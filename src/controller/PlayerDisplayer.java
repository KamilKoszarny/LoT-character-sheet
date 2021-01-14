package controller;

import controller.items.ItemHandler;
import controller.items.ItemSlot;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import model.Ability;
import model.Proffesion;
import model.Skill;
import model.horses.Horse;
import model.items.*;
import utils.Utils;

import java.awt.*;

import static controller.Main.guiController;
import static controller.PlayerUpdater.currentPlayer;

public class PlayerDisplayer {

    public static void displaySkills() {
        displaySkill(1, guiController.getSkill1(), guiController.getSkill1lvl1(), guiController.getSkill1lvl2(), guiController.getSkill1lvl3(), guiController.getSkill1description());
        displaySkill(2, guiController.getSkill2(), guiController.getSkill2lvl1(), guiController.getSkill2lvl2(), guiController.getSkill2lvl3(), guiController.getSkill2description());
        displaySkill(3, guiController.getSkill3(), guiController.getSkill3lvl1(), guiController.getSkill3lvl2(), guiController.getSkill3lvl3(), guiController.getSkill3description());
        displaySkill(4, guiController.getSkill4(), guiController.getSkill4lvl1(), guiController.getSkill4lvl2(), guiController.getSkill4lvl3(), guiController.getSkill4description());
        displaySkill(5, guiController.getSkill5(), guiController.getSkill5lvl1(), guiController.getSkill5lvl2(), guiController.getSkill5lvl3(), guiController.getSkill5description());
        displaySkill(6, guiController.getSkill6(), guiController.getSkill6lvl1(), guiController.getSkill6lvl2(), guiController.getSkill6lvl3(), guiController.getSkill6description());
    }

    private static void displaySkill(int skillNumber, ChoiceBox<Object> choiceBox, CheckBox lvl1Checkbox, CheckBox lvl2Checkbox, CheckBox lvl3Checkbox, Label description) {
        int index = skillNumber - 1;
        Skill skill = currentPlayer.getSkills()[index];
        if (skill != null) {
            choiceBox.getSelectionModel().select(skill.getType());
            if (skill.getLevel() >= 1) {
                lvl1Checkbox.setSelected(true);
            }
            if (skill.getLevel() >= 2) {
                lvl2Checkbox.setSelected(true);
            }
            if (skill.getLevel() == 3) {
                lvl3Checkbox.setSelected(true);
            }
            description.setText(skill.getType().getDescriptionPL());
        } else {
            description.setText(null);
        }
    }

    public static void displayTraits() {
        if (currentPlayer.getRace() != null) {
            guiController.getTraitRaceDescription().setText(currentPlayer.getRace().getTraitDescription());
        }
        if (currentPlayer.getPositiveTrait() != null) {
            guiController.getTraitPositive().getSelectionModel().select(currentPlayer.getPositiveTrait());
            guiController.getTraitPositiveDescription().setText(currentPlayer.getPositiveTrait().getDescriptionPL());
        }
        if (currentPlayer.getNeutralTrait() != null) {
            guiController.getTraitNeutral().getSelectionModel().select(currentPlayer.getNeutralTrait());
            guiController.getTraitNeutralDescription().setText(currentPlayer.getNeutralTrait().getDescriptionPL());
        }
        if (currentPlayer.getNegativeTrait() != null) {
            guiController.getTraitNegative().getSelectionModel().select(currentPlayer.getNegativeTrait());
            guiController.getTraitNegativeDescription().setText(currentPlayer.getNegativeTrait().getDescriptionPL());
        }
    }

