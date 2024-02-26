import java.util.Scanner;
import java.util.Random;
/**
 * guess
 */
public class guess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int start = 1;
        int end = 100;
        int numGenerated = random.nextInt(end - start + 1) + start;
        int max = 5;
        int attempts = 0;

        System.out.println("This ia a Number Guessing Game!");
        System.out.println("A number will be generated between " + start + " and " + end + ". Can you guess it?");

        while (attempts<max) {
            System.out.print("Enter your guess: ");
            int userGuess = sc.nextInt();
            if (userGuess == numGenerated) {
                System.out.println("Congratulations! You have guessed the correct number in " + attempts + " attempts.");
                break;
            } else if (userGuess < numGenerated) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }

            if (attempts == max) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was " + numGenerated + ".");
                break;
            }
            attempts++;
        }

        sc.close();
    }
    
}