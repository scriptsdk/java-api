package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public final class CharAnimationEvent implements EventReadable {
    private Long id;
    private Integer action;


    public Long getId() {
        return id;
    }

    public Integer getAction() {
        return action;
    }

    @Override
    public void deserialize(EventReader reader) {
        this.id = reader.readCardinal();
        this.action = reader.readWord();
    }
}