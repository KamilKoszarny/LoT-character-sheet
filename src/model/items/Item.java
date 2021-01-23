package model.items;

import javafx.scene.paint.Color;
import lombok.Getter;
import model.Modifying;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
public class Item implements Serializable, Modifying {

    private final ItemType itemType;
    private final ItemModel itemModel;

    private int weight;
    private int durability;
    private int durabilityMax;

    protected List<Modifier> modifiers;
    private Color color;

    public Item(ItemType itemType, ItemModel itemModel) {
        this.itemType = itemType;
        this.itemModel = itemModel;
        this.weight = itemModel.getWeight();
        this.durability = itemModel.getDurabilityMax();
        this.durabilityMax = itemModel.getDurabilityMax();
        this.modifiers = new ArrayList<>(itemModel.getModifiers());
    }

    public void setMagicModifier(MagicModifier newMagicModifier) {
        Modifier newModifier = new Modifier(newMagicModifier);
        Modifier oldModifierToDelete = null;
        for (Modifier modifier: modifiers) {
            if (modifier.hasPrefix() && newModifier.hasPrefix()) {
                oldModifierToDelete = modifier;
            } else if (modifier.hasSuffix() && newModifier.hasSuffix()) {
                oldModifierToDelete = modifier;
            }
        }
        if (oldModifierToDelete != null) {
            modifiers.remove(oldModifierToDelete);
        }
        modifiers.add(newModifier);
        color = newMagicModifier.getColor();
    }

    public void removeMagicModifier(boolean prefix) {
        Modifier modifierToRemove = null;
        if (prefix) {
            Optional<Modifier> optionalPrefixModifier = modifiers.stream().filter(Modifier::hasPrefix).findFirst();
            if (optionalPrefixModifier.isPresent()) {
                modifierToRemove = optionalPrefixModifier.get();
            }
        } else {
            Optional<Modifier> optionalSuffixModifier = modifiers.stream().filter(Modifier::hasSuffix).findFirst();
            if (optionalSuffixModifier.isPresent()) {
                modifierToRemove = optionalSuffixModifier.get();
            }
        }
        if (modifierToRemove != null) {
            modifiers.remove(modifierToRemove);
        }
    }

    @Override
    public int getModifiersSum(ModifierType modifierType) {
        List<Modifier> modifiersOfType = this.modifiers.stream().filter(modifier -> modifier.getType().equals(modifierType)).collect(Collectors.toList());
        int sum = 0;
        for (Modifier modifier: modifiersOfType) {
            sum += modifier.getValue();
        }
        return sum;
    }

    public boolean isMagic() {
        for (Modifier modifier: modifiers) {
            if (modifier.isMagic()) {
                return true;
            }
        }
        return false;
    }

    public String getDescription() {
        return getPrefix() + itemModel.getNamePL() + getSuffix() +
                "\nWaga: " + weight +
                "\nWytrzymałość: " + durability + "/" + durabilityMax +
                getSpecificDescription() +
                getModifiersDescription();
    }

    private String getPrefix() {
        for (Modifier modifier: modifiers) {
            if (modifier.getPrefix() != null) {
                return modifier.getPrefix() + " ";
            }
        }
        return "";
    }

    private String getSuffix() {
        for (Modifier modifier: modifiers) {
            if (modifier.getSuffix() != null) {
                return " " + modifier.getSuffix();
            }
        }
        return "";
    }

    protected String getSpecificDescription() {
        return "";
    }

    private String getModifiersDescription() {
        StringBuilder modifiersDescription = new StringBuilder();
        for (Modifier modifier : modifiers) {
            modifiersDescription.append("\n").append(modifier.getDescription());
        }
        return modifiersDescription.toString();
    }
}
