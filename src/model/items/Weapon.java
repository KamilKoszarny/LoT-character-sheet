package model.items;

import lombok.Getter;

@Getter
public class Weapon extends Item {

    private final WeaponType weaponType;
    private final WeaponModel model;
    private int dmgMin;
    private int dmgMax;

    public Weapon(WeaponModel model) {
        setItemType(ItemType.WEAPON);
        this.weaponType = model.getType();
        this.model = model;
        this.dmgMin = model.getDmgMin();
        this.dmgMax = model.getDmgMax();
    }
}
