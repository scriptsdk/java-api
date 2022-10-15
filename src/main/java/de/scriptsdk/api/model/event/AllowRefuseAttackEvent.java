package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public final class AllowRefuseAttackEvent implements EventReadable {
    private Long id;
    private Boolean attackIsAllowed;


    public Long getId() {
        return id;
    }

    public Boolean getAttackIsAllowed() {
        return attackIsAllowed;
    }

    @Override
    public void deserialize(EventReader reader) {
        this.id = reader.readCardinal();
        this.attackIsAllowed = reader.readBoolean();
    }
}