package model.items;

import controller.items.ItemSlot;
import javafx.scene.paint.Color;
import lombok.Getter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
public enum MagicModifier {
    MMP00("Trafny", null, ModifierType.HIT, 5, new Color(0.7, 1, 1, 1), ItemType.WEAPON, ItemType.GLOVES, ItemType.RING),
    MMP01("Celny", null, ModifierType.HIT, 10, new Color(0.6, 1, 0.9, 1), ItemType.WEAPON, ItemType.GLOVES, ItemType.RING),
    MMP02("Precyzyjny", null, ModifierType.HIT, 15, new Color(0.5, 1, 0.8, 1), ItemType.WEAPON, ItemType.GLOVES),
    MMP03("Celujący", null, ModifierType.HIT, 20, new Color(0.4, 1, 0.7, 1), ItemType.WEAPON),
    MMP04("Naprowadzający", null, ModifierType.HIT, 25, new Color(0.3, 1, 0.6, 1), ItemType.WEAPON),

    MMP05("Wygodny", null, ModifierType.DMG_MIN, 2, new Color(0.8, 0.8, 0.8, 1), ItemType.WEAPON, ItemType.GLOVES, ItemType.RING),
    MMP06("Spasowany", null, ModifierType.DMG_MIN, 4, new Color(0.5, 0.5, 0.5, 1), ItemType.WEAPON),
    MMP07("Groźny", null, ModifierType.DMG_MAX, 3, new Color(0.7, 0.7, 0.7, 1), ItemType.WEAPON, ItemType.GLOVES, ItemType.RING),
    MMP08("Okrutny", null, ModifierType.DMG_MAX, 6, new Color(0.4, 0.4, 0.4, 1), ItemType.WEAPON),
    MMP09("Naostrzony", null, ModifierType.DMG, 1, new Color(0.7, 0.7, 0.7, 1), ItemType.WEAPON, ItemType.SHIELD, ItemType.GLOVES, ItemType.RING),
    MMP10("Ostry", null, ModifierType.DMG, 2, new Color(0.5, 0.5, 0.5, 1), ItemType.WEAPON, ItemType.SHIELD, ItemType.GLOVES),
    MMP11("Zębaty", null, ModifierType.DMG, 3, new Color(0.3, 0.3, 0.3, 1), ItemType.WEAPON, ItemType.SHIELD),
    MMP12("Zabójczy", null, ModifierType.DMG, 4, new Color(0.2, 0.2, 0.2, 1), ItemType.WEAPON, ItemType.SHIELD),

    MMP13("Poświęcony", null, ModifierType.DMG_UNDEAD, 20, new Color(1, 0.8, 0.5, 1), ItemType.WEAPON, ItemType.AMULET),
    MMP14("Błogosławiony", null, ModifierType.DMG_UNDEAD, 40, new Color(0.9, 0.7, 0.4, 1), ItemType.WEAPON, ItemType.AMULET),
    MMP15("Konsekrowany", null, ModifierType.DMG_UNDEAD, 60, new Color(0.8, 0.6, 0.3, 1), ItemType.WEAPON, ItemType.AMULET),
    MMP16("Święty", null, ModifierType.DMG_UNDEAD, 80, new Color(0.7, 0.5, 0.2, 1), ItemType.WEAPON),
    MMP17("Boski", null, ModifierType.DMG_UNDEAD, 100, new Color(0.6, 0.4, 0.1, 1), ItemType.WEAPON),

    MMP18("Księżycowy", null, ModifierType.DMG_DEMON, 20, new Color(1, 0.8, 1, 1), ItemType.WEAPON, ItemType.AMULET),
    MMP19("Gwieździsty", null, ModifierType.DMG_DEMON, 40, new Color(0.9, 0.7, 0.9, 1), ItemType.WEAPON, ItemType.AMULET),
    MMP20("Elizejski", null, ModifierType.DMG_DEMON, 60, new Color(0.8, 0.6, 0.8, 1), ItemType.WEAPON, ItemType.AMULET),
    MMP21("Nieziemski", null, ModifierType.DMG_DEMON, 80, new Color(0.7, 0.5, 0.7, 1), ItemType.WEAPON),
    MMP22("Niebiański", null, ModifierType.DMG_DEMON, 100, new Color(0.6, 0.4, 0.6, 1), ItemType.WEAPON),

    MMP23("Ciepły", null, ModifierType.DMG_FIRE, 4, new Color(1, 0.9, 0.4, 1), ItemType.WEAPON, ItemType.GLOVES, ItemType.RING),
    MMP24("Gorący", null, ModifierType.DMG_FIRE, 6, new Color(1, 0.8, 0.3, 1), ItemType.WEAPON, ItemType.RING),
    MMP25("Parzący", null, ModifierType.DMG_FIRE, 8, new Color(1, 0.7, 0.2, 1), ItemType.WEAPON, ItemType.RING),
    MMP26("Płonący", null, ModifierType.DMG_FIRE, 10, new Color(1, 0.6, 0.1, 1), ItemType.WEAPON),
    MMP27("Ognisty", null, ModifierType.DMG_FIRE, 12, new Color(1, 0.5, 0, 1), ItemType.WEAPON),

