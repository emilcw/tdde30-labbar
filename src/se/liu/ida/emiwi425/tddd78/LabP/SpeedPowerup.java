package se.liu.ida.emiwi425.tddd78.LabP;

import java.awt.*;

public class SpeedPowerup implements Powerup
{
    @Override public String getDescription() {
        return "Makes a player faster";
    }

    public void paint(Graphics g, int x, int y) {
        g.fillRect(x, y, 10, 10);
    }

    public void playerHitMe(Player p){
        p.setSpeed(SpeedType.FAST);
    }


}