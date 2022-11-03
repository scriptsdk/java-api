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
public final class MapMessageEvent implements EventReadable {

    private Long id = 0L;
    private Integer y = 0;
    private Integer x = 0;

    @Override
    public void deserialize(EventReader reader) {
        this.id = reader.readCardinal();
        this.x = reader.readInteger();
        this.y = reader.readInteger();

    }
}