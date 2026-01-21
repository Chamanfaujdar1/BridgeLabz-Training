import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class JobRole {
    private final String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public abstract List<String> requiredSkills();

    public abstract int minExperienceYears();

    @Override
    public String toString() {
        return roleName;
    }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }

    @Override
    public List<String> requiredSkills() {
        return Arrays.asList("Java", "DSA", "OOP", "SQL", "Git");
    }

    @Override
    public int minExperienceYears() {
        return 1;
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }

    @Override
    public List<String> requiredSkills() {
        return Arrays.asList("Python", "Machine Learning", "Statistics", "SQL");
    }

    @Override
    public int minExperienceYears() {
        return 0;
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }

    @Override
    public List<String> requiredSkills() {
        return Arrays.asList("Communication", "Leadership", "Roadmap", "Agile", "Analytics");
    }

    @Override
    public int minExperienceYears() {
        return 2;
    }
}

class Resume<T extends JobRole> {
    private final String candidateName;
    private final int experienceYears;
    private final List<String> skills;
    private final T jobRole;

    public Resume(String candidateName, int experienceYears, List<String> skills, T jobRole) {
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
        this.skills = skills;
        this.jobRole = jobRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public List<String> getSkills() {
        return skills;
    }

    public T getJobRole() {
        return jobRole;
    }

    @Override
    public String toString() {
        return String.format("Candidate: %s | Role: %s | Exp: %d yrs | Skills: %s",
                candidateName, jobRole.getRoleName(), experienceYears, skills);
    }
}

class ScreeningResult {
    private final String candidateName;
    private final String roleName;
    private final double score;
    private final boolean shortlisted;
    private final String remarks;

    public ScreeningResult(String candidateName, String roleName, double score, boolean shortlisted, String remarks) {
        this.candidateName = candidateName;
        this.roleName = roleName;
        this.score = score;
        this.shortlisted = shortlisted;
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return String.format(" Result -> %s | Role: %s | Score: %.2f | Shortlisted: %s | %s",
                candidateName, roleName, score, shortlisted ? "YES" : "NO", remarks);
    }
}

class AIScreeningEngine {

    public static <T extends JobRole> ScreeningResult screenResume(Resume<T> resume) {

        List<String> required = resume.getJobRole().requiredSkills();
        List<String> candidateSkills = resume.getSkills();

        int matchedSkills = 0;
        for (String skill : required) {
            if (candidateSkills.contains(skill)) {
                matchedSkills++;
            }
        }

        double skillScore = ((double) matchedSkills / required.size()) * 70;

        double expScore;
        if (resume.getExperienceYears() >= resume.getJobRole().minExperienceYears()) {
            expScore = 30;
        } else {
            expScore = 10;
        }

        double finalScore = skillScore + expScore;

        boolean shortlisted = finalScore >= 70;

        String remarks;
        if (shortlisted) {
            remarks = "Strong profile for this role.";
        } else {
            remarks = "Needs improvement in required skills/experience.";
        }

        return new ScreeningResult(
                resume.getCandidateName(),
                resume.getJobRole().getRoleName(),
                finalScore,
                shortlisted,
                remarks
        );
    }

    public static void runScreeningPipeline(List<? extends Resume<? extends JobRole>> resumeList) {
        System.out.println("\n AI Resume Screening Pipeline Started...");

        if (resumeList == null || resumeList.isEmpty()) {
            System.out.println(" No resumes received.");
            return;
        }

        for (Resume<? extends JobRole> resume : resumeList) {
            System.out.println("\n Processing Resume:");
            System.out.println(resume);

            ScreeningResult result = screenResume(resume);
            System.out.println(result);
        }

        System.out.println("\n Screening Pipeline Completed!");
    }
}

public class AIDrivenResumeScreeningSystem {
    public static void main(String[] args) {

        SoftwareEngineer seRole = new SoftwareEngineer();
        DataScientist dsRole = new DataScientist();
        ProductManager pmRole = new ProductManager();

        Resume<SoftwareEngineer> r1 = new Resume<>(
                "Gopal",
                1,
                Arrays.asList("Java", "DSA", "OOP", "SQL", "Git", "React"),
                seRole
        );

        Resume<DataScientist> r2 = new Resume<>(
                "Aman",
                0,
                Arrays.asList("Python", "Statistics", "SQL"),
                dsRole
        );

        Resume<ProductManager> r3 = new Resume<>(
                "Neha",
                1,
                Arrays.asList("Communication", "Agile", "Leadership"),
                pmRole
        );

        List<Resume<? extends JobRole>> pipeline = new ArrayList<>();
        pipeline.add(r1);
        pipeline.add(r2);
        pipeline.add(r3);

        AIScreeningEngine.runScreeningPipeline(pipeline);
    }
}
