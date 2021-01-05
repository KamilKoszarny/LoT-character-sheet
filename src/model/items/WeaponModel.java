package model.items;

import lombok.Getter;

@Getter
public enum WeaponModel {

    SHORT_SWORD(WeaponType.SWORD, "Krótki miecz", 2, 4),
    SABRE(WeaponType.SWORD, "Szabla", 2, 5),
    CHOPPER(WeaponType.SWORD, "Tasak", 3, 6),
    ADZE(WeaponType.AXE, "Siekiera", 1, 4),
    AXE_1H(WeaponType.AXE, "Topór (1 ręka)", 2, 5),
    AXE_2H(WeaponType.AXE, "Topór (2 ręce)", 4, 7),
    TWO_SIDE_AXE(WeaponType.AXE, "Obustronny topór", 3, 6),
    CUDGEL(WeaponType.MACE, "Pałka", 1, 3),
    HAMMER(WeaponType.MACE, "Młot bojowy", 3, 5),
    SPIKE_CLUB(WeaponType.MACE, "Kolczasta maczuga", 2, 4),
    MACE(WeaponType.MACE, "Buława", 3, 5),
    KNIFE(WeaponType.SHORT, "Nóż", 2, 3),
    DAGGER(WeaponType.SHORT, "Sztylet", 2, 4),
    SPEAR(WeaponType.LONG, "Włócznia", 3, 6),
    TRIDENT(WeaponType.LONG, "Trójząb", 4, 6),
    THROWING_KNIFE(WeaponType.THROWING, "Nóż do rzucania", 2, 3),
    THROWING_AXE(WeaponType.THROWING, "Toporek do rzucania", 1, 4),
    SHORT_BOW(WeaponType.BOW, "Krótki łuk", 2, 5),
    HUNTER_BOW(WeaponType.BOW, "Myśliwski łuk", 3, 6),
    LIGHT_CROSSBOW(WeaponType.CROSSBOW, "Lekka kusza", 4, 7),
    CROSSBOW(WeaponType.CROSSBOW, "Kusza", 6, 9);

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
