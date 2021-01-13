package model;

import controller.PlayerUpdater;
import controller.items.ItemHandler;
import controller.items.ItemSlot;
import lombok.Data;
import model.items.*;

import java.awt.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
public class Player implements Serializable {

    private String fullname;
    private Proffesion proffesion;
    private Race race;
    private String age;
    private String height;
    private String weight;
    private Sign sign;
    private String religion;
    private String origin;
    private String family;
    private String appearance;
    private String history;
    private String state;
    private String notes;

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

    private Skill[] skills = new Skill[6];
    private Trait positiveTrait;
    private Trait neutralTrait;
    private Trait negativeTrait;
    private String abilityI1Time;
    private String abilityI2Time;
    private String abilityII1Time;
    private String abilityII2Time;
    private String abilityIII1Time;
    private String abilityIII2Time;

    private int hitPoints;
    private int hitPointsMax;
    private int hitPointsIncrease = 1;

    private int actions = 5;
    private int actionsMax = 5;
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
    private int attackTimeA;
    private int dmgBMin;
    private int dmgBMax;
    private int hitB;
    private int parryB;
    private int blockB;
    private int dodgeB;
    private int rangeB;
    private int attackTimeB;

    private int armorHead;
    private int armorBody;
    private int armorArms;
    private int armorLegs;

    private int resistFire;
    private int resistCold;
    private int resistWind;
    private int resistEarth;
    private int resistMagic;
    private int resistBodyIllness;
    private int resistMindIllness;

    private HorseType horseType;
    private String horseName;
    private String horseHitPoints;
    private String horseRiding;
    private String horseState;
    private String horseEquipment;

    private Weapon weaponA;
    private Weapon weaponB;
    private Shield shieldA;
    private Shield shieldB;
    private Helmet helmet;
    private Armor armor;
    private Gloves gloves;
    private Boots boots;
    private Amulet amulet;
    private Ring ring1;
    private Ring ring2;
    private Belt belt;

    private String extraInventory;

    private String load;

    private String gold;

    private String bankGold;

    private Map<Item, Point> inventory = new HashMap<>();

    public Skill getSkill(SkillType skillType) {
        for (Skill skill: skills) {
            if (skill != null && skill.getType().equals(skillType))
                return skill;
        }
        return null;
    }

    public Set<Item> getWearItems() {
        Set<Item> wearItems = new HashSet<>();
        for (ItemSlot itemSlot: ItemSlot.values()) {
            Item item = getItem(itemSlot);
            if (item != null && itemSlot != ItemSlot.WEAPON_B && itemSlot != ItemSlot.SHIELD_B) {
                wearItems.add(item);
            }
        }
        return wearItems;
    }

    public Item getItem(ItemSlot itemSlot) {
        switch (itemSlot) {
            case WEAPON_A: return weaponA;
            case WEAPON_B: return weaponB;
            case SHIELD_A: return shieldA;
            case SHIELD_B: return shieldB;
            case HELMET: return helmet;
            case ARMOR: return armor;
            case GLOVES: return gloves;
            case BOOTS: return boots;
            case AMULET: return amulet;
            case RING1: return ring1;
            case RING2: return ring2;
            case BELT: return belt;
        }
        return null;
    }

    public boolean trySetItem(Item item, ItemSlot itemSlot) {
        if (item != null
                && (!itemSlot.itemTypeCompatible(item.getItemType())
                || itemSlot.equals(ItemSlot.WEAPON_A) && ((Weapon) item).getModel().isTwoHanded() && shieldA != null
                || itemSlot.equals(ItemSlot.WEAPON_B) && ((Weapon) item).getModel().isTwoHanded() && shieldB != null
                || itemSlot.equals(ItemSlot.SHIELD_A) && weaponA != null && weaponA.getModel().isTwoHanded()
                || itemSlot.equals(ItemSlot.SHIELD_B) && weaponB != null && weaponB.getModel().isTwoHanded()
        )) {
            return false;
        }

        switch (itemSlot) {
            case WEAPON_A:
                setWeaponA((Weapon) item);
                PlayerUpdater.updateStatsFromWeapon(true);
                break;
            case WEAPON_B:
                setWeaponB((Weapon) item);
                PlayerUpdater.updateStatsFromWeapon(false);
                break;
            case SHIELD_A:
                setShieldA((Shield) item);
                PlayerUpdater.updateBlock(true);
                break;
            case SHIELD_B:
                setShieldB((Shield) item);
                PlayerUpdater.updateBlock(false);
                break;
            case HELMET:
                setHelmet((Helmet) item);
                PlayerUpdater.updateStatsFromArmor();
                break;
            case ARMOR:
                setArmor((Armor) item);
                PlayerUpdater.updateStatsFromArmor();
                break;
            case GLOVES:
                setGloves((Gloves) item);
                PlayerUpdater.updateStatsFromArmor();
                break;
            case BOOTS:
                setBoots((Boots) item);
                PlayerUpdater.updateStatsFromArmor();
                break;
            case AMULET:
                setAmulet((Amulet) item);
                PlayerUpdater.updateCharisma();
                break;
            case RING1:
                setRing1((Ring) item);
                PlayerUpdater.updateCharisma();
                break;
            case RING2:
                setRing2((Ring) item);
                PlayerUpdater.updateCharisma();
                break;
            case BELT:
                setBelt((Belt) item);
                PlayerUpdater.updateStatsFromArmor();
                break;
            case INVENTORY:
                ItemHandler.tryPutNewItemInInventory(item);
                break;
        }
        return true;
    }

    public void addToInventory(Item item, Point slot) {
        getInventory().put(item, slot);
    }

    public void removeFromInventory(Item item) {
        getInventory().remove(item);
    }
}