    public static void displayAbilities() {
        if (currentPlayer.getProffesion() == null) return;

        final Proffesion lvl1Proffesion = currentPlayer.getProffesion().getLvl1Proffesion();
        guiController.getAbilityI0().setText(Ability.findAbility(lvl1Proffesion, 0).getNamePL());
        guiController.getAbilityI1().setText(Ability.findAbility(lvl1Proffesion, 1).getNamePL());
        guiController.getAbilityI2().setText(Ability.findAbility(lvl1Proffesion, 2).getNamePL());
        guiController.getAbilityI0Description().setText(Ability.findAbility(lvl1Proffesion, 0).getDescriptionPL());
        guiController.getAbilityI1Description().setText(Ability.findAbility(lvl1Proffesion, 1).getDescriptionPL());
        guiController.getAbilityI2Description().setText(Ability.findAbility(lvl1Proffesion, 2).getDescriptionPL());
        guiController.getAbilityI1Time().setText(currentPlayer.getAbilityI1Time());
        guiController.getAbilityI2Time().setText(currentPlayer.getAbilityI2Time());

        if (currentPlayer.getProffesion().getLevel() >= 2) {
            final Proffesion lvl2Proffesion = currentPlayer.getProffesion().getLvl2Proffesion();
            guiController.getAbilityII0().setText(Ability.findAbility(lvl2Proffesion, 0).getNamePL());
            guiController.getAbilityII1().setText(Ability.findAbility(lvl2Proffesion, 1).getNamePL());
            guiController.getAbilityII2().setText(Ability.findAbility(lvl2Proffesion, 2).getNamePL());
            guiController.getAbilityII0Description().setText(Ability.findAbility(lvl2Proffesion, 0).getDescriptionPL());
            guiController.getAbilityII1Description().setText(Ability.findAbility(lvl2Proffesion, 1).getDescriptionPL());
            guiController.getAbilityII2Description().setText(Ability.findAbility(lvl2Proffesion, 2).getDescriptionPL());
            guiController.getAbilityII1Time().setText(currentPlayer.getAbilityII1Time());
            guiController.getAbilityII2Time().setText(currentPlayer.getAbilityII2Time());
        } else {
            guiController.getAbilitiesII().setVisible(false);
        }

        if (currentPlayer.getProffesion().getLevel() == 3) {
            final Proffesion lvl3Proffesion = currentPlayer.getProffesion();
            guiController.getAbilityIII0().setText(Ability.findAbility(lvl3Proffesion, 0).getNamePL());
            guiController.getAbilityIII1().setText(Ability.findAbility(lvl3Proffesion, 1).getNamePL());
            guiController.getAbilityIII2().setText(Ability.findAbility(lvl3Proffesion, 2).getNamePL());
            guiController.getAbilityIII0Description().setText(Ability.findAbility(lvl3Proffesion, 0).getDescriptionPL());
            guiController.getAbilityIII1Description().setText(Ability.findAbility(lvl3Proffesion, 1).getDescriptionPL());
            guiController.getAbilityIII2Description().setText(Ability.findAbility(lvl3Proffesion, 2).getDescriptionPL());
            guiController.getAbilityIII1Time().setText(currentPlayer.getAbilityIII1Time());
            guiController.getAbilityIII2Time().setText(currentPlayer.getAbilityIII2Time());
        } else {
            guiController.getAbilitiesIII().setVisible(false);
        }
    }

    public static void displayHitPoints() {
        guiController.getHitPoints().setText("" + currentPlayer.getHitPoints() + '/' + currentPlayer.getHitPointsMax());
    }

    public static void displayActions() {
        guiController.getActions().setText("" + currentPlayer.getActions() + '/' + currentPlayer.getActionsMax());
    }

    public static void displayMana() {
        guiController.getMana().setText("" + currentPlayer.getMana() + '/' + currentPlayer.getManaMax());
    }

    public static void displayDmg() {
        String dmgAText = "" + currentPlayer.getDmgAMin() + "-" + currentPlayer.getDmgAMax();
        if (currentPlayer.getItem(ItemSlot.SHIELD_A) != null) {
            dmgAText += "/" + currentPlayer.getDmgA2Min() + "-" + currentPlayer.getDmgA2Max();
        }
        guiController.getDmgA().setText(dmgAText);
        String dmgBText = "" + currentPlayer.getDmgBMin() + "-" + currentPlayer.getDmgBMax();
        if (currentPlayer.getItem(ItemSlot.SHIELD_B) != null) {
            dmgBText += "/" + currentPlayer.getDmgB2Min() + "-" + currentPlayer.getDmgB2Max();
        }
        guiController.getDmgB().setText(dmgBText);
    }

    public static void displayHit() {
        String hitAText = "" + currentPlayer.getHitA();
        if (currentPlayer.getWeaponA2ndHand() != null) {
            hitAText += "/" + currentPlayer.getHitA2();
        }
        guiController.getHitA().setText(hitAText);
        String hitBText = "" + currentPlayer.getHitB();
        if (currentPlayer.getWeaponB2ndHand() != null) {
            hitBText += "/" + currentPlayer.getHitB2();
        }
        guiController.getHitB().setText(hitBText);
    }

    public static void displayParry() {
        guiController.getParryA().setText(Integer.toString(currentPlayer.getParryA()));
        guiController.getParryB().setText(Integer.toString(currentPlayer.getParryB()));
    }

    public static void displayBlock() {
        guiController.getBlockA().setText(Integer.toString(currentPlayer.getBlockA()));
        guiController.getBlockB().setText(Integer.toString(currentPlayer.getBlockB()));
    }

