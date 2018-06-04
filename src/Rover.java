import java.util.stream.Stream;

public class Rover {
    private Compass compass;
    private Location position;
    private Grid planet;
    private Compass.Direction facing;



    /**
     * Constructor for the Rover class.
     *
     * @param  X: x coordinate of the rover's starting location
     * @param  Y: y coordinate of the rover's starting location
     * @param  direction: String representing the current direction the rover is facing
     * @param  Planet: a grid representing the current planet the rover is on
     **/
    public Rover (int X, int Y, String direction, Grid Planet){
        position = new Location (X,Y);
        this.planet = Planet;
        compass = new Compass(direction);

    }

    /**
     * Given a list of commands chars this method will
     * loop through and execute the commands.
     *
     * @param commands: List of commands for the rover to preform. Valid cammond
     *                   characters are l (turn left), r (turn right), f (move forward), and b (move backward)
     * @throws roverException If this exception occurs the rover will ignore the remaining commands
     *                      and stop moving.
     */
    public void giveCommands(char [] commands){
        Stream<Character> commandStream = new String(commands).chars().mapToObj(i->(char)i);

        commandStream.forEach(
                comm -> {
                    try {
                        executeCommand(comm);
                    } catch (roverException e) {
                        e.printStackTrace();
                    }
                }
        );
    }

    /**
     * Incase the list of commands is given using a string instead of a
     * char array. This method will splint the string into a
     * char array and then call the giveCommands for the char
     * array
     * @param commands String of commands for the rover to preform
     */
    public void giveCommands(String commands){
        giveCommands(commands.toCharArray());
    }

    /**
     *Checks for type of command and calls coresponding method.
     *
     * @param comm: This is the command the rover must execute next
     */
    private void executeCommand(char comm) throws roverException{
        if (comm == 'l'){
            turnLeft();
        }else if (comm == 'r'){
            turnRight();
        }else if (comm == 'f'){
            moveForward();
        }else if (comm == 'b'){
            moveBackward();
        }
    }

    /**
     * Move the rover forward. The exact direction is based on which direction the rover
     * is currently facing.
     *
     * @param forward 1 if the rover is moving forward, -1 if moving backward.
     * @throws roverException If there is an obstacle in the way, this will be thrown.
     */
    private void move(int forward) throws roverException{
        int x = position.getX() + compass.getX(forward);
        int y = position.getY() + compass.getY(forward);

        if (x == -1) {
            x = planet.getMaxX();
        }
        if (y == -1 ){
            y = planet.getMaxY();
        }
        Location test = new Location (x%planet.getMaxX(), y%planet.getMaxY());

        if (planet.isClear(test)){
            position.setLocation(test);
        }else{
            throw new roverException("Obstacle  in Path");
        }
    }


    /**
     * Move the rover forwards. The exact direction is based on which direction the rover
     * is facing.
     * @throws roverException
     */
    private void moveForward()throws roverException{
        move(1);

    }

    /**
     * Move the rover backwards. The exact direction is based on which direction the rover
     * is facing.
     * @throws roverException
     */
    private void moveBackward()throws roverException{
       move(-1);

    }



    /**
     * Turn the rover 90 degrees to the left
     */
    private void turnLeft (){
        compass.rotateClockwise();
    }

    /**
     * Turn the rover 90 degrees to the right
     */
    private void turnRight(){

        compass.rotateCounterclockwise();
    }
}

class roverException extends Exception
{
    public roverException(String message)
    {
        super(message);
    }
}