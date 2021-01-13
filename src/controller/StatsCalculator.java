package controller;

import model.Player;
import model.Skill;
import model.SkillType;
import model.items.*;

public class StatsCalculator {

    public static int calculateVim(Player player) {
        return (int) Math.round((player.getStrengthBase() + player.getEnduranceBase() + player.getFormBase()) / 3.);
    }

    public static int calculateStrength(Player player) {
        int strength = player.getStrengthBase();
        strength += itemsModifiersSum(player, ModifierType.STRENGTH);
        return strength;
    }

    public static int calculateEndurance(Player player) {
        int endurance = player.getEnduranceBase();
        endurance += itemsModifiersSum(player, ModifierType.ENDURANCE);
        return endurance;
    }

    public static int calculateForm(Player player) {
        int form = player.getFormBase();
        form += itemsModifiersSum(player, ModifierType.FORM);
        return form;
    }

    public static int calculateEfficiency(Player player) {
        return (int) Math.round((player.getArmBase() + player.getEyeBase() + player.getAgilityBase()) / 3.);
    }

    public static int calculateArm(Player player) {
        int arm = player.getArmBase();
        arm += itemsModifiersSum(player, ModifierType.ARM);
        return arm;
    }

    public static int calculateEye(Player player) {
        int eye = player.getEyeBase();
        eye += itemsModifiersSum(player, ModifierType.EYE);
        return eye;
    }

    public static int calculateAgility(Player player) {
        int agility = player.getAgilityBase();
        agility += itemsModifiersSum(player, ModifierType.AGILITY);
        return agility;
    }

    public static int calculateIntelligence(Player player) {
        return (int) Math.round((player.getKnowledgeBase() + player.getFocusBase() + player.getCharismaBase()) / 3.);
    }

    public static int calculateKnowledge(Player player) {
        int knowledge = player.getKnowledgeBase();
        knowledge += itemsModifiersSum(player, ModifierType.KNOWLEDGE);
        return knowledge;
    }

    public static int calculateFocus(Player player) {
        int focus = player.getFocusBase();
        focus += itemsModifiersSum(player, ModifierType.FOCUS);
        return focus;
    }

    public static int calculateCharisma(Player player) {
        int charisma = player.getCharismaBase();
        charisma += itemsModifiersSum(player, ModifierType.CHARISMA);
        return charisma;
    }

    public static int calculateHitPointsIncrease(Player player) {
        int hitPointsIncrease = 1;
        hitPointsIncrease += itemsModifiersSum(player, ModifierType.HP_INCREASE);
        Skill regeneration = player.getSkill(SkillType.REGENERATION);
        if (regeneration != null) {
            hitPointsIncrease += regeneration.getLevel() == 1 ? 2 : 4;
        }
        return hitPointsIncrease;
    }

    public static int calculateManaMax(Player player) {
        int manaMax = (int) Math.round(player.getIntelligence()/3.);
        manaMax += itemsModifiersSum(player, ModifierType.MANA_MAX);
        Skill magicTalent = player.getSkill(SkillType.MAGIC_TALENT);
        if (magicTalent != null) {
            manaMax += 10 * magicTalent.getLevel();
        }
        return manaMax;
    }

    public static int calculateManaIncrease(Player player) {
        int manaIncrease = (int) Math.round(player.getFocus() / 5.);
        manaIncrease += itemsModifiersSum(player, ModifierType.MANA_INCREASE);
        Skill magicTalent = player.getSkill(SkillType.MAGIC_TALENT);
        if (magicTalent != null) {
            manaIncrease += 3 * magicTalent.getLevel();
        }
        return manaIncrease;
    }

    public static int calculateDmgMin(Player player, boolean firstSet) {
        int dmgMin = 0;
        Weapon weapon = firstSet ? player.getWeaponA() : player.getWeaponB();
        if (weapon == null) {
            dmgMin += (int) Math.round(1 * (1 + player.getStrength()/50.));
        } else if (weapon.getWeaponType().isRange()) {
            dmgMin += (int) Math.round(weapon.getDmgMin() * (1 + player.getEye()/100.));
        } else if (weapon.getWeaponType().equals(WeaponType.MAGES)){
            dmgMin += weapon.getDmgMin();
        } else {
            dmgMin += (int) Math.round(weapon.getDmgMin() * (1 + player.getStrength()/50.));
        }
        Skill wrath = player.getSkill(SkillType.WRATH);
        if (wrath != null && player.getHitPoints() < 0.4 * player.getHitPointsMax()) {
            dmgMin += 2 * wrath.getLevel();
        }
        return dmgMin;
    }

