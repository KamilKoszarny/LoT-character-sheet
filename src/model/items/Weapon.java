package model.items;

import lombok.Getter;

@Getter
public class Weapon extends Item {

    private final WeaponType type;
    private final WeaponModel model;
    private final int dmgMin;
    private final int dmgMax;

    public Weapon(WeaponModel model) {
        this.type = model.getType();
        this.model = model;
        this.dmgMin = model.getDmgMin();
        this.dmgMax = model.getDmgMax();
    }
}
