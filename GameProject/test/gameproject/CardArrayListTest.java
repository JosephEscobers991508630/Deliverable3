/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author joseph
 */
public class CardArrayListTest
{

   public CardArrayListTest ()
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

   /**
    * Test of prepareDeckCard method, of class CardArrayList.
    */
   @Test
   public void testPrepareDeckCard ()
   {
      System.out.println("prepareDeckCard");
      CardArrayList instance = new CardArrayList();
      List<UNOCard> expResult = instance.prepareDeckCard();
      List<UNOCard> result = instance.prepareDeckCard();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
   }

   /**
    * Test of prepareDeckSpecialCard method, of class CardArrayList.
    */
   @Test
   public void testPrepareDeckSpecialCard ()
   {
      System.out.println("prepareDeckSpecialCard");
      CardArrayList instance = new CardArrayList();
      List<UNOCard> expResult = instance.prepareDeckSpecialCard();
      List<UNOCard> result = instance.prepareDeckSpecialCard();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
   }

   /**
    * Test of prepareDeckNormalCard method, of class CardArrayList.
    */
   @Test
   public void testPrepareDeckNormalCard ()
   {
      System.out.println("prepareDeckNormalCard");
      CardArrayList instance = new CardArrayList();
      List<UNOCard> expResult = instance.prepareDeckNormalCard();
      List<UNOCard> result = instance.prepareDeckNormalCard();
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
   }

   /**
    * Test of initDeckCards method, of class CardArrayList.
    */
   @Test
   public void testInitDeckCards ()
   {
      System.out.println("initDeckCards");
      CardArrayList instance = new CardArrayList();
      instance.initDeckCards();
      // TODO review the generated test code and remove the default call to fail.
      // fail("The test case is a prototype.");
   }

   /**
    * Test of initSpecialCards method, of class CardArrayList.
    */
   @Test
   public void testInitSpecialCards ()
   {
      System.out.println("initSpecialCards");
      CardArrayList instance = new CardArrayList();
      instance.initSpecialCards();
      // TODO review the generated test code and remove the default call to fail.
      //   fail("The test case is a prototype.");
   }

   /**
    * Test of initNormalCards method, of class CardArrayList.
    */
   @Test
   public void testInitNormalCards ()
   {
      System.out.println("initNormalCards");
      CardArrayList instance = new CardArrayList();
      instance.initNormalCards();
      // TODO review the generated test code and remove the default call to fail.
      // fail("The test case is a prototype.");
   }

   /**
    * Test of startPlay method, of class CardArrayList.
    */

   /**
    * Test of beginPlay method, of class CardArrayList.
    */


   /**
    * Test of startPlayColor method, of class CardArrayList.
    */
   @Test
   public void testStartPlayColor ()
   {
      System.out.println("startPlayColor");
      CardArrayList instance = new CardArrayList();
      List<UNOCard> listCard1 = instance.prepareDeckCard();
      Color otherCardColor = null;
      boolean expResult = false;
      boolean result = instance.startPlayColor(listCard1, otherCardColor);
      assertEquals(expResult, result);
      // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
   }

   /**
    * Test of shuffleUNOCards method, of class CardArrayList.
    */
   @Test
   public void testShuffleUNOCards ()
   {
      System.out.println("shuffleUNOCards");
      CardArrayList instance = new CardArrayList();
      instance.shuffleUNOCards();
      // TODO review the generated test code and remove the default call to fail.
      //    fail("The test case is a prototype.");
   }

}
