package controller;

import controller.items.ItemSlot;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import model.Ability;
import model.Profession;
import model.Skill;
import model.horses.Horse;

import static controller.Main.guiController;
import static controller.PlayerUpdater.currentPlayer;

public class PlayerDisplayer {

    public static final double DURABILITY_RATIO_FOR_ICON_DISPLAY = 0.3;

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
        } else {
            description.setText(null);
        }
    }

    public static void displayTraits() {
        if (currentPlayer.getRace() != null) {
            guiController.getTraitRaceDescription().setText(currentPlayer.getRace().getTraitDescription());
        }
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
        if (currentPlayer.getProfession() == null) return;

        final Profession lvl1Profession = currentPlayer.getProfession().getLvl1Profession();
        guiController.getAbilityI0().setText(Ability.findAbility(lvl1Profession, 0).getNamePL());
        guiController.getAbilityI1().setText(Ability.findAbility(lvl1Profession, 1).getNamePL());
        guiController.getAbilityI2().setText(Ability.findAbility(lvl1Profession, 2).getNamePL());
        guiController.getAbilityI0Description().setText(Ability.findAbility(lvl1Profession, 0).getDescriptionPL());
        guiController.getAbilityI1Description().setText(Ability.findAbility(lvl1Profession, 1).getDescriptionPL());
        guiController.getAbilityI2Description().setText(Ability.findAbility(lvl1Profession, 2).getDescriptionPL());
        guiController.getAbilityI1Time().setText(currentPlayer.getAbilityI1Time());
        guiController.getAbilityI2Time().setText(currentPlayer.getAbilityI2Time());

        if (currentPlayer.getProfession().getLevel() >= 2) {
            guiController.getAbilitiesII().setVisible(true);
            final Profession lvl2Profession = currentPlayer.getProfession().getLvl2Profession();
            guiController.getAbilityII0().setText(Ability.findAbility(lvl2Profession, 0).getNamePL());
            guiController.getAbilityII1().setText(Ability.findAbility(lvl2Profession, 1).getNamePL());
            guiController.getAbilityII2().setText(Ability.findAbility(lvl2Profession, 2).getNamePL());
            guiController.getAbilityII0Description().setText(Ability.findAbility(lvl2Profession, 0).getDescriptionPL());
            guiController.getAbilityII1Description().setText(Ability.findAbility(lvl2Profession, 1).getDescriptionPL());
            guiController.getAbilityII2Description().setText(Ability.findAbility(lvl2Profession, 2).getDescriptionPL());
            guiController.getAbilityII1Time().setText(currentPlayer.getAbilityII1Time());
            guiController.getAbilityII2Time().setText(currentPlayer.getAbilityII2Time());
        } else {
            guiController.getAbilitiesII().setVisible(false);
        }

        if (currentPlayer.getProfession().getLevel() == 3) {
            guiController.getAbilitiesIII().setVisible(true);
            final Profession lvl3Profession = currentPlayer.getProfession();
            guiController.getAbilityIII0().setText(Ability.findAbility(lvl3Profession, 0).getNamePL());
            guiController.getAbilityIII1().setText(Ability.findAbility(lvl3Profession, 1).getNamePL());
            guiController.getAbilityIII2().setText(Ability.findAbility(lvl3Profession, 2).getNamePL());
            guiController.getAbilityIII0Description().setText(Ability.findAbility(lvl3Profession, 0).getDescriptionPL());
            guiController.getAbilityIII1Description().setText(Ability.findAbility(lvl3Profession, 1).getDescriptionPL());
            guiController.getAbilityIII2Description().setText(Ability.findAbility(lvl3Profession, 2).getDescriptionPL());
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
        guiController.getActions().setText("" + currentPlayer.getActions() + '/' + (currentPlayer.getActionsMax() + currentPlayer.getActionsMaxExtra()));
    }

    public static void displayMana() {
        guiController.getMana().setText("" + currentPlayer.getMana() + '/' + currentPlayer.getManaMax());
    }

    public static void displayDmg() {
        String dmgAText = "" + currentPlayer.getDmg1stSetMin() + "-" + currentPlayer.getDmg1stSetMax();
        dmgAText += writeDmgExtra(currentPlayer.getDmg1stSetFire(), currentPlayer.getDmg1stSetCold(), currentPlayer.getDmg1stSetWind(), currentPlayer.getDmg1stSetEarth(), currentPlayer.getDmg1stSetMagic());
        if (currentPlayer.getItem(ItemSlot.SHIELD_1ST_SET) != null) {
            dmgAText += "/" + currentPlayer.getDmg1stSet2ndHandMin() + "-" + currentPlayer.getDmg1stSet2ndHandMax();
            dmgAText += writeDmgExtra(currentPlayer.getDmg1stSet2ndHandFire(), currentPlayer.getDmg1stSet2ndHandCold(), currentPlayer.getDmg1stSet2ndHandWind(), currentPlayer.getDmg1stSet2ndHandEarth(), currentPlayer.getDmg1stSet2ndHandMagic());
        }
        guiController.getDmgA().setText(dmgAText);

        String dmgBText = "" + currentPlayer.getDmg2ndSetMin() + "-" + currentPlayer.getDmg2ndSetMax();
        dmgBText += writeDmgExtra(currentPlayer.getDmg2ndSetFire(), currentPlayer.getDmg2ndSetCold(), currentPlayer.getDmg2ndSetWind(), currentPlayer.getDmg2ndSetEarth(), currentPlayer.getDmg2ndSetMagic());
        if (currentPlayer.getItem(ItemSlot.SHIELD_2ND_SET) != null) {
            dmgBText += "/" + currentPlayer.getDmg2ndSet2ndHandMin() + "-" + currentPlayer.getDmg2ndSet2ndHandMax();
            dmgBText += writeDmgExtra(currentPlayer.getDmg2ndSet2ndHandFire(), currentPlayer.getDmg2ndSet2ndHandCold(), currentPlayer.getDmg2ndSet2ndHandWind(), currentPlayer.getDmg2ndSet2ndHandEarth(), currentPlayer.getDmg2ndSet2ndHandMagic());
        }
        guiController.getDmgB().setText(dmgBText);
    }


    private static String writeDmgExtra(int dmgFire, int dmgCold, int dmgWind, int dmgEarth, int dmgMagic) {
        StringBuilder dmgExtra = new StringBuilder();
        if (dmgFire != 0) {
            dmgExtra.append(" +k").append(dmgFire).append("og.");
        }
        if (dmgCold != 0) {
            dmgExtra.append(" +k").append(dmgCold).append("zim.");
        }
        if (dmgWind != 0) {
            dmgExtra.append(" +k").append(dmgWind).append("pow.");
        }
        if (dmgEarth != 0) {
            dmgExtra.append(" +2/k").append(dmgEarth).append("tr.");
        }
        if (dmgMagic != 0) {
            dmgExtra.append(" +").append(dmgMagic).append("% mag.");
        }
        return dmgExtra.toString();
    }

    public static void displayHit() {
        String hitAText = "" + currentPlayer.getHit1stSet();
        if (currentPlayer.getWeapon1stSet2ndHand() != null) {
            hitAText += "/" + currentPlayer.getHit1stSet2ndHand();
        }
        guiController.getHitA().setText(hitAText);
        String hitBText = "" + currentPlayer.getHit2ndSet();
        if (currentPlayer.getWeapon2ndSet2ndHand() != null) {
            hitBText += "/" + currentPlayer.getHit2ndSet2ndHand();
        }
        guiController.getHitB().setText(hitBText);
    }

    public static void displayParry() {
        guiController.getParryA().setText(Integer.toString(currentPlayer.getParry1stSet()));
        guiController.getParryB().setText(Integer.toString(currentPlayer.getParry2ndSet()));
    }

    public static void displayBlock() {
        guiController.getBlockA().setText(Integer.toString(currentPlayer.getBlock1stSet()));
        guiController.getBlockB().setText(Integer.toString(currentPlayer.getBlock2ndSet()));
    }

    public static void displayDodge() {
        guiController.getDodgeA().setText(Integer.toString(currentPlayer.getDodge1stSet()));
        guiController.getDodgeB().setText(Integer.toString(currentPlayer.getDodge2ndSet()));
    }

    public static void displayRange() {
        String rangeAText = "" + currentPlayer.getRange1stSet();
        if (currentPlayer.getWeapon1stSet2ndHand() != null) {
            rangeAText += "/" + currentPlayer.getRange1stSet2ndHand();
        }
        guiController.getRangeA().setText(rangeAText);
        String rangeBText = "" + currentPlayer.getRange2ndSet();
        if (currentPlayer.getWeapon2ndSet2ndHand() != null) {
            rangeBText += "/" + currentPlayer.getRange2ndSet2ndHand();
        }
        guiController.getRangeB().setText(rangeBText);
    }

    public static void displayAttackTime() {
        String attackTimeAText = "" + currentPlayer.getAttackTime1stSet();
        if (currentPlayer.getWeapon1stSet2ndHand() != null) {
            attackTimeAText += "/" + currentPlayer.getAttackTime1stSet2ndHand();
        }
        guiController.getTimeA().setText(attackTimeAText);
        String attackTimeBText = "" + currentPlayer.getAttackTime2ndSet();
        if (currentPlayer.getWeapon2ndSet2ndHand() != null) {
            attackTimeBText += "/" + currentPlayer.getAttackTime2ndSet2ndHand();
        }
        guiController.getTimeB().setText(attackTimeBText);
    }

    public static void displayArmors() {
        guiController.getArmorHead().setText(Integer.toString(currentPlayer.getArmorHead()));
        guiController.getArmorBody().setText(Integer.toString(currentPlayer.getArmorBody()));
        guiController.getArmorArms().setText(Integer.toString(currentPlayer.getArmorArms()));
        guiController.getArmorLegs().setText(Integer.toString(currentPlayer.getArmorLegs()));
    }

    public static void displayResistances() {
        guiController.getResistFire().setText(Integer.toString(currentPlayer.getResistFire()));
        guiController.getResistCold().setText(Integer.toString(currentPlayer.getResistCold()));
        guiController.getResistWind().setText(Integer.toString(currentPlayer.getResistWind()));
        guiController.getResistEarth().setText(Integer.toString(currentPlayer.getResistEarth()));
        guiController.getResistMagic().setText(Integer.toString(currentPlayer.getResistMagic()));
        guiController.getResistBodyIllness().setText(Integer.toString(currentPlayer.getResistBodyIllness()));
        guiController.getResistMindIllness().setText(Integer.toString(currentPlayer.getResistMindIllness()));
    }

    public static void displayLoad() {
        guiController.getLoad().setText("" + (currentPlayer.getLoad() + currentPlayer.getLoadExtra()) + "/" + currentPlayer.getLoadMax());
        guiController.getLoadExtra().setText(Integer.toString(currentPlayer.getLoadExtra()));
    }

    public static void displayHorse() {
        Horse horse = currentPlayer.getHorse();
        if (horse != null) {
            guiController.getHorseType().getSelectionModel().select(horse.getType());
            guiController.getHorseName().setText(horse.getName());
            guiController.getHorseHitPoints().setText("" + horse.getHitPoints() + "/" + horse.getHitPointsMax());
            guiController.getHorseRiding().setText(Integer.toString(horse.getRiding()));
            guiController.getHorseState().setText(horse.getState());
            guiController.getHorseEquipment().setText(horse.getEquipmentStr());
        } else {
            guiController.getHorseName().setText(null);
            guiController.getHorseHitPoints().setText(null);
            guiController.getHorseRiding().setText(null);
            guiController.getHorseState().setText(null);
            guiController.getHorseEquipment().setText(null);
        }
    }

    private static void displayIdentity() {
        guiController.getProfession().getSelectionModel().select(currentPlayer.getProfession());
        guiController.getRace().getSelectionModel().select(currentPlayer.getRace());
        guiController.getSign().getSelectionModel().select(currentPlayer.getSign());
        guiController.getFullname().setText(currentPlayer.getFullname());
        guiController.getAge().setText(currentPlayer.getAge());
        guiController.getHeight().setText(currentPlayer.getHeight());
        guiController.getWeight().setText(currentPlayer.getWeight());
        guiController.getReligion().setText(currentPlayer.getReligion());
        guiController.getOrigin().setText(currentPlayer.getOrigin());
        guiController.getFamily().setText(currentPlayer.getFamily());
        guiController.getAppearance().setText(currentPlayer.getAppearance());
        guiController.getHistory().setText(currentPlayer.getHistory());
    }

    private static void displayAttributes() {
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
    }

    public static void displayAllNotAuto() {
        displayIdentity();

        displayAttributes();

        if (currentPlayer.getSign() != null) {
            guiController.getSignNumber().setText(String.valueOf(currentPlayer.getSign().getNumber()));
        }
        guiController.getLuckPoints().setText(Integer.toString(currentPlayer.getLuckPoints()));
        guiController.getExperiencePoints().setText(Integer.toString(currentPlayer.getExperiencePoints()));

        displaySkills();
        displayTraits();
        displayAbilities();
        guiController.getOther().setText(currentPlayer.getOther());

        displayHitPoints();
        displayActions();
        displayMana();
        guiController.getHitPointsIncrease().setText(Integer.toString(currentPlayer.getHitPointsIncrease()));
        guiController.getSpeed().setText(Integer.toString(currentPlayer.getSpeed()));
        guiController.getManaIncrease().setText(Integer.toString(currentPlayer.getManaIncrease()));
        displayDmg();
        displayParry();
        displayBlock();
        displayDodge();
        displayHit();
        displayRange();
        displayAttackTime();
        displayDodge();
        displayArmors();
        displayResistances();

        displayHorse();

        ItemsDisplayer.displayEquipment();
        ItemsDisplayer.displayInventory();
        guiController.getExtraInventory().setText(currentPlayer.getExtraInventory());
        displayLoad();
        guiController.getGold().setText(currentPlayer.getGold());
        guiController.getBankGold().setText(currentPlayer.getBankGold());

        guiController.getSatiety().setText(currentPlayer.getSatiety());
        guiController.getAlertness().setText(currentPlayer.getAlertness());
        guiController.getIllnesses().setText(currentPlayer.getIllnesses());
        guiController.getState().setText(currentPlayer.getState());
        guiController.getNotes().setText(currentPlayer.getNotes());

        EquipmentGuiInitializer.updateTooltips();
    }
}
