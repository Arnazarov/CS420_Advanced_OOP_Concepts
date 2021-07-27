import java.time.LocalDate;
import java.time.Period;

public class Person {

    private String name;
    private LocalDate birthDate;

    private class Position {
        protected String name;
        protected double salary;

        public Position(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return(name+":"+salary);
        }
    }

    private Position position;


    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = LocalDate.parse(birthDate);
    }

    public int getAge() {
        return (Period.between(this.birthDate, LocalDate.now())).getYears();
    }

    public void setPosition(String title, double salary) {
        position = new Position(title, salary);
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return("Name:"+this.name+ " Age:"+getAge()+" Position:"
                +position);
    }
}

