package controller;

import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import model.Skill;

import static controller.PlayerUpdater.currentPlayer;
import static controller.PlayerUpdater.guiController;

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

    public static void displayHitPoints() {
        guiController.getHitPoints().setText("" + currentPlayer.getHitPoints() + '/' + currentPlayer.getHitPointsMax());
    }

    public static void displayActions() {
        guiController.getActions().setText("" + currentPlayer.getActions() + '/' + currentPlayer.getActionsMax());
    }

    public static void displayMana() {
        guiController.getMana().setText("" + currentPlayer.getMana() + '/' + currentPlayer.getManaMax());
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

        displayHitPoints();
        displayActions();
        displayMana();
        guiController.getHitPointsIncrease().setText(Integer.toString(currentPlayer.getHitPointsIncrease()));

        if (currentPlayer.getWeaponA() != null) {
            GuiInitializer.displayWeaponA(currentPlayer.getWeaponA().getModel());
        }
    }
}
