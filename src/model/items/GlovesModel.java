package model.items;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum GlovesModel implements ItemModel{

    RAG_GLOVES(     1, 2, 3, "Szmaciane rękawice"),
    LEATHER_GLOVES( 2, 3, 6, "Skórzane rękawice"),
    CHAIN_GLOVES(   3, 5, 9, "Kolcze rękawice"),
    STEEL_GLOVES(   5, 7, 16, "Stalowe rękawice", new Modifier(ModifierType.ARM, -5)),
    PLATE_GLOVES(   4, 5, 13, "Płytowe rękawice", new Modifier(ModifierType.ARM, -2)),
    ;

    private final int armor;
    private final int weight;
    private final int durabilityMax;
    private final String namePL;
    private final List<Modifier> modifiers;

    GlovesModel(int armor, int weight, int durabilityMax, String namePL, Modifier... modifiers) {
        this.armor = armor;
        this.weight = weight;
        this.durabilityMax = durabilityMax;
        this.namePL = namePL;
        this.modifiers = Arrays.asList(modifiers);
    }

}
