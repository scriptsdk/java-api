package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Crome696
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public final class SpeechEvent implements EventReadable {
    private String text = "";
    private String senderName = "";
    private Long senderId = 0L;

    @Override
    public void deserialize(EventReader reader) {
        this.text = reader.readString();
        this.senderName = reader.readString();
        this.senderId = reader.readCardinal();
    }
}
