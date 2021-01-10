package controller;

import controller.items.EquipmentSlot;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Ability;
import model.Proffesion;
import model.Skill;
import model.items.Item;
import model.items.Weapon;

import static controller.Main.guiController;
import static controller.PlayerUpdater.currentPlayer;

public class PlayerDisplayer {

    public static void displaySkills() {
        displaySkill(1, guiController.getSkill1(), guiController.getSkill1lvl1(), guiController.getSkill1lvl2(), guiController.getSkill1lvl3(), guiController.getSkill1description());
        displaySkill(2, guiController.getSkill2(), guiController.getSkill2lvl1(), guiController.getSkill2lvl2(), guiController.getSkill2lvl3(), guiController.getSkill2description());
        displaySkill(3, guiController.getSkill3(), guiController.getSkill3lvl1(), guiController.getSkill3lvl2(), guiController.getSkill3lvl3(), guiController.getSkill3description());
        displaySkill(4, guiController.getSkill4(), guiController.getSkill4lvl1(), guiController.getSkill4lvl2(), guiController.getSkill4lvl3(), guiController.getSkill4description());
        displaySkill(5, guiController.getSkill5(), guiController.getSkill5lvl1(), guiController.getSkill5lvl2(), guiController.getSkill5lvl3(), guiController.getSkill5description());
        displaySkill(6, guiController.getSkill6(), guiController.getSkill6lvl1(), guiController.getSkill6lvl2(), guiController.getSkill6lvl3(), guiController.getSkill6description());
    }

    private static void displaySkill(int skillNumber, ChoiceBox<Object> choiceBox, CheckBox lvl1Checkbox, CheckBox lvl2Checkbox, CheckBox lvl3Checkbox, Label description) {
        int index = skillNumber - 1;
        Skill skill = currentPlayer.getSkills()[index];
        if (skill != null) {
            choiceBox.getSelectionModel().select(skill.getType());
            if (skill.getLevel() >= 1) {
                lvl1Checkbox.setSelected(true);
            }
            if (skill.getLevel() >= 2) {
                lvl2Checkbox.setSelected(true);
            }
            if (skill.getLevel() == 3) {
                lvl3Checkbox.setSelected(true);
            }
            description.setText(skill.getType().getDescriptionPL());
        }
    }

    public static void displayTraits() {
        if (currentPlayer.getPositiveTrait() != null) {
            guiController.getTraitPositive().getSelectionModel().select(currentPlayer.getPositiveTrait());
            guiController.getTraitPositiveDescription().setText(currentPlayer.getPositiveTrait().getDescriptionPL());
        }
        if (currentPlayer.getNeutralTrait() != null) {
            guiController.getTraitNeutral().getSelectionModel().select(currentPlayer.getNeutralTrait());
            guiController.getTraitNeutralDescription().setText(currentPlayer.getNeutralTrait().getDescriptionPL());
        }
        if (currentPlayer.getNegativeTrait() != null) {
            guiController.getTraitNegative().getSelectionModel().select(currentPlayer.getNegativeTrait());
            guiController.getTraitNegativeDescription().setText(currentPlayer.getNegativeTrait().getDescriptionPL());
        }
    }

    public static void displayAbilities() {
        if (currentPlayer.getProffesion() == null) return;

        final Proffesion lvl1Proffesion = currentPlayer.getProffesion().getLvl1Proffesion();
        guiController.getAbilityI0().setText(Ability.findAbility(lvl1Proffesion, 0).getNamePL());
        guiController.getAbilityI1().setText(Ability.findAbility(lvl1Proffesion, 1).getNamePL());
        guiController.getAbilityI2().setText(Ability.findAbility(lvl1Proffesion, 2).getNamePL());
        guiController.getAbilityI0Description().setText(Ability.findAbility(lvl1Proffesion, 0).getDescriptionPL());
        guiController.getAbilityI1Description().setText(Ability.findAbility(lvl1Proffesion, 1).getDescriptionPL());
        guiController.getAbilityI2Description().setText(Ability.findAbility(lvl1Proffesion, 2).getDescriptionPL());
        guiController.getAbilityI1Time().setText(currentPlayer.getAbilityI1Time());
        guiController.getAbilityI2Time().setText(currentPlayer.getAbilityI2Time());

        if (currentPlayer.getProffesion().getLevel() >= 2) {
            final Proffesion lvl2Proffesion = currentPlayer.getProffesion().getLvl2Proffesion();
            guiController.getAbilityII0().setText(Ability.findAbility(lvl2Proffesion, 0).getNamePL());
            guiController.getAbilityII1().setText(Ability.findAbility(lvl2Proffesion, 1).getNamePL());
            guiController.getAbilityII2().setText(Ability.findAbility(lvl2Proffesion, 2).getNamePL());
            guiController.getAbilityII0Description().setText(Ability.findAbility(lvl2Proffesion, 0).getDescriptionPL());
            guiController.getAbilityII1Description().setText(Ability.findAbility(lvl2Proffesion, 1).getDescriptionPL());
            guiController.getAbilityII2Description().setText(Ability.findAbility(lvl2Proffesion, 2).getDescriptionPL());
            guiController.getAbilityII1Time().setText(currentPlayer.getAbilityII1Time());
            guiController.getAbilityII2Time().setText(currentPlayer.getAbilityII2Time());
        } else {
            guiController.getAbilitiesII().setVisible(false);
        }

        if (currentPlayer.getProffesion().getLevel() == 3) {
            final Proffesion lvl3Proffesion = currentPlayer.getProffesion();
            guiController.getAbilityIII0().setText(Ability.findAbility(lvl3Proffesion, 0).getNamePL());
            guiController.getAbilityIII1().setText(Ability.findAbility(lvl3Proffesion, 1).getNamePL());
            guiController.getAbilityIII2().setText(Ability.findAbility(lvl3Proffesion, 2).getNamePL());
            guiController.getAbilityIII0Description().setText(Ability.findAbility(lvl3Proffesion, 0).getDescriptionPL());
            guiController.getAbilityIII1Description().setText(Ability.findAbility(lvl3Proffesion, 1).getDescriptionPL());
            guiController.getAbilityIII2Description().setText(Ability.findAbility(lvl3Proffesion, 2).getDescriptionPL());
            guiController.getAbilityIII1Time().setText(currentPlayer.getAbilityIII1Time());
            guiController.getAbilityIII2Time().setText(currentPlayer.getAbilityIII2Time());
        } else {
            guiController.getAbilitiesIII().setVisible(false);
        }
    }

