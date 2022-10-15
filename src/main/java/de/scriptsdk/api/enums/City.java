package de.scriptsdk.api.enums;

import de.scriptsdk.core.interfaces.Enumerable;

public enum City implements Enumerable {
    NEW_HAVEN(0),
    YEW(1),
    MINOC(2),
    BRITAIN(3),
    MOONGLOW(4),
    TRINSIC(5),
    JHELOM(6),
    SKARA_BRAE(7),
    VESPER(8),
    ROYAL_CITY(9);
    private final Integer id;

    City(int id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
