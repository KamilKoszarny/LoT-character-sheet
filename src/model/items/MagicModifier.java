package model.items;

import javafx.scene.paint.Color;
import lombok.Getter;

import java.util.Set;

@Getter
public enum MagicModifier {
    MMP00("Trafny", null, ModifierType.HIT, 5, new Color(0.7, 1, 1, 1)),
    MMP01("Celny", null, ModifierType.HIT, 10, new Color(0.6, 1, 0.9, 1)),
    MMP02("Precyzyjny", null, ModifierType.HIT, 15, new Color(0.5, 1, 0.8, 1)),
    MMP03("Celujący", null, ModifierType.HIT, 20, new Color(0.4, 1, 0.7, 1)),
    MMP04("Naprowadzający", null, ModifierType.HIT, 25, new Color(0.3, 1, 0.6, 1)),

    MMP05("Wygodny", null, ModifierType.DMG_MIN, 2, new Color(0.8, 0.8, 0.8, 1)),
    MMP06("Spasowany", null, ModifierType.DMG_MIN, 4, new Color(0.5, 0.5, 0.5, 1)),
    MMP07("Groźny", null, ModifierType.DMG_MAX, 3, new Color(0.7, 0.7, 0.7, 1)),
    MMP08("Okrutny", null, ModifierType.DMG_MAX, 6, new Color(0.4, 0.4, 0.4, 1)),
    MMP09("Naostrzony", null, ModifierType.DMG, 1, new Color(0.7, 0.7, 0.7, 1)),
    MMP10("Ostry", null, ModifierType.DMG, 2, new Color(0.5, 0.5, 0.5, 1)),
    MMP11("Zębaty", null, ModifierType.DMG, 3, new Color(0.3, 0.3, 0.3, 1)),
    MMP12("Ciernisty", null, ModifierType.DMG, 4, new Color(0.2, 0.2, 0.2, 1)),

    MMP13("Poświęcony", null, ModifierType.DMG_UNDEAD, 20, new Color(1, 0.8, 0.5, 1)),
    MMP14("Błogosławiony", null, ModifierType.DMG_UNDEAD, 40, new Color(0.9, 0.7, 0.4, 1)),
    MMP15("Konsekrowany", null, ModifierType.DMG_UNDEAD, 60, new Color(0.8, 0.6, 0.3, 1)),
    MMP16("Święty", null, ModifierType.DMG_UNDEAD, 80, new Color(0.7, 0.5, 0.2, 1)),
    MMP17("Boski", null, ModifierType.DMG_UNDEAD, 100, new Color(0.6, 0.4, 0.1, 1)),

    MMP18("Księżycowy", null, ModifierType.DMG_DEMON, 20, new Color(1, 0.8, 1, 1)),
    MMP19("Gwieździsty", null, ModifierType.DMG_DEMON, 40, new Color(0.9, 0.7, 0.9, 1)),
    MMP20("Elizejski", null, ModifierType.DMG_DEMON, 60, new Color(0.8, 0.6, 0.8, 1)),
    MMP21("Nieziemski", null, ModifierType.DMG_DEMON, 80, new Color(0.7, 0.5, 0.7, 1)),
    MMP22("Niebiański", null, ModifierType.DMG_DEMON, 100, new Color(0.6, 0.4, 0.6, 1)),

    MMP23("Ciepły", null, ModifierType.DMG_FIRE, 4, new Color(1, 0.9, 0.4, 1)),
    MMP24("Gorący", null, ModifierType.DMG_FIRE, 6, new Color(1, 0.8, 0.3, 1)),
    MMP25("Parzący", null, ModifierType.DMG_FIRE, 8, new Color(1, 0.7, 0.2, 1)),
    MMP26("Płonący", null, ModifierType.DMG_FIRE, 10, new Color(1, 0.6, 0.1, 1)),
    MMP27("Ognisty", null, ModifierType.DMG_FIRE, 12, new Color(1, 0.5, 0, 1)),

    MMP28("Chłodny", null, ModifierType.DMG_COLD, 4, new Color(0.4, 0.9, 1, 1)),
    MMP29("Zimny", null, ModifierType.DMG_COLD, 6, new Color(0.3, 0.8, 1, 1)),
    MMP30("Lodowaty", null, ModifierType.DMG_COLD, 8, new Color(0.2, 0.7, 1, 1)),
    MMP31("Mrożący", null, ModifierType.DMG_COLD, 10, new Color(0.1, 0.6, 1, 1)),
    MMP32("Arktyczny", null, ModifierType.DMG_COLD, 12, new Color(0, 0.5, 1, 1)),

