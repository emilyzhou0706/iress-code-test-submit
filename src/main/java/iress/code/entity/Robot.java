package main.java.iress.code.entity;

import main.java.iress.code.constant.Face;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Robot {
    private int x;
    private int y;
    private Face face;

    public void turnLeft() {
        switch (this.face) {
            case NORTH:
                this.face = Face.WEST;
                break;
            case EAST:
                this.face = Face.NORTH;
                break;
            case SOUTH:
                this.face = Face.EAST;
                break;
            case WEST:
                this.face = Face.SOUTH;
                break;
            default:
                break;
        }
    }

    public void turnRight() {
        switch (this.face) {
            case NORTH:
                this.face = Face.EAST;
                break;
            case EAST:
                this.face = Face.SOUTH;
                break;
            case SOUTH:
                this.face = Face.WEST;
                break;
            case WEST:
                this.face = Face.NORTH;
                break;
            default:
                break;
        }
    }

    public void move() {
        boolean validMovRes = false;
        switch (this.face) {
            case NORTH:
                validMovRes = checkValid(x, y + 1);
                if (validMovRes) {
                    this.y++;
                }
                break;
            case EAST:
                validMovRes = checkValid(x + 1, y);
                if (validMovRes) {
                    this.x++;
                }
                break;
            case SOUTH:
                validMovRes = checkValid(x, y - 1);
                if (validMovRes) {
                    this.y--;
                }
                break;
            case WEST:
                validMovRes = checkValid(x - 1, y);
                if (validMovRes) {
                    this.x--;
                }
                break;
            default:
                break;
        }
    }

    public Robot place(int x, int y, Face face) {
        if (checkValid(x, y)) {
            return new Robot(x, y, face);
        } else {
            return this;
        }
    }

    public boolean checkValid(int x, int y) {
        if (x < 0 || x > 5 || y < 0 || y > 5) {
            System.out.println("invalid move, please place another valid command");
            return false;
        } else {
            return true;
        }
    }

}
