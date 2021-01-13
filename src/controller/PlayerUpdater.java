package controller;

import controller.items.ItemHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import lombok.Getter;
import lombok.Setter;
import model.Player;
import model.Skill;
import model.SkillType;

import static controller.Main.guiController;

public class PlayerUpdater {

    @Getter
    @Setter
    public static Player currentPlayer;

    public static void init() {
        createEmptyPlayer();
        initUpdating();
        PlayerDisplayer.displayAllNotAuto();
        ItemHandler.init();
    }

    private static void createEmptyPlayer() {
        currentPlayer = new Player();
    }

    static void loadPlayer(Player player) {
        currentPlayer = player;
        PlayerDisplayer.displayAllNotAuto();
    }


    private static void initUpdating() {
        initIdentityUpdating();
        initAttributesUpdating();
        initSkillsUpdating();
        initTraitsUpdating();
        initAbilityTimeUpdating();
        initStatsUpdating();
    }

    private static void initIdentityUpdating() {
        guiController.getProffesion().getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            currentPlayer.setProffesion(guiController.getProffesion().getItems().get((Integer) newValue));
            PlayerDisplayer.displayAbilities();
        });
        guiController.getRace().getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            currentPlayer.setRace(guiController.getRace().getItems().get((Integer) newValue));
            PlayerDisplayer.displayTraits();
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
        guiController.getFamily().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setFamily(newValue));
        guiController.getAppearance().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setAppearance(newValue));
        guiController.getHistory().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setHistory(newValue));
        guiController.getState().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setState(newValue));
        guiController.getNotes().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setNotes(newValue));
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

    private static void initSkillsUpdating() {
        initSkillUpdating(1, guiController.getSkill1(), guiController.getSkill1lvl1(), guiController.getSkill1lvl2(), guiController.getSkill1lvl3());
        initSkillUpdating(2, guiController.getSkill2(), guiController.getSkill2lvl1(), guiController.getSkill2lvl2(), guiController.getSkill2lvl3());
        initSkillUpdating(3, guiController.getSkill3(), guiController.getSkill3lvl1(), guiController.getSkill3lvl2(), guiController.getSkill3lvl3());
        initSkillUpdating(4, guiController.getSkill4(), guiController.getSkill4lvl1(), guiController.getSkill4lvl2(), guiController.getSkill4lvl3());
        initSkillUpdating(5, guiController.getSkill5(), guiController.getSkill5lvl1(), guiController.getSkill5lvl2(), guiController.getSkill5lvl3());
        initSkillUpdating(6, guiController.getSkill6(), guiController.getSkill6lvl1(), guiController.getSkill6lvl2(), guiController.getSkill6lvl3());
    }

    private static void initSkillUpdating(int skillNumber, ChoiceBox<Object> skillChoiceBox, CheckBox lvl1Checkbox, CheckBox lvl2Checkbox, CheckBox lvl3Checkbox) {
        skillChoiceBox.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() == -1) { //null selected
                return;
            }
            SkillType skillType = (SkillType) skillChoiceBox.getItems().get((Integer) newValue);
            currentPlayer.getSkills()[skillNumber - 1] = new Skill(skillType);
            updateStatsFromSkill(skillType);
            lvl1Checkbox.setDisable(false);
            lvl2Checkbox.setDisable(false);
            PlayerDisplayer.displaySkills();
        });

        lvl1Checkbox.setDisable(true);
        lvl2Checkbox.setDisable(true);
        lvl3Checkbox.setDisable(true);

        lvl1Checkbox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            Skill skill = currentPlayer.getSkills()[skillNumber - 1];
            SkillType skillType = skill.getType();
            if (newValue) {
                skill.setLevel(1);
                lvl2Checkbox.setDisable(false);
            } else {
                currentPlayer.getSkills()[skillNumber - 1] = null;
                skillChoiceBox.getSelectionModel().select(null);
                lvl1Checkbox.setDisable(true);
                lvl2Checkbox.setDisable(true);
            }
            updateStatsFromSkill(skillType);
            PlayerDisplayer.displaySkills();
        });


        lvl2Checkbox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            Skill skill = currentPlayer.getSkills()[skillNumber - 1];
            if (newValue) {
                skill.setLevel(2);
                lvl1Checkbox.setDisable(true);
                lvl3Checkbox.setDisable(false);
            } else {
                skill.setLevel(1);
                lvl1Checkbox.setDisable(false);
                lvl3Checkbox.setDisable(true);
            }
            updateStatsFromSkill(skill.getType());
        });

        lvl3Checkbox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            Skill skill = currentPlayer.getSkills()[skillNumber - 1];
            if (newValue) {
                skill.setLevel(3);
                lvl2Checkbox.setDisable(true);
            } else {
                skill.setLevel(2);
                lvl2Checkbox.setDisable(false);
            }
            updateStatsFromSkill(skill.getType());
        });
    }

    private static void initTraitsUpdating() {
        guiController.getTraitPositive().getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            currentPlayer.setPositiveTrait(guiController.getTraitPositive().getItems().get((Integer) newValue));
            updateResistances();
            PlayerDisplayer.displayTraits();
        });
        guiController.getTraitNeutral().getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            currentPlayer.setNeutralTrait(guiController.getTraitNeutral().getItems().get((Integer) newValue));
            updateResistances();
            PlayerDisplayer.displayTraits();
        });
        guiController.getTraitNegative().getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            currentPlayer.setNegativeTrait(guiController.getTraitNegative().getItems().get((Integer) newValue));
            updateResistances();
            PlayerDisplayer.displayTraits();
        });
    }

    private static void initAbilityTimeUpdating() {
        guiController.getAbilityI1Time().textProperty().addListener((observable, oldValue, newValue)
                -> currentPlayer.setAbilityI1Time(newValue));
        guiController.getAbilityI2Time().textProperty().addListener((observable, oldValue, newValue)
                -> currentPlayer.setAbilityI2Time(newValue));
        guiController.getAbilityII1Time().textProperty().addListener((observable, oldValue, newValue)
                -> currentPlayer.setAbilityII1Time(newValue));
        guiController.getAbilityII2Time().textProperty().addListener((observable, oldValue, newValue)
                -> currentPlayer.setAbilityII2Time(newValue));
        guiController.getAbilityIII1Time().textProperty().addListener((observable, oldValue, newValue)
                -> currentPlayer.setAbilityIII1Time(newValue));
        guiController.getAbilityIII2Time().textProperty().addListener((observable, oldValue, newValue)
                -> currentPlayer.setAbilityIII2Time(newValue));
    }

    private static void initStatsUpdating() {
        guiController.getHitPointsPlus().setOnMouseClicked(event -> {
            currentPlayer.setHitPoints(currentPlayer.getHitPoints() + 1);
            PlayerDisplayer.displayHitPoints();
            updateStatsFromSkill(SkillType.WRATH);
        });
        guiController.getHitPointsMinus().setOnMouseClicked(event -> {
            currentPlayer.setHitPoints(currentPlayer.getHitPoints() - 1);
            PlayerDisplayer.displayHitPoints();
            updateStatsFromSkill(SkillType.WRATH);
        });
        guiController.getActionsPlus().setOnMouseClicked(event -> {
            currentPlayer.setActions(currentPlayer.getActions() + 1);
            PlayerDisplayer.displayActions();
        });
        guiController.getActionsMinus().setOnMouseClicked(event -> {
            currentPlayer.setActions(currentPlayer.getActions() - 1);
            PlayerDisplayer.displayActions();
        });
        guiController.getActionsMaxPlus().setOnMouseClicked(event -> {
            currentPlayer.setActionsMax(currentPlayer.getActionsMax() + 1);
            PlayerDisplayer.displayActions();
        });
        guiController.getActionsMaxMinus().setOnMouseClicked(event -> {
            currentPlayer.setActionsMax(currentPlayer.getActionsMax() - 1);
            PlayerDisplayer.displayActions();
        });
        guiController.getManaPlus().setOnMouseClicked(event -> {
            currentPlayer.setMana(currentPlayer.getMana() + 1);
            PlayerDisplayer.displayMana();
        });
        guiController.getManaMinus().setOnMouseClicked(event -> {
            currentPlayer.setMana(currentPlayer.getMana() - 1);
            PlayerDisplayer.displayMana();
        });
        guiController.getResistFire().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setResistFire(Integer.parseInt(newValue)));
        guiController.getResistCold().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setResistCold(Integer.parseInt(newValue)));
        guiController.getResistWind().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setResistWind(Integer.parseInt(newValue)));
        guiController.getResistEarth().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setResistEarth(Integer.parseInt(newValue)));
        guiController.getResistMagic().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setResistMagic(Integer.parseInt(newValue)));
        guiController.getResistBodyIllness().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setResistBodyIllness(Integer.parseInt(newValue)));
        guiController.getResistMindIllness().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setResistMindIllness(Integer.parseInt(newValue)));
        guiController.getHorseType().getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setHorseType(guiController.getHorseType().getItems().get((Integer) newValue)));
        guiController.getHorseName().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setHorseName(newValue));
        guiController.getHorseHitPoints().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setHorseHitPoints(newValue));
        guiController.getHorseRiding().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setHorseRiding(newValue));
        guiController.getHorseState().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setHorseState(newValue));
        guiController.getHorseEquipment().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setHorseEquipment(newValue));
        guiController.getExtraInventory().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setExtraInventory(newValue));
        guiController.getLoad().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setLoad(newValue));
        guiController.getGold().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setGold(newValue));
        guiController.getBankGold().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setBankGold(newValue));
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
        updateArmors();
        updateResistances();
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
        updateHits();
    }

    public static void updateCharisma() {
        int charisma = StatsCalculator.calculateCharisma(currentPlayer);
        currentPlayer.setCharisma(charisma);
        guiController.getCharisma().setText(Integer.toString(charisma));
    }

    private static void updateIntelligence() {
        int intelligence = StatsCalculator.calculateIntelligence(currentPlayer);
        currentPlayer.setIntelligence(intelligence);
        guiController.getIntelligence().setText(Integer.toString(intelligence));
        updateManaMax();
    }

    public static void updateStatsFromWeapon(boolean firstSet) {
        updateKnowledge();
        updateManaMax();
        updateManaIncrease();
        updateDmg(firstSet);
        updateHits(firstSet);
        updateParry(firstSet);
        updateRange(firstSet);
        updateAttackTime(firstSet);
    }

    public static void updateStatsFromArmor() {
        updateArmors();
        updateForm();
        updateEye();
        updateArm();
        updateAgility();
        updateKnowledge();
        updateFocus();
        updateCharisma();
    }

    private static void updateStatsFromSkill(SkillType skillType) {
        switch (skillType) {
            case REGENERATION:
                updateHitPointsIncrease();
                break;
            case STONE_SKIN:
                updateResistances();
            case WRATH:
                updateDmg();
                break;
            case SHIELDMAN:
                updateBlock();
                updateDmg();
                break;
            case LIGHT_MAGIC:
            case ELEMENTAL_MAGIC:
            case CHANGE_MAGIC:
                updateResistances();
                break;
            case MAGIC_TALENT:
                updateManaIncrease();
                updateManaMax();
                break;
        }
    }

    private static void updateHitPointsIncrease() {
        int hitPointsIncrease = StatsCalculator.calculateHitPointsIncrease(currentPlayer);
        currentPlayer.setHitPointsIncrease(hitPointsIncrease);
        guiController.getHitPointsIncrease().setText(Integer.toString(hitPointsIncrease));
    }

    private static void updateManaMax() {
        int manaMax = StatsCalculator.calculateManaMax(currentPlayer);
        currentPlayer.setManaMax(manaMax);
        guiController.getMana().setText("" + currentPlayer.getMana() + '/' + manaMax);
    }

    private static void updateManaIncrease() {
        int manaIncrease = StatsCalculator.calculateManaIncrease(currentPlayer);
        currentPlayer.setManaIncrease(manaIncrease);
        guiController.getManaIncrease().setText(Integer.toString(manaIncrease));
    }

    public static void updateDmg() {
        updateDmg(true);
        updateDmg(false);
    }

    public static void updateDmg(boolean firstSet) {
        int dmgMin = StatsCalculator.calculateDmgMin(currentPlayer, firstSet, true);
        int dmgMax = StatsCalculator.calculateDmgMax(currentPlayer, firstSet, true);
        int dmgMin2ndHand = StatsCalculator.calculateDmgMin(currentPlayer, firstSet, false);
        int dmgMax2ndHand = StatsCalculator.calculateDmgMax(currentPlayer, firstSet, false);
        if (firstSet) {
            currentPlayer.setDmgAMin(dmgMin);
            currentPlayer.setDmgA2Min(dmgMin2ndHand);
            currentPlayer.setDmgAMax(dmgMax);
            currentPlayer.setDmgA2Max(dmgMax2ndHand);
        } else {
            currentPlayer.setDmgBMin(dmgMin);
            currentPlayer.setDmgB2Min(dmgMin2ndHand);
            currentPlayer.setDmgBMax(dmgMax);
            currentPlayer.setDmgB2Max(dmgMax2ndHand);
        }
        PlayerDisplayer.displayDmg();
    }

    public static void updateArmors() {
        int armorHead = StatsCalculator.calculateArmorHead(currentPlayer);
        currentPlayer.setArmorHead(armorHead);
        int armorBody = StatsCalculator.calculateArmorBody(currentPlayer);
        currentPlayer.setArmorBody(armorBody);
        int armorArms = StatsCalculator.calculateArmorArms(currentPlayer);
        currentPlayer.setArmorArms(armorArms);
        int armorLegs = StatsCalculator.calculateArmorLegs(currentPlayer);
        currentPlayer.setArmorLegs(armorLegs);
        PlayerDisplayer.displayArmors();
    }

    public static void updateResistances() {
        int fireResistance = StatsCalculator.calculateFireResistance(currentPlayer);
        currentPlayer.setResistFire(fireResistance);
        int coldResistance = StatsCalculator.calculateColdResistance(currentPlayer);
        currentPlayer.setResistCold(coldResistance);
        int windResistance = StatsCalculator.calculateWindResistance(currentPlayer);
        currentPlayer.setResistWind(windResistance);
        int earthResistance = StatsCalculator.calculateEarthResistance(currentPlayer);
        currentPlayer.setResistEarth(earthResistance);
        int magicResistance = StatsCalculator.calculateMagicResistance(currentPlayer);
        currentPlayer.setResistMagic(magicResistance);
        int bodyIllnessResistance = StatsCalculator.calculateBodyIllnessResistance(currentPlayer);
        currentPlayer.setResistBodyIllness(bodyIllnessResistance);
        int findIllnessResistance = StatsCalculator.calculateMindIllnessResistance(currentPlayer);
        currentPlayer.setResistMindIllness(findIllnessResistance);
        PlayerDisplayer.displayResistances();
    }

    public static void updateHits() {
        updateHits(true);
        updateHits(false);
    }

    public static void updateHits(boolean firstSet) {
        int hit = StatsCalculator.calculateHit(currentPlayer, firstSet, true);
        int hit2ndHand = StatsCalculator.calculateHit(currentPlayer, firstSet, false);
        if(firstSet) {
            currentPlayer.setHitA(hit);
            currentPlayer.setHitA2(hit2ndHand);
        } else {
            currentPlayer.setHitB(hit);
            currentPlayer.setHitB2(hit2ndHand);
        }
        PlayerDisplayer.displayHit();
    }

    public static void updateParry(boolean firstSet) {
        int parry = StatsCalculator.calculateParry(currentPlayer, firstSet);
        if(firstSet) {
            currentPlayer.setParryA(parry);
        } else {
            currentPlayer.setParryB(parry);
        }
        PlayerDisplayer.displayParry();
    }

    public static void updateBlock() {
        updateBlock(true);
        updateBlock(false);
    }

    public static void updateBlock(boolean firstSet) {
        int block = StatsCalculator.calculateBlock(currentPlayer, firstSet);
        if (firstSet) {
            currentPlayer.setBlockA(block);
        } else {
            currentPlayer.setBlockB(block);
        }
        PlayerDisplayer.displayBlock();
    }

    static void updateDodges() {
        int dodge = StatsCalculator.calculateDodge(currentPlayer, true);
        currentPlayer.setDodgeA(dodge);
        currentPlayer.setDodgeB(dodge);
        PlayerDisplayer.displayDodge();
    }

    public static void updateRange(boolean firstSet) {
        int range = StatsCalculator.calculateRange(currentPlayer, firstSet, true);
        int range2ndHand = StatsCalculator.calculateRange(currentPlayer, firstSet, false);
        if(firstSet) {
            currentPlayer.setRangeA(range);
            currentPlayer.setRangeA2(range2ndHand);
        } else {
            currentPlayer.setRangeB(range);
            currentPlayer.setRangeB2(range2ndHand);
        }
        PlayerDisplayer.displayRange();
    }

    public static void updateAttackTime(boolean firstSet) {
        int attackTime = StatsCalculator.calculateAttackTime(currentPlayer, firstSet, true);
        int attackTime2ndHand = StatsCalculator.calculateAttackTime(currentPlayer, firstSet, false);
        if(firstSet) {
            currentPlayer.setAttackTimeA(attackTime);
            currentPlayer.setAttackTimeA2(attackTime2ndHand);
        } else {
            currentPlayer.setAttackTimeB(attackTime);
            currentPlayer.setAttackTimeB2(attackTime2ndHand);
        }
        PlayerDisplayer.displayAttackTime();
    }

}
