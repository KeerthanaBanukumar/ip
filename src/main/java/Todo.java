public class Todo extends Task {

    public Todo(String description) {
        super(description);  // Call the constructor of the parent class (Task)
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
