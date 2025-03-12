
/**
 * Represents an event task in the task management system.
 * Extends the {@link Task} class and adds the ability to store event start and end times.
 */
public class Event extends Task {

    /**
     * The start time of the event.
     */
    protected String from;

    /**
     * The end time of the event.
     */
    protected String to;

    /**
     * Constructs an Event with the given description, start time, and end time.
     *
     * @param description A brief description of the event.
     * @param from The start time of the event.
     * @param to The end time of the event.
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Converts the Event object to a string that can be saved to a file.
     * The string format is: "E | <isDone> | <description> | <from> | <to>".
     *
     * @return A string representation of the Event in a format suitable for saving to a file.
     */
    @Override
    public String toFileString() {
        return "E | " + (isDone ? "1" : "0") + " | " + description + " | " + from + " | " + to;
    }

    /**
     * Returns a string representation of the Event object, which includes its status, description,
     * and the event's start and end times.
     * The string format is: "[E] <description> (from: <from> to: <to>)".
     *
     * @return A string representation of the Event object.
     */
    @Override
    public String toString() {
        return "[E] " + super.toString() + " (from: " + from + " to: " + to + ")";
    }
}
