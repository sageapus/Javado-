import java.util.Scanner;


public class main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("\n=== Task Manager ===");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Task-Title: ");
                    String task_t = scanner.nextLine();
                    System.out.print("Task-Description: ");
                    String task_d = scanner.nextLine();
                    Task t = new Task(task_t,task_d,false);
                    manager.addTask(t);
                    break;
                case 2:
                    System.out.println("Tasks: " + manager.listTasks());
                    break;
                case 3:
                    System.out.print("Enter title of task to delete: ");
                    String title = scanner.nextLine();
                    Task task = null;
                    if (!manager.listTasks().isEmpty()) {
                        for (int i = 0; i < manager.listTasks().size(); i++) {
                            if (manager.listTasks().get(i).getTitle().equals(title)) {
                                task = manager.listTasks().get(i);
                            }
                        }
                    }
                    else {
                        System.out.println("Couldn't find the task.");
                    }
                    assert task != null;
                    manager.deleteTask(task);

                    System.out.println("Deleting...");
                    break;
                case 4:
                    manager.exit();
                    System.out.println("Exiting......");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}