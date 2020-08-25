
import org.junit.*;
import static org.junit.Assert.*;

public class SeznamiUVTest {

    private SeznamiUV uv;

    public SeznamiUVTest() {
    }

    @Before
    public void setUp() {
        uv = new SeznamiUV();
    }

    // TO DO 
    // razsirite integracijske teste za metodo Use
    @Test
    public void testUse() {
        assertEquals("Error: please specify a data structure type {pv|sk|bst}", uv.processInput("use"));
        assertEquals("OK", uv.processInput("use pv"));
        assertEquals("OK", uv.processInput("use sk"));
        assertEquals("OK", uv.processInput("use bst"));
        assertEquals("OK", uv.processInput("use bst"));
        assertEquals("Error: please specify a correct data structure type {pv|sk|bst}", uv.processInput("use sr"));
    }

    // TO DO
    // napišite teste za sklad, prioritetno vrsto in BS drevo
    // testi kličejo (zaporedoma) vse operacije nad določeno strukturo 
    // glej POMOZNE METODE

    @Test
    public void testUseSklad() {
        assertEquals("Error: please specify a data structure type {pv|sk|bst}", uv.processInput("use"));
        
        assertEquals("OK", uv.processInput("use sk"));
        uv.seznam.add("Test1");
        uv.seznam.add("Test2");
        uv.seznam.add("Test3");
        assertTrue(uv.seznam.exists("Test1"));
        assertFalse(uv.seznam.exists("T"));
        assertEquals(3,uv.seznam.depth());
        assertEquals("Test3",uv.seznam.getFirst());
        assertEquals("Test1",uv.seznam.remove("Test1"));
        assertEquals(2,uv.seznam.depth());
    }

    @Test
    public void testUsePrioritetnaVrsta() {
        assertEquals("Error: please specify a data structure type {pv|sk|bst}", uv.processInput("use"));
        assertEquals("OK", uv.processInput("use pv"));
         uv.seznam.add("Test1");
        uv.seznam.add("Test2");
        uv.seznam.add("Test3");
        assertTrue(uv.seznam.exists("Test1"));
        assertFalse(uv.seznam.exists("T"));
        assertEquals(2,uv.seznam.depth());
        assertEquals("Test3",uv.seznam.getFirst());
        assertEquals("Test1",uv.seznam.remove("Test1"));
        assertEquals(2,uv.seznam.depth());
    }

    @Test
    public void testUseBst() {
        assertEquals("Error: enter command", uv.processInput(""));
        assertEquals("Error: please specify a data structure type {pv|sk|bst}", uv.processInput("use"));
        assertEquals("OK", uv.processInput("use bst"));
         uv.seznam.add("Test1");
        uv.seznam.add("Test2");
        uv.seznam.add("Test3");
        assertTrue(uv.seznam.exists("Test1"));
        assertFalse(uv.seznam.exists("T"));
        assertEquals(3,uv.seznam.depth());
        assertEquals("Test1",uv.seznam.getFirst());
        assertEquals("Test1",uv.seznam.remove("Test1"));
        assertEquals(2,uv.seznam.depth());
    }

    @Test
    public void testreset(){
        assertEquals("Error: enter command", uv.processInput(""));
        assertEquals("Error: please specify a data structure type {pv|sk|bst}", uv.processInput("use"));
        assertEquals("OK", uv.processInput("use bst"));
         uv.seznam.add("Test1");
        uv.seznam.add("Test2");
        uv.seznam.add("Test3");
        uv.processInput("reset");
        assertTrue(uv.seznam.isEmpty());
    }
    
    @Test
    public void removeF(){
        assertEquals("OK", uv.processInput("use bst"));  
        assertEquals("OK", uv.processInput("add Test"));
        assertEquals("Test", uv.processInput("remove_first"));
        assertEquals("Error: data structure is empty", uv.processInput("remove_first"));
        assertEquals("Error: please specify a string", uv.processInput("add"));
        assertEquals("Error: data structure is empty", uv.processInput("remove_first"));
    }
    
