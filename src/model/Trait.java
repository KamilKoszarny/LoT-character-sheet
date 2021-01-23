package model;

import lombok.Getter;
import model.items.Modifier;
import model.items.ModifierType;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Getter
public enum Trait implements Modifying {

    TWO_HANDED(TraitType.POSITIVE, "Oburęczny", "Brak kary drugiej ręki"),
    RESISTANT(TraitType.POSITIVE, "Odporny", "+20% odp. na choroby ciała", new Modifier(ModifierType.RES_BODY_ILL, 20)),
    GOOD_AT_MATHS(TraitType.POSITIVE, "Dobrze liczy", "Charyzma +20 przy targowaniu"),

    ELEMENTAL_NEPHEW(TraitType.NEUTRAL, "Bratanek żywiołów", "+10p% odp. na zywioly;\n-10p% odp. na magie", new Modifier(ModifierType.RES_FIRE, 10), new Modifier(ModifierType.RES_COLD, 10), new Modifier(ModifierType.RES_WIND, 10), new Modifier(ModifierType.RES_EARTH, 10), new Modifier(ModifierType.RES_MAGIC, -10)),
    DREAMER(TraitType.NEUTRAL, "Marzyciel", "-20% odp. na choroby psychiczne\n+20% odp. na choroby ciała", new Modifier(ModifierType.RES_MIND_ILL, -20), new Modifier(ModifierType.RES_BODY_ILL, 20)),
    NON_STANDARD_BODY(TraitType.NEUTRAL, "Niestandardowa budowa", "-10% wym. Przedmiotów;\n-5% statystyki przedmiotów", new Modifier(ModifierType.ITEM_REQUIREMENTS, -10), new Modifier(ModifierType.ITEM_STATS, -5)),

    UNREGULAR_BODY(TraitType.NEGATIVE, "Nieregularna budowa", "+10% wymagania przedmiotow", new Modifier(ModifierType.ITEM_REQUIREMENTS, 10)),
    HAND_SHAKING(TraitType.NEGATIVE, "Drżenie rąk", "ręka -10%(startowa),\nprzyrost -10% (co 10 punkt *2PD)", new Modifier(ModifierType.ARM_GROWTH, -10));

    private final String namePL;
    private final String descriptionPL;
    private final TraitType type;
    protected List<Modifier> modifiers;

    Trait(TraitType type, String namePL, String descriptionPL, Modifier... modifiers) {
        this.type= type;
        this.namePL = namePL;
        this.descriptionPL = descriptionPL;
        this.modifiers = Arrays.asList(modifiers);
    }

    @Override
    public String toString() {
        return this.namePL;
    }

    @Override
    public int getModifiersSum(ModifierType modifierType) {
        final Optional<Modifier> optionalModifier = this.modifiers.stream().filter(modifier -> modifier.getType().equals(modifierType)).findFirst();
        return optionalModifier.map(Modifier::getValue).orElse(0);
    }
}
