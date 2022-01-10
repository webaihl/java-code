package org.example.async;

@FunctionalInterface
public interface Worker {
    String action(Object object);
}
