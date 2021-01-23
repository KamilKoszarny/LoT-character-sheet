package model.items;

import lombok.Getter;

import java.util.Set;

@Getter
public enum MagicModifier {
    MMP00("Trafny", null, ModifierType.HIT, 5),
    MMP01("Celny", null, ModifierType.HIT, 10),

    MMP88("Rześki", null, ModifierType.HP_MAX, 2),


    MMS00(null, "Barana", ModifierType.STRENGTH, 3),
    MMS01(null, "Byka", ModifierType.STRENGTH, 6),

    MMS05(null, "Robaka", ModifierType.ENDURANCE, 3),
    ;

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

    public boolean hasPrefix() {
        return prefix != null;
    }

    public String getText() {
        return prefix != null ? prefix : suffix;
    }
}
