package de.scriptsdk.api.model.event;

import de.scriptsdk.api.enums.Direction;
import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.io.EventReader;
import de.scriptsdk.core.interfaces.Enumerable;
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
public final class MoveRejectionEvent implements EventReadable {
    private Integer sourceX = 0;
    private Integer sourceY = 0;
    private Direction direction = Direction.UNKNOWN;
    private Integer targetX = 0;
    private Integer targetY = 0;

    @Override
    public void deserialize(EventReader reader) {
        this.sourceX = reader.readWord();
        this.sourceY = reader.readWord();
        this.direction = Enumerable.valueOf(reader.readSmallInteger(), Direction.class);
        this.targetX = reader.readWord();
        this.targetY = reader.readWord();
    }
}