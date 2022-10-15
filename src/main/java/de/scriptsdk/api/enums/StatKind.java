package de.scriptsdk.api.enums;

import de.scriptsdk.core.interfaces.Enumerable;

public enum StatKind implements Enumerable {
    STRENGTH(0),
    DEXTERITY(1),
    INTELLIGENCE(2);


    private final Integer id;

    StatKind(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
