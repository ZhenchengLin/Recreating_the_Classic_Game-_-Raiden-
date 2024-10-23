import processing.core.PApplet;

import java.util.ArrayList;

public class AsteroidsGame extends PApplet
{
    //your variable declarations here
    private PApplet applet;
    private Spaceship spaceShip;
    private ArrayList<Asteroid> asteroids;
    public int numStars;

    //background

    Star[] background = new Star[200];


    public static void main(String[] args)
    {
        PApplet.main("AsteroidsGame");
    }

    public void settings()
    {
        // your size() method here
        size(1000,1000);

    }

    public void setup()
    {
        //your code here
        spaceShip = new Spaceship(this);
        numStars = 10;
        asteroids = new ArrayList<>();
        for(int num = 0 ; num < numStars ; num++)
        {
            asteroids.add(new Asteroid(this));
        }

        background(0);


        //background

        for(int x = 0 ; x < 200 ; x ++)
        {
            background[x] = new Star(this);
        }

    }

    public void draw()
    {
        //your code here
        background(0);



        //Background

        for(int x = 0 ; x < 200 ; x++)
        {
            background[x].show();
        }


        // Game



        spaceShip.show();
        spaceShip.move();
        for(int num = 0 ; num < asteroids.size() ; num++)
        {
            asteroids.get(num).show();
            asteroids.get(num).move();
            float dis = dist( (int)asteroids.get(num).getX() , (int)asteroids.get(num).getY() , (int)spaceShip.getX() , (int)spaceShip.getY());
            if(dis < 20)
            {
                asteroids.remove(num);
            }
        }

        if(keyPressed)
        {
            if(key == 'a')
            {
                spaceShip.rotateLeft();
            }
            if(key == 'd')
            {
                spaceShip.rotateRight();
            }
            if(key == 'w')
            {
                spaceShip.moveFW();
            }
        }



    }

    public void keyPressed()
    {
        if(key == 'h')
        {
            spaceShip.hyperspace();
        }


    }

}