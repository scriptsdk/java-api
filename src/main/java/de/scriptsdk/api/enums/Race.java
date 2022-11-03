package de.scriptsdk.api.enums;

import de.scriptsdk.core.interfaces.Enumerable;

/**
 * @author Crome696
 * @version 1.0
 */
public enum Race implements Enumerable {
    HUMAN(0),
    ELF(1),
    GARGOYLE(2);
    private final Integer id;

    Race(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
