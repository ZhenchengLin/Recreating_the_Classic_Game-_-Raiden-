import processing.core.PApplet;

public class Asteroid extends Floater
{
    private double rSpeed;

    public Asteroid(PApplet applet)
    {
        super(applet);
        corners = 6;
        xCorners = new int[] {-11,7,13,6,-11,5};
        yCorners = new int[] {-8, -8,0,10,8,0};
        myColor = 123 ;
        myCenterX = (int)(Math.random() * 1000);
        myCenterY = (int)(Math.random() * 100);
        myXspeed = 0;
        myYspeed = 0.5;
        myPointDirection = 0 ;
        rSpeed += Math.random() - 0.5 ;
    }

    @Override
    public void accelerate (double dAmount)
    {
        double dRadians = myPointDirection * (Math.PI / 180);
        myYspeed += ((dAmount) * Math.sin(dRadians));
    }

    @Override
    public void move()
    {
        super.turn(rSpeed);
        accelerate(0.001);
        myCenterY += myYspeed;
        if(myCenterX > applet.width)
        {
            myCenterX = 0;
        }
        else if (myCenterX < 0)
        {
            myCenterX = applet.width;
        }
        if(myCenterY > applet.height)
        {
            myCenterY = 0;
        }
        else if (myCenterY < 0)
        {
            myCenterY = applet.height;
        }
    }

    @Override
    public void show()
    {
        applet.fill(myColor);
        //applet.stroke(myColor);
        //translate the (x,y) center of the ship to the correct position
        applet.translate((float)myCenterX, (float)myCenterY);

        //convert degrees to radians for rotate()
        float dRadians = (float)(myPointDirection * (Math.PI / 180));

        //rotate so that the polygon will be drawn in the correct direction
        applet.rotate(dRadians);

        //draw the polygon
        applet.beginShape();
        for (int i = 0; i < corners; i++)
        {
            applet.vertex(xCorners[i], yCorners[i]);
        }
        applet.endShape(applet.CLOSE);

        //"unrotate" and "untranslate" in reverse order
        applet.rotate(-1 * dRadians);
        applet.translate(-1 * (float)myCenterX, -1 * (float)myCenterY);
    }

    public double getX()
    {
        return myCenterX;
    }

    public double getY()
    {
        return myCenterY;
    }

    public void frzA()
    {
        accelerate(0);
        myXspeed = 0;
        myYspeed = 0;
    }





}
