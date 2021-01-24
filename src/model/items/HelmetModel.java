package model.items;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum HelmetModel implements ItemModel{

    LEATHER_HOOD(       1, 2, 5, "Skórzany kaptur"),
    CASQUE(             2, 5, 15,"Szyszak", new Modifier(ModifierType.KNOWLEDGE, -5)),
    HELMET(             3, 6, 12, "Hełm", new Modifier(ModifierType.EYE, -3), new Modifier(ModifierType.KNOWLEDGE, -5)),
    CLOSED_HELMET(      4, 8, 16, "Zamknięty hełm", new Modifier(ModifierType.EYE, -8), new Modifier(ModifierType.KNOWLEDGE, -5)),
    MASK(               1, 3, 10, "Maska", new Modifier(ModifierType.EYE, -5), new Modifier(ModifierType.INTIMIDATE, 1)),
    SKULL_HELMET(       4, 7, 24, "Hełm czaszki", new Modifier(ModifierType.EYE, -8), new Modifier(ModifierType.CHARISMA, -5), new Modifier(ModifierType.DARK_MAGIC_COST, -2)),
    WOLF_CAP(           2, 4, 15, "Wilczy kaptur", new Modifier(ModifierType.EYE, -3), new Modifier(ModifierType.CHANGE_FORM_COST, -66)),
    EAGLE_HELMET(       3, 6, 18, "Orli hełm", new Modifier(ModifierType.LIGHT_MAGIC_COST, -2)),
    BARBARIAN_HELMET(   3, 6, 10, "Barbarzyński hełm", new Modifier(ModifierType.STONE_SKIN, -66), new Modifier(ModifierType.KNOWLEDGE, -3)),
    HORN_HELMET(        4, 8, 12, "Rogaty hełm", new Modifier(ModifierType.BLOCK_DMG, 3), new Modifier(ModifierType.EYE, -5), new Modifier(ModifierType.KNOWLEDGE, -3)),
    GLADIATOR_HELMET(   4, 9, 15, "Hełm gladiatora", new Modifier(ModifierType.WRATH, 1), new Modifier(ModifierType.EYE, -10), new Modifier(ModifierType.KNOWLEDGE, -3), new Modifier(ModifierType.CHARISMA, 5)),
    TOURNAMENT_HELMET(  5, 12, 20, "Hełm turniejowy", new Modifier(ModifierType.BLOCK_DMG, 3), new Modifier(ModifierType.EYE, -5), new Modifier(ModifierType.KNOWLEDGE, -5), new Modifier(ModifierType.CHARISMA, 5)),
    CROWN(              5, 8, 30, "Korona", new Modifier(ModifierType.PERSUASION, 1), new Modifier(ModifierType.CHARISMA, 8));

    private final int armor;
    private final int weight;
    private final int durabilityMax;
    private final String namePL;
    private final List<Modifier> modifiers;

    HelmetModel(int armor, int weight, int durabilityMax, String namePL, Modifier... modifiers) {
        this.armor = armor;
        this.weight = weight;
        this.durabilityMax = durabilityMax;
        this.namePL = namePL;
        this.modifiers = Arrays.asList(modifiers);
    }

}
