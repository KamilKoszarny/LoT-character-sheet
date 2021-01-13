package model.items;

import lombok.Getter;

@Getter
public class Shield extends Item{

    private final ShieldModel model;
    private final int block;
    private final int dmg;
    private final int durability;

    public Shield(ShieldModel model) {
        setItemType(ItemType.SHIELD);
        this.model = model;
        this.block = model.getBlock();
        this.dmg = model.getDmg();
        this.durability = model.getDurability();
    }
}