package model.items;

import lombok.Getter;

@Getter
public class Helmet extends Item{

    private HelmetModel model;
    private int armor;

    public Helmet(HelmetModel model) {
        setItemType(ItemType.HELMET);
        this.model = model;
        this.armor = model.getArmor();
    }
}
