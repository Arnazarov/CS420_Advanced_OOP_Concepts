import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Deck implements Iterable<Card>{
    private List<Card> deck;
    private String[] suits = {"Hearts","Clubs","Diamonds","Spades"};
    public Deck() {
        deck = new ArrayList<Card>();

        String[] values = {"Ace", "Jack", "Queen", "King"};
        Integer[] numValues = {2,3,4,5,6,7,8,9,10};

        for (String suit: suits) {
            for (String value : values)
                deck.add(new Card(value, suit));
            for (Integer numValue : numValues)
                deck.add(new Card(numValue, suit));
        }
    }

    public Card dealCard(){
        int ran = (int) Math.round (Math.random() * (deck.size() - 1));
        return deck.remove(ran);
    }

    public int size(){
        return deck.size();
    }
    @Override
    public Iterator<Card> iterator() {
       return new DeckIterator<Card>(this);
    }
}
