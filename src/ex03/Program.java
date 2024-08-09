package src.ex03;

public class Program {
    public static void main(String[] args) {
        String prefix = "--threadsCount=";

        if (args.length != 1 || !args[0].startsWith(prefix)) {
            System.out.println("Invalid argument");
            System.exit(-1);
        }

        System.out.println("Hello");
    }
}
