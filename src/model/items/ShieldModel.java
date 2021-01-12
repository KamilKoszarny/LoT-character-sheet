package model.items;

import lombok.Getter;

@Getter
public enum ShieldModel {

    WOODEN_SHIELD(      15, 0, 4, 5, "Drewniana tarcza"),
    BUCKLER(            20, 0, 7, 12, "Puklerz"),
    TARGE(              20, 1, 8, 15, "Tarża"),
    KITE_SHIELD(        25, 1, 10, 15, "Trójkątna tarcza"),
    DIAMOND_SHIELD(     30, 1, 16, 16, "Rombowa tarcza"),
    RONDACHE(           25, 2, 18, 24, "Rondela"),
    BRONZE_SHIELD(      30, 2, 21, 25, "Brązowa tarcza"),
    SPIKED_SHIELD(      30, 4, 19, 20, "Kolczasta tarcza"),
    BONE_SHIELD(        30, 3, 20, 25, "Kościana tarcza"),
    TOURNAMENT_SHIELD(  35, 2, 18, 32, "Turniejowa tarcza"),
    HERALD_SHIELD(      35, 3, 22, 40, "Heraldyczna tarcza"),
    DRAGON_SHIELD(      40, 3, 25, 50, "Smocza tarcza");

    private final int block;
    private final int dmg;
    private final int weight;
    private final int durability;
    private final String namePL;

    ShieldModel(int block, int dmg, int weight, int durability, String namePL) {
        this.block = block;
        this.dmg = dmg;
        this.weight = weight;
        this.durability = durability;
        this.namePL = namePL;
    }
}
