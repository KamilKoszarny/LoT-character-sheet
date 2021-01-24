package model.items;

import lombok.Getter;

@Getter
public class Helmet extends Item{

    private final HelmetModel model;
    private int armor;

    public Helmet(HelmetModel model) {
        super(ItemType.HELMET, model);
        this.model = model;
        this.armor = model.getArmor();
    }

    @Override
    protected String getSpecificDescription() {
        return "\nPancerz głowy: " + armor;
    }

    @Override
    protected void updateStatsFromModifiers() {
        super.updateStatsFromModifiers();
        armor = model.getArmor() + getModifiersSum(ModifierType.ARMOR);
    }
}
