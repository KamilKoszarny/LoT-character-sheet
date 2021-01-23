package utils;

import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class GraphicUtils {

    public static void addMagicColor(ImageView imageView, Color color) {
        Lighting lighting = new Lighting();
        lighting.setDiffuseConstant(2.0);
        lighting.setSpecularConstant(0.0);
        lighting.setSpecularExponent(0.0);
        lighting.setSurfaceScale(0.0);
        lighting.setLight(new Light.Distant(45, 45, color));
        imageView.setEffect(lighting);
    }
}