    @Test
    public void getF(){
        assertEquals("OK", uv.processInput("use bst"));  
        assertEquals("OK", uv.processInput("add Test"));
        assertEquals("Test", uv.processInput("getfirst"));
        uv.processInput("remove_first");
        assertEquals("Error: data structure is empty", uv.processInput("getfirst"));
        assertEquals("Error: please specify a string", uv.processInput("add"));
        assertEquals("Error: data structure is empty", uv.processInput("getfirst"));
    }
    
    @Test
    public void sizeT(){
        assertEquals("Error: please specify a data structure (use {pv|sk|bst})", uv.processInput("size"));
        assertEquals("OK", uv.processInput("use bst"));
        assertEquals("0", uv.processInput("size"));
        assertEquals("OK", uv.processInput("add Test"));
        assertEquals("1", uv.processInput("size"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("2", uv.processInput("size"));
    }
    
    @Test
    public void depthT(){
        assertEquals("Error: please specify a data structure (use {pv|sk|bst})", uv.processInput("size"));
        assertEquals("OK", uv.processInput("use bst"));
        assertEquals("0", uv.processInput("depth"));
        assertEquals("OK", uv.processInput("add Test"));
        assertEquals("1", uv.processInput("depth"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("2", uv.processInput("depth"));
    }
    
    @Test
    public void emptyT(){
        assertEquals("Error: please specify a data structure (use {pv|sk|bst})", uv.processInput("size"));
        assertEquals("OK", uv.processInput("use bst"));
        assertEquals("Data structure is empty.", uv.processInput("is_empty"));
        assertEquals("Error: please specify a string", uv.processInput("add"));
        assertEquals("Data structure is empty.", uv.processInput("is_empty"));
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("OK", uv.processInput("add Test3"));
        assertEquals("Data structure is not empty.", uv.processInput("is_empty"));    
    }
    
    @Test
    public void existsT(){
        assertEquals("Error: please specify a data structure (use {pv|sk|bst})", uv.processInput("size"));
        assertEquals("OK", uv.processInput("use pv"));
        assertEquals("Data structure is empty.", uv.processInput("is_empty"));
        assertEquals("Error: please specify a string", uv.processInput("exists"));   
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("OK", uv.processInput("add Test3"));
        assertEquals("OK", uv.processInput("add Test4"));
        assertEquals("Data structure is not empty.", uv.processInput("is_empty")); 
        assertEquals("Error: data structure is empty", uv.processInput("exists preberi")); 
        assertEquals("Element doesn't exist in data structure.", uv.processInput("exists Test1 Test2"));  
    }
    
     @Test
    public void removeT(){
        assertEquals("Error: please specify a data structure (use {pv|sk|bst})", uv.processInput("size"));
        assertEquals("OK", uv.processInput("use pv"));
        assertEquals("Data structure is empty.", uv.processInput("is_empty"));
        assertEquals("Error: please specify a string", uv.processInput("exists"));   
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("OK", uv.processInput("add Test3"));
        assertEquals("OK", uv.processInput("add Test4"));
        assertEquals("Error: please specify a string", uv.processInput("remove"));
        assertEquals(null, uv.processInput("remove Test1"));
    }
    
     @Test
    public void invalidCommandT(){
        assertEquals("Error: please specify a data structure (use {pv|sk|bst})", uv.processInput("size"));
        assertEquals("OK", uv.processInput("use pv"));
        assertEquals("Error: invalid command", uv.processInput("test"));
        assertEquals("Error: invalid command", uv.processInput("test1"));
        assertEquals("Error: please specify a correct data structure type {pv|sk|bst}", uv.processInput("use use"));
       
    }
    
    // *****************
    // POMOZNE METODE
    // *****************
    
    public void reset() {
        uv.processInput("reset");
    }

    public void testAdd() {
        assertEquals("Error: enter command", uv.processInput(""));
        assertEquals("Error: please specify a string", uv.processInput("add"));
        assertEquals("Error: please specify a data structure (use {pv|sk|bst})", uv.seznam);
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test2 Test3"));
        assertEquals("Error: please specify a string", uv.processInput("add"));
        
    }

    public void testAddNothing() {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst})", uv.seznam);
        assertEquals("Error: please specify a string", uv.processInput("add"));
    }

    public void testRemoveFirst() {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst})", uv.seznam);
        assertEquals("OK", uv.processInput("add Test"));
        assertEquals("Test", uv.processInput("remove_first"));
    }

