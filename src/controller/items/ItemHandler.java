package controller.items;

import controller.PlayerDisplayer;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import model.items.Item;

import java.awt.*;
import java.util.Arrays;
import java.util.stream.Collectors;

import static controller.Main.guiController;
import static controller.PlayerUpdater.currentPlayer;

public class ItemHandler {

    private static Item heldItem;
    private static Point holdPoint;
    private static final Rectangle heldItemRectangle = new Rectangle();

    public static void init() {
        heldItemRectangle.setMouseTransparent(true);
        heldItemRectangle.setVisible(false);
        guiController.getItemsPane().getChildren().add(heldItemRectangle);
        initItemHolding();
    }

    private static void initItemHolding() {
        guiController.getItemsPane().setPickOnBounds(true);
        guiController.getItemsPane().setOnMouseMoved(event -> {
            if (heldItem != null)
                drawHeldItem(new Point((int)event.getX(), (int)event.getY()));
        });
        for (MenuButton button: Arrays.stream(EquipmentSlot.values()).map(EquipmentSlot::getMenuButton).collect(Collectors.toList())) {
            button.setOnMouseMoved(event -> {
                if (heldItem != null)
                    drawHeldItem(new Point((int) (button.getLayoutX() + event.getX()), (int) (button.getLayoutY() + event.getY())));
            });
        }
    }

    public static void handleEquipmentSlotClick(MenuButton button, EquipmentSlot equipmentSlot, Point clickPoint) {
        if (heldItem != null) {
            button.hide();
            if (currentPlayer.getItem(equipmentSlot) != null) {
                changeItem(equipmentSlot, clickPoint);
            } else {
                tryPutOnItem(equipmentSlot);
            }
        } else {
            if (currentPlayer.getItem(equipmentSlot) != null) {
                button.hide();
                tryCatchItem(equipmentSlot, clickPoint);
            }  // else show menu
        }
    }

    public static void tryCatchItem(EquipmentSlot equipmentSlot, Point clickPoint) {
        Item item = currentPlayer.getItem(equipmentSlot);
        Image itemImage = PlayerDisplayer.findImage(item);
        holdPoint = holdPoint(equipmentSlot, itemImage, clickPoint);
        if (holdPoint == null) {
            return;
        }

        catchItem(item, itemImage);
        drawHeldItem(new Point(equipmentSlot.getX() + clickPoint.x, equipmentSlot.getY() + clickPoint.y));

        currentPlayer.trySetItem(null, equipmentSlot);
        PlayerDisplayer.displayItem(null, equipmentSlot);
    }

    private static void catchItem(Item item, Image itemImage) {
        heldItem = item;
        heldItemRectangle.setFill(new ImagePattern(itemImage));
        heldItemRectangle.setWidth(itemImage.getWidth());
        heldItemRectangle.setHeight(itemImage.getHeight());
        heldItemRectangle.setVisible(true);
    }

    public static boolean tryPutOnItem(EquipmentSlot equipmentSlot) {
        if (currentPlayer.trySetItem(heldItem, equipmentSlot)) {
            PlayerDisplayer.displayItem(heldItem, equipmentSlot);
            hideHeldItem();
            return true;
        }
        return false;
    }

    private static void changeItem(EquipmentSlot equipmentSlot, Point clickPoint) {
        Item belowItem = currentPlayer.getItem(equipmentSlot);
        if (tryPutOnItem(equipmentSlot)) {
            Image itemImage = PlayerDisplayer.findImage(belowItem);
            catchItem(belowItem, itemImage);
            holdPoint = new Point((int) itemImage.getWidth() / 2, (int) itemImage.getHeight() / 2);
            drawHeldItem(new Point(equipmentSlot.getX() + clickPoint.x, equipmentSlot.getY() + clickPoint.y));
        }
    }

    private static void drawHeldItem(Point movePoint) {
        heldItemRectangle.setX(movePoint.x - holdPoint.x);
        heldItemRectangle.setY(movePoint.y - holdPoint.y);
    }

    private static void hideHeldItem() {
        heldItem = null;
        holdPoint = null;
        heldItemRectangle.setWidth(0);
        heldItemRectangle.setHeight(0);
        heldItemRectangle.setVisible(false);
    }

    private static Point holdPoint(EquipmentSlot equipmentSlot, Image itemImage, Point clickPoint) {
        MenuButton button = equipmentSlot.getMenuButton();
        int itemMinX = (int) ((button.getWidth() - itemImage.getWidth()) / 2);
        int itemMaxX = (int) ((button.getWidth() + itemImage.getWidth()) / 2);
        int itemMinY = (int) ((button.getHeight() - itemImage.getHeight()) / 2);
        int itemMaxY = (int) ((button.getHeight() + itemImage.getHeight()) / 2);

        if (itemMinX < clickPoint.x && clickPoint.x < itemMaxX && itemMinY < clickPoint.y && clickPoint.y < itemMaxY)
            return new Point(clickPoint.x - itemMinX, clickPoint.y - itemMinY);
        else
            return null;
    }
}
