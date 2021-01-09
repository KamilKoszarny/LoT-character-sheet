package model;

import lombok.Getter;

import java.io.Serializable;

@Getter
public enum Trait implements Serializable {

    TWO_HANDED(TraitType.POSITIVE, "Oburęczny", "Brak kary drugiej ręki"),
    RESISTANT(TraitType.POSITIVE, "Odporny", "+20% odp. na ch. ciala"),
    GOOD_AT_MATHS(TraitType.POSITIVE, "Dobrze liczy", "charyzma +20% przy targowaniu"),

    ELEMENTAL_NEPHEW(TraitType.NEUTRAL, "Bratanek żywiołów", "+10p% odp. na zywioly; -10p% niewr. na magie"),
    DREAMER(TraitType.NEUTRAL, "Marzyciel", "-20% odp. na ch. Psych.  +20% odp. na ch. ciala"),
    NON_STANDARD_BODY(TraitType.NEUTRAL, "Niestandardowa budowa", "-10% wym. Przedmiotów; -5% stat. Przedmiotów"),

    UNREGULAR_BODY(TraitType.NEGATIVE, "Nieregularna budowa", "+10% wym. przedmiotow"),
    HAND_SHAKING(TraitType.NEGATIVE, "Drżenie rąk", "r -10%, przyrost -10%");

    private final String namePL;
    private final String descriptionPL;
    private final TraitType type;

    Trait(TraitType type, String namePL, String descriptionPL) {
        this.type= type;
        this.namePL = namePL;
        this.descriptionPL = descriptionPL;
    }

    @Override
    public String toString() {
        return this.namePL;
    }
}
