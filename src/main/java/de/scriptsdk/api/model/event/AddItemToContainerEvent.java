package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public final class AddItemToContainerEvent implements EventReadable {
    private Long itemId;
    private Long containerId;

    public Long getItemId() {
        return itemId;
    }

    public Long getContainerId() {
        return containerId;
    }

    @Override
    public void deserialize(EventReader reader) {
        this.itemId = reader.readCardinal();
        this.containerId = reader.readCardinal();
    }
}
