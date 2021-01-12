package controller.items;

import javafx.scene.control.MenuButton;
import lombok.Getter;
import model.items.ItemType;

import static controller.Main.guiController;

@Getter
public enum ItemSlot {
    WEAPON_A(ItemType.WEAPON, guiController.getWeaponA()),
    WEAPON_B(ItemType.WEAPON, guiController.getWeaponB()),
    SHIELD_A(ItemType.SHIELD, guiController.getShieldA()),
    SHIELD_B(ItemType.SHIELD, guiController.getShieldB()),
    HELMET(ItemType.HELMET, guiController.getHelmet()),
    ARMOR(ItemType.ARMOR, guiController.getArmor()),
    GLOVES(ItemType.GLOVES, guiController.getGloves()),
    BOOTS(ItemType.BOOTS, guiController.getBoots()),
    AMULET(ItemType.AMULET, guiController.getAmulet()),
    RING1(ItemType.RING, guiController.getRing1()),
    RING2(ItemType.RING, guiController.getRing2()),
    BELT(ItemType.BELT, guiController.getBelt()),
    INVENTORY(null, guiController.getInventory()) //all types
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
        return this.equals(INVENTORY) || itemType.equals(this.itemType);
    }
}
