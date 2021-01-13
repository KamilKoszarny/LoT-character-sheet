package model.items;

import lombok.Getter;

@Getter
public class Amulet extends Item{

    private final AmuletModel model;

    public Amulet(AmuletModel model) {
        super(ItemType.AMULET, model.getModifiers());
        this.model = model;
    }
}
