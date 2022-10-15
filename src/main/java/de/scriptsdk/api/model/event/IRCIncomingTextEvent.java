package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public final class IRCIncomingTextEvent implements EventReadable {

    private String message;


    public String getMessage() {
        return message;
    }

    @Override
    public void deserialize(EventReader reader) {

        this.message = reader.readString();
    }
}