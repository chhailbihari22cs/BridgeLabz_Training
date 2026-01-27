import java.util.*;

class Employee{
	String name;
	String department;
	public Employee(String name,String department) {
		this.name = name;
		this.department = department;
	}
	
	@Override
    public String toString() {
        return name;
    }
}

public class GroupObjects {

	public static void main(String[] args) {
		
		List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR")
        );
		
		Map<String, List<Employee>> map = new HashMap<>();

        for (Employee emp : employees) {
            if (!map.containsKey(emp.department)) {
                map.put(emp.department, new ArrayList<>());
            }
            map.get(emp.department).add(emp);
        }

        for (Map.Entry<String, List<Employee>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

	

}
