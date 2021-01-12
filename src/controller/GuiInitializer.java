package controller;

import controller.items.ItemHandler;
import controller.items.ItemSlot;
import javafx.collections.ObservableList;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import model.*;
import model.items.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static controller.Main.guiController;

public class GuiInitializer {


    public static void init() {
        initProffesions();
        initRaces();
        initSigns();
        initSkills();
        initTraits();
        initEquipment();
    }

    private static void initProffesions() {
        guiController.getProffesion().getItems().addAll(Proffesion.values());
    }

    private static void initRaces() {
        guiController.getRace().getItems().addAll(Race.values());
    }

    private static void initSigns() {
        guiController.getSign().getItems().addAll(Sign.values());
    }

    private static void initSkills() {
        fillSkillsChoiceBox(guiController.getSkill1().getItems());
        fillSkillsChoiceBox(guiController.getSkill2().getItems());
        fillSkillsChoiceBox(guiController.getSkill3().getItems());
        fillSkillsChoiceBox(guiController.getSkill4().getItems());
        fillSkillsChoiceBox(guiController.getSkill5().getItems());
        fillSkillsChoiceBox(guiController.getSkill6().getItems());
    }

    private static void fillSkillsChoiceBox(ObservableList<Object> items) {
        items.addAll(SkillType.values());
        items.add(10, new Separator());
        items.add(21, new Separator());
    }

    private static void initTraits() {
        guiController.getTraitPositive().getItems().addAll(
                Arrays.stream(Trait.values())
                        .filter(trait -> trait.getType().equals(TraitType.POSITIVE))
                        .collect(Collectors.toList()));
        guiController.getTraitNeutral().getItems().addAll(
                Arrays.stream(Trait.values())
                        .filter(trait -> trait.getType().equals(TraitType.NEUTRAL))
                        .collect(Collectors.toList()));
        guiController.getTraitNegative().getItems().addAll(
                Arrays.stream(Trait.values())
                        .filter(trait -> trait.getType().equals(TraitType.NEGATIVE))
                        .collect(Collectors.toList()));
    }

    private static void initEquipment() {
        for (ItemSlot slot: ItemSlot.values()) {
            initItemMenu(slot.getMenuButton(), slot);
        }
    }

    private static void initItemMenu(MenuButton button, ItemSlot itemSlot) {
        button.lookup(".arrow-button" ).setStyle( "-fx-padding: 0" );
        button.lookup(".arrow" ).setStyle( "-fx-background-insets: 0; -fx-padding: 0; -fx-shape: null;" );

        button.setOnMousePressed(event
                -> ItemHandler.handleItemSlotClick(button, itemSlot, new Point((int)event.getX(), (int)event.getY())));

        switch (itemSlot) {
            case WEAPON_A:
            case WEAPON_B:
                button.getItems().addAll(createWeaponMenu(itemSlot));
                break;
            case SHIELD_A:
            case SHIELD_B:
                button.getItems().addAll(createShieldMenu(itemSlot));
                break;
            case HELMET:
                button.getItems().addAll(createHelmetMenu(itemSlot));
                break;
            case INVENTORY:
                button.getItems().addAll(createInventoryMenu(itemSlot));
                break;
        }
    }

    private static List<MenuItem> createWeaponMenu(ItemSlot itemSlot) {
        List<MenuItem> weaponMenuItems = new ArrayList<>();
        for (WeaponType weaponType: WeaponType.values()) {
            Menu menu = new Menu();
            menu.setText(weaponType.getNamePL());
            for (WeaponModel weaponModel: WeaponModel.values()) {
                if (weaponModel.getType().equals(weaponType)) {
                    MenuItem menuItem = new MenuItem();
                    menuItem.setText(weaponModel.getNamePL());
                    menuItem.setOnAction(event -> {
                        Weapon weapon = new Weapon(weaponModel);
                        PlayerUpdater.getCurrentPlayer().trySetItem(weapon, itemSlot);
                        PlayerUpdater.updateDmg(itemSlot.equals(ItemSlot.WEAPON_A));
                        PlayerUpdater.updateHits(itemSlot.equals(ItemSlot.WEAPON_A));
                        PlayerDisplayer.displayEquipmentItem(weapon, itemSlot);
                    });
                    menu.getItems().add(menuItem);
                }
            }
            weaponMenuItems.add(menu);
        }
        return weaponMenuItems;
    }

    private static List<MenuItem> createShieldMenu(ItemSlot itemSlot) {
        List<MenuItem> shieldMenuItems = new ArrayList<>();
        for (ShieldModel shieldModel: ShieldModel.values()) {
            MenuItem menuItem = new MenuItem();
            menuItem.setText(shieldModel.getNamePL());
            menuItem.setOnAction(event -> {
                Shield shield = new Shield(shieldModel);
                PlayerUpdater.getCurrentPlayer().trySetItem(shield, itemSlot);
                PlayerUpdater.updateBlock(itemSlot.equals(ItemSlot.SHIELD_A));
                PlayerDisplayer.displayEquipmentItem(shield, itemSlot);
            });
            shieldMenuItems.add(menuItem);
        }
        return shieldMenuItems;
    }

    private static List<MenuItem> createHelmetMenu(ItemSlot itemSlot) {
        List<MenuItem> helmetMenuItems = new ArrayList<>();
        for (HelmetModel helmetModel: HelmetModel.values()) {
            MenuItem menuItem = new MenuItem();
            menuItem.setText(helmetModel.getNamePL());
            menuItem.setOnAction(event -> {
                Helmet helmet = new Helmet(helmetModel);
                PlayerUpdater.getCurrentPlayer().trySetItem(helmet, itemSlot);
                PlayerUpdater.updateArmor();
                PlayerDisplayer.displayEquipmentItem(helmet, itemSlot);
            });
            helmetMenuItems.add(menuItem);
        }
        return helmetMenuItems;
    }

    private static List<MenuItem> createInventoryMenu(ItemSlot itemSlot) {
        List<MenuItem> inventoryMenuItems = new ArrayList<>();
        for (ItemType itemType: ItemType.values()) {
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
            }
            inventoryMenuItems.add(menu);
        }
        return inventoryMenuItems;
    }
}
