package model.items;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
public enum GlovesModel implements ItemModel{

    RAG_GLOVES(     0, 2, 3, "Szmaciane rękawice"),
    LEATHER_GLOVES( 1, 3, 6, "Skórzane rękawice"),
    CHAIN_GLOVES(   2, 5, 9, "Kolcze rękawice"),
    STEEL_GLOVES(   4, 7, 16, "Stalowe rękawice", new Modifier(ModifierType.ARM, -5)),
    PLATE_GLOVES(   3, 5, 13, "Płytowe rękawice", new Modifier(ModifierType.ARM, -2)),
    ;

    private final int armor;
    private final int weight;
    private final int durabilityMax;
    private final String namePL;
    private final Set<Modifier> modifiers;

    GlovesModel(int armor, int weight, int durabilityMax, String namePL, Modifier... modifiers) {
        this.armor = armor;
        this.weight = weight;
        this.durabilityMax = durabilityMax;
        this.namePL = namePL;
        this.modifiers = new HashSet<>(Arrays.asList(modifiers));
    }

}
