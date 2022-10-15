package de.scriptsdk.api.interfaces.event;

import de.scriptsdk.api.model.mobile.io.EventReader;

public interface EventReadable {
    void deserialize(EventReader reader);
}
