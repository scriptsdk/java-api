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
public final class UpdateObjectStatusEvent implements EventReadable {

    private Long id = 0L;
    private Integer currentLife = 0;
    private Integer maximumLife = 0;
    private Integer currentMana = 0;
    private Integer maximumMana = 0;
    private Integer currentStamina = 0;
    private Integer maximumStamina = 0;

    @Override
    public void deserialize(EventReader reader) {
        this.id = reader.readCardinal();
        this.currentLife = reader.readInteger();
        this.maximumLife = reader.readInteger();
        this.currentMana = reader.readInteger();
        this.maximumMana = reader.readInteger();
        this.currentStamina = reader.readInteger();
        this.maximumStamina = reader.readInteger();
    }
}
