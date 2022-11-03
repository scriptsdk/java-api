package de.scriptsdk.api.model.gump.components;

import de.scriptsdk.core.interfaces.Deserializable;
import de.scriptsdk.core.model.io.PacketReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


/**
 * @author Crome696
 * @version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public final class GumpTooltipResponse implements Deserializable {
    private Long clilocId = 0L;
    private String arguments = "";
    private Integer page = 0;
    private Integer elementNumber = 0;

    @Override
    public void deserialize(PacketReader reader) {
        this.setClilocId(reader.readCardinal());
        this.setArguments(reader.readString());
        this.setPage(reader.readInteger());
        this.setElementNumber(reader.readInteger());
    }
}
