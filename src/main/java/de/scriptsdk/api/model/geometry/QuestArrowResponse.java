package de.scriptsdk.api.model.geometry;

import de.scriptsdk.core.interfaces.Deserializable;
import de.scriptsdk.core.model.io.PacketReader;

public class QuestArrowResponse implements Deserializable {
    private Integer x;
    private Integer y;

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }


    @Override
    public void deserialize(PacketReader reader) {
        this.x = reader.readWord();
        this.y = reader.readWord();
    }
}