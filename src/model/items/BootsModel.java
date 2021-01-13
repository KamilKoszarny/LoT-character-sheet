package model.items;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
public enum BootsModel {

    RAG_BOOTS(     0, 2, 3, "Szmaciane buty"),
    LEATHER_BOOTS( 1, 3, 6, "Skórzane buty"),
    CHAIN_BOOTS(   2, 5, 9, "Kolcze buty"),
    STEEL_BOOTS(   4, 7, 16, "Stalowe buty", new Modifier(ModifierType.AGILITY, -5)),
    PLATE_BOOTS(   3, 5, 13, "Płytowe buty", new Modifier(ModifierType.AGILITY, -2)),
    ;

    private final int armor;
    private final int weight;
    private final int durability;
    private final String namePL;
    private final Set<Modifier> modifiers;

    BootsModel(int armor, int weight, int durability, String namePL, Modifier... modifiers) {
        this.armor = armor;
        this.weight = weight;
        this.durability = durability;
        this.namePL = namePL;
        this.modifiers = new HashSet<>(Arrays.asList(modifiers));
    }

}
