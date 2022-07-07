package org.example.jmh;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @see  <a href="https://www.xncoding.com/2018/01/07/java/jmh.html">https://www.xncoding.com/2018/01/07/java/jmh.html</a>
 * @see  <a href="http://hg.openjdk.java.net/code-tools/jmh/file/tip/jmh-samples/src/main/java/org/openjdk/jmh/samples/">http://hg.openjdk.java.net/code-tools/jmh/file/tip/jmh-samples/src/main/java/org/openjdk/jmh/samples/</a>
 * @author web
 * @date 2022年07月07日
 */
public class JmhMain {

    public static void main(String[] args) {
        stringDemo();
    }

    public static void stringDemo()  {
        Options options = new OptionsBuilder()
                .include(StringBuilderBenchmark.class.getSimpleName())
                .output("Benchmark.log")
                .build();
        try {
            new Runner(options).run();
        } catch (RunnerException e) {
            throw new RuntimeException(e);
        }
    }
}
