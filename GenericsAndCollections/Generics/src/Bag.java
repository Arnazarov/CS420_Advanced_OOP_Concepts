import java.util.ArrayList;

public class Bag<T> {
    ArrayList<T> objects;
    public Bag(){
        objects = new ArrayList<>();
    }
    public void add(T element) throws BagException{
        if (element != null)
            objects.add(element);
        else
            throw new BagException("Cannot add null to a Bag");
    }

    public T drawOne() {
        int random = (int)(Math.random()* objects.size());
        return objects.get(random);
    }

    public ArrayList<T> drawMany(int howMany){
        ArrayList<T> result = new ArrayList<>(howMany);
        while (howMany != 0) {
            result.add(drawOne());
            howMany--;
        }
        return result;
    }

    public void add(T element,double prob) throws BagException{
        if (prob < 1 && prob > 0) {
            // This is a way to add elements in a given proportion.
            int tot = (int) Math.round(objects.size() * prob);
            for (int i = 0; i < tot; i++) {
                System.out.println("Adding " + i);
                objects.add(element);
            }
        }
        else
            throw new BagException("Probability should be between 0 and 1");


    }
}