    MMP28("Chłodny", null, ModifierType.DMG_COLD, 4, new Color(0.4, 0.9, 1, 1), ItemType.WEAPON, ItemType.GLOVES, ItemType.RING),
    MMP29("Zimny", null, ModifierType.DMG_COLD, 6, new Color(0.3, 0.8, 1, 1), ItemType.WEAPON, ItemType.RING),
    MMP30("Lodowaty", null, ModifierType.DMG_COLD, 8, new Color(0.2, 0.7, 1, 1), ItemType.WEAPON, ItemType.RING),
    MMP31("Mrożący", null, ModifierType.DMG_COLD, 10, new Color(0.1, 0.6, 1, 1), ItemType.WEAPON),
    MMP32("Arktyczny", null, ModifierType.DMG_COLD, 12, new Color(0, 0.5, 1, 1), ItemType.WEAPON),

    MMP33("Drżący", null, ModifierType.DMG_WIND, 4, new Color(0.9, 0.7,0.4, 1), ItemType.WEAPON, ItemType.GLOVES, ItemType.RING),
    MMP34("Naładowany", null, ModifierType.DMG_WIND, 6, new Color(0.9, 0.7, 0.3, 1), ItemType.WEAPON, ItemType.RING),
    MMP35("Iskrzący", null, ModifierType.DMG_WIND, 8, new Color(0.9, 0.7, 0.2, 1), ItemType.WEAPON, ItemType.RING),
    MMP36("Kopiący", null, ModifierType.DMG_WIND, 10, new Color(0.9, 0.7, 0.1, 1), ItemType.WEAPON),
    MMP37("Szokujący", null, ModifierType.DMG_WIND, 12, new Color(0.9, 0.7, 0, 1), ItemType.WEAPON),

    MMP38("Gnijący", null, ModifierType.DMG_EARTH, 2, new Color(0.9, 1,0.4, 1), ItemType.WEAPON, ItemType.GLOVES, ItemType.RING),
    MMP39("Skażony", null, ModifierType.DMG_EARTH, 4, new Color(0.8, 1, 0.3, 1), ItemType.WEAPON, ItemType.RING),
    MMP40("Zatruty", null, ModifierType.DMG_EARTH, 6, new Color(0.7, 1, 0.2, 1), ItemType.WEAPON, ItemType.RING),
    MMP41("Zakaźny", null, ModifierType.DMG_EARTH, 8, new Color(0.6, 1, 0.1, 1), ItemType.WEAPON),
    MMP42("Toksyczny", null, ModifierType.DMG_EARTH, 10, new Color(0.5, 1, 0, 1), ItemType.WEAPON),

    MMP43("Dziwny", null, ModifierType.DMG_MAGIC, 20, new Color(0.8, 0.6,1, 1), ItemType.WEAPON, ItemType.AMULET, ItemType.RING),
    MMP44("Zagadkowy", null, ModifierType.DMG_MAGIC, 40, new Color(0.8, 0.6,1, 0.8), ItemType.WEAPON, ItemType.AMULET),
    MMP45("Enigmatyczny", null, ModifierType.DMG_MAGIC, 60, new Color(0.8, 0.6,1, 0.6), ItemType.WEAPON),

    MMP46("Pomyślny", null, ModifierType.HP_PER_KILL, 2, new Color(0.9, 0.6,0.4, 1), ItemType.WEAPON, ItemType.BELT, ItemType.AMULET),
    MMP47("Zwycięski", null, ModifierType.HP_PER_KILL, 3, new Color(0.9, 0.6,0.4, 0.8), ItemType.WEAPON, ItemType.BELT, ItemType.AMULET),
    MMP48("Tryumfujący", null, ModifierType.HP_PER_KILL, 4, new Color(0.9, 0.6,0.4, 0.6), ItemType.WEAPON, ItemType.BELT, ItemType.AMULET),
    MMP49("Dumny", null, ModifierType.MP_PER_KILL, 4, new Color(0.8, 0.2,1, 1), ItemType.WEAPON, ItemType.HELMET, ItemType.AMULET),
    MMP50("Pyszny", null, ModifierType.MP_PER_KILL, 6, new Color(0.8, 0.2,1, 0.8), ItemType.WEAPON, ItemType.HELMET, ItemType.AMULET),
    MMP51("Butny", null, ModifierType.MP_PER_KILL, 8, new Color(0.8, 0.2,1, 0.6), ItemType.WEAPON, ItemType.HELMET, ItemType.AMULET),

    MMP52("Wytrzymały", null, ModifierType.ITEM_DURABILITY, 50, new Color(0.4, 0.4,0.2, 1)),
    MMP53("Trwały", null, ModifierType.ITEM_DURABILITY, 100, new Color(0.4, 0.4,0.2, 0.7)),
    MMP54("Wieczny", null, ModifierType.ITEM_UNBREAKABLE, 0, new Color(0.4, 0.4,0.2, 0.4)),
    MMP55("Mechaniczny", null, ModifierType.ITEM_GEM_PLACES, 1, new Color(0.5, 0.5,0.7, 1)),
    MMP56("Rzemieślniczy", null, ModifierType.ITEM_GEM_PLACES, 2, new Color(0.5, 0.5,0.7, 0.7)),
    MMP57("Jubilerski", null, ModifierType.ITEM_GEM_PLACES, 3, new Color(0.5, 0.5,0.7, 0.5)),

