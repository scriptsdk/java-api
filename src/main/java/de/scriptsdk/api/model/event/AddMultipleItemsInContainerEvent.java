package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public final class AddMultipleItemsInContainerEvent implements EventReadable {
    private Long containerId;


    public Long getContainerId() {
        return containerId;
    }

    public void setContainerId(Long containerId) {
        this.containerId = containerId;
    }

    @Override
    public void deserialize(EventReader reader) {
        this.setContainerId(reader.readCardinal());
    }
}
