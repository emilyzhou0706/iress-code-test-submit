# iress-code-test-submit
1-App description
The application is a simulation of a toy robot moving on a square table top, of dimensions 5 units x 5 units. There are no
other obstructions on the table surface. The robot is free to roam around the surface of the table, but can be prevented
from falling to destruction. Any movement that would result in the robot falling from the table is coded to be prevented,
however further valid movement commands are still allowed.

2-Prerequisites
jdk 11
[Java 11 Runtime](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

3-Installation/How to run this application?
Java –jar xxx.jar

4-Usage
Initial location of the robot: (0,0,EAST)
Available commands to control the robot, where X,Y should be int of 0-5, F can be NORTH/SOUTH/EAST/WEST.
sample commands: PLACE 2,1,NORTH

PLACE X,Y,F
MOVE
LEFT
RIGHT
REPORT

Commands explaination:
PLACE will put the toy robot on the table in position X,Y and facing NORTH, SOUTH, EAST or WEST.
MOVE will move the toy robot one unit forward in the direction it is currently facing.
LEFT and RIGHT will rotate the robot 90 degrees in the specified direction without changing the position of the robot.
REPORT will announce the X,Y and F of the robot.
A robot that is not on the table can choose to ignore the MOVE, LEFT, RIGHT and REPORT commands.
The toy robot can only move on a square table top of dimensions 5 units x 5 units.
