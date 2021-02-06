package controller.items;

import javafx.scene.control.MenuButton;
import lombok.Getter;
import model.items.ItemType;

import java.util.Arrays;
import java.util.List;

import static controller.Main.guiController;

@Getter
public enum ItemSlot {
    WEAPON_1ST_SET(guiController.getWeaponA(), ItemType.WEAPON),
    WEAPON_2ND_SET(guiController.getWeaponB(), ItemType.WEAPON),
    SHIELD_1ST_SET(guiController.getShieldA(), ItemType.SHIELD, ItemType.WEAPON, ItemType.AMMUNITION),
    SHIELD_2ND_SET(guiController.getShieldB(), ItemType.SHIELD, ItemType.WEAPON, ItemType.AMMUNITION),
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

    private final List<ItemType> itemTypes;
    private final MenuButton menuButton;
    private final int x;
    private final int y;
    private final int width;
    private final int height;

    ItemSlot(MenuButton menuButton, ItemType... itemTypes) {
        this.menuButton = menuButton;
        this.itemTypes = Arrays.asList(itemTypes);
        this.x = (int) menuButton.getLayoutX();
        this.y = (int) menuButton.getLayoutY();
        this.width = (int) menuButton.getWidth();
        this.height = (int) menuButton.getHeight();
    }

    public boolean itemTypeCompatible(ItemType itemType) {
        return this.equals(INVENTORY) || itemTypes.contains(itemType);
    }

    public boolean itemTypeCompatibleStrict(ItemType itemType) {
        return this.equals(INVENTORY) || (itemTypes.get(0).equals(itemType));
    }
}
