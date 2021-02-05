package controller;

import controller.items.ItemHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import lombok.Getter;
import lombok.Setter;
import model.Modifying;
import model.Player;
import model.Skill;
import model.SkillType;
import model.horses.Horse;
import model.items.ModifierType;

import java.util.Set;

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
        initLuckAndExperienceUpdating();
        initSkillsUpdating();
        initTraitsUpdating();
        initAbilityTimeUpdating();
        initStatsUpdating();
    }

    private static void initIdentityUpdating() {
        guiController.getProfession().getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            currentPlayer.setProfession(guiController.getProfession().getItems().get((Integer) newValue));
            PlayerDisplayer.displayAbilities();
        });
        guiController.getRace().getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            currentPlayer.setRace(guiController.getRace().getItems().get((Integer) newValue));
            PlayerDisplayer.displayTraits();
        });
        guiController.getSign().getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            currentPlayer.setSign(guiController.getSign().getItems().get((Integer) newValue));
            guiController.getSignNumber().setText(String.valueOf(currentPlayer.getSign().getNumber()));
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
        guiController.getSatiety().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setSatiety(newValue));
        guiController.getAlertness().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setAlertness(newValue));
        guiController.getIllnesses().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setIllnesses(newValue));
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

    private static void initLuckAndExperienceUpdating() {
        guiController.getLuckPoints().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setLuckPoints(Integer.parseInt(newValue)));
        guiController.getExperiencePoints().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setExperiencePoints(Integer.parseInt(newValue)));
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
            updateSkillsExtra();
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
            updateSkillsExtra();
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
            updateSkillsExtra();
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
            updateSkillsExtra();
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
        guiController.getHorseType().getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            boolean horseRemoved = newValue.intValue() <= 0;
            if (horseRemoved) {
                currentPlayer.setHorse(null);
            } else {
                currentPlayer.setHorse(new Horse(guiController.getHorseType().getItems().get((Integer) newValue)));
            }
            guiController.getHorseName().setDisable(horseRemoved);
            guiController.getHorseRiding().setDisable(horseRemoved);
            guiController.getHorseState().setDisable(horseRemoved);
            guiController.getHorseEquipment().setDisable(horseRemoved);
            updateLoad();
            PlayerDisplayer.displayHorse();
        });
        guiController.getHorseName().textProperty().addListener((observable, oldValue, newValue) -> {
            if (currentPlayer.getHorse() != null) {
                currentPlayer.getHorse().setName(newValue);
            }
        });
        guiController.getHorseHPPlus().setOnMouseClicked(event -> {
            currentPlayer.getHorse().setHitPoints(currentPlayer.getHorse().getHitPoints() + 1);
            PlayerDisplayer.displayHorse();
        });
        guiController.getHorseHPMinus().setOnMouseClicked(event -> {
            currentPlayer.getHorse().setHitPoints(currentPlayer.getHorse().getHitPoints() - 1);
            PlayerDisplayer.displayHorse();
        });
        guiController.getHorseRiding().textProperty().addListener((observable, oldValue, newValue) -> {
            if (currentPlayer.getHorse() != null) {
                currentPlayer.getHorse().setRiding(Integer.parseInt(newValue));
            }
        });
        guiController.getHorseState().textProperty().addListener((observable, oldValue, newValue) -> {
            if (currentPlayer.getHorse() != null) {
                currentPlayer.getHorse().setState(newValue);
            }
        });
        guiController.getHorseEquipment().textProperty().addListener((observable, oldValue, newValue) -> {
            if (currentPlayer.getHorse() != null) {
                currentPlayer.getHorse().setEquipmentStr(newValue);
            }
        });
        guiController.getExtraInventory().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setExtraInventory(newValue));
        guiController.getLoadExtra().textProperty().addListener((observable, oldValue, newValue) -> {
            currentPlayer.setLoadExtra(Integer.parseInt(newValue));
            updateLoad();
        });
        guiController.getLoadExtraPlus().setOnMouseClicked(event -> {
            currentPlayer.setLoadExtra(currentPlayer.getLoadExtra() + 1);
            PlayerDisplayer.displayLoad();
        });
        guiController.getLoadExtraMinus().setOnMouseClicked(event -> {
            currentPlayer.setLoadExtra(currentPlayer.getLoadExtra() - 1);
            PlayerDisplayer.displayLoad();
        });
        guiController.getGold().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setGold(newValue));
        guiController.getBankGold().textProperty().addListener((observable, oldValue, newValue) -> currentPlayer.setBankGold(newValue));
    }


    private static void updateStrength() {
        int strength = StatsCalculator.calculateStrength(currentPlayer);
        currentPlayer.setStrength(strength);
        guiController.getStrength().setText(Integer.toString(strength));

        updateDmg();
        updateLoad();
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
        updateHitPointsMax();
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
        updateSpeed();
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

    private static void updateSkillsExtra() {
        Set<Modifying> modifiers = currentPlayer.getModifyingObjects();
        for (int i = 1; i <= currentPlayer.getSkills().length; i++) {
            Skill skill = currentPlayer.getSkills()[i-1];
            if (skill != null) {
                int skillExtra = 0;
                for (Modifying modifier: modifiers) {
                    skillExtra += modifier.getModifiersSum(skill.getType().getModifierType());
                }
                if (skillExtra > 0) {
                    guiController.getSkillExtraLabel(i).setText("+" + skillExtra);
                } else {
                    guiController.getSkillExtraLabel(i).setText("");
                }
            }
        }
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

    private static void updateHitPointsMax() {
        int hitPointsMax = StatsCalculator.calculateHitPointsMax(currentPlayer);
        currentPlayer.setHitPointsMax(hitPointsMax);
        guiController.getHitPoints().setText("" + currentPlayer.getHitPoints() + '/' + hitPointsMax);
    }


    private static void updateHitPointsIncrease() {
        int hitPointsIncrease = StatsCalculator.calculateHitPointsIncrease(currentPlayer);
        currentPlayer.setHitPointsIncrease(hitPointsIncrease);
        guiController.getHitPointsIncrease().setText(Integer.toString(hitPointsIncrease));
    }

    private static void updateSpeed() {
        int speed = StatsCalculator.calculateSpeed(currentPlayer);
        currentPlayer.setSpeed(speed);
        guiController.getSpeed().setText(Integer.toString(speed));
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

    private static void updateActionsMax() {
        int actionsMaxExtra = StatsCalculator.calculateActionsMaxExtra(currentPlayer);
        currentPlayer.setActionsMaxExtra(actionsMaxExtra);
        PlayerDisplayer.displayActions();
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
        int dmgFire = StatsCalculator.calculateDmgExtra(currentPlayer, firstSet, true, ModifierType.DMG_FIRE);
        int dmgFire2ndHand = StatsCalculator.calculateDmgExtra(currentPlayer, firstSet, false, ModifierType.DMG_FIRE);
        int dmgCold = StatsCalculator.calculateDmgExtra(currentPlayer, firstSet, true, ModifierType.DMG_COLD);
        int dmgCold2ndHand = StatsCalculator.calculateDmgExtra(currentPlayer, firstSet, false, ModifierType.DMG_COLD);
        int dmgWind = StatsCalculator.calculateDmgExtra(currentPlayer, firstSet, true, ModifierType.DMG_WIND);
        int dmgWind2ndHand = StatsCalculator.calculateDmgExtra(currentPlayer, firstSet, false, ModifierType.DMG_WIND);
        int dmgEarth = StatsCalculator.calculateDmgExtra(currentPlayer, firstSet, true, ModifierType.DMG_EARTH);
        int dmgEarth2ndHand = StatsCalculator.calculateDmgExtra(currentPlayer, firstSet, false, ModifierType.DMG_EARTH);
        int dmgMagic = StatsCalculator.calculateDmgExtra(currentPlayer, firstSet, true, ModifierType.DMG_MAGIC);
        int dmgMagic2ndHand = StatsCalculator.calculateDmgExtra(currentPlayer, firstSet, false, ModifierType.DMG_MAGIC);
        if (firstSet) {
            currentPlayer.setDmg1stSetMin(dmgMin);
            currentPlayer.setDmg1stSet2ndHandMin(dmgMin2ndHand);
            currentPlayer.setDmg1stSetMax(dmgMax);
            currentPlayer.setDmg1stSet2ndHandMax(dmgMax2ndHand);
            currentPlayer.setDmg1stSetFire(dmgFire);
            currentPlayer.setDmg1stSet2ndHandFire(dmgFire2ndHand);
            currentPlayer.setDmg1stSetCold(dmgCold);
            currentPlayer.setDmg1stSet2ndHandCold(dmgCold2ndHand);
            currentPlayer.setDmg1stSetWind(dmgWind);
            currentPlayer.setDmg1stSet2ndHandWind(dmgWind2ndHand);
            currentPlayer.setDmg1stSetEarth(dmgEarth);
            currentPlayer.setDmg1stSet2ndHandEarth(dmgEarth2ndHand);
            currentPlayer.setDmg1stSetMagic(dmgMagic);
            currentPlayer.setDmg1stSet2ndHandMagic(dmgMagic2ndHand);
        } else {
            currentPlayer.setDmg2ndSetMin(dmgMin);
            currentPlayer.setDmg2ndSet2ndHandMin(dmgMin2ndHand);
            currentPlayer.setDmg2ndSetMax(dmgMax);
            currentPlayer.setDmg2ndSet2ndHandMax(dmgMax2ndHand);
            currentPlayer.setDmg2ndSetFire(dmgFire);
            currentPlayer.setDmg2ndSet2ndHandFire(dmgFire2ndHand);
            currentPlayer.setDmg2ndSetCold(dmgCold);
            currentPlayer.setDmg2ndSet2ndHandCold(dmgCold2ndHand);
            currentPlayer.setDmg2ndSetWind(dmgWind);
            currentPlayer.setDmg2ndSet2ndHandWind(dmgWind2ndHand);
            currentPlayer.setDmg2ndSetEarth(dmgEarth);
            currentPlayer.setDmg2ndSet2ndHandEarth(dmgEarth2ndHand);
            currentPlayer.setDmg2ndSetMagic(dmgMagic);
            currentPlayer.setDmg2ndSet2ndHandMagic(dmgMagic2ndHand);
        }
        PlayerDisplayer.displayDmg();
    }

    public static void updateHits() {
        updateHits(true);
        updateHits(false);
    }

    public static void updateHits(boolean firstSet) {
        int hit = StatsCalculator.calculateHit(currentPlayer, firstSet, true);
        int hit2ndHand = StatsCalculator.calculateHit(currentPlayer, firstSet, false);
        if(firstSet) {
            currentPlayer.setHit1stSet(hit);
            currentPlayer.setHit1stSet2ndHand(hit2ndHand);
        } else {
            currentPlayer.setHit2ndSet(hit);
            currentPlayer.setHit2ndSet2ndHand(hit2ndHand);
        }
        PlayerDisplayer.displayHit();
    }

    public static void updateParry() {
        updateParry(true);
        updateParry(false);
    }

    public static void updateParry(boolean firstSet) {
        int parry = StatsCalculator.calculateParry(currentPlayer, firstSet);
        if(firstSet) {
            currentPlayer.setParry1stSet(parry);
        } else {
            currentPlayer.setParry2ndSet(parry);
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
            currentPlayer.setBlock1stSet(block);
        } else {
            currentPlayer.setBlock2ndSet(block);
        }
        PlayerDisplayer.displayBlock();
    }

    static void updateDodges() {
        int dodge = StatsCalculator.calculateDodge(currentPlayer, true);
        currentPlayer.setDodge1stSet(dodge);
        currentPlayer.setDodge2ndSet(dodge);
        PlayerDisplayer.displayDodge();
    }

    public static void updateRange() {
        updateRange(true);
        updateRange(false);
    }

    public static void updateRange(boolean firstSet) {
        int range = StatsCalculator.calculateRange(currentPlayer, firstSet, true);
        int range2ndHand = StatsCalculator.calculateRange(currentPlayer, firstSet, false);
        if(firstSet) {
            currentPlayer.setRange1stSet(range);
            currentPlayer.setRange1stSet2ndHand(range2ndHand);
        } else {
            currentPlayer.setRange2ndSet(range);
            currentPlayer.setRange2ndSet2ndHand(range2ndHand);
        }
        PlayerDisplayer.displayRange();
    }

    public static void updateAttackTime() {
        updateAttackTime(true);
        updateAttackTime(false);
    }

    public static void updateAttackTime(boolean firstSet) {
        int attackTime = StatsCalculator.calculateAttackTime(currentPlayer, firstSet, true);
        int attackTime2ndHand = StatsCalculator.calculateAttackTime(currentPlayer, firstSet, false);
        if(firstSet) {
            currentPlayer.setAttackTime1stSet(attackTime);
            currentPlayer.setAttackTime1stSet2ndHand(attackTime2ndHand);
        } else {
            currentPlayer.setAttackTime2ndSet(attackTime);
            currentPlayer.setAttackTime2ndSet2ndHand(attackTime2ndHand);
        }
        PlayerDisplayer.displayAttackTime();
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

    public static void updateLoad() {
        int load = StatsCalculator.calculateLoad(currentPlayer);
        currentPlayer.setLoad(load);
        int loadMax = StatsCalculator.calculateLoadMax(currentPlayer);
        currentPlayer.setLoadMax(loadMax);
        PlayerDisplayer.displayLoad();
    }

    public static void updateAll() {
        //all updates should be called here explicit or inside below methods
        updateStrength();
        updateEndurance();
        updateForm();
        updateVim();
        updateArm();
        updateEye();
        updateAgility();
        updateEfficiency();
        updateKnowledge();
        updateFocus();
        updateCharisma();
        updateIntelligence();
        updateSkillsExtra();
        for (SkillType skillType: SkillType.values()) {
            if (currentPlayer.getSkill(skillType) != null) {
                updateStatsFromSkill(skillType);
            }
        }
        updateHitPointsIncrease();
        updateActionsMax();
        updateParry();
        updateBlock();
        updateDodges();
        updateRange();
        updateAttackTime();
        updateArmors();
        updateResistances();
        updateLoad();
    }
}
