package model.items;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum AmuletModel implements ItemModel{

    BRONZE_AMULET("Brązowy amulet", new Modifier(ModifierType.CHARISMA, 3)),
    SILVER_AMULET("Srebrny amulet", new Modifier(ModifierType.CHARISMA, 4)),
    GOLD_AMULET("Złoty amulet", new Modifier(ModifierType.CHARISMA, 5)),
    ;

    private final String namePL;
    private final List<Modifier> modifiers;
    private final int weight = 0;
    private final int durabilityMax = 99;

    AmuletModel(String namePL, Modifier... modifiers) {
        this.namePL = namePL;
        this.modifiers = Arrays.asList(modifiers);
    }
}
