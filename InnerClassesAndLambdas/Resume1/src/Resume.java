import java.util.ArrayList;
import java.util.List;

public class Resume {

    public class Education {
        String school;
        String major;

        public Education(String school, String major) {
            this.school = school;
            this.major = major;
        }

        public String getSchool() {
            return this.school;
        }
        public void setSchool(String school) {
            this.school = school;
        }
        public String getMajor() {
            return this.major;
        }
        public void setMajor(String major){
            this.major = major;
        }
        @Override
        public String toString() {
            return(this.major+" at "+this.school);
        }
    }

    public static class Experience {
        String jobTitle;
        int fromYear;
        int toYear;

        public Experience(String job, int start, int end) {
            this.jobTitle = job;
            this.fromYear = start;
            this.toYear = end;
        }
        @Override
        public String toString() {
            return(this.fromYear+"-"+this.toYear+": "+this.jobTitle);
        }
    }

    private Person person;
    private List<Education> education;
    private List<Experience> experience;

    public Resume(Person p){
        this.person = p;
        education = new ArrayList<>();
        experience = new ArrayList<>();
    }

    public void addExperience(Experience ex){
        if (experience != null)
            experience.add(ex);
    }

    public void addEducation(Education ed){
        if (education != null)
            education.add(ed);
    }

    @Override
    public String toString(){
        return(this.person+"\nExperience\n"+this.experience+"\nEducation\n"+this.education);
    }
}
