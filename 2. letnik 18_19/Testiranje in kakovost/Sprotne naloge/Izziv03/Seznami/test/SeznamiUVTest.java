/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author User
 */
public class SeznamiUVTest {

    public SeznamiUVTest() {
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

    @Test
    public void testPushBasic() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testPushBasic");
        assertEquals("OK", uv.processInput("push Test1"));
        assertEquals("OK", uv.processInput("push Test2"));
    }

    @Ignore("To be implemented at a later stage")
    @Test
    public void testPushMultipleWords() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testPushMultipleWords");
        assertEquals("OK",
                uv.processInput("push \"Test with multiple words\""));
        assertEquals("1", uv.processInput("count"));
        assertEquals("OK", uv.processInput(
                "push \"Another test with multiple words\""));
        assertEquals("2", uv.processInput("count"));
    }

    @Test
    public void testPushNothing() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testPushNothing");
        assertEquals("Error: please specify a string",
                uv.processInput("push"));
    }

    @Test
    public void testPopBasic() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testPopBasic");
        assertEquals("OK", uv.processInput("push Test1"));
        assertEquals("OK", uv.processInput("push Test2"));
        assertEquals("Test2", uv.processInput("pop"));
        assertEquals("Test1", uv.processInput("pop"));
    }

    @Ignore("To be implemented at a later stage")
    @Test
    public void testPopMultipleWords() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testPopMultipleWords");
        assertEquals("OK", uv.processInput(
                "push \"Test with multiple words\""));
        assertEquals("OK", uv.processInput(
                "push \"Another test with multiple words\""));
        assertEquals("2", uv.processInput("count"));
        assertEquals("Another test with multiple words",
                uv.processInput("pop"));
        assertEquals("1", uv.processInput("count"));
        assertEquals("Test with multiple words",
                uv.processInput("pop"));
        assertEquals("0", uv.processInput("count"));
    }

    @Test
    public void testPopNothing() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testPopNothing");
        assertEquals("Error: stack is empty",
                uv.processInput("pop"));
        assertEquals("Error: please specify a string",
                uv.processInput("push"));
        assertEquals("Error: stack is empty",
                uv.processInput("pop"));
    }

    @Test
    public void testResetOnEmpty() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testResetOnEmpty");
        assertEquals("OK", uv.processInput("reset"));
    }

    @Test
    public void testResetOnFull() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testResetOnFull");
        assertEquals("OK", uv.processInput("push Test"));
        assertEquals("OK", uv.processInput("reset"));
        assertEquals("Error: stack is empty",
                uv.processInput("pop"));
        assertEquals("0", uv.processInput("count"));
    }

    @Test
    public void testCountOnEmpty() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testCountOnEmpty");
        assertEquals("0", uv.processInput("count"));
    }

    @Test(timeout=100)
    public void testCountOne() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testCountOne");
        assertEquals("OK", uv.processInput("push Test"));
        assertEquals("1", uv.processInput("count"));
    }

    @Test(timeout=100)
    public void testCountTwo() {
        SeznamiUV uv = new SeznamiUV();
        System.out.println("testCountTwo");
        assertEquals("OK", uv.processInput("push Test1"));
        assertEquals("OK", uv.processInput("push Test2"));
        assertEquals("2", uv.processInput("count"));
    }

}
