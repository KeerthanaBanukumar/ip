public class Parser {
    public boolean processCommand(String command, TaskList tasks, Ui ui, Storage storage) throws NodeException {
        String[] parts = command.split(" ", 2);
        String keyword = parts[0];

        switch (keyword) {
        case "bye":
            return false;

        case "list":
            tasks.listTasks();
            break;

        case "mark":
            tasks.markTask(Integer.parseInt(parts[1]) - 1);
            break;

        case "unmark":
            tasks.unmarkTask(Integer.parseInt(parts[1]) - 1);
            break;

        case "todo":
            tasks.addTask(new Todo(parts[1]));
            break;

        case "deadline":
            String[] deadlineParts = parts[1].split(" /by ");
            if (deadlineParts.length < 2) throw new NodeException("Invalid deadline format.");
            tasks.addTask(new Deadline(deadlineParts[0], deadlineParts[1]));
            break;

        case "event":
            String[] eventParts = parts[1].split(" /from | /to ");
            if (eventParts.length < 3) throw new NodeException("Invalid event format.");
            tasks.addTask(new Event(eventParts[0], eventParts[1], eventParts[2]));
            break;

        case "delete":
            tasks.deleteTask(Integer.parseInt(parts[1]) - 1);
            break;

        default:
            throw new NodeException("OOPS!!! I'm sorry, but I don't know what that means :-(");
        }

        try {
            storage.save(tasks.getTasks());
        } catch (NodeException e) {
            ui.showError("Failed to save tasks.");
        }

        return true;
    }
}
