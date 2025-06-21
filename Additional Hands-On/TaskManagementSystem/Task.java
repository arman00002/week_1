package TaskManagementSystem;

public class Task {
    private int taskId;
    private String taskName;
    private String status;
    private Task next;

    private static Task head = null;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    public static void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
        System.out.println("Task added: " + name);
    }

    public static void searchTask(int id) {
        Task current = head;
        while (current != null) {
            if (current.taskId == id) {
                System.out.println("Task Found:");
                current.display();
                return;
            }
            current = current.next;
        }
        System.out.println("Task ID " + id + " not found.");
    }

    public static void deleteTask(int id) {
        if (head == null) {
            System.out.println("No tasks to delete.");
            return;
        }

        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task deleted: " + id);
            return;
        }

        Task current = head;
        while (current.next != null) {
            if (current.next.taskId == id) {
                current.next = current.next.next;
                System.out.println("Task deleted: " + id);
                return;
            }
            current = current.next;
        }

        System.out.println("Task ID " + id + " not found.");
    }

    public static void showAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        Task current = head;
        System.out.println("Task List:");
        while (current != null) {
            current.display();
            current = current.next;
        }
    }

    private void display() {
        System.out.println("ID: " + taskId + ", Name: " + taskName + ", Status: " + status);
    }

    public static void main(String[] args) {
        addTask(1, "Design UI", "Pending");
        addTask(2, "Write Backend", "In Progress");
        addTask(3, "Testing", "Pending");

        System.out.println();
        showAllTasks();

        System.out.println("\nSearching for Task ID 2:");
        searchTask(2);

        System.out.println("\nDeleting Task ID 1:");
        deleteTask(1);

        System.out.println();
        showAllTasks();
    }
}

