package de.scriptsdk.api.interfaces.event;

import de.scriptsdk.api.model.network.ApiClient;

@FunctionalInterface
public interface EventAction {
    void onEvent(ApiClient client);
}
