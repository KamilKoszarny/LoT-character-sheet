package controller;

import controller.items.ItemHandler;
import controller.items.ItemSlot;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.shape.Rectangle;
import model.items.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static controller.PlayerUpdater.currentPlayer;

public class EquipmentGuiInitializer {

    static void initEquipment() {
        for (ItemSlot slot : ItemSlot.values()) {
            initItemMenu(slot.getMenuButton(), slot);
        }
    }

    static void updateTooltips() {
        for (ItemSlot slot : ItemSlot.values()) {
            updateTooltip(null, slot, null);
        }
    }

    private static void initItemMenu(MenuButton button, ItemSlot itemSlot) {
        button.lookup(".arrow-button").setStyle("-fx-padding: 0");
        button.lookup(".arrow").setStyle("-fx-background-insets: 0; -fx-padding: 0; -fx-shape: null;");

        button.setOnMousePressed(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                ItemHandler.handleItemSlotClick(button, itemSlot, new Point((int) event.getX(), (int) event.getY()));
            }
        });

        addNewItemMenus(button, itemSlot);

        if (!itemSlot.equals(ItemSlot.INVENTORY)) {
            button.setContextMenu(createContextMenu(null, itemSlot, null));
        }
    }

    private static void addNewItemMenus(MenuButton button, ItemSlot itemSlot) {
        switch (itemSlot) {
            case WEAPON_1ST_SET:
            case WEAPON_2ND_SET:
                button.getItems().addAll(createWeaponMenu(itemSlot));
                break;
            case SHIELD_1ST_SET:
            case SHIELD_2ND_SET:
                button.getItems().addAll(create2ndHandMenu(itemSlot));
                break;
            case HELMET:
                button.getItems().addAll(createHelmetMenu(itemSlot));
                break;
            case ARMOR:
                button.getItems().addAll(createArmorMenu(itemSlot));
                break;
            case GLOVES:
                button.getItems().addAll(createGlovesMenu(itemSlot));
                break;
            case BOOTS:
                button.getItems().addAll(createBootsMenu(itemSlot));
                break;
            case AMULET:
                button.getItems().addAll(createAmuletMenu(itemSlot));
                break;
            case RING1:
            case RING2:
                button.getItems().addAll(createRingMenu(itemSlot));
                break;
            case BELT:
                button.getItems().addAll(createBeltMenu(itemSlot));
                break;
            case INVENTORY:
                button.getItems().addAll(createInventoryMenu(itemSlot));
                break;
        }
    }

    public static void updateTooltip(Item item, ItemSlot itemSlot, Rectangle rectangle) {
        if (item == null) {
            item = PlayerUpdater.getCurrentPlayer().getItem(itemSlot);
        }
        if (item != null) {
            Tooltip tooltip = new Tooltip(item.getDescription());
            if (itemSlot != null) {
                MenuButton button = itemSlot.getMenuButton();
                button.setTooltip(tooltip);
            } else {
                Tooltip.install(rectangle, tooltip);
            }
        }
    }

    public static ContextMenu createContextMenu(Item item, ItemSlot itemSlot, Rectangle rectangle) {
        final ContextMenu contextMenu = new ContextMenu();
        contextMenu.getItems().add(createDurabilityMenu(item, itemSlot, rectangle));
        contextMenu.getItems().add(new SeparatorMenuItem());
        contextMenu.getItems().add(createSetMagicModifierMenu(item, itemSlot, rectangle));
        contextMenu.getItems().add(new SeparatorMenuItem());
        contextMenu.getItems().add(createDropButton(itemSlot, item));
        return contextMenu;
    }

    public static Menu createDurabilityMenu(Item item, ItemSlot itemSlot, Rectangle rectangle) {
        final boolean isQuantityType = item != null && item.getType().equals(ItemType.AMMUNITION);
        Menu durabilityMenu = new Menu(isQuantityType ? "Ilość" : "Wytrzymałość");
        MenuItem durabilityMinus1 = new MenuItem(isQuantityType ? "odejmij: -1" : "uszkodzenie: -1");
        MenuItem durabilityMinus5 = new MenuItem(isQuantityType ? "odejmij: -5" : "uszkodzenie: -5");
        MenuItem durabilityMax = new MenuItem(isQuantityType ? "uzupełnij: max" : "naprawa: max");
        durabilityMinus1.setOnAction(event -> handleDurabilityMinusClick(item, rectangle, itemSlot, 1));
        durabilityMinus5.setOnAction(event -> handleDurabilityMinusClick(item, rectangle, itemSlot, 5));
        durabilityMax.setOnAction(event -> {
            Item foundItem = findItem(item, itemSlot);
            if (foundItem != null) {
                foundItem.durabilityMax();
                updateTooltip(item, itemSlot, rectangle);
                if (item != null) {
                    ItemsDisplayer.displayInventory();
                } else {
                    ItemsDisplayer.displayEquipmentItem(foundItem, itemSlot);
                }
            }
        });
        durabilityMenu.getItems().addAll(durabilityMinus1, durabilityMinus5, new SeparatorMenuItem(), durabilityMax);
        return durabilityMenu;
    }

    private static void handleDurabilityMinusClick(Item item, Rectangle rectangle, ItemSlot itemSlot, int value) {
        Item foundItem = findItem(item, itemSlot);
        if (foundItem != null) {
            foundItem.durabilityMinus(value);
            updateTooltip(item, itemSlot, rectangle);
            if (foundItem.breakIconShouldBeDisplayed()) {
                if (item != null) {
                    ItemsDisplayer.displayInventory();
                } else {
                    ItemsDisplayer.displayEquipmentItem(foundItem, itemSlot);
                }
            }
        }
    }

    public static Menu createSetMagicModifierMenu(Item item, ItemSlot itemSlot, Rectangle rectangle) {
        Menu addMagicModifierMenu = new Menu("Magiczne właściwości");
        Menu prefixesMenu = new Menu("Przedrostki");
        Menu suffixesMenu = new Menu("Przyrostki");
        prefixesMenu.getItems().add(createRemoveMagicModifierButton(item, itemSlot, rectangle, true));
        suffixesMenu.getItems().add(createRemoveMagicModifierButton(item, itemSlot, rectangle, false));
        for (MagicModifier magicModifier: MagicModifier.values()) {
            if (magicModifier.applicableForType(item, itemSlot)) {
                MenuItem modifierButton = createMagicModifierButton(item, itemSlot, rectangle, magicModifier);
                if (magicModifier.hasPrefix()) {
                    prefixesMenu.getItems().add(modifierButton);
                } else {
                    suffixesMenu.getItems().add(modifierButton);
                }
            }
        }
        addMagicModifierMenu.getItems().add(prefixesMenu);
        addMagicModifierMenu.getItems().add(suffixesMenu);
        return addMagicModifierMenu;
    }

    private static MenuItem createMagicModifierButton(Item item, ItemSlot itemSlot, Rectangle rectangle, MagicModifier magicModifier) {
        MenuItem modifierButton = new MenuItem();
        modifierButton.setText(magicModifier.getText());
        modifierButton.setOnAction(event -> handleMagicModifierButtonClick(item, itemSlot, rectangle, magicModifier, null));
        return modifierButton;
    }

    private static MenuItem createRemoveMagicModifierButton(Item item, ItemSlot itemSlot, Rectangle rectangle, boolean hasPrefix) {
        MenuItem modifierButton = new MenuItem();
        modifierButton.setText("Brak");
        modifierButton.setOnAction(event -> handleMagicModifierButtonClick(item, itemSlot, rectangle, null, hasPrefix));
        return modifierButton;
    }

    private static void handleMagicModifierButtonClick(Item item, ItemSlot itemSlot, Rectangle rectangle, MagicModifier magicModifier, Boolean hasPrefix) {
        Item foundItem = findItem(item, itemSlot);
        if (foundItem != null) {
            if (magicModifier != null) {
                foundItem.setMagicModifier(magicModifier);
            } else {
                foundItem.removeMagicModifier(hasPrefix);
            }
            PlayerUpdater.updateAll();
            if (item == null) {
                ItemsDisplayer.displayEquipmentItem(foundItem, itemSlot);
            } else {
                ItemsDisplayer.displayInventory();
            }
            updateTooltip(item, itemSlot, rectangle);
        }
    }

    private static Item findItem(Item item, ItemSlot itemSlot) {
        Item foundItem;
        if (item == null) {
            foundItem = currentPlayer.getItem(itemSlot);
        } else {
            foundItem = item;
        }
        return foundItem;
    }

    public static MenuItem createDropButton(ItemSlot itemSlot, Item item) {
        MenuItem dropButton = new MenuItem();
        dropButton.setText("Wyrzuć");
        if (itemSlot != null) {
            dropButton.setOnAction(event -> PlayerUpdater.getCurrentPlayer().trySetItem(null, itemSlot));
        } else {
            dropButton.setOnAction(event -> {
                currentPlayer.removeFromInventory(item);
                ItemsDisplayer.removeInventoryItem(item);
            });
        }
        return dropButton;
    }

    private static List<MenuItem> createWeaponMenu(ItemSlot itemSlot) {
        List<MenuItem> weaponMenuItems = new ArrayList<>();
        for (WeaponType weaponType : WeaponType.values()) {
            Menu menu = new Menu();
            menu.setText(weaponType.getNamePL());
            for (WeaponModel weaponModel : WeaponModel.values()) {
                if (weaponModel.getType().equals(weaponType)) {
                    MenuItem menuItem = new MenuItem();
                    menuItem.setText(weaponModel.getNamePL());
                    menuItem.setOnAction(event -> {
                        Weapon weapon = new Weapon(weaponModel);
                        PlayerUpdater.getCurrentPlayer().trySetItem(weapon, itemSlot);
                    });
                    menu.getItems().add(menuItem);
                }
            }
            weaponMenuItems.add(menu);
        }
        return weaponMenuItems;
    }

    private static List<MenuItem> create2ndHandMenu(ItemSlot itemSlot) {
        List<MenuItem> secondHandMenuItems = new ArrayList<>();
        Menu weaponMenu = new Menu();
        weaponMenu.setText(ItemType.WEAPON.getNamePL());
        weaponMenu.getItems().addAll(createWeaponMenu(itemSlot));
        secondHandMenuItems.add(weaponMenu);

        Menu shieldMenu = new Menu();
        shieldMenu.setText(ItemType.SHIELD.getNamePL());
        shieldMenu.getItems().addAll(createShieldMenu(itemSlot));
        secondHandMenuItems.add(shieldMenu);

        Menu ammunitionMenu = new Menu();
        ammunitionMenu.setText(ItemType.AMMUNITION.getNamePL());
        ammunitionMenu.getItems().addAll(createAmmunitionMenu(itemSlot));
        secondHandMenuItems.add(ammunitionMenu);

        return secondHandMenuItems;
    }

    private static List<MenuItem> createShieldMenu(ItemSlot itemSlot) {
        List<MenuItem> shieldMenuItems = new ArrayList<>();
        for (ShieldModel shieldModel : ShieldModel.values()) {
            MenuItem menuItem = new MenuItem();
            menuItem.setText(shieldModel.getNamePL());
            menuItem.setOnAction(event -> {
                Shield shield = new Shield(shieldModel);
                PlayerUpdater.getCurrentPlayer().trySetItem(shield, itemSlot);
            });
            shieldMenuItems.add(menuItem);
        }
        return shieldMenuItems;
    }

    private static List<MenuItem> createHelmetMenu(ItemSlot itemSlot) {
        List<MenuItem> helmetMenuItems = new ArrayList<>();
        for (HelmetModel helmetModel : HelmetModel.values()) {
            MenuItem menuItem = new MenuItem();
            menuItem.setText(helmetModel.getNamePL());
            menuItem.setOnAction(event -> {
                Helmet helmet = new Helmet(helmetModel);
                PlayerUpdater.getCurrentPlayer().trySetItem(helmet, itemSlot);
            });
            helmetMenuItems.add(menuItem);
        }
        return helmetMenuItems;
    }

    private static List<MenuItem> createArmorMenu(ItemSlot itemSlot) {
        List<MenuItem> armorMenuItems = new ArrayList<>();
        for (ArmorModel armorModel : ArmorModel.values()) {
            MenuItem menuItem = new MenuItem();
            menuItem.setText(armorModel.getNamePL());
            menuItem.setOnAction(event -> {
                Armor armor = new Armor(armorModel);
                PlayerUpdater.getCurrentPlayer().trySetItem(armor, itemSlot);
            });
            armorMenuItems.add(menuItem);
        }
        return armorMenuItems;
    }

    private static List<MenuItem> createGlovesMenu(ItemSlot itemSlot) {
        List<MenuItem> glovesMenuItems = new ArrayList<>();
        for (GlovesModel glovesModel : GlovesModel.values()) {
            MenuItem menuItem = new MenuItem();
            menuItem.setText(glovesModel.getNamePL());
            menuItem.setOnAction(event -> {
                Gloves gloves = new Gloves(glovesModel);
                PlayerUpdater.getCurrentPlayer().trySetItem(gloves, itemSlot);
            });
            glovesMenuItems.add(menuItem);
        }
        return glovesMenuItems;
    }

    private static List<MenuItem> createBootsMenu(ItemSlot itemSlot) {
        List<MenuItem> bootsMenuItems = new ArrayList<>();
        for (BootsModel bootsModel : BootsModel.values()) {
            MenuItem menuItem = new MenuItem();
            menuItem.setText(bootsModel.getNamePL());
            menuItem.setOnAction(event -> {
                Boots boots = new Boots(bootsModel);
                PlayerUpdater.getCurrentPlayer().trySetItem(boots, itemSlot);
            });
            bootsMenuItems.add(menuItem);
        }
        return bootsMenuItems;
    }

    private static List<MenuItem> createAmuletMenu(ItemSlot itemSlot) {
        List<MenuItem> amuletMenuItems = new ArrayList<>();
        for (AmuletModel amuletModel : AmuletModel.values()) {
            MenuItem menuItem = new MenuItem();
            menuItem.setText(amuletModel.getNamePL());
            menuItem.setOnAction(event -> {
                Amulet amulet = new Amulet(amuletModel);
                PlayerUpdater.getCurrentPlayer().trySetItem(amulet, itemSlot);
            });
            amuletMenuItems.add(menuItem);
        }
        return amuletMenuItems;
    }

    private static List<MenuItem> createRingMenu(ItemSlot itemSlot) {
        List<MenuItem> ringMenuItems = new ArrayList<>();
        for (RingModel ringModel : RingModel.values()) {
            MenuItem menuItem = new MenuItem();
            menuItem.setText(ringModel.getNamePL());
            menuItem.setOnAction(event -> {
                Ring ring = new Ring(ringModel);
                PlayerUpdater.getCurrentPlayer().trySetItem(ring, itemSlot);
            });
            ringMenuItems.add(menuItem);
        }
        return ringMenuItems;
    }

    private static List<MenuItem> createBeltMenu(ItemSlot itemSlot) {
        List<MenuItem> beltMenuItems = new ArrayList<>();
        for (BeltModel beltModel : BeltModel.values()) {
            MenuItem menuItem = new MenuItem();
            menuItem.setText(beltModel.getNamePL());
            menuItem.setOnAction(event -> {
                Belt belt = new Belt(beltModel);
                PlayerUpdater.getCurrentPlayer().trySetItem(belt, itemSlot);
            });
            beltMenuItems.add(menuItem);
        }
        return beltMenuItems;
    }

    private static List<MenuItem> createAmmunitionMenu(ItemSlot itemSlot) {
        List<MenuItem> ammunitionMenuItems = new ArrayList<>();
        for (AmmunitionModel ammunitionModel : AmmunitionModel.values()) {
            MenuItem menuItem = new MenuItem();
            menuItem.setText(ammunitionModel.getNamePL());
            menuItem.setOnAction(event -> {
                Ammunition ammunition = new Ammunition(ammunitionModel);
                PlayerUpdater.getCurrentPlayer().trySetItem(ammunition, itemSlot);
            });
            ammunitionMenuItems.add(menuItem);
        }
        return ammunitionMenuItems;
    }

    private static List<MenuItem> createInventoryMenu(ItemSlot itemSlot) {
        List<MenuItem> inventoryMenuItems = new ArrayList<>();
        for (ItemType itemType : ItemType.values()) {
            Menu menu = new Menu();
            menu.setText(itemType.getNamePL());
            switch (itemType) {
                case WEAPON:
                    menu.getItems().addAll(createWeaponMenu(itemSlot));
                    break;
                case SHIELD:
                    menu.getItems().addAll(createShieldMenu(itemSlot));
                    break;
                case HELMET:
                    menu.getItems().addAll(createHelmetMenu(itemSlot));
                    break;
                case ARMOR:
                    menu.getItems().addAll(createArmorMenu(itemSlot));
                    break;
                case GLOVES:
                    menu.getItems().addAll(createGlovesMenu(itemSlot));
                    break;
                case BOOTS:
                    menu.getItems().addAll(createBootsMenu(itemSlot));
                    break;
                case AMULET:
                    menu.getItems().addAll(createAmuletMenu(itemSlot));
                    break;
                case RING:
                    menu.getItems().addAll(createRingMenu(itemSlot));
                    break;
                case BELT:
                    menu.getItems().addAll(createBeltMenu(itemSlot));
                    break;
                case AMMUNITION:
                    menu.getItems().addAll(createAmmunitionMenu(itemSlot));
                    break;
            }
            inventoryMenuItems.add(menu);
        }
        return inventoryMenuItems;
    }
}
