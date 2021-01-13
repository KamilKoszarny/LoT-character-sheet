package model.items;

import lombok.Getter;

@Getter
public class Weapon extends Item {

    private final WeaponType weaponType;
    private final WeaponModel model;
    private int dmgMin;
    private int dmgMax;
    private int parry;
    private int range;
    private int time;

    public Weapon(WeaponModel model) {
        super(ItemType.WEAPON, model.getModifiers());
        this.weaponType = model.getType();
        this.model = model;
        this.dmgMin = model.getDmgMin();
        this.dmgMax = model.getDmgMax();
        this.parry = model.getParry();
        this.range = model.getRange();
        this.time = model.getTime();
    }
}
