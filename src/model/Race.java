package model;

import lombok.Getter;

@Getter
public enum Race {
    HUMAN("Człowiek", "Adaptacja: Ignorowane są ujemne modyfikatory przy przerzucie za Punkt Szczęścia."),
    ELF("Elf", "Mieszkańcy lasu: Ignorowane są ujemne modyfikatory podróży przez las."),
    DWARF("Krasnolud", "Widzenie w ciemności: Ignorowane są ujemne modyfikatory od mroku"),
    HALFELF("Półelf", "Południowicy: Ignorowane są ujemne modyfikatory od gorąca. Ogień zadaje ½ obrażeń.");

    private final String namePL;
    private final String traitDescription;

    Race(String namePL, String traitDescription) {
        this.namePL = namePL;
        this.traitDescription = traitDescription;
    }

    @Override
    public String toString() {
        return this.namePL;
    }
}