    MMP58("Pewny", null, ModifierType.ARMOR, 1, new Color(0.8, 0.8,0.8, 1), ItemType.HELMET, ItemType.ARMOR, ItemType.GLOVES, ItemType.BOOTS, ItemType.BELT),
    MMP59("Bezpieczny", null, ModifierType.ARMOR, 2, new Color(0.8, 0.8,0.8, 0.8), ItemType.HELMET, ItemType.ARMOR, ItemType.GLOVES, ItemType.BOOTS),
    MMP60("Szczelny", null, ModifierType.ARMOR, 3, new Color(0.8, 0.8,0.8, 0.6), ItemType.HELMET, ItemType.ARMOR, ItemType.GLOVES, ItemType.BOOTS),
    MMP61("Chroniący", null, ModifierType.ARMOR, 4, new Color(0.8, 0.8,0.8, 0.4), ItemType.ARMOR, ItemType.GLOVES, ItemType.BOOTS),
    MMP62("Ratujący", null, ModifierType.ARMOR, 5, new Color(0.8, 0.8,0.8, 0.2), ItemType.ARMOR),

    MMP63("Czerwonawy", null, ModifierType.RES_FIRE, 15, new Color(1, 0.5,0.5, 1)),
    MMP64("Czerwony", null, ModifierType.RES_FIRE, 30, new Color(1, 0.4,0.4, 1)),
    MMP65("Brunatny", null, ModifierType.RES_FIRE, 45, new Color(1, 0.3,0.3, 1), ItemType.SHIELD, ItemType.HELMET, ItemType.ARMOR, ItemType.GLOVES, ItemType.BOOTS, ItemType.BELT, ItemType.AMULET, ItemType.RING),
    MMP66("Karmazynowy", null, ModifierType.RES_FIRE, 60, new Color(1, 0.2,0.2, 1), ItemType.SHIELD, ItemType.HELMET, ItemType.ARMOR, ItemType.BELT, ItemType.AMULET, ItemType.RING),
    MMP67("Rubinowy", null, ModifierType.RES_FIRE, 75, new Color(1, 0.1,0.1, 1), ItemType.SHIELD, ItemType.HELMET, ItemType.ARMOR, ItemType.AMULET),
    MMP68("Niebieskawy", null, ModifierType.RES_COLD, 15, new Color(0.5, 0.5,1, 1)),
    MMP69("Niebieski", null, ModifierType.RES_COLD, 30, new Color(0.4, 0.4,1, 1)),
    MMP70("Granatowy", null, ModifierType.RES_COLD, 45, new Color(0.3, 0.3,1, 1), ItemType.SHIELD, ItemType.HELMET, ItemType.ARMOR, ItemType.GLOVES, ItemType.BOOTS, ItemType.BELT, ItemType.AMULET, ItemType.RING),
    MMP71("Lazurowy", null, ModifierType.RES_COLD, 60, new Color(0.2, 0.2,1, 1), ItemType.SHIELD, ItemType.HELMET, ItemType.ARMOR, ItemType.BELT, ItemType.AMULET, ItemType.RING),
    MMP72("Szafirowy", null, ModifierType.RES_COLD, 75, new Color(0.1, 0.1,1, 1), ItemType.SHIELD, ItemType.HELMET, ItemType.ARMOR, ItemType.AMULET),
    MMP73("Żółtawy", null, ModifierType.RES_WIND, 15, new Color(1, 1,0.7, 1)),
    MMP74("Żółty", null, ModifierType.RES_WIND, 30, new Color(1, 1,0.55, 1)),
    MMP75("Bursztynowy", null, ModifierType.RES_WIND, 45, new Color(1, 1,0.4, 1), ItemType.SHIELD, ItemType.HELMET, ItemType.ARMOR, ItemType.GLOVES, ItemType.BOOTS, ItemType.BELT, ItemType.AMULET, ItemType.RING),
    MMP76("Złoty", null, ModifierType.RES_WIND, 60, new Color(1, 1,0.25, 1), ItemType.SHIELD, ItemType.HELMET, ItemType.ARMOR, ItemType.BELT, ItemType.AMULET, ItemType.RING),
    MMP77("Topazowy", null, ModifierType.RES_WIND, 75, new Color(1, 1,0.1, 1), ItemType.SHIELD, ItemType.HELMET, ItemType.ARMOR, ItemType.AMULET),
    MMP78("Zielonkawy", null, ModifierType.RES_EARTH, 15, new Color(0.5, 1 ,0.5,1)),
    MMP79("Zielony", null, ModifierType.RES_EARTH, 30, new Color(0.4, 1, 0.4, 1)),
    MMP80("Seledynowy", null, ModifierType.RES_EARTH, 45, new Color(0.3, 1, 0.3, 1), ItemType.SHIELD, ItemType.HELMET, ItemType.ARMOR, ItemType.GLOVES, ItemType.BOOTS, ItemType.BELT, ItemType.AMULET, ItemType.RING),
    MMP81("Turkusowy", null, ModifierType.RES_EARTH, 60, new Color(0.2, 1, 0.2, 1), ItemType.SHIELD, ItemType.HELMET, ItemType.ARMOR, ItemType.BELT, ItemType.AMULET, ItemType.RING),
    MMP82("Szmaragdowy", null, ModifierType.RES_EARTH, 75, new Color(0.1, 1, 0.1, 1), ItemType.SHIELD, ItemType.HELMET, ItemType.ARMOR, ItemType.AMULET),
    MMP83("Błyszczący", null, ModifierType.RES_ELEMENTS, 5, new Color(1, 0.7, 1, 1)),
    MMP84("Lśniący", null, ModifierType.RES_ELEMENTS, 10, new Color(1, 0.55, 1, 1)),
    MMP85("Wielobarwny", null, ModifierType.RES_ELEMENTS, 15, new Color(1, 0.4, 1, 1), ItemType.SHIELD, ItemType.HELMET, ItemType.ARMOR, ItemType.GLOVES, ItemType.BOOTS, ItemType.BELT, ItemType.AMULET, ItemType.RING),
    MMP86("Pryzmatyczny", null, ModifierType.RES_ELEMENTS, 20, new Color(1, 0.25, 1, 1), ItemType.SHIELD, ItemType.HELMET, ItemType.ARMOR, ItemType.BELT, ItemType.AMULET, ItemType.RING),
    MMP87("Tęczowy", null, ModifierType.RES_ELEMENTS, 25, new Color(1, 0.1, 1, 1), ItemType.SHIELD, ItemType.HELMET, ItemType.ARMOR, ItemType.AMULET),

