package de.scriptsdk.api.model.geometry;

import de.scriptsdk.core.interfaces.Deserializable;
import de.scriptsdk.core.model.io.PacketReader;

public class Point3DResponse implements Deserializable {
    private Integer x;
    private Integer y;
    private Integer z;

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Integer getZ() {
        return z;
    }

    @Override
    public void deserialize(PacketReader reader) {
        this.x = reader.readWord();
        this.y = reader.readWord();
        this.z = reader.readSmallInteger();
    }
}
