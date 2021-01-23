package model.items;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
public enum ArmorModel implements ItemModel{

    LEATHER_SHIRT(      0, 1, 1, 0, 6, 12, "Skórzana koszula"),
    GAMBISON(           0, 1, 1, 1, 8, 8, "Przeszywanica"),
    LEATHER_ARMOR(      0, 2, 1, 0, 10, 16, "Skórzana zbroja", new Modifier(ModifierType.ARM, -3)),
    STUDDED_ARMOR(      0, 3, 0, 1, 11, 19, "Ćwiekowana zbroja"),
    CHAIN_SHIRT(        0, 4, 3, 0, 20, 23, "Kolcza koszula", new Modifier(ModifierType.FOCUS, -5)),
    SCALE_SHIRT(        0, 5, 2, 0, 18, 27, "Zbroja łuskowa", new Modifier(ModifierType.AGILITY, -3), new Modifier(ModifierType.FOCUS, -5)),
    HAUBERK(            0, 4, 3, 2, 28, 25, "Kolczuga", new Modifier(ModifierType.AGILITY, -5), new Modifier(ModifierType.FOCUS, -10)),
    LIGHT_PLATE_ARMOR(  0, 5, 2, 2, 20, 26, "Lekka płytówka", new Modifier(ModifierType.FOCUS, -3)),
    BREASTPLATE(        0, 7, 0, 0, 16, 30, "Napierśnik", new Modifier(ModifierType.FOCUS, -5)),
    TOURNAMENT_ARMOR(   0, 5, 4, 2, 23, 35, "Zbroja turniejowa", new Modifier(ModifierType.FOCUS, -5), new Modifier(ModifierType.CHARISMA, 5)),
    GUARDIAN_ARMOR(     1, 6, 4, 3, 26, 40, "Zbroja strażnika", new Modifier(ModifierType.AGILITY, -8), new Modifier(ModifierType.FOCUS, -10), new Modifier(ModifierType.CHARISMA, 3)),
    FULL_PLATE_ARMOR(   0, 7, 4, 4, 30, 40, "Pełna płytówka", new Modifier(ModifierType.AGILITY, -10), new Modifier(ModifierType.FOCUS, -15)),
    FORGED_ARMOR(       2, 9, 4, 1, 36, 50, "Kuta zbroja", new Modifier(ModifierType.ARM, -5), new Modifier(ModifierType.FOCUS, -10), new Modifier(ModifierType.CHARISMA, -15));

    private final int headArmor;
    private final int bodyArmor;
    private final int armsArmor;
    private final int legsArmor;
    private final int weight;
    private final int durabilityMax;
    private final String namePL;
    private final Set<Modifier> modifiers;

    ArmorModel(int headArmor, int bodyArmor, int armsArmor, int legsArmor, int weight, int durabilityMax, String namePL, Modifier... modifiers) {
        this.headArmor = headArmor;
        this.bodyArmor = bodyArmor;
        this.armsArmor = armsArmor;
        this.legsArmor = legsArmor;
        this.weight = weight;
        this.durabilityMax = durabilityMax;
        this.namePL = namePL;
        this.modifiers = new HashSet<>(Arrays.asList(modifiers));
    }
}
