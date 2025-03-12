/*import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public void createFolderIfNotExists() {
        File file = new File(filePath);
        File folder = file.getParentFile();
        if (!folder.exists()) {
            folder.mkdirs();  // Create folder if it doesn't exist
        }
    }

    public List<Task> loadTasks() {
        List<Task> tasks = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            return tasks; // Return empty list if file doesn't exist
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" \\| ");
                Task task;

                switch (parts[0]) {
                case "T":
                    task = new Todo(parts[2]);
                    break;
                case "D":
                    task = new Deadline(parts[2], parts[3]);
                    break;
                case "E":
                    task = new Event(parts[2], parts[3], parts[4]);
                    break;
                default:
                    continue;
                }

                if (parts[1].equals("1")) {
                    task.markAsDone(); // Mark as done if the status is 1
                }
                tasks.add(task);
            }
        } catch (IOException e) {
            System.out.println("OOPS!!! Error loading tasks.");
        }
        return tasks;
    }

    public void saveTasks(List<Task> tasks) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Task task : tasks) {
                bw.write(task.toFileFormat());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("OOPS!!! Error saving tasks.");
        }
    }
}

 */


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles the loading and saving of tasks from/to a file.
 */
public class Storage {
    private String filePath;

    /**
     * Initializes the Storage with a specified file path.
     * Creates the necessary folder structure if it doesn't exist.
     *
     * @param filePath The file path where tasks are stored.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
        createFolderIfNotExists();
    }

    /**
     * Creates the parent folder if it doesn't exist.
     */
    public void createFolderIfNotExists() {
        File file = new File(filePath);
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }
    }

    /**
     * Loads the list of tasks from the file.
     * If the file doesn't exist, returns an empty list.
     *
     * @return A list of tasks loaded from the file.
     * @throws NodeException If an error occurs while loading the tasks.
     */
    public List<Task> load() throws NodeException {
        List<Task> tasks = new ArrayList<>();
        File file = new File(filePath);

        // If the file doesn't exist, return an empty list
        if (!file.exists()) {
            return tasks;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            // Read each line and convert it to a Task object
            while ((line = br.readLine()) != null) {
                tasks.add(Task.fromString(line));
            }
        } catch (IOException e) {
            throw new NodeException("Error loading tasks from file.");
        }

        return tasks;
    }

    /**
     * Saves the list of tasks to the file.
     *
     * @param tasks The list of tasks to be saved.
     * @throws NodeException If an error occurs while saving the tasks.
     */
    public void save(List<Task> tasks) throws NodeException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            // Write each task to the file
            for (Task task : tasks) {
                bw.write(task.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new NodeException("Error saving tasks to file.");
        }
    }
}
