package de.scriptsdk.api.exceptions.api;

import de.scriptsdk.core.exceptions.BaseException;

/**
 * @author Crome696
 * @version 1.0
 */
public class ApiException extends BaseException {
    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String format, Object... args) {
        super(String.format(format, args));
    }

}
