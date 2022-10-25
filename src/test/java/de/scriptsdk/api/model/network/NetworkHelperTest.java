package de.scriptsdk.api.model.network;

import de.scriptsdk.api.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NetworkHelperTest extends BaseTest {

    @Test
    void getPing() {
        NetworkHelper helper = new NetworkHelper();

        Assertions.assertDoesNotThrow(() ->
                log(helper.getPing("play.uovnv.com", 2593, 2)));
    }
}