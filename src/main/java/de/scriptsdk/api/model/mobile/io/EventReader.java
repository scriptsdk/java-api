package de.scriptsdk.api.model.mobile.io;

import de.scriptsdk.api.enums.EventDataType;
import de.scriptsdk.api.exceptions.event.EventException;
import de.scriptsdk.core.enums.io.DataType;
import de.scriptsdk.core.interfaces.Enumerable;
import de.scriptsdk.core.interfaces.ReadablePacket;
import de.scriptsdk.core.model.io.PacketReader;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

public class EventReader {
    private final PacketReader reader;

    public EventReader(PacketReader reader) {
        this.reader = reader;
    }

    private <T> T readInternal(DataType requiredType, ReadablePacket<T> readable) {
        DataType type = readType();
        if (Objects.equals(type, requiredType)) {
            return readable.read(reader);
        }
        throw new EventException("Parameter type %s expected but %s actual!", DataType.DOUBLE.name(), type.name());
    }

    private DataType readType() {
        return Enumerable.valueOf(reader.readSmallInteger(), EventDataType.class).getType();
    }

    public double readDouble() {
        return readInternal(DataType.DOUBLE, PacketReader::readDouble);
    }

    public LocalDateTime readDateTime() {
        return readInternal(DataType.DATETIME, PacketReader::readDateTime);
    }

    public Long readCardinal() {
        return readInternal(DataType.CARDINAL, PacketReader::readCardinal);
    }

    public Integer readSmallInteger() {
        return readInternal(DataType.SMALL_INTEGER, PacketReader::readSmallInteger);

    }

    public String readString() {
        return readInternal(DataType.STRING, PacketReader::readString);
    }

    public Integer readWord() {
        return readInternal(DataType.WORD, PacketReader::readWord);

    }

    public Integer readInteger() {
        return readInternal(DataType.INTEGER, PacketReader::readInteger);
    }

    public BigInteger readBigInteger() {
        return readInternal(DataType.ULONG, PacketReader::readBigInteger);
    }

    public Boolean readBoolean() {
        return readInternal(DataType.BOOLEAN, PacketReader::readBoolean);
    }
}
