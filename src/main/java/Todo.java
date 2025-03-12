/*public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    @Override
    public String toFileFormat() {
        return "T | " + getStatusIcon() + " | " + description;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    // Static method to create a Todo task from a file string
    public static Todo fromFileString(String line) {
        String[] parts = line.split(" \\| ");
        if (parts.length < 3) {
            throw new IllegalArgumentException("Invalid Todo format in file");
        }
        Todo todo = new Todo(parts[2]);
        return todo;
    }
}
*/

public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    @Override
    public String toFileString() {
        return "T | " + (isDone ? "1" : "0") + " | " + description;
    }

    @Override
    public String toString() {
        return "[T] " + super.toString();
    }
}


