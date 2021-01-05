package controller;

import GUI.GuiController;
import model.items.Weapon;
import model.items.WeaponModel;

public class ItemUpdater {

    private static GuiController guiController;

    public static void init(GuiController guiController) {
        ItemUpdater.guiController = guiController;
        initUpdating();
    }

    private static void initUpdating() {
        guiController.getShortSwordA().setOnAction(event -> {
            PlayerUpdater.getCurrentPlayer().setWeaponA(new Weapon(WeaponModel.SHORT_SWORD));
            PlayerUpdater.updateDmg();
        });
        guiController.getSaberA().setOnAction(event -> {
            PlayerUpdater.getCurrentPlayer().setWeaponA(new Weapon(WeaponModel.SABER));
            PlayerUpdater.updateDmg();
        });
        guiController.getChopperA().setOnAction(event -> {
            PlayerUpdater.getCurrentPlayer().setWeaponA(new Weapon(WeaponModel.CHOPPER));
            PlayerUpdater.updateDmg();
        });
        guiController.getAdzeA().setOnAction(event -> {
            PlayerUpdater.getCurrentPlayer().setWeaponA(new Weapon(WeaponModel.ADZE));
            PlayerUpdater.updateDmg();
        });
    }

}
