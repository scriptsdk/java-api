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
public final class XmfHtmlTokenResponse extends BaseGumpElementResponse {
    private Integer width = 0;
    private Integer height = 0;
    private Integer background = 0;
    private Integer scrollbar = 0;
    private Integer color = 0;
    private Long clilocId = 0L;
    private String arguments = "";
    private Integer page = 0;
    private Integer elementNumber = 0;

    @Override
    public void deserialize(PacketReader reader) {
        super.deserialize(reader);

        this.setWidth(reader.readInteger());
        this.setHeight(reader.readInteger());
        this.setBackground(reader.readInteger());
        this.setScrollbar(reader.readInteger());
        this.setColor(reader.readInteger());
        this.setClilocId(reader.readCardinal());
        this.setArguments(reader.readString());
        this.setPage(reader.readInteger());
        this.setElementNumber(reader.readInteger());
    }
}
