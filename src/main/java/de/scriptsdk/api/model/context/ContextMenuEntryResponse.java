package de.scriptsdk.api.model.context;

import de.scriptsdk.core.interfaces.Deserializable;
import de.scriptsdk.core.model.io.PacketReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@EqualsAndHashCode
public final class ContextMenuEntryResponse implements Deserializable {

    private Integer tag;
    private Long id;
    private Integer flags;
    private Integer color;

    @Override
    public void deserialize(PacketReader reader) {
        this.setTag(reader.readWord());
        this.setId(reader.readCardinal());
        this.setFlags(reader.readWord());
        this.setColor(reader.readWord());
    }
}
