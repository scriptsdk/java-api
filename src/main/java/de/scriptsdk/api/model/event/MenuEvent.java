package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public final class MenuEvent implements EventReadable {

    private Long dialogId;
    private Integer menuId;

    @Override
    public void deserialize(EventReader reader) {

        this.dialogId = reader.readCardinal();
        this.menuId = reader.readWord();
    }
}