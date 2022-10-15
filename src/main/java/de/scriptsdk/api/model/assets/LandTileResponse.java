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
public final class LandTileResponse implements Deserializable {
    private Long flags = 0L;
    private Long flags2 = 0L;
    private Integer textureId = 0;
    private String name = "";

    @Override
    public void deserialize(PacketReader reader) {
        this.setFlags(reader.readCardinal());
        this.setFlags2(reader.readCardinal());
        this.setTextureId(reader.readInteger());
        this.setName(reader.readString());
    }
}
