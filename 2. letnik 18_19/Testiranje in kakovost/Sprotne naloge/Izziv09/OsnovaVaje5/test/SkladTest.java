
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.easymock.EasyMock;
import org.junit.*;
import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

public class SkladTest {

    static Sklad<String> instance;

    public SkladTest() {
    }

    @BeforeClass
    public static void setUpOnce() {
        instance = new Sklad<>();
    }

    @Before
    public void setUp() {
        while (!instance.isEmpty()) {
            instance.pop();
        }
    }
    
    public interface ProstorZaSave { String dodajNekaj(String dodaj) throws IOException; }
    
    @Test
    public void testEasyMockSklad() throws IOException {
        ProstorZaSave mock = EasyMock.createMock(ProstorZaSave.class);
        expect(mock.dodajNekaj("dodaj")).andReturn(null);
        replay(mock);
        int stevec = 0;
        try { 
            while(true){
                mock.dodajNekaj(Integer.toString(stevec));
                stevec++;
            }
        } catch (OutOfMemoryError e) {
            throw(e);
        }
    }
    
    @Test
    public void testMockNadomestniRazred() throws IOException{
        int stevec = 0;
        try { 
            while(true){
                instance.push(Integer.toString(stevec));
                stevec++;
            }
        } catch (OutOfMemoryError e) {
            throw(e);
        }
    }
    
    @Test
    public void testRemoveFirst(){
        instance.push("Test");
        assertEquals("Test", instance.removeFirst());
    }
    
