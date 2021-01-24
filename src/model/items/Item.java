package model.items;

import javafx.scene.paint.Color;
import lombok.Getter;
import model.Modifying;
import utils.GraphicUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
public class Item implements Serializable, Modifying {

    private final ItemType itemType;
    private final ItemModel itemModel;

    private final int weight;
    private int durability;
    private int durabilityMax;

    protected List<Modifier> modifiers;
    private Color prefixColor;
    private Color suffixColor;

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
        if (newMagicModifier.hasPrefix()) {
            prefixColor = newMagicModifier.getColor();
        } else {
            suffixColor = newMagicModifier.getColor();
        }
        updateStatsFromModifiers();
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
            if (modifierToRemove.hasPrefix()) {
                prefixColor = null;
            } else {
                suffixColor = null;
            }
        }
        updateStatsFromModifiers();
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

    protected void updateStatsFromModifiers() {
        durabilityMax = (int) (itemModel.getDurabilityMax() * (100 + getModifiersSum(ModifierType.ITEM_DURABILITY))/100.);
    }

    public boolean isMagic() {
        for (Modifier modifier: modifiers) {
            if (modifier.isMagic()) {
                return true;
            }
        }
        return false;
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

    public Color getColor() {
        if (prefixColor != null && suffixColor != null) {
            return GraphicUtils.mixColors(prefixColor, suffixColor);
        } else if (prefixColor != null) {
            return prefixColor;
        } else {
            return suffixColor;
        }
    }

    public String getDescription() {
        boolean isUnbreakable = modifiers.stream().anyMatch(modifier -> modifier.getType().equals(ModifierType.ITEM_UNBREAKABLE));
        return getPrefix() + itemModel.getNamePL() + getSuffix() +
                "\nWaga: " + weight +
                (isUnbreakable ? "" : "\nWytrzymałość: " + durability + "/" + durabilityMax) +
                getSpecificDescription() +
                getModifiersDescription();
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
