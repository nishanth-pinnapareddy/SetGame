package com.siftscience.game;

import java.util.Set;
/**
 * Created by pinnapareddy on 9/16/17.
 */
public class Card {
   private static Integer ID = 1;

   // Mapping string attribute values of card to integer values improves comparision efficiency.
   private static final int COLOR_BLUE_SYMBOL_A_SHADING_LOWERCASE = 1;
   private static final int COLOR_GREEN_SYMBOL_S_SHADING_UPPERCASE = 2;
   private static final int COLOR_YELLOW_SYMBOL_H_SHADING_SPECIAL= 3;

   private int id;
   private int color;
   private int symbol;
   private int shading;
   private int number;
   private String card;

   public Card(int id, int color, int symbol, int shading, int number, String card) {
      this.id = id;
      this.color = color;
      this.symbol = symbol;
      this.shading = shading;
      this.number = number;
      this.card = card;
   }

   public String getCard() {
      return this.card;
   }

   public Integer getId() {
      return this.id;
   }

   public static boolean isSet(Card c1, Card c2, Card c3) {
      // If color not compatible
      if (!(areAllValuesEqual(c1.color, c2.color, c3.color)
         || areAllValuesNotEqual(c1.color, c2.color, c3.color))) {
         return false;
      }

      // If symbol not compatible
      if (!(areAllValuesEqual(c1.symbol, c2.symbol, c3.symbol)
         || areAllValuesNotEqual(c1.symbol, c2.symbol, c3.symbol))) {
         return false;
      }

      // If shading not compatible
      if (!(areAllValuesEqual(c1.shading, c2.shading, c3.shading)
         || areAllValuesNotEqual(c1.shading, c2.shading, c3.shading))) {
         return false;
      }

      // If number not compatible
      if (!(areAllValuesEqual(c1.number, c2.number, c3.number)
         || areAllValuesNotEqual(c1.number, c2.number, c3.number))) {
         return false;
      }

      return true;
   }

   private static boolean areAllValuesEqual(int v1, int v2, int v3) {
      return v1 == v2 && v2 == v3 && v3 == v1;
   }

   private static boolean areAllValuesNotEqual(int v1, int v2, int v3) {
      return v1 != v2 && v2 != v3 && v3 != v1;
   }

   /**
    * Assuming we get valid representation of input string.
    */
   public static Card getCardFromStringRepresentation(String card) {
      String[] values = card.split(" ");
      int number = values[1].length();

      int  color = 0;
      if (values[0].equals("blue")) {
         color = COLOR_BLUE_SYMBOL_A_SHADING_LOWERCASE;
      }
      else if (values[0].equals("green")) {
         color = COLOR_GREEN_SYMBOL_S_SHADING_UPPERCASE;
      }
      else {
         color = COLOR_YELLOW_SYMBOL_H_SHADING_SPECIAL;
      }

      int symbol = 0;
      if (values[1].charAt(0) == 'a' || values[1].charAt(0) == 'A' ||  values[1].charAt(0) == '@') {
         symbol = COLOR_BLUE_SYMBOL_A_SHADING_LOWERCASE;;
      }
      else if (values[1].charAt(0) == 's' || values[1].charAt(0) == 'S' ||  values[1].charAt(0) == '$') {
         symbol = COLOR_GREEN_SYMBOL_S_SHADING_UPPERCASE;
      }
      else {
         symbol = COLOR_YELLOW_SYMBOL_H_SHADING_SPECIAL;
      }

      int shading = 0;
      if ('a' <= values[1].charAt(0) &&  values[1].charAt(0) <= 'z') {
         shading = COLOR_BLUE_SYMBOL_A_SHADING_LOWERCASE;;
      }
      else if ('A' <= values[1].charAt(0) &&  values[1].charAt(0) <= 'Z') {
         shading = COLOR_GREEN_SYMBOL_S_SHADING_UPPERCASE;
      }
      else {
         shading = COLOR_YELLOW_SYMBOL_H_SHADING_SPECIAL;
      }

      return new Card(ID++, color, symbol, shading, number, card);
   }
}
