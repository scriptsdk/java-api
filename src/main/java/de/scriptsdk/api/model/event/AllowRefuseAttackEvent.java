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
public final class AllowRefuseAttackEvent implements EventReadable {
    private Long id = 0L;
    private Boolean attackIsAllowed = false;

    @Override
    public void deserialize(EventReader reader) {
        this.id = reader.readCardinal();
        this.attackIsAllowed = reader.readBoolean();
    }
}