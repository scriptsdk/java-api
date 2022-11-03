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
public final class ClilocSpeechAffixEvent implements EventReadable {
    private String clilocText = "";
    private String senderName = "";
    private Long senderId = 0L;
    private String affix = "";
    private Long clilocId = 0L;

    @Override
    public void deserialize(EventReader reader) {
        this.senderId = reader.readCardinal();
        this.senderName = reader.readString();
        this.clilocId = reader.readCardinal();
        this.affix = reader.readString();
        this.clilocText = reader.readString();
    }
}
