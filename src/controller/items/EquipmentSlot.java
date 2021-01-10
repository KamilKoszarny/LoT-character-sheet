package controller.items;

import lombok.Getter;

@Getter
public enum EquipmentSlot {
    WEAPON_A(181, 56, 67, 137),
    WEAPON_B(85, 56, 67, 137);

    private int x;
    private int y;
    private int width;
    private int height;

    EquipmentSlot(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
