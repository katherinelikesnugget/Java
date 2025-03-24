import ecs100.*;
import java.awt.Color;
import javax.swing.JColorChooser;
/**
 * Let user draw lines on graphics pane with the mouse
 *
 * @author Katherine Ng
 * @version (a version number or a date)
 */
public class LineDrawer
{
    // fields to remember the pressed position
    private double startX, startY;
    private Color currentColor = Color.black;
    
    
    /**
     * callback mouse method
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
     *  Main routine
     */
    public static void main(String[] args){
        UI.setLineWidth(10);
        LineDrawer drawer = new LineDrawer();
        UI.addButton("Change Colour", drawer::changeColor);
        UI.setMouseListener(drawer::doMouse);
        UI.addButton("Quit", UI::quit);
        //UI.addButton("Colour", drawer::ChooseColor);
    }
}
