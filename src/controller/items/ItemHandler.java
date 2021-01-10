package controller.items;

import controller.PlayerDisplayer;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import model.items.Item;

import java.awt.*;

import static controller.Main.guiController;
import static controller.PlayerUpdater.currentPlayer;

public class ItemHandler {

    private static Item heldItem;
    private static Point holdPoint;
    private static final Rectangle heldItemRectangle = new Rectangle();

    public static void init() {
        initItemHolding();
    }

    private static void initItemHolding() {
        heldItemRectangle.setVisible(false);
        guiController.getItemsPane().getChildren().add(heldItemRectangle);
        guiController.getItemsPane().setOnMouseMoved(event -> {
            if (heldItem != null)
                drawHeldItem(new Point((int)event.getX(), (int)event.getY()));
            else
                heldItemRectangle.setVisible(false);
        });
    }

    public static void tryCatchItem(EquipmentSlot equipmentSlot, Point clickPoint) {
        Item item = currentPlayer.getItem(equipmentSlot);
        Image itemImage = PlayerDisplayer.findImage(item);
        holdPoint = holdPoint(equipmentSlot, itemImage, clickPoint);
        if (holdPoint == null) {
            return;
        }

        heldItem = item;
        heldItemRectangle.setFill(new ImagePattern(itemImage));
        heldItemRectangle.setWidth(itemImage.getWidth());
        heldItemRectangle.setHeight(itemImage.getHeight());
        heldItemRectangle.setVisible(true);
        drawHeldItem(new Point(equipmentSlot.getX() + clickPoint.x, equipmentSlot.getY() + clickPoint.y));

        currentPlayer.setItem(null, equipmentSlot);
        PlayerDisplayer.displayItem(null, equipmentSlot);
    }

    private static void drawHeldItem(Point movePoint) {
        heldItemRectangle.setX(movePoint.x - holdPoint.x);
        heldItemRectangle.setY(movePoint.y - holdPoint.y);
    }

    private static Point holdPoint(EquipmentSlot equipmentSlot, Image itemImage, Point clickPoint) {
        MenuButton button = PlayerDisplayer.findEquipmentButton(equipmentSlot);
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
