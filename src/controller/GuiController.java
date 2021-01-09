package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import lombok.Getter;
import lombok.Setter;
import model.Proffesion;
import model.Race;
import model.Sign;

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
    private TextField armorHead;

    @FXML
    private TextField armorBody;

    @FXML
    private TextField armorArms;

    @FXML
    private TextField armorLegs;

    @FXML
    private MenuButton weaponAMenu;

    @FXML
    private MenuItem shortSwordA;

    @FXML
    private MenuItem saberA;

    @FXML
    private MenuItem chopperA;

    @FXML
    private MenuItem adzeA;
}

