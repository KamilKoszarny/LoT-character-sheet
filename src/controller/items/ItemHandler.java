package controller.items;

import controller.PlayerDisplayer;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import model.items.Item;
import model.items.MagicModifier;
import model.items.Modifier;

import java.awt.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static controller.Main.guiController;
import static controller.PlayerUpdater.currentPlayer;

public class ItemHandler {

    public static final int ITEM_SLOT_SIZE = 30;
    public static final int INVENTORY_SLOTS_X = 10;
    public static final int INVENTORY_SLOTS_Y = 5;


    private static Item heldItem;
    private static Point holdPoint;
    private static final Rectangle heldItemRectangle = new Rectangle();

    public static void init() {
        heldItemRectangle.setMouseTransparent(true);
        heldItemRectangle.setVisible(false);
        heldItemRectangle.toFront();
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
        heldItemRectangle.toFront();
        heldItemRectangle.setVisible(true);
        PlayerDisplayer.changeInventoryItemsMouseTransparency(true);
    }

    public static boolean tryPutItem(ItemSlot itemSlot, Point clickPoint) {
        if (!itemSlot.equals(ItemSlot.INVENTORY) && currentPlayer.trySetItem(heldItem, itemSlot)) {
            PlayerDisplayer.displayEquipmentItem(heldItem, itemSlot);
            hideHeldItem();
            return true;
        } else if (itemSlot.equals(ItemSlot.INVENTORY)) {
            Point inventorySlot = calcInventorySlot(clickPoint);
            if (itemOutOfInventory(heldItem, inventorySlot)) {
                return false;
            }
            Set<Item> itemsUnderneath = itemsUnderneath(heldItem, inventorySlot);
            if (itemsUnderneath.size() == 0) {
                currentPlayer.addToInventory(heldItem, inventorySlot);
                hideHeldItem();
                PlayerDisplayer.displayInventory();
                return true;
            } else if (itemsUnderneath.size() == 1) {
                Item underneathItem = itemsUnderneath.iterator().next();
                Image itemImage = PlayerDisplayer.findImage(underneathItem);
                currentPlayer.addToInventory(heldItem, inventorySlot);
                holdPoint = new Point((int) itemImage.getWidth() / 2, (int) itemImage.getHeight() / 2);
                catchItem(underneathItem, itemImage);
                currentPlayer.removeFromInventory(underneathItem);
                PlayerDisplayer.removeInventoryItem(underneathItem);
                PlayerDisplayer.displayInventory();
                heldItemRectangle.toFront();
                return true;
            }
        }
        return false;
    }

    private static void changeItem(ItemSlot itemSlot, Point clickPoint) {
        Item underneathItem = currentPlayer.getItem(itemSlot);
        if (tryPutItem(itemSlot, clickPoint)) {
            Image itemImage = PlayerDisplayer.findImage(underneathItem);
            holdPoint = new Point((int) itemImage.getWidth() / 2, (int) itemImage.getHeight() / 2);
            catchItem(underneathItem, itemImage);
            drawHeldItem(new Point(itemSlot.getX() + clickPoint.x, itemSlot.getY() + clickPoint.y));
        }
    }

    private static void drawHeldItem(Point movePoint) {
        heldItemRectangle.setX(movePoint.x - holdPoint.x);
        heldItemRectangle.setY(movePoint.y - holdPoint.y);
        heldItemRectangle.toFront();
    }

    private static void hideHeldItem() {
        heldItem = null;
        holdPoint = null;
        heldItemRectangle.setWidth(0);
        heldItemRectangle.setHeight(0);
        heldItemRectangle.setVisible(false);
        PlayerDisplayer.changeInventoryItemsMouseTransparency(false);
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
        return new Point(inventorySlotX, inventorySlotY);
    }

    private static boolean itemOutOfInventory(Item item, Point slot) {
        Set<Point> heldItemSlots = itemSlots(item, slot);
        return heldItemSlots.stream().anyMatch(point -> point.x >= INVENTORY_SLOTS_X || point.y >= INVENTORY_SLOTS_Y);
    }

