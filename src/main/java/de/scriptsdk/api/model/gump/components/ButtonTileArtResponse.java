package de.scriptsdk.api.model.gump.components;

import de.scriptsdk.core.model.io.PacketReader;
import de.scriptsdk.api.model.gump.core.BaseGumpActionElementResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public final class ButtonTileArtResponse extends BaseGumpActionElementResponse {
    private Integer quit = 0;
    private Integer pageId = 0;
    private Integer returnValue = 0;
    private Integer artId = 0;
    private Integer hue = 0;
    private Integer artX = 0;
    private Integer artY = 0;
    private Integer elementNumber = 0;

    @Override
    public void deserialize(PacketReader reader) {
        super.deserialize(reader);

        this.setPageId(reader.readInteger());
        this.setReturnValue(reader.readInteger());
        this.setArtId(reader.readInteger());
        this.setHue(reader.readInteger());
        this.setArtX(reader.readInteger());
        this.setArtY(reader.readInteger());
        this.setElementNumber(reader.readInteger());
    }
}