    public static void displayDodge() {
        guiController.getDodgeA().setText(Integer.toString(currentPlayer.getDodgeA()));
        guiController.getDodgeB().setText(Integer.toString(currentPlayer.getDodgeB()));
    }

    public static void displayRange() {
        String rangeAText = "" + currentPlayer.getRangeA();
        if (currentPlayer.getWeaponA2ndHand() != null) {
            rangeAText += "/" + currentPlayer.getRangeA2();
        }
        guiController.getRangeA().setText(rangeAText);
        String rangeBText = "" + currentPlayer.getRangeB();
        if (currentPlayer.getWeaponB2ndHand() != null) {
            rangeBText += "/" + currentPlayer.getRangeB2();
        }
        guiController.getRangeB().setText(rangeBText);
    }

    public static void displayAttackTime() {
        String attackTimeAText = "" + currentPlayer.getAttackTimeA();
        if (currentPlayer.getWeaponA2ndHand() != null) {
            attackTimeAText += "/" + currentPlayer.getAttackTimeA2();
        }
        guiController.getTimeA().setText(attackTimeAText);
        String attackTimeBText = "" + currentPlayer.getAttackTimeB();
        if (currentPlayer.getWeaponB2ndHand() != null) {
            attackTimeBText += "/" + currentPlayer.getAttackTimeB2();
        }
        guiController.getTimeB().setText(attackTimeBText);
    }

    public static void displayArmors() {
        guiController.getArmorHead().setText(Integer.toString(currentPlayer.getArmorHead()));
        guiController.getArmorBody().setText(Integer.toString(currentPlayer.getArmorBody()));
        guiController.getArmorArms().setText(Integer.toString(currentPlayer.getArmorArms()));
        guiController.getArmorLegs().setText(Integer.toString(currentPlayer.getArmorLegs()));
    }

    public static void displayResistances() {
        guiController.getResistFire().setText(Integer.toString(currentPlayer.getResistFire()));
        guiController.getResistCold().setText(Integer.toString(currentPlayer.getResistCold()));
        guiController.getResistWind().setText(Integer.toString(currentPlayer.getResistWind()));
        guiController.getResistEarth().setText(Integer.toString(currentPlayer.getResistEarth()));
        guiController.getResistMagic().setText(Integer.toString(currentPlayer.getResistMagic()));
        guiController.getResistBodyIllness().setText(Integer.toString(currentPlayer.getResistBodyIllness()));
        guiController.getResistMindIllness().setText(Integer.toString(currentPlayer.getResistMindIllness()));
    }

    private static void displayEquipment() {
        if (currentPlayer.getWeaponA() != null) {
            displayEquipmentItem(currentPlayer.getWeaponA(), ItemSlot.WEAPON_A);
        }
        if (currentPlayer.getWeaponB() != null) {
            displayEquipmentItem(currentPlayer.getWeaponA(), ItemSlot.WEAPON_B);
        }
        if (currentPlayer.getShieldA() != null) {
            displayEquipmentItem(currentPlayer.getShieldA(), ItemSlot.SHIELD_A);
        }
        if (currentPlayer.getShieldB() != null) {
            displayEquipmentItem(currentPlayer.getShieldB(), ItemSlot.SHIELD_B);
        }
        if (currentPlayer.getHelmet() != null) {
            displayEquipmentItem(currentPlayer.getHelmet(), ItemSlot.HELMET);
        }
        if (currentPlayer.getArmor() != null) {
            displayEquipmentItem(currentPlayer.getArmor(), ItemSlot.ARMOR);
        }
        if (currentPlayer.getGloves() != null) {
            displayEquipmentItem(currentPlayer.getGloves(), ItemSlot.GLOVES);
        }
        if (currentPlayer.getBoots() != null) {
            displayEquipmentItem(currentPlayer.getBoots(), ItemSlot.BOOTS);
        }
        if (currentPlayer.getAmulet() != null) {
            displayEquipmentItem(currentPlayer.getAmulet(), ItemSlot.AMULET);
        }
        if (currentPlayer.getRing1() != null) {
            displayEquipmentItem(currentPlayer.getRing1(), ItemSlot.RING1);
        }
        if (currentPlayer.getRing2() != null) {
            displayEquipmentItem(currentPlayer.getRing2(), ItemSlot.RING2);
        }
        if (currentPlayer.getBelt() != null) {
            displayEquipmentItem(currentPlayer.getBelt(), ItemSlot.BELT);
        }
    }

    public static void displayEquipmentItem(Item item, ItemSlot itemSlot) {
        displayEquipmentItem(item, itemSlot, 1);
        if (itemSlot.equals(ItemSlot.WEAPON_A)) {
            displaySecondHand(item, true);
        } else if (itemSlot.equals(ItemSlot.WEAPON_B)) {
            displaySecondHand(item, false);
        }
    }

