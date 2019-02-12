import java.util.ArrayList;

public class Practice {
    public String getDomain(String email) { return email.substring(email.indexOf('@')); }

    public void print(Card[] cards) {
        for(Card c : cards) {
            System.out.print(c + ", ");
        }
        System.out.println();
    }

    public void print(ArrayList<Card> cards) {
        for(Card c : cards) {
            System.out.print(c + ", ");
        }
        System.out.println();
    }

    public int getLargest(Card[] cards) {
        int max = cards[0].getValue();
        for(Card c : cards) {
            if(c.getValue() > max) max = c.getValue();
        }

        return max;
    }

    public int getLargest(ArrayList<Card> cards) {
        int max = cards.get(0).getValue();
        for(Card c : cards) {
            if(c.getValue() > max) max = c.getValue();
        }

        return max;
    }

    public int getSmallest(Card[] cards) {
        int min = cards[0].getValue();
        for(Card c : cards) {
            if(c.getValue() < min) min = c.getValue();
        }

        return min;
    }

    public int getSmallest(ArrayList<Card> cards) {
        int min = cards.get(0).getValue();
        for(Card c : cards) {
            if(c.getValue() < min) min = c.getValue();
        }

        return min;
    }

    public void scramble(Card[] cards) {
        for(int i = 0; i < cards.length; i++) {
            int index = (int)(cards.length * Math.random());

            Card temp = cards[i];
            cards[i] = cards[index];
            cards[index] = temp;
        }
    }

    public void scramble(ArrayList<Card> cards) {
        for(int i = 0; i < cards.size(); i++) {
            int index = (int)(cards.size()* Math.random());

            Card temp = cards.get(i);
            cards.set(i, cards.get(index));
            cards.set(index, temp);
        }
    }

    public void sort(Card[] cards) {
        for(int i = 0; i < cards.length; i++) {
            for(int j = 0; j < cards.length; j++) {
                if(cards[j].getValue() > cards[i].getValue()) {
                    Card temp = cards[i];
                    cards[i] = cards[j];
                    cards[j] = temp;
                }
            }
        }
    }

    public void sort(ArrayList<Card> cards) {
        for(int i = 0; i < cards.size(); i++) {
            for(int j = 0; j < cards.size(); j++) {
                if(cards.get(j).getValue() > cards.get(i).getValue()) {
                    Card temp = cards.get(i);
                    cards.set(i, cards.get(j));
                    cards.set(j, temp);
                }
            }
        }
    }

    public void searchReplace(int val, Card[] cards) {
        for(int i = 0; i < cards.length; i++) {
            if(cards[i].getValue() == 1) cards[i] = new Card(val);
        }
    }

    public void searchReplace(int val, ArrayList<Card> cards) {
        for(int i = 0; i < cards.size(); i++) {
            if(cards.get(i).getValue() == 1) cards.set(i, new Card(val));
        }
    }

    public void searchDelete(int val, ArrayList<Card> cards) {
        for(int i = 0; i < cards.size(); i++) {
            if(cards.get(i).getValue() == val) cards.remove(i);
        }
    }
}