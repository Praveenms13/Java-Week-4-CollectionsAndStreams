import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    private String title;
    private String instructor;

    public CourseType(String title, String instructor) {
        this.title = title;
        this.instructor = instructor;
    }

    public String getTitle() {
        return title;
    }

    public String getInstructor() {
        return instructor;
    }

    public abstract void evaluate();
}

class ExamCourse extends CourseType {
    public ExamCourse(String title, String instructor) {
        super(title, instructor);
    }

    public void evaluate() {
        System.out.println("Course: " + getTitle() + ", Instructor: " + getInstructor() + " - Evaluation: Written Exam");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String title, String instructor) {
        super(title, instructor);
    }

    public void evaluate() {
        System.out.println("Course: " + getTitle() + ", Instructor: " + getInstructor() + " - Evaluation: Assignments");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String title, String instructor) {
        super(title, instructor);
    }

    public void evaluate() {
        System.out.println("Course: " + getTitle() + ", Instructor: " + getInstructor() + " - Evaluation: Research Paper");
    }
}

class Course<T extends CourseType> {
    private List<T> courseList = new ArrayList<>();

    public void addCourse(T course) {
        courseList.add(course);
    }

    public List<T> getCourses() {
        return courseList;
    }
}

class CourseUtils {
    public static void displayEvaluations(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            course.evaluate();
        }
    }
}

public class UniversityCourseSystem {
    public static void main(String[] args) {
        Course<ExamCourse> examCourses = new Course<>();
        examCourses.addCourse(new ExamCourse("Mathematics 101", "Dr. Smith"));
        examCourses.addCourse(new ExamCourse("Physics 201", "Dr. Jones"));

        Course<AssignmentCourse> assignmentCourses = new Course<>();
        assignmentCourses.addCourse(new AssignmentCourse("Creative Writing", "Prof. Allen"));
        assignmentCourses.addCourse(new AssignmentCourse("Marketing", "Prof. Lee"));

        Course<ResearchCourse> researchCourses = new Course<>();
        researchCourses.addCourse(new ResearchCourse("Thesis Seminar", "Dr. Chen"));
        researchCourses.addCourse(new ResearchCourse("Independent Study", "Dr. Patel"));

        System.out.println("=== Exam-Based Courses ===");
        CourseUtils.displayEvaluations(examCourses.getCourses());

        System.out.println("\n=== Assignment-Based Courses ===");
        CourseUtils.displayEvaluations(assignmentCourses.getCourses());

        System.out.println("\n=== Research-Based Courses ===");
        CourseUtils.displayEvaluations(researchCourses.getCourses());
    }
}
