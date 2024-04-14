
import javax.swing.JOptionPane;
import java.util.Random;

public class NumberGuess {

    public static void main(String[] args) {
        // Constants for defining the range and maximum attempts
        final int MIN_RANGE = 1;
        final int MAX_RANGE = 100;
        final int MAX_ATTEMPTS = 5;

        // Initialize random number generator
        Random random = new Random();

        // Initialize variables
        int score = 0;
        int totalScore = 0;
        int rounds = 0;

        // Main game loop
        while (true) {
            int target = random.nextInt(MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE;
            int attemptCount = 0;

            // Inner loop for the current round
            while (attemptCount < MAX_ATTEMPTS) {
                // Prompt user for input
                String input = JOptionPane.showInputDialog(null,
                        "Guess the number between " + MIN_RANGE + " and " + MAX_RANGE +
                                "\nAttempts left: " + (MAX_ATTEMPTS - attemptCount) +
                                "\nYour current score: " + score +
                                "\nTotal score: " + totalScore +
                                "\nTotal rounds played: " + rounds +
                                "\nEnter your guess:");

                // Check if input is null (user clicked cancel)
                if (input == null) {
                    JOptionPane.showMessageDialog(null, "Thanks for playing!");
                    return;
                }

                // Parse user input
                int guess;
                try {
                    guess = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter a valid number.");
                    continue;
                }

                // Check if guess is within range
                if (guess < MIN_RANGE || guess > MAX_RANGE) {
                    JOptionPane.showMessageDialog(null, "Your guess is out of range! Please enter a number between " +
                            MIN_RANGE + " and " + MAX_RANGE + ".");
                    continue;
                }

                // Increment attempt count
                attemptCount++;

                // Check if guess is correct
                if (guess == target) {
                    // Calculate score based on remaining attempts
                    score = (MAX_ATTEMPTS - attemptCount + 1) * 10;
                    totalScore += score;

                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number " + target +
                            " in " + attemptCount + " attempt(s).\nYour score for this round: " + score +
                            "\nTotal score: " + totalScore);
                    break;
                } else if (guess < target) {
                    JOptionPane.showMessageDialog(null, "Your guess is too low!");
                } else {
                    JOptionPane.showMessageDialog(null, "Your guess is too high!");
                }
            }

            // Check if maximum attempts reached
            if (attemptCount == MAX_ATTEMPTS) {
                JOptionPane.showMessageDialog(null,
                        "Oops! You've used all your attempts. The correct number was: " + target);
            }

            // Prompt for another round
            int choice = JOptionPane.showConfirmDialog(null, "Do you want to play another round?", "Play Again?",
                    JOptionPane.YES_NO_OPTION);
            if (choice != JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Thanks for playing!\nYour final score: " + totalScore);
                break;
            }
            rounds++;
        }
    }
}
