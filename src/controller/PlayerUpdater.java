package controller;

import lombok.Getter;
import lombok.Setter;
import model.Player;

public class PlayerUpdater {

    @Getter
    @Setter
    private static Player currentPlayer;

    private static GuiController guiController;

    public static void init(GuiController guiController) {
        PlayerUpdater.guiController = guiController;
        createEmptyPlayer();
        initUpdating();
        displayAllNotAuto();
        ItemUpdater.init(guiController);
    }

    private static void createEmptyPlayer() {
        currentPlayer = new Player();
    }

    static void loadPlayer(Player player) {
        currentPlayer = player;
        displayAllNotAuto();
    }


    private static void initUpdating() {
        initIdentityUpdating();
        initAttributesUpdating();
        initStatsUpdating();
    }

    private static void initIdentityUpdating() {
        guiController.getProffesion().getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            currentPlayer.setProffesion(guiController.getProffesion().getItems().get((Integer) newValue));
        });
        guiController.getRace().getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            currentPlayer.setRace(guiController.getRace().getItems().get((Integer) newValue));
        });
        guiController.getSign().getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            currentPlayer.setSign(guiController.getSign().getItems().get((Integer) newValue));
        });

        guiController.getFullname().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setFullname(newValue));
        guiController.getAge().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setAge(newValue));
        guiController.getHeight().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setHeight(newValue));
        guiController.getWeight().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setWeight(newValue));
        guiController.getReligion().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setReligion(newValue));
        guiController.getOrigin().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setOrigin(newValue));
        guiController.getAppearance().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setAppearance(newValue));
        guiController.getHistory().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setHistory(newValue));
    }


    private static void initAttributesUpdating() {
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


    private static void initStatsUpdating() {
        guiController.getHitPointsPlus().setOnMouseClicked(event -> {
            currentPlayer.setHitPoints(currentPlayer.getHitPoints() + 1);
            displayHitPoints();
        });
        guiController.getHitPointsMinus().setOnMouseClicked(event -> {
            currentPlayer.setHitPoints(currentPlayer.getHitPoints() - 1);
            displayHitPoints();
        });
        guiController.getActionsPlus().setOnMouseClicked(event -> {
            currentPlayer.setActions(currentPlayer.getActions() + 1);
            displayActions();
        });
        guiController.getActionsMinus().setOnMouseClicked(event -> {
            currentPlayer.setActions(currentPlayer.getActions() - 1);
            displayActions();
        });
        guiController.getManaPlus().setOnMouseClicked(event -> {
            currentPlayer.setMana(currentPlayer.getMana() + 1);
            displayMana();
        });
        guiController.getManaMinus().setOnMouseClicked(event -> {
            currentPlayer.setMana(currentPlayer.getMana() - 1);
            displayMana();
        });
    }


    private static void updateStrength() {
        int strength = StatsCalculator.calculateStrength(currentPlayer);
        currentPlayer.setStrength(strength);
        guiController.getStrength().setText(Integer.toString(strength));

        updateDmg();
    }

    private static void updateEndurance() {
        int endurance = StatsCalculator.calculateEndurance(currentPlayer);
        currentPlayer.setEndurance(endurance);
        guiController.getEndurance().setText(Integer.toString(endurance));

        updateArmor();
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
        int hitPointsMax = (int) Math.round(vim/3.);
        currentPlayer.setHitPointsMax(hitPointsMax);
        guiController.getHitPoints().setText("" + currentPlayer.getHitPoints() + '/' + hitPointsMax);
    }

    private static void updateArm() {
        int arm = StatsCalculator.calculateArm(currentPlayer);
        currentPlayer.setArm(arm);
        guiController.getArm().setText(Integer.toString(arm));

        updateHits();
    }

    private static void updateEye() {
        int eye = StatsCalculator.calculateEye(currentPlayer);
        currentPlayer.setEye(eye);
        guiController.getEye().setText(Integer.toString(eye));

        updateDmg();
        updateHits();
    }

    private static void updateAgility() {
        int agility = StatsCalculator.calculateAgility(currentPlayer);
        currentPlayer.setAgility(agility);
        guiController.getAgility().setText(Integer.toString(agility));

        updateDodges();
    }

    private static void updateEfficiency() {
        int efficiency = StatsCalculator.calculateEfficiency(currentPlayer);
        currentPlayer.setEfficiency(efficiency);
        guiController.getEfficiency().setText(Integer.toString(efficiency));
        int speed = (int) Math.round(1 + efficiency/25.);
        currentPlayer.setSpeed(speed);
        guiController.getSpeed().setText(Integer.toString(speed));
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

        updateManaIncrease();
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
        int manaMax = (int) Math.round(intelligence/3.);
        currentPlayer.setManaMax(manaMax);
        guiController.getMana().setText("" + currentPlayer.getMana() + '/' + manaMax);
    }


    static void updateDmg() {
        int dmgAMin = StatsCalculator.calculateDmgAMin(currentPlayer);
        currentPlayer.setDmgAMin(dmgAMin);
        int dmgAMax = StatsCalculator.calculateDmgAMax(currentPlayer);
        currentPlayer.setDmgAMax(dmgAMax);
        guiController.getDmgA().setText("" + dmgAMin + "-" + dmgAMax);
    }

    private static void updateArmor() {
        int armorHead = StatsCalculator.calculateArmorHead(currentPlayer);
        currentPlayer.setArmorHead(armorHead);
        guiController.getArmorHead().setText(Integer.toString(armorHead));
        int armorBody = StatsCalculator.calculateArmorBody(currentPlayer);
        currentPlayer.setArmorBody(armorBody);
        guiController.getArmorBody().setText(Integer.toString(armorBody));
        int armorArms = StatsCalculator.calculateArmorArms(currentPlayer);
        currentPlayer.setArmorArms(armorArms);
        guiController.getArmorArms().setText(Integer.toString(armorArms));
        int armorLegs = StatsCalculator.calculateArmorLegs(currentPlayer);
        currentPlayer.setArmorLegs(armorLegs);
        guiController.getArmorLegs().setText(Integer.toString(armorLegs));
    }

    static void updateHits() {
        int hitA = StatsCalculator.calculateHitA(currentPlayer);
        currentPlayer.setHitA(hitA);
        guiController.getHitA().setText(Integer.toString(hitA));
    }

    static void updateDodges() {
        int dodge = StatsCalculator.calculateDodgeA(currentPlayer);
        currentPlayer.setDodgeA(dodge);
        guiController.getDodgeA().setText(Integer.toString(dodge));
    }

    static void updateManaIncrease() {
        int manaIncrease = StatsCalculator.calculateManaIncrease(currentPlayer);
        currentPlayer.setManaIncrease(manaIncrease);
        guiController.getManaIncrease().setText(Integer.toString(manaIncrease));
    }

    private static void displayHitPoints() {
        guiController.getHitPoints().setText("" + currentPlayer.getHitPoints() + '/' + currentPlayer.getHitPointsMax());
    }

    private static void displayActions() {
        guiController.getActions().setText("" + currentPlayer.getActions() + '/' + currentPlayer.getActionsMax());
    }

    private static void displayMana() {
        guiController.getMana().setText("" + currentPlayer.getMana() + '/' + currentPlayer.getManaMax());
    }

    private static void displayAllNotAuto() {
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

        displayHitPoints();
        displayActions();
        displayMana();
        guiController.getHitPointsIncrease().setText(Integer.toString(currentPlayer.getHitPointsIncrease()));

        if (currentPlayer.getWeaponA() != null) {
            GuiInitializer.displayWeaponA(currentPlayer.getWeaponA().getModel());
        }
    }
}
