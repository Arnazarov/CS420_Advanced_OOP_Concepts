public class Task {
    public static void main(String[] args){
        Person p = new Person("Kim Possible","2000-01-01");
        p.setPosition("Associate", 34000);
        Resume r = new Resume(p);
        Resume.Education education = r.new Education("NEIU","Computer Science");
        r.addEducation(education);
        Resume.Experience experience = new Resume.Experience("Junior Analyst", 2020,2021);
        r.addExperience(experience);
        r.addExperience(new Resume.Experience("Escape Runner", 2019,2020));
        r.addExperience(new Resume.Experience("UI Designer", 2018,2019));
        System.out.println(r); //watch the resume print.

    }
}