    MMP88("Rześki", null, ModifierType.HP_MAX, 2, new Color(1, 0.8, 0.8, 1), ItemType.HELMET, ItemType.ARMOR, ItemType.BELT, ItemType.AMULET, ItemType.RING),
    MMP89("Świeży", null, ModifierType.HP_MAX, 4, new Color(1, 0.6, 0.6, 1), ItemType.ARMOR, ItemType.BELT, ItemType.AMULET),
    MMP90("Zdrowy", null, ModifierType.HP_MAX, 6, new Color(1, 0.4, 0.4, 1), ItemType.ARMOR, ItemType.AMULET),
    MMP91("Żywy", null, ModifierType.HP_MAX, 8, new Color(1, 0.2, 0.2, 1), ItemType.ARMOR, ItemType.AMULET),
    MMP92("Witalny", null, ModifierType.HP_MAX, 8, new Color(1, 0, 0, 1), ItemType.ARMOR),
    MMP93("Łebski", null, ModifierType.MP_MAX, 4, new Color(0.8, 0.8, 1, 1), ItemType.HELMET, ItemType.ARMOR, ItemType.BELT, ItemType.AMULET, ItemType.RING),
    MMP94("Pojętny", null, ModifierType.MP_MAX, 8, new Color(0.6, 0.6, 1, 1), ItemType.ARMOR, ItemType.BELT, ItemType.AMULET),
    MMP95("Rozumny", null, ModifierType.MP_MAX, 12, new Color(0.4, 0.4, 1, 1), ItemType.ARMOR, ItemType.AMULET),
    MMP96("Mądry", null, ModifierType.MP_MAX, 16, new Color(0.2, 0.2, 1, 1), ItemType.ARMOR, ItemType.AMULET),
    MMP97("Światły", null, ModifierType.MP_MAX, 20, new Color(0, 0, 1,1 ), ItemType.ARMOR),


