class MobilePhone {
    private String brand, model;
    private double price;

    MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    void display() {
        System.out.println("Brand of mobile: " + brand);
        System.out.println("Model of mobile: " + model);
        System.out.println("Price of mobile: " + price);
        System.out.println("------------------------------");
    }

    public static void main(String[] args) {
        new MobilePhone("VIVO", "VIVO V29", 15999).display();
        new MobilePhone("ONE PLUS", "Nord 4", 39999).display();
        new MobilePhone("APPLE", "iPhone Pro 16", 79999).display();
    }
}
