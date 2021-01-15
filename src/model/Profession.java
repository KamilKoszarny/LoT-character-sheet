package model;

import lombok.Getter;

@Getter
public enum Profession {
    ADEPT(1, "Uczeń"),
    RASCAL(1, "Hultaj"),
    BULLY(1, "Osiłek"),
    HEALER(2, "Uzdrowiciel", Profession.ADEPT),
    MASTER(2, "Magister", Profession.ADEPT),
    WIZARD(2, "Czarodziej", Profession.ADEPT),
    SHADOW(2, "Cień", Profession.RASCAL),
    HUNTER(2, "Łowca", Profession.RASCAL),
    MERCENARY(2, "Najemnik", Profession.RASCAL),
    SOLDIER(2, "Żołnierz", Profession.BULLY),
    WARRIOR(2, "Wojownik", Profession.BULLY),
    FANATIC(2, "Fanatyk", Profession.BULLY),
    MONK(3, "Mnich", Profession.BULLY, Profession.FANATIC);

    private final int level;
    private final String namePL;
    private final Profession lvl1Profession;
    private final Profession lvl2Profession;

    Profession(int level, String namePL) {
        this.level = level;
        this.namePL = namePL;
        this.lvl1Profession = this;
        this.lvl2Profession = null;
    }

    Profession(int level, String namePL, Profession lvl1Profession) {
        this.level = level;
        this.namePL = namePL;
        this.lvl1Profession = lvl1Profession;
        this.lvl2Profession = this;
    }

    Profession(int level, String namePL, Profession lvl1Profession, Profession lvl2Profession) {
        this.level = level;
        this.namePL = namePL;
        this.lvl1Profession = lvl1Profession;
        this.lvl2Profession = lvl2Profession;
    }

    @Override
    public String toString() {
        return this.namePL;
    }
}
