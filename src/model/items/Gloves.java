package model.items;

import lombok.Getter;

@Getter
public class Gloves extends Item{

    private final GlovesModel model;
    private int armor;

    public Gloves(GlovesModel model) {
        super(ItemType.GLOVES, model.getModifiers());
        this.model = model;
        this.armor = model.getArmor();
    }
}
