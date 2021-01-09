package model;

import lombok.Getter;

@Getter
public enum Proffesion {
    ADEPT(1, "Uczeń"),
    RASCAL(1, "Hultaj"),
    BULLY(1, "Osiłek"),
    HEALER(2, "Uzdrowiciel", Proffesion.ADEPT),
    MASTER(2, "Magister", Proffesion.ADEPT),
    WIZARD(2, "Czarodziej", Proffesion.ADEPT),
    SHADOW(2, "Cień", Proffesion.RASCAL),
    HUNTER(2, "Łowca", Proffesion.RASCAL),
    MERCENARY(2, "Najemnik", Proffesion.RASCAL),
    SOLDIER(2, "Żołnierz", Proffesion.BULLY),
    WARRIOR(2, "Wojownik", Proffesion.BULLY),
    FANATIC(2, "Fanatyk", Proffesion.BULLY),
    MONK(3, "Mnich", Proffesion.BULLY, Proffesion.FANATIC);

    private final int level;
    private final String namePL;
    private final Proffesion lvl1Proffesion;
    private final Proffesion lvl2Proffesion;

    Proffesion(int level, String namePL) {
        this.level = level;
        this.namePL = namePL;
        this.lvl1Proffesion = this;
        this.lvl2Proffesion = null;
    }

    Proffesion(int level, String namePL, Proffesion lvl1Proffesion) {
        this.level = level;
        this.namePL = namePL;
        this.lvl1Proffesion = lvl1Proffesion;
        this.lvl2Proffesion = this;
    }

    Proffesion(int level, String namePL, Proffesion lvl1Proffesion, Proffesion lvl2Proffesion) {
        this.level = level;
        this.namePL = namePL;
        this.lvl1Proffesion = lvl1Proffesion;
        this.lvl2Proffesion = lvl2Proffesion;
    }

    @Override
    public String toString() {
        return this.namePL;
    }
}
