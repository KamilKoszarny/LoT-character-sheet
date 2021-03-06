package model.items;

import lombok.Getter;

@Getter
public class Ring extends Item{

    private final RingModel model;

    public Ring(RingModel model) {
        super(ItemType.RING, model);
        this.model = model;
    }
}
