class CarRental {

    private String customerName;
    private String carModel;
    private int rentalDays;
    private double totalCost;

    // Default constructor
    CarRental() {
        this("Customer", "Basic Model", 1);
    }

    // Parameterized constructor
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.totalCost = calculateCost();
    }

    // Encapsulated logic
    private double calculateCost() {
        double dailyRate = 1000;
        return rentalDays * dailyRate;
    }

    void showRentalDetails() {
        System.out.println(customerName + " | " + carModel + " | Total ₹" + totalCost);
    }
}
