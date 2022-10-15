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
public final class GroupResponse implements Deserializable {

    private Integer groupNumber = 0;
    private Integer page = 0;
    private Integer elementNumber = 0;

    @Override
    public void deserialize(PacketReader reader) {
        this.setGroupNumber(reader.readInteger());
        this.setPage(reader.readInteger());
        this.setElementNumber(reader.readInteger());
    }
}
