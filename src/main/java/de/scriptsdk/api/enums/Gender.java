package de.scriptsdk.api.enums;

import de.scriptsdk.core.interfaces.Enumerable;

/**
 * @author Crome696
 * @version 1.0
 */
public enum Gender implements Enumerable {
    FEMALE(0),
    MALE(1);

    private final Integer id;

    Gender(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
