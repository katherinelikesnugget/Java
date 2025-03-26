import ecs100.*;
import java.awt.Color;
import javax.swing.JColorChooser;
/**
 * Driver class for flowers
 * Make flowers and grow them
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Garden
{
    // instance variables - replace the example below with your own
    private Flower f1 = new Flower(50, 100, 20, 20, Color.blue);

    /**
     * Constructor for objects of class Garden
     */
    public Garden()
    {
        // initialise instance variables
        UI.initialise();
        UI.addButton("Grow", this::growGarden);
    }
    
    /**
     * Grows the flowers in the garden, and animate the objects
     */
    private void growGarden(){
        f1.draw();
    
        f1.grow();
        f1.grow();
        
        //f1.erase();
    }
}
