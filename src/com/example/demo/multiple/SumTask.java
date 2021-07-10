package com.example.demo.multiple;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Long> {

    static final int THRESHOLD = 50;
    long[] array;
    int start;
    int end;

    SumTask(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long nano = System.nanoTime();
        if (end - start <= THRESHOLD) {
            // 如果任务足够小,直接计算:
            long sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.printf("%s: compute %d~%d = %d%n\n", Thread.currentThread().getName(), start, end, sum);
            return sum;
        }
        // 任务太大,一分为二:
        int middle = (end + start) / 2;
//        System.out.printf("%s: split %d~%d ==> %d~%d, %d~%d%n\n", Thread.currentThread().getName(), start, end, start, middle, middle, end);
        System.out.printf("%s: split %d~%d ==> %d~%d, %d~%d, nano=%d%n\n", Thread.currentThread().getName(), start, end, start, middle, middle, end, nano);
        SumTask subtask1 = new SumTask(this.array, start, middle);
        SumTask subtask2 = new SumTask(this.array, middle, end);
        /*
         * 分别对子任务调用fork():
         */
        // ================================================
        //================================================
//        boolean flag = true;
        boolean flag = false;
        if (flag) {
            invokeAll(subtask1, subtask2);
        } else {
            subtask1.fork();
            subtask2.fork();
        }
        // ================================================
        /*
         * 合并结果:
         */
        Long subresult1 = subtask1.join();
        Long subresult2 = subtask2.join();
        Long result = subresult1 + subresult2;
        System.out.println(Thread.currentThread().getName() + ": result = " + subresult1 + " + " + subresult2 + " ==> " + result);
        return result;
    }

    public static void fillArray(long[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    public static void main(String[] args) throws Exception {
        // 创建随机数组成的数组:
        long[] array = new long[400];
//        long[] array = new long[800];
        fillArray(array);
        // fork/join task:
//        ForkJoinPool fjp = new ForkJoinPool(1); // 最大并发数1
        ForkJoinPool fjp = new ForkJoinPool(2); // 最大并发数2
//        ForkJoinPool fjp = new ForkJoinPool(4); // 最大并发数4
//        ForkJoinPool fjp = new ForkJoinPool(8); // 最大并发数8
//        ForkJoinPool fjp = new ForkJoinPool(16); // 最大并发数16
        ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
        long startTime = System.currentTimeMillis();
        Long result = fjp.invoke(task);
        long endTime = System.currentTimeMillis();
        System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
    }
}