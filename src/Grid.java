

public class Grid {
    private boolean planet [][];

    /**
     Initialize the planet surface. True on the grid means
     there is an obstical.
     */
    public Grid (boolean Planet [][] ){
        planet = new boolean [Planet.length][Planet[0].length];
        for (int i = 0; i < Planet.length; i++){
            for (int j = 0; j < Planet[i].length; j++){
                this.planet[i][j] = Planet[i][j];
            }
        }
    }

    /**
     Allows for new obsticals to be added to the planet

     @param  spot: position to put new obstical
     */
    public void addObsticle (Location spot){
        planet[spot.getX()][spot.getY()] = true;
    }
    /**
     Allows for new obsticals to be removed from the planet

     @param  spot: position to remove obstical
     */
    public void removeObsticle (Location spot){
        planet[spot.getX()][spot.getY()] = false;
    }

    /**
     Checks the surface at the given location for obsticals

     @param  spot: Location to check for obsticals
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