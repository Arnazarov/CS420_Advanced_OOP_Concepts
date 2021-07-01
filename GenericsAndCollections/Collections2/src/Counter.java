import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class Counter<E> {
    private HashMap<E, Integer> counts;

    public Counter(E[] things){
        counts = new HashMap<>();

        for(E thing: things) {
            if (!counts.containsKey(thing))
                counts.put(thing, 1);
            else
                counts.put(thing, counts.get(thing) + 1);
        }
    }

    public Integer getCount(E element){
        return counts.get(element);
    }

    public int getSize(){
        return this.counts.size();
    }

    public E mostFrequent(){
        int mostFreq = Collections.max(counts.values());
        for (E key : counts.keySet()) {
            if (counts.get(key) == mostFreq)
                return key;
        }
        return null;
    }
}
