package model.items;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class Item implements Serializable {

    @Getter
    @Setter
    private ItemType itemType;
}
