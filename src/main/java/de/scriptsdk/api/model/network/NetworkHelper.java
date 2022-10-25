package de.scriptsdk.api.model.network;

import de.scriptsdk.core.exceptions.BaseException;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class NetworkHelper {
    public Integer getPing(String url, Integer port, Integer tryout) {

        InetSocketAddress address = new InetSocketAddress(url, port);

        int delay = 0;

        for (int index = 0; index < tryout; index++) {
            try {
                Socket socket = new Socket();
                long start = System.nanoTime();

                socket.connect(address, 5000);

                long finish = System.nanoTime();
                long durationInMs = TimeUnit.MILLISECONDS.convert(finish - start, TimeUnit.NANOSECONDS);
                delay += (int) durationInMs;

                socket.close();
            } catch (IOException e) {
                throw new BaseException(e);
            }
        }
        return (int) ((double) delay / (double) tryout);
    }
}
