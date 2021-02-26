package se.liu.ida.emiwi425.tddd78.LabP;

import java.awt.*;

public interface Powerup {
    String getDescription();

    public void paint(Graphics g, int x, int y);

    public void playerHitMe(Player p);

}

