package model.items;

import lombok.Getter;
import lombok.Setter;
import model.Modifying;

import java.io.Serializable;
import java.util.Optional;
import java.util.Set;

public class Item implements Serializable, Modifying {

    @Getter
    @Setter
    private ItemType itemType;

    @Getter
    protected Set<Modifier> modifiers;

    public Item(ItemType itemType, Set<Modifier> modifiers) {
        this.itemType = itemType;
        this.modifiers = modifiers;
    }

    @Override
    public int getModifierValue(ModifierType modifierType) {
        final Optional<Modifier> optionalModifier = this.modifiers.stream().filter(modifier -> modifier.getType().equals(modifierType)).findFirst();
        return optionalModifier.map(Modifier::getValue).orElse(0);
    }
}
