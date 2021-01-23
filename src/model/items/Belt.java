package model.items;

import lombok.Getter;

@Getter
public class Belt extends Item{

    private final BeltModel model;
    private int armor;

    public Belt(BeltModel model) {
        super(ItemType.BELT, model);
        this.model = model;
        this.armor = model.getArmor();
    }
}
