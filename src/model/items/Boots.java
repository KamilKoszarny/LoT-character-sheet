package model.items;

import lombok.Getter;

@Getter
public class Boots extends Item{

    private final BootsModel model;
    private int armor;

    public Boots(BootsModel model) {
        super(ItemType.BOOTS, model);
        this.model = model;
        this.armor = model.getArmor();
    }

    @Override
    protected String getSpecificDescription() {
        return "\nPancerz nóg: " + armor;
    }

    @Override
    protected void updateStatsFromModifiers() {
        super.updateStatsFromModifiers();
        armor = model.getArmor() + getModifiersSum(ModifierType.ARMOR);
    }
}
