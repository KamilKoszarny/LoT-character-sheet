package model.items;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum ShieldModel implements ItemModel{

    WOODEN_SHIELD(      15, 1, 4, 5, "Drewniana tarcza"),
    BUCKLER(            20, 1, 7, 12, "Puklerz"),
    TARGE(              20, 2, 8, 15, "Tarża", new Modifier(ModifierType.EXTRA_BLOCK, 1)),
    KITE_SHIELD(        25, 2, 10, 15, "Trójkątna tarcza", new Modifier(ModifierType.BLOCKS_CONTRA, 0)),
    DIAMOND_SHIELD(     30, 2, 16, 16, "Rombowa tarcza", new Modifier(ModifierType.BLOCK_PROJECTILE, 20)),
    RONDACHE(           25, 3, 18, 24, "Rondela", new Modifier(ModifierType.EXTRA_BLOCK, 1)),
    BRONZE_SHIELD(      30, 3, 21, 25, "Brązowa tarcza"),
    SPIKED_SHIELD(      30, 5, 19, 20, "Kolczasta tarcza", new Modifier(ModifierType.BLOCK_DMG, 3)),
    BONE_SHIELD(        30, 4, 20, 25, "Kościana tarcza", new Modifier(ModifierType.DARK_MAGIC_COST, -2)),
    TOURNAMENT_SHIELD(  35, 3, 18, 32, "Turniejowa tarcza", new Modifier(ModifierType.CHARISMA, 3)),
    HERALD_SHIELD(      35, 4, 22, 40, "Heraldyczna tarcza", new Modifier(ModifierType.RES_ELEMENTS, 5)),
    DRAGON_SHIELD(      40, 4, 25, 50, "Smocza tarcza", new Modifier(ModifierType.RES_MAGIC, 10));

    private final int block;
    private final int dmg;
    private final int weight;
    private final int durabilityMax;
    private final String namePL;
    private final List<Modifier> modifiers;

    ShieldModel(int block, int dmg, int weight, int durabilityMax, String namePL, Modifier... modifiers) {
        this.block = block;
        this.dmg = dmg;
        this.weight = weight;
        this.durabilityMax = durabilityMax;
        this.namePL = namePL;
        this.modifiers = Arrays.asList(modifiers);
    }
}