    public void testRemoveFirstNothing() {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst})", uv.seznam);
        assertEquals("Error: data structure is empty", uv.processInput("remove_first"));
        assertEquals("Error: please specify a string", uv.processInput("add"));
        assertEquals("Error: data structure is empty", uv.processInput("remove_first"));
    }

    public void testGetFirst() {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst})", uv.seznam);
        assertEquals("OK", uv.processInput("add Test"));
        assertEquals("Test", uv.processInput("get_first"));
    }

    public void testGetFirstNothing() {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst})", uv.seznam);
        assertEquals("Error: data structure is empty", uv.processInput("get_first"));
        assertEquals("Error: please specify a string", uv.processInput("add"));
        assertEquals("Error: data structure is empty", uv.processInput("get_first"));
    }

    public void testSizeOnEmpty() {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst})", uv.seznam);
        assertEquals("0", uv.processInput("size"));
    }

    public void testSizeOne() {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst})", uv.seznam);
        assertEquals("OK", uv.processInput("add Test"));
        assertEquals("1", uv.processInput("size"));
    }

    public void testSizeTwo() {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst})", uv.seznam);
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("2", uv.processInput("size"));
    }

    public void testDepthOnEmpty() {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst})", uv.seznam);
        assertEquals("0", uv.processInput("depth"));
    }

    public void testDepthOne() {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst})", uv.seznam);
        assertEquals("OK", uv.processInput("add Test"));
        assertEquals("1", uv.processInput("depth"));
    }

    public void testDepthTwo() {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst})", uv.seznam);
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("2", uv.processInput("depth"));
    }

    public void testIsEmptyEmpty() {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst})", uv.seznam);
        assertEquals("Data structure is empty.", uv.processInput("is_empty"));
        assertEquals("Error: please specify a string", uv.processInput("add"));
        assertEquals("Data structure is empty.", uv.processInput("is_empty"));
    }

    public void testIsEmptyNotEmpty() {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst})", uv.seznam);
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("OK", uv.processInput("add Test3"));
        assertEquals("Data structure is not empty.", uv.processInput("is_empty"));
    }

    public void testResetOnEmpty() {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst})", uv.seznam);
        assertEquals("OK", uv.processInput("reset"));
    }

    public void testResetOnFull() {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst})", uv.seznam);
        assertEquals("OK", uv.processInput("add Test"));
        assertEquals("OK", uv.processInput("reset"));
        assertEquals("Error: data structure is empty", uv.processInput("remove_first"));
        assertEquals("0", uv.processInput("size"));
    }

    // TO DO
    public void testExists() {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst})", uv.seznam);
        fail("To funkcijo morate implementirati!");
    }

    // TO DO
    public void testRemove() {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst})", uv.seznam);
        fail("To funkcijo morate implementirati!");
    }

    public void testAddTestSequence() {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst})", uv.seznam);
        assertEquals("OK", uv.processInput("add Test4"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("OK", uv.processInput("add Test3"));
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test5"));
    }

    public void testSklad(boolean add) {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst})", uv.seznam);
        if (add) {
            testAddTestSequence();
        }
        assertEquals("Test5", uv.processInput("remove_first"));
        assertEquals("Test1", uv.processInput("remove_first"));
        assertEquals("Test3", uv.processInput("remove_first"));
        assertEquals("Test2", uv.processInput("remove_first"));
        assertEquals("Test4", uv.processInput("remove_first"));
    }

    public void testPrioritetnaVrsta(boolean add) {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst})", uv.seznam);
        if (add) {
            testAddTestSequence();
        }
        assertEquals("Test5", uv.processInput("remove_first"));
        assertEquals("Test4", uv.processInput("remove_first"));
        assertEquals("Test3", uv.processInput("remove_first"));
        assertEquals("Test2", uv.processInput("remove_first"));
        assertEquals("Test1", uv.processInput("remove_first"));
    }

    public void testBst(boolean add) {
        if (add) {
            testAddTestSequence();
        }
        assertEquals("Test4", uv.processInput("remove_first"));
        assertEquals("Test5", uv.processInput("remove_first"));
        assertEquals("Test2", uv.processInput("remove_first"));
        assertEquals("Test3", uv.processInput("remove_first"));
        assertEquals("Test1", uv.processInput("remove_first"));
    }

}
