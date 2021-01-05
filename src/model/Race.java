package model;

public enum Race {
    HUMAN("Człowiek"),
    DWARF("Krasnolud"),
    ELF("Elf"),
    HALFELF("Półelf");

    private final String namePL;

    Race(String namePL) {
        this.namePL = namePL;
    }

    @Override
    public String toString() {
        return this.namePL;
    }
}
