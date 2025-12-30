class Item {
    private String itemCode, itemName;
    private double price;

    Item(String itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    void display() {
        System.out.println("itemCode : " + itemCode);
        System.out.println("itemPrice : " + price);
        System.out.println("itemName : " + itemName);
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {
        new Item("01AA", "Water bottle", 500).display();
        new Item("01BB", "Rice", 700).display();
        new Item("02AA", "blackboard", 400).display();
    }
}
