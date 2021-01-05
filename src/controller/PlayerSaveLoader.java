package controller;

import GUI.GuiController;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Player;

import java.io.*;

public class PlayerSaveLoader {

    private static Stage primaryStage;
    private static MenuItem saveAsButton;
    private static MenuItem openButton;

    public static void init(Stage primaryStage, GuiController guiController) {
        PlayerSaveLoader.primaryStage = primaryStage;
        PlayerSaveLoader.saveAsButton = guiController.getSaveAs();
        PlayerSaveLoader.openButton = guiController.getOpen();
        initOpenButton();
        initSaveAsButton();
    }

    static void initOpenButton() {
        openButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file == null) return;
            try {
                FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                Player player = (Player) objectIn.readObject();
                PlayerUpdater.loadPlayer(player);
                fileIn.close();
                objectIn.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    static void initSaveAsButton() {
        saveAsButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showSaveDialog(primaryStage);
            if (file == null) return;
            try {
                FileOutputStream fileOut = new FileOutputStream(file);
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                objectOut.writeObject(PlayerUpdater.getCurrentPlayer());
                fileOut.close();
                objectOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
