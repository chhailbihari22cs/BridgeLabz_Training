class CartItem {
    private String itemName;
    private double price;
    private int quantity;

    CartItem(String name, double price, int qty) {
        this.itemName = name;
        this.price = price;
        this.quantity = qty;
    }

    void addItem(int qty) {
        quantity += qty;
        System.out.println("Added " + qty + " of " + itemName);
    }

    void removeItem(int qty) {
        quantity -= qty;
        System.out.println("Removed " + qty + " of " + itemName);
    }

    void totalCost() {
        System.out.println("Total cost: $" + (price * quantity));
    }

    public static void main(String[] args) {
        CartItem c = new CartItem("Laptop", 999.99, 1);
        c.addItem(2);
        c.removeItem(1);
        c.totalCost();
    }
}
