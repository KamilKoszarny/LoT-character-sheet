package model.horses;

import lombok.Getter;

@Getter
public enum HorseType {
    NAD("Szkapa",       10, 10, 8, 4, 40),
    COLT("Źrebak",      12, 20, 9, 5, 40),
    FARM("Rolniczy",    20, 30, 10, 6, 60),
    COURIER("Gończy",   20, 40, 12, 7, 60),
    ARMY("Wojskowy",    30, 50, 12, 8, 70),
    NOBLE("Szlachetny", 35, 60, 13, 9, 70),
    CHOICE("Wyborowy",  40, 70, 14, 10, 80),
    UNIQUE("Wyjątkowy", 50, 80, 15, 10, 90)
    ;

    private final String namePL;
    private final int hitPointsMax;
    private final int riding;
    private final int travelSpeed;
    private final int combatSpeed;
    private final int loadMax;
    private final int loadColumns;

    HorseType(String namePL, int hitPointsMax, int riding, int travelSpeed, int combatSpeed, int loadMax) {
        this.namePL = namePL;
        this.hitPointsMax = hitPointsMax;
        this.riding = riding;
        this.travelSpeed = travelSpeed;
        this.combatSpeed = combatSpeed;
        this.loadMax = loadMax;
        this.loadColumns = 1;
    }

    @Override
    public String toString() {
        return this.namePL;
    }
}
