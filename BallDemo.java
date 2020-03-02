import java.awt.Color;
import java.util.Random;
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

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }
    
    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line
        int roof = 10;
        myCanvas.setVisible(true);
        
        Random rand = new Random();
        int ballNum = 0;
        
        int boxX = 350;
        int boxY = 350;
        int offBoxX = 50;
        int offBoxY = 50;
        
        
        
        
        int xPos = 50;
        int yPos = 50;
        int ballDiameter = 50;
        Color ballColor;
        int bottomPos = 0;
        int leftPos = 0;
        int rightPos = 0;
        int topPos = 0;
        
        
        

        // draw the ground
        drawSquare(boxX,boxY,offBoxX,offBoxY);
        
        ballNum = (rand.nextInt(30 - 5) + 5) + 1;
        
        for(int i = 0; i < ballNum; i++)
        {
            ballColor = new Color(randomNumber(255),randomNumber(255),randomNumber(255));
            
            xPos = randomNumber();
            
            
            BoxBall ball = new BoxBall(xPos, yPos, ballDiameter,ballColor,bottomPos,
                                    leftPos, rightPos, topPos, myCanvas);
            
            
                                    
            ball.draw();                        
                                    
            
        }
        
        
        
        
        
        
        // crate and show the balls
        //BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        //ball.draw();
        //BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        //ball2.draw();

        
        // make them bounce
        boolean finished =  false;
        /**
         * This is the movement
         * its just paused for the time being
         */
        // while(!finished) {
            // myCanvas.wait(50);           // small delay
            // ball.move();
            // ball2.move();
            // // stop once ball has travelled a certain distance on x axis
            // if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                // finished = true;
            // }
        // }
    }
    
    private int randomNumber(int max, int min)
    {
        Random rand = new Random();
        int num;
        num = (rand.nextInt(max - min) + min) + 1;
        
        return num;
        
    }
    private int randomNumber(int max)
    {
        Random rand = new Random();
        int num;
        num = rand.nextInt(max) + 1;
        
        return num;
        
    }    
    
    
    private void drawSquare(int sizeX, int sizeY, int posX, int posY)
    {
        
        
        
        myCanvas.drawLine(0 + posX, 0 + posY, sizeX + posX, 0 + posY);
        myCanvas.drawLine(0 + posX, 0 + posY, 0 + posX, sizeY + posY);
        myCanvas.drawLine( 0 + posX, sizeY + posY, sizeX + posX, sizeY + posY);
        myCanvas.drawLine( sizeX + posX, 0 + posY, sizeX + posX, sizeY + posY);
        
        
        
    }
}
