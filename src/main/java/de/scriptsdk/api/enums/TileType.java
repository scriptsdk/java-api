package de.scriptsdk.api.enums;

import de.scriptsdk.core.interfaces.Enumerable;

public enum TileType implements Enumerable {
    LAND_TILE(0),
    STATIC_TILE(1);

    private final Integer id;

    TileType(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
