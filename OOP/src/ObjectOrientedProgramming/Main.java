package ObjectOrientedProgramming;

public class Main {
    public static void main(String[] args) {
        String usageMessage =
                "Usage: java Main int denumerator\n" +
                        "  int and denumerator should be integers; denumerator may not be zero.";
        if(args.length != 2) {
            System.err.println(usageMessage);
            System.exit(1);
        }
        int numerator = 1,denumerator = 1;
        try {
            numerator = Integer.parseInt(args[0]);
            denumerator = Integer.parseInt(args[1]);
        }catch (NumberFormatException e) {
            System.err.println(usageMessage);
            System.exit(2);
        }
        RationalNumbers r1 = new RationalNumbers();
        RationalNumbers r2 = new RationalNumbers( numerator, denumerator);
        System.out.println("r1 =" + r1);
        System.out.println("r2 =" + r2);
    }
}
