package de.scriptsdk.api.model.gump.core;

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
@EqualsAndHashCode(callSuper = true)
public abstract class BaseGumpActionElementResponse extends BaseGumpElementResponse {
    private Integer releasedId = 0;
    private Integer pressedId = 0;

    @Override
    public void deserialize(PacketReader reader) {
        super.deserialize(reader);
        this.setReleasedId(reader.readInteger());
        this.setPressedId(reader.readInteger());
    }
}
