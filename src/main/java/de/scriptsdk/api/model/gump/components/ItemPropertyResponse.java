package de.scriptsdk.api.model.gump.components;

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
public final class ItemPropertyResponse implements Deserializable {
    private Long propertyId = 0L;
    private Integer elementNumber = 0;

    @Override
    public void deserialize(PacketReader reader) {
        this.setPropertyId(reader.readCardinal());
        this.setElementNumber(reader.readInteger());
    }
}
