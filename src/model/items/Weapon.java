package model.items;

import lombok.Getter;

import java.util.Optional;
import java.util.Set;

@Getter
public class Weapon extends Item {

    private final WeaponType weaponType;
    private final WeaponModel model;
    private int dmgMin;
    private int dmgMax;
    private int parry;
    private int range;
    private int time;
    private Set<Modifier> modifiers;

    public Weapon(WeaponModel model) {
        setItemType(ItemType.WEAPON);
        this.weaponType = model.getType();
        this.model = model;
        this.dmgMin = model.getDmgMin();
        this.dmgMax = model.getDmgMax();
        this.parry = model.getParry();
        this.range = model.getRange();
        this.time = model.getTime();
        this.modifiers = model.getModifiers();
    }

    public int getModifierValue(ModifierType modifierType) {
        final Optional<Modifier> optionalModifier = this.modifiers.stream().filter(modifier -> modifier.getType().equals(modifierType)).findFirst();
        return optionalModifier.map(Modifier::getValue).orElse(0);
    }
}
