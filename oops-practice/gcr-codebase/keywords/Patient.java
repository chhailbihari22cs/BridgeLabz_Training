class Patient {

    // static variables
    static String hospitalName = "City Hospital";
    static int totalPatients = 0;

    // final variable (unique & immutable)
    final String patientID;

    // instance variables
    String name;
    int age;
    String ailment;

    // constructor using this keyword
    public Patient(String patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    // static method to display total patients
    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    // method to display patient details
    public void displayDetails(Object obj) {

        // instanceof check
        if (obj instanceof Patient) {
            Patient p = (Patient) obj;

            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + p.patientID);
            System.out.println("Name: " + p.name);
            System.out.println("Age: " + p.age);
            System.out.println("Ailment: " + p.ailment);
        } else {
            System.out.println("Invalid patient object");
        }
    }
}

class HospitalManagementSystem {
    public static void main(String[] args) {

        // create patient objects
        Patient p1 = new Patient("P001", "Lathika", 30, "Flu");
        Patient p2 = new Patient("P002", "Lidiya", 45, "Fracture");

        // display total patients
        Patient.getTotalPatients();

        // display patient details
        p1.displayDetails(p1);
        System.out.println();
        p2.displayDetails(p2);
    }
}
