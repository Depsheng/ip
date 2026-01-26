import java.io.*;
import java.util.*;
import java.nio.file.*;


public class Storage {
    private static final String FILE_PATH = "./data/Lala.txt";

    public Storage() throws IOException {
        doesFileExist();
    }

    private static void doesFileExist() throws IOException {
        Path path = Paths.get(FILE_PATH);
        if (!Files.exists(path)) {
            throw new IOException("File Does Not Exist!");
        }
    }

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

    public void save(ArrayList<Task> tasks) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Task task : tasks) {
                bw.write(task.toFileString());
                bw.newLine();
            }
        }
    }

    public static Task parseTask(String line) throws NoDescriptionException {
        String[] str = line.split("\\s*\\|\\s*");
        if (str.length >= 3 && str.length < 6) {
            String type = str[0];
            boolean bool =  str[1].equals("1");
            String desc = str[2];
//            System.out.println(type);
//            System.out.println(desc);
            switch (type) {
                case "T":
                    return new ToDo(desc, bool);
                case "D":
                    return new Deadline(desc, str[3], bool);
                case "E":
                    return new Event(desc, str[3], str[4], bool);
                default:
                    throw new IllegalArgumentException("Unknown task type" + type);
            }
        }
        return null;
    }

}
