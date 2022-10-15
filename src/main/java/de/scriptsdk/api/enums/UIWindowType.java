package de.scriptsdk.api.enums;

import de.scriptsdk.core.interfaces.Enumerable;

public enum UIWindowType implements Enumerable {
    PAPERDOLL(0),
    STATUS(1),
    CHAR_PROFILE(2),
    CONTAINER(3);


    private final Integer id;

    UIWindowType(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
