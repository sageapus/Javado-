import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TaskManager {
//    private static final Logger logger = Logger.getLogger(TaskManager.class.getName());

    private List<String> tasks; // hint: will change in iteration 3
//    private File file;
    public TaskManager() {
        // Initialize tasks list
        tasks = new ArrayList<>();
        try {
            File taskFile = new File("tasks.csv");
            if (taskFile.createNewFile()) {
                System.out.println(taskFile.getName() + " has been created");
            } else {
                System.out.println("File already exists");
            }
        }
        catch (IOException e) {
            System.out.println("ERROR!");
        }

}

    public void addTask(String task) {
         tasks.add(task);

    }

    public List<String> listTasks() {
        return tasks;

//        throw new UnsupportedOperationException("Implement this method!");
    }

    public void deleteTask(String task){
//        leave for iteration 4
    }

    public void exit() {
        // leave for iteration 2
        try {
            BufferedWriter writer=new BufferedWriter(new FileWriter("tasks.csv"));

            for (String task : tasks){
                writer.write( task +"\n");}
            writer.close();
        } catch (IOException e) {
           throw new RuntimeException(e);
        }
    }
}

