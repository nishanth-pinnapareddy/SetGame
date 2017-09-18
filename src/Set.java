import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by pinnapareddy on 9/17/17.
 */
public class Set {
   private int id;
   private Card c1;
   private Card c2;
   private Card c3;

   public Set(int id, Card c1, Card c2, Card c3) {
      this.id = id;
      this.c1 = c1;
      this.c2 = c2;
      this.c3 = c3;
   }

   public int getId() {
      return this.id;
   }

   public void printSet() {
      System.out.println(this.c1.getCard());
      System.out.println(this.c2.getCard());
      System.out.println(this.c3.getCard());
      System.out.println();
   }

   /**
    * Helper function to verify whether two sets are disjoint or not.
    *
    * @param set
    * @return
    */
   public boolean isDisjoint(Set set) {
      HashSet<Integer> setCardIds = new HashSet<Integer>();

      // Add set 1 cards to hash set
      setCardIds.addAll(getCardIdsInSet(this));

      // Check if at least one set 2 card exists in hashset then return false
      List<Integer> set2CardIds = getCardIdsInSet(set);
      for (Integer id : set2CardIds) {
         if (setCardIds.contains(id)) {
            return false;
         }
         setCardIds.add(id);
      }

      return true;
   }

   /**
    * Helper function to return card id's from a set.
    *
    * @param set
    * @return
    */
   private List<Integer> getCardIdsInSet(Set set) {
      List<Integer> cardIds = new ArrayList<Integer>();
      cardIds.add(set.c1.getId());
      cardIds.add(set.c2.getId());
      cardIds.add(set.c3.getId());

      return cardIds;
   }
}
