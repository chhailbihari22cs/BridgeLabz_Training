import java.util.ArrayList;
import java.util.List;

// 1. Abstract Base Class
abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + name;
    }
}

// 2. Specific Item Types
class Electronics extends WarehouseItem {
    public Electronics(String name) { super(name); }
}

class Groceries extends WarehouseItem {
    public Groceries(String name) { super(name); }
}

class Furniture extends WarehouseItem {
    public Furniture(String name) { super(name); }
}

// 3. Generic Storage Class with Bounded Type Parameter
// T extends WarehouseItem ensures only valid items can be stored
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}

// 4. Main System Class
public class WarehouseSystem {

    // 5. Wildcard Method
    // List<? extends WarehouseItem> allows this method to accept 
    // Storage<Electronics>, Storage<Groceries>, etc.
    public static void displayInventory(List<? extends WarehouseItem> items) {
        if (items.isEmpty()) {
            System.out.println("Storage is empty.");
        } else {
            for (WarehouseItem item : items) {
                System.out.println(" - " + item);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Smart Warehouse Management System ---\n");

        // Electronics Storage
        Storage<Electronics> techStorage = new Storage<>();
        techStorage.addItem(new Electronics("OLED TV"));
        techStorage.addItem(new Electronics("Gaming Laptop"));

        // Groceries Storage
        Storage<Groceries> foodStorage = new Storage<>();
        foodStorage.addItem(new Groceries("Organic Flour"));
        foodStorage.addItem(new Groceries("Dairy Milk"));

        // Furniture Storage
        Storage<Furniture> homeStorage = new Storage<>();
        homeStorage.addItem(new Furniture("Ergonomic Chair"));

        // Displaying all using the Wildcard method
        System.out.println("Displaying Electronics:");
        displayInventory(techStorage.getItems());

        System.out.println("\nDisplaying Groceries:");
        displayInventory(foodStorage.getItems());

        System.out.println("\nDisplaying Furniture:");
        displayInventory(homeStorage.getItems());
    }
}