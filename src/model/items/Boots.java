package model.items;

import lombok.Getter;

@Getter
public class Boots extends Item{

    private final BootsModel model;
    private int armor;

    public Boots(BootsModel model) {
        setItemType(ItemType.BOOTS);
        this.model = model;
        this.armor = model.getArmor();
    }
}
