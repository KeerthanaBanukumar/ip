import java.util.Scanner;





/*import java.util.Scanner;


public class Node {
    public static void main(String[] args) throws NodeException {

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

        // File path for storing tasks
        String filePath = "./data/Node.txt";
        Storage storage = new Storage(filePath);

        // Ensure the data folder exists
        storage.createFolderIfNotExists();



        // continuously ask for input until the user types "bye"
        while (true) {
            try {
                String command = scanner.nextLine().trim();

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
                String[] parts = command.split(" ");
                if (parts.length < 2) {
                    throw new NodeException("OOPS!!! Please provide a task number to mark.");
                }
                int taskIndex = Integer.parseInt(parts[1]) - 1;
                taskList.markTask(taskIndex); // Mark the task as done
                System.out.println("____________________________________________________________");
                System.out.println("Nice! I've marked this task as done: ");
                System.out.println(taskList.getTask(taskIndex));
                System.out.println("____________________________________________________________");
            }

            else if (command.startsWith("unmark")) {
                String[] parts = command.split(" ");
                if (parts.length < 2) {
                    throw new NodeException("OOPS!!! Please provide a task number to unmark.");
                }

                int taskIndex = Integer.parseInt(command.split(" ")[1]) - 1; // Get task number
                taskList.unmarkTask(taskIndex); // Unmark the task
                System.out.println("____________________________________________________________");
                System.out.println("OK, I've marked this task as not done yet: ");
                System.out.println(taskList.getTask(taskIndex));
                System.out.println("____________________________________________________________");
            }

            else if (command.startsWith("deadline")) {

                String[] parts = command.split("/by");



                if (parts.length == 2) {
                    String description = parts[0].substring(9).trim(); // Get description by removing "deadline " (9 chars)
                    String by = parts[1].trim(); // Get deadline

                    Deadline deadline = new Deadline(description, by);
                    taskList.addTask(deadline);

                    System.out.println("____________________________________________________________");
                    System.out.println("Got it. I've added this task: ");
                    System.out.println(deadline);

                    // Print the number of tasks in the list
                    System.out.println("Now you have " + taskList.taskCount() + " tasks in the list.");

                    System.out.println("____________________________________________________________");
                }
            }

            else if (command.startsWith("event")) {

                String[] parts = command.split("/from");

                if (parts.length < 2) {
                    throw new NodeException("OOPS!!! Event task format: event <description> /from <start> /to <end>");
                }

                String description = parts[0].substring(6).trim();
                if (description.isEmpty()) {
                    throw new NodeException("OOPS!!! The description of an event cannot be empty.");
                }

                if (parts.length == 2) {
                   // String description = parts[0].substring(6).trim();  // Remove "event " (6 chars) to get the description
                    String[] fromToParts = parts[1].split("/to");
                    if (fromToParts.length < 2) {
                        throw new NodeException("OOPS!!! Event must have a start (/from) and end (/to) time.");
                    }

                    if (fromToParts.length == 2) {
                        String from = fromToParts[0].trim();
                        String to = fromToParts[1].trim();

                        Event event = new Event(description, from, to);
                        taskList.addTask(event);  // Add the event to the task list

                        System.out.println("____________________________________________________________");
                        System.out.println("Got it. I've added this task: ");
                        System.out.println(event);

                        // Print the number of tasks in the list
                        System.out.println("Now you have " + taskList.taskCount() + " tasks in the list.");

                        System.out.println("____________________________________________________________");
                    }
                }
            }

            else if (command.startsWith("todo")) {

                String description = command.substring(5).trim();  // Get the description by removing "todo " (5 chars)

                if (description.isEmpty()) {
                    throw new NodeException("OOPS!!! The description of a todo cannot be empty.");
                }

                Todo todo = new Todo(description);  // Create a Todo task
                taskList.addTask(todo);  // Add the Todo task to the task list

                System.out.println("____________________________________________________________");
                System.out.println("Got it. I've added this task: ");
                System.out.println(todo);  // Print the Todo task

                // Print the number of tasks in the list
                System.out.println("Now you have " + taskList.taskCount() + " tasks in the list.");
                System.out.println("____________________________________________________________");
            }

            else if (command.startsWith("delete")) {
                String[] parts = command.split(" ");
                if (parts.length < 2) {
                    throw new NodeException("OOPS!!! Please provide a task number to delete.");
                }
                int taskIndex = Integer.parseInt(parts[1]) - 1;
                taskList.deleteTask(taskIndex);
            }



            else {
                throw new NodeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
            }

            } catch (NodeException e) {
                System.out.println("____________________________________________________________");
                System.out.println(e.getMessage());
                System.out.println("____________________________________________________________");
            } catch (NumberFormatException e) {
                System.out.println("____________________________________________________________");
                System.out.println("OOPS!!! Task number must be a valid integer.");
                System.out.println("____________________________________________________________");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("____________________________________________________________");
                System.out.println("OOPS!!! Task number is out of range.");
                System.out.println("____________________________________________________________");
            }
        }

        scanner.close();
    }
}
*/

public class Node {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private Parser parser;

    public Node(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        parser = new Parser();

        try {
            tasks = new TaskList(storage.load());
        } catch (NodeException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.showWelcomeMessage();
        boolean isRunning = true;

        while (isRunning) {
            try {
                String input = ui.readCommand();
                isRunning = parser.processCommand(input, tasks, ui, storage);
            } catch (NodeException e) {
                ui.showError(e.getMessage());
            }
        }

        ui.showExitMessage();
    }

    public static void main(String[] args) {
        new Node("data/Node.txt").run();
    }
}

