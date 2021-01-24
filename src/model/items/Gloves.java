package model.items;

import lombok.Getter;

@Getter
public class Gloves extends Item{

    private final GlovesModel model;
    private int armor;

    public Gloves(GlovesModel model) {
        super(ItemType.GLOVES, model);
        this.model = model;
        this.armor = model.getArmor();
    }

    @Override
    protected String getSpecificDescription() {
        return "\nPancerz rąk: " + armor;
    }

    @Override
    protected void updateStatsFromModifiers() {
        super.updateStatsFromModifiers();
        armor = model.getArmor() + getModifiersSum(ModifierType.ARMOR);
    }
}
