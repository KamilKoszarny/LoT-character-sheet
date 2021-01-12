package model.items;

import lombok.Getter;

@Getter
public class Amulet extends Item{

    private final AmuletModel model;

    private int charisma;

    public Amulet(AmuletModel model) {
        setItemType(ItemType.AMULET);
        this.model = model;
        this.charisma = model.getCharisma();
    }
}