    MMS00(null, "Barana", ModifierType.STRENGTH, 3, new Color(1, 0.6, 0.4, 1), ItemType.WEAPON, ItemType.GLOVES, ItemType.BELT, ItemType.AMULET, ItemType.RING),
    MMS01(null, "Byka", ModifierType.STRENGTH, 6, new Color(1, 0.5, 0.3, 1), ItemType.WEAPON, ItemType.GLOVES, ItemType.BELT, ItemType.AMULET, ItemType.RING),
    MMS02(null, "Niedźwiedzia", ModifierType.STRENGTH, 9, new Color(1, 0.4, 0.2, 1), ItemType.WEAPON, ItemType.GLOVES, ItemType.BELT, ItemType.AMULET),
    MMS03(null, "Słonia", ModifierType.STRENGTH, 12, new Color(1, 0.3, 0.1, 1), ItemType.GLOVES, ItemType.BELT, ItemType.AMULET),
    MMS04(null, "Mamuta", ModifierType.STRENGTH, 15, new Color(1, 0.2, 0, 1), ItemType.GLOVES, ItemType.BELT, ItemType.AMULET),
    MMS05(null, "Robaka", ModifierType.ENDURANCE, 3, new Color(1, 0.4, 0.6, 1), ItemType.SHIELD, ItemType.HELMET, ItemType.ARMOR, ItemType.BELT, ItemType.AMULET, ItemType.RING),
    MMS06(null, "Żółwia", ModifierType.ENDURANCE, 6, new Color(1, 0.3, 0.5, 1), ItemType.SHIELD, ItemType.HELMET, ItemType.ARMOR, ItemType.BELT, ItemType.AMULET, ItemType.RING),
    MMS07(null, "Pancernika", ModifierType.ENDURANCE, 9, new Color(1, 0.2, 0.4, 1), ItemType.SHIELD, ItemType.HELMET, ItemType.ARMOR, ItemType.AMULET),
    MMS08(null, "Krokodyla", ModifierType.ENDURANCE, 12, new Color(1, 0.1, 0.3, 1), ItemType.SHIELD, ItemType.ARMOR, ItemType.AMULET),
    MMS09(null, "Dinozaura", ModifierType.ENDURANCE, 15, new Color(1, 0, 0.2, 1), ItemType.SHIELD, ItemType.ARMOR, ItemType.AMULET),
    MMS10(null, "Osła", ModifierType.FORM, 3, new Color(1, 0.7, 0.6, 1), ItemType.ARMOR, ItemType.BOOTS, ItemType.BELT, ItemType.AMULET, ItemType.RING),
    MMS11(null, "Muła", ModifierType.FORM, 6, new Color(1, 0.6, 0.5, 1), ItemType.ARMOR, ItemType.BOOTS, ItemType.BELT, ItemType.AMULET, ItemType.RING),
    MMS12(null, "Konia", ModifierType.FORM, 9, new Color(1, 0.5, 0.4, 1), ItemType.ARMOR, ItemType.BOOTS, ItemType.BELT, ItemType.AMULET),
    MMS13(null, "Wielbłąda", ModifierType.FORM, 12, new Color(1, 0.4, 0.3, 1), ItemType.BOOTS, ItemType.BELT, ItemType.AMULET),
    MMS14(null, "Pegaza", ModifierType.FORM, 15, new Color(1, 0.3, 0.2, 1), ItemType.BOOTS, ItemType.BELT, ItemType.AMULET),
    MMS15(null, "Wróbla", ModifierType.EYE, 3, new Color(0.6, 1, 0.4, 1), ItemType.WEAPON, ItemType.SHIELD, ItemType.HELMET, ItemType.AMULET, ItemType.RING),
    MMS16(null, "Kruka", ModifierType.EYE, 6, new Color(0.5, 1, 0.3, 1), ItemType.WEAPON, ItemType.SHIELD, ItemType.HELMET, ItemType.AMULET, ItemType.RING),
    MMS17(null, "Jastrzębia", ModifierType.EYE, 9, new Color(0.4, 1, 0.2, 1), ItemType.WEAPON, ItemType.SHIELD, ItemType.HELMET, ItemType.AMULET),
    MMS18(null, "Sokoła", ModifierType.EYE, 12, new Color(0.3, 1, 0.1, 1), ItemType.WEAPON, ItemType.HELMET, ItemType.AMULET),
    MMS19(null, "Orła", ModifierType.EYE, 15, new Color(0.2, 1, 0, 1), ItemType.WEAPON, ItemType.HELMET, ItemType.AMULET),
    MMS20(null, "Makaka", ModifierType.ARM, 3, new Color(0.4, 1, 0.6, 1), ItemType.WEAPON, ItemType.ARMOR, ItemType.GLOVES, ItemType.AMULET, ItemType.RING),
    MMS21(null, "Pawiana", ModifierType.ARM, 6, new Color(0.3, 1, 0.5, 1), ItemType.WEAPON, ItemType.ARMOR, ItemType.GLOVES, ItemType.AMULET, ItemType.RING),
    MMS22(null, "Orangutana", ModifierType.ARM, 9, new Color(0.2, 1, 0.4, 1), ItemType.WEAPON, ItemType.ARMOR, ItemType.GLOVES, ItemType.AMULET),
    MMS23(null, "Goryla", ModifierType.ARM, 12, new Color(0.1, 1, 0.3, 1), ItemType.WEAPON, ItemType.GLOVES, ItemType.AMULET),
    MMS24(null, "Szympansa", ModifierType.ARM, 15, new Color(0, 1, 0.2, 1), ItemType.WEAPON, ItemType.GLOVES, ItemType.AMULET),
    MMS25(null, "Kota", ModifierType.AGILITY, 3, new Color(0.7, 1, 0.6, 1), ItemType.ARMOR, ItemType.BOOTS, ItemType.BELT, ItemType.AMULET, ItemType.RING),
    MMS26(null, "Rysia", ModifierType.AGILITY, 6, new Color(0.6, 1, 0.5, 1), ItemType.ARMOR, ItemType.BOOTS, ItemType.BELT, ItemType.AMULET, ItemType.RING),
    MMS27(null, "Lamparta", ModifierType.AGILITY, 9, new Color(0.5, 1, 0.4, 1), ItemType.ARMOR, ItemType.BOOTS, ItemType.BELT, ItemType.AMULET),
    MMS28(null, "Pumy", ModifierType.AGILITY, 12, new Color(0.4, 1, 0.3, 1), ItemType.ARMOR, ItemType.BOOTS, ItemType.AMULET),
    MMS29(null, "Tygrysa", ModifierType.AGILITY, 15, new Color(0.3, 1, 0.2, 1), ItemType.ARMOR, ItemType.BOOTS, ItemType.AMULET),
    MMS30(null, "Szczura", ModifierType.KNOWLEDGE, 3, new Color(0.6, 0.4, 1, 1), ItemType.WEAPON, ItemType.HELMET, ItemType.BELT, ItemType.AMULET, ItemType.RING),
    MMS31(null, "Królika", ModifierType.KNOWLEDGE, 6, new Color(0.5, 0.3, 1, 1), ItemType.WEAPON, ItemType.HELMET, ItemType.BELT, ItemType.AMULET, ItemType.RING),
    MMS32(null, "Sowy", ModifierType.KNOWLEDGE, 9, new Color(0.4, 0.2, 1, 1), ItemType.WEAPON, ItemType.HELMET, ItemType.BELT, ItemType.AMULET),
    MMS33(null, "Delfina", ModifierType.KNOWLEDGE, 12, new Color(0.3, 0.1, 1, 1), ItemType.HELMET, ItemType.BELT, ItemType.AMULET),
    MMS34(null, "Małpy", ModifierType.KNOWLEDGE, 15, new Color(0.2, 0, 1, 1), ItemType.HELMET, ItemType.BELT, ItemType.AMULET),
    MMS35(null, "Patyczaka", ModifierType.FOCUS, 3, new Color(0.4, 0.6, 1, 1), ItemType.SHIELD, ItemType.HELMET, ItemType.ARMOR, ItemType.AMULET, ItemType.RING),
    MMS36(null, "Pająka", ModifierType.FOCUS, 6, new Color(0.3, 0.5, 1, 1), ItemType.SHIELD, ItemType.HELMET, ItemType.ARMOR, ItemType.AMULET, ItemType.RING),
    MMS37(null, "Leniwca", ModifierType.FOCUS, 9, new Color(0.2, 0.4, 1, 1), ItemType.SHIELD, ItemType.HELMET, ItemType.ARMOR, ItemType.AMULET),
    MMS38(null, "Płaszczki", ModifierType.FOCUS, 12, new Color(0.1, 0.3, 1, 1), ItemType.SHIELD, ItemType.ARMOR, ItemType.AMULET),
    MMS39(null, "Kameleona", ModifierType.FOCUS, 15, new Color(0, 0.2, 1, 1), ItemType.SHIELD, ItemType.ARMOR, ItemType.AMULET),
    MMS40(null, "Muchy", ModifierType.CHARISMA, 3, new Color(0.7, 0.6, 1, 1), ItemType.HELMET, ItemType.GLOVES, ItemType.BOOTS, ItemType.AMULET, ItemType.RING),
    MMS41(null, "Sroki", ModifierType.CHARISMA, 6, new Color(0.6, 0.5, 1, 1), ItemType.HELMET, ItemType.GLOVES, ItemType.BOOTS, ItemType.AMULET, ItemType.RING),
    MMS42(null, "Papugi", ModifierType.CHARISMA, 9, new Color(0.5, 0.4, 1, 1), ItemType.HELMET, ItemType.GLOVES, ItemType.BOOTS, ItemType.AMULET),
    MMS43(null, "Pawia", ModifierType.CHARISMA, 12, new Color(0.4, 0.3, 1, 1), ItemType.HELMET, ItemType.BOOTS, ItemType.AMULET),
    MMS44(null, "Lwa", ModifierType.CHARISMA, 15, new Color(0.3, 0.2, 1, 1), ItemType.HELMET, ItemType.BOOTS, ItemType.AMULET),

