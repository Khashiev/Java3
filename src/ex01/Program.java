package src.ex01;

public class Program {
    public static void main(String[] args) {
        String prefix = "--count=";

        if (args.length != 1 || !args[0].startsWith(prefix)) {
            System.err.println("Invalid count number");
            System.exit(-1);
        }

        int count = Integer.parseInt(args[0].substring(prefix.length()));

        if (count <= 0) {
            System.err.println("Invalid count number");
            System.exit(-1);
        }

        ProducerConsumer producerConsumer = new ProducerConsumer();
        Thread egg = new Thread(new Egg(count, producerConsumer));
        Thread hen = new Thread(new Hen(count, producerConsumer));

        egg.start();
        hen.start();
    }
}
