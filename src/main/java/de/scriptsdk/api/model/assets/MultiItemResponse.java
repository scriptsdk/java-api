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
public final class MultiItemResponse implements Deserializable {
    private Long id = 0L;
    private Integer x = 0;
    private Integer y = 0;
    private Integer z = 0;
    private Integer minX = 0;
    private Integer minY = 0;
    private Integer maxX = 0;
    private Integer maxY = 0;
    private Integer width = 0;
    private Integer height = 0;

    @Override
    public void deserialize(PacketReader reader) {
        this.setId(reader.readCardinal());

        this.setX(reader.readWord());
        this.setY(reader.readWord());
        this.setZ(reader.readSmallInteger());


        this.setMinX(reader.readInteger());
        this.setMinY(reader.readInteger());
        this.setMaxX(reader.readInteger());
        this.setMaxY(reader.readInteger());

        this.setWidth(reader.readInteger());
        this.setHeight(reader.readInteger());
    }
}
