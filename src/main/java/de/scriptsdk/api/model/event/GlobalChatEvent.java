package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public final class GlobalChatEvent implements EventReadable {

    private Integer msgCode;
    private String name;
    private String text;

    public Integer getMsgCode() {
        return msgCode;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    @Override
    public void deserialize(EventReader reader) {
        this.msgCode = reader.readWord();
        this.name = reader.readString();
        this.text = reader.readString();
    }
}
