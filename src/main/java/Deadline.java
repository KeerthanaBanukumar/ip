/*public class Deadline extends Task {
    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toFileFormat() {
        return "D | " + getStatusIcon() + " | " + description + " | " + by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

    // Static method to create a Deadline task from a file string
    public static Deadline fromFileString(String line) {
        String[] parts = line.split(" \\| ");
        if (parts.length < 4) {
            throw new IllegalArgumentException("Invalid Deadline format in file");
        }
        Deadline deadline = new Deadline(parts[2], parts[3]);
        return deadline;
    }
}
*/
/**
 * Represents a task with a deadline.
 * A <code>Deadline</code> object contains a description of the task and a due date/time.
 */
public class Deadline extends Task {
    /** The due date/time of the task, stored as a string. */
    protected String by;

    /**
     * Constructs a <code>Deadline</code> task with a specified description and deadline.
     *
     * @param description Description of the task.
     * @param by Deadline of the task in string format.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns a formatted string representation of the task for saving to a file.
     *
     * @return A string representation of the task in a savable format.
     */
    @Override
    public String toFileString() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + by;
    }

    /**
     * Returns a string representation of the deadline task,
     * including its status and due date.
     *
     * @return A formatted string representing the task.
     */
    @Override
    public String toString() {
        return "[D] " + super.toString() + " (by: " + by + ")";
    }
}

