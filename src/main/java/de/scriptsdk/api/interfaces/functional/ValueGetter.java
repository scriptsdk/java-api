package de.scriptsdk.api.interfaces.functional;

@FunctionalInterface
public interface ValueGetter<T> {
    T getValue();
}
