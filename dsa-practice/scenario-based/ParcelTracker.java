
// Node class representing a Delivery Stage
class Stage {
    String stageName;
    Stage next;

    Stage(String name) {
        this.stageName = name;
        this.next = null;
    }
}

public class ParcelTracker {
    private Stage head; // Starting point (Packed)

    // 1. Initial Chain Setup (Packed -> Shipped -> In Transit -> Delivered)
    public void setupDefaultChain() {
        head = new Stage("Packed");
        head.next = new Stage("Shipped");
        head.next.next = new Stage("In Transit");
        head.next.next.next = new Stage("Delivered");
    }

    // 2. Custom Checkpoint Add Karna (Intermediate Node)
    // Example: "In Transit" se pehle "Out for Delivery" dalna
    public void addCheckpoint(String afterStage, String newStageName) {
        Stage temp = head;
        while (temp != null && !temp.stageName.equals(afterStage)) {
            temp = temp.next;
        }

        if (temp != null) {
            Stage newNode = new Stage(newStageName);
            newNode.next = temp.next;
            temp.next = newNode;
            System.out.println("Added Checkpoint: " + newStageName + " after " + afterStage);
        } else {
            System.out.println("Stage '" + afterStage + "' not found!");
        }
    }

    // 3. Parcel Track Karna (Forward Traversal)
    public void trackParcel() {
        if (head == null) {
            System.out.println("Parcel info missing! (Lost/Null)");
            return;
        }

        System.out.print(" Tracking: ");
        Stage temp = head;
        while (temp != null) {
            System.out.print(temp.stageName + (temp.next != null ? "--->" : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    // 4. Handle Lost Parcel (Breaking the chain)
    public void markAsLost(String fromStage) {
        Stage temp = head;
        while (temp != null && !temp.stageName.equals(fromStage)) {
            temp = temp.next;
        }
        if (temp != null) {
            temp.next = null; // Aage ka rasta khatam (Lost)
            System.out.println("Parcel tracking stopped at: " + fromStage + " (Marked as Lost)");
        }
    }

    public static void main(String[] args) {
        ParcelTracker tracker = new ParcelTracker();

        tracker.setupDefaultChain();
        tracker.trackParcel();

        // Adding intermediate step
        tracker.addCheckpoint("In Transit", "Out for Delivery");
        tracker.trackParcel();

        // Simulating a lost parcel
        tracker.markAsLost("Shipped");
        tracker.trackParcel();
    }
}