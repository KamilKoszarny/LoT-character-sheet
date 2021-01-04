package controller;

import GUI.GuiController;
import model.Player;

public class PlayerUpdater {

    private static Player currentPlayer;
    private static GuiController guiController;

    public static void init() {
        createEmptyPlayer();
        initUpdating();
    }

    private static void createEmptyPlayer() {
        currentPlayer = new Player();
    }

    private static void initUpdating() {
        initStatsUpdating();
    }

    private static void initStatsUpdating() {
        initStrengthBaseListener();
        initEnduranceBaseListener();
        initFormBaseListener();
        initArmBaseListener();
        initEyeBaseListener();
        initAgilityBaseListener();
        initKnowledgeBaseListener();
        initFocusBaseListener();
        initCharismaBaseListener();
    }

    private static void initStrengthBaseListener() {
        guiController.getStrengthBase().textProperty().addListener((observable, oldValue, newValue) -> {
            currentPlayer.setStrengthBase(Integer.parseInt(newValue));
            updateStrength();
            updateVim();
        });
    }

    private static void initEnduranceBaseListener() {
        guiController.getEnduranceBase().textProperty().addListener((observable, oldValue, newValue) -> {
            currentPlayer.setEnduranceBase(Integer.parseInt(newValue));
            updateEndurance();
            updateVim();
        });
    }

    private static void initFormBaseListener() {
        guiController.getFormBase().textProperty().addListener((observable, oldValue, newValue) -> {
            currentPlayer.setFormBase(Integer.parseInt(newValue));
            updateForm();
            updateVim();
        });
    }

    private static void initArmBaseListener() {
        guiController.getArmBase().textProperty().addListener((observable, oldValue, newValue) -> {
            currentPlayer.setArmBase(Integer.parseInt(newValue));
            updateArm();
            updateEfficiency();
        });
    }

    private static void initEyeBaseListener() {
        guiController.getEyeBase().textProperty().addListener((observable, oldValue, newValue) -> {
            currentPlayer.setEyeBase(Integer.parseInt(newValue));
            updateEye();
            updateEfficiency();
        });
    }

    private static void initAgilityBaseListener() {
        guiController.getAgilityBase().textProperty().addListener((observable, oldValue, newValue) -> {
            currentPlayer.setAgilityBase(Integer.parseInt(newValue));
            updateAgility();
            updateEfficiency();
        });
    }

    private static void initKnowledgeBaseListener() {
        guiController.getKnowledgeBase().textProperty().addListener((observable, oldValue, newValue) -> {
            currentPlayer.setKnowledgeBase(Integer.parseInt(newValue));
            updateKnowledge();
            updateIntelligence();
        });
    }

    private static void initFocusBaseListener() {
        guiController.getFocusBase().textProperty().addListener((observable, oldValue, newValue) -> {
            currentPlayer.setFocusBase(Integer.parseInt(newValue));
            updateFocus();
            updateIntelligence();
        });
    }

    private static void initCharismaBaseListener() {
        guiController.getCharismaBase().textProperty().addListener((observable, oldValue, newValue) -> {
            currentPlayer.setCharismaBase(Integer.parseInt(newValue));
            updateCharisma();
            updateIntelligence();
        });
    }

    private static void updateStrength() {
        int strength = StatsCalculator.calculateStrength(currentPlayer);
        currentPlayer.setStrength(strength);
        guiController.getStrength().setText(Integer.toString(strength));
    }

    private static void updateEndurance() {
        int endurance = StatsCalculator.calculateEndurance(currentPlayer);
        currentPlayer.setEndurance(endurance);
        guiController.getEndurance().setText(Integer.toString(endurance));
    }

    private static void updateForm() {
        int form = StatsCalculator.calculateForm(currentPlayer);
        currentPlayer.setForm(form);
        guiController.getForm().setText(Integer.toString(form));
    }

    private static void updateVim() {
        int vim = StatsCalculator.calculateVim(currentPlayer);
        currentPlayer.setVim(vim);
        guiController.getVim().setText(Integer.toString(vim));
    }

    private static void updateArm() {
        int arm = StatsCalculator.calculateArm(currentPlayer);
        currentPlayer.setArm(arm);
        guiController.getArm().setText(Integer.toString(arm));
    }

    private static void updateEye() {
        int eye = StatsCalculator.calculateEye(currentPlayer);
        currentPlayer.setEye(eye);
        guiController.getEye().setText(Integer.toString(eye));
    }

    private static void updateAgility() {
        int agility = StatsCalculator.calculateAgility(currentPlayer);
        currentPlayer.setAgility(agility);
        guiController.getAgility().setText(Integer.toString(agility));
    }

    private static void updateEfficiency() {
        int efficiency = StatsCalculator.calculateEfficiency(currentPlayer);
        currentPlayer.setEfficiency(efficiency);
        guiController.getEfficiency().setText(Integer.toString(efficiency));
    }

    private static void updateKnowledge() {
        int knowledge = StatsCalculator.calculateKnowledge(currentPlayer);
        currentPlayer.setKnowledge(knowledge);
        guiController.getKnowledge().setText(Integer.toString(knowledge));
    }

    private static void updateFocus() {
        int focus = StatsCalculator.calculateFocus(currentPlayer);
        currentPlayer.setFocus(focus);
        guiController.getFocus().setText(Integer.toString(focus));
    }

    private static void updateCharisma() {
        int charisma = StatsCalculator.calculateCharisma(currentPlayer);
        currentPlayer.setCharisma(charisma);
        guiController.getCharisma().setText(Integer.toString(charisma));
    }

    private static void updateIntelligence() {
        int intelligence = StatsCalculator.calculateIntelligence(currentPlayer);
        currentPlayer.setIntelligence(intelligence);
        guiController.getIntelligence().setText(Integer.toString(intelligence));
    }

    public static void setGuiController(GuiController guiController) {
        PlayerUpdater.guiController = guiController;
    }
}
