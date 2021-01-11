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

    public static final int ITEM_SLOT_SIZE = 30;
    public static final int INVENTORY_SLOTS_X = 5;
    public static final int INVENTORY_SLOTS_Y = 10;


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
        for (MenuButton button: Arrays.stream(ItemSlot.values()).map(ItemSlot::getMenuButton).collect(Collectors.toList())) {
            button.setOnMouseMoved(event -> {
                if (heldItem != null)
                    drawHeldItem(new Point((int) (button.getLayoutX() + event.getX()), (int) (button.getLayoutY() + event.getY())));
            });
        }
    }

    public static void handleItemSlotClick(MenuButton button, ItemSlot itemSlot, Point clickPoint) {
        if (heldItem != null) {
            button.hide();
            if (currentPlayer.getItem(itemSlot) != null) {
                changeItem(itemSlot, clickPoint);
            } else {
                tryPutItem(itemSlot, clickPoint);
            }
        } else {
            if (currentPlayer.getItem(itemSlot) != null) {
                button.hide();
                tryCatchItem(itemSlot, clickPoint);
            }  // else show menu
        }
    }

    public static void tryCatchItem(ItemSlot itemSlot, Point clickPoint) {
        Item item = currentPlayer.getItem(itemSlot);
        Image itemImage = PlayerDisplayer.findImage(item);
        holdPoint = holdPoint(itemSlot, itemImage, clickPoint);
        if (holdPoint == null) {
            return;
        }

        catchItem(item, itemImage);
        drawHeldItem(new Point(itemSlot.getX() + clickPoint.x, itemSlot.getY() + clickPoint.y));

        currentPlayer.trySetItem(null, itemSlot);
        PlayerDisplayer.displayEquipmentItem(null, itemSlot);
    }

    private static void catchItem(Item item, Image itemImage) {
        heldItem = item;
        heldItemRectangle.setFill(new ImagePattern(itemImage));
        heldItemRectangle.setWidth(itemImage.getWidth());
        heldItemRectangle.setHeight(itemImage.getHeight());
        heldItemRectangle.setVisible(true);
    }

    public static boolean tryPutItem(ItemSlot itemSlot, Point clickPoint) {
        if (currentPlayer.trySetItem(heldItem, itemSlot)) {
            PlayerDisplayer.displayEquipmentItem(heldItem, itemSlot);
            hideHeldItem();
            return true;
        } else if (itemSlot.equals(ItemSlot.INVENTORY)) {
            Point inventorySlot = calcInventorySlot(clickPoint);
            if (itemFitsInInventory(inventorySlot)) {
                currentPlayer.addToInventory(heldItem, inventorySlot);
                hideHeldItem();
                PlayerDisplayer.displayInventory();
            }
        }
        return false;
    }

    private static void changeItem(ItemSlot itemSlot, Point clickPoint) {
        Item belowItem = currentPlayer.getItem(itemSlot);
        if (tryPutItem(itemSlot, clickPoint)) {
            Image itemImage = PlayerDisplayer.findImage(belowItem);
            catchItem(belowItem, itemImage);
            holdPoint = new Point((int) itemImage.getWidth() / 2, (int) itemImage.getHeight() / 2);
            drawHeldItem(new Point(itemSlot.getX() + clickPoint.x, itemSlot.getY() + clickPoint.y));
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

    private static Point holdPoint(ItemSlot itemSlot, Image itemImage, Point clickPoint) {
        MenuButton button = itemSlot.getMenuButton();
        int itemMinX = (int) ((button.getWidth() - itemImage.getWidth()) / 2);
        int itemMaxX = (int) ((button.getWidth() + itemImage.getWidth()) / 2);
        int itemMinY = (int) ((button.getHeight() - itemImage.getHeight()) / 2);
        int itemMaxY = (int) ((button.getHeight() + itemImage.getHeight()) / 2);

        if (itemMinX < clickPoint.x && clickPoint.x < itemMaxX && itemMinY < clickPoint.y && clickPoint.y < itemMaxY)
            return new Point(clickPoint.x - itemMinX, clickPoint.y - itemMinY);
        else
            return null;
    }

    private static Point calcInventorySlot(Point clickPoint) {
        double itemUpLeftCornerX = Math.max(0, clickPoint.x - holdPoint.x);
        double itemUpLeftCornerY = Math.max(0, clickPoint.y - holdPoint.y);
        int inventorySlotX = (int) Math.round(itemUpLeftCornerX / ITEM_SLOT_SIZE);
        int inventorySlotY = (int) Math.round(itemUpLeftCornerY / ITEM_SLOT_SIZE);
        System.out.println("itemUpLeftCornerX: " + itemUpLeftCornerX);
        System.out.println("itemUpLeftCornerY: " + itemUpLeftCornerY);
        System.out.println("inventorySlotX: " + inventorySlotX);
        System.out.println("inventorySlotY: " + inventorySlotY);
        return new Point(inventorySlotX, inventorySlotY);
    }

    private static boolean itemFitsInInventory(Point slot) {
        Image itemImage = PlayerDisplayer.findImage(heldItem);
        int heldItemSizeX = (int) Math.round(itemImage.getWidth()/ITEM_SLOT_SIZE);
        int heldItemSizeY = (int) Math.round(itemImage.getHeight()/ITEM_SLOT_SIZE);
        //todo
        return true;
    }
}
