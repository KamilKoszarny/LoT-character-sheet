package model.items;

import lombok.Getter;

@Getter
public class Modifier {

    private ModifierType type;
    private int value;

    public Modifier(ModifierType type, int value) {
        this.type = type;
        this.value = value;
    }
}
