/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class Drevo23Test {
    
    public Drevo23 d23 = new Drevo23<>();
    
    public Drevo23Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    

    /**
     * Test of add method, of class Drevo23.
     */
    @Test
    public void testAdd() {
       d23.add("20");
       d23.add("15");
       d23.add("16");
       d23.add("25");
       d23.add("9");
       d23.add("12");
       d23.add("8");
       d23.add("7");
       d23.add("1");
       assertTrue(d23.exists("1"));
       assertFalse(d23.exists("100"));
       assertTrue(d23.exists("9"));
       assertTrue(d23.exists("25"));
    }

    /**
     * Test of removeFirst method, of class Drevo23.
     */
    @Test
    public void testRemoveFirst() {
        assertEquals(null, d23.removeFirst());
        d23.add("2");
        assertEquals("2", d23.removeFirst());
        d23.add("1");
        d23.add("3");
        assertEquals("1", d23.removeFirst());
        List<String> test = new ArrayList<String>();
        test.add("3");
        assertEquals(test, d23.asList());
    }

    /**
     * Test of getFirst method, of class Drevo23.
     */
    @Test
    public void testGetFirst() {
        d23.add("1");
        d23.add("2");
        d23.add("3");
        d23.add("4");
        d23.add("5");
        assertEquals("3",d23.getFirst());
        d23.add("0");
        assertEquals("1", d23.getFirst());
    }

    /**
     * Test of size method, of class Drevo23.
     */
    @Test
    public void testSize() {
        assertEquals(0, d23.size());
        d23.add("1");
        d23.add("2");
        d23.add("3");
        d23.add("4");
        d23.add("5");
        assertEquals(5, d23.size());
        d23.add("123");
        d23.add("1234");
        assertEquals(7, d23.size());
    }

    /**
     * Test of depth method, of class Drevo23.
     */
    @Test
    public void testDepth() {
        assertEquals(0, d23.depth());
        d23.add("1");
        d23.add("2");
        assertEquals(1,d23.depth());
        d23.add("3");
        d23.add("4");
        d23.add("5");
        d23.add("6");
        assertEquals(2, d23.depth());
        d23.add("0");
        d23.add("-1");
        assertEquals(3, d23.depth());
    }

    /**
     * Test of isEmpty method, of class Drevo23.
     */
    @Test
    public void testIsEmpty() {
        assertTrue(d23.isEmpty());
        d23.add("125125");
        assertFalse(d23.isEmpty());
    }

    /**
     * Test of remove method, of class Drevo23.
     */
    
    
    @Test
    public void testExistsN() {
    boolean thrown = false;

    try {
        d23.add("2");
        d23.add("2");
    } catch (UnsupportedOperationException e) {
        thrown = true;
    }

    assertTrue(thrown);
    }
    
    @Test
    public void dodaj2gor(){
        d23.add("8");
        d23.add("12");
        d23.add("15");
        d23.add("16");
        d23.add("2");
        d23.add("7");
        d23.add("6");
        d23.add("5");
        d23.add("3");
    }
    
    @Test
    public void dodaj2gorL(){
        d23.add("8");
        d23.add("12");
        d23.add("15");
        d23.add("16");
        d23.add("2");
        d23.add("7");
        d23.add("6");
        d23.add("5");
        d23.add("1");
    }
    
    @Test
    public void dodaj2gorS(){
        d23.add("8");
        d23.add("12");
        d23.add("15");
        d23.add("16");
        d23.add("2");
        d23.add("7");
        d23.add("6");
        d23.add("5");
        d23.add("9");
    }
    
    @Test
    public void dodaj2gorD(){
        d23.add("8");
        d23.add("12");
        d23.add("15");
        d23.add("16");
        d23.add("2");
        d23.add("7");
        d23.add("6");
        d23.add("5");
        d23.add("17");
    }
    
    @Test
    public void dodaj2gorDa(){
        d23.add("8");
        d23.add("12");
        d23.add("15");
        d23.add("16");
        d23.add("2");
        d23.add("7");
        d23.add("6");
        d23.add("5");
        d23.add("13");
    }
    
    @Test
    public void dodaj2gorDb(){
        d23.add("8");
        d23.add("12");
        d23.add("13");
        d23.add("16");
        d23.add("2");
        d23.add("7");
        d23.add("6");
        d23.add("5");
        d23.add("15");
    }
    
    @Test
    public void dodaj2gorDbb(){
        d23.add("8");
        d23.add("12");
        d23.add("13");
        d23.add("16");
        d23.add("2");
        d23.add("7");
        d23.add("6");
        d23.add("5");
        d23.add("17");
    }
    
    @Test
    public void dodaj2gorSvse(){
        d23.add("9");
        d23.add("16");
        d23.add("18");
        d23.add("19");
        d23.add("2");
        d23.add("7");
        d23.add("5");
        d23.add("14");
        d23.add("8");
    }
    
    @Test
    public void dodaj2gorSm(){
        d23.add("9");
        d23.add("16");
        d23.add("18");
        d23.add("19");
        d23.add("2");
        d23.add("7");
        d23.add("5");
        d23.add("14");
        d23.add("10");
    }
    
    @Test
    public void dodaj2gorSd(){
        d23.add("9");
        d23.add("16");
        d23.add("18");
        d23.add("19");
        d23.add("2");
        d23.add("7");
        d23.add("5");
        d23.add("14");
        d23.add("15");
    }
    
    @Test
    public void dodaj2gorDSprostor(){
        d23.add("10");
        d23.add("7");
        d23.add("13");
        d23.add("16");
        d23.add("8");
        d23.add("2");
        d23.add("11");
    }
    
    @Test
    public void dodaj2gorDSprostorS(){
        d23.add("10");
        d23.add("7");
        d23.add("13");
        d23.add("16");
        d23.add("8");
        d23.add("2");
        d23.add("15");
    }
    
    @Test
    public void dodaj(){
        d23.add("2");
        d23.add("5");
        d23.add("10");
        d23.add("4");
        d23.add("3");
        d23.D23();
        d23.add("3");
        d23.add("5");
        d23.add("7");
        d23.add("2");
        d23.add("10");
        d23.add("8");
    }
    
    @Test
    public void dodajSa(){
        d23.add("12");
        d23.add("7");
        d23.add("15");
        d23.add("5");
        d23.add("16");
        d23.add("9");
        d23.add("11");
        assertEquals("16", d23.remove("16"));
        d23.add("8"); 
    }
    
    @Test
    public void dodajLpoveca(){
        d23.add("12");
        d23.add("6");
        d23.add("15");
        d23.add("1");
        d23.add("16");
        d23.add("8");
        d23.add("2");
        d23.add("10");
        d23.add("5");
        d23.add("7");
        d23.add("9");
        d23.add("17");
    }
    
    @Test
    public void dodajvLdaGregor(){
        d23.add("25");
        d23.add("10");
        d23.add("30");
        d23.add("15");
        d23.add("20");
        d23.add("35");
        d23.add("11");
        d23.add("16");
        d23.add("22");
        d23.add("17");
        d23.add("9");
    }
    
    @Test
    public void dodajSb(){
        d23.add("12");
        d23.add("7");
        d23.add("15");
        d23.add("5");
        d23.add("16");
        d23.add("9");
        d23.add("10");
        assertEquals("16", d23.remove("16"));
        d23.add("11");
    }
    
    @Test
    public void dodajSm(){
        d23.add("12");
        d23.add("7");
        d23.add("15");
        d23.add("5");
        d23.add("16");
        d23.add("9");
        d23.add("11");
        assertEquals("16", d23.remove("16"));
        d23.add("10");
    }
    
    @Test
    public void dodajSl(){
        d23.add("12");
        d23.add("7");
        d23.add("15");
        d23.add("5");
        d23.add("16");
        d23.add("9");
        d23.add("11");
        d23.add("8");
    }
    
    @Test
    public void dodajSlm(){
        d23.add("12");
        d23.add("7");
        d23.add("15");
        d23.add("5");
        d23.add("16");
        d23.add("9");
        d23.add("11");
        d23.add("10");
    }
    
    @Test
    public void dodajSlb(){
        d23.add("12");
        d23.add("7");
        d23.add("15");
        d23.add("5");
        d23.add("16");
        d23.add("9");
        d23.add("10");
        d23.add("11");
    }
    
    @Test
    public void testRemovevecNevem(){
        d23.add("15");
        d23.add("16");
        d23.add("5");
        d23.add("4");
        d23.add("7");
        d23.add("8");
        d23.add("3");
        d23.add("2");
        assertEquals(null, d23.remove("2"));
    }
    
    
    @Test
    public void testRemove() {
        d23.add("15");
        assertEquals("15", d23.remove("15"));
        assertEquals(0, d23.size());
        assertEquals(null, d23.remove("1244"));
        
        d23.add("20");
        d23.add("55");
        d23.add("14");
        d23.add("5");
        d23.add("25");
        assertEquals("14", d23.remove("14"));
        assertEquals("5", d23.remove("5"));
        assertEquals("25", d23.remove("25"));
        assertEquals("55", d23.remove("55"));
    }

    @Test
    public void testRemove3je(){
        d23.add("1");
        d23.add("2");
        d23.add("3");
        assertEquals("1", d23.remove("1"));
        d23.add("1");
        assertEquals("2", d23.remove("2"));
        d23.add("2");
        assertEquals("3", d23.remove("3"));
        d23.add("3");
    }
          
    
    @Test
    public void testRemove2gorPolno(){
        d23.add("10");
        d23.add("11");
        d23.add("20");
        d23.add("9");
        d23.add("8");
        d23.add("7");
        d23.add("6");
        d23.add("5");
        assertEquals("6", d23.remove("6"));
        d23.add("6");
        assertEquals("9", d23.remove("9"));
        d23.add("9");
        assertEquals("20", d23.remove("20"));
        d23.add("20");
        assertEquals("5", d23.remove("5"));
        d23.add("5");
        assertEquals("8", d23.remove("8"));
        d23.add("8");
        assertEquals("11", d23.remove("11"));
        d23.add("11");
        assertEquals("7", d23.remove("7"));
        d23.add("7");
        assertEquals("8", d23.remove("8"));
    }
    
    @Test
    public void testRemove2gorNipolno(){
        d23.add("3");
        d23.add("6");
        d23.add("15");
        d23.add("12");
        d23.add("13");
        d23.add("7");
        d23.add("8");
        assertEquals("3", d23.remove("3"));
        assertEquals("6", d23.remove("6"));
        d23.add("16");
        assertEquals("13", d23.remove("13"));
        d23.add("17");
        d23.add("18");
        assertEquals("8", d23.remove("8"));
        assertEquals("15", d23.remove("15"));
        d23.add("4");
        d23.add("3");
        assertEquals("12", d23.remove("12"));
        d23.add("2");
        d23.add("8");
        assertEquals("18", d23.remove("18"));
        assertEquals("17", d23.remove("17"));
        assertEquals("16", d23.remove("16"));
    }
    
    @Test
    public void testRemove2gorRemoveGor(){
        d23.add("3");
        d23.add("6");
        d23.add("15");
        d23.add("12");
        d23.add("13");
        d23.add("7");
        d23.add("8");
        assertEquals("6", d23.remove("6"));
        d23.add("4");
        d23.add("16");
        assertEquals("8", d23.remove("8"));
        d23.add("8");
        assertEquals("16", d23.remove("16"));
        assertEquals("7", d23.remove("7"));
        d23.add("2");
        assertEquals("4", d23.remove("4"));
    }
    
    @Test
    public void testRemove1gor(){
        d23.add("2");
        d23.add("5");
        d23.add("15");
        d23.add("3");
        d23.add("12");
        assertEquals("2", d23.remove("2"));
        assertEquals("12", d23.remove("12"));
        d23.add("2");
        assertEquals("15", d23.remove("15"));
        d23.add("1");
        d23.add("7");
        assertEquals("3", d23.remove("3"));
        assertEquals("5", d23.remove("5"));
        assertEquals("2", d23.remove("2"));
        d23.add("10");
        d23.add("11");
        assertEquals("7", d23.remove("7"));
    }
    
    
    
    
    
   @Test
   public void testClear(){
       d23.add("15");
       d23.add("99");
       d23.add("1231244");
       assertEquals(3, d23.size());
       d23.D23();
       assertEquals(0, d23.size());
   }
    
    
    @Test
    public void testExists() {
        assertFalse(d23.exists("10"));
        d23.add("10");
        d23.add("30");
        d23.add("14");
        d23.add("15");
        assertTrue(d23.exists("10"));
        assertFalse(d23.exists("1"));
        d23.add("16");
        d23.add("1");
        d23.add("2");
        d23.add("8");
        d23.add("17");
        assertTrue(d23.exists("1"));
        assertFalse(d23.exists("55"));
        d23.add("25");
        d23.add("22");
        d23.add("5");
        d23.add("20");
        d23.add("21");
        d23.add("34");
        d23.add("55");
        assertTrue(d23.exists("55"));
        assertFalse(d23.exists("12444"));

        
    }

    /**
     * Test of asList method, of class Drevo23.
     */
    @Test
    public void testAsList() {
       assertEquals(null, d23.asList());
       d23.add("20");
       d23.add("15");
       d23.add("16");
       d23.add("25");
       d23.add("9");
       List<String> primerjava = new ArrayList<String>();
       primerjava.add("16");
       primerjava.add("9");
       primerjava.add("15");
       primerjava.add("20");
       primerjava.add("25");
       d23.add("12");
       d23.add("8");
       d23.add("7");
       d23.add("1");
       primerjava = new ArrayList<String>();
       primerjava.add("9");
       primerjava.add("7");
       primerjava.add("1");
       primerjava.add("8");
       primerjava.add("16");
       primerjava.add("12");
       primerjava.add("15");
       primerjava.add("20");
       primerjava.add("25");
       assertEquals(primerjava, d23.asList());
    }
    
}
