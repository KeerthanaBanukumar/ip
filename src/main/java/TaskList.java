/*import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    // Constructor
    public TaskList() {
        tasks = new ArrayList<>();
    }

    // Modify this method to accept Task objects
    public void addTask(Task task) {
        tasks.add(task);
    }

    public void markTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            tasks.get(taskIndex).markAsDone();
        }
    }

    public void unmarkTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            tasks.get(taskIndex).unmark();
        }
    }

    public void listTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ": " + tasks.get(i));
        }
    }

    public Task getTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            return tasks.get(index);
        }
        return null;
    }

    public int taskCount() {
        return tasks.size();
    }


    public void deleteTask(int index) {
        if (index < 1 || index > tasks.size()) {
            System.out.println("Invalid task number!");
            return;
        }
        Task removedTask = tasks.remove(index - 1);
        System.out.println("Noted. I've removed this task:\n  " + removedTask);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

}*/
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a list of tasks.
 * Provides methods to add, list, mark, unmark, and delete tasks from the list.
 */
public class TaskList {
    private List<Task> tasks;

    /**
     * Constructs a TaskList with an empty task list.
     */
    public TaskList() {
        tasks = new ArrayList<>();
    }

    /**
     * Constructs a TaskList with a given list of tasks.
     *
     * @param tasks The list of tasks to initialize the TaskList with.
     */
    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Adds a task to the task list.
     *
     * @param task The task to be added to the list.
     */
    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Got it. I've added this task:");
        System.out.println(task);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    /**
     * Lists all tasks in the task list.
     * If the list is empty, it prints a message indicating no tasks are present.
     */
    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    /**
     * Marks the task at the specified index as done.
     *
     * @param index The index of the task to mark as done.
     * @throws NodeException If the index is invalid.
     */
    public void markTask(int index) throws NodeException {
        if (index < 0 || index >= tasks.size()) {
            throw new NodeException("Invalid task number.");
        }
        tasks.get(index).markAsDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(tasks.get(index));
    }

    /**
     * Unmarks the task at the specified index as not done.
     *
     * @param index The index of the task to unmark.
     * @throws NodeException If the index is invalid.
     */
    public void unmarkTask(int index) throws NodeException {
        if (index < 0 || index >= tasks.size()) {
            throw new NodeException("Invalid task number.");
        }
        tasks.get(index).markAsNotDone();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(tasks.get(index));
    }

    /**
     * Deletes the task at the specified index from the task list.
     *
     * @param index The index of the task to be deleted.
     * @throws NodeException If the index is invalid.
     */
    public void deleteTask(int index) throws NodeException {
        if (index < 0 || index >= tasks.size()) {
            throw new NodeException("Invalid task number.");
        }
        Task removedTask = tasks.remove(index);
        System.out.println("Noted. I've removed this task:");
        System.out.println(removedTask);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    /**
     * Returns the list of tasks.
     *
     * @return The list of tasks in the TaskList.
     */
    public List<Task> getTasks() {
        return tasks;
    }
}
