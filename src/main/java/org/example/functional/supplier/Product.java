package org.example.functional.supplier;

@FunctionalInterface
public interface Product<T> {
    T get();
}
