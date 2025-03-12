/**
 * Abstract class representing a task in a task management system.
 * This class contains common fields and methods for all types of tasks, such as a description and completion status.
 */
public abstract class Task {

    /**
     * The description of the task.
     */
    protected String description;

    /**
     * The completion status of the task (true if done, false otherwise).
     */
    protected boolean isDone;

    /**
     * Constructs a new Task with the given description and marks it as not done.
     *
     * @param description A brief description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Gets the description of the task.
     *
     * @return The description of the task.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Marks the task as not done.
     */
    public void markAsNotDone() {
        isDone = false;
    }

    /**
     * Returns the status icon for the task. This is "[X]" if the task is done, and "[ ]" if it is not done.
     *
     * @return The status icon representing the task's completion status.
     */
    public String getStatusIcon() {
        return (isDone ? "[X]" : "[ ]"); // Mark done tasks with an "X"
    }

    /**
     * Converts the task to a string that can be saved to a file.
     * The exact format depends on the subclass.
     *
     * @return A string representation of the task in a format suitable for saving to a file.
     */
    public abstract String toFileString();

    /**
     * Returns a string representation of the task that includes its status and description.
     * For example, "[X] Task description" or "[ ] Task description".
     *
     * @return A string representation of the task.
     */
    @Override
    public String toString() {
        return getStatusIcon() + " " + description;
    }

    /**
     * Creates a Task object from a saved string representation.
     * The string should be in the format: "<taskType> | <isDone> | <description> | <additionalFields>".
     *
     * @param line The string representation of the task.
     * @return The Task object created from the string.
     * @throws NodeException If the string is corrupted or the task type is unknown.
     */
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
