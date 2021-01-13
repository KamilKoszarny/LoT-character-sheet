package model;

import lombok.Getter;

@Getter
public enum Trait {

    TWO_HANDED(TraitType.POSITIVE, "Oburęczny", "Brak kary drugiej ręki"),
    RESISTANT(TraitType.POSITIVE, "Odporny", "+20% odp. na choroby ciała"),
    GOOD_AT_MATHS(TraitType.POSITIVE, "Dobrze liczy", "Charyzma +20 przy targowaniu"),

    ELEMENTAL_NEPHEW(TraitType.NEUTRAL, "Bratanek żywiołów", "+10p% odp. na zywioly;\n-10p% odp. na magie"),
    DREAMER(TraitType.NEUTRAL, "Marzyciel", "-20% odp. na choroby psychiczne\n+20% odp. na choroby ciała"),
    NON_STANDARD_BODY(TraitType.NEUTRAL, "Niestandardowa budowa", "-10% wym. Przedmiotów;\n-5% statystyki przedmiotów"),

    UNREGULAR_BODY(TraitType.NEGATIVE, "Nieregularna budowa", "+10% wymagania przedmiotow"),
    HAND_SHAKING(TraitType.NEGATIVE, "Drżenie rąk", "ręka -10%(startowa),\nprzyrost -10% (co 10 punkt *2PD)");

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
