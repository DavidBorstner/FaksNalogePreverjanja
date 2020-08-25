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
        bst.remove("Test1");
        assertFalse(bst.exists("Test1"));
        assertTrue(bst.exists("Test2"));
        bst.remove("Test2");
        assertFalse(bst.exists("Test2"));
    }
    
}