    private static void displaySecondHand(Item item, boolean firstSet) {
        Weapon weapon = firstSet ? currentPlayer.getWeaponA() : currentPlayer.getWeaponB();
        Shield shield = firstSet ? currentPlayer.getShieldA() : currentPlayer.getShieldB();
        Weapon weapon2ndHand = firstSet ? currentPlayer.getWeaponA2ndHand() : currentPlayer.getWeaponB2ndHand();
        ItemSlot shieldSlot = firstSet ? ItemSlot.SHIELD_A : ItemSlot.SHIELD_B;

        if (item == null) {
            if (shield == null && weapon2ndHand == null) {
                displayEquipmentItem(null, shieldSlot);
            }
        } else if (weapon.getModel().isTwoHanded()) {
            displayEquipmentItem(weapon, shieldSlot, 0.6);
        } else if (shield == null && weapon2ndHand == null) {
            displayEquipmentItem(null, shieldSlot);
        }
    }

    public static void displayEquipmentItem(Item item, ItemSlot itemSlot, double opacity) {
        MenuButton button = itemSlot.getMenuButton();
        if (item == null) {
            button.setOpacity(0);
        } else {
            Image img = findImage(item);
            ImageView view = new ImageView(img);
            button.setGraphic(view);
            button.setOpacity(opacity);
        }
    }

    public static void displayInventory() {
        for (Item item: currentPlayer.getInventory().keySet()) {
            displayInventoryItem(item, currentPlayer.getInventory().get(item));
        }
        changeInventoryItemsMouseTransparency(ItemHandler.isItemHeld());
    }

    public static void displayInventoryItem(Item item, Point slot) {
        final MenuButton invButton = guiController.getInventory();
        Image itemImage = findImage(item);
        Rectangle rectangle = new Rectangle(
                invButton.getLayoutX() + slot.x * ItemHandler.ITEM_SLOT_SIZE,
                invButton.getLayoutY() + slot.y * ItemHandler.ITEM_SLOT_SIZE,
                itemImage.getWidth(), itemImage.getHeight());
        rectangle.setFill(new ImagePattern(itemImage));
        rectangle.setId(Integer.toString(item.hashCode()));

        ItemHandler.initInventoryItemClick(item, rectangle);

        guiController.getItemsPane().getChildren().add(rectangle);
    }

    public static void removeInventoryItem(Item item) {
        guiController.getItemsPane().getChildren()
                .removeIf(node -> node.getId() != null
                        && node.getId().equals(Integer.toString(item.hashCode())));
    }

    public static void changeInventoryItemsMouseTransparency(boolean transparent) {
        guiController.getItemsPane().getChildren().forEach(node -> {
            if (Utils.isInteger(node.getId())) {
                node.setMouseTransparent(transparent);
            }
        });
    }

    public static void displayLoad() {
        guiController.getLoad().setText("" + (currentPlayer.getLoad() + currentPlayer.getLoadExtra()) + "/" + currentPlayer.getLoadMax());
        guiController.getLoadExtra().setText(Integer.toString(currentPlayer.getLoadExtra()));
    }

    public static Image findImage(Item item) {
        String path = "images/items/";
        switch (item.getItemType()) {
            case WEAPON:
                path += "weapons/" + ((Weapon) item).getModel().name() + ".png";
                break;
            case SHIELD:
                path += "shields/" + ((Shield) item).getModel().name() + ".png";
                break;
            case HELMET:
                path += "helmets/" + ((Helmet) item).getModel().name() + ".png";
                break;
            case ARMOR:
                path += "armors/" + ((Armor) item).getModel().name() + ".png";
                break;
            case GLOVES:
                path += "gloves/" + ((Gloves) item).getModel().name() + ".png";
                break;
            case BOOTS:
                path += "boots/" + ((Boots) item).getModel().name() + ".png";
                break;
            case AMULET:
                path += "amulets/" + ((Amulet) item).getModel().name() + ".png";
                break;
            case RING:
                path += "rings/" + ((Ring) item).getModel().name() + ".png";
                break;
            case BELT:
                path += "belts/" + ((Belt) item).getModel().name() + ".png";
                break;
        }
        return new Image(path);
    }

