package controller.items;

import javafx.scene.control.MenuButton;
import lombok.Getter;
import model.items.ItemType;

import static controller.Main.guiController;

@Getter
public enum ItemSlot {
    WEAPON_A(ItemType.WEAPON, guiController.getWeaponA()),
    WEAPON_B(ItemType.WEAPON, guiController.getWeaponB()),
    HELMET(ItemType.HELMET, guiController.getHelmet()),
    INVENTORY(null, guiController.getInventory())
    ;

    private final ItemType itemType;
    private final MenuButton menuButton;
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    ItemSlot(ItemType itemType, MenuButton menuButton) {
        this.itemType = itemType;
        this.menuButton = menuButton;
        this.x = (int) menuButton.getLayoutX();
        this.y = (int) menuButton.getLayoutY();
        this.width = (int) menuButton.getWidth();
        this.height = (int) menuButton.getHeight();
    }

    public boolean itemTypeCompatible(ItemType itemType) {
        return itemType.equals(this.itemType);
    }
}