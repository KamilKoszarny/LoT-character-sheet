package controller;

import controller.items.ItemHandler;
import controller.items.ItemSlot;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import model.items.Item;
import model.items.Shield;
import model.items.Weapon;
import utils.GraphicUtils;
import utils.Utils;

import java.awt.*;

public class ItemsDisplayer {
    public static void displayEquipment() {
        displayEquipmentItem(PlayerUpdater.currentPlayer.getWeapon1stSet(), ItemSlot.WEAPON_1ST_SET);
        displayEquipmentItem(PlayerUpdater.currentPlayer.getWeapon2ndSet(), ItemSlot.WEAPON_2ND_SET);
        if (PlayerUpdater.currentPlayer.getShield1stSet() != null) {
            displayEquipmentItem(PlayerUpdater.currentPlayer.getShield1stSet(), ItemSlot.SHIELD_1ST_SET);
        }
        if (PlayerUpdater.currentPlayer.getShield2ndSet() != null) {
            displayEquipmentItem(PlayerUpdater.currentPlayer.getShield2ndSet(), ItemSlot.SHIELD_2ND_SET);
        }
        if (PlayerUpdater.currentPlayer.getAmmunition1stSet() != null) {
            displayEquipmentItem(PlayerUpdater.currentPlayer.getAmmunition1stSet(), ItemSlot.SHIELD_1ST_SET);
        }
        if (PlayerUpdater.currentPlayer.getAmmunition2ndSet() != null) {
            displayEquipmentItem(PlayerUpdater.currentPlayer.getAmmunition2ndSet(), ItemSlot.SHIELD_2ND_SET);
        }
        displayEquipmentItem(PlayerUpdater.currentPlayer.getHelmet(), ItemSlot.HELMET);
        displayEquipmentItem(PlayerUpdater.currentPlayer.getArmor(), ItemSlot.ARMOR);
        displayEquipmentItem(PlayerUpdater.currentPlayer.getGloves(), ItemSlot.GLOVES);
        displayEquipmentItem(PlayerUpdater.currentPlayer.getBoots(), ItemSlot.BOOTS);
        displayEquipmentItem(PlayerUpdater.currentPlayer.getAmulet(), ItemSlot.AMULET);
        displayEquipmentItem(PlayerUpdater.currentPlayer.getRing1(), ItemSlot.RING1);
        displayEquipmentItem(PlayerUpdater.currentPlayer.getRing2(), ItemSlot.RING2);
        displayEquipmentItem(PlayerUpdater.currentPlayer.getBelt(), ItemSlot.BELT);
    }

    public static void displayEquipmentItem(Item item, ItemSlot itemSlot) {
        displayEquipmentItem(item, itemSlot, 1);
        if (itemSlot.equals(ItemSlot.WEAPON_1ST_SET)) {
            displaySecondHand(item, true);
        } else if (itemSlot.equals(ItemSlot.WEAPON_2ND_SET)) {
            displaySecondHand(item, false);
        }
    }

    private static void displaySecondHand(Item item, boolean firstSet) {
        Weapon weapon = firstSet ? PlayerUpdater.currentPlayer.getWeapon1stSet() : PlayerUpdater.currentPlayer.getWeapon2ndSet();
        Shield shield = firstSet ? PlayerUpdater.currentPlayer.getShield1stSet() : PlayerUpdater.currentPlayer.getShield2ndSet();
        Weapon weapon2ndHand = firstSet ? PlayerUpdater.currentPlayer.getWeapon1stSet2ndHand() : PlayerUpdater.currentPlayer.getWeapon2ndSet2ndHand();
        ItemSlot shieldSlot = firstSet ? ItemSlot.SHIELD_1ST_SET : ItemSlot.SHIELD_2ND_SET;

        if (item == null) {
            if (shield == null && weapon2ndHand == null) {
                displayEquipmentItem(null, shieldSlot);
            }
        } else if (weapon.getModel().isTwoHanded()) {
            displayEquipmentItem(weapon, shieldSlot, 0.6);
        } else if (shield == null && weapon2ndHand == null) {
            displayEquipmentItem(null, shieldSlot);
        }
    }

    private static void displayEquipmentItem(Item item, ItemSlot itemSlot, double opacity) {
        MenuButton button = itemSlot.getMenuButton();
        if (item == null) {
            button.setOpacity(0);
        } else {
            Image img = prepareImage(item);
            ImageView view = new ImageView(img);
            if (item.isMagic()) {
                GraphicUtils.addMagicColor(view, item.getColor());
            }
            button.setGraphic(view);
            button.setOpacity(opacity);
        }
    }

    public static void displayInventory() {
        for (Item item : PlayerUpdater.currentPlayer.getInventory().keySet()) {
            displayInventoryItem(item, PlayerUpdater.currentPlayer.getInventory().get(item));
        }
        changeInventoryItemsMouseTransparency(ItemHandler.isItemHeld());
    }

    private static void displayInventoryItem(Item item, Point slot) {
        final MenuButton invButton = Main.guiController.getInventory();
        Image itemImage = prepareImage(item);
        Rectangle rectangle = new Rectangle(
                invButton.getLayoutX() + slot.x * ItemHandler.ITEM_SLOT_SIZE,
                invButton.getLayoutY() + slot.y * ItemHandler.ITEM_SLOT_SIZE,
                itemImage.getWidth(), itemImage.getHeight());
        rectangle.setId(Integer.toString(item.hashCode()));
        rectangle.setFill(new ImagePattern(itemImage));
        if (item.isMagic()) {
            GraphicUtils.addMagicColor(rectangle, item.getColor());
        }

        ItemHandler.initInventoryItemClick(item, rectangle);
        EquipmentGuiInitializer.updateTooltip(item, null, rectangle);

        Main.guiController.getItemsPane().getChildren().add(rectangle);
    }

    public static void removeInventoryItem(Item item) {
        Main.guiController.getItemsPane().getChildren()
                .removeIf(node -> node.getId() != null
                        && node.getId().equals(Integer.toString(item.hashCode())));
    }

    public static void changeInventoryItemsMouseTransparency(boolean transparent) {
        Main.guiController.getItemsPane().getChildren().forEach(node -> {
            if (Utils.isInteger(node.getId())) {
                node.setMouseTransparent(transparent);
            }
        });
    }

    public static Image prepareImage(Item item) {
        String path = "images/items/" + item.getType().name().toLowerCase() + "/" + item.getModel().name() + ".png";
        Image image = new Image(path);
        image = GraphicUtils.addBrokenIcon(image, item.getDurabilityOrQuantity() / (double)item.getDurabilityOrQuantityMax());
        return image;
    }
}
