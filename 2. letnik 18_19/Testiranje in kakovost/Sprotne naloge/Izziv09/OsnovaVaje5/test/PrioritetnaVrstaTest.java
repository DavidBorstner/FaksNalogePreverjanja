import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.*;
import static org.junit.Assert.*;


public class PrioritetnaVrstaTest {
    
    private PrioritetnaVrsta<String> pv;
    
    public PrioritetnaVrstaTest() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        pv = new PrioritetnaVrsta<>(10);
    }
    
    @After
    public void tearDown() {
    }
	
	
    /** Test metod razreda <PrioritetnaVrsta> */
	
    // testi dodajanja

    @Test
    public void testAddOne() {
        pv.add("Test");
    }
    
    @Test
    public void testPrint() throws FileNotFoundException, IOException{
        pv.print();
        pv.save(new FileOutputStream("novo"));
        pv.add("test");
        pv.add("test2");
        pv.add("test3");
        pv.print();
        pv.save(new FileOutputStream("novo"));
        try {
            pv.restore(new FileInputStream("novo"));
        } catch (IOException ex) {
            Logger.getLogger(PrioritetnaVrstaTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrioritetnaVrstaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testAddMultiple() {
        pv.add("Test1");
        pv.add("Test2");
    }
    
    //@Ignore("To be implemented later...")
    @Test
    public void testAddOverflow() {
        pv = new PrioritetnaVrsta<>(2);
        pv.add("Test1");
        pv.add("Test2");
        pv.add("Test3");
        
    }
    
    // testi brisanja
	
    @Test(expected=java.util.NoSuchElementException.class)
    public void testRemoveFirstEmpty() {
        pv.removeFirst();
    }
    
    @Test
    public void testRemoveFirstOne() {
        pv.add("Test");
        assertEquals("Test", pv.removeFirst());
    }
    
    @Test
    public void testRemoveFirstMultiple() {
        pv.add("Test1");
        pv.add("Test5");
        pv.add("Test2");
        pv.add("Test4");
        pv.add("Test3");
        assertEquals("Test5", pv.removeFirst());
        assertEquals("Test4", pv.removeFirst());
        assertEquals("Test3", pv.removeFirst());
        assertEquals("Test2", pv.removeFirst());
        assertEquals("Test1", pv.removeFirst());
    }
    
    // metoda get
	
    @Test
    public void testRemoveBubbleDown(){
        pv.add("10");
        pv.add("15");
        pv.add("16");
        pv.add("17");
        pv.add("18");
        pv.add("20");
        pv.add("4");
        pv.add("25");
        pv.add("2");
        pv.add("89");
        pv.add("124");
        pv.add("44");
        assertEquals("15", pv.remove("15"));
        assertEquals("4", pv.remove("4"));
        assertEquals("17", pv.remove("17"));
        assertEquals("124", pv.remove("124"));
        assertEquals("89", pv.remove("89"));
        assertEquals("2", pv.remove("2"));
    }
    
    @Test(expected=java.util.NoSuchElementException.class)
    public void testGetFirstEmpty() {
        pv.getFirst();
    }
    
    @Test
    public void testGetFirstOne() {
        pv.add("Test");
        assertEquals("Test", pv.getFirst());
    }
    
    @Test
    public void testGetFirstMultiple() {
        pv.add("Test1");
        assertEquals("Test1", pv.getFirst());
        pv.add("Test3");
        pv.add("Test2");
        assertEquals("Test3", pv.getFirst());
        assertEquals("Test3", pv.getFirst());
    }
    
    // testiranje metode za globino
	
    @Test
    public void testDepthEmpty() {
        assertEquals(0, pv.depth());
    }
    
    @Test
    public void testDepthOne() {
        pv.add("Test1");
        assertEquals(1, pv.depth());
    }

    @Test
    public void testDepthMultiple() {
        pv.add("Test1");
        assertEquals(1, pv.depth());
        pv.add("Test5");
        assertEquals(2, pv.depth());
        pv.add("Test2");
        assertEquals(2, pv.depth());
        pv.add("Test4");
        assertEquals(3, pv.depth());
        pv.add("Test3");
        assertEquals(3, pv.depth());
        pv.add("Test6");
        assertEquals(3, pv.depth());
        pv.add("Test8");
        assertEquals(3, pv.depth());
        pv.add("Test7");
        assertEquals(4, pv.depth());
    }
    
    // test metode size
	
    @Test
    public void testSizeEmpty() {
        assertEquals(0, pv.size());
    }
    
    @Test
    public void testSizeOne() {
        pv.add("Test");
        assertEquals(1, pv.size());
    }
    
    @Test
    public void testSizeMultiple() {
        assertEquals(0, pv.size());
        pv.add("Test");
        assertEquals(1, pv.size());
        pv.add("Test1");
        assertEquals(2, pv.size());
        pv.add("Test2");
        assertEquals(3, pv.size());
    }
    
    // test metode isEmpty
	
    @Test
    public void testIsEmptyEmpty() {
        assertTrue(pv.isEmpty());
    }

    @Test
    public void testIsEmptyOne() {
        pv.add("Test");
        assertFalse(pv.isEmpty());
    }
    
    @Test
    public void testIsEmptyMultiple() {
        pv.add("Test");
        pv.add("Test1");
        pv.add("Test2");
        assertFalse(pv.isEmpty());
    }
    
    @Test
    public void testRemove() {
        pv.add("Test");
        pv.add("Test1");
        pv.add("Test2");
        assertEquals("Test2", pv.remove("Test2"));
        assertEquals("Test", pv.remove("Test"));
        assertEquals("Test1", pv.remove("Test1"));
        
    }
    
    @Test
    public void testExists() {
        pv.add("Test");
        pv.add("Test1");
        pv.add("Test2");
        assertTrue(pv.exists("Test1"));
        assertTrue(pv.exists("Test2"));
        assertFalse(pv.exists("Test3"));
        assertFalse(pv.exists("Test4"));
    }
    
    @Test
    public void testRemoveNoSuch() {
    boolean thrown = false;

    try {
        pv.remove("Test");
        assertEquals(null, pv.remove("Test45"));
    } catch (java.util.NoSuchElementException e) {
        thrown = true;
    }

    assertTrue(thrown);
    }

    @Test
    public void testExistsNoSuch() {
    boolean thrown = false;

    try {
        pv.exists("Test");
    } catch (java.util.NoSuchElementException e) {
        thrown = true;
    }

    assertTrue(thrown);
    }
    
    @Test
    public void asList(){
        pv.add("Test");
        pv.add("Test1");
        pv.add("Test2");
        List<String> test = new ArrayList<String>();
        test.add("Test2");
        test.add("Test");
        test.add("Test1");
        assertEquals(test, pv.asList());
        test = new ArrayList<String>();
        pv.add("Test4");
        pv.add("Test3");
        test.add("Test4");
        test.add("Test3");
        test.add("Test1");
        test.add("Test");
        test.add("Test2");
        assertEquals(test, pv.asList());
    }
    
    @Test
    public void asListRemove(){
        pv.add("6");
        pv.add("4");
        pv.add("5");
        pv.add("3");
        pv.add("2");
        pv.add("0");
        pv.add("1");
        List<String> test = new ArrayList<String>();
        test.add("6");
        test.add("4");
        test.add("5");
        test.add("3");
        test.add("2");
        test.add("0");
        test.add("1");
        assertEquals(test, pv.asList());
    }
    
    @Test
    public void asListEmpty(){
        List<String> test = new ArrayList<String>();
        assertEquals(test, pv.asList());
        pv.add("test");
        pv.removeFirst();
        assertEquals(test, pv.asList());
    }
    
}