class productDetail {
    public static void main(String[] args) {
        product p = new product("laptop", 1200.00, 5, "P001");

        Object ob = p;
        if (ob instanceof product) {
            product emp = (product) ob;
            emp.showDetail();
        } else {
            System.out.println(" object is not instance of a class");
        }
        product.updateDiscount(15.00);
        p.updatedPrice();

    }

}

class product {
    private static double discount = 0.00;
    private String productName;
    private double price;
    private int quantity;
    private final String productID;

    public product(String productName, double price, int quantity, String productID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.productID = productID;

    }

    public void showDetail() {
        System.out.println("product id is : " + productID + "\nproduct name is : " + productName + "\nprice is : $"
                + price + "\nQuantity is : " + quantity);
    }

    public static void updateDiscount(double updatediscount) {
        discount = updatediscount;
        System.out.println("Discount : " + updatediscount + "%");
    }

    public void updatedPrice() {
        double NewPrice = (discount * price) / 100;
        NewPrice = price - NewPrice;

        System.out.println("price after discount : " + NewPrice);
    }
}