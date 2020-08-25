import static org.junit.Assert.*;
import org.junit.*;
public class SkladTest {
public SkladTest() {
}
@Test
public void testPush() {
Sklad instance = new Sklad();
String a = "Test";
instance.push(a);
}
@Test
public void testPop() {
Sklad<String> instance = new Sklad<>();
String a = "Test";
instance.push(a);
String b = instance.pop();
assertEquals("Test", b);
}

@Test
public void testWithTwoElements()
{
Sklad<String> instance = new Sklad<>();
String a = "Prvi test";
String b = "Drugi test";
instance.push(a);
instance.push(b);
assertEquals(b, instance.pop());
assertEquals(a, instance.pop());
}

@Test
public void testIsEmptyOnEmpty() {
Sklad<String> instance = new Sklad<>();
assertTrue(instance.isEmpty());
}
@Test
public void testIsEmptyOnFull() {
Sklad<String> instance = new Sklad<>();
instance.push("Test");
assertFalse(instance.isEmpty());
}

@Test
public void testTop0()
{
Sklad<String> instance = new Sklad<>();
String a = "Prvi test";
String b = "Drugi test";
instance.push(b);
assertEquals(b, instance.top());
instance.push(a);
assertEquals(a, instance.top());
}

@Test
public void testTop1()
{
Sklad<String> instance = new Sklad<>();
String a = "Prvi test";
instance.push(a);
assertEquals(1, instance.size());
assertEquals(a, instance.top());
}

@Test
public void testTop2()
{
Sklad<String> instance = new Sklad<>();
String a = "Prvi test";
String b = "Drugi test";
instance.push(b);
assertEquals(1, instance.size());
assertEquals(b, instance.top());
instance.push(a);
assertEquals(2, instance.size());
assertEquals(a, instance.top());
}

@Test
public void testSize0()
{
Sklad<String> instance = new Sklad<>();
String a = "Prvi test";
String b = "Drugi test";
String c = "Tretji test";
String d = "Cetrti test";
String e = "Peti test";
instance.push(a);
instance.push(b);
instance.push(c);
instance.push(d);
assertEquals(4, instance.size());
instance.push(e);
assertEquals(5,instance.size());
}

@Test
public void testSize1()
{
Sklad<String> instance = new Sklad<>();
String a = "Prvi test";
String b = "Drugi test";
String c = "Tretji test";
String d = "Cetrti test";
String e = "Peti test";
instance.push(a);
instance.push(b);
instance.push(c);
instance.push(d);
assertEquals(4, instance.size());
instance.push(e);
assertEquals(e, instance.top());
assertEquals(5,instance.size());
assertEquals(e,instance.top());
}
}