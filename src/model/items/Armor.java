package model.items;

import lombok.Getter;

@Getter
public class Armor extends Item{

    private final ArmorModel model;
    private final int headArmor;
    private int bodyArmor;
    private final int armsArmor;
    private final int legsArmor;

    public Armor(ArmorModel model) {
        super(ItemType.ARMOR, model);
        this.model = model;
        this.headArmor = model.getHeadArmor();
        this.bodyArmor = model.getBodyArmor();
        this.armsArmor = model.getArmsArmor();
        this.legsArmor = model.getLegsArmor();
    }

    @Override
    protected String getSpecificDescription() {
        return "\nPancerz głowy: " + headArmor
                + "\nPancerz tułowia: " + bodyArmor
                + "\nPancerz rąk: " + armsArmor
                + "\nPancerz nóg: " + legsArmor;
    }

    @Override
    protected void updateStatsFromModifiers() {
        super.updateStatsFromModifiers();
        bodyArmor = model.getBodyArmor() + getModifiersSum(ModifierType.ARMOR);
    }
}
