import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

/**
 * Write a description of class BoxBall here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BoxBall
{
    private static final int GRAVITY = 3;  // effect of gravity

    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private int xPosition;
    private int yPosition;
    
    private final int bottomPosition;      // y position of ground
    private final int leftPosition;
    private final int rightPosition;
    private final int topPosition;
    
    private int xSpeed;
    private int ySpeed;  
    
    private Canvas canvas;
    
    
                  // initial downward speed
        /**
     * Constructor for objects of class BouncingBall
     *
     * @param xPos  the horizontal coordinate of the ball
     * @param yPos  the vertical coordinate of the ball
     * @param ballDiameter  the diameter (in pixels) of the ball
     * @param ballColor  the color of the ball
     * @param groundPos  the position of the ground (where the wall will bounce)
     * @param drawingCanvas  the canvas to draw this ball on
     */
    public BoxBall(int xPos, int yPos, int ballDiameter, Color ballColor,
                        int bottomPos,int leftPos, int rightPos, int topPos, Canvas drawingCanvas, 
                        int inXSpeed, int inYSpeed)
    {
        xPosition = xPos;
        yPosition = yPos;
        color = ballColor;
        diameter = ballDiameter;
        bottomPosition = bottomPos;
        leftPosition = leftPos;
        rightPosition = rightPos;
        topPosition = topPos;
        canvas = drawingCanvas;
        
        
        // this makes it so that the speeds aren't Zero
        if (inXSpeed == 0)
            xSpeed = 7;
        else
            xSpeed = inXSpeed;
        if(inYSpeed == 0)
            ySpeed = 7;
        else
            ySpeed = inYSpeed;
        
    }
    
    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }    

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        //Random rand = new Random();
        
        //color = new Color(rand.nextInt(240),rand.nextInt(240),rand.nextInt(240));
        
        
        
        
        // compute new position
        //ySpeed += GRAVITY;
        yPosition += ySpeed;
        xPosition += xSpeed;

        
        if (xPosition + diameter>= rightPosition)
        {
            xSpeed *= -1;
            xPosition -= diameter;
        }
        else if(xPosition <= leftPosition)
        {
            xSpeed *= -1;
            xPosition += diameter;
        }
        
        if (yPosition + diameter >= bottomPosition)
        {
            ySpeed *= -1;
            yPosition -= diameter;
        }
        else if (yPosition <= topPosition)
        {
            ySpeed *= -1;
            yPosition += diameter;
        }
        
        

        // draw again at new position
        draw();
    }    

    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }
    
    
}
