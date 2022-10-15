package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public final class SpeechEvent implements EventReadable {
    private String text;
    private String senderName;
    private Long senderId;

    public String getText() {
        return text;
    }

    public String getSenderName() {
        return senderName;
    }

    public Long getSenderId() {
        return senderId;
    }

    @Override
    public void deserialize(EventReader reader) {
        this.text = reader.readString();
        this.senderName = reader.readString();
        this.senderId = reader.readCardinal();
    }
}
