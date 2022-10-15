package de.scriptsdk.api.model.entity;

import de.scriptsdk.api.model.network.ApiClient;

public abstract class ApiEntity {
    protected final ApiClient client;

    protected ApiEntity(ApiClient client) {
        this.client = client;
    }

    protected ApiClient getClient() {
        return client;
    }
}
