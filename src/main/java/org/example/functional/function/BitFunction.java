package org.example.functional.function;

@FunctionalInterface
public interface BitFunction<T,U,R> {
    R apply(T t, U u);
}
