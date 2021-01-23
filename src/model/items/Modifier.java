package model.items;

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
        String optionalPlus = value > 0 ? "+" : "";
        String valueText = optionalPlus + this.value;
        return genericDescription.replace("<value>", valueText);
    }
}
