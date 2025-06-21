public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        taskManager.addTask(new Task(1, "Home Page", "in progress"));
        taskManager.addTask(new Task(2, "About Page", "in progress"));
        taskManager.addTask(new Task(3, "Router", "Done"));
        taskManager.addTask(new Task(4, "Setup", "Done"));
        taskManager.addTask(new Task(5, "Packages", "Done"));

        System.out.println();

        taskManager.traverseTask();

        System.out.println();

        taskManager.searchTask(1);

        System.out.println();

        taskManager.deleteTask(5);
        taskManager.traverseTask();
    }    
}
