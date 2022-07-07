package org.example.jmh;

/**
 * @author web
 * @date 2022年07月07日
 * 自然数求和的串行和并行算法性能测试
 **/


import lombok.extern.slf4j.Slf4j;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
@Slf4j
public class SecondBenchmark {
    @Param({"10000", "100000", "1000000"})
    private int length;

    private int[] numbers;
    private Calculator singleThreadCalc;
    private Calculator multiThreadCalc;

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(SecondBenchmark.class.getSimpleName())
                .forks(1)
                .warmupIterations(5)
                .measurementIterations(2)
                .build();
        Collection<RunResult> results = new Runner(opt).run();
        System.out.println("单线程与多线程求和性能 " + results + " length + 微秒");
    }


    @Benchmark
    public long singleThreadBench() {
        return singleThreadCalc.sum(numbers);
    }

    @Benchmark
    public long multiThreadBench() {
        return multiThreadCalc.sum(numbers);
    }

    @Setup
    public void prepare() {
        numbers = IntStream.rangeClosed(1, length).toArray();
//        singleThreadCalc = new SinglethreadCalculator();
//        multiThreadCalc = new MultithreadCalculator(Runtime.getRuntime().availableProcessors());
    }

    @TearDown
    public void shutdown() {
        singleThreadCalc.shutdown();
        multiThreadCalc.shutdown();
    }
}
