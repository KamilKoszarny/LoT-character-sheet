package model;

import controller.EquipmentGuiInitializer;
import controller.ItemsDisplayer;
import controller.PlayerUpdater;
import controller.items.ItemHandler;
import controller.items.ItemSlot;
import lombok.Data;
import model.horses.Horse;
import model.items.*;

import java.awt.*;
import java.io.Serializable;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

@Data
public class Player implements Serializable {

    static final long serialVersionUID = 1L;

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
    private String other;

    private int hitPoints;
    private int hitPointsMax;
    private int hitPointsIncrease = 1;

    private int actions = 5;
    private int actionsMax = 5;
    private int actionsMaxExtra;
    private int speed;

    private int mana;
    private int manaMax;
    private int manaIncrease;

    private int dmg1stSetMin;
    private int dmg1stSetMax;
    private int dmg1stSetFire;
    private int dmg1stSetCold;
    private int dmg1stSetWind;
    private int dmg1stSetEarth;
    private int dmg1stSetMagic;
    private int hit1stSet;
    private int parry1stSet;
    private int block1stSet;
    private int dodge1stSet;
    private int range1stSet;
    private int attackTime1stSet;
    private int dmg1stSet2ndHandMin;
    private int dmg1stSet2ndHandMax;
    private int dmg1stSet2ndHandFire;
    private int dmg1stSet2ndHandCold;
    private int dmg1stSet2ndHandWind;
    private int dmg1stSet2ndHandEarth;
    private int dmg1stSet2ndHandMagic;
    private int hit1stSet2ndHand;
    private int range1stSet2ndHand;
    private int attackTime1stSet2ndHand;
    private int dmg2ndSetMin;
    private int dmg2ndSetMax;
    private int dmg2ndSetFire;
    private int dmg2ndSetCold;
    private int dmg2ndSetWind;
    private int dmg2ndSetEarth;
    private int dmg2ndSetMagic;
    private int hit2ndSet;
    private int parry2ndSet;
    private int block2ndSet;
    private int dodge2ndSet;
    private int range2ndSet;
    private int attackTime2ndSet;
    private int dmg2ndSet2ndHandMin;
    private int dmg2ndSet2ndHandMax;
    private int dmg2ndSet2ndHandFire;
    private int dmg2ndSet2ndHandCold;
    private int dmg2ndSet2ndHandWind;
    private int dmg2ndSet2ndHandEarth;
    private int dmg2ndSet2ndHandMagic;
    private int hit2ndSet2ndHand;
    private int range2ndSet2ndHand;
    private int attackTime2ndSet2ndHand;

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

    private Weapon weapon1stSet;
    private Weapon weapon2ndSet;
    private Weapon weapon1stSet2ndHand;
    private Weapon weapon2ndSet2ndHand;
    private Shield shield1stSet;
    private Shield shield2ndSet;
    private Ammunition ammunition1stSet;
    private Ammunition ammunition2ndSet;
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

    public List<Ability> getAbilities() {
        return Arrays.stream(Ability.values()).filter(ability -> ability.getProfession().equals(profession)).collect(Collectors.toList());
    }

