package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public final class MapMessageEvent implements EventReadable {

    private Long id;
    private Integer y;
    private Integer x;

    @Override
    public void deserialize(EventReader reader) {
        this.id = reader.readCardinal();
        this.x = reader.readInteger();
        this.y = reader.readInteger();

    }
}