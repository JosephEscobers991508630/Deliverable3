/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author joseph
 */
public class CardGameTest
{

   public CardGameTest ()
   {
   }

   @BeforeClass
   public static void setUpClass ()
   {
   }

   @AfterClass
   public static void tearDownClass ()
   {
   }

   @Before
   public void setUp ()
   {
   }

   @After
   public void tearDown () throws Exception
   {
   }

   /**
    * Test of startPlay method, of class CardGame.
    */
   @Test
   public void testStartPlay ()
   {
      System.out.println("startPlay");
      CardGame oneCard = null;
      CardGame instance = new CardGame();
      boolean expResult = false;
      boolean result = instance.startPlay(oneCard);
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      // fail("The test case is a prototype.");
   }

   /**
    * Test of playColor method, of class CardGame.
    */
   @Test
   public void testPlayColor ()
   {
      System.out.println("playColor");
      CardGame oneCard = null;
      CardGame instance = new CardGame();
      boolean expResult = false;
      boolean result = instance.playColor(oneCard);
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
   }

   /**
    * Test of toString method, of class CardGame.
    */
   @Test
   public void testToString ()
   {
      System.out.println("toString");
      CardGame instance = new CardGame();
      String expResult = "";
      String result = instance.toString();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
   }

   /**
    * Test of StartGame method, of class CardGame.
    */
   @Test
   public void testStartGame ()
   {
      System.out.println("StartGame");
      CardGame instance = new CardGame();
      instance.StartGame();
      // TODO review the generated test code and remove the default call to fail.
      // fail("The test case is a prototype.");
   }

   /**
    * Test of displayOutcome method, of class CardGame.
    */
   @Test
   public void testDisplayOutcome ()
   {
      System.out.println("displayOutcome");
      CardGame instance = new CardGame();
      instance.displayOutcome();
      // TODO review the generated test code and remove the default call to fail.
      //   fail("The test case is a prototype.");
   }

   /**
    * Test of playTurn method, of class CardGame.
    */
   @Test
   public void testPlayTurn ()
   {
      System.out.println("playTurn");
      int newPlayer = 0;
      CardGame instance = new CardGame();
      instance.playTurn(newPlayer);
      // TODO review the generated test code and remove the default call to fail.
      // fail("The test case is a prototype.");
   }

   /**
    * Test of checkTypeSpecial method, of class CardGame.
    */
   @Test
   public void testCheckTypeSpecial ()
   {
      System.out.println("checkTypeSpecial");
      int value = 0;
      List<CardGame> list = null;
      CardGame instance = new CardGame();
      boolean expResult = false;
      boolean result = instance.checkTypeSpecial(value, list);
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      //     fail("The test case is a prototype.");
   }

   /**
    * Test of typeSpecialCard method, of class CardGame.
    */
   @Test
   public void testTypeSpecialCard ()
   {
      System.out.println("typeSpecialCard");
      int value = 0;
      List<CardGame> list = null;
      CardGame instance = new CardGame();
      instance.typeSpecialCard(value, list);
      // TODO review the generated test code and remove the default call to fail.
      //   fail("The test case is a prototype.");
   }

   /**
    * Test of initializeVariables method, of class CardGame.
    */


   /**
    * Test of checkCardSpecial method, of class CardGame.
    */
   @Test
   public void testCheckCardSpecial ()
   {
      System.out.println("checkCardSpecial");
      int value = 0;
      List<UNOCard> list = null;
      CardGame instance = new CardGame();
      boolean expResult = false;
      boolean result = instance.checkCardSpecial(value, list);
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
   }

   /**
    * Test of specialCardProcessing method, of class CardGame.
    */
   @Test
   public void testSpecialCardProcessing ()
   {
      System.out.println("specialCardProcessing");
      int value = 0;
      List<UNOCard> list = null;
      CardGame instance = new CardGame();
      instance.specialCardProcessing(value, list);
      // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
   }

}
