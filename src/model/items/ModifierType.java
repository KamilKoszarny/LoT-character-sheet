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

    //stats
    HP_MAX("<value> do maks. PZ"),
    ACTIONS_MAX("<value> do maks. akcji"),
    MANA_MAX("<value> do maks. many"),
    HP_INCREASE("<value> do przyrostu PZ/sen"),
    SPEED("<value>m/s do szybkości w walce"),
    MANA_INCREASE("<value> do przyrostu many/sen"),

    DMG_MIN("<value> do obrażeń min."),
    DMG_MAX("<value> do obrażeń max."),
    DMG("<value> do obrażeń"),
    HIT("<value> do trafienia"),
    PARRY("<value> do parowania"),
    BLOCK("<value> do blokowania"),
    DODGE("<value> do uników"),
    RANGE("<value> do zasięgu"),
    ATTACK_TIME("<value> do obrażeń min."),

    ARMOR_HEAD("<value> do pancerza głowy"),
    ARMOR_BODY("<value> do pancerza tułowia"),
    ARMOR_ARMS("<value> do pancerza rąk"),
    ARMOR_LEGS("<value> do pancerza nóg"),
    RES_FIRE("<value> do odp. na ogień"),
    RES_COLD("<value> do odp. na chłód"),
    RES_WIND("<value> do odp. na wiatr"),
    RES_EARTH("<value> do odp. na ziemię/trucizny"),
    RES_MAGIC("<value> do odp. na magię"),
    RES_BODY_ILL("<value> do odp. na choroby ciała"),
    RES_MIND_ILL("<value> do odp. na choroby umysłu"),

    //others
    ITEM_REQUIREMENTS("<value> do wymagań przedmiotu"),
    ITEM_STATS("<value> do statystyk przedmiotu"),
    ;

    private final String description;

    ModifierType(String description) {
        this.description = description;
    }
}
