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
public final class ResizablePictureResponse extends BaseGumpElementResponse {
    private Integer gumpId = 0;
    private Integer width = 0;
    private Integer height = 0;
    private Integer page = 0;
    private Integer elementNumber = 0;

    @Override
    public void deserialize(PacketReader reader) {
        super.deserialize(reader);

        this.setGumpId(reader.readInteger());
        this.setWidth(reader.readInteger());
        this.setHeight(reader.readInteger());
        this.setPage(reader.readInteger());
        this.setElementNumber(reader.readInteger());
    }
}