    public static void displayHitPoints() {
        guiController.getHitPoints().setText("" + currentPlayer.getHitPoints() + '/' + currentPlayer.getHitPointsMax());
    }

    public static void displayActions() {
        guiController.getActions().setText("" + currentPlayer.getActions() + '/' + currentPlayer.getActionsMax());
    }

    public static void displayMana() {
        guiController.getMana().setText("" + currentPlayer.getMana() + '/' + currentPlayer.getManaMax());
    }

    private static void displayEquipment() {
        if (currentPlayer.getWeaponA() != null) {
            displayItem(currentPlayer.getWeaponA(), EquipmentSlot.WEAPON_A);
        }
        if (currentPlayer.getWeaponB() != null) {
            displayItem(currentPlayer.getWeaponA(), EquipmentSlot.WEAPON_B);
        }
    }

    public static void displayItem(Item item, EquipmentSlot equipmentSlot) {
        MenuButton button = findEquipmentButton(equipmentSlot);
        Image img = findImage(item);
        ImageView view = new ImageView(img);
        button.setGraphic(view);
        button.setOpacity(1);
    }

    public static MenuButton findEquipmentButton(EquipmentSlot equipmentSlot) {
        switch (equipmentSlot) {
            case WEAPON_A: return guiController.getWeaponAMenu();
            case WEAPON_B: return guiController.getWeaponBMenu();
            default: return guiController.getWeaponAMenu();
        }
    }

    public static Image findImage(Item item) {
        String path = "images/";
        switch (item.getItemType()) {
            case WEAPON:
                path += "weapons/" + ((Weapon) item).getModel().name() + ".png";
        }
        return new Image(path);
    }

    public static void displayAllNotAuto() {
        guiController.getProffesion().getSelectionModel().select(currentPlayer.getProffesion());
        guiController.getRace().getSelectionModel().select(currentPlayer.getRace());
        guiController.getSign().getSelectionModel().select(currentPlayer.getSign());
        guiController.getFullname().setText(currentPlayer.getFullname());
        guiController.getAge().setText(currentPlayer.getAge());
        guiController.getHeight().setText(currentPlayer.getHeight());
        guiController.getWeight().setText(currentPlayer.getWeight());
        guiController.getReligion().setText(currentPlayer.getReligion());
        guiController.getOrigin().setText(currentPlayer.getOrigin());
        guiController.getAppearance().setText(currentPlayer.getAppearance());
        guiController.getHistory().setText(currentPlayer.getHistory());

        guiController.getVim().setText(Integer.toString(currentPlayer.getVim()));
        guiController.getStrengthBase().setText(Integer.toString(currentPlayer.getStrengthBase()));
        guiController.getStrength().setText(Integer.toString(currentPlayer.getStrength()));
        guiController.getEnduranceBase().setText(Integer.toString(currentPlayer.getEnduranceBase()));
        guiController.getEndurance().setText(Integer.toString(currentPlayer.getEndurance()));
        guiController.getFormBase().setText(Integer.toString(currentPlayer.getFormBase()));
        guiController.getForm().setText(Integer.toString(currentPlayer.getForm()));
        guiController.getEfficiency().setText(Integer.toString(currentPlayer.getEfficiency()));
        guiController.getArmBase().setText(Integer.toString(currentPlayer.getArmBase()));
        guiController.getArm().setText(Integer.toString(currentPlayer.getArm()));
        guiController.getEyeBase().setText(Integer.toString(currentPlayer.getEyeBase()));
        guiController.getEye().setText(Integer.toString(currentPlayer.getEye()));
        guiController.getAgilityBase().setText(Integer.toString(currentPlayer.getAgilityBase()));
        guiController.getAgility().setText(Integer.toString(currentPlayer.getAgility()));
        guiController.getIntelligence().setText(Integer.toString(currentPlayer.getIntelligence()));
        guiController.getKnowledgeBase().setText(Integer.toString(currentPlayer.getKnowledgeBase()));
        guiController.getKnowledge().setText(Integer.toString(currentPlayer.getKnowledge()));
        guiController.getFocusBase().setText(Integer.toString(currentPlayer.getFocusBase()));
        guiController.getFocus().setText(Integer.toString(currentPlayer.getFocus()));
        guiController.getCharismaBase().setText(Integer.toString(currentPlayer.getCharismaBase()));
        guiController.getCharisma().setText(Integer.toString(currentPlayer.getCharisma()));

        displaySkills();
        displayTraits();
        displayAbilities();

        displayHitPoints();
        displayActions();
        displayMana();
        guiController.getHitPointsIncrease().setText(Integer.toString(currentPlayer.getHitPointsIncrease()));

        displayEquipment();
    }
}
