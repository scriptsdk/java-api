package de.scriptsdk.api.model.geometry;

import de.scriptsdk.core.interfaces.Serializable;
import de.scriptsdk.core.model.io.PacketWriter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Crome696
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Point3DRequest implements Serializable {
    private Integer x = 0;
    private Integer y = 0;
    private Integer z = 0;

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
