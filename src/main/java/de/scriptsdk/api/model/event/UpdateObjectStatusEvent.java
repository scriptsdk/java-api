package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public final class UpdateObjectStatusEvent implements EventReadable {

    private Long id;
    private Integer currentLife;
    private Integer maximumLife;
    private Integer currentMana;
    private Integer maximumMana;
    private Integer currentStamina;
    private Integer maximumStamina;

    public Long getId() {
        return id;
    }

    public Integer getCurrentLife() {
        return currentLife;
    }

    public Integer getMaximumLife() {
        return maximumLife;
    }

    public Integer getCurrentMana() {
        return currentMana;
    }

    public Integer getMaximumMana() {
        return maximumMana;
    }

    public Integer getCurrentStamina() {
        return currentStamina;
    }

    public Integer getMaximumStamina() {
        return maximumStamina;
    }

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
