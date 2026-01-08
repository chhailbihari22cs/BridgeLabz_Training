class Process {
    int id;
    int burstTime;    // Total time needed
    int remainingTime; // Remaining execution time
    int arrivalTime = 0;
    int completionTime, waitingTime, turnAroundTime;
    Process next;

    Process(int id, int burstTime) {
        this.id = id;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.next = null;
    }
}

class Scheduler {
    Process head = null;
    Process tail = null;
    int size = 0;

    // 1. Add Process at End
    public void addProcess(int id, int burstTime) {
        Process newNode = new Process(id, burstTime);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        size++;
    }

    // 2. Simulate Round Robin
    public void simulate(int quantum) {
        if (head == null) return;

        int currentTime = 0;
        Process curr = head;
        Process prev = tail;
        
        System.out.println("\n--- Starting Round Robin Execution ---");
        
        while (size > 0) {
            if (curr.remainingTime > 0) {
                int executeTime = Math.min(curr.remainingTime, quantum);
                System.out.println("Time " + currentTime + ": Executing P" + curr.id + " for " + executeTime + "ms");
                
                curr.remainingTime -= executeTime;
                currentTime += executeTime;

                // Agar process khatam ho gayi
                if (curr.remainingTime == 0) {
                    System.out.println("Time " + currentTime + ": P" + curr.id + " Finished.");
                    curr.completionTime = currentTime;
                    curr.turnAroundTime = curr.completionTime - curr.arrivalTime;
                    curr.waitingTime = curr.turnAroundTime - curr.burstTime;
                    
                    // Node remove karna circular list se
                    if (size == 1) {
                        head = tail = null;
                        size = 0;
                        break;
                    } else {
                        prev.next = curr.next;
                        if (curr == head) head = curr.next;
                        if (curr == tail) tail = prev;
                        curr = curr.next;
                        size--;
                        continue; // skip prev update
                    }
                }
            }
            prev = curr;
            curr = curr.next;
        }
    }
}

public class RoundRobinScheduler {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        
        // Adding processes (ID, Burst Time)
        scheduler.addProcess(1, 10);
        scheduler.addProcess(2, 5);
        scheduler.addProcess(3, 8);

        int timeQuantum = 3;
        scheduler.simulate(timeQuantum);
    }
}
