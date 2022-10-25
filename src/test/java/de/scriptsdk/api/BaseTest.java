package de.scriptsdk.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import de.scriptsdk.core.exceptions.BaseException;
import de.scriptsdk.core.model.mapper.BaseJsonMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

public abstract class BaseTest {
    final BaseJsonMapper mapper = new BaseJsonMapper();

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
    }

    @AfterEach
    protected void onAfterEach() {
        System.out.println("-> Finished");
    }
}
