package model.items;

import lombok.Getter;

@Getter
public enum ArmorModel {

    LEATHER_SHIRT(      0, 1, 1, 0, 6, 12, "Skórzana koszula"),
    GAMBISON(           0, 1, 1, 1, 8, 8, "Przeszywanica"),
    LEATHER_ARMOR(      0, 2, 1, 0, 10, 16, "Skórzana zbroja"),
    STUDDED_ARMOR(      0, 3, 0, 1, 11, 19, "Ćwiekowana zbroja"),
    CHAIN_SHIRT(        0, 4, 3, 0, 20, 23, "Kolcza koszula"),
    SCALE_SHIRT(        0, 5, 2, 0, 18, 27, "Zbroja łuskowa"),
    HAUBERK(            0, 4, 3, 2, 28, 25, "Kolczuga"),
    LIGHT_PLATE_ARMOR(  0, 5, 2, 2, 20, 26, "Lekka płytówka"),
    BREASTPLATE(        0, 7, 0, 0, 16, 30, "Napierśnik"),
    TOURNAMENT_ARMOR(   0, 5, 4, 2, 23, 35, "Zbroja turniejowa"),
    GUARDIAN_ARMOR(     1, 6, 4, 3, 26, 40, "Zbroja strażnika"),
    FULL_PLATE_ARMOR(   0, 7, 4, 4, 30, 40, "Pełna płytówka"),
    FORGED_ARMOR(       2, 9, 4, 1, 36, 50, "Kuta zbroja");

    private final int headArmor;
    private final int bodyArmor;
    private final int armsArmor;
    private final int legsArmor;
    private final int weight;
    private final int durability;
    private final String namePL;

    ArmorModel(int headArmor, int bodyArmor, int armsArmor, int legsArmor, int weight, int durability, String namePL) {
        this.headArmor = headArmor;
        this.bodyArmor = bodyArmor;
        this.armsArmor = armsArmor;
        this.legsArmor = legsArmor;
        this.weight = weight;
        this.durability = durability;
        this.namePL = namePL;
    }
}
