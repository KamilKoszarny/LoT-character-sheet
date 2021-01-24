package utils.aids;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @web http://java-buddy.blogspot.com/
 */
public class JavaFX_Lighting extends Application {

    @Override
    public void start(Stage primaryStage) {

        //Light.Distant: Represents a distant light source.
        Light.Distant light = new Light.Distant();
        light.setAzimuth(45);
        light.setElevation(45);
        light.setColor(Color.AZURE);
        Lighting lighting = new Lighting();
        lighting.setLight(light);
        lighting.setSurfaceScale(5.0);
        lighting.setDiffuseConstant(1.0);

        ColorPicker colorPicker = new ColorPicker(Color.AZURE);
        colorPicker.setOnAction(new EventHandler() {
            @Override
            public void handle(Event t) {
                light.setColor(colorPicker.getValue());
            }
        });

        Button btn = new Button("Button with Lighting");
        btn.setEffect(lighting);

        TextField textField = new TextField("TextField with Lighting");
        textField.setEffect(lighting);

        Text text = new Text("Text with lighting");
        text.setFont(Font.font ("Verdana", FontWeight.BOLD, 40));
        text.setFill(Color.WHITE);
        text.setEffect(lighting);

        Circle circle = new Circle(20,  Color.rgb(255,255,255));
        circle.setEffect(lighting);

        Rectangle rectangle = new Rectangle(50, 50, Color.rgb(255,255,255));
        rectangle.setEffect(lighting);

        ImageView imageView = new ImageView(new Image("http://goo.gl/kYEQl"));
        imageView.setEffect(lighting);

        HBox hBoxShape = new HBox();
        hBoxShape.getChildren().addAll(rectangle, circle, imageView);

        Label labelAzimuth = new Label("Azimuth: "
                + "the direction angle for the light source on the XY plane.");
        Slider sliderAzimuth = new Slider();
        sliderAzimuth.setMin(0);
        sliderAzimuth.setMax(360);
        sliderAzimuth.setValue(45);
        sliderAzimuth.setMajorTickUnit(90);
        sliderAzimuth.setMinorTickCount(3);
        sliderAzimuth.setShowTickLabels(true);
        sliderAzimuth.setShowTickMarks(true);
        sliderAzimuth.valueProperty().addListener(
                (ObservableValue<? extends Number> ov,
                 Number old_val, Number new_val) -> {
                    light.setAzimuth((Double)new_val);
                });

        Label labelElevation = new Label("Elevation: "
                + "the direction angle for the light source on the YZ plane.");
        Slider sliderElevation = new Slider();
        sliderElevation.setMin(0);
        sliderElevation.setMax(360);
        sliderElevation.setValue(45);
        sliderElevation.setMajorTickUnit(90);
        sliderElevation.setMinorTickCount(3);
        sliderElevation.setShowTickLabels(true);
        sliderElevation.setShowTickMarks(true);
        sliderElevation.valueProperty().addListener(
                (ObservableValue<? extends Number> ov,
                 Number old_val, Number new_val) -> {
                    light.setElevation((Double)new_val);
                });

        Label labelSurfaceScale = new Label("SurfaceScale");
        Slider sliderSurfaceScale = new Slider();
        sliderSurfaceScale.setMin(0);
        sliderSurfaceScale.setMax(10);
        sliderSurfaceScale.setValue(1.5);
        sliderSurfaceScale.setMajorTickUnit(1);
        sliderSurfaceScale.setMinorTickCount(2);
        sliderSurfaceScale.setShowTickLabels(true);
        sliderSurfaceScale.setShowTickMarks(true);
        sliderSurfaceScale.valueProperty().addListener(
                (ObservableValue<? extends Number> ov,
                 Number old_val, Number new_val) -> {
                    lighting.setSurfaceScale((Double)new_val);
                });

        Label labelDiffuse = new Label("DiffuseConstant");
        Slider sliderDiffuse = new Slider();
        sliderDiffuse.setMin(0);
        sliderDiffuse.setMax(2);
        sliderDiffuse.setValue(1);
        sliderDiffuse.setMajorTickUnit(1);
        sliderDiffuse.setMinorTickCount(4);
        sliderDiffuse.setShowTickLabels(true);
        sliderDiffuse.setShowTickMarks(true);
        sliderDiffuse.valueProperty().addListener(
                (ObservableValue<? extends Number> ov,
                 Number old_val, Number new_val) -> {
                    lighting.setDiffuseConstant((Double)new_val);
                });

        Label labelSpecularConstant = new Label("SpecularConstant");
        Slider sliderSpecularConstant = new Slider();
        sliderSpecularConstant.setMin(0);
        sliderSpecularConstant.setMax(2);
        sliderSpecularConstant.setValue(0);
        sliderSpecularConstant.setMajorTickUnit(1);
        sliderSpecularConstant.setMinorTickCount(4);
        sliderSpecularConstant.setShowTickLabels(true);
        sliderSpecularConstant.setShowTickMarks(true);
        sliderSpecularConstant.valueProperty().addListener(
                (ObservableValue<? extends Number> ov,
                 Number old_val, Number new_val) -> {
                    lighting.setSpecularConstant((Double)new_val);
                });

        Label labelSpecularExponent = new Label("SpecularExponent");
        Slider sliderSpecularExponent = new Slider();
        sliderSpecularExponent.setMin(0);
        sliderSpecularExponent.setMax(40);
        sliderSpecularExponent.setValue(0);
        sliderSpecularExponent.setMajorTickUnit(5);
        sliderSpecularExponent.setMinorTickCount(5);
        sliderSpecularExponent.setShowTickLabels(true);
        sliderSpecularExponent.setShowTickMarks(true);
        sliderSpecularExponent.valueProperty().addListener(
                (ObservableValue<? extends Number> ov,
                 Number old_val, Number new_val) -> {
                    lighting.setSpecularExponent((Double)new_val);
                });

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.getChildren().addAll(colorPicker, btn, text, textField, hBoxShape,
                labelAzimuth, sliderAzimuth, labelElevation, sliderElevation,
                labelSurfaceScale, sliderSurfaceScale, labelDiffuse, sliderDiffuse,
                labelSpecularConstant, sliderSpecularConstant,
                labelSpecularExponent, sliderSpecularExponent);

        StackPane root = new StackPane();
        root.getChildren().add(vBox);

        Scene scene = new Scene(root, 853, 480);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
