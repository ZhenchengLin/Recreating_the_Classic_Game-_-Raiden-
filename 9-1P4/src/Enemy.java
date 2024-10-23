import processing.core.PApplet;
class Enemy extends Floater
{

    public Enemy(PApplet applet)
    {
        super(applet);
        corners = 4;
        xCorners = new int[] {-8,16,-8,2};
        yCorners = new int[] {-8,0,8,0};
        myColor = 123 ;
        myCenterX = (int)(Math.random() * 1000);
        myCenterY = (int)(Math.random() * 100);
        myXspeed = 0;
        myYspeed = 0;
        myPointDirection = 90 ;
        r = 128 ;
        g = 0;
        b = 0 ;
    }

    @Override
    public void move()
    {
        accelerate(0.003);
        myCenterY += myYspeed;
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

    public void frzE()
    {
        accelerate(0);
        myXspeed = 0;
        myYspeed = 0;
    }

    public void hyperspace()
    {
        myCenterX = (int)(Math.random() * 1000);
        myXspeed = 0;
    }




}
