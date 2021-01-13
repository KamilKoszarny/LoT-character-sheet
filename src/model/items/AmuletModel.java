package model.items;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
public enum AmuletModel {

    BRONZE_AMULET("Brązowy amulet", new Modifier(ModifierType.CHARISMA, 3)),
    SILVER_AMULET("Srebrny amulet", new Modifier(ModifierType.CHARISMA, 4)),
    GOLD_AMULET("Złoty amulet", new Modifier(ModifierType.CHARISMA, 5)),
    ;

    private final String namePL;
    private final Set<Modifier> modifiers;

    AmuletModel(String namePL, Modifier... modifiers) {
        this.namePL = namePL;
        this.modifiers = new HashSet<>(Arrays.asList(modifiers));
    }

}
