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

public class Deadline extends Task {
    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toFileString() {
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + by;
    }

    @Override
    public String toString() {
        return "[D] " + super.toString() + " (by: " + by + ")";
    }
}
