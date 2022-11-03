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
public final class GumpTextEntryEvent implements EventReadable {
    private Long id = 0L;
    private String title = "";
    private Integer inputStyle = 0;
    private Long maxValue = 0L;
    private String title2 = "";

    @Override
    public void deserialize(EventReader reader) {
        this.id = reader.readCardinal();
        this.title = reader.readString();
        this.inputStyle = reader.readSmallInteger();
        this.maxValue = reader.readCardinal();
        this.title2 = reader.readString();
    }
}