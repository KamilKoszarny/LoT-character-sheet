package model.items;

import lombok.Getter;

@Getter
public class Belt extends Item{

    private final BeltModel model;
    private int armor;

    public Belt(BeltModel model) {
        setItemType(ItemType.BELT);
        this.model = model;
        this.armor = model.getArmor();
    }
}
