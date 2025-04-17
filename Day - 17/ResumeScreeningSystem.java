import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String candidateName;
    private int experienceYears;

    public JobRole(String candidateName, int experienceYears) {
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public abstract boolean isEligible();
    public abstract void displayProfile();
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String name, int years) {
        super(name, years);
    }

    public boolean isEligible() {
        return getExperienceYears() >= 2;
    }

    public void displayProfile() {
        System.out.println("Software Engineer: " + getCandidateName() + ", Experience: " + getExperienceYears() + " years");
    }
}

class DataScientist extends JobRole {
    public DataScientist(String name, int years) {
        super(name, years);
    }

    public boolean isEligible() {
        return getExperienceYears() >= 3;
    }

    public void displayProfile() {
        System.out.println("Data Scientist: " + getCandidateName() + ", Experience: " + getExperienceYears() + " years");
    }
}

class ProductManager extends JobRole {
    public ProductManager(String name, int years) {
        super(name, years);
    }

    public boolean isEligible() {
        return getExperienceYears() >= 4;
    }

    public void displayProfile() {
        System.out.println("Product Manager: " + getCandidateName() + ", Experience: " + getExperienceYears() + " years");
    }
}

class Resume<T extends JobRole> {
    private List<T> resumes = new ArrayList<>();

    public void addResume(T resume) {
        resumes.add(resume);
    }

    public List<T> getResumes() {
        return resumes;
    }
}

class ResumeProcessor {
    public static <T extends JobRole> List<T> filterEligible(List<T> resumes) {
        List<T> eligible = new ArrayList<>();
        for (T resume : resumes) {
            if (resume.isEligible()) {
                eligible.add(resume);
            }
        }
        return eligible;
    }

    public static void displayAll(List<? extends JobRole> resumes) {
        for (JobRole resume : resumes) {
            resume.displayProfile();
        }
    }
}

public class ResumeScreeningSystem {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> softwareResumes = new Resume<>();
        softwareResumes.addResume(new SoftwareEngineer("Alice", 3));
        softwareResumes.addResume(new SoftwareEngineer("Bob", 1));

        Resume<DataScientist> dataResumes = new Resume<>();
        dataResumes.addResume(new DataScientist("Charlie", 4));
        dataResumes.addResume(new DataScientist("Dana", 2));

        Resume<ProductManager> productResumes = new Resume<>();
        productResumes.addResume(new ProductManager("Evan", 5));
        productResumes.addResume(new ProductManager("Fay", 3));

        System.out.println("=== Eligible Software Engineers ===");
        ResumeProcessor.displayAll(ResumeProcessor.filterEligible(softwareResumes.getResumes()));

        System.out.println("\n=== Eligible Data Scientists ===");
        ResumeProcessor.displayAll(ResumeProcessor.filterEligible(dataResumes.getResumes()));

        System.out.println("\n=== Eligible Product Managers ===");
        ResumeProcessor.displayAll(ResumeProcessor.filterEligible(productResumes.getResumes()));
    }
}
