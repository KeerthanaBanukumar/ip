import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a deadline task that has a specific time to be completed by.
 */
public class Deadline extends Task {
    protected LocalDateTime by;

    /**
     * Constructs a Deadline task with the specified description and time.
     *
     * @param description The description of the task.
     * @param by The deadline time as a string in the format "d/M/yyyy HHmm".
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = parseDateTime(by);
    }

    /**
     * Parses a string representing the date and time into a LocalDateTime object.
     * The expected format is "d/M/yyyy HHmm".
     *
     * @param dateTime The date and time string to parse.
     * @return The corresponding LocalDateTime object, or null if parsing fails.
     */
    private LocalDateTime parseDateTime(String dateTime) {
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
        try {
            return LocalDateTime.parse(dateTime, inputFormat);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format! Use d/M/yyyy HHmm (e.g., 2/12/2019 1800).");
            return null;
        }
    }

    /**
     * Returns a string representation of the Deadline task in the format:
     * "[D][Status] Description (by: Date)".
     * The date will be formatted as "MMM dd yyyy, h:mm a" (e.g., Dec 02 2019, 6:00 PM).
     *
     * @return A string representation of the deadline task.
     */
    @Override
    public String toString() {
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("MMM dd yyyy, h:mm a");
        return "[D]" + super.toString() + " (by: " + (by != null ? by.format(outputFormat) : "Invalid Date") + ")";
    }

    /**
     * Returns a string representation of the Deadline task for file storage in the format:
     * "D | isDone | Description | DateTime".
     * The date and time are formatted as "d/M/yyyy HHmm".
     *
     * @return A string representation of the deadline task for file storage.
     */
    @Override
    public String toFileString() {
        DateTimeFormatter fileFormat = DateTimeFormatter.ofPattern("d/M/yyyy HHmm");
        return "D | " + (isDone ? "1" : "0") + " | " + description + " | " + (by != null ? by.format(fileFormat) : "Invalid Date");
    }
}
