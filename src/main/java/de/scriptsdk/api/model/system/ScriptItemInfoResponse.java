package de.scriptsdk.api.model.system;

import de.scriptsdk.core.enums.network.ScriptState;
import de.scriptsdk.core.interfaces.Deserializable;
import de.scriptsdk.core.interfaces.Enumerable;
import de.scriptsdk.core.model.io.PacketReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Crome696
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ScriptItemInfoResponse implements Deserializable {
    private Integer index = 0;
    private String name = " ";
    private ScriptState state = ScriptState.UNKNOWN;

    @Override
    public void deserialize(PacketReader reader) {
        this.setIndex(reader.readWord());
        this.setName(reader.readString());
        this.setState(Enumerable.valueOf(reader.readWord(), ScriptState.class));
    }
}