    MMS45(null, "Ogłuszenia", ModifierType.STUNN, 1, new Color(0.8, 0.3, 0.1, 1), ItemType.WEAPON, ItemType.GLOVES, ItemType.AMULET),
    MMS46(null, "Szarży", ModifierType.CHARGE, 1, new Color(0.9, 0.2, 0.5, 1), ItemType.WEAPON, ItemType.BOOTS, ItemType.AMULET),
    MMS47(null, "Szału", ModifierType.FURY, 1, new Color(0.9, 0.2, 0.5, 1), ItemType.WEAPON, ItemType.BELT, ItemType.AMULET),
    MMS48(null, "Zamachu", ModifierType.SWING, 1, new Color(1, 0.4, 0.3, 0.5), ItemType.WEAPON, ItemType.RING),
    MMS49(null, "Regeneracji", ModifierType.REGENERATION, 1, new Color(1, 0.6, 0.7, 0.9), ItemType.ARMOR, ItemType.BELT, ItemType.AMULET),
    MMS50(null, "Kamiennej skóry", ModifierType.STONE_SKIN, 1, new Color(1, 0.8, 0.8, 0.5), ItemType.ARMOR, ItemType.SHIELD, ItemType.AMULET),
    MMS51(null, "Gniewu", ModifierType.WRATH, 1, new Color(1, 0.1, 0.2, 1), ItemType.WEAPON, ItemType.SHIELD, ItemType.AMULET),
    MMS52(null, "Tarczownika", ModifierType.SHIELDMAN, 1, new Color(0.6, 0.1, 0.2, 1), ItemType.SHIELD, ItemType.RING),
    MMS53(null, "Zastraszania", ModifierType.INTIMIDATE, 1, new Color(0.5, 0.1, 0.2, 0.6), ItemType.WEAPON, ItemType.HELMET, ItemType.AMULET),
    MMS54(null, "Kowalstwa", ModifierType.BLACKSMITHING, 1, new Color(0.6, 0.1, 0.5, 0.7), ItemType.HELMET, ItemType.GLOVES, ItemType.AMULET),
    MMS55(null, "Wielostrzału", ModifierType.MULTISHOT, 1, new Color(0.3, 0.8, 0.1, 1), ItemType.WEAPON, ItemType.HELMET, ItemType.AMULET),
    MMS56(null, "Krytycznego ciosu", ModifierType.CRITICAL_STRIKE, 1, new Color(0.2, 0.9, 0.5, 1), ItemType.WEAPON, ItemType.GLOVES, ItemType.AMULET),
    MMS57(null, "Rozpoznania", ModifierType.RECOGNITION, 1, new Color(0.2, 0.9, 0.5, 1), ItemType.HELMET, ItemType.RING),
    MMS58(null, "Wytrącania", ModifierType.KNOCK_OFF, 1, new Color(0.4, 1, 0.3, 0.5), ItemType.WEAPON, ItemType.SHIELD, ItemType.AMULET),
    MMS59(null, "Oswajania", ModifierType.TAMING, 1, new Color(0.6, 1, 0.7, 0.9), ItemType.GLOVES, ItemType.RING),
    MMS60(null, "Uników", ModifierType.DODGE_MASTER, 1, new Color(0.8, 1, 0.8, 0.5), ItemType.ARMOR, ItemType.BOOTS, ItemType.AMULET),
    MMS61(null, "Myśliwego", ModifierType.HUNTER, 1, new Color(0.1, 1, 0.2, 1), ItemType.WEAPON, ItemType.BELT, ItemType.AMULET),
    MMS62(null, "Kontry", ModifierType.CONTRA, 1, new Color(0.1, 0.6, 0.2, 1), ItemType.WEAPON, ItemType.SHIELD, ItemType.AMULET),
    MMS63(null, "Jeźdźca", ModifierType.HORSEMEN, 1, new Color(0.1, 0.5, 0.2, 0.6), ItemType.GLOVES, ItemType.BOOTS, ItemType.AMULET),
    MMS64(null, "Ucieczki", ModifierType.ESCAPE, 1, new Color(0.1, 0.6, 0.5, 0.7), ItemType.ARMOR, ItemType.BOOTS, ItemType.AMULET),
    MMS65(null, "Światła", ModifierType.LIGHT_MAGIC, 1, new Color(0.3, 0.1, 0.8, 1), ItemType.WEAPON, ItemType.BELT, ItemType.AMULET),
    MMS66(null, "Mroku", ModifierType.DARK_MAGIC, 1, new Color(0.2, 0.5, 0.9, 1), ItemType.WEAPON, ItemType.ARMOR, ItemType.AMULET),
    MMS67(null, "Żywiołów", ModifierType.ELEMENTAL_MAGIC, 1, new Color(0.2, 0.5, 0.9, 1), ItemType.WEAPON, ItemType.HELMET, ItemType.AMULET),
    MMS68(null, "Przemian", ModifierType.CHANGE_MAGIC, 1, new Color(0.4, 0.3, 1, 0.5), ItemType.WEAPON, ItemType.BOOTS, ItemType.AMULET),
    MMS69(null, "Magii", ModifierType.MAGIC_TALENT, 1, new Color(0.6, 0.7, 1, 0.9), ItemType.HELMET, ItemType.RING),
    MMS70(null, "Alchemii", ModifierType.ALCHEMY, 1, new Color(0.8, 0.8, 1, 0.5), ItemType.GLOVES, ItemType.BELT, ItemType.AMULET),
    MMS71(null, "Medycyny", ModifierType.MEDICINE, 1, new Color(0.1, 0.2, 1, 1), ItemType.SHIELD, ItemType.BELT, ItemType.AMULET),
    MMS72(null, "Inżynierii", ModifierType.ENGINEERING, 1, new Color(0.1, 0.2, 0.6, 1), ItemType.GLOVES, ItemType.BOOTS, ItemType.AMULET),
    MMS73(null, "Targowania", ModifierType.TRADING, 1, new Color(0.1, 0.2, 0.5, 0.6), ItemType.ARMOR, ItemType.RING),
    MMS74(null, "Perswazji", ModifierType.PERSUASION, 1, new Color(0.1, 0.5, 0.6, 0.7), ItemType.WEAPON, ItemType.GLOVES, ItemType.AMULET),