    MMP33("Drżący", null, ModifierType.DMG_WIND, 4, new Color(0.9, 0.7,0.4, 1)),
    MMP34("Naładowany", null, ModifierType.DMG_WIND, 6, new Color(0.9, 0.7, 0.3, 1)),
    MMP35("Iskrzący", null, ModifierType.DMG_WIND, 8, new Color(0.9, 0.7, 0.2, 1)),
    MMP36("Kopiący", null, ModifierType.DMG_WIND, 10, new Color(0.9, 0.7, 0.1, 1)),
    MMP37("Szokujący", null, ModifierType.DMG_WIND, 12, new Color(0.9, 0.7, 0, 1)),

    MMP38("Gnijący", null, ModifierType.DMG_EARTH, 2, new Color(0.9, 1,0.4, 1)),
    MMP39("Skażony", null, ModifierType.DMG_EARTH, 4, new Color(0.8, 1, 0.3, 1)),
    MMP40("Zatruty", null, ModifierType.DMG_EARTH, 6, new Color(0.7, 1, 0.2, 1)),
    MMP41("Zakaźny", null, ModifierType.DMG_EARTH, 8, new Color(0.6, 1, 0.1, 1)),
    MMP42("Toksyczny", null, ModifierType.DMG_EARTH, 10, new Color(0.5, 1, 0, 1)),

    MMP43("Dziwny", null, ModifierType.DMG_MAGIC, 20, new Color(0.8, 0.6,1, 1)),
    MMP44("Zagadkowy", null, ModifierType.DMG_MAGIC, 40, new Color(0.8, 0.6,1, 0.8)),
    MMP45("Enigmatyczny", null, ModifierType.DMG_MAGIC, 60, new Color(0.8, 0.6,1, 0.6)),



    MMP88("Rześki", null, ModifierType.HP_MAX, 2, new Color(1, 0.8, 0.8, 1)),
    MMP89("Świeży", null, ModifierType.HP_MAX, 4, new Color(1, 0.6, 0.6, 1)),
    MMP90("Zdrowy", null, ModifierType.HP_MAX, 6, new Color(1, 0.4, 0.4, 1)),
    MMP91("Żywy", null, ModifierType.HP_MAX, 8, new Color(1, 0.2, 0.2, 1)),
    MMP92("Witalny", null, ModifierType.HP_MAX, 8, new Color(1, 0, 0, 1)),


    MMS00(null, "Barana", ModifierType.STRENGTH, 3, new Color(1, 0.6, 0.4, 1)),
    MMS01(null, "Byka", ModifierType.STRENGTH, 6, new Color(1, 0.5, 0.3, 1)),
    MMS02(null, "Niedźwiedzia", ModifierType.STRENGTH, 9, new Color(1, 0.4, 0.2, 1)),
    MMS03(null, "Słonia", ModifierType.STRENGTH, 12, new Color(1, 0.3, 0.1, 1)),
    MMS04(null, "Mamuta", ModifierType.STRENGTH, 15, new Color(1, 0.2, 0, 1)),

    MMS05(null, "Robaka", ModifierType.ENDURANCE, 3, new Color(1, 0.4, 0.6, 1)),
    MMS06(null, "Żółwia", ModifierType.ENDURANCE, 6, new Color(1, 0.3, 0.5, 1)),
    MMS07(null, "Pancernika", ModifierType.ENDURANCE, 9, new Color(1, 0.2, 0.4, 1)),
    MMS08(null, "Krokodyla", ModifierType.ENDURANCE, 12, new Color(1, 0.1, 0.3, 1)),
    MMS09(null, "Dinozaura", ModifierType.ENDURANCE, 15, new Color(1, 0, 0.2, 1)),

    MMS10(null, "Osła", ModifierType.FORM, 3, new Color(1, 0.7, 0.6, 1)),
    MMS11(null, "Muła", ModifierType.FORM, 6, new Color(1, 0.6, 0.5, 1)),
    MMS12(null, "Konia", ModifierType.FORM, 9, new Color(1, 0.5, 0.4, 1)),
    MMS13(null, "Wielbłąda", ModifierType.FORM, 12, new Color(1, 0.4, 0.3, 1)),
    MMS14(null, "Pegaza", ModifierType.FORM, 15, new Color(1, 0.3, 0.2, 1)),

