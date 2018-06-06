public class Direction{
    private int x;
    private int y;
    private Compass.MapDirection toLeft;
    private Compass.MapDirection toRight;

    public Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * Change the direction 90 degrees to the left
     *
     * @return direction value to the left of the current direction.
     */
    public Compass.MapDirection turnLeft() {
        return toLeft;
    }

    public void setToLeft(Compass.MapDirection toLeft) {
        this.toLeft = toLeft;
    }
    /**
     * Change the direction 90 degrees to the left
     *
     * @return direction value to the left of the current direction.
     */
    public Compass.MapDirection turnRight() {
        return toRight;
    }

    public void setToRight(Compass.MapDirection toRight) {
        this.toRight = toRight;
    }
}