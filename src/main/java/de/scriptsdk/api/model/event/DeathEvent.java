package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public final class DeathEvent implements EventReadable {

    private Boolean isDead;

    @Override
    public void deserialize(EventReader reader) {
        this.isDead = reader.readBoolean();
    }
}