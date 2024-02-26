import java.util.Scanner;

public class calculator {
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: Take marks obtained in each subject
        System.out.println("Enter the marks obtained (out of 100) in each subject:");
        System.out.print("Subject 1: ");
        int sub1 = sc.nextInt();
        System.out.print("Subject 2: ");
        int sub2 = sc.nextInt();
        System.out.print("Subject 3: ");
        int sub3 = sc.nextInt();

        // Calculate Total Marks
        int tot= sub1 + sub2 + sub3;

        // Calculate Average Percentage
        double avg = tot / 3.0;

        // Grade Calculation
        char G;
        if (avg >= 90) {
            G = 'A';
        } else if (avg >= 80) {
            G = 'B';
        } else if (avg >= 65) {
            G = 'C';
        } else if (avg >= 55) {
            G = 'D';
        } else if (avg >= 40) {
            G = 'E';
        } else {
            G = 'F';
        }

        // Display Results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + tot);
        System.out.println("Average Percentage: " + avg + "%");
        System.out.println("Grade: " + G);

        sc.close();
    }
}
