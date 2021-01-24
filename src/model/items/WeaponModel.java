package model.items;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public enum WeaponModel implements ItemModel {

    //swords
    SHORT_SWORD(WeaponType.SWORD,         2, 4, 1, 1,         false, 15, 6, 12, "Krótki miecz"),
    SABRE(WeaponType.SWORD,               2, 5, 1, 1,      false, 30, 4, 8, "Szabla", new Modifier(ModifierType.HIT, 5)),
    CHOPPER(WeaponType.SWORD,             3, 6, 1, 1,       false, 15, 8, 14, "Tasak", new Modifier(ModifierType.HIT, -5)),
    GLASS_SWORD(WeaponType.SWORD,         4, 8, 1, 1,       false, 20, 3, 4, "Szklany miecz"),
    BROAD_SWORD(WeaponType.SWORD,         4, 8, 1, 1,       false, 25, 9, 18, "Pałasz"),
    LONG_SWORD(WeaponType.SWORD,          3, 9, 1, 1,       false, 30, 7, 16, "Długi miecz"),
    TWO_HAND_SWORD(WeaponType.SWORD,      5, 7, 1, 2,      true, 30, 12, 18, "Miecz oburęczny"),
    CLAYMORE(WeaponType.SWORD,            3, 10, 1, 2,     true, 45, 9, 16, "Claymore"),
    HALF_HAND_SWORD_1H(WeaponType.SWORD,  4, 8, 2, 2,    false, 30, 11, 19, "Miecz półtoraręczny (1 ręka)"),
    HALF_HAND_SWORD_2H(WeaponType.SWORD,  5, 10, 1, 2,    true, 30, 11, 19, "Miecz półtoraręczny (2 ręce)"),
    SABER(WeaponType.SWORD,               6, 14, 2, 3,    true, 35, 13, 15, "Koncerz"),
    GRAND_SWORD(WeaponType.SWORD,         6, 12, 1, 2,      true, 40, 17, 22, "Wielki miecz"),

    //axes
    ADZE(WeaponType.AXE,               1, 4, 1, 1,     false, 5, 5, 9, "Siekiera"),
    AXE_1H(WeaponType.AXE,             2, 5, 1, 1,     false, 15, 13, 13, "Topór (1-ręczny)"),
    AXE_2H(WeaponType.AXE,             4, 7, 1, 1,     true, 15, 13, 13, "Topór (2-ręczny)"),
    TWO_SIDE_AXE(WeaponType.AXE,       3, 6, 1, 1,         false, 10, 15, 15, "Obustronny topór"),
    PICK(WeaponType.AXE,               1, 4, 2, 1,        false, 10, 9, 12, "Nadziak", new Modifier(ModifierType.HIT, -5)),
    BEARD_AXE(WeaponType.AXE,          5, 8, 1, 1,       true, 25, 16, 22, "Brodaty topór"),
    BIG_ADZE(WeaponType.AXE,           2, 6, 2, 2,    true, 10, 9, 14, "Duża siekiera", new Modifier(ModifierType.HIT, -10)),
    BATTLE_AXE(WeaponType.AXE,         5, 9, 1, 1,    true, 25, 15, 19, "Bitewny topór"),
    GRAND_AXE(WeaponType.AXE,          7, 12, 2, 2,    true, 35, 20, 24, "Wielki topór"),
    DWARF_AXE(WeaponType.AXE,          4, 11, 1, 1,      true, 30, 18, 28, "Krasnoludzki topór"),

    //maces
    CUDGEL(WeaponType.MACE,             1, 3, 1, 1,       false, 15, 2, 15, "Pałka"),
    HAMMER(WeaponType.MACE,             3, 5, 2, 1,      false, 15, 4, 20, "Młot bojowy"),
    SPIKE_CLUB(WeaponType.MACE,         2, 4, 1, 1,       false, 10, 3, 10, "Kolczasta maczuga"),
    MACE(WeaponType.MACE,               3, 5, 1, 1,       false, 15, 5, 16, "Buława"),
    SPIKE_STAR(WeaponType.MACE,         4, 6, 1, 1,         false, 10, 5, 13, "Wiekiera"),
    SCEPTER(WeaponType.MACE,            5, 6, 1, 1,     false, 25, 5, 12, "Berło"),
    KURBASH(WeaponType.MACE,            2, 9, 1, 2,       false, 15, 5, 14, "Korbacz"),
    COMBAT_STICK(WeaponType.MACE,       3, 5, 1, 2,        true, 40, 3, 18, "Bojowy kij"),
    COMBAT_SCEPTER(WeaponType.MACE,     4, 8, 1, 1,     true, 30, 7, 17, "Wywijacz"),
    RAM(WeaponType.MACE,                7, 10, 2, 3,     true, 30, 12,24, "Kafar"),

    //short
    KNIFE(WeaponType.SHORT,              2, 3, 1, 1,       false, 0, 2, 7, "Nóż"),
    DAGGER(WeaponType.SHORT,             2, 4, 1, 1,       false, 0, 2, 9, "Sztylet"),
    CEREMONY_DAGGER(WeaponType.SHORT,    2, 4, 1, 1,       false, 0, 3, 13, "Ceremonialny sztylet"),
    SPIKE(WeaponType.SHORT,              4, 5, 1, 1,        false, 0, 3, 10, "Kolec"),
    KNUCKLE_DUSTER(WeaponType.SHORT,     2, 3, 1, 1,       false, 0, 2, 17, "Kastet"),
    HAND_BLADE(WeaponType.SHORT,         3, 7, 1, 1,         false, 0, 4, 13, "Ręczne ostrze"),
    TRIBLADE(WeaponType.SHORT,           4, 8, 1, 1,         false, 0, 6, 12, "Trójostrze"),
    CLAWS(WeaponType.SHORT,              3, 10, 1, 1,        false, 0, 5, 11, "Pazury"),

    //long
    SPEAR(WeaponType.LONG,              3, 6, 1, 3,       true, 20, 8, 10, "Włócznia"),
    TRIDENT(WeaponType.LONG,            4, 7, 1, 3,     true, 25, 14, 13, "Trójząb"),
    PIQUE(WeaponType.LONG,              4, 10, 2, 4,      true, 15, 10, 12, "Pika"),
    HARPOON(WeaponType.LONG,            4, 7, 1, 3,      true, 20, 11, 9, "Harpun"),
    SCYTHE(WeaponType.LONG,             2, 6, 2, 3,         true, 10, 12, 7, "Kosa"),
    BARDICHE(WeaponType.LONG,           2, 10, 2, 3,         true, 20, 19, 8, "Berdysz"),
    PARTISAN(WeaponType.LONG,           4, 11, 2, 3,         true, 35, 15, 12, "Partyzana"),
    HALABARD(WeaponType.LONG,           7, 13, 2, 4,         true, 45, 16, 20, "Halabarda"),
    CEREMONIAL_PIQUE(WeaponType.LONG,   5, 12, 1, 4,         true, 25, 9, 19, "Ceremonialna pika"),

    //throwing TODO: throw dmg
    THROWING_KNIFE(WeaponType.THROWING, 2, 3, 1, 10,      false, 0, 1, 10, "Nóż do rzucania"),
    THROWING_AXE(WeaponType.THROWING,   1, 4, 1, 10,      false, 0, 1, 10, "Toporek do rzucania"),
    BALANCED_KNIFE(WeaponType.THROWING, 1, 3, 1, 20,      false, 0, 1, 8, "Zbalansowany nóż"),
    BALANCED_AXE(WeaponType.THROWING,   2, 4, 1, 20,      false, 0, 2, 8, "Zbalansowany toporek"),
    JAVELIN(WeaponType.THROWING,        2, 4, 1, 15,      false, 0, 2, 6, "Oszczep"),
    PILUM(WeaponType.THROWING,          1, 5, 1, 10,      false, 0, 2, 3, "Pilum"),
    GLAIVE(WeaponType.THROWING,         3, 5, 1, 15,      false, 0, 2, 6, "Glewia"),
    CEREMONIAL_JAVELIN(WeaponType.THROWING,4, 6, 1, 25,   false, 0, 1, 6, "Ceremonialny oszczep"),

    //bows
    SHORT_BOW(WeaponType.BOW,          2, 5, 2, 20,      true, 0, 4, 9, "Krótki łuk"),
    HUNTER_BOW(WeaponType.BOW,         3, 6, 2, 20,      true, 0, 4, 13, "Myśliwski łuk", new Modifier(ModifierType.HIT, 5)),
    LONG_BOW(WeaponType.BOW,           3, 8, 2, 25,      true, 0, 5, 10, "Długi łuk"),
    ELF_SHORT_BOW(WeaponType.BOW,      3, 5, 2, 20,      true, 0, 3, 13, "Krótki łuk elfów", new Modifier(ModifierType.HIT, 5)),
    ELF_LONG_BOW(WeaponType.BOW,       4, 9, 2, 20,      true, 0, 5, 16, "Długi łuk elfów", new Modifier(ModifierType.HIT, 10)),
    COMBAT_SHORT_BOW(WeaponType.BOW,   3, 6, 1, 20,      true, 0, 5, 15, "Bojowy krótki łuk"),
    COMBAT_LONG_BOW(WeaponType.BOW,    4, 11, 2, 30,      true, 0, 7, 18, "Bojowy długi łuk"),

    //crossbows
    LIGHT_CROSSBOW(WeaponType.CROSSBOW,     4, 7, 3, 15, true, 0, 6, 8, "Lekka kusza"),
    CROSSBOW(WeaponType.CROSSBOW,           6, 9, 3, 15, true, 0, 9, 11, "Kusza"),
    HEAVY_CROSSBOW(WeaponType.CROSSBOW,     8, 15, 4, 20,true, 0, 14, 14, "Ciężka kusza"),
    REPEAT_CROSSBOW(WeaponType.CROSSBOW,    4, 6, 1, 15, true, 0, 10, 9, "Kusza powtarzalna"),

    //mages
    WAND(WeaponType.MAGES,               2, 2, 1, 10,       false, 0, 2, 5, "Różdżka", new Modifier(ModifierType.MANA_MAX, 5)),
    FEATHERY_WAND(WeaponType.MAGES,      3, 3, 1, 15,       false, 0, 1, 6, "Pierzasta różdżka", new Modifier(ModifierType.MANA_MAX, 5), new Modifier(ModifierType.MANA_INCREASE, 1)),
    BONE_WAND(WeaponType.MAGES,          3, 3, 1, 15,       false, 0, 2, 6, "Kościana różdżka", new Modifier(ModifierType.MANA_MAX, 10)),
    KRIN_WAND(WeaponType.MAGES,          5, 5, 1, 15,       false, 0, 2, 9, "Różdżka Krinów"),
    SPHERE(WeaponType.MAGES,             2, 2, 1, 15,       false, 10, 3, 4, "Kula", new Modifier(ModifierType.MANA_INCREASE, 1)),
    HOLY_SPHERE(WeaponType.MAGES,        4, 4, 1, 15,       false, 15, 3, 7, "Święta kula"),
    COLD_SPHERE(WeaponType.MAGES,        3, 3, 1, 10,       false, 15, 5, 7, "Zimna kula", new Modifier(ModifierType.MANA_INCREASE, 2)),
    CLOUD_SPHERE(WeaponType.MAGES,       2, 2, 1, 20,       false, 15, 3, 6, "Kula chmur", new Modifier(ModifierType.MANA_INCREASE, 2)),
    HOT_SPHERE(WeaponType.MAGES,         2, 2, 1, 20,       false, 15, 3, 6, "Gorąca kula", new Modifier(ModifierType.MANA_INCREASE, 2)),
    EARTH_STAFF( WeaponType.MAGES,       4, 4, 1, 25,     true, 25, 6, 10, "Laska ziemi", new Modifier(ModifierType.KNOWLEDGE, 8)),
    STAFF(WeaponType.MAGES,              4, 4, 1, 20,     true, 20, 5, 9, "Laska", new Modifier(ModifierType.KNOWLEDGE, 5)),
    KNOTTY_STAFF(WeaponType.MAGES,       5, 5, 1, 25,     true, 35, 7, 16, "Sękata laska", new Modifier(ModifierType.KNOWLEDGE, 10)),
    WINGED_STAFF(WeaponType.MAGES,       5, 5, 1, 30,     true, 30, 2, 14, "Skrzydlata laska", new Modifier(ModifierType.KNOWLEDGE, 10)),
    ;

    private final WeaponType type;
    private final int dmgMin;
    private final int dmgMax;
    private final int time;
    private final int range;
    private final boolean twoHanded;
    private final int parry;
    private final int weight;
    private final int durabilityMax;
    private final String namePL;
    private final List<Modifier> modifiers;

    WeaponModel(WeaponType type, int dmgMin, int dmgMax, int time, int range, boolean twoHanded, int parry, int weight, int durabilityMax, String namePL, Modifier... modifiers) {
        this.type = type;
        this.dmgMin = dmgMin;
        this.dmgMax = dmgMax;
        this.time = time;
        this.range = range;
        this.twoHanded = twoHanded;
        this.parry = parry;
        this.weight = weight;
        this.durabilityMax = durabilityMax;
        this.namePL = namePL;
        this.modifiers = Arrays.asList(modifiers);
    }
}
