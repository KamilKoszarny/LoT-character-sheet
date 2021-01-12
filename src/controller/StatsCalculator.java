package controller;

import model.Player;
import model.items.Shield;
import model.items.Weapon;

public class StatsCalculator {

    public static int calculateStrength(Player player) {
        int strength = player.getStrengthBase();
        return strength;
    }

    public static int calculateDmgMin(Player player, boolean firstSet) {
        Weapon weapon = firstSet ? player.getWeaponA() : player.getWeaponB();
        if (weapon == null) {
            return (int) Math.round(1 * (1 + player.getStrength()/50.));
        } else if (weapon.getWeaponType().isRange()) {
            return (int) Math.round(weapon.getDmgMin() * (1 + player.getEye()/100.));
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
        } else {
            return (int) Math.round(weapon.getDmgMax() * (1 + player.getStrength()/50.));
        }
    }

    public static int calculateEndurance(Player player) {
        int endurance = player.getEnduranceBase();
        return endurance;
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

    public static int calculateForm(Player player) {
        int form = player.getFormBase();
        return form;
    }

    public static int calculateVim(Player player) {
        int vim = (int) Math.round((player.getStrengthBase() + player.getEnduranceBase() + player.getFormBase()) / 3.);
        return vim;
    }

    public static int calculateArm(Player player) {
        int arm = player.getArmBase();
        return arm;
    }

    public static int calculateHit(Player player, boolean firstSet) {
        Weapon weapon = firstSet ? player.getWeaponA() : player.getWeaponB();
        if (weapon == null || !weapon.getWeaponType().isRange()) {
            return 50 + player.getArm();
        } else {
            return 50 + player.getEye();
        }
    }

    public static int calculateEye(Player player) {
        int eye = player.getEyeBase();
        return eye;
    }

    public static int calculateAgility(Player player) {
        int agility = player.getAgilityBase();
        return agility;
    }

    public static int calculateDodgeA(Player player) {
        int dodge = (int) Math.round(player.getAgility() / 2.);
        return dodge;
    }

    public static int calculateEfficiency(Player player) {
        int efficiency = (int) Math.round((player.getArmBase() + player.getEyeBase() + player.getAgilityBase()) / 3.);
        return efficiency;
    }

    public static int calculateKnowledge(Player player) {
        int knowledge = player.getKnowledgeBase();
        return knowledge;
    }

    public static int calculateFocus(Player player) {
        int focus = player.getFocusBase();
        return focus;
    }

    public static int calculateManaIncrease(Player player) {
        int manaIncrease = (int) Math.round(player.getFocus() / 5.);
        return manaIncrease;
    }

    public static int calculateCharisma(Player player) {
        int charisma = player.getCharismaBase();
        return charisma;
    }

    public static int calculateIntelligence(Player player) {
        int intelligence = (int) Math.round((player.getKnowledgeBase() + player.getFocusBase() + player.getCharismaBase()) / 3.);
        return intelligence;
    }

    public static int calculateBlock(Player player, boolean firtsSet) {
        Shield shield = firtsSet ? player.getShieldA() : player.getShieldB();
        if (shield == null) {
            return 0;
        }
        return shield.getBlock();
    }
}
