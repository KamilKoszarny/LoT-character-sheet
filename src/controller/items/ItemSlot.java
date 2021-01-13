package controller.items;

import javafx.scene.control.MenuButton;
import lombok.Getter;
import model.items.ItemType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static controller.Main.guiController;

@Getter
public enum ItemSlot {
    WEAPON_A(guiController.getWeaponA(), ItemType.WEAPON),
    WEAPON_B(guiController.getWeaponB(), ItemType.WEAPON),
    SHIELD_A(guiController.getShieldA(), ItemType.SHIELD, ItemType.WEAPON),
    SHIELD_B(guiController.getShieldB(), ItemType.SHIELD, ItemType.WEAPON),
    HELMET(guiController.getHelmet(), ItemType.HELMET),
    ARMOR(guiController.getArmor(), ItemType.ARMOR),
    GLOVES(guiController.getGloves(), ItemType.GLOVES),
    BOOTS(guiController.getBoots(), ItemType.BOOTS),
    AMULET(guiController.getAmulet(), ItemType.AMULET),
    RING1(guiController.getRing1(), ItemType.RING),
    RING2(guiController.getRing2(), ItemType.RING),
    BELT(guiController.getBelt(), ItemType.BELT),
    INVENTORY(guiController.getInventory()) //all types
    ;

    private final Set<ItemType> itemTypes;
    private final MenuButton menuButton;
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    ItemSlot(MenuButton menuButton, ItemType... itemTypes) {
        this.menuButton = menuButton;
        this.itemTypes = new HashSet<>(Arrays.asList(itemTypes));
        this.x = (int) menuButton.getLayoutX();
        this.y = (int) menuButton.getLayoutY();
        this.width = (int) menuButton.getWidth();
        this.height = (int) menuButton.getHeight();
    }

    public boolean itemTypeCompatible(ItemType itemType) {
        return this.equals(INVENTORY) || itemTypes.contains(itemType);
    }
}
