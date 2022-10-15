package de.scriptsdk.api.model.gump.components;

import de.scriptsdk.core.interfaces.Deserializable;
import de.scriptsdk.core.model.io.PacketReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public final class UpperWordCaseToggleResponse implements Deserializable {
    private String arguments = "";
    private Integer elementNumber = 0;

    @Override
    public void deserialize(PacketReader reader) {
        this.setArguments(reader.readString());
        this.setElementNumber(reader.readInteger());
    }
}
