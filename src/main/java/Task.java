public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        // Return the description as a plain string, ignoring formatting.
        return description;
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
