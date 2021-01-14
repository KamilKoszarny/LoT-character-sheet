package model.items;

import lombok.Getter;

@Getter
public class Amulet extends Item{

    private final AmuletModel model;

    public Amulet(AmuletModel model) {
        super(ItemType.AMULET, 0, model.getModifiers());
        this.model = model;
    }
}
