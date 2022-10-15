package de.scriptsdk.api.enums;

import de.scriptsdk.core.interfaces.Enumerable;

public enum VirtueType implements Enumerable {
    HUMILITY(0x6C, 0),
    SACRIFICE(0x6E, 1),
    COMPASSION(0x69, 2),
    SPIRITUALITY(0x6F, 3),
    VALOR(0x70, 4),
    HONOR(0x6B, 5),
    JUSTICE(0x6D, 6),
    HONESTY(0x6A, 7);
    private final Integer id;
    private final Integer levelId;

    VirtueType(Integer id, Integer levelId) {
        this.id = id;
        this.levelId = levelId;
    }

    public Integer getLevelId() {
        return levelId;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
