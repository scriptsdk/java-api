package de.scriptsdk.api.model.target;

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
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public final class TargetInfoResponse implements Deserializable {
    private Long id = 0L;
    private Integer tile = 0;
    private Integer x = 0;
    private Integer y = 0;
    private Integer z = 0;

    @Override
    public void deserialize(PacketReader reader) {
        this.setId(reader.readCardinal());
        this.setTile(reader.readWord());
        this.setX(reader.readWord());
        this.setY(reader.readWord());
        this.setZ(reader.readWord());
    }
}
