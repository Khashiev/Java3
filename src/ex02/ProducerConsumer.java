package src.ex02;

public class ProducerConsumer {
    private final int threads;
    private int threadsSum;
    private int threadId;

    public ProducerConsumer(int threads) {
        this.threads = threads;
        this.threadsSum = 0;
        this.threadId = 1;
    }

    public synchronized void printThreadSum(int[] arr, int begin, int end, int threadId)
            throws InterruptedException {
        int sum = 0;

        for (int i = begin; i < end; i++) {
            sum += arr[i];
        }

        this.threadsSum += sum;
        this.threadId++;

        if (begin != end) {
            System.out.printf("Thread %d: from %d to %d sum is %d\n",
                    threadId, begin, end - 1, sum);
        }
        notify();
    }

    public synchronized void printRes() throws InterruptedException {
        if (threadId < threads) {
            wait();
        }

        System.out.println("Sum by threads: " + threadsSum);
    }
}
