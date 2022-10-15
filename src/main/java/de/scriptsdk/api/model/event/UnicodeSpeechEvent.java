package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public final class UnicodeSpeechEvent implements EventReadable {

    private String senderName;
    private String text;
    private Long senderId;

    public String getSenderName() {
        return senderName;
    }

    public String getText() {
        return text;
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