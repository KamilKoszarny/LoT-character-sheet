package model;

import controller.PlayerUpdater;
import controller.items.ItemHandler;
import controller.items.ItemSlot;
import lombok.Data;
import model.horses.Horse;
import model.items.*;

import java.awt.*;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Data
public class Player implements Serializable {

    private String fullname;
    private Profession profession;
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
    private int dmgA2Min;
    private int dmgA2Max;
    private int hitA2;
    private int rangeA2;
    private int attackTimeA2;
    private int dmgBMin;
    private int dmgBMax;
    private int hitB;
    private int parryB;
    private int blockB;
    private int dodgeB;
    private int rangeB;
    private int attackTimeB;
    private int dmgB2Min;
    private int dmgB2Max;
    private int hitB2;
    private int rangeB2;
    private int attackTimeB2;

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

    private Horse horse;

    private Weapon weaponA;
    private Weapon weaponB;
    private Weapon weaponA2ndHand;
    private Weapon weaponB2ndHand;
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

    private Map<Item, Point> inventory = new HashMap<>();
    private String extraInventory;

    private int load;
    private int loadMax;
    private int loadExtra;

    private String gold;
    private String bankGold;

    private String satiety;
    private String alertness;
    private String illnesses;
    private String state;

    private String notes;


    public Skill getSkill(SkillType skillType) {
        for (Skill skill: skills) {
            if (skill != null && skill.getType().equals(skillType))
                return skill;
        }
        return null;
    }

    public Set<Modifying> getModifyingObjects() {
        Set<Modifying> modifyingObjects = new HashSet<>();
        modifyingObjects.addAll(getWearItems());
        modifyingObjects.add(positiveTrait);
        modifyingObjects.add(neutralTrait);
        modifyingObjects.add(negativeTrait);
        //todo illness
        return modifyingObjects.stream().filter(Objects::nonNull).collect(Collectors.toSet());
    }

    public Set<Item> getAllItems() {
        Set<Item> items = new HashSet<>();
        for (ItemSlot itemSlot: ItemSlot.values()) {
            Item item = getItem(itemSlot);
            if (item != null) {
                items.add(item);
            }
        }
        items.addAll(inventory.keySet());
        return items;
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
            case SHIELD_A:
                if (shieldA != null)
                    return shieldA;
                else
                    return weaponA2ndHand;
            case SHIELD_B:
                if (shieldB != null)
                    return shieldB;
                else
                    return weaponB2ndHand;
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
                || itemSlot.equals(ItemSlot.WEAPON_A) && ((Weapon) item).getModel().isTwoHanded() && (shieldA != null || weaponA2ndHand != null)
                || itemSlot.equals(ItemSlot.WEAPON_B) && ((Weapon) item).getModel().isTwoHanded() && (shieldB != null || weaponB2ndHand != null)
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
                if (item == null) {
                    setShieldA(null);
                    setWeaponA2ndHand(null);
                    PlayerUpdater.updateStatsFromWeapon(true);
                    PlayerUpdater.updateBlock(true);
                } else if (item instanceof Weapon) {
                    setWeaponA2ndHand((Weapon) item);
                    PlayerUpdater.updateStatsFromWeapon(true);
                } else {
                    setShieldA((Shield) item);
                    PlayerUpdater.updateDmg(true);
                    PlayerUpdater.updateBlock(true);
                }
                break;
            case SHIELD_B:
                if (item == null) {
                    setShieldB(null);
                    setWeaponB2ndHand(null);
                    PlayerUpdater.updateStatsFromWeapon(false);
                    PlayerUpdater.updateBlock(false);
                } else if (item instanceof Weapon) {
                    setWeaponB2ndHand((Weapon) item);
                    PlayerUpdater.updateStatsFromWeapon(false);
                } else {
                    setShieldB((Shield) item);
                    PlayerUpdater.updateDmg(false);
                    PlayerUpdater.updateBlock(false);
                }
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
        PlayerUpdater.updateLoad();
        return true;
    }

    public void addToInventory(Item item, Point slot) {
        getInventory().put(item, slot);
        PlayerUpdater.updateLoad();
    }

    public void removeFromInventory(Item item) {
        getInventory().remove(item);
        PlayerUpdater.updateLoad();
    }
}
