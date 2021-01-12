package model.items;

import lombok.Getter;

@Getter
public class Ring extends Item{

    private final RingModel model;

    private int charisma;

    public Ring(RingModel model) {
        setItemType(ItemType.RING);
        this.model = model;
        this.charisma = model.getCharisma();
    }
}
