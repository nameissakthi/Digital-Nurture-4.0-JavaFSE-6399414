class Node{
    Task task;
    Node next;

    Node(Task task){
        this.task = task;
        this.next = null;
    }
}

public class TaskManager {
    private Node head;

    public TaskManager(){
        head = null;
    }

    public void addTask(Task task){
        Node newNode = new Node(task);
        if(head==null){
            head = newNode;
            System.out.println("Task Added Successfully");
            return;
        }

        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;

        System.out.println("Task Added Successfully");
    }

    public void traverseTask(){
        if(head == null){
            System.out.println("No Task");
            return;
        }
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    public void searchTask(int taskId){
        if(head == null){
            System.out.println("No Task");
            return;
        }
        Node temp = head;
        while(temp!=null){
            if(temp.task.getTaskId() == taskId){
                System.out.println(temp.task);
                return;
            }
        }
        System.out.println("No Task Found");
    }

    public void deleteTask(int taskId) {
        if (head == null) {
            return; // List is empty
        }

        if (head.task.getTaskId() == taskId) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.task.getTaskId()!= taskId) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
}
