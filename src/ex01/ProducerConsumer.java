package src.ex01;

public class ProducerConsumer {
    private Answer answer;

    public ProducerConsumer() {
        this.answer = Answer.EGG;
    }

    public synchronized void printEgg() throws InterruptedException {
        if (!this.answer.equals(Answer.EGG)) {
            wait();
        }

        System.out.println("Egg");
        this.answer = Answer.HEN;
        notify();
    }

    public synchronized void printHen() throws InterruptedException {
        if (!this.answer.equals(Answer.HEN)) {
            wait();
        }

        System.out.println("Hen");
        this.answer = Answer.EGG;
        notify();
    }


    private enum Answer {
        EGG, HEN
    }
}
