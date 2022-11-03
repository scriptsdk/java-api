package de.scriptsdk.api.model.context;

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
public final class ContextMenuEntryResponse implements Deserializable {

    private Integer tag = 0;
    private Long id = 0L;
    private Integer flags = 0;
    private Integer color = 0;

    @Override
    public void deserialize(PacketReader reader) {
        this.setTag(reader.readWord());
        this.setId(reader.readCardinal());
        this.setFlags(reader.readWord());
        this.setColor(reader.readWord());
    }
}
