import ecs100.*;
/**
 * Support class for Book
 * A Book contains an id, name, author, quantity, image
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Book
{
    // fields
    private int id;
    private String name;
    private String author;
    private int quantity;
    private String image;
    static final String DEFAULT_IMAGE = "book.jpg";
    
    /**
     * Constructor for objects of class Book
     */
    public Book (int key, String nm, String auth, int qty, String img)
    {
        id = key;
        name = nm;
        author = auth;
        quantity = qty;
        if (img == null) {
            this.image = DEFAULT_IMAGE;     // add default img if user clicks cancel
        } else {
            this.image = img;
        }
    }
    
    /**
     * Constructor overloading
     * Set default image to obj
     */
      
    public Book(int key, String nm, String auth, int qty){
        this(key, nm, auth, qty, DEFAULT_IMAGE);
    }
    
    /**
     * Display image on GUI
     */
    public void displayBook() {
        int locX = 100;
        int locY = 100;
        final double WIDTH = 100;
        final double HEIGHT = 100;
        
        UI.drawImage(this.image, locX, locY, WIDTH, HEIGHT);
    }
    /**
     * Getter for id
     */
    public int getId() {
        return this.id;
    }
    /**
     * Getter for name
     */
    public String getName() {
        return this.name;
    }
    /**
     * Getter for author
     */
    public String getAuthor() {
        return this.author;
    }
    /**
     * Getter for quantity
     */
    public int getQuantity() {
        return this.quantity;
    }
}
