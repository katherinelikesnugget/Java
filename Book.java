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
    private int clickBook = 0;
    
    private String cover;
    
    // Book dimensions
    private int locX;
    private int locY;
    private double width;
    private double height;
    
    /**
     * Constructor for objects of class Book
     */
    public Book (int key, String nm, String auth, int qty, String img)
    {
        id = key;
        name = nm;
        author = auth;
        quantity = qty;
        cover = img;
        /**if (img == null) {
            this.image = DEFAULT_IMAGE;     // add default img if user clicks cancel
        } else {
            this.image = img;
        
        }**/
    
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
        final double WIDTH = 200;
        final double HEIGHT = 250;
        
        //UI.drawImage(this.image, locX, locY, WIDTH, HEIGHT);
        UI.drawImage(cover, locX, locY, WIDTH, HEIGHT);
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
    
    /**
     * Checks if the mouse is over the book
     */
    public int qtybook(double x, double y){
        if ((x >= 100) && (x <= 300) &&
            (y >= 100) && (y <= 400)){
                clickBook ++;
        }
        return clickBook;
    }
    
}
