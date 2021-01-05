package model.items;

import lombok.Getter;

@Getter
public enum WeaponModel {

    SHORT_SWORD(WeaponType.SWORD, "Krótki miecz", 2, 4),
    SABER(WeaponType.SWORD, "Szabla", 2, 5),
    CHOPPER(WeaponType.SWORD, "Tasak", 3, 6),
    ADZE(WeaponType.AXE, "Siekiera", 1, 4);

    private final WeaponType type;
    private final String namePL;
    private final int dmgMin;
    private final int dmgMax;

    WeaponModel(WeaponType type, String namePL, int dmgMin, int dmgMax) {
        this.type = type;
        this.namePL = namePL;
        this.dmgMin = dmgMin;
        this.dmgMax = dmgMax;
    }
}
