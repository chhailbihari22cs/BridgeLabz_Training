class Item {
    String name;
    int id;
    int quantity;
    double price;
    Item next;

    Item(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    Item head = null;

    // 1. Add Item at End
    public void addItem(int id, String name, int qty, double price) {
        Item newNode = new Item(id, name, qty, price);
        if (head == null) {
            head = newNode;
        } else {
            Item temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
    }

    // 2. Remove Item by ID
    public void removeItem(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            return;
        }
        Item curr = head, prev = null;
        while (curr != null && curr.id != id) {
            prev = curr;
            curr = curr.next;
        }
        if (curr != null) prev.next = curr.next;
    }

    // 3. Update Quantity
    public void updateQuantity(int id, int newQty) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQty;
                return;
            }
            temp = temp.next;
        }
    }

    // 4. Calculate Total Inventory Value
    public double calculateTotalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += (temp.price * temp.quantity);
            temp = temp.next;
        }
        return total;
    }

    // 5. Sort by Item Name (Bubble Sort)
    public void sortByName() {
        if (head == null || head.next == null) return;
        boolean swapped;
        do {
            swapped = false;
            Item curr = head;
            while (curr.next != null) {
                if (curr.name.compareToIgnoreCase(curr.next.name) > 0) {
                    // Sirf Data swap kar rahe hain nodes nahi
                    String tempName = curr.name; curr.name = curr.next.name; curr.next.name = tempName;
                    int tempId = curr.id; curr.id = curr.next.id; curr.next.id = tempId;
                    int tempQty = curr.quantity; curr.quantity = curr.next.quantity; curr.next.quantity = tempQty;
                    double tempPrice = curr.price; curr.price = curr.next.price; curr.next.price = tempPrice;
                    swapped = true;
                }
                curr = curr.next;
            }
        } while (swapped);
    }

    // 6. Display Inventory
    public void display() {
        Item temp = head;
        System.out.println("\nID\tName\tQty\tPrice\tValue");
        while (temp != null) {
            System.out.println(temp.id + "\t" + temp.name + "\t" + temp.quantity + "\t" + temp.price + "\t" + (temp.price * temp.quantity));
            temp = temp.next;
        }
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory shop = new Inventory();

        shop.addItem(101, "Laptop", 5, 50000);
        shop.addItem(102, "Mouse", 20, 500);
        shop.addItem(103, "Keyboard", 10, 1200);

        System.out.println("Original Inventory:");
        shop.display();

        System.out.println("\nTotal Inventory Value: " + shop.calculateTotalValue());

        System.out.println("\nSorting by Name...");
        shop.sortByName();
        shop.display();

        System.out.println("\nUpdating Mouse Quantity to 50...");
        shop.updateQuantity(102, 50);
        shop.display();
    }
}
