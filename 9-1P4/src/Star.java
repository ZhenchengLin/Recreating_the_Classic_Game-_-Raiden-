import processing.core.PApplet;
class Star extends PApplet
{
    private PApplet applet;
    private int myX , myY , colorR , colorG, colorB;
    public Star(PApplet applet_)
    {
        applet = applet_;
        myX = (int)(Math.random() * 1000);
        myY = (int)(Math.random() * 1000);
        colorR = (int)(Math.random() * 255);
        colorG = (int)(Math.random() * 255);
        colorG = (int)(Math.random() * 255);
    }
    public void show()
    {
        applet.fill(colorR,colorG,colorB);
        applet.ellipse(myX,myY,5,5);
        applet.stroke(0,0);
    }
}