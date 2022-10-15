package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public final class ClilocSpeechEvent implements EventReadable {

    private String clilocText;
    private Long senderId;
    private String senderName;
    private Long clilocId;

    public String getClilocText() {
        return clilocText;
    }

    public Long getSenderId() {
        return senderId;
    }

    public String getSenderName() {
        return senderName;
    }

    public Long getClilocId() {
        return clilocId;
    }

    @Override
    public void deserialize(EventReader reader) {
        this.senderId = reader.readCardinal();
        this.senderName = reader.readString();
        this.clilocId = reader.readCardinal();
        this.clilocText = reader.readString();
    }
}