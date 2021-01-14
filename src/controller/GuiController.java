package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import lombok.Getter;
import lombok.Setter;
import model.*;

@Getter
@Setter
public class GuiController {

    @FXML
    private MenuItem open;

    @FXML
    private MenuItem saveAs;

    @FXML
    private TextField fullname;

    @FXML
    private ChoiceBox<Proffesion> proffesion;

    @FXML
    private ChoiceBox<Race> race;

    @FXML
    private TextField age;

    @FXML
    private TextField height;

    @FXML
    private TextField weight;

    @FXML
    private ChoiceBox<Sign> sign;

    @FXML
    private TextField religion;

    @FXML
    private TextField origin;

    @FXML
    private TextField family;

    @FXML
    private TextField appearance;

    @FXML
    private TextArea history;

    @FXML
    private TextField vim;

    @FXML
    private TextField strengthBase;

    @FXML
    private TextField strength;

    @FXML
    private TextField enduranceBase;

    @FXML
    private TextField endurance;

    @FXML
    private TextField formBase;

    @FXML
    private TextField form;

    @FXML
    private TextField efficiency;

    @FXML
    private TextField eyeBase;

    @FXML
    private TextField eye;

    @FXML
    private TextField armBase;

    @FXML
    private TextField arm;

    @FXML
    private TextField agilityBase;

    @FXML
    private TextField agility;

    @FXML
    private TextField intelligence;

    @FXML
    private TextField knowledgeBase;

    @FXML
    private TextField knowledge;

    @FXML
    private TextField focusBase;

    @FXML
    private TextField focus;

    @FXML
    private TextField charismaBase;

    @FXML
    private TextField charisma;

    @FXML
    private TextField luckPoints;

    @FXML
    private TextField experiencePoints;

    @FXML
    private ChoiceBox<Object> skill1;

    @FXML
    private CheckBox skill1lvl1;

    @FXML
    private CheckBox skill1lvl2;

    @FXML
    private CheckBox skill1lvl3;

    @FXML
    private Label skill1description;

    @FXML
    private ChoiceBox<Object> skill2;

    @FXML
    private CheckBox skill2lvl1;

    @FXML
    private CheckBox skill2lvl2;

    @FXML
    private CheckBox skill2lvl3;

    @FXML
    private Label skill2description;

    @FXML
    private ChoiceBox<Object> skill3;

    @FXML
    private CheckBox skill3lvl1;

    @FXML
    private CheckBox skill3lvl2;

    @FXML
    private CheckBox skill3lvl3;

    @FXML
    private Label skill3description;

    @FXML
    private ChoiceBox<Object> skill4;

    @FXML
    private CheckBox skill4lvl1;

    @FXML
    private CheckBox skill4lvl2;

    @FXML
    private CheckBox skill4lvl3;

    @FXML
    private Label skill4description;

    @FXML
    private ChoiceBox<Object> skill5;

    @FXML
    private CheckBox skill5lvl1;

    @FXML
    private CheckBox skill5lvl2;

    @FXML
    private CheckBox skill5lvl3;

    @FXML
    private Label skill5description;

    @FXML
    private ChoiceBox<Object> skill6;

    @FXML
    private CheckBox skill6lvl1;

    @FXML
    private CheckBox skill6lvl2;

    @FXML
    private CheckBox skill6lvl3;

    @FXML
    private Label skill6description;

    @FXML
    private Label traitRaceDescription;

    @FXML
    private ChoiceBox<Trait> traitPositive;

    @FXML
    private Label traitPositiveDescription;

    @FXML
    private ChoiceBox<Trait> traitNeutral;

    @FXML
    private Label traitNeutralDescription;

    @FXML
    private ChoiceBox<Trait> traitNegative;

    @FXML
    private Label traitNegativeDescription;

    @FXML
    private HBox abilitiesI;

    @FXML
    private Label abilityI0;

    @FXML
    private Label abilityI0Description;

    @FXML
    private Label abilityI1;

    @FXML
    private TextField abilityI1Time;

    @FXML
    private Label abilityI1Description;

    @FXML
    private Label abilityI2;

