package gameproject;

/**
 * Joseph Escober
 * Java Project - Deliverable 3 - Card Game
 * SYST17796 - Group 6
 */

public class UNOCard {

   CardFaceValue cardFaceValue;
   Color color;


   public UNOCard (CardFaceValue cardFaceValue, Color color) {
      this.cardFaceValue = cardFaceValue;
      this.color = color;

   }

   public boolean startPlay (UNOCard oneCard) {

      return this.cardFaceValue == oneCard.cardFaceValue || this.color == oneCard.color;
   }

   public boolean startPlayColor (UNOCard oneCard) {

      return this.color == oneCard.color;
   }

   public String toString () {
      if (cardFaceValue.equals(CardFaceValue.WILD) || cardFaceValue.equals(CardFaceValue.WILD_FOUR)) {
           return cardFaceValue.name();
      }
      else {
            return cardFaceValue.name() + "-" + color.name();
      }
   }

}
