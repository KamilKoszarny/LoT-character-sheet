package model.items;

import java.util.List;

public interface ItemModel {

    String getNamePL();
    int getWeight();
    int getDurabilityMax();
    List<Modifier> getModifiers();
}