    public static int calculateDmgMax(Player player, boolean firstSet) {
        int dmgMax = 0;
        Weapon weapon = firstSet ? player.getWeaponA() : player.getWeaponB();
        if (weapon == null) {
            dmgMax += (int) Math.round(2 * (1 + player.getStrength()/50.));
        } else if (weapon.getWeaponType().isRange()) {
            dmgMax += (int) Math.round(weapon.getDmgMax() * (1 + player.getEye()/100.));
        } else if (weapon.getWeaponType().equals(WeaponType.MAGES)){
            dmgMax += weapon.getDmgMax();
        } else {
            dmgMax += (int) Math.round(weapon.getDmgMax() * (1 + player.getStrength()/50.));
        }
        Skill wrath = player.getSkill(SkillType.WRATH);
        if (wrath != null && player.getHitPoints() < 0.4 * player.getHitPointsMax()) {
            dmgMax += 2 * wrath.getLevel();
        }
        return dmgMax;
    }

    public static int calculateHit(Player player, boolean firstSet) {
        Weapon weapon = firstSet ? player.getWeaponA() : player.getWeaponB();
        if (weapon == null) {
            return 50 + player.getArm();
        } else if (weapon.getWeaponType().isRange()) {
            return 50 + player.getEye() + weapon.getModifierValue(ModifierType.HIT);
        } else if (weapon.getWeaponType().equals(WeaponType.MAGES)) {
            return 50 + player.getFocus();
        } else {
            return 50 + player.getArm() + weapon.getModifierValue(ModifierType.HIT);
        }
    }

    public static int calculateParry(Player player, boolean firstSet) {
        Weapon weapon = firstSet ? player.getWeaponA() : player.getWeaponB();
        if (weapon == null) {
            return 0;
        } else {
            return weapon.getParry();
        }
    }

    public static int calculateBlock(Player player, boolean firtsSet) {
        Shield shield = firtsSet ? player.getShieldA() : player.getShieldB();
        if (shield == null) {
            return 0;
        }
        return shield.getBlock();
    }

    public static int calculateDodge(Player player, boolean firstSet) {
        int dodge = (int) Math.round(player.getAgility() / 2.);
        return dodge;
    }

    public static int calculateRange(Player player, boolean firstSet) {
        Weapon weapon = firstSet ? player.getWeaponA() : player.getWeaponB();
        if (weapon == null) {
            return 0;
        } else {
            return weapon.getRange();
        }
    }

    public static int calculateAttackTime(Player player, boolean firstSet) {
        Weapon weapon = firstSet ? player.getWeaponA() : player.getWeaponB();
        if (weapon == null) {
            return 0;
        } else {
            return weapon.getTime();
        }
    }

    public static int calculateArmorHead(Player player) {
        int armorHead = (int) Math.round(player.getEndurance()/20.);
        if (player.getHelmet() != null)
            armorHead += player.getHelmet().getArmor();
        if (player.getArmor() != null)
            armorHead += player.getArmor().getHeadArmor();
        return armorHead;
    }

    public static int calculateArmorBody(Player player) {
        int armorBody = (int) Math.round(player.getEndurance()/20.);
        if (player.getArmor() != null)
            armorBody += player.getArmor().getBodyArmor();
        if (player.getBelt() != null)
            armorBody += player.getBelt().getArmor();
        return armorBody;
    }

    public static int calculateArmorArms(Player player) {
        int armorArms = (int) Math.round(player.getEndurance()/20.);
        if (player.getGloves() != null)
            armorArms += player.getGloves().getArmor();
        if (player.getArmor() != null)
            armorArms += player.getArmor().getArmsArmor();
        return armorArms;
    }

    public static int calculateArmorLegs(Player player) {
        int armorLegs = (int) Math.round(player.getEndurance()/20.);
        if (player.getBoots() != null)
            armorLegs += player.getBoots().getArmor();
        if (player.getArmor() != null)
            armorLegs += player.getArmor().getLegsArmor();
        return armorLegs;
    }

    private static int itemsModifiersSum(Player player, ModifierType modifierType) {
        int sum = 0;
        for (Item item: player.getWearItems()) {
            sum += item.getModifierValue(modifierType);
        }
        return sum;
    }
}
