package model.items;

import lombok.Getter;

@Getter
public enum GlovesModel {

    RAG_GLOVES(     0, 2, 3, 0, "Szmaciane rękawice"),
    LEATHER_GLOVES( 1, 3, 6, 0, "Skórzane rękawice"),
    CHAIN_GLOVES(   2, 5, 9, 0, "Kolcze rękawice"),
    STEEL_GLOVES(   4, 7, 16, -5, "Stalowe rękawice"),
    PLATE_GLOVES(   3, 5, 13, -2, "Płytowe rękawice"),
    ;

    private final int armor;
    private final int weight;
    private final int durability;
    private final int armModifier;
    private final String namePL;

    GlovesModel(int armor, int weight, int durability, int armModifier, String namePL) {
        this.armor = armor;
        this.weight = weight;
        this.durability = durability;
        this.armModifier = armModifier;
        this.namePL = namePL;
    }

}
