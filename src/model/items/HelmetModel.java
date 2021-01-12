package model.items;

import lombok.Getter;

@Getter
public enum HelmetModel {

    LEATHER_HOOD(       1, 2, 5, 0, "Skórzany kaptur"),
    CASQUE(             2, 5, 15, -5, "Szyszak"),
    HELMET(             3, 6, 12, -5, "Hełm"),
    CLOSED_HELMET(      4, 8, 16, -5, "Zamknięty hełm"),
    MASK(               1, 3, 10, 0, "Maska"),
    SKULL_HELMET(       4, 7, 24, 0, "Hełm czaszki"),
    WOLF_CAP(           2, 4, 15, 0, "Wilczy kaptur"),
    EAGLE_HELMET(       3, 6, 18, 0, "Orli hełm"),
    BARBARIAN_HELMET(   3, 6, 10, 0, "Barbarzyński hełm"),
    HORN_HELMET(        4, 8, 12, 0, "Rogaty hełm"),
    GLADIATOR_HELMET(   4, 9, 15, 0, "Hełm gladiatora"),
    TOURNAMENT_HELMET(  5, 12, 20, -5, "Hełm turniejowy"),
    CROWN(              5, 8, 30, 0, "Korona");

    private final int armor;
    private final int weight;
    private final int durability;
    private final int knowledgeModifier;
    private final String namePL;

    HelmetModel(int armor, int weight, int durability, int knowledgeModifier, String namePL) {
        this.armor = armor;
        this.weight = weight;
        this.durability = durability;
        this.knowledgeModifier = knowledgeModifier;
        this.namePL = namePL;
    }

}
