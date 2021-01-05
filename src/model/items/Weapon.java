package model.items;

import lombok.Getter;

@Getter
public class Weapon extends Item {

    private WeaponType type;
    private WeaponModel model;
    private int dmgMin;
    private int dmgMax;

    public Weapon(WeaponModel model) {
        this.type = model.getType();
        this.model = model;
        this.dmgMin = model.getDmgMin();
        this.dmgMax = model.getDmgMax();
    }
}
