package model.items;

import lombok.Getter;

@Getter
public enum WeaponType {

    SWORD("Miecze"),
    AXE("Topory"),
    MACE("Obuchowe"),
    SHORT("Krótkie"),
    LONG("Długie"),
    THROWING("Rzucane"),
    BOW("Łuki"),
    CROSSBOW("Kusze"),
    MAGES("Magów");

    private final String namePL;

    WeaponType(String namePL) {
        this.namePL = namePL;
    }
}
