package model.items;

import lombok.Getter;

@Getter
public enum BootsModel {

    RAG_BOOTS(     0, 2, 3, "Szmaciane buty"),
    LEATHER_BOOTS( 1, 3, 6, "Skórzane buty"),
    CHAIN_BOOTS(   2, 5, 9, "Kolcze buty"),
    STEEL_BOOTS(   4, 7, 16, "Stalowe buty"),
    PLATE_BOOTS(   3, 5, 13, "Płytowe buty"),
    ;

    private final int armor;
    private final int weight;
    private final int durability;
    private final String namePL;

    BootsModel(int armor, int weight, int durability, String namePL) {
        this.armor = armor;
        this.weight = weight;
        this.durability = durability;
        this.namePL = namePL;
    }

}
