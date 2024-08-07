package src.ex00;

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

        Egg egg = new Egg(count);
        Hen hen = new Hen(count);

        egg.start();
        hen.start();

        try {
            egg.join();
            hen.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        for (int i = 0; i < count; i++) {
            System.out.println("Human");
        }
    }
}
