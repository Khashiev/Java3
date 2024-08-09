package src.ex02;

public class Adder implements Runnable {
    private final ProducerConsumer producerConsumer;
    private final int[] array;
    private final int begin;
    private final int end;
    private final int threadId;

    public Adder(ProducerConsumer producerConsumer, int[] array, int begin,
                 int end, int threadId) {
        this.producerConsumer = producerConsumer;
        this.array = array;
        this.begin = begin;
        this.end = end;
        this.threadId = threadId;
    }

    @Override
    public synchronized void run() {
        try {
            producerConsumer.printThreadSum(array, begin, end, threadId);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
