    // This program is copyright VUW.
// You are granted permission to use it to construct your answer to a Onslow College 13DTC assignment.
// You may not distribute it in any other way without permission.

/* Exercise for WGC 13DT
 * Name:
 * Email:
 * Date:
 */

import ecs100.*;
import java.awt.Color;

/** A Lamp object represents a table lamp on the graphics pane. A lamp consists of a colored bulb and a stem.
 *   It remembers its current position, its color and whether it is on or off.
 *   Its initial position and its color are set when it is constructed.
 *   The diameter of a bulb should be 80.
 *   The height of the stem should be 80.
 *   The width of the stem should be 20.
 *   It has three methods:
 *     draw(),        which draws the lamp at its current position.
 *     onBulb(x,y),   which reports whether the point(x,y) is on the bulb.
 *     onStem(x,y),   which reports whether the point(x,y) is on the stem.
 *     turnOff(),     which turns the light off.
 *     changeColor(), which turns the light on if it is off; changes its color to a random bright colour if it is already on. 
 */

public class Lamp{

    public static final double SIZE = 80;  // diameter of the bulb and height of the stem
    public static final double WIDTH = SIZE/4;  // width of the stem is SIZE/4
    //fields
    private double LampX = -100;
    private double LampY = -100;
    
    private Color currentColor;
    
    private double left;
    private double top;
    private double bottom;
    
    private boolean bulb = false;
    private boolean stem = false;
    
    private boolean bulbOn = false;
    
    /** Constructor: passed the initial position.
     * Initialises the fields
     */
    public Lamp(double x, double y){
        LampX = x;
        LampY = y;
        
        setTop();
        setLeft();
        setBottom();
    }
    /**
     * Set Top
     */
    public void setTop(){
        this.top = this.LampY + this.SIZE/2.0;
    }
    
    /**
     * Set left
     */
    public void setLeft(){
        this.left = LampX - SIZE/2.0;
    }
    /**
     * Set bottom
     */
    public void setBottom(){
        this.bottom = this.LampY + this.SIZE;
    }
    
    /**
     * Left Getter
     */
    public double getLeft(){
        return this.left;
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
     * draws the lamp at its current position:
     * - the bulb of the right colour.
     * - the stem darkGray
     * The height of the stem is the same as the diameter of the bulb
     * The width of the stem is a quater of its height
     */
    public void draw(){
        /*# YOUR CODE HERE */
        // draw stem
        UI.setColor(Color.darkGray);
        UI.setLineWidth(WIDTH);
        UI.drawLine(this.LampX, this.LampY, this.LampX, this.top);
        //UI.drawLine(this.LampX, this.LampY, this.LampX, this.bottom);
        
        // draw bulb
        UI.setColor(Color.black);
        //UI.fillOval(left, top, SIZE, SIZE);
        UI.fillOval(this.left, this.top, SIZE, SIZE);
    }   
    
    /** 
     * Reports whether the point (x,y) is on the bulb.
     * (x and y represent the position where the mouse was released):
     */
    public boolean onBulb(double x, double y){
        // an easy approximation is to pretend it is the enclosing rectangle.
        // It is nicer to do a little bit of geometry and get it right
        /*# YOUR CODE HERE */
        if ((x >= this.getLeft()) && (x <= this.getLeft()+(WIDTH)) &&
            (y >= this.getTop()) && (y <= this.getTop()+SIZE)){
                bulb = true;
                
            } else {
                bulb = false;
                UI.println("bulb");
            }
        
        return bulb;
    }   

    /**
     * Reports whether the point (x,y) is on the stem.
     * (x and y represent the position where the mouse was released):
     */
    public boolean onStem(double x, double y){
        /*# YOUR CODE HERE */
        if ((x >= this.LampX -(WIDTH/2.0)) && (x <= this.LampX + (WIDTH/2.0)) &&
            (y >= this.LampY) && (y <= this.bottom)){
                stem = true;
            } else {
                stem = false;
            }
        System.out.println("stem");
        return stem;
    }   

    /**
     * Turns the light off.
     * Does not redraw
     */
    public void turnOff(){
        /*# YOUR CODE HERE */
        this.currentColor = (Color.gray);
    }   

    /** changeColor method (no parameters):
     * Turns the light on (if it is off)
     * Changes its color to a random bright colour (if it is already on).
     * Does not redraw
     */
    public void changeColor(){
        /*# YOUR CODE HERE */
        Color.getHSBColor((float)(Math.random()), 1.0f, 1.0f);
    }   
}
