/*public abstract class Task {
    protected String description; // Holds the description of tasks
    private boolean isDone; // Keeps track of whether the task is done or not

    // Constructor
    public Task(String description) {
        this.description = description;
        this.isDone = false; // By default, the task is not done.
    }

    // Getter methods
    public String getDescription() {
        return description; // Allows other classes to retrieve the description
    }

    public boolean isDone() {
        return isDone;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void unmark() {
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "1" : "0"); // "1" for done, "0" for not done
    }

    public abstract String toFileFormat(); // Abstract method for subclass-specific file formatting

    @Override
    public String toString() {
        return (isDone ? "[X]" : "[ ]") + " " + description;
    }

    // Static method to create tasks from file data
    public static Task fromFileString(String line) {
        String[] parts = line.split(" \\| ");
        if (parts.length < 3) {
            throw new IllegalArgumentException("Invalid task format in file");
        }

        Task task = null;
        switch (parts[0]) {
        case "T":
            task = Todo.fromFileString(line); // Delegate to Todo class
            break;
        case "D":
            task = Deadline.fromFileString(line); // Delegate to Deadline class
            break;
        case "E":
            task = Event.fromFileString(line); // Delegate to Event class
            break;
        default:
            throw new IllegalArgumentException("Unknown task type");
        }

        if (parts[1].equals("1")) { // Mark the task as done if the status is "1"
            task.markAsDone();
        }

        return task;
    }
}
*/

public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public void markAsDone() {
        isDone = true;
    }

    public void markAsNotDone() {
        isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]"); // Mark done tasks with an "X"
    }

    public abstract String toFileString(); // Converts task to a savable format

    @Override
    public String toString() {
        return getStatusIcon() + " " + description;
    }

    public static Task fromString(String line) throws NodeException {
        String[] parts = line.split("\\|");
        if (parts.length < 3) {
            throw new NodeException("Corrupted task data.");
        }

        boolean isDone = parts[1].trim().equals("1");
        Task task;

        switch (parts[0]) {
        case "T":
            task = new Todo(parts[2].trim());
            break;
        case "D":
            if (parts.length < 4) throw new NodeException("Invalid deadline format.");
            task = new Deadline(parts[2].trim(), parts[3].trim());
            break;
        case "E":
            if (parts.length < 5) throw new NodeException("Invalid event format.");
            task = new Event(parts[2].trim(), parts[3].trim(), parts[4].trim());
            break;
        default:
            throw new NodeException("Unknown task type.");
        }

        if (isDone) task.markAsDone();
        return task;
    }
}
