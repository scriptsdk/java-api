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
public final class HuedGumpPictureResponse extends BaseGumpElementResponse {
    private Integer graphic = 0;
    private Integer color = 0;
    private Integer elementNumber = 0;

    @Override
    public void deserialize(PacketReader reader) {
        super.deserialize(reader);

        this.setGraphic(reader.readInteger());
        this.setColor(reader.readInteger());
        this.setElementNumber(reader.readInteger());
    }
}
