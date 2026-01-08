

// Node class
class Student {
    int rollNo;
    String name;
    int age;
    String grade;
    Student next; 

    Student(int rollNo, String name, int age, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

// Linked List Logic class
class StudentManagement {
    Student head = null;

    // 1. Add Student (End mein)
    public void addStudent(int r, String n, int a, String g) {
        Student newNode = new Student(r, n, a, g);
        if (head == null) {
            head = newNode;
        } else {
            Student temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Record added: " + n);
    }

    // 2. Display All Records
    public void display() {
        if (head == null) {
            System.out.println("List khali hai.");
            return;
        }
        Student temp = head;
        System.out.println("\n--- Student List ---");
        while (temp != null) {
            System.out.println("Roll: " + temp.rollNo + " | Name: " + temp.name + 
                               " | Age: " + temp.age + " | Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    // 3. Search by Roll Number
    public void search(int r) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == r) {
                System.out.println("Student Mila: " + temp.name + " (Grade: " + temp.grade + ")");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Roll No " + r + " nahi mila.");
    }

    // 4. Update Grade
    public void updateGrade(int r, String newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNo == r) {
                temp.grade = newGrade;
                System.out.println("Grade update ho gaya " + temp.name + " ke liye.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Roll No nahi mila, update fail.");
    }

    // 5. Delete by Roll Number
    public void deleteStudent(int r) {
        if (head == null) return;

        if (head.rollNo == r) {
            head = head.next;
            System.out.println("Record delete ho gaya.");
            return;
        }

        Student curr = head;
        Student prev = null;
        while (curr != null && curr.rollNo != r) {
            prev = curr;
            curr = curr.next;
        }

        if (curr != null) {
            prev.next = curr.next;
            System.out.println("Record delete ho gaya.");
        } else {
            System.out.println("Roll No nahi mila.");
        }
    }
}

// Ye main class hai jiska naam file name se match hona chahiye
public class StudentManagementSystem {
    public static void main(String[] args) {
        StudentManagement system = new StudentManagement();

        // Testing the operations
        system.addStudent(1, "Rahul", 20, "B");
        system.addStudent(2, "Anjali", 21, "A");
        system.addStudent(3, "Vikas", 22, "C");

        system.display();

        System.out.println("\n--- Updating Grade ---");
        system.updateGrade(1, "A+");

        System.out.println("\n--- Searching Student ---");
        system.search(2);

        System.out.println("\n--- Deleting Student ---");
        system.deleteStudent(3);

        system.display();
    }
}