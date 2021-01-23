package model.items;

import java.util.Set;

public interface ItemModel {

    String getNamePL();
    int getWeight();
    int getDurabilityMax();
    Set<Modifier> getModifiers();
}
