public class employeeDetail {
    public static void main(String[] args) {
        Employee e = new Employee("jatin", 42069, "CEO of Company");
        Employee e2 = new Employee("Anita", 102, "QA Engineer");
        Employee.displayTotalEmployees();
        Object ob = e;
        Object obj = e2;

        if (ob instanceof Employee) {
            Employee emp = (Employee) ob;
            emp.EmployeeDetail();
        } else {
            System.out.println("it is not instance of class book");
        }
        if (obj instanceof Employee) {
            Employee emp = (Employee) obj;
            emp.EmployeeDetail();
        } else {
            System.out.println("it is not instance of class employee");
        }

    }
}

class Employee {
    static String CompanyName = "Ramesh Limited company";
    static int totalEmployee = 0;
    private String name;
    private final int id;
    private String designation;

    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployee++;
    }

    public static void displayTotalEmployees() {
        System.out.println("Total number of employee in the company is : " + totalEmployee);

    }

    public void EmployeeDetail() {
        System.out.println("Name of the compony is : ----------- " + CompanyName + " ----------");

        System.out.println("Name of the employee is : " + name + "\nID of the employee is : " + id
                + "\nDesignation of the employee is : " + designation);
    }
}
