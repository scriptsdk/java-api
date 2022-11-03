package de.scriptsdk.api.interfaces.functional;

/**
 * @author Crome696
 * @version 1.0
 */
@FunctionalInterface
public interface ValueGetter<T> {
    T getValue();
}
