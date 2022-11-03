package de.scriptsdk.api.model.context;

import de.scriptsdk.core.interfaces.Deserializable;
import de.scriptsdk.core.model.generic.BaseList;
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
public class ContextMenuResponse implements Deserializable {
    Long id = 0L;
    Integer index = 0;
    Boolean newCliloc = false;
    BaseList<ContextMenuEntryResponse> entries = new BaseList<>();

    @Override
    public void deserialize(PacketReader reader) {
        this.setId(reader.readCardinal());
        this.setIndex(reader.readSmallInteger());
        this.setNewCliloc(reader.readBoolean());

        reader.readList(reader1 ->
                {
                    ContextMenuEntryResponse entry = new ContextMenuEntryResponse();
                    entry.deserialize(reader1);
                    return entry;
                }
        );
    }
}
