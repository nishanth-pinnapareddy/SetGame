import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameRunner {

    private ArrayList<Card> readCardsIntoDeck() {
       ArrayList<Card> deck = new ArrayList<Card>();
       Scanner scanner = null;

       try {
          // Populate deck with cards
          scanner = new Scanner(System.in);
          int numberOfCards = Integer.valueOf(scanner.nextLine());
          while (numberOfCards-- > 0) {
             String line = scanner.nextLine();
             deck.add(Card.getCardFromStringRepresentation(line));
          }

       } catch (Exception e) {
          System.out.println("Oppss !!!! Please provide valid input.");
       } finally {
          scanner.close();
       }

       return deck;
    }

    private ArrayList<Set> getSetsInDeck(ArrayList<Card> deck) {
       ArrayList<Set> setsInDeck = new ArrayList<Set>();
       int setPointer = 0;

       for (int l = 0; l < deck.size()-2; l++) {
          Card card_l = deck.get(l);
          for (int m = l+1; m < deck.size()-1; m++) {
             Card card_m = deck.get(m);
             for (int n = m+1; n < deck.size(); n++) {
                Card card_n = deck.get(n);
                if (Card.isSet(card_l, card_m, card_n)) {
                   setsInDeck.add(new Set(setPointer++, card_l, card_m, card_n));
                }
             }
          }
       }

       return setsInDeck;
    }

    private List<Set> getLargestDisjointSets(ArrayList<Set> sets) {
       List<Set> largestDisjointSets = null;

       for (int i=0; i<sets.size(); i++){
          SetTree root = new SetTree(sets.get(i));
          for (int j=i+1; j<sets.size(); j++) {
             root.insert(sets.get(j));
          }

          List<Set> currentDisjointSets = root.getLargestDisjointSets();
          if (largestDisjointSets == null || currentDisjointSets.size() > largestDisjointSets.size()) {
             largestDisjointSets = currentDisjointSets;
          }
       }

       return largestDisjointSets;
    }

    public static void main(String[] args) {
      GameRunner gameRunner = new GameRunner();

      // Read cards in to deck.
      ArrayList<Card> deck = gameRunner.readCardsIntoDeck();

      // Get all possible set of SET's in deck.
      ArrayList<Set> setsInDeck = gameRunner.getSetsInDeck(deck);
      System.out.println(setsInDeck.size());

      // Get largest disjoint sets from possible SET's in deck.
      List<Set> disjointSets = gameRunner.getLargestDisjointSets(setsInDeck);
      System.out.println(disjointSets.size());
      System.out.println();

      // Print largest disjoint sets
      for (Set set : disjointSets) {
         set.printSet();
      }

      return;
   }
}
