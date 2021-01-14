package model.items;

import lombok.Getter;

@Getter
public class Helmet extends Item{

    private final HelmetModel model;
    private int armor;

    public Helmet(HelmetModel model) {
        super(ItemType.HELMET, model.getWeight(), model.getModifiers());
        this.model = model;
        this.armor = model.getArmor();
    }
}
