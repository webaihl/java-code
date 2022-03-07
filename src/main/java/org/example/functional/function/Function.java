package org.example.functional.function;

@FunctionalInterface
public interface Function<T,R> {
    R apply(T t);
}
