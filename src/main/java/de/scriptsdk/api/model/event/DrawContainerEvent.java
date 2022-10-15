package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public final class DrawContainerEvent implements EventReadable {
    private Long containerId;
    private Integer modelGump;

    @Override
    public void deserialize(EventReader reader) {
        this.containerId = reader.readCardinal();
        this.modelGump = reader.readWord();
    }

    public Long getContainerId() {
        return containerId;
    }

    public Integer getModelGump() {
        return modelGump;
    }
}
