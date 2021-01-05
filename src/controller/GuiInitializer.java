package controller;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Proffesion;
import model.Race;
import model.Sign;
import model.items.Weapon;
import model.items.WeaponModel;
import model.items.WeaponType;

public class GuiInitializer {

    private static GuiController guiController;

    public static void init(GuiController guiController) {
        GuiInitializer.guiController = guiController;

        initProffesions();
        initRaces();
        initSigns();

        initWeaponAMenu();
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

    private static void initWeaponAMenu() {
        MenuButton button = guiController.getWeaponAMenu();

        button.lookup(".arrow-button" ).setStyle( "-fx-padding: 0" );
        button.lookup(".arrow" ).setStyle( "-fx-background-insets: 0; -fx-padding: 0; -fx-shape: null;" );

        for (WeaponType weaponType: WeaponType.values()) {
            Menu menu = new Menu();
            menu.setText(weaponType.getNamePL());
            for (WeaponModel weaponModel: WeaponModel.values()) {
                if (weaponModel.getType().equals(weaponType)) {
                    MenuItem menuItem = new MenuItem();
                    menuItem.setText(weaponModel.getNamePL());
                    menuItem.setOnAction(event -> {
                        PlayerUpdater.getCurrentPlayer().setWeaponA(new Weapon(weaponModel));
                        PlayerUpdater.updateDmg();
                        PlayerUpdater.updateHits();
                        displayWeaponA(weaponModel);
                    });
                    menu.getItems().add(menuItem);
                }
            }
            button.getItems().add(menu);
        }
    }

    private static void displayWeaponA(WeaponModel weaponModel) {
        MenuButton button = guiController.getWeaponAMenu();
        Image img = new Image("images/weapons/" + weaponModel.name() + ".png");
        ImageView view = new ImageView(img);
        button.setGraphic(view);
        button.setOpacity(1);
    }
}
