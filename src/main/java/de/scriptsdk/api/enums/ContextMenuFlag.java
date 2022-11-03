package de.scriptsdk.api.enums;

import de.scriptsdk.core.interfaces.Enumerable;

/**
 * @author Crome696
 * @version 1.0
 */
public enum ContextMenuFlag implements Enumerable {
    NONE(0x00),
    DISABLED(0x01),
    ARROW(0x02),
    HIGHLIGHTED(0x04),
    COLORED(0x20);

    private final Integer id;

    ContextMenuFlag(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
