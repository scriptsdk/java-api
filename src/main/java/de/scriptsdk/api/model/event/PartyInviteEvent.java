package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public final class PartyInviteEvent implements EventReadable {
    private Long inviterId;


    public Long getInviterId() {
        return inviterId;
    }

    @Override
    public void deserialize(EventReader reader) {
        this.inviterId = reader.readCardinal();
    }
}
