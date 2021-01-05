package model;

import lombok.Data;

@Data
public class Player {

    private String fullname;
    private Proffesion proffesion;
    private Race race;
    private double age;
    private double height;
    private double weight;
    private Sign sign;
    private String religion;
    private String origin;
    private String appearance;
    private String history;

    private int vim;
    private int strengthBase;
    private int strength;
    private int enduranceBase;
    private int endurance;
    private int formBase;
    private int form;

    private int efficiency;
    private int eyeBase;
    private int eye;
    private int armBase;
    private int arm;
    private int agilityBase;
    private int agility;

    private int intelligence;
    private int knowledgeBase;
    private int knowledge;
    private int focusBase;
    private int focus;
    private int charismaBase;
    private int charisma;

    private int luckPoints;

    private int experiencePoints;

    private int hitPoints;
    private int hitPointsMax;
    private int hitPointsIncreaseByNight;

    private int actions;
    private int actionsMax;
    private int speed;

    private int mana;
    private int manaMax;
    private int manaIncrease;

    private int dmgAMin;
    private int dmgAMax;
    private int hitA;
    private int parryA;
    private int blockA;
    private int dodgeA;
    private int rangeA;

    private int armorHead;
    private int armorBody;
    private int armorArms;
    private int armorLegs;
}
