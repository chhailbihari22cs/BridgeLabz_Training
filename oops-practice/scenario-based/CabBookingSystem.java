import java.util.*;

// Custom Exception for No Available Drivers
class DriverUnavailableException extends Exception {
    public DriverUnavailableException(String message) {
        super(message);
    }
}

// Interface for Fare Calculation (Polymorphism)
interface FarePolicy {
    double computeFare(double distance);
}

// Normal Fare Calculation Strategy
class StandardFare implements FarePolicy {
    @Override
    public double computeFare(double distance) {
        return distance * 10;
    }
}

// Peak Fare Calculation Strategy
class SurgeFare implements FarePolicy {
    @Override
    public double computeFare(double distance) {
        return distance * 20;
    }
}

// User Class
class Passenger {
    String name;

    Passenger(String name) {
        this.name = name;
    }
}

// Driver Class
class CabDriver {
    String name;
    boolean available = true;

    CabDriver(String name) {
        this.name = name;
    }
}

// Ride Class
class CabRide {
    Passenger passenger;
    CabDriver driver;
    double fare;

    void bookRide(Passenger p, List<CabDriver> driverList, double distance, FarePolicy farePolicy)
            throws DriverUnavailableException {
        this.passenger = p;

        // Find the first available driver
        this.driver = driverList.stream()
                .filter(d -> d.available)
                .findFirst()
                .orElseThrow(() -> new DriverUnavailableException("Sorry " + p.name + ", no drivers are available!"));

        this.driver.available = false; // Mark driver as unavailable
        this.fare = farePolicy.computeFare(distance);

        System.out.println("Ride Confirmed! Driver: " + driver.name + " | Fare: " + fare);
    }
}

// Main Class
public class CabBookingSystem {
    public static void main(String[] args) {
        Passenger passenger1 = new Passenger("Rahul");
        List<CabDriver> driverList = Arrays.asList(new CabDriver("Amit"), new CabDriver("Sunil"));

        CabRide ride = new CabRide();
        try {
            // Using Surge Fare Policy
            ride.bookRide(passenger1, driverList, 10.5, new SurgeFare());
        } catch (DriverUnavailableException e) {
            System.out.println(e.getMessage());
        }
    }
}