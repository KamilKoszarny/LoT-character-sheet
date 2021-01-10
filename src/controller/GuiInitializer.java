package controller;

import controller.items.EquipmentSlot;
import controller.items.ItemHandler;
import javafx.collections.ObservableList;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import model.*;
import model.items.Weapon;
import model.items.WeaponModel;
import model.items.WeaponType;

import java.awt.*;
import java.util.Arrays;
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
        for (EquipmentSlot slot: EquipmentSlot.values()) {
            initItemMenu(slot.getMenuButton(), slot);
        }
    }

    private static void initItemMenu(MenuButton button, EquipmentSlot equipmentSlot) {
        button.lookup(".arrow-button" ).setStyle( "-fx-padding: 0" );
        button.lookup(".arrow" ).setStyle( "-fx-background-insets: 0; -fx-padding: 0; -fx-shape: null;" );

        button.setOnMousePressed(event
                -> ItemHandler.handleEquipmentSlotClick(button, equipmentSlot, new Point((int)event.getX(), (int)event.getY())));

        for (WeaponType weaponType: WeaponType.values()) {
            Menu menu = new Menu();
            menu.setText(weaponType.getNamePL());
            for (WeaponModel weaponModel: WeaponModel.values()) {
                if (weaponModel.getType().equals(weaponType)) {
                    MenuItem menuItem = new MenuItem();
                    menuItem.setText(weaponModel.getNamePL());
                    menuItem.setOnAction(event -> {
                        Weapon weapon = new Weapon(weaponModel);
                        PlayerUpdater.getCurrentPlayer().trySetItem(weapon, equipmentSlot);
                        PlayerUpdater.updateDmg(equipmentSlot.equals(EquipmentSlot.WEAPON_A));
                        PlayerUpdater.updateHits(equipmentSlot.equals(EquipmentSlot.WEAPON_A));
                        PlayerDisplayer.displayItem(weapon, equipmentSlot);
                    });
                    menu.getItems().add(menuItem);
                }
            }
            button.getItems().add(menu);
        }
    }
}
