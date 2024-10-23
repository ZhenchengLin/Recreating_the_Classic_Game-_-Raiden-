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
        myPointDirection = 270 ;
        r = 0 ;
        g = 0;
        b = 128 ;
    }

    public void moveLeft()
    {
        myCenterX -= 5;
    }

    public void moveRight()
    {
        myCenterX += 5;
    }


    public void moveFW()
    {
        myCenterY -= 5;
    }

    public void moveBW()
    {
        myCenterY += 5;
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

    public double getDirac()
    {
        return myPointDirection;
    }

    public void frzSP()
    {
        accelerate(0);
        myXspeed = 0;
        myYspeed = 0;
        myCenterX = 500;
        myCenterY = 600;
        turn(50);
    }

    public void setX(double x)
    {
        myCenterX = x ;
    }

    public void setY(double x)
    {
        myCenterY = x ;
    }


}