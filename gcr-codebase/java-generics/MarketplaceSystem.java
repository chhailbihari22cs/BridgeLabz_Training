

// 1. Categories for Bounded Types
interface Category { String getCategoryName(); }

class BookCategory implements Category {
    public String getCategoryName() { return "Books"; }
}

class GadgetCategory implements Category {
    public String getCategoryName() { return "Gadgets"; }
}

// 2. Generic Product Class with Bounded Type Parameter <T extends Category>
class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public T getCategory() { return category; }

    @Override
    public String toString() {
        return String.format("Product: %-15s | Category: %-10s | Price: $%.2f", 
                name, category.getCategoryName(), price);
    }
}

// 3. Marketplace System
public class MarketplaceSystem {

    // 4. Generic Method to apply discounts
    // It accepts any product that extends the Product class
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double currentPrice = product.getPrice();
        double discountAmount = currentPrice * (percentage / 100);
        product.setPrice(currentPrice - discountAmount);
        System.out.println("Applied " + percentage + "% discount to: " + product.getName());
    }

    public static void main(String[] args) {
        System.out.println("--- Dynamic Online Marketplace ---\n");

        // Creating products with specific categories
        Product<BookCategory> javaBook = new Product<>("Java Programming", 500.0, new BookCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone", 15000.0, new GadgetCategory());

        // Initial Catalog
        System.out.println("Before Discount:");
        System.out.println(javaBook);
        System.out.println(phone);
        System.out.println();

        // Using Generic Method to apply discounts
        applyDiscount(javaBook, 10); // 10% off on book
        applyDiscount(phone, 15);   // 15% off on gadget

        // Final Catalog
        System.out.println("\nAfter Discount (Updated Catalog):");
        System.out.println(javaBook);
        System.out.println(phone);
    }
}