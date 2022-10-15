package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public final class ClilocSpeechAffixEvent implements EventReadable {
    private String clilocText;
    private String senderName;
    private Long senderId;
    private String affix;
    private Long clilocId;

    public String getClilocText() {
        return clilocText;
    }

    public String getSenderName() {
        return senderName;
    }

    public Long getSenderId() {
        return senderId;
    }

    public String getAffix() {
        return affix;
    }

    public Long getClilocId() {
        return clilocId;
    }

    @Override
    public void deserialize(EventReader reader) {
        this.senderId = reader.readCardinal();
        this.senderName = reader.readString();
        this.clilocId = reader.readCardinal();
        this.affix = reader.readString();
        this.clilocText = reader.readString();
    }
}
