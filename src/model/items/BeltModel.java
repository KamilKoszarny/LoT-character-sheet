package model.items;

import lombok.Getter;

@Getter
public enum BeltModel {

    SASH(           0, 2, 3, "Szarfa"),
    LEATHER_BELT(   1, 3, 6, "Skórzany pas"),
    WIDE_BELT(      1, 4, 8, "Szeroki pas"),
    PLATE_BELT(     2, 6, 14, "Płytowy pas"),
    ;

    private final int armor;
    private final int weight;
    private final int durability;
    private final String namePL;

    BeltModel(int armor, int weight, int durability, String namePL) {
        this.armor = armor;
        this.weight = weight;
        this.durability = durability;
        this.namePL = namePL;
    }

}
