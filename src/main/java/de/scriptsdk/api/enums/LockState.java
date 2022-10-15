package de.scriptsdk.api.enums;

import de.scriptsdk.core.interfaces.Enumerable;

public enum LockState implements Enumerable {
    UP(0),
    DOWN(1),
    LOCKED(2);

    private final Integer id;

    LockState(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
