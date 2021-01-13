package model.items;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
public enum BeltModel {

    SASH(           0, 2, 3, "Szarfa"),
    LEATHER_BELT(   1, 3, 6, "Skórzany pas"),
    WIDE_BELT(      1, 4, 8, "Szeroki pas", new Modifier(ModifierType.FORM, -5)),
    PLATE_BELT(     2, 6, 14, "Płytowy pas", new Modifier(ModifierType.FORM, -8)),
    ;

    private final int armor;
    private final int weight;
    private final int durability;
    private final String namePL;
    private final Set<Modifier> modifiers;

    BeltModel(int armor, int weight, int durability, String namePL, Modifier... modifiers) {
        this.armor = armor;
        this.weight = weight;
        this.durability = durability;
        this.namePL = namePL;
        this.modifiers = new HashSet<>(Arrays.asList(modifiers));
    }
}
