package model.items;

import lombok.Getter;

@Getter
public enum WeaponModel {

    SHORT_SWORD(WeaponType.SWORD, 2, 4),
    SABER(WeaponType.SWORD, 2, 5),
    CHOPPER(WeaponType.SWORD, 3, 6),
    ADZE(WeaponType.AXE, 1, 4);

    private final WeaponType type;
    private final int dmgMin;
    private final int dmgMax;

    WeaponModel(WeaponType type, int dmgMin, int dmgMax) {
        this.type = type;
        this.dmgMin = dmgMin;
        this.dmgMax = dmgMax;
    }
}
