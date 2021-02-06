package model.items;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public enum AmmunitionModel implements ItemModel {

    ARROWS("Strzały"),
    BOLTS("Bełty"),
    ;

    private final String namePL;
    private final List<Modifier> modifiers;
    private final int weight = 3;
    private final int durabilityMax = 30;

    AmmunitionModel(String namePL) {
        this.namePL = namePL;
        this.modifiers = Collections.emptyList();
    }
}
