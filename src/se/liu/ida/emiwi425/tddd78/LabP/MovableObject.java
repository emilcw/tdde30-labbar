package se.liu.ida.emiwi425.tddd78.LabP;

/**
 * A movable object on the screen, with current x and y coordinates.
 */
public class MovableObject
{
    protected int x, y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public MovableObject(int x, int y){
        this.x = x;
        this.y = y;
    }

}