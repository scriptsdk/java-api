package de.scriptsdk.api.enums;

import de.scriptsdk.core.interfaces.Enumerable;

/**
 * @author Crome696
 * @version 1.0
 */
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
