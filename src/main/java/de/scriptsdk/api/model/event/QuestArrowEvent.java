package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public final class QuestArrowEvent implements EventReadable {
    private Integer x;
    private Integer y;
    private Boolean isActive;

    @Override
    public void deserialize(EventReader reader) {
        this.setX(reader.readWord());
        this.setY(reader.readWord());
        this.setIsActive(reader.readBoolean());
    }
}