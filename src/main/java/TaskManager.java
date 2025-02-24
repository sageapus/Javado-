import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;



public class TaskManager {
//    private List<String> tasks; // hint: will change in iteration 3
    private List<Task> tasks; // hint: will change in iteration 3

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

    public void addTask(Task task) {
         tasks.add(task);

    }

    public List<Task> listTasks() {
        return tasks;

//        throw new UnsupportedOperationException("Implement this method!");
    }

    public void deleteTask(Task task) throws IllegalArgumentException{
//        leave for iteration 4

        if (!tasks.isEmpty()) {
            tasks.remove(task);
        } else {
            throw new IllegalArgumentException("Task not found!");
        }

    }

    public void exit() {
        // leave for iteration 2
        try {
            BufferedWriter writer=new BufferedWriter(new FileWriter("tasks.csv"));

            for (Task task : tasks){
                writer.write( task +"\n");}
            writer.close();
        } catch (IOException e) {
           throw new RuntimeException(e);
        }
    }
    public void markTaskAsComplete(Task task){
        if (tasks.contains(task)){
            task.setComplete(true);
        }
    }
    public void processMenuChoice(int menuChoice){
        throw new IllegalArgumentException("Invalid menu option!");
    }
}


