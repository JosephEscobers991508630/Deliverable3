package gameproject;

/**
 * Joseph Escober
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class CardGame
{

   final private static int numUNOCards = 7;

   private int cardNumber;
   int nextRoll = 0;

   private String namePlayer1;
   private String namePlayer2;

   private Color color;

   private Boolean cardSpecialFlag;
   private boolean colorFlagFirst;
   private boolean colorFlagSecond;
   private boolean firstTimeToPlay;

   private CardArrayList cardList;
   private List<UNOCard> finalCardDeck;
   private List<UNOCard> dumpStackofCards;
   private List<UNOCard> handCard1;
   private List<UNOCard> handCard2;
   private List<UNOCard> specialCards;
   private List<UNOCard> normalCards;


   public CardGame ()
   {

      initializeVariables();

      for (int i = 0; i < numUNOCards; i++) {
         handCard1.add((UNOCard) finalCardDeck.get(finalCardDeck.size() - 1));
         finalCardDeck.remove(finalCardDeck.size() - 1);
         handCard2.add((UNOCard) finalCardDeck.get(finalCardDeck.size() - 1));
         finalCardDeck.remove(finalCardDeck.size() - 1);
      }
   }

   public void StartGame ()
   {

      Scanner input = new Scanner(System.in);
      System.out.print("Enter your name my Player#1:\n");
      namePlayer1 = input.nextLine();
      System.out.print("Enter your name my Player#2:\n");
      namePlayer2 = input.nextLine();
      nextRoll = 1;

      while (finalCardDeck.size() > 0 && handCard1.size() > 0 && handCard2.size() > 0) {
         cardSpecialFlag = false;
         playTurn(nextRoll);
         if (nextRoll == 1) {
            nextRoll = 2;
         }
         else {
            nextRoll = 1;
         }
      }
      displayOutcome();
   }


   public void displayOutcome ()
   {
      if (finalCardDeck.size() == 0) {
         System.out.println("Sorry, Its a draw game.");
      }
      else if (handCard1.size() == 0) {
         System.out.println(namePlayer1 + " Congratulations!, you win!!!");
      }
      else {
         System.out.println(namePlayer2 + " Congratulations!, you win!!!");
      }
   }

// Plays one nextRoll for the newPlayer number indicated.
   public void playTurn (int newPlayer)
   {
      Scanner stdin = new Scanner(System.in);

      if (!colorFlagFirst) {
         if (!firstTimeToPlay) {
            System.out.println("The card sitting on the top of the remove stack of Card is " + dumpStackofCards.get(dumpStackofCards.size() - 1));
         }
      }
      else {
         System.out.println("Card you have to remove is colored: " + color);
      }
      if (firstTimeToPlay) {
         firstTimeToPlay = false;
         dumpStackofCards.add(normalCards.get(normalCards.size() - 1));
         System.out.println("The card sitting on the top of the remove stack of Card is " + dumpStackofCards.get(dumpStackofCards.size() - 1));
      }

      if (newPlayer == 1) {
         if (colorFlagFirst) {
            if (cardList.startPlayColor(handCard1, color)) {
               colorFlagFirst = false;
               System.out.println("\n" + namePlayer1 + ", here is your card hand:\n" + handCard1);
               System.out.println("Choose card would you like to remove? Please give the correct number.");
               try {
                  cardNumber = stdin.nextInt();
                  if (!(cardNumber >= 0 && cardNumber < handCard1.size() - 1)) {
                     throw new Exception();
                  }
               }
               catch (Exception e) {
                  System.out.println("Number is out of range.it should be between 0 and " + handCard1.size() + " \ngame is over now");
                  System.exit(1);
               }
               specialCardProcessing(cardNumber, handCard1);
               if (!cardSpecialFlag) {
                  dumpStackofCards.add(handCard1.get(cardNumber));
                  handCard1.remove(cardNumber);
               }


            }
            else {
               System.out.println("Sorry that is an incorrect card. You lost your time to drop a card. A New Card has been drawn for you. " + finalCardDeck.get(finalCardDeck.size() - 1));
               finalCardDeck.remove(finalCardDeck.size() - 1);
            }
         }

         if (cardList.startPlay(handCard1, (UNOCard) dumpStackofCards.get(dumpStackofCards.size() - 1))) {
            System.out.println("\n" + namePlayer1 + ", here is your hand card:\n" + handCard1);
            System.out.println("Which card would you like to remove? Please give the correct number.");
            try {
               cardNumber = stdin.nextInt();
               if (!(cardNumber >= 0 && cardNumber < handCard1.size())) {
                  throw new Exception();
               }
            }

            catch (Exception e) {
               System.out.println("Number is out of range .it should be between 0 and " + (handCard1.size() - 1) + " \ngame is exiting now");
               System.exit(1);
            }
            specialCardProcessing(cardNumber, handCard1);


            if (!cardSpecialFlag) {

               if (cardList.beginPlay((UNOCard) handCard1.get(cardNumber), (UNOCard) dumpStackofCards.get(dumpStackofCards.size() - 1))) {
                  dumpStackofCards.add(handCard1.get(cardNumber));
                  handCard1.remove(cardNumber);
               }
               else {
                  System.out.println("Sorry that is an incorrect number. You lost your time to drop a card.");
               }

               if (handCard1.size() == 1) {
                  System.out.println(namePlayer1 + " Player One WINS!!!!");
               }
            }

         }


         else {
            System.out.println("Sorry, you are not allowed to play on this card " + namePlayer1 + " Your card hand is --> " + handCard1);
            System.out.println("\n A New Card that has been drawn for you. " + finalCardDeck.get(finalCardDeck.size() - 1));
            handCard1.add((UNOCard) finalCardDeck.get(finalCardDeck.size() - 1));
            finalCardDeck.remove(finalCardDeck.size() - 1);
            System.out.println(namePlayer2 + ", here is your resulting hand card:\n" + handCard1);
         }
      }
      else {
         if (colorFlagSecond) {
            if (cardList.startPlayColor(handCard2, color)) {
               colorFlagSecond = false;
               System.out.println("\n" + namePlayer2 + ", here is your card hand:\n" + handCard2);
               System.out.println("What card would you like to remove? Please give the correct number.");
               try {
                  cardNumber = stdin.nextInt();
                  if (!(cardNumber >= 0 && cardNumber <= handCard1.size() - 1)) {
                     throw new Exception();
                  }
               }
               catch (Exception e) {
                  System.out.println("Number is out of range, it should be between 0 and " + (handCard1.size() - 1) + " \ngame is over now");
                  System.exit(1);
               }
               specialCardProcessing(cardNumber, handCard2);
               if (!cardSpecialFlag) {
                  dumpStackofCards.add(handCard2.get(cardNumber));
                  handCard2.remove(cardNumber);
               }

            }
            else {
               System.out.println("Sorry, that is an incorrect card. You lost your time to drop a card. A New Card has been drawn for you. " + finalCardDeck.get(finalCardDeck.size() - 1));
               finalCardDeck.remove(finalCardDeck.size() - 1);
            }
         }


         if (cardList.startPlay(handCard2, (UNOCard) dumpStackofCards.get(dumpStackofCards.size() - 1))) {
            System.out.println(namePlayer2 + ", here is your hand card:\n" + handCard2);
            System.out.println("What card would you like to remove? Please give the correct number.");
            try {
               cardNumber = stdin.nextInt();
               if (!(cardNumber > 0 && cardNumber < handCard2.size())) {
                  throw new Exception();
               }
            }
            catch (Exception e) {
               System.out.println("Number is out of range, it should be between 0 and " + (handCard2.size() - 1) + " \ngame is over now");
               System.exit(1);
            }
            specialCardProcessing(cardNumber, handCard2);
            if (!cardSpecialFlag) {

               if (cardList.beginPlay((UNOCard) handCard2.get(cardNumber), (UNOCard) dumpStackofCards.get(dumpStackofCards.size() - 1))) {

                  dumpStackofCards.add(handCard2.get(cardNumber));
                  handCard2.remove(cardNumber);
               }
               else {
                  System.out.println("Sorry, that is an incorrect card. You lost your time to drop a card.");
               }


               if (handCard2.size() == 1) {
                  System.out.println("Second Player(2) says UNO!!!!");
               }
            }
         }


         else {
            System.out.println("Sorry, you are not allowed to play on this card. A new card has been drawn for you.");
            handCard2.add((UNOCard) finalCardDeck.get(finalCardDeck.size() - 1));
            System.out.println(namePlayer1 + ", here is your card hand:\n" + handCard2);
         }

      }
   }

   public void initializeVariables ()
   {
      cardList = new CardArrayList();
      finalCardDeck = cardList.prepareDeckCard();
      handCard1 = new ArrayList<UNOCard>();
      handCard2 = new ArrayList<UNOCard>();
      dumpStackofCards = new ArrayList<UNOCard>();
      specialCards = cardList.prepareDeckSpecialCard();
      normalCards = cardList.prepareDeckNormalCard();

      namePlayer1 = "";
      namePlayer2 = "";
      colorFlagFirst = false;
      colorFlagSecond = false;
      cardSpecialFlag = false;
      firstTimeToPlay = true;

   }

   public boolean checkCardSpecial (int value, List<UNOCard> list)
   {
      UNOCard tmpCard = list.get(value);
      if (!(value >= 0 || value <= 6)) {
         System.out.println("Incorrect value!\n ");
         return false;
      }
      else if (specialCards.contains(tmpCard)) {

         return true;
      }
      return false;
   }


   public void specialCardProcessing (int value, List<UNOCard> list)
   {
      UNOCard tempCard1 = (UNOCard) list.get(value);
      if (tempCard1.cardFaceValue.equals(CardFaceValue.PICK_TWO)) {
         if (nextRoll == 1) {
            System.out.println("You used the PICK_TWO Card.\n. Two Cards to play for " + namePlayer2);

            handCard2.add((UNOCard) finalCardDeck.get(finalCardDeck.size() - 1));
            handCard2.add((UNOCard) finalCardDeck.get(finalCardDeck.size() - 1));


         }
         else {
            System.out.println("You used the PICK_TWO Card.\n. Two Cards to play for " + namePlayer1);
            handCard1.add((UNOCard) finalCardDeck.get(finalCardDeck.size() - 1));
            handCard1.add((UNOCard) finalCardDeck.get(finalCardDeck.size() - 1));
         }

         cardSpecialFlag = true;
         finalCardDeck.remove(finalCardDeck.size() - 1);
         finalCardDeck.remove(finalCardDeck.size() - 1);
         if (nextRoll == 1 && (finalCardDeck.size() > 0 && handCard1.size() > 0 && handCard2.size() > 0)) {
            playTurn(nextRoll);

         }
         else if (nextRoll == 2 && (finalCardDeck.size() > 0 && handCard1.size() > 0 && handCard2.size() > 0)) {
            playTurn(nextRoll);
         }
      }


      if (tempCard1.cardFaceValue.equals(CardFaceValue.SKIP) || tempCard1.cardFaceValue.equals(CardFaceValue.REVERSE)) {
         if (nextRoll == 1 && (finalCardDeck.size() > 0 && handCard1.size() > 0 && handCard2.size() > 0)) {
            cardSpecialFlag = true;
            dumpStackofCards.add(tempCard1);
            handCard1.remove(tempCard1);
            playTurn(nextRoll);
         }

         else if (nextRoll == 2 && (finalCardDeck.size() > 0 && handCard1.size() > 0 && handCard2.size() > 0)) {
            cardSpecialFlag = true;
            dumpStackofCards.add(tempCard1);
            handCard2.remove(tempCard1);

            playTurn(nextRoll);
         }

      }

      if (tempCard1.cardFaceValue.equals(CardFaceValue.WILD_FOUR)) {
         cardSpecialFlag = true;
         if (nextRoll == 1 && (finalCardDeck.size() > 0 && handCard1.size() > 0 && handCard2.size() > 0)) {
            System.out.println(namePlayer1 + " has used WILD_FOUR , 4 cards have been drawn for ." + namePlayer2);

            for (int i = 0; i < 4; i++) {
               handCard2.add((UNOCard) finalCardDeck.get(finalCardDeck.size() - 1));
               finalCardDeck.remove(finalCardDeck.size() - 1);
            }
            playTurn(nextRoll);
         }
         else if (nextRoll == 2 && (finalCardDeck.size() > 0 && handCard1.size() > 0 && handCard2.size() > 0)) {
            System.out.println(namePlayer2 + " has used WILD_FOUR , 4 cards have been drawn for " + namePlayer1);

            for (int i = 0; i < 4; i++) {
               handCard1.add((UNOCard) finalCardDeck.get(finalCardDeck.size() - 1));
               finalCardDeck.remove(finalCardDeck.size() - 1);
            }
            playTurn(nextRoll);
         }
      }
      if (tempCard1.cardFaceValue.equals(CardFaceValue.WILD)) {
         cardSpecialFlag = true;

         Scanner input1 = new Scanner(System.in);
         System.out.println(" WILD card plays now.... Choose the color from the following <0-3>\n");
         for (Color color : Color.values()) {
            System.out.println(color.name());

         }

         int input = input1.nextInt();
         if (input >= 0 && input <= 3) {
            switch (input) {
               case 0:
                  System.out.println("You selected the Yellow color");
                  color = Color.YELLOW;
                  if (nextRoll == 1 && (finalCardDeck.size() > 0 && handCard1.size() > 0 && handCard2.size() > 0)) {
                     colorFlagSecond = true;
                     playTurn(2);
                  }
                  else {
                     colorFlagFirst = true;
                     playTurn(1);
                  }
                  break;
               case 1:
                  System.out.println("You selected the Blue color");
                  color = Color.BLUE;
                  if (nextRoll == 1 && (finalCardDeck.size() > 0 && handCard1.size() > 0 && handCard2.size() > 0)) {
                     colorFlagSecond = true;
                     playTurn(2);
                  }
                  else if (nextRoll == 2 && (finalCardDeck.size() > 0 && handCard1.size() > 0 && handCard2.size() > 0)) {
                     colorFlagFirst = true;
                     playTurn(1);
                  }
                  break;
               case 2:
                  System.out.println("You selected the Green color");
                  color = Color.GREEN;
                  if (nextRoll == 1 && (finalCardDeck.size() > 0 && handCard1.size() > 0 && handCard2.size() > 0)) {
                     colorFlagSecond = true;
                     playTurn(2);
                     break;
                  }
                  else {
                     colorFlagFirst = true;
                     playTurn(1);
                     break;
                  }

               case 3:
                  System.out.println("you selected the Red color");
                  color = Color.RED;
                  if (nextRoll == 1 && (finalCardDeck.size() > 0 && handCard1.size() > 0 && handCard2.size() > 0)) {
                     colorFlagSecond = true;
                     playTurn(2);
                     break;
                  }
                  else {
                     colorFlagFirst = true;
                     playTurn(1);
                     break;

                  }
            }

         }

      }
   }

//   public static void main (String[] args)
//   {
//
////      Scanner input = new Scanner(System.in);
////      System.out.print("Enter your name Player#1:\n");
////      namePlayer1 = input.nextLine();
////      System.out.print("Enter your name Player#2:\n");
////      namePlayer2 = input.nextLine();
////      nextRoll = 1;
////      while (finalCardDeck.size() > 0 && handCard1.size() > 0 && handCard2.size() > 0) {
////         cardSpecialFlag = false;
////         new CardGame().playTurn(nextRoll);
////         if (nextRoll == 1) {
////            nextRoll = 2;
////         }
////         else {
////            nextRoll = 1;
////         }
////      }
////      new CardGame().displayOutcome();
//   }
}
