import processing.core.PApplet;
public class Spaceship extends Floater
{
    //your code here
    public Spaceship(PApplet applet)
    {
        super(applet);
        corners = 4;
        xCorners = new int[] {-8,16,-8,2};
        yCorners = new int[] {-8,0,8,0};
        myColor = 123 ;
        myCenterX = 500;
        myCenterY = 500;
        myXspeed = 0;
        myYspeed = 0;
        myPointDirection = 0 ;
    }

    public void rotateLeft()
    {
        super.turn(-4);
    }

    public void rotateRight()
    {
        super.turn(4);
    }


    public void moveFW()
    {
        accelerate(0.03);
        move();
    }

    public void hyperspace()
    {
        myCenterX = (int)(Math.random() * 1000);
        myCenterY = (int)(Math.random() * 1000);
        myXspeed = 0;
        myYspeed = 0;
    }

    public double getX()
    {
        return myCenterX;
    }

    public double getY()
    {
        return myCenterY;
    }






}