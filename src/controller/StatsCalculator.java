package controller;

import model.Player;
import model.Skill;
import model.SkillType;
import model.items.Shield;
import model.items.Weapon;
import model.items.WeaponType;

public class StatsCalculator {

    public static int calculateVim(Player player) {
        int vim = (int) Math.round((player.getStrengthBase() + player.getEnduranceBase() + player.getFormBase()) / 3.);
        return vim;
    }

    public static int calculateStrength(Player player) {
        int strength = player.getStrengthBase();
        return strength;
    }

    public static int calculateEndurance(Player player) {
        int endurance = player.getEnduranceBase();
        return endurance;
    }

    public static int calculateForm(Player player) {
        int form = player.getFormBase();
        return form;
    }

    public static int calculateEfficiency(Player player) {
        int efficiency = (int) Math.round((player.getArmBase() + player.getEyeBase() + player.getAgilityBase()) / 3.);
        return efficiency;
    }

    public static int calculateArm(Player player) {
        int arm = player.getArmBase();
        if (player.getArmor() != null)
            arm += player.getArmor().getModel().getArmModifier();
        if (player.getGloves() != null)
            arm += player.getGloves().getModel().getArmModifier();
        return arm;
    }

    public static int calculateEye(Player player) {
        int eye = player.getEyeBase();
        if (player.getHelmet() != null)
            eye += player.getHelmet().getModel().getEyeModifier();
        return eye;
    }

    public static int calculateAgility(Player player) {
        int agility = player.getAgilityBase();
        if (player.getArmor() != null)
            agility += player.getArmor().getModel().getAgilityModifier();
        if (player.getGloves() != null)
            agility += player.getBoots().getModel().getAgilityModifier();
        if (player.getBelt() != null) {
            agility += player.getBelt().getModel().getAgilityModifier();
        }
        return agility;
    }

    public static int calculateIntelligence(Player player) {
        int intelligence = (int) Math.round((player.getKnowledgeBase() + player.getFocusBase() + player.getCharismaBase()) / 3.);
        return intelligence;
    }

    public static int calculateKnowledge(Player player) {
        int knowledge = player.getKnowledgeBase();
        if (player.getHelmet() != null)
            knowledge += player.getHelmet().getModel().getKnowledgeModifier();
        return knowledge;
    }

    public static int calculateFocus(Player player) {
        int focus = player.getFocusBase();
        if (player.getArmor() != null)
            focus += player.getArmor().getModel().getFocusModifier();
        return focus;
    }

    public static int calculateCharisma(Player player) {
        int charisma = player.getCharismaBase();
        if (player.getArmor() != null)
            charisma += player.getArmor().getModel().getCharismaModifier();
        if (player.getHelmet() != null)
            charisma += player.getHelmet().getModel().getCharismaModifier();
        if (player.getAmulet() != null)
            charisma += player.getAmulet().getCharisma();
        if (player.getRing1() != null)
            charisma += player.getRing1().getCharisma();
        if (player.getRing2() != null)
            charisma += player.getRing2().getCharisma();
        return charisma;
    }

    public static int calculateManaMax(Player player) {
        int manaMax = (int) Math.round(player.getIntelligence()/3.);
        Skill magicTalent = player.getSkill(SkillType.MAGIC_TALENT);
        if (magicTalent != null) {
            manaMax += 10 * magicTalent.getLevel();
        }
        return manaMax;
    }

    public static int calculateManaIncrease(Player player) {
        int manaIncrease = (int) Math.round(player.getFocus() / 5.);
        Skill magicTalent = player.getSkill(SkillType.MAGIC_TALENT);
        if (magicTalent != null) {
            manaIncrease += 3 * magicTalent.getLevel();
        }
        return manaIncrease;
    }

    public static int calculateDmgMin(Player player, boolean firstSet) {
        Weapon weapon = firstSet ? player.getWeaponA() : player.getWeaponB();
        if (weapon == null) {
            return (int) Math.round(1 * (1 + player.getStrength()/50.));
        } else if (weapon.getWeaponType().isRange()) {
            return (int) Math.round(weapon.getDmgMin() * (1 + player.getEye()/100.));
        } else if (weapon.getWeaponType().equals(WeaponType.MAGES)){
            return weapon.getDmgMin();
        } else {
            return (int) Math.round(weapon.getDmgMin() * (1 + player.getStrength()/50.));
        }
    }

    public static int calculateDmgMax(Player player, boolean firstSet) {
        Weapon weapon = firstSet ? player.getWeaponA() : player.getWeaponB();
        if (weapon == null) {
            return (int) Math.round(2 * (1 + player.getStrength()/50.));
        } else if (weapon.getWeaponType().isRange()) {
            return (int) Math.round(weapon.getDmgMax() * (1 + player.getEye()/100.));
        } else if (weapon.getWeaponType().equals(WeaponType.MAGES)){
            return weapon.getDmgMax();
        } else {
            return (int) Math.round(weapon.getDmgMax() * (1 + player.getStrength()/50.));
        }
    }

    public static int calculateHit(Player player, boolean firstSet) {
        Weapon weapon = firstSet ? player.getWeaponA() : player.getWeaponB();
        if (weapon == null) {
            return 50 + player.getArm();
        } else if (weapon.getWeaponType().isRange()) {
            return 50 + player.getEye();
        } else if (weapon.getWeaponType().equals(WeaponType.MAGES)) {
            return 50 + player.getFocus();
        } else {
            return 50 + player.getArm();
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
}
