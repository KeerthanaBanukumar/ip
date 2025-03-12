import java.util.Scanner;

/**
 * Represents the user interface of the task management application.
 * Handles displaying messages and reading user input.
 */
public class Ui {
    private Scanner scanner;

    /**
     * Initializes the user interface by setting up the scanner for input.
     */
    public Ui() {
        scanner = new Scanner(System.in);
    }

    /**
     * Displays a welcome message with the application logo and a prompt.
     */
    public void showWelcomeMessage() {
        String logo = " _   _           _     \n"
                + "| \\ | | ___   __| | ___ \n"
                + "|  \\| |/ _ \\ / _` |/ _ \\\n"
                + "| |\\  | (_) | (_| |  __/\n"
                + "|_| \\_|\\___/ \\__,_|\\___|\n";

        System.out.println("Hello from\n" + logo);
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm Node");
        System.out.println("What can I do for you?");
        System.out.println("____________________________________________________________");
    }

    /**
     * Reads and returns the user input from the console.
     *
     * @return The input command entered by the user.
     */
    public String readCommand() {
        return scanner.nextLine().trim();
    }

    /**
     * Displays an error message to the user.
     *
     * @param message The error message to display.
     */
    public void showError(String message) {
        System.out.println("____________________________________________________________");
        System.out.println(message);
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays an exit message when the application is closed.
     */
    public void showExitMessage() {
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }

    /**
     * Displays an error message when tasks cannot be loaded.
     */
    public void showLoadingError() {
        System.out.println("Error loading tasks. Starting with an empty task list.");
    }
}
