package model.items;

import lombok.Getter;

@Getter
public enum ItemType {

    WEAPON("Broń"),
    SHIELD("Tarcze"),
    ARMOR("Zbroje"),
    HELMET("Hełmy"),
    GLOVES("Rękawice"),
    BOOTS("Buty"),
    BELT("Pasy"),
    AMULET("Amulety"),
    RING("Pierścienie");


    private final String namePL;

    ItemType(String namePL) {
        this.namePL = namePL;
    }
}
