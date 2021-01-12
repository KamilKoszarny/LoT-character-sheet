package model.items;

import lombok.Getter;

@Getter
public enum HelmetModel {

    LEATHER_HOOD(       1, 2, 5, 0, 0, 0, "Skórzany kaptur"),
    CASQUE(             2, 5, 15, 0, -5, 0,"Szyszak"),
    HELMET(             3, 6, 12, -3, -5, 0,"Hełm"),
    CLOSED_HELMET(      4, 8, 16, -8, -5, 0, "Zamknięty hełm"),
    MASK(               1, 3, 10, -5, 0, 0, "Maska"),
    SKULL_HELMET(       4, 7, 24, -8, 0, -5, "Hełm czaszki"),
    WOLF_CAP(           2, 4, 15, -3, 0, 0,"Wilczy kaptur"),
    EAGLE_HELMET(       3, 6, 18, 0, 0, 0,"Orli hełm"),
    BARBARIAN_HELMET(   3, 6, 10, 0, -3, 0,"Barbarzyński hełm"),
    HORN_HELMET(        4, 8, 12, -5, -3, 0,"Rogaty hełm"),
    GLADIATOR_HELMET(   4, 9, 15, -10, -3, 5,"Hełm gladiatora"),
    TOURNAMENT_HELMET(  5, 12, 20, -5, -5, 5,"Hełm turniejowy"),
    CROWN(              5, 8, 30, 0, 0, 8,"Korona");

    private final int armor;
    private final int weight;
    private final int durability;
    private final int eyeModifier;
    private final int knowledgeModifier;
    private final int charismaModifier;
    private final String namePL;

    HelmetModel(int armor, int weight, int durability, int eyeModifier, int knowledgeModifier, int charismaModifier, String namePL) {
        this.armor = armor;
        this.weight = weight;
        this.durability = durability;
        this.eyeModifier = eyeModifier;
        this.knowledgeModifier = knowledgeModifier;
        this.charismaModifier = charismaModifier;
        this.namePL = namePL;
    }

}