    public static void displayAllNotAuto() {
        guiController.getProffesion().getSelectionModel().select(currentPlayer.getProffesion());
        guiController.getRace().getSelectionModel().select(currentPlayer.getRace());
        guiController.getSign().getSelectionModel().select(currentPlayer.getSign());
        guiController.getFullname().setText(currentPlayer.getFullname());
        guiController.getAge().setText(currentPlayer.getAge());
        guiController.getHeight().setText(currentPlayer.getHeight());
        guiController.getWeight().setText(currentPlayer.getWeight());
        guiController.getReligion().setText(currentPlayer.getReligion());
        guiController.getOrigin().setText(currentPlayer.getOrigin());
        guiController.getFamily().setText(currentPlayer.getFamily());
        guiController.getAppearance().setText(currentPlayer.getAppearance());
        guiController.getHistory().setText(currentPlayer.getHistory());

        guiController.getVim().setText(Integer.toString(currentPlayer.getVim()));
        guiController.getStrengthBase().setText(Integer.toString(currentPlayer.getStrengthBase()));
        guiController.getStrength().setText(Integer.toString(currentPlayer.getStrength()));
        guiController.getEnduranceBase().setText(Integer.toString(currentPlayer.getEnduranceBase()));
        guiController.getEndurance().setText(Integer.toString(currentPlayer.getEndurance()));
        guiController.getFormBase().setText(Integer.toString(currentPlayer.getFormBase()));
        guiController.getForm().setText(Integer.toString(currentPlayer.getForm()));
        guiController.getEfficiency().setText(Integer.toString(currentPlayer.getEfficiency()));
        guiController.getArmBase().setText(Integer.toString(currentPlayer.getArmBase()));
        guiController.getArm().setText(Integer.toString(currentPlayer.getArm()));
        guiController.getEyeBase().setText(Integer.toString(currentPlayer.getEyeBase()));
        guiController.getEye().setText(Integer.toString(currentPlayer.getEye()));
        guiController.getAgilityBase().setText(Integer.toString(currentPlayer.getAgilityBase()));
        guiController.getAgility().setText(Integer.toString(currentPlayer.getAgility()));
        guiController.getIntelligence().setText(Integer.toString(currentPlayer.getIntelligence()));
        guiController.getKnowledgeBase().setText(Integer.toString(currentPlayer.getKnowledgeBase()));
        guiController.getKnowledge().setText(Integer.toString(currentPlayer.getKnowledge()));
        guiController.getFocusBase().setText(Integer.toString(currentPlayer.getFocusBase()));
        guiController.getFocus().setText(Integer.toString(currentPlayer.getFocus()));
        guiController.getCharismaBase().setText(Integer.toString(currentPlayer.getCharismaBase()));
        guiController.getCharisma().setText(Integer.toString(currentPlayer.getCharisma()));

        displaySkills();
        displayTraits();
        displayAbilities();

        displayHitPoints();
        displayActions();
        displayMana();
        guiController.getHitPointsIncrease().setText(Integer.toString(currentPlayer.getHitPointsIncrease()));
        guiController.getSpeed().setText(Integer.toString(currentPlayer.getSpeed()));
        guiController.getManaIncrease().setText(Integer.toString(currentPlayer.getManaIncrease()));
        displayDmg();
        displayParry();
        displayBlock();
        displayDodge();
        displayHit();
        displayRange();
        displayAttackTime();
        displayDodge();
        displayArmors();
        displayResistances();

        displayHorse();

        displayEquipment();
        displayInventory();
        guiController.getExtraInventory().setText(currentPlayer.getExtraInventory());
        displayLoad();
        guiController.getGold().setText(currentPlayer.getGold());
        guiController.getBankGold().setText(currentPlayer.getBankGold());

        guiController.getSatiety().setText(currentPlayer.getSatiety());
        guiController.getAlertness().setText(currentPlayer.getAlertness());
        guiController.getIllnesses().setText(currentPlayer.getIllnesses());
        guiController.getState().setText(currentPlayer.getState());
        guiController.getNotes().setText(currentPlayer.getNotes());
    }

    public static void displayHorse() {
        Horse horse = currentPlayer.getHorse();
        if (horse != null) {
            guiController.getHorseType().getSelectionModel().select(horse.getType());
            guiController.getHorseName().setText(horse.getName());
            guiController.getHorseHitPoints().setText("" + horse.getHitPoints() + "/" + horse.getHitPointsMax());
            guiController.getHorseRiding().setText(Integer.toString(horse.getRiding()));
            guiController.getHorseState().setText(horse.getState());
            guiController.getHorseEquipment().setText(horse.getEquipment());
        } else {
            guiController.getHorseName().setText(null);
            guiController.getHorseHitPoints().setText(null);
            guiController.getHorseRiding().setText(null);
            guiController.getHorseState().setText(null);
            guiController.getHorseEquipment().setText(null);
        }
    }
}
