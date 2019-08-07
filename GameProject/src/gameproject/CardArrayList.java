package gameproject;

/**
 * Joseph Escober
 * Java Project - Deliverable 3 - Card Game
 * SYST17796
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class CardArrayList {

   private static List<UNOCard> cardDeck = new ArrayList<UNOCard>();
   private static List<UNOCard> dealSpecialCard = new ArrayList<UNOCard>();
   private static List<UNOCard> dealNormalCard = new ArrayList<UNOCard>();


   public List<UNOCard> prepareDeckCard () {

      initDeckCards();
      shuffleUNOCards();
      return cardDeck;
   }


   public List<UNOCard> prepareDeckSpecialCard () {

      initSpecialCards();
      shuffleUNOCards();
      return dealSpecialCard;
   }

   public List<UNOCard> prepareDeckNormalCard () {

      initNormalCards();
      shuffleUNOCards();
      return dealNormalCard;
   }

   public void initDeckCards () {
      for (Color color : Color.values()) {
          for (int i = 0; i < 2; i++) {
             for (CardFaceValue cardFaceValue : CardFaceValue.values()) {
                 if (i == 1 && cardFaceValue.equals(CardFaceValue.ZERO) || i == 1 && (cardFaceValue.equals(CardFaceValue.WILD) || cardFaceValue.equals(CardFaceValue.WILD_FOUR))) {
                    continue;
                 }
               else if (cardFaceValue.equals(CardFaceValue.WILD) || cardFaceValue.equals(CardFaceValue.WILD_FOUR)) {
                     cardDeck.add(new UNOCard(cardFaceValue, null));
               }
               else {
                    cardDeck.add(new UNOCard(cardFaceValue, color));
               }

            }
         }
      }

   }


   public void initSpecialCards () {
      
      for (Color color : Color.values()) {
          for (int i = 0; i < 2; i++) {
              for (CardFaceValue cardFaceValue : CardFaceValue.values()) {
                  if (i == 1 && (cardFaceValue.equals(CardFaceValue.WILD) || cardFaceValue.equals(CardFaceValue.WILD_FOUR))) {
                      continue;
               }
               else if (cardFaceValue.equals(CardFaceValue.WILD) || cardFaceValue.equals(CardFaceValue.WILD_FOUR)) {
                       dealSpecialCard.add(new UNOCard(cardFaceValue, null));
               }
               else if (cardFaceValue.equals(CardFaceValue.PICK_TWO) || cardFaceValue.equals(CardFaceValue.REVERSE) || cardFaceValue.equals(CardFaceValue.SKIP)) {
                       dealSpecialCard.add(new UNOCard(cardFaceValue, color));
               }
            }

         }
      }
   }

   public void initNormalCards () {
      
      for (Color color : Color.values()) {
         for (int i = 0; i < 2; i++) {
            for (CardFaceValue cardFaceValue : CardFaceValue.values()) {
                if (i == 1 && cardFaceValue.equals(CardFaceValue.ZERO)) {
                   continue;
                }
               if (!(cardFaceValue.equals(CardFaceValue.WILD) || cardFaceValue.equals(CardFaceValue.WILD_FOUR) || cardFaceValue.equals(CardFaceValue.PICK_TWO) || cardFaceValue.equals(CardFaceValue.SKIP) || cardFaceValue.equals(CardFaceValue.REVERSE))) {
                    dealNormalCard.add(new UNOCard(cardFaceValue, color));
               }
            }
         }
      }



   }

   public boolean startPlay (List<UNOCard> listCard1, UNOCard card) {

      for (int i = 0; i < listCard1.size(); i++) {
           if (((UNOCard) listCard1.get(i)).startPlay(card)) {
               return true;
           }
      }


      return false;
   }

   public boolean beginPlay (UNOCard card, UNOCard otherCard) {


      if (card.startPlay(otherCard)) {
         return true;
      }


      return false;

   }

   public boolean startPlayColor (List<UNOCard> listCard1, Color otherCardColor) {
      for (UNOCard tempCard : listCard1) {
         if (tempCard.color.equals(otherCardColor)) {
            return true;
         }
       }
      return false;
   }

   public void shuffleUNOCards () {
      
      Collections.shuffle(cardDeck);
      Collections.shuffle(dealSpecialCard);
      Collections.shuffle(dealNormalCard);
   }

}
