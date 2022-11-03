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
public final class GraphicalEffectEvent implements EventReadable {

    private Integer fixedDir = 0;
    private Long srcId = 0L;
    private Integer srcZ = 0;
    private Integer srcX = 0;
    private Integer srcY = 0;
    private Long destId = 0L;
    private Integer destX = 0;
    private Integer destY = 0;
    private Integer destZ = 0;
    private Integer type = 0;
    private Integer itemId = 0;

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