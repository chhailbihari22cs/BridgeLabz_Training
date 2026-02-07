import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class StreamForEachExamples {

    public static void main(String[] args) {

        topTrendingMovies();
        doctorAvailability();
        insuranceClaimAnalysis();
        expiringMemberships();
        transformNames();
        stockPriceLogger();
        eventWelcome();
        sensorReadings();
        emailNotifications();
        transactionLogging();
    }

    // 1. Top 5 Trending Movies
    static void topTrendingMovies() {
        List<Movie> movies = List.of(
                new Movie("MovieA", 8.9, 2023),
                new Movie("MovieB", 7.5, 2021),
                new Movie("MovieC", 9.1, 2024),
                new Movie("MovieD", 8.7, 2022),
                new Movie("MovieE", 8.5, 2020),
                new Movie("MovieF", 9.0, 2024));

        movies.stream()
                .filter(m -> m.releaseYear >= 2020)
                .sorted((a, b) -> Double.compare(b.rating, a.rating))
                .limit(5)
                .forEach(System.out::println);
    }

    // 2. Hospital Doctor Availability
    static void doctorAvailability() {
        List<Doctor> doctors = List.of(
                new Doctor("Dr. A", "Cardiology", true),
                new Doctor("Dr. B", "Neurology", false),
                new Doctor("Dr. C", "Orthopedic", true));

        doctors.stream()
                .filter(Doctor::availableOnWeekend)
                .sorted(Comparator.comparing(d -> d.specialty))
                .forEach(System.out::println);
    }

    // 3. Insurance Claim Analysis
    static void insuranceClaimAnalysis() {
        List<Claim> claims = List.of(
                new Claim("Health", 50000),
                new Claim("Vehicle", 20000),
                new Claim("Health", 30000),
                new Claim("Vehicle", 40000));

        Map<String, Double> avgClaims = claims.stream()
                .collect(Collectors.groupingBy(
                        c -> c.type,
                        Collectors.averagingDouble(c -> c.amount)));

        avgClaims.forEach((k, v) -> System.out.println(k + " Average Claim: " + v));
    }

    // 4. Expiring Memberships
    static void expiringMemberships() {
        List<Member> members = List.of(
                new Member("Amit", LocalDate.now().plusDays(10)),
                new Member("Riya", LocalDate.now().plusDays(40)));

        members.stream()
                .filter(m -> m.expiryDate.isBefore(LocalDate.now().plusDays(30)))
                .forEach(System.out::println);
    }

    // 5. Transform Names
    static void transformNames() {
        List<String> customers = List.of("kartik", "amit", "neha");

        customers.stream()
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }

    // forEach Examples

    static void stockPriceLogger() {
        List<Double> prices = List.of(101.5, 98.2, 110.0);
        prices.forEach(p -> System.out.println("Stock Price: " + p));
    }

    static void eventWelcome() {
        List<String> attendees = List.of("Ankit", "Sara");
        attendees.forEach(n -> System.out.println("Welcome to the event, " + n));
    }

    static void sensorReadings() {
        List<Integer> readings = List.of(45, 80, 60);
        int threshold = 50;

        readings.stream()
                .filter(r -> r > threshold)
                .forEach(r -> System.out.println("High Reading: " + r));
    }

    static void emailNotifications() {
        List<String> emails = List.of("a@mail.com", "b@mail.com");
        emails.forEach(e -> System.out.println("Email sent to " + e));
    }

    static void transactionLogging() {
        List<String> ids = List.of("TX101", "TX102");
        ids.forEach(id -> System.out.println(LocalDateTime.now() + " - Transaction: " + id));
    }
}

// Model Classes

class Movie {
    String name;
    double rating;
    int releaseYear;

    Movie(String name, double rating, int releaseYear) {
        this.name = name;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    public String toString() {
        return name + " | " + rating + " | " + releaseYear;
    }
}

class Doctor {
    String name;
    String specialty;
    boolean availableOnWeekend;

    Doctor(String name, String specialty, boolean availableOnWeekend) {
        this.name = name;
        this.specialty = specialty;
        this.availableOnWeekend = availableOnWeekend;
    }

    boolean availableOnWeekend() {
        return availableOnWeekend;
    }

    public String toString() {
        return name + " | " + specialty;
    }
}

class Claim {
    String type;
    double amount;

    Claim(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}

class Member {
    String name;
    LocalDate expiryDate;

    Member(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    public String toString() {
        return name + " | Expiry: " + expiryDate;
    }
}
