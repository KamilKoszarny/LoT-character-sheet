package controller;

import model.Player;

public class StatsCalculator {

    private static Player currentPlayer;

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
}
