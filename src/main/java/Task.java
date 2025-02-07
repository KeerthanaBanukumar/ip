public class Task {
    private String description; //holds the description of tasks
    private boolean isDone; //keeps track of whether the task is done or not

    //constructor
    public Task(String description) {
        this.description = description;
        this.isDone = false; // By default, the task is not done.
    }

    //getter method
    public String getDescription() {
        return description; //allows other classes to retrieve the description
    }

    public boolean isDone() {
        return isDone; //allows other classes to retrieve the status of tasks
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void unmark() {
        this.isDone = false;
    }

    public String toString() {
        return (isDone ? "[X]" : "[ ]") + " " + description;
    }
}
