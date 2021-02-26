package se.liu.ida.emiwi425.tddd78.LabP;

import java.awt.*;

public class GhostPowerup implements Powerup
{
    public void paint(Graphics g, int x, int y) {
        g.fillOval(x, y, 10, 10);
    }

    @Override public String getDescription() {
        return "Makes a player into a ghost that can travel through walls";
    }

    public void playerHitMe(Player p){
	p.setMode(ModeType.GHOST);
    }


}
