public class Compass {

    private MapDirection facing;

    public Compass (String directionFacing){
        facing = MapDirection.valueOf(directionFacing);
    }

    public enum MapDirection {
        NORTH(new Direction(0,1)),
        SOUTH(new Direction(0,-1)),
        EAST(new Direction(1,0)),
        WEST(new Direction(-1,0));

        public final Direction direction;

        MapDirection(Direction direction){
            this.direction = direction;
        }

        static {
            NORTH.direction.setToLeft(WEST);
            NORTH.direction.setToRight(EAST);
            SOUTH.direction.setToRight(WEST);
            SOUTH.direction.setToLeft(EAST);
            EAST.direction.setToRight(SOUTH);
            EAST.direction.setToLeft(NORTH);
            WEST.direction.setToLeft(SOUTH);
            WEST.direction.setToRight(NORTH);
        }
    }


    /**
     * Returns the amount to move in x for the current direction being faced
     * @param forward value of 1 means move forward, -1 means move backward
     * @return amount to move in x
     */
    public int getX (int forward){
        return facing.direction.getX()*forward;
    }

    /**
     * Returns the amount to move in y for the current direction being faced
     * @param forward value of 1 means move forward, -1 means move backward
     * @return amount to move in y
     */
    public int getY(int forward){
        return facing.direction.getY()*forward;
    }

    /**
     * Rotates the compass clockwise, effectively making the user turn right
     */
    public void rotateClockwise (){
        facing = facing.direction.turnRight();
    }

    /**
     * Rotates the compass clockwise, effectively making the user turn left
     */
    public void rotateCounterclockwise (){
        facing = facing.direction.turnLeft();
    }
}
