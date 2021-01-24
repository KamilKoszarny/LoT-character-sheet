package model.items;

import javafx.scene.paint.Color;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class Modifier implements Serializable {

    private final ModifierType type;
    private int value;
    private boolean isMagic = false;
    private String prefix;
    private String suffix;

    public Modifier(ModifierType type, int value) {
        this.type = type;
        this.value = value;
    }

    public Modifier(MagicModifier magicModifier) {
        this.type = magicModifier.getModifierType();
        this.value = magicModifier.getValue();
        this.isMagic = true;
        this.prefix = magicModifier.getPrefix();
        this.suffix = magicModifier.getSuffix();
    }

    public String getDescription() {
        String genericDescription = type.getDescription();
        if (genericDescription.contains("<value>")) {
            String optionalPlus = value > 0 ? "+" : "";
            String valueText = optionalPlus + this.value;
            return genericDescription.replace("<value>", valueText);
        } else {
            return genericDescription.replace("<kvalue>", "k" + this.value);
        }
    }

    public boolean hasPrefix() {
        return prefix != null;
    }

    public boolean hasSuffix() {
        return suffix != null;
    }

    public Color getColor() {
        for (MagicModifier magicModifier: MagicModifier.values()) {
            if (hasPrefix() && prefix.equals(magicModifier.getPrefix())) {
                return magicModifier.getColor();
            }
            if (hasSuffix() && suffix.equals(magicModifier.getSuffix())) {
                return magicModifier.getColor();
            }
        }
        return null;
    }
}
