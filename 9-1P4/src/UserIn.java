import processing.core.PApplet;
public class UserIn extends Floater
{
    public UserIn(PApplet applet_)
    {
        super(applet_);
        myCenterY = 0;
        myCenterX = 0;
    }

    @Override
    public void show()
    {
        applet.rect((int)myCenterX, 140, 40, 10);
    }

    public void setX(int x)
    {
        myCenterX = x ;
    }
}