    @FXML
    private TextField abilityI2Time;

    @FXML
    private Label abilityI2Description;

    @FXML
    private HBox abilitiesII;

    @FXML
    private Label abilityII0;

    @FXML
    private Label abilityIIPassive;

    @FXML
    private Label abilityII0Description;

    @FXML
    private Label abilityII1;

    @FXML
    private TextField abilityII1Time;

    @FXML
    private Label abilityII1Description;

    @FXML
    private Label abilityII2;

    @FXML
    private TextField abilityII2Time;

    @FXML
    private Label abilityII2Description;

    @FXML
    private HBox abilitiesIII;

    @FXML
    private Label abilityIII0;

    @FXML
    private Label abilityIII0Description;

    @FXML
    private Label abilityIII1;

    @FXML
    private TextField abilityIII1Time;

    @FXML
    private Label abilityIII1Description;

    @FXML
    private Label abilityIII2;

    @FXML
    private TextField abilityIII2Time;

    @FXML
    private Label abilityIII2Description;

    @FXML
    private TextField hitPoints;

    @FXML
    private Button hitPointsPlus;

    @FXML
    private Button hitPointsMinus;

    @FXML
    private TextField hitPointsIncrease;

    @FXML
    private TextField actions;

    @FXML
    private Button actionsPlus;

    @FXML
    private Button actionsMinus;

    @FXML
    private Button actionsMaxPlus;

    @FXML
    private Button actionsMaxMinus;

    @FXML
    private TextField speed;

    @FXML
    private TextField mana;

    @FXML
    private Button manaPlus;

    @FXML
    private Button manaMinus;

    @FXML
    private TextField manaIncrease;

    @FXML
    private TextField dmgA;

    @FXML
    private TextField hitA;

    @FXML
    private TextField parryA;

    @FXML
    private TextField blockA;

    @FXML
    private TextField dodgeA;

    @FXML
    private TextField rangeA;

    @FXML
    private TextField timeA;

    @FXML
    private TextField dmgB;

    @FXML
    private TextField hitB;

    @FXML
    private TextField parryB;

    @FXML
    private TextField blockB;

    @FXML
    private TextField dodgeB;

    @FXML
    private TextField rangeB;

    @FXML
    private TextField timeB;

    @FXML
    private TextField armorHead;

    @FXML
    private TextField armorBody;

    @FXML
    private TextField armorArms;

    @FXML
    private TextField armorLegs;

    @FXML
    private TextField resistFire;

    @FXML
    private TextField resistCold;

    @FXML
    private TextField resistWind;

    @FXML
    private TextField resistEarth;

    @FXML
    private TextField resistMagic;

    @FXML
    private TextField resistBodyIllness;

    @FXML
    private TextField resistMindIllness;

    @FXML
    private ChoiceBox<HorseType> horseType;

    @FXML
    private TextField horseName;

    @FXML
    private TextField horseHitPoints;

    @FXML
    private TextField horseRiding;

    @FXML
    private TextField horseState;

    @FXML
    private TextArea horseEquipment;

    @FXML
    private AnchorPane itemsPane;

    @FXML
    private MenuButton weaponA;

    @FXML
    private MenuButton weaponB;

    @FXML
    private MenuButton shieldA;

    @FXML
    private MenuButton shieldB;

    @FXML
    private MenuButton helmet;

    @FXML
    private MenuButton armor;

    @FXML
    private MenuButton gloves;

    @FXML
    private MenuButton boots;

    @FXML
    private MenuButton amulet;

    @FXML
    private MenuButton ring1;

    @FXML
    private MenuButton ring2;

    @FXML
    private MenuButton belt;

    @FXML
    private MenuButton inventory;

    @FXML
    private TextArea extraInventory;

    @FXML
    private TextField load;

    @FXML
    private TextField loadExtra;

    @FXML
    private TextField gold;

    @FXML
    private TextField bankGold;

    @FXML
    private TextField satiety;

    @FXML
    private TextField alertness;

    @FXML
    private TextField illnesses;

    @FXML
    private TextArea state;

    @FXML
    private TextArea notes;
}