    @Test
    public void testPrintSaveRestore() throws FileNotFoundException, IOException, ClassNotFoundException{
        instance.print();
        instance.save(new FileOutputStream("novo"));
        instance.push("Test");
        instance.push("Test2");
        instance.print();
        try {
            instance.save(new FileOutputStream("novo"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SkladTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        instance.restore(new FileInputStream("novo"));
    }
    
    @Test
    public void testPush() {
        String a = "Test";
        instance.push(a);
    }

    @Test
    public void testPop() {
        String a = "Test";
        instance.push(a);
        String b = instance.pop();
        assertEquals("Test", b);
    }

    @Test
    public void testWithTwoElements() {
        String a = "Prvi element";
        String b = "Drugi element";
        instance.push(a);
        instance.push(b);
        assertEquals(b, instance.pop());
        assertEquals(a, instance.pop());
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void testPopOnEmptyStack() {
        String a = instance.pop();
    }

    @Test
    public void testIsEmptyOnEmpty() {
        assertTrue(instance.isEmpty());
    }

    @Test
    public void testIsEmptyOnFull() {
        instance.push("Test");
        assertFalse(instance.isEmpty());
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void testTopOnEmptyStack() {
        String a = instance.top();
    }

    @Test
    public void testTopOnFullStack() {
        String a = "Vrednost 1";
        String b = "Vrednost 2";
        instance.push(a);
        instance.push(b);
        String c = instance.top();
        assertEquals(c, b);
    }

    @Test
    public void testTopSame() {
        instance.push("Test1");
        instance.push("Test2");
        instance.push("Test3");
        assertEquals("Test3", instance.top());
        assertEquals("Test3", instance.pop());
        assertEquals("Test2", instance.pop());
        assertEquals("Test1", instance.pop());
        assertTrue(instance.isEmpty());
    }

    @Test
    public void testSizeEmpty() {
        assertEquals(0, instance.size());
    }

    @Test(timeout = 100)
    public void testSizeNonEmpty() {
        instance.push("Vrednost 1");
        instance.push("Vrednost 2");
        instance.push("Vrednost 3");
        assertEquals(3, instance.size());
    }

    @Test
    public void testSizeSame() {
        instance.push("Test1");
        instance.push("Test2");
        instance.push("Test3");
        assertEquals(3, instance.size());
        assertEquals("Test3", instance.pop());
        assertEquals("Test2", instance.pop());
        assertEquals("Test1", instance.pop());
        assertTrue(instance.isEmpty());
    }

    @Test
    public void testIsTopTrue() {
        instance.push("Test");
        assertTrue(instance.isTop("Test"));
    }

    @Test
    public void testIsTopFalse() {
        instance.push("Test1");
        assertFalse(instance.isTop("Test2"));
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void testIsTopEmpty() {
        assertFalse(instance.isTop("Test"));
    }

    @Test
    public void testIsTopSame() {
        instance.push("Test1");
        instance.push("Test2");
        instance.push("Test3");
        assertTrue(instance.isTop("Test3"));
        assertEquals("Test3", instance.pop());
        assertEquals("Test2", instance.pop());
        assertEquals("Test1", instance.pop());
        assertTrue(instance.isEmpty());
    }

    @Test
    public void testSearchEmpty() {
        assertEquals(-1, instance.search("Test"));
    }

    @Test(timeout = 100)
    public void testSearchFoundTop() {
        instance.push("Vrednost 1");
        instance.push("Vrednost 2");
        instance.push("Vrednost 3");
        assertEquals(0, instance.search("Vrednost 3"));
    }

    @Test(timeout = 100)
    public void testSearchFoundNonTop() {
        instance.push("Vrednost 1");
        instance.push("Vrednost 2");
        instance.push("Vrednost 3");
        assertEquals(2, instance.search("Vrednost 1"));
    }

    @Test(timeout = 100)
    public void testSearchNotFound() {
        instance.push("Vrednost 1");
        instance.push("Vrednost 2");
        instance.push("Vrednost 3");
        assertEquals(-1, instance.search("Vrednost"));
    }

    @Test
    public void testSearchSame() {
        instance.push("Test1");
        instance.push("Test2");
        instance.push("Test3");
        assertEquals(1, instance.search("Test2"));
        assertEquals("Test3", instance.pop());
        assertEquals("Test2", instance.pop());
        assertEquals("Test1", instance.pop());
        assertTrue(instance.isEmpty());
    }

    // Testi za add, removeFirst, getFirst, size in depth
    // so izpuščeni, ker gre le za klice že testiranih metod! 
    
    // TO DO
    // Testi za remove() in exists() ...
    
    
    @Test
    public void testRemove() {
        assertEquals(null, instance.remove("Test2"));
        instance.push("Test1");
        instance.push("Test2");
        instance.push("Test3");
        assertEquals("Test2", instance.remove("Test2"));
        assertEquals("Test3", instance.pop());
        assertEquals("Test1", instance.pop());
        assertTrue(instance.isEmpty());
    }
    
    @Test
    public void testRemoveVse() {
        instance.push("Test1");
        instance.push("Test2");
        instance.push("Test3");
        assertEquals("Test2", instance.remove("Test2"));
        assertEquals("Test3", instance.remove("Test3"));
        assertEquals("Test1", instance.remove("Test1"));
        assertTrue(instance.isEmpty());
    }
    
    @Test
    public void testExists() {
        instance.push("Test1");
        instance.push("Test2");
        instance.push("Test3");
        assertTrue(instance.exists("Test2"));
        assertTrue(instance.exists("Test3"));
        assertFalse(instance.exists("Test4"));
    }
    
    @Test
    public void testRemoveExists() {
        instance.push("Test1");
        instance.push("Test2");
        instance.push("Test3");
        assertEquals("Test2", instance.remove("Test2"));
        assertFalse(instance.exists("Test2"));
        assertTrue(instance.exists("Test3"));
        assertEquals("Test3", instance.remove("Test3"));
        assertFalse(instance.exists("Test3"));
    }
    
    @Test
    public void asList() {
        instance.push("Test1");
        instance.push("Test2");
        instance.push("Test3");
        List<String> test = new ArrayList<String>();
        test.add("Test3");
        test.add("Test2");
        test.add("Test1");
        assertEquals(test, instance.asList());        
        instance.remove("Test2");
        test.remove("Test2");
        assertEquals(test, instance.asList());
    }
    
    @Test
    public void asListEmpty(){
        List<String> test = new ArrayList<String>();
        assertEquals(test,instance.asList());
        
        test.add("Test1");
        test.remove("Test1");
        instance.push("Test3");
        instance.pop();
        assertEquals(test,instance.asList());
    }
}
