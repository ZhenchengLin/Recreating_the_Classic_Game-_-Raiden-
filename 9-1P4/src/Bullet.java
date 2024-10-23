import processing.core.PApplet;

public class Bullet extends Floater
{

    public Bullet(PApplet applet, Spaceship theShip)
    {
        super(applet);
        myCenterX = theShip.getX();
        myCenterY = theShip.getY();
        myPointDirection = theShip.getDirac();
        accelerate(6);
    }

    public Bullet(PApplet applet, Enemy theShip)
    {
        super(applet);
        myCenterX = theShip.getX();
        myCenterY = theShip.getY();
        myPointDirection = theShip.getDirac();
        accelerate(6);
    }

    @Override
    public void show()
    {
        applet.ellipse((int)myCenterX, (int)myCenterY, 5, 5);
    }

    public double getX()
    {
        return myCenterX;
    }

    public double getY()
    {
        return myCenterY;
    }

    public void frzB()
    {
        accelerate(0);
        myXspeed = 0;
        myYspeed = 0;
    }


}
