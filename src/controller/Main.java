package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    public static GuiController guiController;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoT Character Sheet.fxml"));
        Pane pane = loader.load();
        primaryStage.setTitle("Legacy of Tyrant: Karta postaci");
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();

        GuiController guiController = loader.getController();
        Main.guiController = loader.getController();
        GuiInitializer.init();
        PlayerUpdater.init();
        PlayerSaveLoader.init(primaryStage, guiController);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
