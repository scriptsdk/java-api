package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.io.EventReader;
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
public final class IncomingGumpEvent implements EventReadable {

    private Long gumpId = 0L;
    private Integer type = 0;
    private Integer x = 0;
    private Integer y = 0;

    @Override
    public void deserialize(EventReader reader) {

        this.gumpId = reader.readCardinal();
        this.type = reader.readInteger();
        this.x = reader.readInteger();
        this.y = reader.readInteger();
    }
}
