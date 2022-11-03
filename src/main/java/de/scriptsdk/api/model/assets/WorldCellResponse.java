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
public class WorldCellResponse implements Deserializable {
    private Boolean state = false;
    private Integer z = 0;

    @Override
    public void deserialize(PacketReader packetReader) {
        this.setState(packetReader.readBoolean());
        this.setZ(packetReader.readInteger());
    }
}
