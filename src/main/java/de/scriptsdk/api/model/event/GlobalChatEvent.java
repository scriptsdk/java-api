package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public final class GlobalChatEvent implements EventReadable {

    private Integer msgCode;
    private String name;
    private String text;

    @Override
    public void deserialize(EventReader reader) {
        this.msgCode = reader.readWord();
        this.name = reader.readString();
        this.text = reader.readString();
    }
}
