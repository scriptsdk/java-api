package de.scriptsdk.api.model.process;

import de.scriptsdk.api.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProcessHelperTest extends BaseTest {

    @Test
    void getProcessList() {
        ProcessHelper helper = new ProcessHelper();
        Assertions.assertDoesNotThrow(() ->
                log(helper.getProcessList("Stealth.exe")));
    }
}