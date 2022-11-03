package de.scriptsdk.api.enums;

import de.scriptsdk.core.interfaces.Enumerable;

/**
 * @author Crome696
 * @version 1.0
 */
public enum FigureCoordination implements Enumerable {
    WORLD(0),
    SCREEN(1);

    private final Integer id;

    FigureCoordination(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
