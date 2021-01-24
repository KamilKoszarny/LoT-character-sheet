package model.items;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum BeltModel implements ItemModel{

    SASH(           0, 2, 3, "Szarfa", new Modifier(ModifierType.POTION_SPACE, 1)),
    LEATHER_BELT(   1, 3, 6, "Skórzany pas", new Modifier(ModifierType.POTION_SPACE, 2)),
    WIDE_BELT(      1, 4, 8, "Szeroki pas", new Modifier(ModifierType.FORM, -5), new Modifier(ModifierType.POTION_SPACE, 3)),
    PLATE_BELT(     2, 6, 14, "Płytowy pas", new Modifier(ModifierType.FORM, -8), new Modifier(ModifierType.POTION_SPACE, 3)),
    ;

    private final int armor;
    private final int weight;
    private final int durabilityMax;
    private final String namePL;
    private final List<Modifier> modifiers;

    BeltModel(int armor, int weight, int durabilityMax, String namePL, Modifier... modifiers) {
        this.armor = armor;
        this.weight = weight;
        this.durabilityMax = durabilityMax;
        this.namePL = namePL;
        this.modifiers = Arrays.asList(modifiers);
    }
}
