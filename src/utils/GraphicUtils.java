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

    public static Color mixColors(Color color1, Color color2) {
        double red = (color1.getRed() + color2.getRed()) / 2;
        double green = (color1.getGreen() + color2.getGreen()) / 2;
        double blue = (color1.getBlue() + color2.getBlue()) / 2;
        double opacity = (color1.getOpacity() + color2.getOpacity()) / 2;
        return new Color(red, green, blue, opacity);
    }
}
