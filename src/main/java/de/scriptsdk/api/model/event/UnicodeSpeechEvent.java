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
public final class UnicodeSpeechEvent implements EventReadable {

    private String senderName = "";
    private String text = "";
    private Long senderId = 0L;

    @Override
    public void deserialize(EventReader reader) {
        this.text = reader.readString();
        this.senderName = reader.readString();
        this.senderId = reader.readCardinal();
    }
}