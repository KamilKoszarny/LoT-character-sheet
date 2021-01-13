package model.items;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
public enum RingModel {

    IRON_RING("Żelazny pierścień", new Modifier(ModifierType.CHARISMA, 1)),
    COPPER_RING("Miedziany pierścień", new Modifier(ModifierType.CHARISMA, 2)),
    BRONZE_RING("Brązowy pierścień", new Modifier(ModifierType.CHARISMA, 3)),
    SILVER_RING("Srebrny pierścień", new Modifier(ModifierType.CHARISMA, 4)),
    GOLD_RING("Złoty pierścień", new Modifier(ModifierType.CHARISMA, 5)),
    ;

    private final String namePL;
    private final Set<Modifier> modifiers;

    RingModel(String namePL, Modifier... modifiers) {
        this.namePL = namePL;
        this.modifiers = new HashSet<>(Arrays.asList(modifiers));
    }

}
