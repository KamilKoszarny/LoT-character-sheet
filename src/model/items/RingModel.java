package model.items;

import lombok.Getter;

@Getter
public enum RingModel {

    IRON_RING("Żelazny pierścień", 1),
    COPPER_RING("Miedziany pierścień", 2),
    BRONZE_RING("Brązowy pierścień", 3),
    SILVER_RING("Srebrny pierścień", 4),
    GOLD_RING("Złoty pierścień", 5),
    ;

    private final String namePL;
    private final int charisma;

    RingModel(String namePL, int charisma) {
        this.namePL = namePL;
        this.charisma = charisma;
    }

}
