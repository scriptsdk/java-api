package de.scriptsdk.api.exceptions.dto;

import de.scriptsdk.core.exceptions.BaseException;

public class DtoException extends BaseException {
    public DtoException(String format, Object... args) {
        super(format, args);
    }

    public DtoException(String message) {
        super(message);
    }
}
