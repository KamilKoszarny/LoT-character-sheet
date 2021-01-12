package model.items;

import lombok.Getter;

@Getter
public enum BootsModel {

    RAG_BOOTS(     0, 2, 3, 0, "Szmaciane buty"),
    LEATHER_BOOTS( 1, 3, 6, 0, "Skórzane buty"),
    CHAIN_BOOTS(   2, 5, 9, 0, "Kolcze buty"),
    STEEL_BOOTS(   4, 7, 16, -5, "Stalowe buty"),
    PLATE_BOOTS(   3, 5, 13, -2, "Płytowe buty"),
    ;

    private final int armor;
    private final int weight;
    private final int durability;
    private final int agilityModifier;
    private final String namePL;

    BootsModel(int armor, int weight, int durability, int agilityModifier, String namePL) {
        this.armor = armor;
        this.weight = weight;
        this.durability = durability;
        this.agilityModifier = agilityModifier;
        this.namePL = namePL;
    }

}
