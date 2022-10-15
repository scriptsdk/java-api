package de.scriptsdk.api.model.gump.components;

import de.scriptsdk.core.model.io.PacketReader;
import de.scriptsdk.api.model.gump.core.BaseGumpElementResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public final class PictureInPictureResponse extends BaseGumpElementResponse {

    private Integer graphic = 0;
    private Integer startX = 0;
    private Integer startY = 0;
    private Integer width = 0;
    private Integer height = 0;
    private Integer elementNumber = 0;

    @Override
    public void deserialize(PacketReader reader) {
        super.deserialize(reader);

        this.setGraphic(reader.readInteger());
        this.setStartX(reader.readInteger());
        this.setStartY(reader.readInteger());
        this.setWidth(reader.readInteger());
        this.setHeight(reader.readInteger());
        this.setElementNumber(reader.readInteger());
    }
}
