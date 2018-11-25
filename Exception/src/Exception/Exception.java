package Exception;
import java.util.InputMismatchException;
import java.util.Scanner;
/*public class Exception {
    public void printTo100(){
        int[] array = new int[101];
        try{
            printToArrayLimit(array, 1);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("No matching element found");
        }
    }
    public void printToArrayLimit(int[] array, int index){
        array[index] = array[index-1]+1;
        System.out.println(array[index]);
        printToArrayLimit(array, index+1);
    }
}*/
public class Exception {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean tryAgain = true;
        do {
            try {
                System.out.println("Please enter an integer between 1 and 100: ");

                int inInt = input.nextInt();

                if (inInt >= 1 && inInt <= 100){
                    System.out.println("Thank you.  Initialization completed.");
                    tryAgain = false;
                }
                else if (inInt < 1 || inInt > 100){
                    throw new NumberFormatException("Integer is out of range.");
                }
            }
            catch (NumberFormatException e1) { // Range check
                System.out.println("* The number you entered is not between 9 and 99.  Try again.");
                System.out.println();
                input.nextLine();
            }
            catch (InputMismatchException e2) { // Something other than a number
                System.out.println("* You did not enter an integer.  Try again.");
                System.out.println();
                input.nextLine();
            }
        } while(tryAgain);
    }
}
