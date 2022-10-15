package de.scriptsdk.api.model.context;

import de.scriptsdk.core.interfaces.Deserializable;
import de.scriptsdk.core.model.generic.BaseList;
import de.scriptsdk.core.model.io.PacketReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@EqualsAndHashCode
public class ContextMenuResponse implements Deserializable {
    Long id;
    Integer index;
    Boolean newCliloc;
    BaseList<ContextMenuEntryResponse> entries;

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
