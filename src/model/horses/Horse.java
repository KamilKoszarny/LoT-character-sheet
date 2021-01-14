package model.horses;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class Horse implements Serializable {

    private final HorseType type;
    private final int hitPointsMax;
    private final int travelSpeed;
    private final int combatSpeed;
    private final int loadMax;
    private final int loadColumns;
    private int riding;
    private int hitPoints;
    private int armor;

    private String name;
    private String state;
    private String equipmentStr;
    private List<HorseEquipment> equipment;

    public Horse(HorseType type) {
        this.type = type;
        hitPointsMax = type.getHitPointsMax();
        hitPoints = hitPointsMax;
        riding = type.getRiding();
        travelSpeed = type.getTravelSpeed();
        combatSpeed = type.getCombatSpeed();
        loadMax = type.getLoadMax();
        loadColumns = type.getLoadColumns();
    }
}
