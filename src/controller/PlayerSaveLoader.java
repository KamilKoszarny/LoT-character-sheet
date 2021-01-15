package controller;

import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Player;

import java.io.*;

public class PlayerSaveLoader {

    private static Stage primaryStage;
    private static MenuItem saveButton;
    private static MenuItem saveAsButton;
    private static MenuItem openButton;
    private static FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Legacy of Tyrant Character Sheet", "*.lotcs");
    private static File file;
    private static File directory;

    public static void init(Stage primaryStage, GuiController guiController) {
        PlayerSaveLoader.primaryStage = primaryStage;
        PlayerSaveLoader.saveButton = guiController.getSave();
        PlayerSaveLoader.saveAsButton = guiController.getSaveAs();
        PlayerSaveLoader.openButton = guiController.getOpen();
        initOpenButton();
        initSaveButton();
        initSaveAsButton();
    }

    static void initOpenButton() {
        openButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(extensionFilter);
            if (directory != null) {
                fileChooser.setInitialDirectory(directory);
            }
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file == null) return;
            try {
                FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                Player player = (Player) objectIn.readObject();
                PlayerUpdater.loadPlayer(player);
                fileIn.close();
                objectIn.close();
                PlayerSaveLoader.file = file;
                directory = file.getParentFile();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    static void initSaveAsButton() {
        saveAsButton.setOnAction(event -> saveAsAction());
    }

    private static void saveAsAction() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(extensionFilter);
        if (directory != null) {
            fileChooser.setInitialDirectory(directory);
        }
        File file = fileChooser.showSaveDialog(primaryStage);
        if (file == null) return;
        try {
            save(file);
            PlayerSaveLoader.file = file;
            directory = file.getParentFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void initSaveButton() {
        saveButton.setOnAction(event -> {
            if (file == null || directory == null) {
                saveAsAction();
            }
            try {
                save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private static void save(File file) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(file);
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(PlayerUpdater.getCurrentPlayer());
        fileOut.close();
        objectOut.close();
    }
}
