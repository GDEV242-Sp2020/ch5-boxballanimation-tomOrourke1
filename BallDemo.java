import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Bill Crosbie
 * @version 2015-March-BB
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    
    private ArrayList<BoxBall> ballArray;
    
    private int ground;   // position of the ground line
    private int roof;
        
    private Random rand;
    private int ballNum;
        
    private int boxX;
    private int boxY;
    private int offBoxX;
    private int offBoxY;
        
    private int xPos;
    private int yPos;
    private int ballDiameter;
        
    private Color ballColor;
        
    private int bottomPos;
    private int leftPos;
    private int rightPos;
    private int topPos;
        
    private int speedX;
    private int speedY;
        
    
    
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        
        // creates new array
        ballArray = new ArrayList<>();
        
        ground = 400;   // position of the ground line
        roof = 10;
        myCanvas.setVisible(true);
        
        //new random variable
        rand = new Random();
        
        //temp ball num
        ballNum = 100;
        
        //IMPORTANT these numbers decide the size of the box
        boxX = 350;
        boxY = 350;
        offBoxX = 50;
        offBoxY = 50;
        
        //temp x and y pos
        xPos = 50;
        yPos = 50;
        
        // temp ball diameter 
        ballDiameter = 50;
        
        //this is the positions of the walls of the box either being on the x or y axis
        bottomPos = boxY + offBoxY;
        leftPos = 0 + offBoxX;
        rightPos = boxX + offBoxX;
        topPos = 0 + offBoxY;
        //x and y speed
        speedX = 0;
        speedY = 0;
        
        // draw the ground
        drawSquare(boxX,boxY,offBoxX,offBoxY);
        
    }
    
    /**
     * this is what creates the balls as well as moves them
     */
    public void bounce()
    {
        //gets a random ball number
        ballNum = (rand.nextInt(30 - 5) + 5) + 1;
        //ballNum = rand.nextInt(10) + 1;
        
        //this loopo generates the balls needed and sticks them in an array
        for(int i = 0; i < ballNum; i++)
        {
            //generates new color and it doesn't get too close to white
            ballColor = new Color(randomNumber(240),randomNumber(240),randomNumber(240));
            
            /**
             * This is the extra credit
             * change the size between 10 and 25 pixels
             */
            ballDiameter = (randomNumber(25 - 10) + 10) + 1;
            
            //this generates a random position for the balls inside the box
            xPos = randomNumber((rightPos - ballDiameter), leftPos);
            yPos = randomNumber((bottomPos - ballDiameter), topPos);
            
            //this gets a random speed for the balls
            speedX = randomNumber(7, -7,true);
            speedY = randomNumber(7, -7,true);
            
            //this creates the new boxball objext with the constructor taking in all the fields
            BoxBall ball = new BoxBall(xPos, yPos, ballDiameter,ballColor,bottomPos,
                                    leftPos, rightPos, topPos, myCanvas, speedX, speedY);
            //this adds the ball to an arraylist so it is easy to move them
            ballArray.add(ball);
            //this draws the new ball in the box                    
            ball.draw();                        
                 
        }
        
        
        
        // make them bounce
        boolean finished =  false;
        //this is what moves the balls in the box
        while(!finished)
        {
            myCanvas.wait(50);
            
            for(BoxBall ball : ballArray)
            {
                ball.move();
                
            }
            
        }
        
    }
    /**
     * this random number method takes in a min and a max to get
     */
    private int randomNumber(int max, int min)
    {
        Random rand = new Random();
        int num;
        num = (rand.nextInt(max - min) + min) + 1;
        
        return num;
        
    }
    /**
     * this random number method just takes a max and assumes that the min is zero to be replaced by 1
     */
    private int randomNumber(int max)
    {
        Random rand = new Random();
        int num;
        num = rand.nextInt(max) + 1; 
        
        return num;
        
    } 
    /**
     * this method overide is specifically for getting negative as well as positive numbers
     * takes in min max and a boolean range
     * the boolean doesn't do anything then force this method to be called
     */
    private int randomNumber(int max, int min, boolean range)
    {
        Random rand = new Random();
        int num;
        num = (rand.nextInt((max + 1) - min) + min);
        
        return num;
        
    }    
    /**
     * This method draws the box for the balls to bounce in
     * perameters are the xSize, ySize, as well as the x and y offset
     */
    private void drawSquare(int sizeX, int sizeY, int posX, int posY)
    {
        
        myCanvas.drawLine(0 + posX, 0 + posY, sizeX + posX, 0 + posY);
        myCanvas.drawLine(0 + posX, 0 + posY, 0 + posX, sizeY + posY);
        myCanvas.drawLine( 0 + posX, sizeY + posY, sizeX + posX, sizeY + posY);
        myCanvas.drawLine( sizeX + posX, 0 + posY, sizeX + posX, sizeY + posY);
        
    }
}
