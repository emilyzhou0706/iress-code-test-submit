package main.java;

import main.java.iress.code.constant.Face;
import main.java.iress.code.entity.Robot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot(0, 0, Face.EAST);
        System.out.println("Hello, welcome to have fun with the iress robot");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the move in sequence: ");
        while (scanner.hasNext()) {
            String commandInp = scanner.nextLine();
            System.out.println("Input command is: " + commandInp);
            String[] strings = commandInp.split(" ");
            switch (strings[0]) {
                case "MOVE":
                    robot.move();
                    break;
                case "LEFT":
                    robot.turnLeft();
                    break;
                case "RIGHT":
                    robot.turnRight();
                    break;
                case "PLACE":
                    String[] stringsPara = strings[1].split(",");
                    robot = robot.place(Integer.valueOf(stringsPara[0]), Integer.valueOf(stringsPara[1]), Face.valueOf(stringsPara[2]));
                    break;
                case "REPORT":
                    System.out.println("I am at location" + " x= " + robot.getX() + " y=" + robot.getY() + " facing " + robot.getFace());
                    break;
                default:
                    System.out.println("##Invalid input, please try again");
                    break;
            }
        }
        scanner.close();
    }
}
