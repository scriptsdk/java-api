package de.scriptsdk.api.model.assets;

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
public final class MapCellResponse implements Deserializable {
    private Integer tile = 0;
    private Integer z = 0;

    @Override
    public void deserialize(PacketReader reader) {
        this.setTile(reader.readInteger());
        this.setZ(reader.readSmallInteger());
    }
}
