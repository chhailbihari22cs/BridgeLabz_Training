import java.util.ArrayList;
import java.util.List;

// 1. Abstract Base Class for Course Types
abstract class CourseType {
    String evaluationMethod;
    CourseType(String evaluationMethod) { this.evaluationMethod = evaluationMethod; }
    public abstract String getDetails();
}

// 2. Specific Course Implementations
class ExamCourse extends CourseType {
    ExamCourse() { super("Written Examination"); }
    public String getDetails() { return "Focus: Theoretical knowledge and time-bound exams."; }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse() { super("Practical Assignments"); }
    public String getDetails() { return "Focus: Hands-on projects and continuous assessment."; }
}

class ResearchCourse extends CourseType {
    ResearchCourse() { super("Thesis and Publication"); }
    public String getDetails() { return "Focus: Original research and data analysis."; }
}

// 3. Generic Course Class with Bounded Type Parameter
class Course<T extends CourseType> {
    private String courseName;
    private T type;

    public Course(String courseName, T type) {
        this.courseName = courseName;
        this.type = type;
    }

    public String getCourseName() { return courseName; }
    public T getType() { return type; }

    @Override
    public String toString() {
        return "Course: " + courseName + " | Evaluation: " + type.evaluationMethod;
    }
}

// 4. University Management System
public class UniversitySystem {

    // 5. Wildcard Method: Handles any type of course dynamically
    // List<? extends Course<?>> accepts List of Course<ExamCourse>, Course<ResearchCourse>, etc.
    public static void displayCourseCatalog(List<? extends Course<?>> courses) {
        System.out.println("--- Official Course Catalog ---");
        for (Course<?> c : courses) {
            System.out.println(c);
            System.out.println("   " + c.getType().getDetails());
        }
        System.out.println("-------------------------------\n");
    }

    public static void main(String[] args) {
        // Managing different departments
        List<Course<ExamCourse>> engineeringCourses = new ArrayList<>();
        engineeringCourses.add(new Course<>("Mathematics IV", new ExamCourse()));
        engineeringCourses.add(new Course<>("Thermodynamics", new ExamCourse()));

        List<Course<AssignmentCourse>> designCourses = new ArrayList<>();
        designCourses.add(new Course<>("UI/UX Design", new AssignmentCourse()));
        designCourses.add(new Course<>("Graphic Illustration", new AssignmentCourse()));

        List<Course<ResearchCourse>> PhDProgram = new ArrayList<>();
        PhDProgram.add(new Course<>("Quantum Computing", new ResearchCourse()));

        // Displaying using wildcards
        displayCourseCatalog(engineeringCourses);
        displayCourseCatalog(designCourses);
        displayCourseCatalog(PhDProgram);
    }
}