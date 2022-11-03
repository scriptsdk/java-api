package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Crome696
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public final class MenuEvent implements EventReadable {

    private Long dialogId = 0L;
    private Integer menuId = 0;

    @Override
    public void deserialize(EventReader reader) {

        this.dialogId = reader.readCardinal();
        this.menuId = reader.readWord();
    }
}