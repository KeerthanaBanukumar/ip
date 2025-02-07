public class TaskList {
    private Task[] tasks;
    private int taskCounter;

    //constructor
    public TaskList() {
        tasks = new Task[100]; // Initialize with a fixed array size
        taskCounter = 0;
    }

    // Modify this method to accept Task objects
    public void addTask(Task task) {
        tasks[taskCounter] = task;
        taskCounter++;
    }

    public void markTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < taskCounter) {
            tasks[taskIndex].markAsDone();
        }
    }

    public void unmarkTask(int taskIndex) {
        if (taskIndex >= 0 && taskIndex < taskCounter) {
            tasks[taskIndex].unmark();
        }
    }

    public void listTasks() {
        for (int i = 0; i < taskCounter; i++) {
            System.out.println((i + 1) + ": " + tasks[i]);
        }
    }

    public Task getTask(int index) {
        if (index >= 0 && index < taskCounter) {
            return tasks[index];
        }
        return null;
    }

    public int taskCount(){
       return taskCounter;
    }
}
