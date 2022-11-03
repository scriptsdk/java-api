package de.scriptsdk.api.enums;

import de.scriptsdk.core.interfaces.Enumerable;

/**
 * @author Crome696
 * @version 1.0
 */
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
