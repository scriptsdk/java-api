package de.scriptsdk.api.model.assets;

import de.scriptsdk.core.interfaces.Deserializable;
import de.scriptsdk.core.model.io.PacketReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public final class TileResultResponse implements Deserializable {
    private Integer tile = 0;
    private Integer x;
    private Integer y;
    private Integer z;

    @Override
    public void deserialize(PacketReader reader) {
        this.setTile(reader.readInteger());
        this.setX(reader.readWord());
        this.setY(reader.readWord());
        this.setZ(reader.readSmallInteger());
    }
}
