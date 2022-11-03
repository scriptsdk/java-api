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
public final class MapPinEvent implements EventReadable {

    private Long id = 0L;
    private Integer action = 0;
    private Integer pinId = 0;
    private Integer x = 0;
    private Integer y = 0;

    @Override
    public void deserialize(EventReader reader) {

        this.id = reader.readCardinal();
        this.action = reader.readSmallInteger();
        this.pinId = reader.readSmallInteger();
        this.x = reader.readWord();
        this.y = reader.readWord();
    }
}