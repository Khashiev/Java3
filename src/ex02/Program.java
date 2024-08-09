package src.ex02;

public class Program {
    public static void main(String[] args) {
        String sizePrefix = "--arraySize=";
        String threadsCountPrefix = "--threadsCount=";

        if (args.length != 2 || !args[0].startsWith(sizePrefix) ||
                !args[1].startsWith(threadsCountPrefix)) {
            System.err.println("Invalid arguments");
            System.exit(-1);
        }

        try {
            int arrSize = Integer.parseInt(args[0].substring(sizePrefix.length()));
            int threadsCount = Integer.parseInt(args[1].substring(threadsCountPrefix.length()));

            if (arrSize > 2_000_000 || threadsCount > arrSize) {
                System.err.println("Invalid arguments");
                System.exit(-1);
            }

            RandomArray randomArray = new RandomArray(arrSize, threadsCount);
            randomArray.getSum();
        } catch (NumberFormatException e) {
            System.err.println("Invalid arguments");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
