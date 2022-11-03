package de.scriptsdk.api.model.geometry;

import de.scriptsdk.core.interfaces.Deserializable;
import de.scriptsdk.core.model.io.PacketReader;
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
public class Point3DResponse implements Deserializable {
    private Integer x = 0;
    private Integer y = 0;
    private Integer z = 0;

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
