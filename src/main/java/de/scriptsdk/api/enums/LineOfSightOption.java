package de.scriptsdk.api.enums;

import de.scriptsdk.core.interfaces.Enumerable;

import java.util.Arrays;
import java.util.Objects;

public enum LineOfSightOption implements Enumerable {
    NONE(0),
    LOS_SPHERE_CHECK_CORNERS(0x100, LineOfSightType.SPHERE, LineOfSightType.SPHERE_ADVANCED),
    SPHERE_CHECK_CORNERS(0x100, LineOfSightType.SPHERE, LineOfSightType.SPHERE_ADVANCED),
    LOS_POL_USE_NO_SHOOT(0x200, LineOfSightType.POL),
    POL_USE_NO_SHOOT(0x200, LineOfSightType.POL),
    LOS_POL_LOS_THROUGH_WINDOW(0x400, LineOfSightType.POL),
    POL_LOS_THROUGH_WINDOW(0x400, LineOfSightType.POL);

    private final Integer id;
    private final LineOfSightType[] args;

    LineOfSightOption(Integer id, LineOfSightType... args) {
        this.args = args;
        this.id = id;
    }

    public Boolean containsType(LineOfSightType type) {
        return !Arrays.stream(args).filter(queryType -> Objects.equals(queryType, type)).toList().isEmpty();
    }

    public LineOfSightType[] getArgs() {
        return args;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
