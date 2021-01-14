package model.items;

import lombok.Getter;
import model.Modifying;

import java.io.Serializable;
import java.util.Optional;
import java.util.Set;

@Getter
public class Item implements Serializable, Modifying {

    private final ItemType itemType;

    private int weight;

    @Getter
    protected Set<Modifier> modifiers;

    public Item(ItemType itemType, int weight, Set<Modifier> modifiers) {
        this.itemType = itemType;
        this.weight = weight;
        this.modifiers = modifiers;
    }

    @Override
    public int getModifierValue(ModifierType modifierType) {
        final Optional<Modifier> optionalModifier = this.modifiers.stream().filter(modifier -> modifier.getType().equals(modifierType)).findFirst();
        return optionalModifier.map(Modifier::getValue).orElse(0);
    }
}
