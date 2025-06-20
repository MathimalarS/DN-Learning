class TaskNode {
    Task task;
    TaskNode next;

    public TaskNode(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class TaskList {
    private TaskNode head;

    public TaskList() {
        this.head = null;
    }

    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);
        if (head == null) {
            head = newNode;
            System.out.println("Added first task: " + task);
            return;
        }

        TaskNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        System.out.println("Added task: " + task);
    }

    public Task searchTask(int taskId) {
        TaskNode current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }
        System.out.println("Current Tasks:");
        TaskNode current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty. Nothing to delete.");
            return;
        }

        // If head is the task to delete
        if (head.task.getTaskId() == taskId) {
            System.out.println("Deleted task: " + head.task);
            head = head.next;
            return;
        }

        TaskNode current = head;
        TaskNode previous = null;

        while (current != null && current.task.getTaskId() != taskId) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Task with ID " + taskId + " not found.");
            return;
        }

        previous.next = current.next;
        System.out.println("Deleted task: " + current.task);
    }

    public static void main(String[] args) {
        TaskList taskList = new TaskList();

        taskList.addTask(new Task(1, "Design UI", "Pending"));
        taskList.addTask(new Task(2, "Develop Backend", "Pending"));
        taskList.addTask(new Task(3, "Write Tests", "Pending"));

        taskList.traverseTasks();

        int searchId = 2;
        System.out.println("\nSearching for task with ID " + searchId + "...");
        Task foundTask = taskList.searchTask(searchId);
        System.out.println(foundTask != null ? "Found: " + foundTask : "Task not found.");

        int deleteId = 1;
        System.out.println("\nDeleting task with ID " + deleteId + "...");
        taskList.deleteTask(deleteId);

        taskList.traverseTasks();
    }
}
