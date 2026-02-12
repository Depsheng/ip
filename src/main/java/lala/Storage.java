package lala;

import lala.exception.NoDescriptionException;
import lala.task.Deadline;
import lala.task.Event;
import lala.task.Task;
import lala.task.ToDo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Handles persistence of tasks to/from disk.
 */
public class Storage {
    private static final String FILE_PATH = "./data/Lala.txt";

    public Storage() throws IOException {
        doesFileExist();
    }

    // checks if the file exists
    private static void doesFileExist() throws IOException {
        Path path = Paths.get(FILE_PATH);
        if (!Files.exists(path)) {
            throw new IOException("File Does Not Exist!");
        }
    }

    // loads the tasks from input file and returns a List of Task objects
    public static ArrayList<Task> load() throws IOException, NoDescriptionException {
        ArrayList<Task> tasks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                Task t = parseTask(line);
                if (t != null) tasks.add(t);
            }
        }
        return tasks;
    }

    // saves all tasks into input file currently in TaskList
    public static void saveAll(ArrayList<Task> tasks) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Task t : tasks) {
                bw.write(t.toFileString());
                bw.newLine();
            }
        }
    }

    public static Task parseTask(String line) throws NoDescriptionException {
        String[] str = line.split("\\s*\\|\\s*");
        if (str.length > 3 && str.length < 7) {
            String type = str[0];
            boolean bool =  str[1].equals("1");
            String tag = str[2];
            String desc = str[3];
            switch (type) {
                case "T":
                    return new ToDo(desc, bool, tag);
                case "D":
                    return new Deadline(desc, str[4], bool, tag);
                case "E":
                    return new Event(desc, str[4], str[5], bool, tag);
                default:
                    throw new IllegalArgumentException("Unknown task type" + type);
            }
        }
        return null;
    }

}
