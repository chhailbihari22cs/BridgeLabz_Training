package StudentResultGrouping;

import java.util.*;
import java.util.stream.*;

public class MainApp {

	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
	            new Student("Amit", "A"),
	            new Student("Neha", "B"),
	            new Student("Karan", "A"),
	            new Student("Riya", "C"));
		
		Map<String,List<String>> groups = students.stream().collect(Collectors.groupingBy(s -> s.grade,
				Collectors.mapping(s -> s.name, Collectors.toList())));
		System.out.println(groups);

	}

}
