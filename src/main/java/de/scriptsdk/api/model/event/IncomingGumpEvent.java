package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public final class IncomingGumpEvent implements EventReadable {

    private Long gumpId;
    private Integer type;
    private Integer x;
    private Integer y;


    public Long getGumpId() {
        return gumpId;
    }

    public Integer getType() {
        return type;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    @Override
    public void deserialize(EventReader reader) {

        this.gumpId = reader.readCardinal();
        this.type = reader.readInteger();
        this.x = reader.readInteger();
        this.y = reader.readInteger();
    }
}
