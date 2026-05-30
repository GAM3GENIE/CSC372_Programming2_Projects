import java.util.InputMismatchException;
import java.util.Scanner;

public class ProvideProduct {

    private static final int SIZE = 5;

    public static void run() {
        Scanner sc = new Scanner(System.in);

        try {
            long[] numbers = readNumbers(sc, SIZE);
            long product = productNumbers(numbers, 0);
            System.out.println("The product of your five numbers is: " + product);
        } catch (ArithmeticException e) {
            System.out.println("The product is too large or too small to fit in a long value.");
        } finally {
            sc.close();
        }
    }

    public static long[] readNumbers(Scanner sc, int size) {
        long[] numbers = new long[size];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = readLong(sc, "Enter number " + (i + 1) + ": ");
        }

        return numbers;
    }

    public static long readLong(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return sc.nextLong();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a whole number.");
                sc.next();
            }
        }
    }

    public static long productNumbers(long[] numbers, int index) {
        if (index == numbers.length) {
            return 1L;
        }

        long partialProduct = productNumbers(numbers, index + 1);
        return Math.multiplyExact(numbers[index], partialProduct);
    }
}