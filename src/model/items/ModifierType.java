package model.items;

import lombok.Getter;

@Getter
public enum ModifierType {

    //attributes
    STRENGTH("<value> do siły"),
    ENDURANCE("<value> do wytrzymałości postaci"),
    FORM("<value> do kondycji"),
    EYE("<value> do oka"),
    ARM("<value> do ręki"),
    AGILITY("<value> do zwinności"),
    KNOWLEDGE("<value> do wiedzy"),
    FOCUS("<value> do skupienia"),
    CHARISMA("<value> do charyzmy"),
    STRENGTH_GROWTH("<value> do przyrostu siły"),
    ENDURANCE_GROWTH("<value> do przyrostu wytrzymałości postaci"),
    FORM_GROWTH("<value> do przyrostu kondycji"),
    EYE_GROWTH("<value> do przyrostu oka"),
    ARM_GROWTH("<value> do przyrostu ręki"),
    AGILITY_GROWTH("<value> do przyrostu zwinności"),
    KNOWLEDGE_GROWTH("<value> do przyrostu wiedzy"),
    FOCUS_GROWTH("<value> do przyrostu skupienia"),
    CHARISMA_GROWTH("<value> do przyrostu charyzmy"),

    //skills
    STUNN("<value> do Ogłuszania"),
    CHARGE("<value> do Szarży"),
    FURY("<value> do Szału"),
    SWING("<value> do Zamachu"),
    REGENERATION("<value> do Regeneracji"),
    STONE_SKIN("<value> do Kamiennej skóry"),
    WRATH("<value> do Gniewu"),
    SHIELDMAN("<value> do Tarczownika"),
    INTIMIDATE("<value> do Zastraszania"),
    BLACKSMITHING("<value> do Kowalstwa"),
    MULTISHOT("<value> do Wielostrzału"),
    CRITICAL_STRIKE("<value> do Krytycznego ciosu"),
    RECOGNITION("<value> do Rozpoznania"),
    KNOCK_OFF("<value> do Wytrącania"),
    TAMING("<value> do Oswajania"),
    DODGE_MASTER("<value> do Mistrza uników"),
    HUNTER("<value> do Myśliwego"),
    CONTRA("<value> do Kontry"),
    HORSEMEN("<value> do Jeździectwa"),
    ESCAPE("<value> do Ucieczki"),
    LIGHT_MAGIC("<value> do "),
    DARK_MAGIC("<value> do "),
    ELEMENTAL_MAGIC("<value> do "),
    CHANGE_MAGIC("<value> do "),
    MAGIC_TALENT("<value> do "),
    ALCHEMY("<value> do "),
    MEDICINE("<value> do "),
    ENGINEERING("<value> do "),
    TRADING("<value> do "),
    PERSUASION("<value> do "),

    //stats
    HP_MAX("<value> do maks. PZ"),
    ACTIONS_MAX("<value> do maks. akcji"),
    MP_MAX("<value> do maks. many"),
    HP_INCREASE("<value> do przyrostu PZ/sen"),
    SPEED("<value>m/s do szybkości w walce"),
    MP_INCREASE("<value> do przyrostu many/sen"),

    DMG_MIN("<value> do obrażeń min."),
    DMG_MAX("<value> do obrażeń max."),
    DMG("<value> do obrażeń"),
    DMG_UNDEAD("<value>% do obr. nieumarłym"),
    DMG_DEMON("<value>% do obr. demonom"),
    DMG_FIRE("+<kvalue> obr. od ognia"),
    DMG_COLD("+<kvalue> obr. od zimna"),
    DMG_WIND("+<kvalue> obr. od powietrza"),
    DMG_EARTH("2 obr. od trucizn przez <kvalue> tur"),
    DMG_MAGIC("<value>% obr. magicznych"),
    DMG_HIDDEN("<value>% obr. z ukrycia"),
    DMG_AGAINST_CHARGE("<value>% obr. przeciw szarży"),

    HIT("<value> do trafienia"),
    PARRY("<value> do parowania"),
    BLOCK("<value> do blokowania"),
    EXTRA_BLOCK("<value> dodatkowy blok"),
    BLOCKS_CONTRA("blokuje kontrę"),
    BLOCK_PROJECTILE("blokuje kontrę"),
    BLOCK_DMG("blok zadaje <value> obr. w rękę"),
    DODGE("<value> do uników"),
    RANGE("<value> do zasięgu"),
    ATTACK_TIME("<value> do obrażeń min."),

    ARMOR("<value> do pancerza"),
    ARMOR_PIERCE("<value> pancerz przeciwnika"),
    ACTIONS_DRAIN("<value> akcje przeciwnika"),
    PUSH("odepchnięcie <kvalue>m"),
    PULL("przyciągnięcie <value>m"),
    PIERCE("<value>% przebicie (potem 1/2 obr.)"),

    LIGHT_MAGIC_USAGE("<value> czary M. Światła"),
    LIGHT_MAGIC_COST("<value>PM czary M. Światła"),
    DARK_MAGIC_USAGE("<value> czary M. Mroku"),
    DARK_MAGIC_COST("<value>PM czary M. Mroku"),
    FIRE_MAGIC_DMG("<value>% obr. od czarów ognia"),
    COLD_MAGIC_DMG("<value>% obr. od czarów zimna"),
    WIND_MAGIC_DMG("<value>% obr. od czarów powietrza"),
    EARTH_MAGIC_DMG("<value>% obr. od czarów ziemi/trucizn"),
    CHANGE_MAGIC_USAGE("<value> czary M. Przemian"),
    CHANGE_FORM_COST("<value>%PM Zwierzęca postać"),
    POTION_SPACE("<value> miejsce na mikstury"),

    RES_FIRE("<value> do odp. na ogień"),
    RES_COLD("<value> do odp. na chłód"),
    RES_WIND("<value> do odp. na wiatr"),
    RES_EARTH("<value> do odp. na ziemię/trucizny"),
    RES_ELEMENTS("<value> do odp. na żywioły"),
    RES_MAGIC("<value> do odp. na magię"),
    RES_BODY_ILL("<value> do odp. na choroby ciała"),
    RES_MIND_ILL("<value> do odp. na choroby umysłu"),

    //others
    HP_PER_KILL("<value>PZ za zabicie przeciwnika"),
    MP_PER_KILL("<value>PM za zabicie przeciwnika"),

    ITEM_DURABILITY("<value>% do maks. wytrzymałości"),
    ITEM_UNBREAKABLE("Niezniszczalny"),
    ITEM_GEM_PLACES("<value> miejsca na klejnot"),
    ITEM_REQUIREMENTS("<value> do wymagań przedmiotu"),
    ITEM_STATS("<value> do statystyk przedmiotu"),
    ;

    private final String description;

    ModifierType(String description) {
        this.description = description;
    }
}
