/**
 * Represents a Node in the system that manages tasks and interacts with the user.
 * It handles the loading and saving of tasks, as well as processing user commands.
 */
public class Node {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private Parser parser;

    /**
     * Constructs a Node with a specified file path to load and save task data.
     * Initializes the UI, Storage, Parser, and TaskList components.
     *
     * @param filePath the path to the file where task data is stored
     */
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

    /**
     * Runs the main loop of the Node system. It shows a welcome message, reads and processes user input,
     * and continues until the user exits. Commands are processed and executed based on the input.
     */
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

    /**
     * The entry point of the Node application. Creates a new Node instance with a given file path
     * and starts the application.
     *
     * @param args the command-line arguments (not used in this implementation)
     */
    public static void main(String[] args) {
        new Node("data/Node.txt").run();
    }
}
