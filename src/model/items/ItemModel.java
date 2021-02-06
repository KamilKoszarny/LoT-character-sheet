package model.items;

import java.util.List;

public interface ItemModel {

    String name();
    String getNamePL();
    int getWeight();
    int getDurabilityMax();
    List<Modifier> getModifiers();
}
