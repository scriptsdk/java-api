package de.scriptsdk.api.enums;

import de.scriptsdk.core.enums.io.DataType;
import de.scriptsdk.core.interfaces.Enumerable;

/**
 * @author Crome696
 * @version 1.0
 */
public enum EventDataType implements Enumerable {
    STRING(0, DataType.STRING),
    CARDINAL(1, DataType.CARDINAL),
    INTEGER(2, DataType.INTEGER),
    USHORT(3, DataType.WORD),
    SHORT(4, DataType.WORD),
    BYTE1(5, DataType.SMALL_INTEGER),
    BYTE2(6, DataType.SMALL_INTEGER),
    BOOLEAN(7, DataType.BOOLEAN);

    private final DataType type;
    private final int id;

    EventDataType(int id, DataType type) {
        this.id = id;
        this.type = type;
    }

    public DataType getType() {
        return type;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
