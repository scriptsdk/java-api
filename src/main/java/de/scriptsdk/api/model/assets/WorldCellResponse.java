package de.scriptsdk.api.model.assets;

import de.scriptsdk.core.interfaces.Deserializable;
import de.scriptsdk.core.model.io.PacketReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorldCellResponse implements Deserializable {
    private Boolean state;
    private Integer z;

    @Override
    public void deserialize(PacketReader packetReader) {
        this.setState(packetReader.readBoolean());
        this.setZ(packetReader.readInteger());
    }
}
