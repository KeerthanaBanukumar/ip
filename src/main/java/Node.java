import java.util.Scanner; //read inputs

//level 0
public class Node {
    public static void main(String[] args) {
        // Display the logo and introduction
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

        Scanner scanner = new Scanner(System.in);//scanner object created
        String command;//will hold the command entered by the user
        String[] tasks = new String[100];
        int taskcounter = 0;


        // continuously ask for input until the user types "bye"
        while (true) {
            command = scanner.nextLine();

            if (command.equals("bye")) {
                System.out.println("____________________________________________________________");
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("____________________________________________________________");
                break;
            } // If user enters "bye", exit the loop

            if (command.equals("list")) {
                System.out.println("____________________________________________________________");

                for (int i = 0; i < taskcounter; i++) {
                    System.out.println((i + 1) + (":") + tasks[i]);
                }
                System.out.println("____________________________________________________________");

            } else {
                tasks[taskcounter] = command; // Add the task to the array
                taskcounter++; // Increment task count
                System.out.println("____________________________________________________________");
                System.out.println("added: " + command);
                System.out.println("____________________________________________________________");
            }
        }

        // Close the scanner
        scanner.close();
    }
}
