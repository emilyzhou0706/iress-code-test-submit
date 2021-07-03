package test.java.iress.code;
import main.java.iress.code.constant.Face;
import main.java.iress.code.entity.Robot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotTest {
    Robot robot00North;
    Robot robot00WEST;
    Robot robot00SOUTH;
    Robot robot12North;
    Robot robot12South;
    Robot robot12West;
    Robot robot12East;
    Robot robot55SOUTH;
    Robot robot55EAST;
    Robot robot55NORTH;


    @BeforeEach
    public void init(){
        robot00North=new Robot(0,0,Face.NORTH);
        robot00WEST=new Robot(0,0,Face.WEST);
        robot00SOUTH=new Robot(0,0,Face.SOUTH);
        robot12North=new Robot(1,2,Face.NORTH);
        robot12South=new Robot(1,2,Face.SOUTH);
        robot12West =new Robot(1,2,Face.WEST);
        robot12East =new Robot(1,2,Face.EAST);
        robot55SOUTH=new Robot(5,5,Face.SOUTH);
        robot55EAST =new Robot(5,5,Face.EAST);
        robot55NORTH =new Robot(5,5,Face.NORTH);

    }

    @Test
    public void checkValidTest(){
        assertEquals(true,robot00North.checkValid(1,2));
        assertEquals(true,robot00North.checkValid(5,5));

        assertEquals(false,robot00North.checkValid(-1,2));
        assertEquals(false,robot00North.checkValid(0,-1));

        assertEquals(false,robot00North.checkValid(6,1));
        assertEquals(false,robot00North.checkValid(1,6));
        assertEquals(false,robot00North.checkValid(-1,6));
    }

    @Test
    public void checkPlaceTest(){
        Robot  robot1=robot00North.place(1,2,Face.NORTH);
        assertEquals(robot1,robot1);

        Robot robot2=robot00North.place(-1,2,Face.NORTH);
        assertEquals(robot00North,robot2);
    }

    @Test
    public void moveTest() {
        robot00North.move();
        assertEquals(0,robot00North.getX());
        assertEquals(1,robot00North.getY());
        assertEquals(Face.NORTH,robot00North.getFace());

        robot12North.move();
        assertEquals(1,robot12North.getX());
        assertEquals(3,robot12North.getY());
        assertEquals(Face.NORTH,robot12North.getFace());

        robot12South.move();
        assertEquals(1,robot12South.getX());
        assertEquals(1,robot12South.getY());
        assertEquals(Face.SOUTH,robot12South.getFace());

        robot12West.move();
        assertEquals(0,robot12West.getX());
        assertEquals(2,robot12West.getY());
        assertEquals(Face.WEST,robot12West.getFace());

        robot12East.move();
        assertEquals(2,robot12East.getX());
        assertEquals(2,robot12East.getY());
        assertEquals(Face.EAST,robot12East.getFace());

        robot55SOUTH.move();
        assertEquals(5,robot55SOUTH.getX());
        assertEquals(4,robot55SOUTH.getY());
        assertEquals(Face.SOUTH,robot55SOUTH.getFace());

        //test invalid move
        robot55EAST.move();
        assertEquals(5,robot55EAST.getX());
        assertEquals(5,robot55EAST.getY());
        assertEquals(Face.EAST,robot55EAST.getFace());

        //test invalid move
        robot55NORTH.move();
        assertEquals(5,robot55NORTH.getX());
        assertEquals(5,robot55NORTH.getY());
        assertEquals(Face.NORTH,robot55NORTH.getFace());

        //test invalid move
        robot55NORTH.move();
        assertEquals(5,robot55NORTH.getX());
        assertEquals(5,robot55NORTH.getY());
        assertEquals(Face.NORTH,robot55NORTH.getFace());

        //test invalid move
        robot00SOUTH.move();
        assertEquals(0,robot00SOUTH.getX());
        assertEquals(0,robot00SOUTH.getY());
        assertEquals(Face.SOUTH,robot00SOUTH.getFace());

        //testinvalid move
        robot00WEST.move();
        assertEquals(0,robot00WEST.getX());
        assertEquals(0,robot00WEST.getY());
        assertEquals(Face.WEST,robot00WEST.getFace());
    }

    @Test
    public void turnLeftTest() {
        robot12North.turnLeft();
        assertEquals(Face.WEST,robot12North.getFace());

        robot12South.turnLeft();
        assertEquals(Face.EAST,robot12South.getFace());

        robot12West.turnLeft();
        assertEquals(Face.SOUTH,robot12West.getFace());

        robot12East.turnLeft();
        assertEquals(Face.NORTH,robot12East.getFace());
    }

    @Test
    public void turnRightTest() {
        robot12North.turnRight();
        assertEquals(Face.EAST,robot12North.getFace());

        robot12South.turnRight();
        assertEquals(Face.WEST,robot12South.getFace());

        robot12West.turnRight();
        assertEquals(Face.NORTH,robot12West.getFace());

        robot12East.turnRight();
        assertEquals(Face.SOUTH,robot12East.getFace());

    }
}

