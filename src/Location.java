

public class Location {
    private int x;
    private int y;

    /**
     Constructor to set the initial location values
     */
    public Location(int X, int Y){
        setLocation(X,Y);
    }


    public int getX (){
        return x;
    }

    public int getY(){
        return y;
    }

    public void setX(int X){
        this.x = X;
    }


    public void setY(int Y){
        this.y = Y;
    }

    /**
     Allows the location to be changed if needed for new test using specific coordinates

     @param  X: the new X coordinate
     @param  Y: the new Y coordinate
     */
    public void setLocation (int X, int Y){
        setY(Y);
        setX(X);
    }

    /**
     Allows the location to be changed if needed for new test using specific coordinates

     @param  newSpot: the new location to set this equal to.
     */
    public void setLocation (Location newSpot){
        this.x = newSpot.getX();
        this.y = newSpot.getY();
    }


}