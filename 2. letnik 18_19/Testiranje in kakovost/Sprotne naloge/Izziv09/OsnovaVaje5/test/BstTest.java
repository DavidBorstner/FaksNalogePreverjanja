import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.*;

public class BstTest {

    
    
    private Bst<String> bst;

    public BstTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        bst = new Bst<>();
    }

    @After
    public void tearDown() {
    }

    // Praviloma bi morali testirati vsako funkcijo v razredu
    // torej tudi: member, insert, delete, deleteMin, getDepth, countNodes
    
    // Glede na to, da teste zasnujemo pred poznavanjem podrobnosti implementacije
    // zasnujemo teste za metode vmesnika: 
    // add, removeFirst, getFirst, size,depth, isEmpty, remove, exists
    
    @Test
    public void testAdd() {
       bst.add("Test");
       assertEquals("Test", bst.getFirst());
       bst.add("Test2");
       bst.add("Test3");
       assertEquals(3, bst.size());
       bst.add("Test4");
       bst.add("Test5");
       assertEquals(5, bst.size());
    }

    @Test
    public void testRemoveFirst(){
        bst.add("Test1");
        bst.add("Test2");
        bst.add("Test3");
        bst.add("Test4");
        bst.removeFirst();
        assertFalse(bst.exists("Test1"));
        assertTrue(bst.exists("Test2"));
        bst.remove("Test2");
        assertFalse(bst.exists("Test2"));
        bst.removeFirst();
        assertFalse(bst.exists("Test3"));
    }   
    
    @Test
    public void testGetFirstOne() {
        bst.add("Test");
        assertEquals("Test", bst.getFirst());
        assertEquals(1, bst.size());
        assertEquals(1, bst.depth());
    }

    @Test
    public void testGetFirstMultiple() {
        bst.add("Test2");
        assertEquals("Test2", bst.getFirst());
        assertEquals(1, bst.size());
        assertEquals(1, bst.depth());
        bst.add("Test3");
        bst.add("Test1");
        assertEquals("Test2", bst.getFirst());
        assertEquals("Test2", bst.getFirst());
        assertEquals(3, bst.size());
        assertEquals(2, bst.depth());
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void testGetFirstOnEmpty() {
        bst.getFirst();
    }

   @Test
    public void testSizeOnEmpty() {
        assertEquals(0, bst.size());
    }
    
    @Test
    public void testSize(){
        assertEquals(0, bst.size());
        bst.add("Test1");
        bst.add("Test2");
        bst.add("Test3");
        assertEquals(3, bst.size());
        bst.add("Test4");
        bst.add("Test5");
        bst.add("Test6");
         assertEquals(6, bst.size());
    }
    
    @Test
    public void testDepthOnEmpty() {
        assertEquals(0, bst.depth());
    }
    
    @Test
    public void testDepth(){
        assertEquals(0, bst.depth());
        bst.add("Test1");
        bst.add("Test2");
        bst.add("Test3");
        assertEquals(3, bst.depth());
        bst.add("Test4");
        bst.add("Test5");
        bst.add("Test6");
        assertEquals(6, bst.depth());
        bst.add("Test0");
        assertEquals(6, bst.depth());
    }
    
    @Test
    public void isEmpty(){       
        assertTrue(bst.isEmpty());
        bst.add("Test2");
        assertFalse(bst.isEmpty());
        bst.add("Test3");
        assertFalse(bst.isEmpty());
    }
    
    @Test
    public void testExists(){
        assertFalse(bst.exists("Test1"));
        bst.add("Test2");
        assertTrue(bst.exists("Test2"));
        bst.add("Test3");
        assertTrue(bst.exists("Test3"));
        
    }
    
    @Test
    public void testRemove(){
        bst.add("Test1");
        bst.add("Test2");
        bst.add("Test3");
        bst.add("Test4");
        assertEquals("Test1",bst.remove("Test1"));
        assertFalse(bst.exists("Test1"));
        assertTrue(bst.exists("Test2"));
        assertEquals("Test2",bst.remove("Test2"));
        assertFalse(bst.exists("Test2"));
        boolean thrown = false;
        try {
        bst.remove("Test");
        } catch (java.util.NoSuchElementException e) {
        thrown = true;
        }
        assertTrue(thrown);
    }
    
    @Test
    public void testDelete(){
        bst.add("12");
        bst.add("15");
        bst.add("44");
        bst.add("4");
        bst.add("8");
        bst.add("6");
        bst.add("9");
        bst.add("22");
        bst.add("10");
        bst.add("20");
        assertEquals("12", bst.removeFirst());
        assertEquals("4", bst.remove("4"));
        assertEquals("44", bst.remove("44"));
        assertEquals("6", bst.remove("6"));
        assertEquals("22", bst.remove("22"));
        assertEquals("20", bst.remove("20"));
        assertEquals("10", bst.remove("10"));
    }
    
    @Test
    public void bstMinFirst(){
        bst.add("Test1");
        bst.add("Test2");
        assertEquals("Test1", bst.removeFirst());
        assertEquals("Test2", bst.min(bst.rootNode));
        bst.add("Test0");
        assertEquals("Test0", bst.min(bst.rootNode));
    }
    
    @Test
    public void bstDelMin(){
        bst.add("Test1");
        bst.add("Test2");
        assertTrue(bst.removeMin(bst.rootNode));
        assertEquals("Test1", bst.min(bst.rootNode));
        bst.add("Test0");
        assertEquals("Test0", bst.min(bst.rootNode));
        assertTrue(bst.removeMin(bst.rootNode));
    }
    
    @Test
    public void testRemoveFirstNoSuch() {
    boolean thrown = false;

    try {
        bst.removeFirst();
        bst.remove("Test");
    } catch (java.util.NoSuchElementException e) {
        thrown = true;
    }

    assertTrue(thrown);
    }
     @Test
    public void testRemoveNoSuch() {
    boolean thrown = false;

    try {
        bst.remove("Test");
    } catch (java.util.NoSuchElementException e) {
        thrown = true;
    }

    assertTrue(thrown);
    }
    
    
    @Test
    public void asListMesano(){
        bst.add("12");
        bst.add("11");
        bst.add("10");
        bst.add("14");
        List<String> test = new ArrayList<String>();
        test.add("10");
        test.add("11");
        test.add("12");
        test.add("14");
        assertEquals(test, bst.asList());
        
    }
    
    @Test
    public void asListVecTest(){
        List<String> test = new ArrayList<String>();
        bst.add("5");
        bst.add("4");
        bst.add("6");
        bst.add("2");
        bst.add("7");
        bst.add("3");
        test.add("2");
        test.add("3");
        test.add("4");
        test.add("5");
        test.add("6");
        test.add("7");
        assertEquals(test, bst.asList());
        
        
    }
    
    @Test
    public void testSeVecRemove(){
        bst.add("6");
        bst.add("5");
        assertEquals("6", bst.removeFirst());
        
    }
    
    @Test
    public void asList(){
        bst.add("Test1");
        bst.add("Test2");
        bst.add("Test3");
        List<String> test = new ArrayList<String>();
        test.add("Test1");
        test.add("Test2"); 
        test.add("Test3");
        assertEquals(test, bst.asList());
        bst.add("Test10");
        test.add("Test10");
        assertEquals(test, bst.asList());
    }
    
    @Test
    public void testJeZeNot() {
    boolean thrown = false;

    try {
        bst.add("2");
        bst.add("2");
    } catch (java.lang.IllegalArgumentException e) {
        thrown = true;
    }

    assertTrue(thrown);
    }
    
    @Test
    public void asListRemove(){
        bst.add("Test1");
        bst.add("Test2");
        bst.add("Test3");
        bst.add("Test5");
        bst.add("Test4");
        List<String> test = new ArrayList<String>();
        test.add("Test1");
        test.add("Test2"); 
        test.add("Test3");
        test.add("Test4");
        test.add("Test5");
        assertEquals(test, bst.asList());
        bst.remove("Test1");
        assertEquals(test, bst.asList());
    }
    
  
    
    @Test
    public void asListEmpty(){
        List<String> test = new ArrayList<String>();
        assertEquals(test, bst.asList());
        bst.add("test");
        bst.removeFirst();
        assertEquals(test, bst.asList());
    }
    
    @Test
    public void testPrint() throws FileNotFoundException, IOException, ClassNotFoundException{
        bst.add("1");
        bst.add("2");
        bst.add("3");
        bst.add("4");
        bst.add("5");
        bst.print();
        
        
        bst.save(new FileOutputStream("novo"));
        bst.restore(new FileInputStream("novo"));
    }
}
