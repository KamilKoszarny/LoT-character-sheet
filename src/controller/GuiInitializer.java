package controller;

import GUI.GuiController;
import model.Proffesion;
import model.Race;
import model.Sign;

public class GuiInitializer {

    private static GuiController guiController;

    public static void init(GuiController guiController) {
        GuiInitializer.guiController = guiController;

        initProffesions();
        initRaces();
        initSigns();
    }

    private static void initProffesions() {
        guiController.getProffesion().getItems().addAll(Proffesion.values());
    }

    private static void initRaces() {
        guiController.getRace().getItems().addAll(Race.values());
    }

    private static void initSigns() {
        guiController.getSign().getItems().addAll(Sign.values());
    }
}
