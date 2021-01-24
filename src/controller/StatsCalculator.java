package controller;

import model.Modifying;
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
        strength += modifiersSum(player, ModifierType.STRENGTH);
        return strength;
    }

    public static int calculateEndurance(Player player) {
        int endurance = player.getEnduranceBase();
        endurance += modifiersSum(player, ModifierType.ENDURANCE);
        return endurance;
    }

    public static int calculateForm(Player player) {
        int form = player.getFormBase();
        form += modifiersSum(player, ModifierType.FORM);
        return form;
    }

    public static int calculateEfficiency(Player player) {
        return (int) Math.round((player.getArmBase() + player.getEyeBase() + player.getAgilityBase()) / 3.);
    }

    public static int calculateArm(Player player) {
        int arm = player.getArmBase();
        arm += modifiersSum(player, ModifierType.ARM);
        return arm;
    }

    public static int calculateEye(Player player) {
        int eye = player.getEyeBase();
        eye += modifiersSum(player, ModifierType.EYE);
        return eye;
    }

    public static int calculateAgility(Player player) {
        int agility = player.getAgilityBase();
        agility += modifiersSum(player, ModifierType.AGILITY);
        return agility;
    }

    public static int calculateIntelligence(Player player) {
        return (int) Math.round((player.getKnowledgeBase() + player.getFocusBase() + player.getCharismaBase()) / 3.);
    }

    public static int calculateKnowledge(Player player) {
        int knowledge = player.getKnowledgeBase();
        knowledge += modifiersSum(player, ModifierType.KNOWLEDGE);
        return knowledge;
    }

    public static int calculateFocus(Player player) {
        int focus = player.getFocusBase();
        focus += modifiersSum(player, ModifierType.FOCUS);
        return focus;
    }

    public static int calculateCharisma(Player player) {
        int charisma = player.getCharismaBase();
        charisma += modifiersSum(player, ModifierType.CHARISMA);
        return charisma;
    }

    public static int calculateHitPointsMax(Player player) {
        int hitPointsMax = (int) Math.round(player.getVim()/3.);
        hitPointsMax += modifiersSum(player, ModifierType.HP_MAX);
        return hitPointsMax;
    }

    public static int calculateHitPointsIncrease(Player player) {
        int hitPointsIncrease = 1;
        hitPointsIncrease += modifiersSum(player, ModifierType.HP_INCREASE);
        Skill regeneration = player.getSkill(SkillType.REGENERATION);
        if (regeneration != null) {
            hitPointsIncrease += regeneration.getLevel() == 1 ? 2 : 4;
        }
        return hitPointsIncrease;
    }

    public static int calculateManaMax(Player player) {
        int manaMax = (int) Math.round(player.getIntelligence()/3.);
        manaMax += modifiersSum(player, ModifierType.MANA_MAX);
        Skill magicTalent = player.getSkill(SkillType.MAGIC_TALENT);
        if (magicTalent != null) {
            manaMax += 10 * magicTalent.getLevel();
        }
        return manaMax;
    }

    public static int calculateManaIncrease(Player player) {
        int manaIncrease = (int) Math.round(player.getFocus() / 5.);
        manaIncrease += modifiersSum(player, ModifierType.MANA_INCREASE);
        Skill magicTalent = player.getSkill(SkillType.MAGIC_TALENT);
        if (magicTalent != null) {
            manaIncrease += 3 * magicTalent.getLevel();
        }
        return manaIncrease;
    }

    public static int calculateDmgMin(Player player, boolean firstSet, boolean firstHand) {
        int dmgMin = 0;
        Weapon weapon = firstSet ? (firstHand ? player.getWeaponA() : player.getWeaponA2ndHand()) : (firstHand ? player.getWeaponB() : player.getWeaponB2ndHand());
        if (weapon == null) {
            dmgMin += (int) Math.round(1 * (1 + player.getStrength()/50.));
        } else if (weapon.getWeaponType().isRange()) {
            dmgMin += (int) Math.round(weapon.getDmgMin() * (1 + player.getEye()/100.));
        } else if (weapon.getWeaponType().equals(WeaponType.MAGES)){
            dmgMin += weapon.getDmgMin();
        } else {
            dmgMin += (int) Math.round(weapon.getDmgMin() * (1 + player.getStrength()/50.));
        }
        return dmgMin + calculateSkillsDmg(player, firstHand);
    }

    public static int calculateDmgMax(Player player, boolean firstSet, boolean firstHand) {
        int dmgMax = 0;
        Weapon weapon = firstSet ? (firstHand ? player.getWeaponA() : player.getWeaponA2ndHand()) : (firstHand ? player.getWeaponB() : player.getWeaponB2ndHand());
        if (weapon == null) {
            dmgMax += (int) Math.round(2 * (1 + player.getStrength()/50.));
        } else if (weapon.getWeaponType().isRange()) {
            dmgMax += (int) Math.round(weapon.getDmgMax() * (1 + player.getEye()/100.));
        } else if (weapon.getWeaponType().equals(WeaponType.MAGES)){
            dmgMax += weapon.getDmgMax();
        } else {
            dmgMax += (int) Math.round(weapon.getDmgMax() * (1 + player.getStrength()/50.));
        }
        return dmgMax + calculateSkillsDmg(player, firstHand);
    }

    private static int calculateSkillsDmg(Player player, boolean firstHand) {
        int dmgMax = 0;
        Skill wrath = player.getSkill(SkillType.WRATH);
        if (wrath != null && player.getHitPoints() < 0.4 * player.getHitPointsMax()) {
            dmgMax += 2 * wrath.getLevel();
        }
        if (!firstHand) {
            if (player.getShieldA() != null) {
                dmgMax = player.getShieldA().getDmg();
                Skill shieldman = player.getSkill(SkillType.SHIELDMAN);
                if (shieldman != null) {
                    dmgMax += shieldman.getLevel();
                }
            } else if (player.getWeaponA2ndHand() == null) {
                dmgMax = 1;
            }
        }
        return dmgMax;
    }

    public static int calculateDmgExtra(Player player, boolean firstSet, boolean firstHand, ModifierType modifierType) {
        int wearDmgExtra = modifiersSum(player, modifierType);
        int firstSet1stHandDmgExtra = player.getWeaponA() != null ? player.getWeaponA().getModifiersSum(modifierType) : 0;
        int firstSet2ndHandDmgExtra = player.getWeaponA2ndHand() != null ? player.getWeaponA2ndHand().getModifiersSum(modifierType)
                : player.getShieldA() != null ? player.getShieldA().getModifiersSum(modifierType) : 0;
        int secondSet1stHandDmgExtra = player.getWeaponB() != null ? player.getWeaponB().getModifiersSum(modifierType) : 0;
        int secondSet2ndHandDmgExtra = player.getWeaponB2ndHand() != null ? player.getWeaponB2ndHand().getModifiersSum(modifierType)
                : player.getShieldB() != null ? player.getShieldB().getModifiersSum(modifierType) : 0;

        if (firstSet) {
            if (firstHand) {
                return wearDmgExtra - firstSet2ndHandDmgExtra;
            } else {
                return wearDmgExtra - firstSet1stHandDmgExtra;
            }
        } else {
            if (firstHand) {
                return wearDmgExtra - firstSet1stHandDmgExtra - firstSet2ndHandDmgExtra + secondSet1stHandDmgExtra;
            } else {
                return wearDmgExtra - firstSet1stHandDmgExtra - firstSet2ndHandDmgExtra + secondSet2ndHandDmgExtra;
            }
        }
    }

    public static int calculateHit(Player player, boolean firstSet, boolean firstHand) {
        int hit = 0;
        Weapon weapon = firstSet ? (firstHand ? player.getWeaponA() : player.getWeaponA2ndHand()) : (firstHand ? player.getWeaponB() : player.getWeaponB2ndHand());
        if (weapon == null) {
            hit += 50 + player.getArm();
        } else if (weapon.getWeaponType().isRange()) {
            hit += 50 + player.getEye() + weapon.getModifiersSum(ModifierType.HIT);
        } else if (weapon.getWeaponType().equals(WeaponType.MAGES)) {
            hit += 50 + player.getFocus();
        } else {
            hit += 50 + player.getArm() + weapon.getModifiersSum(ModifierType.HIT);
        }
        if (!firstHand) {
            hit += -30;
        }
        return hit;
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
        int block = shield.getBlock();
        Skill shieldman = player.getSkill(SkillType.SHIELDMAN);
        if (shieldman != null) {
            block += shieldman.getLevel() * 5;
        }
        return block;
    }

    public static int calculateDodge(Player player, boolean firstSet) {
        int dodge = (int) Math.round(player.getAgility() / 2.);
        return dodge;
    }

    public static int calculateRange(Player player, boolean firstSet, boolean firstHand) {
        Weapon weapon = firstSet ? (firstHand ? player.getWeaponA() : player.getWeaponA2ndHand()) : (firstHand ? player.getWeaponB() : player.getWeaponB2ndHand());
        if (weapon == null) {
            return 0;
        } else {
            return weapon.getRange();
        }
    }

    public static int calculateAttackTime(Player player, boolean firstSet, boolean firstHand) {
        Weapon weapon = firstSet ? (firstHand ? player.getWeaponA() : player.getWeaponA2ndHand()) : (firstHand ? player.getWeaponB() : player.getWeaponB2ndHand());
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

    public static int calculateFireResistance(Player player) {
        int fireResistance = 0;
        fireResistance += modifiersSum(player, ModifierType.RES_FIRE);
        fireResistance += getStoneSkinResistance(player);
        fireResistance += getElementalMagicResistance(player);
        return fireResistance;
    }

    public static int calculateColdResistance(Player player) {
        int coldResistance = 0;
        coldResistance += modifiersSum(player, ModifierType.RES_COLD);
        coldResistance += getStoneSkinResistance(player);
        coldResistance += getElementalMagicResistance(player);
        return coldResistance;
    }

    public static int calculateWindResistance(Player player) {
        int windResistance = 0;
        windResistance += modifiersSum(player, ModifierType.RES_WIND);
        windResistance += getStoneSkinResistance(player);
        windResistance += getElementalMagicResistance(player);
        return windResistance;
    }

    public static int calculateEarthResistance(Player player) {
        int earthResistance = 0;
        earthResistance += modifiersSum(player, ModifierType.RES_EARTH);
        earthResistance += getStoneSkinResistance(player);
        earthResistance += getLightMagicResistance(player);
        earthResistance += getElementalMagicResistance(player);
        return earthResistance;
    }

    public static int calculateMagicResistance(Player player) {
        int magicResistance = 0;
        magicResistance += modifiersSum(player, ModifierType.RES_MAGIC);
        magicResistance += getStoneSkinResistance(player);
        magicResistance += getChangeMagicResistance(player);
        return magicResistance;
    }

    public static int calculateBodyIllnessResistance(Player player) {
        int bodyIllnessResistance = 0;
        bodyIllnessResistance += modifiersSum(player, ModifierType.RES_BODY_ILL);
        bodyIllnessResistance += getLightMagicResistance(player);
        return bodyIllnessResistance;
    }

    public static int calculateMindIllnessResistance(Player player) {
        int mindIllnessResistance = 0;
        mindIllnessResistance += modifiersSum(player, ModifierType.RES_MIND_ILL);
        return mindIllnessResistance;
    }

    public static int calculateLoad(Player player) {
        int load = 0;
        for (Item item: player.getAllItems()) {
            load += item.getWeight();
        }
        return load;
    }

    public static int calculateLoadMax(Player player) {
        int loadMax = player.getStrength() * 2;
        if (player.getHorse() != null) {
            loadMax += player.getHorse().getLoadMax();
        }
        return loadMax;
    }

    private static int getStoneSkinResistance(Player player) {
        Skill stoneSkin = player.getSkill(SkillType.STONE_SKIN);
        if (stoneSkin != null) {
            int lvl = stoneSkin.getLevel();
            return player.getEndurance() / (lvl == 1 ? 10 : lvl == 2 ? 5 : 3);
        }
        return 0;
    }

    private static int getLightMagicResistance(Player player) {
        Skill lightMagic = player.getSkill(SkillType.LIGHT_MAGIC);
        return lightMagic != null ? 10 : 0;
    }

    private static int getElementalMagicResistance(Player player) {
        Skill elementalMagic = player.getSkill(SkillType.ELEMENTAL_MAGIC);
        if (elementalMagic != null) {
            int lvl = elementalMagic.getLevel();
            return lvl == 1 ? 5 : lvl == 2 ? 5 : 12;
        }
        return 0;
    }

    private static int getChangeMagicResistance(Player player) {
        Skill changeMagic = player.getSkill(SkillType.CHANGE_MAGIC);
        if (changeMagic != null && changeMagic.getLevel() >= 2)
            return 20;
        return 0;
    }

    private static int modifiersSum(Player player, ModifierType modifierType) {
        int sum = 0;
        for (Modifying modifying: player.getModifyingObjects()) {
            sum += modifying.getModifiersSum(modifierType);
        }
        return sum;
    }
}
