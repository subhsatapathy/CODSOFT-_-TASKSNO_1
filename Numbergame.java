import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int roundsPlayed = 0;
        int roundsWon = 0;
        boolean playAgain = true;

        System.out.println("=========================================");
        System.out.println("   WELCOME TO THE NUMBER GUESSING GAME!  ");
        System.out.println("=========================================");

        // 6. Loop for multiple rounds
        while (playAgain) {
            roundsPlayed++;

            // 1. Generate a random number within range (1 to 100)
            int minRange = 1;
            int maxRange = 100;
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;

            // 5. Limit the number of attempts (e.g., 7 attempts per round)
            int maxAttempts = 7;
            int attemptsUsed = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("\n--- Round " + roundsPlayed + " ---");
            System.out.println("I have picked a number between " + minRange + " and " + maxRange + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it!");

            // 4. Repeat steps 2 & 3 until correct or attempts run out
            while (attemptsUsed < maxAttempts) {
                attemptsUsed++;

                // 2. Prompt the user to enter their guess
                System.out.print("\nAttempt " + attemptsUsed + "/" + maxAttempts + " - Enter your guess: ");

                // Input validation for integers
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a valid number.");
                    System.out.print("Enter your guess: ");
                    scanner.next();
                }

                int userGuess = scanner.nextInt();

                // 3. Compare user's guess and provide feedback
                if (userGuess == targetNumber) {
                    System.out.println("🎉 Correct! You guessed the number in " + attemptsUsed + " attempt(s)!");
                    hasGuessedCorrectly = true;
                    roundsWon++;
                    break; // Exit the attempt loop on correct guess
                } else if (userGuess < targetNumber) {
                    System.out.println("📈 Too low! Try a higher number.");
                } else {
                    System.out.println("📉 Too high! Try a lower number.");
                }
            }

            // Handles case when user runs out of attempts
            if (!hasGuessedCorrectly) {
                System.out.println("\n❌ Out of attempts! The correct number was: " + targetNumber);
            }

            // Display overall score summary
            System.out.println("\n--- Scoreboard ---");
            System.out.println("Rounds Played: " + roundsPlayed);
            System.out.println("Rounds Won:    " + roundsWon);

            // 6. Ask the user if they want to play again
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String userResponse = scanner.next().trim().toLowerCase();

            if (!userResponse.equals("yes") && !userResponse.equals("y")) {
                playAgain = false;
            }
        }

        System.out.println("\n=========================================");
        System.out.println("  GAME OVER! Thanks for playing.");
        System.out.println("  Final Score: " + roundsWon + " round(s) won out of " + roundsPlayed + ".");
        System.out.println("=========================================");

        scanner.close();
    }
}
