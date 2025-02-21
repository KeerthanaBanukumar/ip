import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Added: " + task);
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Your task list is empty!");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ": " + tasks.get(i));
        }
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

    public void markTask(int index) {
        if (index >= 1 && index <= tasks.size()) {
            tasks.get(index - 1).markAsDone();
        } else {
            System.out.println("Invalid task number!");
        }
    }

    public void unmarkTask(int index) {
        if (index >= 1 && index <= tasks.size()) {
            tasks.get(index - 1).unmark();
        } else {
            System.out.println("Invalid task number!");
        }
    }

    public int getTaskCount() {
        return tasks.size();
    }

    public Task getTask(int index) {
        if (index >= 1 && index <= tasks.size()) {
            return tasks.get(index - 1);
        }
        return null;
    }

    public ArrayList<Task> getAllTasks() {
        return tasks;
    }
}
