package model;

import lombok.Getter;

public enum Sign {
    WOLF("Wilk", 50),
    CRANE("Żuraw", 51),
    SWAN("Łabędź", 80);

    @Getter
    private final String namePL;
    @Getter
    private final int number;

    Sign(String namePL, int number) {
        this.namePL = namePL;
        this.number = number;
    }

    @Override
    public String toString() {
        return this.namePL;
    }
}
