package controller;

import model.Player;

public class StatsCalculator {

    protected static int calculateStrength(Player player) {
        int strength = player.getStrengthBase();
        return strength;
    }

    protected static int calculateEndurance(Player player) {
        int endurance = player.getEnduranceBase();
        return endurance;
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

    protected static int calculateEye(Player player) {
        int eye = player.getEyeBase();
        return eye;
    }

    protected static int calculateAgility(Player player) {
        int agility = player.getAgilityBase();
        return agility;
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

    protected static int calculateCharisma(Player player) {
        int charisma = player.getCharismaBase();
        return charisma;
    }

    protected static int calculateIntelligence(Player player) {
        int intelligence = (int) Math.round((player.getKnowledgeBase() + player.getFocusBase() + player.getCharismaBase()) / 3.);
        return intelligence;
    }
}
