package src.ex02;

import java.util.Arrays;
import java.util.Random;

public class RandomArray {
    private final int[] array;
    private final int threadsCount;

    public RandomArray(int sizeArray, int threadsCount) {
        Random random = new Random();
        array = new int[sizeArray];
        for (int i = 0; i < sizeArray; i++) {
            array[i] = random.nextInt(1000) + 1;
        }

        this.threadsCount = threadsCount;
    }

    public void getSum() throws InterruptedException {
        int sum = Arrays.stream(array).sum();
        System.out.println("Sum " + sum);

        Thread[] threads = new Thread[threadsCount];
        ProducerConsumer consumer = new ProducerConsumer(threadsCount);

        int begin = 0;
        int step = (array.length + threadsCount - 1) / threadsCount;

        for (int i = 0; i < threadsCount; i++) {
            int end = Math.min(begin + step, array.length);
            Runnable runnable = new Adder(consumer, array, begin, end, i + 1);
            threads[i] = new Thread(runnable);
            threads[i].start();
            threads[i].join();
            begin = end;
        }

        consumer.printRes();
    }
}
