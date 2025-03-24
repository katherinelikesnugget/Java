import ecs100.*;
import java.awt.Color;
import javax.swing.JColorChooser;
/**
 * Painting
 *
 * @author Katherine Ng
 * @version (a version number or a date)
 */
public class MSPAINT
{
    // instance variables - replace the example below with your own
    private double startX, startY;  // fields to remember Mouse Input
    private double brushSize = 5;   // Initialising the original size of brush
    private Color currentColor = Color.black;
    
    /**
     * Constructor for objects of class MSPAINT
     */
    public MSPAINT(){
        UI.initialise();
        //UI.setLineWidth(this.brushSize);
        UI.setMouseListener(this::doMouse);
        UI.addButton("Quit", UI::quit);
        UI.addSlider("Slider", 1, 20, this.brushSize, this::getSize);    // Slider to change the brush size
    }
    
    /**
     * Drawing lines by checking my mouse action
     * @para x, y
     */
    
    public void doMouse(String action, double x, double y){
        if (action.equals("pressed")){
            this.startX = x;
            this.startY = y; // this, is inside the class, for this instance, we us this start x and y as oppose we use variables here
        } else if(action.equals("released")){
            UI.drawLine(this.startX, this.startY, x,y);
        }
    }
    /**
     * A slider to get the brush size
     * @para double size
     */
    public void getSize(double size){
        this.brushSize = size;
        UI.setLineWidth(this.brushSize);
    }
    
    /**
     *  Main routine
     */
    public static void main(String[] args){
        MSPAINT drawer = new MSPAINT();
        UI.addButton("Change Colour", drawer::changeColor);
        //UI.addButton("Change shape", drawer::changeShape);
    }
    
    /**
     * Callback to let user choose colour
     
    public void doChoosecolor(){
        this.currentColor = JColorChooser.showDialog(null, "Choose Colour", currentColor);
        UI.setColor(this.currentColor);
    }*/
    private void changeColor(){
        Color col = new Color((float) Math.random(),(float) Math.random(),(float) Math.random());
        UI.setColor(col);
    }
    
    /**
     * Change shape
     */
    //private void changeShape(){
        
    //}
}