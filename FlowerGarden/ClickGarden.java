import ecs100.*;
import java.awt.Color;
import javax.swing.JColorChooser;
/**
 * clickgarden here obj in arrays
 * create a garden with each object in an array
 * click on the flower to make it grow
 *
 * @author Katherine
 * @version 26/03/25
 */
public class ClickGarden
{
    // fields
    private final int STARTX = 75;
    private final int YPOS = 100;
    private final int MAXFLOWERS = 5;
    
    private Flower[] flowerBed = new Flower[MAXFLOWERS];    // array of the flowers
    
    /**
     * Constructor for objects of class ClickGarden
     */
    public ClickGarden()
    {
        // initialise instance variables
        UI.initialise();
        UI.addButton("Quit", UI::quit);
        UI.addButton("Random Grow", this::randomGrow);
        
        // Set up the flowers, positions
        for (int i = 0; i < MAXFLOWERS; i ++){
            // set every flower to a random colour
            Color col = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
            flowerBed[i] = new Flower(STARTX * (i + 1), YPOS, 10, 50, col); // Create the flower obj, put them in an array
        }
        
        // Draw Flowers, for each flower
        for (Flower flower : flowerBed){
            flower.draw();
        }
        
        // Set up the mouse input
        //UI.setMouseListener(this::doMouse);
    }
    
    /**
     * Random grow the flowers in the array
     */
    public void randomGrow(){
        for (int i = 0; i < 10; i++){
            int randomFlower = (int)(Math.random() * MAXFLOWERS); // choose a random flower to grow
            flowerBed[randomFlower].grow();
        }
    }
    
    /**
     * Select obj based on where the user clicks
     */
    
    private void doMouse(String action, double x, double y){
        if (action.equals("clicked")){
            // check the location of the x and y against loc of the obj
            for (Flower flower : flowerBed){
                if ((x >=  flower.getLeft()) && (x <= flower.getRight()) &&
                    (y <=  flower.getTop()) && (y <= flower.getBottom())){
                        flower.grow();
                    }
            }
        }
    }
    
    public static void main(String[] args){
        ClickGarden obj = new ClickGarden();
    }
}
