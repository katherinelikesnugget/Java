import ecs100.*;
import java.awt.Color;
import javax.swing.JColorChooser;
/**
 * Write a description of class Flower here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Flower
{
    private double flowerX = -100;
    private double flowerY = -100;
    
    private int flowerSize;     //initialise flower size
    private int flowerHeight;   //initialise flower height
    
    private Color color;
    
    private double left;
    private double top;
    private double bottom;
    
    /**
     * Constructor for objects of class Flower
     */
    public Flower(double x, double y, int size, int stem, Color col)
    {
        // initialise instance variables
        this.flowerX = x;
        this.flowerY = y;
        this.flowerSize = size;
        this.flowerHeight = stem;
        this.color = col;
        
        // Set top, left, bottom
        this.setTop();
        this.setLeft();
        this.setBottom();
        
        UI.initialise();
        UI.addButton("Quit", UI::quit);
    }

    /**
     * Set Top
     */
    public void setTop(){
        this.top = this.flowerY - this.flowerSize/2.0;
    }
    
    /**
     * Set left
     */
    public void setLeft(){
        this.left = this.flowerX - this.flowerSize/2.0;
    }
    /**
     * Set bottom
     */
    public void setBottom(){
        this.bottom = this.flowerY + this.flowerHeight + this.flowerSize/2.0;
    }
    
    /**
     * Left Getter
     */
    public double getLeft(){
        return this.left;
    }
    /**
     * Right Getter
     */
    public double getRight(){
        return this.left + this.flowerSize;
    }
    /**
     * Top Getter
     */
    public double getTop(){
        return this.top;
    }
    /**
     * Bottom Getter
     */
    public double getBottom(){
        return this.bottom;
    }
    
    /**
     * Draw the flower on screen
     */
    public void draw(){
        // draw stem
        UI.setColor(Color.green);   // Set the colour of stem
        UI.setLineWidth(2);
        UI.drawLine(this.flowerX, this.flowerY, this.flowerX, this.bottom);
        
        // draw the flower
        UI.setColor(this.color);
        UI.fillOval(this.left, this.top, this.flowerSize, this.flowerSize);     // draw the bulb
        UI.sleep(500);  // wait
    }
    
    /**
     * Erase a rect around the current object
     */
    public void erase(){
        final int BUFFER = 1;
        UI.eraseRect(this.left, this.top, this.flowerSize + BUFFER, this.bottom + BUFFER);  // draw a rect to erase the bulb
    }
    
    /**
     * Make the flower grow
     */
    public void grow(){
        // Erase the whole thing
        this.erase();
        
        // Increase the size of my flower
        this.flowerY -= 10; // increasing the height
        this.flowerSize += 10;   // increasing the size of the bulb
        
        this.setTop();
        this.setLeft();
        
        // Draw the flower again
        this.draw();
    }
}
