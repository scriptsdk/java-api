package de.scriptsdk.api.enums;

import de.scriptsdk.core.interfaces.Enumerable;

public enum Facet implements Enumerable {

    FELUCCA(0),
    TRAMMEL(1),
    ILSHENAR(2),
    MALAS(3),
    TOKUNO(4),
    TER_MUR(5),
    VALLEY_OF_EODON(6);

    private final Integer id;

    Facet(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
