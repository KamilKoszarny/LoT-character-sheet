package model.items;

import lombok.Getter;

@Getter
public enum HelmetModel {

    LEATHER_HOOD(       1, 1, 5, "Skórzany kaptur"),
    CASQUE(             2, 4, 15, "Szyszak"),
    HELMET(             3, 5, 12, "Hełm"),
    CLOSED_HELMET(      4, 6, 16, "Zamknięty hełm"),
    MASK(               1, 2, 10, "Maska"),
    SKULL_HELMET(       4, 5, 24, "Hełm czaszki"),
    WOLF_CAP(           2, 2, 15, "Wilczy kaptur"),
    EAGLE_HELMET(       3, 2, 18, "Orli hełm"),
    BARBARIAN_HELMET(   3, 2, 10, "Barbarzyński hełm"),
    HORN_HELMET(        4, 6, 12, "Rogaty hełm"),
    GLADIATOR_HELMET(   4, 5, 15, "Hełm gladiatora"),
    TOURNAMENT_HELMET(  5, 7, 20, "Hełm turniejowy"),
    CROWN(              5, 3, 30, "Korona");

    private int armor;
    private int weight;
    private int durability;
    private final String namePL;

    HelmetModel(int armor, int weight, int durability, String namePL) {
        this.armor = armor;
        this.weight = weight;
        this.durability = durability;
        this.namePL = namePL;
    }

}
