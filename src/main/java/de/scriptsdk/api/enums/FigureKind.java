package de.scriptsdk.api.enums;

import de.scriptsdk.core.interfaces.Enumerable;

/**
 * @author Crome696
 * @version 1.0
 */
public enum FigureKind implements Enumerable {
    LINE(0),
    ELLIPSE(1),
    RECTANGLE(2),
    DIRECTION(3),
    TEXT(4);

    private final Integer id;

    FigureKind(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
