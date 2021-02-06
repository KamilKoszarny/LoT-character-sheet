package model.items;

import controller.PlayerDisplayer;
import controller.PlayerUpdater;
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

    private final ItemType type;
    private final ItemModel model;

    private int weight;
    private int durabilityOrQuantity;
    private int durabilityOrQuantityMax;

    protected List<Modifier> modifiers;

    public Item(ItemType type, ItemModel model) {
        this.type = type;
        this.model = model;
        this.weight = model.getWeight();
        this.durabilityOrQuantity = model.getDurabilityMax();
        this.durabilityOrQuantityMax = model.getDurabilityMax();
        this.modifiers = new ArrayList<>(model.getModifiers());
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
        durabilityOrQuantityMax = (int) (model.getDurabilityMax() * (100 + getModifiersSum(ModifierType.ITEM_DURABILITY))/100.);
    }

    public boolean isMagic() {
        for (Modifier modifier: modifiers) {
            if (modifier.isMagic()) {
                return true;
            }
        }
        return false;
    }

    private Modifier getPrefixModifier() {
        for (Modifier modifier: modifiers) {
            if (modifier.getPrefix() != null) {
                return modifier;
            }
        }
        return null;
    }

    private Modifier getSuffixModifier() {
        for (Modifier modifier: modifiers) {
            if (modifier.getSuffix() != null) {
                return modifier;
            }
        }
        return null;
    }

    private String getPrefix() {
        Modifier prefixModifier = getPrefixModifier();
        return prefixModifier != null ? prefixModifier.getPrefix() + " " : "";
    }

    private String getSuffix() {
        Modifier suffixModifier = getSuffixModifier();
        return suffixModifier != null ? " " + suffixModifier.getSuffix() : "";
    }

    public Color getColor() {
        Modifier prefixModifier = getPrefixModifier();
        Color prefixColor = prefixModifier != null ? prefixModifier.getColor() : null;
        Modifier suffixModifier = getSuffixModifier();
        Color suffixColor = suffixModifier != null ? suffixModifier.getColor() : null;

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
        String durabilityOrQuantity = isUnbreakable ? "" : (type.equals(ItemType.AMMUNITION) ? "\nIlość: " : "\nWytrzymałość: ") + this.durabilityOrQuantity + "/" + durabilityOrQuantityMax;

        return getPrefix() + model.getNamePL() + getSuffix() +
                "\nWaga: " + weight +
                durabilityOrQuantity +
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

    public void durabilityMinus(int value) {
        durabilityOrQuantity -= value;
        if (type.equals(ItemType.AMMUNITION)) {
            weight = Math.round(Math.round(durabilityOrQuantity / 10.));
            PlayerUpdater.updateLoad();
        }
    }

    public void durabilityMax() {
        durabilityOrQuantity = durabilityOrQuantityMax;
        if (type.equals(ItemType.AMMUNITION)) {
            weight = Math.round(Math.round(durabilityOrQuantity / 10.));
            PlayerUpdater.updateLoad();
        }
    }

    public boolean breakIconShouldBeDisplayed() {
        return durabilityOrQuantity / (double) durabilityOrQuantityMax <= PlayerDisplayer.DURABILITY_RATIO_FOR_ICON_DISPLAY;
    }
}
