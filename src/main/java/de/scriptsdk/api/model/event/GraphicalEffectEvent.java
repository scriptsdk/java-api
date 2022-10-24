package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public final class GraphicalEffectEvent implements EventReadable {

    private Integer fixedDir;
    private Long srcId;
    private Integer srcZ;
    private Integer srcX;
    private Integer srcY;
    private Long destId;
    private Integer destX;
    private Integer destY;
    private Integer destZ;
    private Integer type;
    private Integer itemId;

    @Override
    public void deserialize(EventReader reader) {
        this.srcId = reader.readCardinal();
        this.srcX = reader.readWord();
        this.srcY = reader.readWord();
        this.srcZ = reader.readSmallInteger();
        this.destId = reader.readCardinal();
        this.destX = reader.readWord();
        this.destY = reader.readWord();
        this.destZ = reader.readSmallInteger();
        this.type = reader.readSmallInteger();
        this.itemId = reader.readWord();
        this.fixedDir = reader.readSmallInteger();
    }
}