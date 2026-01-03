
public class EmployeeDetail
{
	public static void main(String[] args) {
		Employee e1=new Manager("jatin",69,160000.00,5);
		Employee e2=new Developer("Goldy",69420,120000.00,"Java and python");
		Employee e3=new Intern("johnny",69214,130000.00,6);
		System.out.println("===========================Manager class detail=========================");
		e1.displayDetail();
		System.out.println("===========================Developer class detail===========================");
		e2.displayDetail();
		System.out.println("===========================Intern class detail===========================");
		e3.displayDetail();
		
	}
}
class Employee
{
    String name;
    int id;
    double salary;
    public Employee(String name,int id,double salary)
    {
        this.name=name;
        this.id=id;
        this.salary=salary;
    }
    public void displayDetail()
    {
        System.out.println("Employee name : "+name+"\nid : "+id+"\nsalary is : "+salary);
    }
}
class Manager extends Employee
{
    int teamSize;
    public Manager(String name,int id,double salary,int teamsize)
    {
        super(name,id,salary);
        this.teamSize=teamSize;
    }
    public void displayDetail()
    {
        System.out.println("Employee name : "+name+"\nid : "+id+"\nsalary is : "+salary+"\nteamSize is : "+teamSize);;
    }
}
class Developer extends Employee
{
    String programmingLanguage;
    public Developer(String name,int id,double salary,String programmingLanguage)
    {
        super(name,id,salary);
        this.programmingLanguage=programmingLanguage;
    }
    public void displayDetail()
    {
        System.out.println("Employee name : "+name+"\nid : "+id+"\nsalary is : "+salary+"\nprogramming language is : "+programmingLanguage);
    }
}
class Intern extends Employee
{
    int duration;
    public Intern(String name,int id,double salary,int duration)
    {
        super(name,id,salary);
        this.duration=duration;
    }
    public void displayDetail()
    {
        System.out.println("Employee name : "+name+"\nid : "+id+"\nsalary is : "+salary+"\nduration of time is : "+duration+"months");
    }
}