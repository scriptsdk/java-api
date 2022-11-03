package de.scriptsdk.api.interfaces.event;

import de.scriptsdk.api.model.network.ApiClient;

/**
 * @author Crome696
 * @version 1.0
 */
@FunctionalInterface
public interface ExtendedEventAction<T extends EventReadable> {
    void onEvent(ApiClient client, T eventData);
}
