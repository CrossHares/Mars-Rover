public class Compass {
    int x, y;

    private Direction facing;

    public Compass (String directionFacing){
        facing = Direction.valueOf(directionFacing);
        setDirection();
    }

    public  enum Direction {
        N, S, E, W
    }

    /**
     * Returns the amount to move in x for the current direction being faced
     * @param forward value of 1 means move forward, -1 means move forward
     * @return amount to move in x
     */
    public int getX (int forward){
        return x*forward;
    }

    /**
     * Returns the amount to move in y for the current direction being faced
     * @param forward value of 1 means move forward, -1 means move forward
     * @return amount to move in y
     */
    public int getY(int forward){
        return y*forward;
    }

    /**
     * When the direction being faced changes this method needs to be called to update x and y
     */
    public void setDirection () {
        switch (facing) {
            case N:
                x = -1;
                y = 0;
                break;
            case S:
                x = 1;
                y = 0;
                break;
            case E:
                x = 0;
                y = 1;
                break;
            case W:
                x = 0;
                y = -1;
                break;
        }
    }


    /**
     * Rotates the compass clockwise, effectively making the user turn right
     */
    public void rotateClockwise (){
        switch (facing) {
            case N:
                facing = Direction.W;
                break;
            case S:
                facing = Direction.E;
                break;
            case E:
                facing = Direction.N;
                break;
            case W:
                facing = Direction.S;
                break;
        }
        setDirection();
    }

    /**
     * Rotates the compass clockwise, effectively making the user turn left
     */
    public void rotateCounterclockwise (){
        switch (facing) {
            case N:
                facing = Direction.E;
                break;
            case S:
                facing = Direction.W;
                break;
            case E:
                facing = Direction.S;
                break;
            case W:
                facing = Direction.N;
                break;
        }
        setDirection();
    }
}
