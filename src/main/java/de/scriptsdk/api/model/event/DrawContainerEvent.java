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
public final class DrawContainerEvent implements EventReadable {
    private Long containerId = 0L;
    private Integer modelGump = 0;

    @Override
    public void deserialize(EventReader reader) {
        this.containerId = reader.readCardinal();
        this.modelGump = reader.readWord();
    }
}
