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
public final class QuestArrowEvent implements EventReadable {
    private Integer x = 0;
    private Integer y = 0;
    private Boolean isActive = false;

    @Override
    public void deserialize(EventReader reader) {
        this.setX(reader.readWord());
        this.setY(reader.readWord());
        this.setIsActive(reader.readBoolean());
    }
}