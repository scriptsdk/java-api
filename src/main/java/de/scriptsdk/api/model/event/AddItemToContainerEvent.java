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
public final class AddItemToContainerEvent implements EventReadable {
    private Long itemId = 0L;
    private Long containerId = 0L;

    @Override
    public void deserialize(EventReader reader) {
        this.itemId = reader.readCardinal();
        this.containerId = reader.readCardinal();
    }
}
