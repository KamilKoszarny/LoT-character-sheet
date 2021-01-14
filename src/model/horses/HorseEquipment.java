package model.horses;

import lombok.Getter;

import java.io.Serializable;

@Getter
public enum HorseEquipment implements Serializable {

    SECOND_RIDER("Drugi jeździec", -20, -2, -3, 0, 0, 0),
    SADDLE("Siodło", 10, 1, 0, 0, 0, 0),
    COMFORT_SADDLE("Wygodne siodło", 20, 2, 0, 0, 0, 0),
    GREAT_SADDLE("Świetne siodło", 30, 3, 1, 0, 0, 0),

    BAGS("Juki", -10, -1, -1, 100, 3, 0),
    BIG_BAGS("Duże juki", -15, -1, -2, 180, 5, 0),
    CART("Wóz", -50, -3, -5, 600, 20, 0),

    LEATHER_ARMOR("", 0, 0, 0, 0, 0, 2),
    CHAIN_ARMOR("", 0, 0, 0, 0, 0, 4),
    PLATE_ARMOR("", 0, 0, 0, 0, 0, 6),
    ;

    private final String namePL;
    private final int riding;
    private final int travelSpeed;
    private final int combatSpeed;
    private final int loadMax;
    private final int loadColumns;
    private final int armor;

    HorseEquipment(String namePL, int riding, int travelSpeed, int combatSpeed, int loadMax, int loadColumns, int armor) {
        this.namePL = namePL;
        this.riding = riding;
        this.travelSpeed = travelSpeed;
        this.combatSpeed = combatSpeed;
        this.loadMax = loadMax;
        this.loadColumns = loadColumns;
        this.armor = armor;
    }
}
