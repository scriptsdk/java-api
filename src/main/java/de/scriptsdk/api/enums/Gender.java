package de.scriptsdk.api.enums;

import de.scriptsdk.core.interfaces.Enumerable;

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
