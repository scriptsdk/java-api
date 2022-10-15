package de.scriptsdk.api.enums;

import de.scriptsdk.core.interfaces.Enumerable;

public enum LanguageType implements Enumerable {
    PYTHON(1),
    DELPHI(2),
    CSHARP(3),
    OTHER(255);
    private final int id;

    LanguageType(int id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
