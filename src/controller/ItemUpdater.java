package controller;

import GUI.GuiController;
import model.Player;
import model.items.Weapon;
import model.items.WeaponModel;

public class ItemUpdater {

    private static Player currentPlayer;

    private static GuiController guiController;

    public static void init(Player currentPlayer, GuiController guiController) {
        ItemUpdater.currentPlayer = currentPlayer;
        ItemUpdater.guiController = guiController;
        initUpdating();
    }

    private static void initUpdating() {
        guiController.getShortSwordA().setOnAction(event -> {
            currentPlayer.setWeaponA(new Weapon(WeaponModel.SHORT_SWORD));
            PlayerUpdater.updateDmg();
        });
        guiController.getSaberA().setOnAction(event -> {
            currentPlayer.setWeaponA(new Weapon(WeaponModel.SABER));
            PlayerUpdater.updateDmg();
        });
        guiController.getChopperA().setOnAction(event -> {
            currentPlayer.setWeaponA(new Weapon(WeaponModel.CHOPPER));
            PlayerUpdater.updateDmg();
        });
        guiController.getAdzeA().setOnAction(event -> {
            currentPlayer.setWeaponA(new Weapon(WeaponModel.ADZE));
            PlayerUpdater.updateDmg();
        });
    }

}
