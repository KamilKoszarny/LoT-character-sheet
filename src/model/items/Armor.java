package model.items;

import lombok.Getter;

@Getter
public class Armor extends Item{

    private final ArmorModel model;
    private int headArmor;
    private int bodyArmor;
    private int armsArmor;
    private int legsArmor;

    public Armor(ArmorModel model) {
        super(ItemType.ARMOR, model);
        this.model = model;
        this.headArmor = model.getHeadArmor();
        this.bodyArmor = model.getBodyArmor();
        this.armsArmor = model.getArmsArmor();
        this.legsArmor = model.getLegsArmor();
    }
}
