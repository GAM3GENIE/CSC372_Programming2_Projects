import java.util.InputMismatchException;
import java.util.Scanner;

public class ProvideProduct {
    public static int productNumbers(int[] numbers, int index){
        // base
        if(index == numbers.length - 1){
            return numbers[index];
        }
        return numbers[index] * productNumbers(numbers, index + 1);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        for(int i = 0; i < numbers.length; i++){
            while(true) {
                try {
                    System.out.println("Enter a number " + (i + 1) + ": ");
                    numbers[i] = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a whole number.");
                    sc.next();
                }
            }
        }

        int product = productNumbers(numbers, 0);
        System.out.println("The product of your five numbers is: " + product);
        sc.close();
    }
}
