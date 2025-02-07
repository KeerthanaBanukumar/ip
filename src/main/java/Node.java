import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in); // scanner object created
        TaskList taskList = new TaskList(); // TaskList object to manage tasks

        // continuously ask for input until the user types "bye"
        while (true) {
            String command = scanner.nextLine();

            if (command.equals("bye")) {
                System.out.println("____________________________________________________________");
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println("____________________________________________________________");
                break;
            } // If user enters "bye", exit the loop

            if (command.equals("list")) {
                System.out.println("____________________________________________________________");
                taskList.listTasks();
                System.out.println("____________________________________________________________");
            }

            else if (command.startsWith("mark")) {
                int taskIndex = Integer.parseInt(command.split(" ")[1]) - 1; // Get task number
                taskList.markTask(taskIndex); // Mark the task as done
                System.out.println("____________________________________________________________");
                System.out.println("Nice! I've marked this task as done: ");
                System.out.println(taskList.getTask(taskIndex));
                System.out.println("____________________________________________________________");
            }

            else if (command.startsWith("unmark")) {
                int taskIndex = Integer.parseInt(command.split(" ")[1]) - 1; // Get task number
                taskList.unmarkTask(taskIndex); // Unmark the task
                System.out.println("____________________________________________________________");
                System.out.println("OK, I've marked this task as not done yet: ");
                System.out.println(taskList.getTask(taskIndex));
                System.out.println("____________________________________________________________");
            }

            else {
                taskList.addTask(command); // Add the task to the list
                System.out.println("____________________________________________________________");
                System.out.println("added: " + command);
                System.out.println("____________________________________________________________");
            }
        }

        // Close the scanner
        scanner.close();
    }
}
