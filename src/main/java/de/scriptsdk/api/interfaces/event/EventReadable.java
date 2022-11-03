package de.scriptsdk.api.interfaces.event;

import de.scriptsdk.api.model.io.EventReader;

/**
 * @author Crome696
 * @version 1.0
 */
public interface EventReadable {
    void deserialize(EventReader reader);
}
