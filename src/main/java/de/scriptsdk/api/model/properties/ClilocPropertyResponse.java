package de.scriptsdk.api.model.properties;

import de.scriptsdk.core.interfaces.Deserializable;
import de.scriptsdk.core.model.io.PacketReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Crome696
 * @version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public final class ClilocPropertyResponse implements Deserializable {

    private Long clilocID = 0L;
    private List<String> args = new ArrayList<>();

    @Override
    public void deserialize(PacketReader reader) {
        this.setClilocID(reader.readCardinal());

        args = reader.readList(PacketReader::readString);
    }
}
