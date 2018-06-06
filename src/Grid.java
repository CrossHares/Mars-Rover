import java.util.ArrayList;

public class Grid {
    private boolean planet [][];


    /**
     * Initialize the planet grid.
     * @param Obstacles List of obstacle locations within the grid
     * @param width width of the grid representing the planet
     * @param height height of the grid representing the planet.
     */
    public Grid (ArrayList<Location> Obstacles, int width, int height){
        planet = new boolean [width][height];
        Obstacles.stream().forEach(
                obs -> {addObstacle(obs);}
        );
    }

    /**
     Allows for new obstacles to be added to the planet

     @param  spot: position to put new obstacle
     */
    public void addObstacle (Location spot){
        planet[spot.getX()][spot.getY()] = true;
    }
    /**
     Allows for new obstacles to be removed from the planet

     @param  spot: position to remove obstacle
     */
    public void removeObstacle (Location spot){
        planet[spot.getX()][spot.getY()] = false;
    }

    /**
     Checks the surface at the given location for obstacles

     @param  spot: Location to check for obstacles
     */
    public boolean isClear (Location spot){
        return !(planet[spot.getX()][spot.getY()]);
    }

    /**
     Allows for going around the planet in the Rover class by supplying the
     max X value
     */
    public int getMaxX(){
        return planet.length-1;
    }

    /**
     Allows for going around the planet in the Rover class by supplying the
     max Y value
     */
    public int getMaxY(){
        return (planet[0].length)-1;
    }
}