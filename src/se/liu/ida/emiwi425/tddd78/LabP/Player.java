package se.liu.ida.emiwi425.tddd78.LabP;

public class Player {

    private int x, y;
    private SpeedType speed = SpeedType.MEDIUM;
    private ModeType mode = ModeType.NORMAL;

    public SpeedType getSpeed() {
        return speed;
    }

    public void setSpeed(final SpeedType speed) {
        this.speed = speed;
    }

    public ModeType getMode() {
        return mode;
    }

    public void setMode(final ModeType mode) {
        this.mode = mode;
    }

    public void moveRight() {
        switch (speed) {
            case SLOW:
                x += 5;
                break;
            case MEDIUM:
                x += 10;
                break;
            case FAST:
                x += 20;
                break;
        }
    }

    /**
     * Describe current speed and mode -- used for a status display
     */
    public String getDescription() {
        StringBuilder buf = new StringBuilder();
        buf.append("Player is ");
        buf.append(speed);
        buf.append(" and ");
        buf.append(mode);

        return buf.toString();
    }

    public static void main(String[] args) {
        final Player player = new Player();
        System.out.println(player.getDescription());
    }
}