    public Set<Modifying> getModifyingObjects() {
        Set<Modifying> modifyingObjects = new HashSet<>();
        //noinspection CollectionAddAllCanBeReplacedWithConstructor
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
            if (item != null && itemSlot != ItemSlot.WEAPON_2ND_SET && itemSlot != ItemSlot.SHIELD_2ND_SET) {
                wearItems.add(item);
            }
        }
        return wearItems;
    }

    public Item getItem(ItemSlot itemSlot) {
        switch (itemSlot) {
            case WEAPON_1ST_SET: return weapon1stSet;
            case WEAPON_2ND_SET: return weapon2ndSet;
            case SHIELD_1ST_SET:
                if (shield1stSet != null)
                    return shield1stSet;
                else if (weapon1stSet2ndHand != null)
                    return weapon1stSet2ndHand;
                else
                    return ammunition1stSet;
            case SHIELD_2ND_SET:
                if (shield2ndSet != null)
                    return shield2ndSet;
                else if (weapon2ndSet2ndHand != null)
                    return weapon2ndSet2ndHand;
                else
                    return ammunition2ndSet;
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
        if (checkIfSetImpossible(item, itemSlot)) return false;

        switch (itemSlot) {
            case WEAPON_1ST_SET:
                setWeapon1stSet((Weapon) item);
                break;
            case WEAPON_2ND_SET:
                setWeapon2ndSet((Weapon) item);
                break;
            case SHIELD_1ST_SET:
                if (item == null) {
                    setShield1stSet(null);
                    setWeapon1stSet2ndHand(null);
                    setAmmunition1stSet(null);
                } else if (item instanceof Weapon) {
                    setWeapon1stSet2ndHand((Weapon) item);
                } else if (item instanceof Shield){
                    setShield1stSet((Shield) item);
                } else {
                    setAmmunition1stSet((Ammunition) item);
                }
                break;
            case SHIELD_2ND_SET:
                if (item == null) {
                    setShield2ndSet(null);
                    setWeapon2ndSet2ndHand(null);
                    setAmmunition2ndSet(null);
                } else if (item instanceof Weapon) {
                    setWeapon2ndSet2ndHand((Weapon) item);
                } else if (item instanceof Shield){
                    setShield2ndSet((Shield) item);
                } else {
                    setAmmunition2ndSet((Ammunition) item);
                }
                break;
            case HELMET:
                setHelmet((Helmet) item);
                break;
            case ARMOR:
                setArmor((Armor) item);
                break;
            case GLOVES:
                setGloves((Gloves) item);
                break;
            case BOOTS:
                setBoots((Boots) item);
                break;
            case AMULET:
                setAmulet((Amulet) item);
                break;
            case RING1:
                setRing1((Ring) item);
                break;
            case RING2:
                setRing2((Ring) item);
                break;
            case BELT:
                setBelt((Belt) item);
                break;
            case INVENTORY:
                ItemHandler.tryPutNewItemInInventory(item);
                break;
        }
        if (!itemSlot.equals(ItemSlot.INVENTORY)) {
            EquipmentGuiInitializer.updateTooltip(null, itemSlot, null);
        }
        PlayerUpdater.updateAll();
        ItemsDisplayer.displayEquipment();
        return true;
    }

    private boolean checkIfSetImpossible(Item item, ItemSlot itemSlot) {
        boolean tryingPutTwoHandedWeaponWhen2ndHandBusy = item != null
                && (itemSlot.equals(ItemSlot.WEAPON_1ST_SET) && ((Weapon) item).getModel().isTwoHanded() && (shield1stSet != null || weapon1stSet2ndHand != null)
                || itemSlot.equals(ItemSlot.WEAPON_2ND_SET) && ((Weapon) item).getModel().isTwoHanded() && (shield2ndSet != null || weapon2ndSet2ndHand != null));
        boolean tryingPutTo2ndHandWhenHasTwoHandedWeaponAndItsNotBowPlusArrowsOrCrossbowPlusBolts = item != null
                && ((itemSlot.equals(ItemSlot.SHIELD_1ST_SET) && weapon1stSet != null && weapon1stSet.getModel().isTwoHanded()
                && !(item.getModel().equals(AmmunitionModel.ARROWS) && weapon1stSet.getWeaponType().equals(WeaponType.BOW))
                && !(item.getModel().equals(AmmunitionModel.BOLTS) && weapon1stSet.getWeaponType().equals(WeaponType.CROSSBOW)))
                || (itemSlot.equals(ItemSlot.SHIELD_2ND_SET) && weapon2ndSet != null && weapon2ndSet.getModel().isTwoHanded()
                && !(item.getModel().equals(AmmunitionModel.ARROWS) && weapon1stSet.getWeaponType().equals(WeaponType.BOW))
                && !(item.getModel().equals(AmmunitionModel.BOLTS) && weapon1stSet.getWeaponType().equals(WeaponType.CROSSBOW)))
        );
        return item != null
                && (!itemSlot.itemTypeCompatible(item.getType())
                || tryingPutTwoHandedWeaponWhen2ndHandBusy
                || tryingPutTo2ndHandWhenHasTwoHandedWeaponAndItsNotBowPlusArrowsOrCrossbowPlusBolts
        );
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
