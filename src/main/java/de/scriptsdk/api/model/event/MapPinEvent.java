package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public final class MapPinEvent implements EventReadable {

    private Long id;
    private Integer action;
    private Integer pinId;
    private Integer x;
    private Integer y;

    @Override
    public void deserialize(EventReader reader) {

        this.id = reader.readCardinal();
        this.action = reader.readSmallInteger();
        this.pinId = reader.readSmallInteger();
        this.x = reader.readWord();
        this.y = reader.readWord();
    }
}