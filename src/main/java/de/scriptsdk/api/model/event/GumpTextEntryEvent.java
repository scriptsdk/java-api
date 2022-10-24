package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public final class GumpTextEntryEvent implements EventReadable {
    private Long id;
    private String title;
    private Integer inputStyle;
    private Long maxValue;
    private String title2;

    @Override
    public void deserialize(EventReader reader) {
        this.id = reader.readCardinal();
        this.title = reader.readString();
        this.inputStyle = reader.readSmallInteger();
        this.maxValue = reader.readCardinal();
        this.title2 = reader.readString();
    }
}