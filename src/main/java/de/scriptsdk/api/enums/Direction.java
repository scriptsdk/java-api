package de.scriptsdk.api.enums;

import de.scriptsdk.core.interfaces.Enumerable;

/**
 * @author Crome696
 * @version 1.0
 */
public enum Direction implements Enumerable {
    UNKNOWN(100),
    NORTH(0),
    NORTH_EAST(1),
    EAST(2),
    SOUTH_EAST(3),
    SOUTH(4),
    SOUTH_WEST(5),
    WEST(6),
    NORTH_WEST(7);

    private final Integer id;

    Direction(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
