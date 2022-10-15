package de.scriptsdk.api.model.geometry;

import de.scriptsdk.core.interfaces.Serializable;
import de.scriptsdk.core.model.io.PacketWriter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Point3DRequest implements Serializable {
    private Integer x;
    private Integer y;
    private Integer z;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getZ() {
        return z;
    }

    public void setZ(Integer z) {
        this.z = z;
    }

    @Override
    public void serialize(PacketWriter writer) {
        writer.writeWord(getX());
        writer.writeWord(getY());
        writer.writeSmallInteger(getZ());
    }
}
