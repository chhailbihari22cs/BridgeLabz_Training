class Task {
    int id;
    String name;
    int priority;
    String dueDate;
    Task next;

    Task(int id, String name, int priority, String dueDate) {
        this.id = id;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class CircularTaskList {
    Task head = null;
    Task tail = null;
    Task current = null; // Current task track karne ke liye

    // 1. Add Task at End
    public void addTask(int id, String name, int p, String d) {
        Task newNode = new Task(id, name, p, d);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head; // Circle complete
            current = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // Last node points to first
        }
        System.out.println("Task Added: " + name);
    }

    // 2. Display All Tasks
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks scheduled.");
            return;
        }
        Task temp = head;
        System.out.println("\n--- Scheduled Tasks (Circular) ---");
        do {
            System.out.println("ID: " + temp.id + " | Task: " + temp.name + " | Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head); // Jab tak wapas head pe na aa jaye
    }

    // 3. Move to Next Task (Scheduler functionality)
    public void nextTask() {
        if (current != null) {
            System.out.println("\nExecuting Task: " + current.name);
            current = current.next; // Move to next in circle
            System.out.println("Next up: " + current.name);
        }
    }

    // 4. Remove Task by ID
    public void removeTask(int id) {
        if (head == null) return;

        Task curr = head, prev = tail;
        do {
            if (curr.id == id) {
                if (curr == head && curr == tail) { // Sirf ek hi node ho
                    head = tail = current = null;
                } else {
                    prev.next = curr.next;
                    if (curr == head) head = head.next;
                    if (curr == tail) tail = prev;
                    if (curr == current) current = curr.next;
                }
                System.out.println("Task ID " + id + " removed.");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
        System.out.println("Task not found.");
    }

    // 5. Search by Priority
    public void searchByPriority(int p) {
        if (head == null) return;
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == p) {
                System.out.println("Found: " + temp.name + " (Due: " + temp.dueDate + ")");
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No task with priority " + p);
    }
}

public class TaskSchedulerSystem {
    public static void main(String[] args) {
        CircularTaskList scheduler = new CircularTaskList();

        scheduler.addTask(101, "Backup Database", 1, "2026-01-10");
        scheduler.addTask(102, "Security Patch", 2, "2026-01-12");
        scheduler.addTask(103, "UI Design Review", 3, "2026-01-15");

        scheduler.displayTasks();

        // Moving through the circle
        scheduler.nextTask();
        scheduler.nextTask();
        scheduler.nextTask();
        scheduler.nextTask(); // Yeh wapas first task pe chala jayega

        System.out.println("\n--- Searching Priority 2 ---");
        scheduler.searchByPriority(2);

        System.out.println("\n--- Deleting Task 102 ---");
        scheduler.removeTask(102);
        scheduler.displayTasks();
    }
}
