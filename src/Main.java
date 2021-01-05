import GUI.GuiController;
import controller.PlayerSaveLoader;
import controller.PlayerUpdater;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI/LoT Character Sheet.fxml"));
        Pane pane = loader.load();
        primaryStage.setTitle("Legacy of Tyrant: Karta postaci");
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();

        GuiController guiController = loader.getController();
        PlayerUpdater.init(guiController);
        PlayerSaveLoader.init(primaryStage, guiController);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
