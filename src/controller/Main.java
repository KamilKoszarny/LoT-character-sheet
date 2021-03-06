package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    public static GuiController guiController;
    public static String version = "v0.3.4";

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoT Character Sheet.fxml"));
        Pane pane = loader.load();
        primaryStage.setTitle("Legacy of Tyrant: Karta postaci " + version);
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();

        GuiController guiController = loader.getController();
        Main.guiController = loader.getController();
        PlayerUpdater.init();
        GuiInitializer.init();
        PlayerSaveLoader.init(primaryStage, guiController);
        primaryStage.setX(10);
        primaryStage.setY(10);
        primaryStage.setWidth(742);
        primaryStage.setHeight(640);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
