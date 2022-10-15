package de.scriptsdk.api.interfaces.functional;

@FunctionalInterface
public interface ValueSetter<T> {
    void setValue(T value);
}
