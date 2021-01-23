package model.items;

import lombok.Getter;

import java.util.Set;

@Getter
public enum MagicModifier {
    MM00("Trafny", null, ModifierType.HIT, 5);

    private String prefix;
    private String suffix;
    private ModifierType modifierType;
    private int value;
    private Set<Class> itemTypes;

    MagicModifier(String prefix, String suffix, ModifierType modifierType, int value) {
        this.prefix = prefix;
        this.suffix = suffix;
        this.modifierType = modifierType;
        this.value = value;
    }

    public String getText() {
        return prefix != null ? prefix : suffix;
    }
}
