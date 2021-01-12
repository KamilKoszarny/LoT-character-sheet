package model.items;

import lombok.Getter;

@Getter
public enum AmuletModel {

    BRONZE_AMULET("Brązowy amulet", 3),
    SILVER_AMULET("Srebrny amulet", 4),
    GOLD_AMULET("Złoty amulet", 5),
    ;

    private final String namePL;
    private final int charisma;

    AmuletModel(String namePL, int charisma) {
        this.namePL = namePL;
        this.charisma = charisma;
    }

}
