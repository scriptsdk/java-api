package de.scriptsdk.api.exceptions.api;

import de.scriptsdk.core.exceptions.BaseException;

public class ApiException extends BaseException {
    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String format, Object... args) {
        super(String.format(format, args));
    }

}
