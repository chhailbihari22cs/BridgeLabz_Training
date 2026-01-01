class Vehicle {

    // static variable (common for all vehicles)
    static double registrationFee = 0.0;

    // final variable
    final String registrationNumber;

    // instance variables
    String ownerName;
    String vehicleType;

    // constructor using this keyword
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    // static method to update registration fee
    public static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    // method to display registration details
    public void displayDetails(Object obj) {

        // instanceof check
        if (obj instanceof Vehicle) {
            Vehicle v = (Vehicle) obj;

            System.out.println("Owner Name: " + v.ownerName);
            System.out.println("Vehicle Type: " + v.vehicleType);
            System.out.println("Registration Number: " + v.registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        } else {
            System.out.println("Invalid vehicle object");
        }
    }
}

class VehicleRegistrationSystem {
    public static void main(String[] args) {

        // update registration fee for all vehicles
        Vehicle.updateRegistrationFee(150.0);

        // create vehicle objects
        Vehicle v1 = new Vehicle("Honest raj", "Sedan", "ABC123");
        Vehicle v2 = new Vehicle("Price danish", "SUV", "XYZ789");

        // display registration details
        v1.displayDetails(v1);
        System.out.println();
        v2.displayDetails(v2);
    }
}
