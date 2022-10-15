package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public final class RejectMoveItemEvent implements EventReadable {

    private Integer reason;

    public Integer getReason() {
        return reason;
    }

    @Override
    public void deserialize(EventReader reader) {

        this.reason = reader.readSmallInteger();
    }
}