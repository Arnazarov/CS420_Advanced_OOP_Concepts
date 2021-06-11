import java.util.ArrayList;

public class Task {
    Person[] patients = new Person[5];
    public static void main(String[] args) {
        Task t = new Task();
        t.run();
    }

    public void run(){
        Person bart = new ChildPatient();
        Diagnosable lisa = new ChildPatient();
        ChildPatient maggie = new ChildPatient();
        AdultPatient homer = new AdultPatient();
        Employable marge = new AdultPatient();

        // Set the temperature of each child.
        ((ChildPatient) bart).setTemperature(101.2);
        maggie.setTemperature(100.1);
        lisa.setTemperature(100.6);

        // set the jobs
        homer.addJob("Nuclear Engineer");
        homer.addJob("Major");
        homer.addJob("Bar Owner");
        marge.addJob("House Keeper");



        //insert all of the sympsons in the patients array.
        patients[0] = bart;
        patients[1] = (Person) lisa;
        patients[2] = maggie;
        patients[3] = homer;
        patients[4] = (Person) marge;
    }

    public boolean isAdult(Person p){
        return p instanceof Employable;
    }
}