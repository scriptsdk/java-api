package de.scriptsdk.api.model.event;

import de.scriptsdk.api.enums.Direction;
import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import de.scriptsdk.core.interfaces.Enumerable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public final class MoveRejectionEvent implements EventReadable {
    private Integer sourceX;
    private Integer sourceY;
    private Direction direction;
    private Integer targetX;
    private Integer targetY;

    @Override
    public void deserialize(EventReader reader) {
        this.sourceX = reader.readWord();
        this.sourceY = reader.readWord();
        this.direction = Enumerable.valueOf(reader.readSmallInteger(), Direction.class);
        this.targetX = reader.readWord();
        this.targetY = reader.readWord();
    }
}