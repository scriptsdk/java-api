package de.scriptsdk.api.enums;

import de.scriptsdk.core.interfaces.Enumerable;

/**
 * @author Crome696
 * @version 1.0
 */
public enum Notoriety implements Enumerable {
    INVALID(0),
    INNOCENT(1),
    ALLY(2),
    CAN_BE_ATTACKED(3),
    CRIMINAL(4),
    ENEMY(5),
    MURDERER(6),
    INVULNERABLE(7);
    private final Integer id;

    Notoriety(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
