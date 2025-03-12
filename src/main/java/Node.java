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

