import processing.core.PApplet;
class Star extends PApplet
{
    private PApplet applet;
    private int myX , myY , color;
    public Star(PApplet applet_)
    {
        applet = applet_;
        myX = (int)(Math.random() * 1000);
        myY = (int)(Math.random() * 1000);
        color = (int)(Math.random() * 255);
    }
    public void show()
    {
        applet.fill(color);
        applet.ellipse(myX,myY,4,4);
    }
}