    MMS75(null, "Lekceważenia", ModifierType.RES_MAGIC, 5, new Color(1, 1, 1, 0.8)),
    MMS76(null, "Ignorancji", ModifierType.RES_MAGIC, 10, new Color(1, 1, 1, 0.6)),
    MMS77(null, "Neutralności", ModifierType.RES_MAGIC, 15, new Color(1, 1, 1, 0.4), ItemType.SHIELD, ItemType.HELMET, ItemType.ARMOR, ItemType.GLOVES, ItemType.BOOTS, ItemType.BELT, ItemType.AMULET, ItemType.RING),
    MMS78(null, "Odporności", ModifierType.RES_MAGIC, 20, new Color(1, 1, 1, 0.2), ItemType.SHIELD, ItemType.HELMET, ItemType.ARMOR, ItemType.BELT, ItemType.AMULET, ItemType.RING),
    MMS79(null, "Niewrażliwości", ModifierType.RES_MAGIC, 25, new Color(1, 1, 1, 0.1), ItemType.SHIELD, ItemType.HELMET, ItemType.ARMOR, ItemType.AMULET),

    MMS80(null, "Relaksu", ModifierType.HP_INCREASE, 1, new Color(1, 0.3, 0.6, 0.8), ItemType.ARMOR, ItemType.BELT, ItemType.RING, ItemType.AMULET),
    MMS81(null, "Wypoczynku", ModifierType.HP_INCREASE, 2, new Color(1, 0.3, 0.6, 0.6), ItemType.ARMOR, ItemType.BELT, ItemType.RING, ItemType.AMULET),
    MMS82(null, "Drezena", ModifierType.HP_INCREASE, 3, new Color(1, 0.3, 0.6, 0.4), ItemType.BELT, ItemType.AMULET),
    MMS83(null, "Drzemania", ModifierType.MP_INCREASE, 3, new Color(0.3, 0.6, 1, 0.8), ItemType.HELMET, ItemType.ARMOR, ItemType.RING, ItemType.AMULET),
    MMS84(null, "Snu", ModifierType.MP_INCREASE, 6, new Color(0.3, 0.6, 1, 0.6), ItemType.HELMET, ItemType.ARMOR, ItemType.RING, ItemType.AMULET),
    MMS85(null, "Hardona", ModifierType.MP_INCREASE, 9, new Color(0.3, 0.6, 1,0.4), ItemType.HELMET, ItemType.AMULET),
    MMS86(null, "Czujności", ModifierType.ACTIONS_MAX, 1, new Color(0.3, 1, 0.6, 0.8), ItemType.GLOVES, ItemType.BOOTS, ItemType.RING, ItemType.AMULET),
    MMS87(null, "Strażnika", ModifierType.ACTIONS_MAX, 2, new Color(0.3, 1, 0.6, 0.6), ItemType.GLOVES, ItemType.BOOTS, ItemType.RING, ItemType.AMULET),
    MMS88(null, "Ignosa", ModifierType.ACTIONS_MAX, 3, new Color(0.3, 1, 0.6, 0.4), ItemType.BOOTS, ItemType.AMULET),
    MMS89(null, "Laika", ModifierType.ITEM_REQUIREMENTS, -20, new Color(1, 1, 0.6, 0.8)),
    MMS90(null, "Ucznia", ModifierType.ITEM_REQUIREMENTS, -40, new Color(1, 1, 0.6, 0.6)),
    MMS91(null, "Ellanii", ModifierType.ITEM_REQUIREMENTS, -60, new Color(1, 1, 0.6, 0.4)),
    MMS92(null, "Chodu", ModifierType.SPEED, 1, new Color(0, 0.8, 0.5, 0.8), ItemType.BOOTS, ItemType.BELT, ItemType.RING, ItemType.AMULET),
    MMS93(null, "Biegu", ModifierType.SPEED, 2, new Color(0, 0.8, 0.5, 0.6), ItemType.BOOTS, ItemType.BELT, ItemType.RING, ItemType.AMULET),
    MMS94(null, "Lotu", ModifierType.SPEED, 3, new Color(0, 0.8, 0.5, 0.4), ItemType.BOOTS, ItemType.AMULET),
    ;

    private final String prefix;
    private final String suffix;
    private final ModifierType modifierType;
    private int value;
    private final Color color;
    private Set<ItemType> itemTypes;

    MagicModifier(String prefix, String suffix, ModifierType modifierType, int value, Color color, ItemType... itemTypes) {
        this.prefix = prefix;
        this.suffix = suffix;
        this.modifierType = modifierType;
        this.value = value;
        this.color = color;
        if (itemTypes.length != 0) {
            this.itemTypes = new HashSet<>(Arrays.asList(itemTypes));
        } else {
            this.itemTypes = new HashSet<>();
            this.itemTypes.addAll(Arrays.asList(ItemType.values()));
        }
    }

    public boolean hasPrefix() {
        return prefix != null;
    }

    public String getText() {
        return this.name().substring(3) + " " + (prefix != null ? prefix : suffix);
    }

    public boolean applicableForType(Item item, ItemSlot itemSlot) {
        if (item != null) {
            return itemTypes.contains(item.getItemType());
        }
        if (itemSlot != null) {
            for (ItemType itemType: itemTypes) {
                if (itemSlot.itemTypeCompatibleStrict(itemType)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

}
