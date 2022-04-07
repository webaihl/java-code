package org.example.code;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.stream.Stream;

public class BigfileTopK {

    //模拟海量数据的文件
    private final static File file = new File("topkdata.txt");
    private final static Random random = new Random();
    private final static PriorityQueue<Long> priorityQueue = new PriorityQueue<>(10);

    public static void main(String[] args) throws IOException {
//        System.out.println(file.length());
//        init();
        long start = System.currentTimeMillis();
//        computeTopK();
        // todo 1、文件拆分line count 2、new_stream=stream.skip().limit()  3、reduce
        computeTopK2();
        System.out.println("用时：" + String.format("%.2f",(System.currentTimeMillis() - start)/1000.0));

    }

    public static void computeTopK2() {
        try {
            Stream<String> lines = Files.lines(Paths.get("topkdata.txt"));
            lines.forEach(line-> addToTopKQueue(Long.valueOf(line)));
            printQuery();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printQuery() {
        System.out.println("Long.MAX_VALUE = " + Long.MAX_VALUE);
        Long target;
        while ((target = BigfileTopK.priorityQueue.poll()) != null) {
            System.out.println("target = " + target);
        }
    }

    public static void computeTopK() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                addToTopKQueue(Long.valueOf(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        printQuery();
    }

    /**
     * init方法仅运行一次即可，是为准备模拟数据
     */
    public static void init() {
        long start = System.currentTimeMillis();
        System.out.println("init");
        try {
            if (file.createNewFile()) {
                System.out.println("New Text File is created!");
            } else {
                System.out.println("File already exists.");
                return;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileWriter fileWriter = new FileWriter(file, true)) {

            //先用100万数据，多了电脑可能受不了
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                fileWriter.write(random.nextLong() + System.lineSeparator());
            }
            //写入10个接近long的最大值的数，便于取出是验证正确结果
            for (int i = 0; i < 10; i++) {
                fileWriter.write(Long.MAX_VALUE - i + System.lineSeparator());
            }
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("用时：" + (System.currentTimeMillis() - start));
        }
    }

    public static void addToTopKQueue(Long target) {
        if (priorityQueue.size() < 10) {
            priorityQueue.add(target);
        } else {
            Long head = priorityQueue.peek();
            if (target > head) {
                priorityQueue.poll();
                priorityQueue.add(target);
            }
        }
    }

}

