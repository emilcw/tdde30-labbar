package se.liu.ida.emiwi425.tddd78.LabP;

public class PlayerSprite extends MovableObject
{
    private final String name;

    public PlayerSprite(final String name, final int x, final int y) {
        //We don't want the local x and y, we want them to be stored in MovableObject since the PlayerSprite is a MO.
        super(x,y);
        this.name = name;
    }
}