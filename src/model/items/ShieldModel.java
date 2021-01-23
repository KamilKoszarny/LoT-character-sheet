package model.items;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
public enum ShieldModel implements ItemModel{

    WOODEN_SHIELD(      15, 1, 4, 5, "Drewniana tarcza"),
    BUCKLER(            20, 1, 7, 12, "Puklerz"),
    TARGE(              20, 2, 8, 15, "Tarża"),
    KITE_SHIELD(        25, 2, 10, 15, "Trójkątna tarcza"),
    DIAMOND_SHIELD(     30, 2, 16, 16, "Rombowa tarcza"),
    RONDACHE(           25, 3, 18, 24, "Rondela"),
    BRONZE_SHIELD(      30, 3, 21, 25, "Brązowa tarcza"),
    SPIKED_SHIELD(      30, 5, 19, 20, "Kolczasta tarcza"),
    BONE_SHIELD(        30, 4, 20, 25, "Kościana tarcza"),
    TOURNAMENT_SHIELD(  35, 3, 18, 32, "Turniejowa tarcza"),
    HERALD_SHIELD(      35, 4, 22, 40, "Heraldyczna tarcza"),
    DRAGON_SHIELD(      40, 4, 25, 50, "Smocza tarcza");

    private final int block;
    private final int dmg;
    private final int weight;
    private final int durabilityMax;
    private final String namePL;
    private final Set<Modifier> modifiers;

    ShieldModel(int block, int dmg, int weight, int durabilityMax, String namePL, Modifier... modifiers) {
        this.block = block;
        this.dmg = dmg;
        this.weight = weight;
        this.durabilityMax = durabilityMax;
        this.namePL = namePL;
        this.modifiers = new HashSet<>(Arrays.asList(modifiers));
    }
}
