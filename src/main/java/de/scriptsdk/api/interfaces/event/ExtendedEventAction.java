package de.scriptsdk.api.interfaces.event;

import de.scriptsdk.api.model.network.ApiClient;

@FunctionalInterface
public interface ExtendedEventAction<T extends EventReadable> {
    void onEvent(ApiClient client, T eventData);
}
