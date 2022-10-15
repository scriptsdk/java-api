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
public final class CheckBoxResponse extends BaseGumpActionElementResponse {
    private Integer status = 0;
    private Integer returnValue = 0;
    private Integer page = 0;
    private Integer elementNumber = 0;

    @Override
    public void deserialize(PacketReader reader) {
        super.deserialize(reader);

        this.setStatus(reader.readInteger());
        this.setReturnValue(reader.readInteger());
        this.setPage(reader.readInteger());
        this.setElementNumber(reader.readInteger());
    }
}

