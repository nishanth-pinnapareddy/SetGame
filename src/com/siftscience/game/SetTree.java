package com.siftscience.game;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by pinnapareddy on 9/17/17.
 */
public class SetTree {
   private Set root;
   private ArrayList<SetTree> children;

   public SetTree(Set root) {
      this.root = root;
      this.children = new ArrayList<SetTree>();
   }

   public void insert(Set set) {
      if (!root.isDisjoint(set))
         return;

      boolean isSetAdded = false;
      for (SetTree child : this.children) {
         child.insert(set);
         if (child.root.getId() == set.getId())
            isSetAdded = true;
      }

      if (!isSetAdded)
         children.add(new SetTree(set));

   }

   public List<Set> getLargestDisjointSets() {
      List<Set> disjointSets = new LinkedList<Set>();
      disjointSets.add(this.root);

      for (SetTree child : children) {
         List<Set> tmpDisjointSets = child.getLargestDisjointSets();
         if (tmpDisjointSets.size() >= disjointSets.size()) {
            tmpDisjointSets.add(0, this.root);
            disjointSets = tmpDisjointSets;
         }
      }

      return disjointSets;
   }
}
