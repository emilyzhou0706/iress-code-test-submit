package test.java.iress.code;

import main.java.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    public ByteArrayOutputStream outContent;

    @BeforeEach
    public void init(){
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void turnLeftOnlyTest() throws IOException {
        String[] args = null;
        final FileInputStream fips = new FileInputStream(new File("src/main/resources/turnLeftOnly.txt"));
        System.setIn(fips);
        Main.main(args);
        String result=Arrays.asList(outContent.toString("UTF-8").split(("\\r?\\n"))).get(3);
        assertEquals("I am at location x= 0 y=0 facing NORTH",result);
    }

    @Test
    public void turnRightOnlyTest() throws IOException {
        String[] args = null;
        final FileInputStream fips = new FileInputStream(new File("src/main/resources/turnRightOnly.txt"));
        System.setIn(fips);
        Main.main(args);
        String result=Arrays.asList(outContent.toString("UTF-8").split(("\\r?\\n"))).get(3);
        assertEquals("I am at location x= 0 y=0 facing SOUTH",result);
    }

    @Test
    public void validMoveTest() throws IOException {
        String[] args = null;
        final FileInputStream fips = new FileInputStream(new File("src/main/resources/moveOnlyValid.txt"));
        System.setIn(fips);
        Main.main(args);
        String result=Arrays.asList(outContent.toString("UTF-8").split(("\\r?\\n"))).get(3);
        assertEquals("I am at location x= 1 y=0 facing EAST",result);
    }

    @Test
    public void invalidMoveTest() throws IOException {
        String[] args = null;
        final FileInputStream fips = new FileInputStream(new File("src/main/resources/moveInvalid.txt"));
        System.setIn(fips);
        Main.main(args);
        String result=Arrays.asList(outContent.toString("UTF-8").split(("\\r?\\n"))).get(6);
        assertEquals("I am at location x= 0 y=0 facing WEST",result);
    }

    @Test
    public void placeOnlyInvalidTest() throws IOException {
        String[] args = null;
        final FileInputStream fips = new FileInputStream(new File("src/main/resources/placeOnlyInvalid.txt"));
        System.setIn(fips);
        Main.main(args);
        String result=Arrays.asList(outContent.toString("UTF-8").split(("\\r?\\n"))).get(4);
        assertEquals("I am at location x= 0 y=0 facing EAST",result);
    }

    @Test
    public void placeOnlyValidTest() throws IOException {
        String[] args = null;
        final FileInputStream fips = new FileInputStream(new File("src/main/resources/placeOnlyValid.txt"));
        System.setIn(fips);
        Main.main(args);
        String result=Arrays.asList(outContent.toString("UTF-8").split(("\\r?\\n"))).get(3);
        assertEquals("I am at location x= 2 y=3 facing NORTH",result);
    }

    @Test
    public void mainMulActionTest() throws IOException {
        String[] args = null;
        final FileInputStream fips = new FileInputStream(new File("src/main/resources/mainMulAction.txt"));
        System.setIn(fips);
        Main.main(args);
        String result=Arrays.asList(outContent.toString("UTF-8").split(("\\r?\\n"))).get(9);
        assertEquals("I am at location x= 2 y=3 facing NORTH",result);
    }


}
