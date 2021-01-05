package controller;

import model.Player;

public class StatsCalculator {

    protected static int calculateStrength(Player player) {
        int strength = player.getStrengthBase();
        return strength;
    }

    protected static int calculateDmgAMin(Player player) {
        int dmgAMinBase = player.getWeaponA() == null ? 1 : player.getWeaponA().getDmgMin();
        int dmgAMin = (int) Math.round(dmgAMinBase * (1 + player.getStrength()/50.));
        return dmgAMin;
    }

    protected static int calculateDmgAMax(Player player) {
        int dmgAMaxBase = player.getWeaponA() == null ? 2 : player.getWeaponA().getDmgMax();
        int dmgAMax = (int) Math.round(dmgAMaxBase * (1 + player.getStrength()/50.));
        return dmgAMax;
    }

    protected static int calculateEndurance(Player player) {
        int endurance = player.getEnduranceBase();
        return endurance;
    }

    protected static int calculateArmorHead(Player player) {
        int armorHead = (int) Math.round(player.getEndurance()/20.);
        return armorHead;
    }

    protected static int calculateArmorBody(Player player) {
        int armorBody = (int) Math.round(player.getEndurance()/20.);
        return armorBody;
    }

    protected static int calculateArmorArms(Player player) {
        int armorArms = (int) Math.round(player.getEndurance()/20.);
        return armorArms;
    }

    protected static int calculateArmorLegs(Player player) {
        int armorLegs = (int) Math.round(player.getEndurance()/20.);
        return armorLegs;
    }

    protected static int calculateForm(Player player) {
        int form = player.getFormBase();
        return form;
    }

    protected static int calculateVim(Player player) {
        int vim = (int) Math.round((player.getStrengthBase() + player.getEnduranceBase() + player.getFormBase()) / 3.);
        return vim;
    }

    protected static int calculateArm(Player player) {
        int arm = player.getArmBase();
        return arm;
    }

    protected static int calculateHitA(Player player) {
        int hitA = 50 + player.getArm();
        return hitA;
    }

    protected static int calculateEye(Player player) {
        int eye = player.getEyeBase();
        return eye;
    }

    protected static int calculateAgility(Player player) {
        int agility = player.getAgilityBase();
        return agility;
    }

    protected static int calculateDodgeA(Player player) {
        int dodge = (int) Math.round(player.getAgility() / 2.);
        return dodge;
    }

    protected static int calculateEfficiency(Player player) {
        int efficiency = (int) Math.round((player.getArmBase() + player.getEyeBase() + player.getAgilityBase()) / 3.);
        return efficiency;
    }

    protected static int calculateKnowledge(Player player) {
        int knowledge = player.getKnowledgeBase();
        return knowledge;
    }

    protected static int calculateFocus(Player player) {
        int focus = player.getFocusBase();
        return focus;
    }

    protected static int calculateManaIncrease(Player player) {
        int manaIncrease = (int) Math.round(player.getFocus() / 5.);
        return manaIncrease;
    }

    protected static int calculateCharisma(Player player) {
        int charisma = player.getCharismaBase();
        return charisma;
    }

    protected static int calculateIntelligence(Player player) {
        int intelligence = (int) Math.round((player.getKnowledgeBase() + player.getFocusBase() + player.getCharismaBase()) / 3.);
        return intelligence;
    }
}
