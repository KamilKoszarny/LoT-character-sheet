package utils;

import controller.PlayerDisplayer;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Node;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GraphicUtils {

    public static void addMagicColor(Node node, Color color) {
        Lighting lighting = new Lighting();
        lighting.setDiffuseConstant(2.0);
        lighting.setSpecularConstant(0.0);
        lighting.setSpecularExponent(0.0);
        lighting.setSurfaceScale(0.0);
        lighting.setLight(new Light.Distant(45, 45, color));
        node.setEffect(lighting);
    }

    public static Image addBrokenIcon(Image image, double durabilityRatio) {
        if (durabilityRatio <= PlayerDisplayer.DURABILITY_RATIO_FOR_ICON_DISPLAY) {
            BufferedImage mergedImage = SwingFXUtils.fromFXImage(image, null);
            Graphics graphics = mergedImage.getGraphics();

            BufferedImage breakIcon = SwingFXUtils.fromFXImage(new Image("icons/shield-broken.png"), null);
            int iconSize = 30;
            setBrokenColor(breakIcon, durabilityRatio);

            graphics.drawImage(breakIcon, (int) image.getWidth() - iconSize, 0, iconSize, iconSize, null);
            graphics.dispose();

            return SwingFXUtils.toFXImage(mergedImage, null);
        } else {
            return image;
        }
    }

    private static void setBrokenColor(BufferedImage image, double durabilityRatio) {
        durabilityRatio = Math.max(durabilityRatio, 0);
        int red = (int) (255 - 100 * durabilityRatio/PlayerDisplayer.DURABILITY_RATIO_FOR_ICON_DISPLAY);
        int green = (int) (150 * durabilityRatio/PlayerDisplayer.DURABILITY_RATIO_FOR_ICON_DISPLAY);
        int blue = 0;
        java.awt.Color color = new java.awt.Color(red, green, blue);

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int originalColor = image.getRGB(x, y);
                if (originalColor != 0) { //not transparent
                    image.setRGB(x, y, color.getRGB());
                }
            }
        }
    }

    public static Color mixColors(Color color1, Color color2) {
        double red = (color1.getRed() + color2.getRed()) / 2;
        double green = (color1.getGreen() + color2.getGreen()) / 2;
        double blue = (color1.getBlue() + color2.getBlue()) / 2;
        double opacity = (color1.getOpacity() + color2.getOpacity()) / 2;
        return new Color(red, green, blue, opacity);
    }
}
