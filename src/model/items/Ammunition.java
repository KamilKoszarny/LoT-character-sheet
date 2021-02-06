package model.items;

import lombok.Getter;

@Getter
public class Ammunition extends Item{

    private final AmmunitionModel model;

    public Ammunition(AmmunitionModel model) {
        super(ItemType.AMMUNITION, model);
        this.model = model;
    }
}
