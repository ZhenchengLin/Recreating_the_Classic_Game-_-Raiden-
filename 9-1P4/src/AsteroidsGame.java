import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class AsteroidsGame extends PApplet
{
    //your variable declarations here
    private PApplet applet;
    private Spaceship spaceShip;
    private ArrayList<Asteroid> asteroids;
    private ArrayList<Bullet> bullets;
    private ArrayList<Enemy> enemies;
    private UserIn[] userIn;
    private boolean[] images;
    public int numStars;
    private int hp = 5;
    private int maxToWin = 25;
    PImage p1;
    boolean hardMode = false;
    boolean gameStart = false;


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
        numStars = 3;


        asteroids = new ArrayList<>();
        for(int num = 0 ; num < numStars ; num++)
        {
            asteroids.add(new Asteroid(this));
        }

        userIn = new UserIn[10];
        for(int x = 0 ; x < 10 ; x ++)
        {
            userIn[x] = new UserIn(this);
        }

        bullets = new ArrayList<>();

        enemies = new ArrayList<>();


        background(0);

        //background

        for(int x = 0 ; x < 200 ; x ++)
        {
            background[x] = new Star(this);
        }

        //hp

        p1 = loadImage("pixelheart.png");

        images = new boolean[5];
        for(int x = 0 ; x < 5 ; x ++)
        {
            images[x] = true;
        }

    }

    int round = 1;
    int kills = 0;
    public void draw() {
        //your code here
        background(0);
        textSize(70);
        text("The New Asteroids Game", 100 , 450);
        textSize(20);
        text("Press any key to Start", 400 , 500);
        text("Press any H to Start hard mode", 350 , 525);
        if(keyPressed)
        {
            gameStart = true;
        }
        if(gameStart)
        {
            background(0);
            //Hp
            if (images[0]) {
                image(p1, 20, 30, width / 40, height / 40);
            }
            if (images[1]) {
                image(p1, 40, 30, width / 40, height / 40);
            }
            if (images[2]) {
                image(p1, 60, 30, width / 40, height / 40);
            }
            if (images[3]) {
                image(p1, 80, 30, width / 40, height / 40);
            }
            if (images[4]) {
                image(p1, 100, 30, width / 40, height / 40);
            }

            if (hp == 4) {
                images[4] = false;
            }
            if (hp == 3) {
                images[3] = false;
            }
            if (hp == 2) {
                images[2] = false;
            }
            if (hp == 1) {
                images[1] = false;
            }
            if (hp == 0) {
                images[0] = false;
            }

            for (int x = 0; x < enemies.size(); x++)
            {
                if(enemies.get(x).getY() >= 999)
                {
                    enemies.remove(x);
                    hp--;
                    break;
                }
            }

            //Background

            for(int x = 0 ; x < 200 ; x++)
            {
                background[x].show();
            }

            int space = 0;
            for(int x = 0 ; x < 10 ; x ++)
            {
                userIn[x].show();
                userIn[x].setX(space);
                space += 100;
            }

            // Game System

            fill(255,0,0);
            textSize(20);
            //End
            text("Round: " + round , 450 , 30);
            text("KILLS: " + kills , 600 , 30);
            if(hp <= 0)
            {
                background(0);
                textSize(120);
                fill(255,0,0);
                text("Game Over", 200, 500);
                frz();
                removeE();
            }
            if(kills >= maxToWin)
            {
                background(0);
                fill(255,102,0);
                textSize(120);
                text("You Won!" , 200 , 500);
                frz();
                removeE();
            }

            //game

            for(int num = 0 ; num < bullets.size() ; num++)
            {
                for(int x = 0 ; x < enemies.size() ; x ++)
                {
                    int length = enemies.size();
                    float disC = dist( (int)bullets.get(num).getX() , (int)bullets.get(num).getY() , (int)enemies.get(x).getX() , (int)enemies.get(x).getY());
                    if(disC < 20)
                    {
                        bullets.remove(num);
                        enemies.remove(x);
                        if(length > enemies.size())
                        {
                            kills++;
                            if(kills == 2)
                            {
                                round ++;
                                break;
                            }
                            if(kills == 4)
                            {
                                round++;
                                break;
                            }
                            if(kills == 6)
                            {
                                round++;
                                break;
                            }
                            if(kills == 8)
                            {
                                round++;
                                break;
                            }
                            if(kills == 12)
                            {
                                round++;
                                break;
                            }
                            if(kills == 16)
                            {
                                round++;
                                break;
                            }
                            if(kills == 20)
                            {
                                round++;
                                break;
                            }
                            if(kills >= maxToWin)
                            {
                                text("You Won!" , 200 , 500);
                                break;
                            }
                            break;
                        }
                        break;
                    }
                }

            }

            for(int num = 0 ; num < asteroids.size() ; num++)
            {
                float dis = dist( (int)asteroids.get(num).getX() , (int)asteroids.get(num).getY() , (int)spaceShip.getX() , (int)spaceShip.getY());
                if(dis <= 20)
                {
                    hp --;
                }
            }

            // elements


            spaceShip.show();
            spaceShip.move();


            for(int num = 0 ; num < bullets.size() ; num++)
            {
                if(bullets.get(num).getY() <= 140)
                {
                    bullets.remove(num);
                }
            }

            for(int num = 0 ; num < asteroids.size() ; num++)
            {
                asteroids.get(num).show();
                asteroids.get(num).move();
            }

            for(int x = 0 ; x < round * 2 ; x++)
            {
                enemies.add(new Enemy(this));
                enemies.get(x).show();
                enemies.get(x).move();
            }

            for(int x = 0 ; x < bullets.size() ; x++)
            {
                bullets.get(x).show();
                bullets.get(x).move();
            }


            //Controls
            if(keyPressed)
            {
                if(key == 'a')
                {
                    spaceShip.moveLeft();
                }
                if(key == 'd')
                {
                    spaceShip.moveRight();
                }
                if(key == 'w')
                {
                    spaceShip.moveFW();
                }
                if(key == 's')
                {
                    spaceShip.moveBW();
                }
            }


        }
        if(hardMode)
        {
            background(0);
            //Hp
            if (images[0]) {
                image(p1, 20, 30, width / 40, height / 40);
            }
            if (images[1]) {
                image(p1, 40, 30, width / 40, height / 40);
            }
            if (images[2]) {
                image(p1, 60, 30, width / 40, height / 40);
            }
            if (images[3]) {
                image(p1, 80, 30, width / 40, height / 40);
            }
            if (images[4]) {
                image(p1, 100, 30, width / 40, height / 40);
            }

            if (hp == 4) {
                images[4] = false;
            }
            if (hp == 3) {
                images[3] = false;
            }
            if (hp == 2) {
                images[2] = false;
            }
            if (hp == 1) {
                images[1] = false;
            }
            if (hp == 0) {
                images[0] = false;
            }

            for (int x = 0; x < enemies.size(); x++)
            {
                if(enemies.get(x).getY() >= 999)
                {
                    enemies.remove(x);
                    hp--;
                    break;
                }
            }

            //Background

            for(int x = 0 ; x < 200 ; x++)
            {
                background[x].show();
            }

            int space = 0;
            for(int x = 0 ; x < 10 ; x ++)
            {
                userIn[x].show();
                userIn[x].setX(space);
                space += 100;
            }

            // Game System

            fill(255,0,0);
            textSize(20);
            //End
            text("Round: " + round , 450 , 30);
            text("KILLS: " + kills , 600 , 30);
            if(hp <= 0)
            {
                background(0);
                textSize(120);
                fill(255,0,0);
                text("Game Over", 200, 500);
                frz();
                removeE();
            }
            if(kills >= maxToWin)
            {
                background(0);
                fill(255,102,0);
                textSize(120);
                text("You Won!" , 200 , 500);
                frz();
                removeE();
            }

            //game

            for(int num = 0 ; num < bullets.size() ; num++)
            {
                for(int x = 0 ; x < enemies.size() ; x ++)
                {
                    int length = enemies.size();
                    float disC = dist( (int)bullets.get(num).getX() , (int)bullets.get(num).getY() , (int)enemies.get(x).getX() , (int)enemies.get(x).getY());
                    if(disC < 20)
                    {
                        bullets.remove(num);
                        enemies.remove(x);
                        if(length > enemies.size())
                        {
                            kills++;
                            if(kills == 2)
                            {
                                round ++;
                                break;
                            }
                            if(kills == 4)
                            {
                                round++;
                                break;
                            }
                            if(kills == 6)
                            {
                                round++;
                                break;
                            }
                            if(kills == 8)
                            {
                                round++;
                                break;
                            }
                            if(kills == 12)
                            {
                                round++;
                                break;
                            }
                            if(kills == 16)
                            {
                                round++;
                                break;
                            }
                            if(kills == 20)
                            {
                                round++;
                                break;
                            }
                            if(kills >= maxToWin)
                            {
                                text("You Won!" , 200 , 500);
                                break;
                            }
                            break;
                        }
                        break;
                    }
                }

            }

            for(int num = 0 ; num < asteroids.size() ; num++)
            {
                float dis = dist( (int)asteroids.get(num).getX() , (int)asteroids.get(num).getY() , (int)spaceShip.getX() , (int)spaceShip.getY());
                if(dis <= 20)
                {
                    hp --;
                }
            }

            // elements


            spaceShip.show();
            spaceShip.move();


            for(int num = 0 ; num < bullets.size() ; num++)
            {
                if(bullets.get(num).getY() <= 140)
                {
                    bullets.remove(num);
                }
            }

            for(int num = 0 ; num < asteroids.size() ; num++)
            {
                asteroids.get(num).show();
                asteroids.get(num).move();
            }

            for(int x = 0 ; x < round * 2 ; x++)
            {
                enemies.add(new Enemy(this));
                enemies.get(x).show();
                enemies.get(x).move();
                enemies.get(x).hyperspace();
            }

            for(int x = 0 ; x < bullets.size() ; x++)
            {
                bullets.get(x).show();
                bullets.get(x).move();
            }


            //Controls
            if(keyPressed)
            {
                if(key == 'a')
                {
                    spaceShip.moveLeft();
                }
                if(key == 'd')
                {
                    spaceShip.moveRight();
                }
                if(key == 'w')
                {
                    spaceShip.moveFW();
                }
                if(key == 's')
                {
                    spaceShip.moveBW();
                }
            }

        }


    }

    //methods
    public void keyPressed()
    {
        if(key == ' ')
        {
            atk();
        }
        if(key == 'h')
        {
            hardMode = true;
        }
    }

    public void atk()
    {
        bullets.add(new Bullet(this, spaceShip));
    }



    public void frz()
    {
        for(int x = 0 ; x < bullets.size() ; x ++)
        {
            bullets.get(x).frzB();
        }
        for(int x = 0 ; x < enemies.size() ; x ++)
        {
            enemies.get(x).frzE();
        }
        spaceShip.frzSP();
        for(int x = 0 ; x < asteroids.size() ; x ++)
        {
            asteroids.get(x).frzA();
        }
    }

    public void removeE()
    {
        for(int x = 0 ; x < bullets.size() ; x ++)
        {
            bullets.remove(x);
        }
        for(int x = 0 ; x < enemies.size() ; x ++)
        {
            enemies.remove(x);
        }
        for(int x = 0 ; x < asteroids.size() ; x ++)
        {
            asteroids.remove(x);
        }
    }
}