    private static Set<Item> itemsUnderneath(Item item, Point slot) {
        Set<Item> itemsUnderneath = new HashSet<>();
        Set<Point> heldItemSlots = itemSlots(item, slot);
        for (Item invItem: currentPlayer.getInventory().keySet()) {
            Point invItemSlot = currentPlayer.getInventory().get(invItem);
            Set<Point> invItemSlots = itemSlots(invItem, invItemSlot);
            if (!Collections.disjoint(heldItemSlots, invItemSlots)) {
                itemsUnderneath.add(invItem);
            }
        }
        return itemsUnderneath;
    }

    private static Set<Point> itemSlots(Item item, Point slot) {
        Image itemImage = PlayerDisplayer.findImage(item);
        int itemSizeX = (int) Math.round(itemImage.getWidth() / ITEM_SLOT_SIZE);
        int itemSizeY = (int) Math.round(itemImage.getHeight() / ITEM_SLOT_SIZE);
        Set<Point> itemSlots = new HashSet<>();
        for (int x = slot.x; x < slot.x + itemSizeX; x++) {
            for (int y = slot.y; y < slot.y + itemSizeY; y++) {
                itemSlots.add(new Point(x, y));
            }
        }
        return itemSlots;
    }

    public static boolean isItemHeld() {
        return heldItem != null;
    }

    public static void initInventoryItemClick(Item item, Rectangle rectangle) {
        ContextMenu invItemContextMenu = invItemContextMenu(item);
        rectangle.setOnMousePressed(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                Image itemImage = PlayerDisplayer.findImage(item);
                holdPoint = new Point((int) itemImage.getWidth() / 2, (int) itemImage.getHeight() / 2);
                catchItem(item, itemImage);
                drawHeldItem(new Point((int) (rectangle.getLayoutX() + event.getX()), (int) (rectangle.getLayoutY() + event.getY())));
                currentPlayer.removeFromInventory(item);
                PlayerDisplayer.removeInventoryItem(item);
                PlayerDisplayer.displayInventory();
            } else {
                invItemContextMenu.show(rectangle, event.getScreenX(), event.getScreenY());
            }
        });
    }

    private static ContextMenu invItemContextMenu(Item item) {
        final ContextMenu contextMenu = new ContextMenu();
        contextMenu.getItems().add(createInvItemDropButton(item));
        contextMenu.getItems().add(createAddMagicModifierButton(item));
        return contextMenu;
    }

    private static javafx.scene.control.MenuItem createInvItemDropButton(Item item) {
        javafx.scene.control.MenuItem dropButton = new MenuItem();
        dropButton.setText("Wyrzuć");
        dropButton.setOnAction(event -> {
            currentPlayer.removeFromInventory(item);
            PlayerDisplayer.removeInventoryItem(item);
        });
        return dropButton;
    }

    private static MenuItem createAddMagicModifierButton(Item item) {
        javafx.scene.control.Menu addMagicModifierButton = new Menu();
        addMagicModifierButton.setText("Dodaj magiczną właściwość");
        for (MagicModifier magicModifier: MagicModifier.values()) {
            MenuItem modifierButton = new MenuItem();
            modifierButton.setText(magicModifier.getText());
            modifierButton.setOnAction(event -> {
                item.getModifiers().add(new Modifier(magicModifier));
            });
            addMagicModifierButton.getItems().add(modifierButton);
        }
        return addMagicModifierButton;
    }

    public static void tryPutNewItemInInventory(Item item) {
        for (int x = 0; x < INVENTORY_SLOTS_X; x++) {
            for (int y = 0; y < INVENTORY_SLOTS_Y; y++) {
                Point slot = new Point(x, y);
                if (!itemOutOfInventory(item, slot) && itemsUnderneath(item, slot).size() == 0) {
                    currentPlayer.addToInventory(item, slot);
                    PlayerDisplayer.displayInventory();
                    return;
                }
            }
        }
    }
}
