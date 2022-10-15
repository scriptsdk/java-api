package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public final class QuestArrowEvent implements EventReadable {
    private Integer x;
    private Integer y;
    private Boolean isActive;


    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public void deserialize(EventReader reader) {
        this.setX(reader.readWord());
        this.setY(reader.readWord());
        this.setActive(reader.readBoolean());
    }
}