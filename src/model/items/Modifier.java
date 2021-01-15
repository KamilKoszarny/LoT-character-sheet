package model.items;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class Modifier implements Serializable {

    private ModifierType type;
    private int value;

    public Modifier(ModifierType type, int value) {
        this.type = type;
        this.value = value;
    }
}
