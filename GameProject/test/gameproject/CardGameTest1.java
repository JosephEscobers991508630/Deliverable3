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
 * Group 6
 */
public class CardGameTest1
{

   public CardGameTest1 ()
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
   public void tearDown ()
   {
   }

   // TODO add test methods here.
   // The methods must be annotated with annotation @Test. For example:
   //
   // @Test
   // public void hello() {}

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

   @Test
   public void testDisplayOutcome ()
   {
      System.out.println("displayOutcome");
      CardGame instance = new CardGame();
      instance.displayOutcome();
      // TODO review the generated test code and remove the default call to fail.
      //   fail("The test case is a prototype.");
   }

   @Test
   public void testToString ()
   {
      System.out.println("toString");
      CardGame instance = new CardGame();
      String expResult = "WILD";
      String result = instance.toString();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
   }

   @Test
   public void testStartGame ()
   {
      System.out.println("StartGame");
      CardGame instance = new CardGame();
      instance.StartGame();
      // TODO review the generated test code and remove the default call to fail.
      // fail("The test case is a prototype.");
   }

   @Test
   public void testCheckCardSpecial ()
   {
      System.out.println("checkCardSpecial");
      int value = 2;
      CardGame instance = new CardGame();
      List<UNOCard> list = null;
      boolean expResult = true;
      boolean result = instance.checkCardSpecial(value, list);
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
   }

   @Test
   public void testSpecialCardProcessing ()
   {
      System.out.println("specialCardProcessing");
      int value = 2;
      List<UNOCard> list = null;
      CardGame instance = new CardGame();
      instance.specialCardProcessing(value, list);
      // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
   }
   /**
    * Test of displayOutcome method, of class CardGame.
    */

}
