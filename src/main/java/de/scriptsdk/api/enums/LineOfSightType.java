package de.scriptsdk.api.enums;

import de.scriptsdk.core.interfaces.Enumerable;

/**
 * @author Crome696
 * @version 1.0
 */
public enum LineOfSightType implements Enumerable {
    SPHERE(1),
    SPHERE_ADVANCED(2),
    POL(3),
    RUNUO(4);

    private final Integer id;

    LineOfSightType(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
