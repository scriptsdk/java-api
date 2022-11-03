package de.scriptsdk.api.enums;

import de.scriptsdk.core.interfaces.Enumerable;

/**
 * @author Crome696
 * @version 1.0
 */
public enum BrushStyle implements Enumerable {
    SOLID(0),
    CLEAR(1),
    HORIZONTAL(2),
    VERTICAL(3),
    F_DIAGONAL(4),
    B_DIAGONAL(5),
    CROSS(6),
    DIAG_CROSS(7);

    private final Integer id;

    BrushStyle(int id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
