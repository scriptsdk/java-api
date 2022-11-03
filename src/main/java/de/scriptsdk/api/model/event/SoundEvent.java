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
public final class SoundEvent implements EventReadable {

    private Integer soundId = 0;
    private Integer x = 0;
    private Integer y = 0;
    private Integer z = 0;

    @Override
    public void deserialize(EventReader reader) {
        this.soundId = reader.readWord();
        this.x = reader.readWord();
        this.y = reader.readWord();
        this.z = reader.readSmallInteger();
    }
}