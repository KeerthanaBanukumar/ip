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
/*
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
*/
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    protected LocalDateTime by;

    public Deadline(String description, String by) {
        super(description);
        this.by = parseDateTime(by);
    }

    private LocalDateTime parseDateTime(String dateTime) {
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
        try {
            return LocalDateTime.parse(dateTime, inputFormat);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format! Use d/M/yyyy HHmm (e.g., 2/12/2019 1800).");
            return null;
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("MMM dd yyyy, h:mm a");
        return "[D]" + super.toString() + " (by: " + (by != null ? by.format(outputFormat) : "Invalid Date") + ")";
    }

    @Override
    public String toFileString() {
        DateTimeFormatter fileFormat = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + (by != null ? by.format(fileFormat) : "Invalid Date");
    }
}
