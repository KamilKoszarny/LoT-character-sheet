package model;

public enum HorseType {
    NAD("Szkapa"),
    COLT("Źrebak"),
    FARM("Rolniczy"),
    COURIER("Gończy"),
    ARMY("Wojskowy"),
    NOBLE("Szlachetny"),
    CHOICE("Wyborowy"),
    UNIQUE("Wyjątkowy")
    ;

    private final String namePL;

    HorseType(String namePL) {
        this.namePL = namePL;
    }

    @Override
    public String toString() {
        return this.namePL;
    }
}
