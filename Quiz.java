import java.util.Scanner;  // Import the Scanner class for user input

 /**
 * A simple and fun interactive quiz program that asks the user a series of questions,
 * validates the input, calculates the score, and displays the results.
 */

public class Quiz {
    public static void main(String[] args) {
        System.out.println("Welcome to today's quiz!");

        // Array of questions
        String[] questions = {
    "Which is the correct Fibonacci Sequence?",
    "In which continent is the country Kenya located?",
    "Which medium does not transmit sound?",
    "Which one of these is a major contributor to global warming?",
    "Which is the largest organ on the human body?"
    };

    // Array of four options for each question
    String[] options = {
    "A. 0, 0, 1, 2, 3, 5, 8, 13, 21\nB. 0, 1, 1, 2, 3, 5, 8, 13, 21\nC. 0, 2, 3, 5, 8, 13, 21, 34, 55\nD. 1, 2, 3, 5, 8, 13, 34, 55, 89",
    "A. Asia\nB. Europe\nC. Australia\nD. Africa",
    "A. Vacuum\nB. Air\nC. Liquid\nD. Solid",
    "A. Sports\nB. Cows in the field\nC. Burning fossil fuels\nD. None of the above",
    "A. Skin\nB. Liver\nC. Heart\nD. Brain"
    };

    // Array of answers to each question
    char[] answers = {'B','D','A','C','A'};

    int score = 0;
    int totalQuestions = questions.length;

    Scanner scanner = new Scanner(System.in);

    // Loop through each question
    for (int i = 0; i < totalQuestions; i++) {
        System.out.println("Question " + (i + 1) + "/5:");
        System.out.println(questions[i]);
        System.out.println(options[i]);

        // Variable to store the answer    
        String answer;
        boolean validAnswer = false;
            
    // Using a switch-case statement to validate the answer
    do {
        System.out.print("Please type either A, B, C, or D as your answer: ");
        answer = scanner.nextLine().trim().toUpperCase();
        switch (answer) {
            case "A":
            case "B":
            case "C":
            case "D":
                validAnswer = true;
                break;
            default:
                System.out.println("Invalid input.");
                break;
        }
    } while (!validAnswer);

    // Convert the answer to a char and check if it matches the answer to the question
    char userAnswer = answer.charAt(0);
    if (userAnswer == answers[i]) {
        score++;
    }
}

    // Calculate the percentage score
    double percentage = (double) score / totalQuestions * 100;

    // Display the final score and percentage
    System.out.println("\nFinal score is: " + score + "/" + totalQuestions);
    System.out.println("Percentage: " + percentage + "%");

    // Close the Scanner object
    scanner.close();
 }
}