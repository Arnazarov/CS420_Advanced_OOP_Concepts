import java.util.ArrayList;
import java.util.Iterator;

public class Task {
    public static void main(String[] args){
        Deck d = new Deck();
        // Draw some random cards:
        System.out.println(d.dealCard());
        System.out.println(d.dealCard());

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(d.dealCard());
        hand.add(d.dealCard());
        hand.add(d.dealCard());

        System.out.println("Hand is:"+hand);
        System.out.println("Cards add:"+addCards(hand));


        for(Card card : d)
            System.out.print(card + ", ");

    }

    public static int addCards(ArrayList<Card> hand){
        int total = 0;
        for (Card card : hand) {
            if (card.getValue().equals("Ace"))
                total += 1;
            else if (card.getValue().equals("Jack"))
                total += 11;
            else if (card.getValue().equals("Queen"))
                total += 12;
            else if (card.getValue().equals("King"))
                total += 13;
            else
                total += (int) card.getValue();
        }
        return total;
    }
}