package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public final class BuffDebuffSystemEvent implements EventReadable {
    private Long id;
    private Integer attributeID;
    private Boolean isEnabled;


    public Long getId() {
        return id;
    }

    public Integer getAttributeID() {
        return attributeID;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    @Override
    public void deserialize(EventReader reader) {
        this.id = reader.readCardinal();
        this.attributeID = reader.readWord();
        this.isEnabled = reader.readBoolean();
    }
}
