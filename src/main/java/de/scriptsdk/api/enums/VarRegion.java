package de.scriptsdk.api.enums;

import de.scriptsdk.core.interfaces.Enumerable;

public enum VarRegion implements Enumerable {
    STEALTH(0),
    CHARACTER(1);

    private final Integer id;

    VarRegion(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
