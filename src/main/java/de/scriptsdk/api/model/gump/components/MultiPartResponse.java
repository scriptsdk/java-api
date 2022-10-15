package de.scriptsdk.api.model.gump.components;

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
public final class MultiPartResponse implements Deserializable {
    private Integer graphic = 0;
    private Integer x = 0;
    private Integer y = 0;
    private Integer z = 0;
    private Long flag = 0L;

    @Override
    public void deserialize(PacketReader reader) {
        this.setGraphic(reader.readInteger());
        this.setX(reader.readWord());
        this.setY(reader.readWord());
        this.setZ(reader.readSmallInteger());
        this.setFlag(reader.readCardinal());
    }
}
