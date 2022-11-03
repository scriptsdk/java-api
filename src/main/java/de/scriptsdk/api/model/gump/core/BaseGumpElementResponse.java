package de.scriptsdk.api.model.gump.core;

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
public abstract class BaseGumpElementResponse implements Deserializable {
    private Integer x = 0;
    private Integer y = 0;

    @Override
    public void deserialize(PacketReader reader) {
        this.setX(reader.readInteger());
        this.setY(reader.readInteger());
    }
}
