package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public final class SoundEvent implements EventReadable {

    private Integer soundId;
    private Integer x;
    private Integer y;
    private Integer z;

    @Override
    public void deserialize(EventReader reader) {
        this.soundId = reader.readWord();
        this.x = reader.readWord();
        this.y = reader.readWord();
        this.z = reader.readSmallInteger();
    }
}