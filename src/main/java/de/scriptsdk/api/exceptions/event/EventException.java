package de.scriptsdk.api.exceptions.event;

import de.scriptsdk.core.exceptions.BaseException;

public class EventException extends BaseException {
    public EventException(String format, Object... args) {
        super(format, args);
    }

    public EventException(String message) {
        super(message);
    }
}
