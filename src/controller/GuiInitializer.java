package controller;

import javafx.collections.ObservableList;
import javafx.scene.control.Separator;
import model.*;
import model.horses.HorseType;
import utils.Utils;

import java.util.Arrays;
import java.util.stream.Collectors;

import static controller.Main.guiController;

public class GuiInitializer {


    public static void init() {
        makeFieldsNumeric();
        initProfessions();
        initRaces();
        initSigns();
        initSkills();
        initTraits();
        initHorseTypes();
        EquipmentGuiInitializer.initEquipment();
    }

    private static void makeFieldsNumeric(){
        Utils.makeNumeric(guiController.getStrengthBase());
        Utils.makeNumeric(guiController.getEnduranceBase());
        Utils.makeNumeric(guiController.getFormBase());
        Utils.makeNumeric(guiController.getEyeBase());
        Utils.makeNumeric(guiController.getArmBase());
        Utils.makeNumeric(guiController.getAgilityBase());
        Utils.makeNumeric(guiController.getKnowledgeBase());
        Utils.makeNumeric(guiController.getFocusBase());
        Utils.makeNumeric(guiController.getCharismaBase());
        Utils.makeNumeric(guiController.getLuckPoints());
        Utils.makeNumeric(guiController.getExperiencePoints());
        Utils.makeNumeric(guiController.getSpeed());
        Utils.makeNumeric(guiController.getHorseRiding());
        Utils.makeNumeric(guiController.getLoadExtra());
    }

    private static void initProfessions() {
        guiController.getProfession().getItems().addAll(Profession.values());
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

    private static void initHorseTypes() {
        guiController.getHorseType().getItems().add(null);
        guiController.getHorseType().getItems().addAll(HorseType.values());
    }

}
