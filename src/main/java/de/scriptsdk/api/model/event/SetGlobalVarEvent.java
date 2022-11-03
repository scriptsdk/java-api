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
public final class SetGlobalVarEvent implements EventReadable {

    private String value = "";
    private String varName = "";

    @Override
    public void deserialize(EventReader reader) {

        this.varName = reader.readString();

        this.value = reader.readString();

    }
}
