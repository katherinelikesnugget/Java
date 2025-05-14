import ecs100.*;
/**
 * Write a description of class GUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GUI
{
    // instance variables - replace the example below with your own
    private Books books;    // declare books instance
    
    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        books = new Books();   // instantiate the books object
        UI.initialise();
        UI.addButton("Print All", books::printAll);
        UI.addButton("Add", books::addBook);
        UI.addButton("Find", books::findBook);
        UI.addButton("Remove", books::removeBook);
        UI.addButton("Quit", UI::quit);
        
        UI.setMouseListener(books::doMouse);
        
    }
    
    /**
     * Main method to run the program.
     */
    public static void main(String[] args) {
        new GUI();
    }
}

