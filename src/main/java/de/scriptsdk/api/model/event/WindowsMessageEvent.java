package de.scriptsdk.api.model.event;

import de.scriptsdk.api.interfaces.event.EventReadable;
import de.scriptsdk.api.model.mobile.io.EventReader;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public final class WindowsMessageEvent implements EventReadable {
    private Long lParam;

    public Long getLParam() {
        return lParam;
    }

    @Override
    public void deserialize(EventReader reader) {
        this.lParam = reader.readCardinal();
    }
}
