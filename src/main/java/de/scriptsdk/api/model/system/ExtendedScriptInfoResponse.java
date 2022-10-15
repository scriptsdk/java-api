package de.scriptsdk.api.model.system;

import de.scriptsdk.core.interfaces.Deserializable;
import de.scriptsdk.core.model.io.PacketReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public final class ExtendedScriptInfoResponse implements Deserializable {
    Integer timeZone = 0;

    @Override
    public void deserialize(PacketReader reader) {
        this.setTimeZone(reader.readInteger());
    }
}
