package org.example.juc.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Main {

    /**
     * @link https://www.baeldung.com/java-fork-join
     */
    public static void main(String[] args) {
        //testRecursiveAction();
        //testRecursiveTask();
    }

    private static void testRecursiveTask() {
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        CustomRecursiveTask customRecursiveTask = new CustomRecursiveTask(new int[]{1,34,2,423,43,2432,42345,12351,54225,22,4,245,434,5345,242,5435,3254});
        // 1
        commonPool.execute(customRecursiveTask);
        System.out.println(customRecursiveTask.join());
        //2
        System.out.println(commonPool.invoke(customRecursiveTask));
        //3
        ForkJoinTask<Integer> fork = customRecursiveTask.fork();
        System.out.println(fork.join());
    }

    private static void testRecursiveAction() {
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        CustomRecursiveAction customRecursiveAction = new CustomRecursiveAction("abcdefghlijkmopqrxyz");
        // 1
        commonPool.execute(customRecursiveAction);
        customRecursiveAction.join();
        //2
        commonPool.invoke(customRecursiveAction);
        //3
        customRecursiveAction.fork();
    }
}