    MMS15(null, "Wróbla", ModifierType.EYE, 3, new Color(0.6, 1, 0.4, 1)),
    MMS16(null, "Kruka", ModifierType.EYE, 6, new Color(0.5, 1, 0.3, 1)),
    MMS17(null, "Jastrzębia", ModifierType.EYE, 9, new Color(0.4, 1, 0.2, 1)),
    MMS18(null, "Sokoła", ModifierType.EYE, 12, new Color(0.3, 1, 0.1, 1)),
    MMS19(null, "Orła", ModifierType.EYE, 15, new Color(0.2, 1, 0, 1)),

    MMS20(null, "Makaka", ModifierType.ARM, 3, new Color(0.4, 1, 0.6, 1)),
    MMS21(null, "Pawiana", ModifierType.ARM, 6, new Color(0.3, 1, 0.5, 1)),
    MMS22(null, "Orangutana", ModifierType.ARM, 9, new Color(0.2, 1, 0.4, 1)),
    MMS23(null, "Goryla", ModifierType.ARM, 12, new Color(0.1, 1, 0.3, 1)),
    MMS24(null, "Szympansa", ModifierType.ARM, 15, new Color(0, 1, 0.2, 1)),

    MMS25(null, "Kota", ModifierType.AGILITY, 3, new Color(0.7, 1, 0.6, 1)),
    MMS26(null, "Rysia", ModifierType.AGILITY, 6, new Color(0.6, 1, 0.5, 1)),
    MMS27(null, "Lamparta", ModifierType.AGILITY, 9, new Color(0.5, 1, 0.4, 1)),
    MMS28(null, "Pumy", ModifierType.AGILITY, 12, new Color(0.4, 1, 0.3, 1)),
    MMS29(null, "Tygrysa", ModifierType.AGILITY, 15, new Color(0.3, 1, 0.2, 1)),

    MMS30(null, "Szczura", ModifierType.KNOWLEDGE, 3, new Color(0.6, 0.4, 1, 1)),
    MMS31(null, "Królika", ModifierType.KNOWLEDGE, 6, new Color(0.5, 0.3, 1, 1)),
    MMS32(null, "Sowy", ModifierType.KNOWLEDGE, 9, new Color(0.4, 0.2, 1, 1)),
    MMS33(null, "Delfina", ModifierType.KNOWLEDGE, 12, new Color(0.3, 0.1, 1, 1)),
    MMS34(null, "Małpy", ModifierType.KNOWLEDGE, 15, new Color(0.2, 0, 1, 1)),

    MMS35(null, "Patyczaka", ModifierType.FOCUS, 3, new Color(0.4, 0.6, 1, 1)),
    MMS36(null, "Pająka", ModifierType.FOCUS, 6, new Color(0.3, 0.5, 1, 1)),
    MMS37(null, "Leniwca", ModifierType.FOCUS, 9, new Color(0.2, 0.4, 1, 1)),
    MMS38(null, "Płaszczki", ModifierType.FOCUS, 12, new Color(0.1, 0.3, 1, 1)),
    MMS39(null, "Kameleona", ModifierType.FOCUS, 15, new Color(0, 0.2, 1, 1)),

    MMS40(null, "Muchy", ModifierType.CHARISMA, 3, new Color(0.7, 0.6, 1, 1)),
    MMS41(null, "Sroki", ModifierType.CHARISMA, 6, new Color(0.6, 0.5, 1, 1)),
    MMS42(null, "Papugi", ModifierType.CHARISMA, 9, new Color(0.5, 0.4, 1, 1)),
    MMS43(null, "Pawia", ModifierType.CHARISMA, 12, new Color(0.4, 0.3, 1, 1)),
    MMS44(null, "Lwa", ModifierType.CHARISMA, 15, new Color(0.3, 0.2, 1, 1)),
    ;

    private final String prefix;
    private final String suffix;
    private final ModifierType modifierType;
    private int value;
    private final Color color;
    private Set<Class> itemTypes;

    MagicModifier(String prefix, String suffix, ModifierType modifierType, int value, Color color) {
        this.prefix = prefix;
        this.suffix = suffix;
        this.modifierType = modifierType;
        this.value = value;
        this.color = color;
    }

    public boolean hasPrefix() {
        return prefix != null;
    }

    public String getText() {
        return this.name().substring(3) + " " + (prefix != null ? prefix : suffix);
    }

}
