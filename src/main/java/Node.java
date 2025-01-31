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

        // continuously ask for input until the user types "bye"
        while (true) {
            command = scanner.nextLine();

            if (command.equals("bye")) {
                System.out.println("____________________________________________________________");
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("____________________________________________________________");
                break;
            } // If user enters "bye", exit the loop


            // Echo the command entered by the user
            System.out.println("____________________________________________________________");
            System.out.println(command);
            System.out.println("____________________________________________________________");
        }

        // Close the scanner
        scanner.close();
    }
}
