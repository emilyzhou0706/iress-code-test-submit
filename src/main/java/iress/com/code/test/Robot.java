package iress.com.code.test;

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
    private String face;

    public void turnLeft(){
        switch(this.face) {
            case "NORTH":
                this.face="WEST";
                break;
            case "EAST":
                this.face="NORTH";
                break;
            case "SOUTH":
                // code block
                this.face="EAST";
                break;
            case "WEST":
                this.face="SOUTH";
                break;
            default:
                break;
        }
    }

    public void turnRight() {
        switch (this.face) {
            case "NORTH":
                this.face = "EAST";
                break;
            case "EAST":
                this.face = "SOUTH";
                break;
            case "SOUTH":
                this.face = "WEST";
                break;
            case "WEST":
                this.face = "NORTH";
                break;
            default:
                break;
        }
    }

    public void move(){
        boolean validMovRes=false;
        switch (this.face) {
            case "NORTH":
                validMovRes=checkValid(x,y+1);
                if(validMovRes){
                    this.y++;
                }
                break;
            case "EAST":
                validMovRes=checkValid(x+1,y);
                if(validMovRes){
                    this.x++;
                }
                break;
            case "SOUTH":
                validMovRes=checkValid(x,y-1);
                if(validMovRes) {
                    this.y--;
                }
                break;
            case "WEST":
                validMovRes=checkValid(x-1,y);
                if(validMovRes) {
                    this.x--;
                }
                break;
            default:
                break;
        }
    }

    public Robot place(int x,int y,String face){
        if(checkValid(x,y)){
            return new Robot(x,y,face);
        }else{
            return this;
        }
    }

    public boolean checkValid(int x,int y){
        if(x<0||x>5||y<0||y>5){
            System.out.println("invalid move, please place another valid command");
            return false;
        }
        else{
            return true;
        }
    }

}
