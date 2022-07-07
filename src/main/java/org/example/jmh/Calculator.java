package org.example.jmh;

/**
 * @author web
 * @date 2022年07月07日
 * Calculator
 *
 */
public interface Calculator {

    long sum(int[] numbers);

    /**
     * shutdown pool or reclaim any related resources
     */
    void shutdown();
}
