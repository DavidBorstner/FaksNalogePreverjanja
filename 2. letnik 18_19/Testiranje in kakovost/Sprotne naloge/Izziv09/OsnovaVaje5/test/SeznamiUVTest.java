
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.*;
import static org.junit.Assert.*;

public class SeznamiUVTest {

    private SeznamiUV uv;

    public SeznamiUVTest() {
    }

    @Before
    public void setUp() {
        uv = new SeznamiUV();
        uv.addImpl("sk", new Sklad<String>());
        uv.addImpl("pv", new PrioritetnaVrsta<String>());
        uv.addImpl("bst", new Bst<String>());
    }

    @Test
    public void testAddMemoryFullMock() throws IOException {
        uv.addImpl("skmock", new SkladMock<String>());
        assertEquals("OK", uv.processInput("use skmock"));
        assertEquals("Error: not enough memory, operation failed",
        uv.processInput("add Test"));
    }

    // TO DO 
    // razsirite integracijske teste za metodo Use
    @Test
    public void testUse() throws IOException {
        assertEquals("Error: please specify a data structure type {pv|sk|bst|23}", uv.processInput("use"));
        assertEquals("OK", uv.processInput("use pv"));
        assertEquals("OK", uv.processInput("use sk"));
        assertEquals("OK", uv.processInput("use bst"));
        assertEquals("OK", uv.processInput("use bst"));
        assertEquals("Error: please specify a correct data structure type {pv|sk|bst|23}", uv.processInput("use sr"));
    }

    @Test
    public void testAddMemoryFull() throws IOException {
        try {
            assertEquals("OK", uv.processInput("use sk"));
            while (true) {
                uv.processInput("add Test");
            }
        } catch (OutOfMemoryError ex) {
            Logger.getLogger(SeznamiUVTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test

    // TO DO
    // napišite teste za sklad, prioritetno vrsto in BS drevo
    // testi kličejo (zaporedoma) vse operacije nad določeno strukturo 
    // glej POMOZNE METODE
    @Test
    public void testUseSklad() throws IOException {
        assertEquals("Error: please specify a data structure type {pv|sk|bst|23}", uv.processInput("use"));

        assertEquals("OK", uv.processInput("use sk"));
        uv.seznam.add("Test1");
        uv.seznam.add("Test2");
        uv.seznam.add("Test3");
        assertTrue(uv.seznam.exists("Test1"));
        assertFalse(uv.seznam.exists("T"));
        assertEquals(3, uv.seznam.depth());
        assertEquals("Test3", uv.seznam.getFirst());
        assertEquals("Test1", uv.seznam.remove("Test1"));
        assertEquals(2, uv.seznam.depth());
    }

    @Test
    public void testUsePrioritetnaVrsta() throws IOException {
        assertEquals("Error: please specify a data structure type {pv|sk|bst|23}", uv.processInput("use"));
        assertEquals("OK", uv.processInput("use pv"));
        uv.seznam.add("Test1");
        uv.seznam.add("Test2");
        uv.seznam.add("Test3");
        assertTrue(uv.seznam.exists("Test1"));
        assertFalse(uv.seznam.exists("T"));
        assertEquals(2, uv.seznam.depth());
        assertEquals("Test3", uv.seznam.getFirst());
        assertEquals("Test1", uv.seznam.remove("Test1"));
        assertEquals(2, uv.seznam.depth());
    }

    @Test
    public void testUseBst() throws IOException {
        assertEquals("Error: enter command", uv.processInput(""));
        assertEquals("Error: please specify a data structure type {pv|sk|bst|23}", uv.processInput("use"));
        assertEquals("OK", uv.processInput("use bst"));
        uv.seznam.add("Test1");
        uv.seznam.add("Test2");
        uv.seznam.add("Test3");
        assertTrue(uv.seznam.exists("Test1"));
        assertFalse(uv.seznam.exists("T"));
        assertEquals(3, uv.seznam.depth());
        assertEquals("Test1", uv.seznam.getFirst());
        assertEquals("Test1", uv.seznam.remove("Test1"));
        assertEquals(2, uv.seznam.depth());
    }

    @Test
    public void testreset() throws IOException {
        assertEquals("Error: enter command", uv.processInput(""));
        assertEquals("Error: please specify a data structure type {pv|sk|bst|23}", uv.processInput("use"));
        assertEquals("OK", uv.processInput("use bst"));
        uv.seznam.add("Test1");
        uv.seznam.add("Test2");
        uv.seznam.add("Test3");
        uv.processInput("reset");
        assertTrue(uv.seznam.isEmpty());
    }

    @Test
    public void removeF() throws IOException {
        assertEquals("OK", uv.processInput("use bst"));
        assertEquals("OK", uv.processInput("add Test"));
        assertEquals("Test", uv.processInput("remove_first"));
        assertEquals("Error: data structure is empty", uv.processInput("remove_first"));
        assertEquals("Error: please specify a string", uv.processInput("add"));
        assertEquals("Error: data structure is empty", uv.processInput("remove_first"));
    }

    @Test
    public void getF() throws IOException {
        assertEquals("OK", uv.processInput("use bst"));
        assertEquals("OK", uv.processInput("add Test"));
        assertEquals("Test", uv.processInput("getfirst"));
        uv.processInput("remove_first");
        assertEquals("Error: data structure is empty", uv.processInput("getfirst"));
        assertEquals("Error: please specify a string", uv.processInput("add"));
        assertEquals("Error: data structure is empty", uv.processInput("getfirst"));
    }

    @Test
    public void sizeT() throws IOException {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst|23})", uv.processInput("size"));
        assertEquals("OK", uv.processInput("use bst"));
        assertEquals("0", uv.processInput("size"));
        assertEquals("OK", uv.processInput("add Test"));
        assertEquals("1", uv.processInput("size"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("2", uv.processInput("size"));
    }

    @Test
    public void depthT() throws IOException {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst|23})", uv.processInput("size"));
        assertEquals("OK", uv.processInput("use bst"));
        assertEquals("0", uv.processInput("depth"));
        assertEquals("OK", uv.processInput("add Test"));
        assertEquals("1", uv.processInput("depth"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("2", uv.processInput("depth"));
    }

    @Test
    public void emptyT() throws IOException {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst|23})", uv.processInput("size"));
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
    public void existsT() throws IOException {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst|23})", uv.processInput("size"));
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
    public void removeT() throws IOException {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst|23})", uv.processInput("size"));
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
    public void asList() throws IOException {
        assertEquals("OK", uv.processInput("use bst"));
        uv.seznam.add("Test1");
        uv.seznam.add("Test2");
        uv.seznam.add("Test3");
        assertEquals("Test1, Test2, Test3", uv.processInput("asList"));
    }

