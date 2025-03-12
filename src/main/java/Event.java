/*public class Event extends Task {
    protected String from;
    protected String to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String toFileFormat() {
        return "E | " + getStatusIcon() + " | " + description + " | " + from + " | " + to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }

    // Static method to create an Event task from a file string
    public static Event fromFileString(String line) {
        String[] parts = line.split(" \\| ");
        if (parts.length < 5) {
            throw new IllegalArgumentException("Invalid Event format in file");
        }
        Event event = new Event(parts[2], parts[3], parts[4]);
        return event;
    }
}
*/
/**
 * Represents an Event task, which occurs from a start time to an end time.
 */
public class Event extends Task {
    protected String from;
    protected String to;

    /**
     * Initializes an Event with a description, start time, and end time.
     *
     * @param description The description of the event.
     * @param from The start time of the event.
     * @param to The end time of the event.
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Converts the Event to a string that can be saved to a file.
     * The string format is: "E | <done status> | <description> | <from> | <to>"
     *
     * @return A string representing the Event in a file-readable format.
     */
    @Override
    public String toFileString() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + from + " | " + to;
    }

    /**
     * Returns a string representation of the Event.
     * The string format is: "[E] <description> (from: <from> to: <to>)"
     *
     * @return A string representing the Event in a user-friendly format.
     */
    @Override
    public String toString() {
        return "[E] " + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}
