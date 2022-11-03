package de.scriptsdk.api.model.menu;

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
public final class MenuResponseResponse implements Deserializable {
    private Integer model = 0;
    private Integer color = 0;
    private String text = "";

    @Override
    public void deserialize(PacketReader reader) {
        this.setModel(reader.readInteger());
        this.setColor(reader.readInteger());
        this.setText(reader.readString());
    }
}