    @Test
    public void invalidCommandT() throws IOException {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst|23})", uv.processInput("size"));
        assertEquals("OK", uv.processInput("use pv"));
        assertEquals("Error: invalid command", uv.processInput("test"));
        assertEquals("Error: invalid command", uv.processInput("test1"));
        assertEquals("Error: please specify a correct data structure type {pv|sk|bst|23}", uv.processInput("use use"));

    }

    // *****************
    // POMOZNE METODE
    // *****************
    public void reset() throws IOException {
        uv.processInput("reset");
    }

    public void testAdd() throws IOException {
        assertEquals("Error: enter command", uv.processInput(""));
        assertEquals("Error: please specify a string", uv.processInput("add"));
        assertEquals("Error: please specify a data structure (use {pv|sk|bst|23})", uv.seznam);
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test2 Test3"));
        assertEquals("Error: please specify a string", uv.processInput("add"));

    }

    public void testAddNothing() {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst|23})", uv.seznam);
        try {
            assertEquals("Error: please specify a string", uv.processInput("add"));
        } catch (IOException ex) {
            Logger.getLogger(SeznamiUVTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void testRemoveFirst() throws IOException {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst|23})", uv.seznam);
        assertEquals("OK", uv.processInput("add Test"));
        assertEquals("Test", uv.processInput("remove_first"));
    }

    public void testRemoveFirstNothing() throws IOException {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst|23})", uv.seznam);
        assertEquals("Error: data structure is empty", uv.processInput("remove_first"));
        assertEquals("Error: please specify a string", uv.processInput("add"));
        assertEquals("Error: data structure is empty", uv.processInput("remove_first"));
    }

    public void testGetFirst() throws IOException {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst|23})", uv.seznam);
        assertEquals("OK", uv.processInput("add Test"));
        assertEquals("Test", uv.processInput("get_first"));
    }

    public void testGetFirstNothing() throws IOException {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst|23})", uv.seznam);
        assertEquals("Error: data structure is empty", uv.processInput("get_first"));
        assertEquals("Error: please specify a string", uv.processInput("add"));
        assertEquals("Error: data structure is empty", uv.processInput("get_first"));
    }

    public void testSizeOnEmpty() throws IOException {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst|23})", uv.seznam);
        assertEquals("0", uv.processInput("size"));
    }

    public void testSizeOne() throws IOException {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst|23})", uv.seznam);
        assertEquals("OK", uv.processInput("add Test"));
        assertEquals("1", uv.processInput("size"));
    }

    public void testSizeTwo() throws IOException {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst|23})", uv.seznam);
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("2", uv.processInput("size"));
    }

    public void testDepthOnEmpty() throws IOException {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst|23})", uv.seznam);
        assertEquals("0", uv.processInput("depth"));
    }

    public void testDepthOne() throws IOException {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst|23})", uv.seznam);
        try {
            assertEquals("OK", uv.processInput("add Test"));
        } catch (IOException ex) {
            Logger.getLogger(SeznamiUVTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals("1", uv.processInput("depth"));
    }

    public void testDepthTwo() {
        try {
            assertEquals("Error: please specify a data structure (use {pv|sk|bst|23})", uv.seznam);
            assertEquals("OK", uv.processInput("add Test1"));
            try {
                assertEquals("OK", uv.processInput("add "
                        + "Test2"));
            } catch (IOException ex) {
                Logger.getLogger(SeznamiUVTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            assertEquals("2", uv.processInput("depth"));
        } catch (IOException ex) {
            Logger.getLogger(SeznamiUVTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void testIsEmptyEmpty() throws IOException {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst|23})", uv.seznam);
        assertEquals("Data structure is empty.", uv.processInput("is_empty"));
        assertEquals("Error: please specify a string", uv.processInput("add"));
        assertEquals("Data structure is empty.", uv.processInput("is_empty"));
    }

    public void testIsEmptyNotEmpty() throws IOException {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst|23})", uv.seznam);
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("OK", uv.processInput("add Test3"));
        assertEquals("Data structure is not empty.", uv.processInput("is_empty"));
    }

    public void testResetOnEmpty() throws IOException {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst|23})", uv.seznam);
        try {
            assertEquals("OK", uv.processInput("reset"));
        } catch (IOException ex) {
            Logger.getLogger(SeznamiUVTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void testResetOnFull() throws IOException {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst|23})", uv.seznam);
        assertEquals("OK", uv.processInput("add Test"));
        assertEquals("OK", uv.processInput("reset"));
        assertEquals("Error: data structure is empty", uv.processInput("remove_first"));
        assertEquals("0", uv.processInput("size"));
    }

    // TO DO
    public void testExists() {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst|23})", uv.seznam);
        fail("To funkcijo morate implementirati!");
    }

    // TO DO
    public void testRemove() {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst|23})", uv.seznam);
        fail("To funkcijo morate implementirati!");
    }

    @Test
    public void testPrint() throws IOException {
        assertEquals("OK", uv.processInput("use bst"));
        assertEquals("OK", uv.processInput("add Test"));
        assertEquals("OK", uv.processInput("print"));
        assertEquals("OK", uv.processInput("save novo"));
        assertEquals("Error: please specify a file name", uv.processInput("save"));
        assertEquals("Error: please specify a file name", uv.processInput("restore"));
        assertEquals("OK", uv.processInput("restore novo"));
    }

    public void testAddTestSequence() throws IOException {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst|23})", uv.seznam);
        assertEquals("OK", uv.processInput("add Test4"));
        assertEquals("OK", uv.processInput("add Test2"));
        assertEquals("OK", uv.processInput("add Test3"));
        assertEquals("OK", uv.processInput("add Test1"));
        assertEquals("OK", uv.processInput("add Test5"));
    }

    @Test
    public void testExit() throws IOException {
        assertEquals("Have a nice day.", uv.processInput("exit"));
    }

    public void testSklad(boolean add) throws IOException {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst|23})", uv.seznam);
        if (add) {
            testAddTestSequence();
        }
        try {
            assertEquals("Test5", uv.processInput("remove_first"));
        } catch (IOException ex) {
            Logger.getLogger(SeznamiUVTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals("Test1", uv.processInput("remove_first"));
        assertEquals("Test3", uv.processInput("remove_first"));
        assertEquals("Test2", uv.processInput("remove_first"));
        assertEquals("Test4", uv.processInput("remove_first"));
    }

    public void testPrioritetnaVrsta(boolean add) throws IOException {
        assertEquals("Error: please specify a data structure (use {pv|sk|bst|23})", uv.seznam);
        if (add) {
            testAddTestSequence();
        }
        assertEquals("Test5", uv.processInput("remove_first"));
        assertEquals("Test4", uv.processInput("remove_first"));
        assertEquals("Test3", uv.processInput("remove_first"));

    }

    public void testBst(boolean add) throws IOException {
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
