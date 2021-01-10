package model.items;

import lombok.Data;

import java.io.Serializable;

@Data
public class Item implements Serializable {

    private ItemType itemType;
}
