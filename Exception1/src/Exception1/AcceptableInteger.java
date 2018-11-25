package Exception1;
import java.util.Scanner;
public class AcceptableInteger {

    private int minAcceptable = 1;
    private int maxAcceptable = 100;
    private String prompt = "type a numer between 1 and to";
    private int userInput;

    public void getValue() {
        int input;
        Scanner keys = new Scanner(System.in);
        System.out.println(prompt);
        input = keys.nextInt();
        userInput = input;
        System.out.println("you input " + userInput);
    }

    public void checkValidity() {
        if (userInput >= 1 && userInput <= 100) {
            System.out.println(userInput + " is valid");
        }
        else {
            System.out.println(userInput + " is not valid");
        }
    }

    public static void main (String args[]) {

        AcceptableInteger test = new AcceptableInteger();
        test.getValue();
        test.checkValidity();



    }
}

