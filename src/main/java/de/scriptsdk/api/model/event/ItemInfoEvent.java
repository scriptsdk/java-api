package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public final class ItemInfoEvent implements EventReadable {
    private Long id;


    public Long getId() {
        return id;
    }

    @Override
    public void deserialize(EventReader reader) {
        this.id = reader.readCardinal();
    }
}
