import java.util.function.Predicate;

public class TemperatureAlert {

    public static void main(String[] args) {

        double threshold = 37.5;
        Predicate<Double> isHighTemp = temp -> temp > threshold;
        double currentTemp = 38.2;

        if (isHighTemp.test(currentTemp)) {
            System.out.println("Alert! Temperature crossed the threshold.");
        } else {
            System.out.println("Temperature is normal.");
        }

    }

}