package model;

public enum Proffesion {
    ADEPT("Uczeń"),
    RASCAL("Hultaj"),
    BULLY("Osiłek"),
    HEALER("Uzdrowiciel"),
    MASTER("Magister"),
    WIZARD("Czarodziej"),
    SHADOW("Cień"),
    HUNTER("Łowca"),
    MERCENARY("Najemnik"),
    SOLDIER("Żołnierz"),
    WARRIOR("Wojownik"),
    FANATIC("Fanatyk");

    private final String namePL;

    Proffesion(String namePL) {
        this.namePL = namePL;
    }

    @Override
    public String toString() {
        return this.namePL;
    }
}
