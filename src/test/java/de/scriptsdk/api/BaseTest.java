package de.scriptsdk.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.scriptsdk.api.enums.LanguageType;
import de.scriptsdk.api.model.network.ApiClient;
import de.scriptsdk.api.model.system.Version;
import de.scriptsdk.core.exceptions.BaseException;
import de.scriptsdk.core.model.mapper.BaseJsonMapper;
import org.junit.jupiter.api.*;

import java.util.Objects;

public abstract class BaseTest {
    static ApiClient client;
    final BaseJsonMapper mapper = new BaseJsonMapper();

    @BeforeAll
    static void prepareStage() {
        client = new ApiClient("localhost", 47602);
        if (Objects.equals(client.isStealthRunning(), true)) {
            client.authenthicate(LanguageType.OTHER, new Version(1, 0, 0, 0));
        }
    }

    public ApiClient getClient() {
        return client;
    }

    public <T> void log(T value) {
        try {
            String text = String.format("-> Result = %s", mapper.writeValueAsString(value));
            System.out.println(text);
        } catch (JsonProcessingException e) {
            throw new BaseException(e);
        }
    }

    @BeforeEach
    protected void onBeforeEach(TestInfo testInfo) {
        System.out.println("-------------------------");
        String methodName = String.format("-> Executing \"%s\"", testInfo.getDisplayName());
        System.out.println(methodName);
        if (Objects.equals(getClient().isStealthRunning(), false)) {
            Assertions.fail("No Unit-Test without Stealth client");
        }

        if (Objects.equals(getClient().isConnected(), false)) {
            getClient().connect();

            while (Objects.equals(getClient().isConnected(), false)) {
                getClient().waitForClient(250);
            }
        }
    }

    @AfterEach
    protected void onAfterEach() {
        System.out.println("-> Finished");
    }
}
