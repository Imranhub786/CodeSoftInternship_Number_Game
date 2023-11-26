import java.util.Random;
import java.util.Scanner;

public class Launchgame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Extended Number Guessing Game!");
        boolean playAgain = true;
        int totalAttempts = 0;
        int totalRounds = 0;

        while (playAgain) {
            int lowerBound = 1;
            int upperBound = 100;
            int generatedNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int maxAttempts = 5;
            int attempts = 0;

            System.out.println("I have generated a number between " + lowerBound + " and " + upperBound + ". Try to guess!");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number!");
                    break;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                attempts++;
                totalAttempts++;
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + generatedNumber);
            }

            totalRounds++;

            System.out.println("Current Statistics:");
            System.out.println("Total Rounds Played: " + totalRounds);
            System.out.println("Total Attempts Made: " + totalAttempts);
            System.out.println("Average Attempts per Round: " + (totalAttempts / (double) totalRounds));

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next().toLowerCase();
            playAgain = playAgainResponse.equals("yes");
        }

        System.out.println("Thanks for playing the Extended Number Guessing Game!");
    }
}
