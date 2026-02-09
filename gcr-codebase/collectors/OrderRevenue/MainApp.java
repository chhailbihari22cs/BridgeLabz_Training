package OrderRevenue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MainApp {

	public static void main(String[] args) {
		List<Order> orders = Arrays.asList(
	            new Order("Amit", 2500),
	            new Order("Neha", 1800),
	            new Order("Amit", 1200),
	            new Order("Neha", 2200));

	    Map<String, Double> revenueByCustomer = orders.stream().collect(Collectors.groupingBy(o -> o.customer,
	                          Collectors.summingDouble(o -> o.amount)));

	    System.out.println(revenueByCustomer);

	}

}
