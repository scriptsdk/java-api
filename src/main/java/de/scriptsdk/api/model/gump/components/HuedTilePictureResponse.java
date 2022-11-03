package de.scriptsdk.api.model.gump.components;

import de.scriptsdk.api.model.gump.core.BaseGumpElementResponse;
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
@EqualsAndHashCode(callSuper = true)
public final class HuedTilePictureResponse extends BaseGumpElementResponse {

    private Integer id = 0;
    private Integer color = 0;
    private Integer page = 0;
    private Integer elementNumber = 0;

    @Override
    public void deserialize(PacketReader reader) {
        super.deserialize(reader);

        this.setId(reader.readInteger());
        this.setColor(reader.readInteger());
        this.setPage(reader.readInteger());
        this.setElementNumber(reader.readInteger());
    }
}
