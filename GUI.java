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
    private Book book;      // declare book instance

    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        books = new Books();   // instantiate the books object
        UI.initialise();
        UI.addButton("Print All", books::printAll);
        UI.addButton("Add", this::addBook);
        UI.addButton("Find", this::findBook);
        UI.addButton("Quit", UI::quit);
    }
    
    /**
     * Add a book to collection
     */
    public void addBook(){
        final int MAX_QUANTITY = 99;
        final int INCREMENT = 1;
        int quantity;
        
        // Ask the user for details
        String name = UI.askString("Title: ");
        String author = UI.askString("Author: ");
        
        // Check boundaries for the number of books added
        do {
            quantity = UI.askInt("Quantity: ");
            if ((quantity > 0) && (quantity <= MAX_QUANTITY)) {
                UI.println("Added");
            } else if (quantity > MAX_QUANTITY) {
                UI.println("Must be less than 100");
            } else if (quantity < 1) {
                UI.println("Must be greater than 0");
            } else {
                UI.println("Must be a number");
            }
            } while (0 > quantity || quantity > MAX_QUANTITY);
            
            // add a book image for display in the GUI
            String imgFileName = UIFileChooser.open("Choose Image File: ");
        
            // Increment the book ID count and add the hashmap
            books.setBookId();  // increment the id by 1
            books.addBook(name, author, quantity, null);
    }
    /**
     * Finds book based on name
     * Prints out the author and qty if found
     */
    public void findBook(){
        String bookName = UI.askString("Name of books: ");
        if (books.findBook(bookName.toLowerCase())) {
            UI.println("Found book!");
            book = books.getBook();
            UI.println("Author: " + book.getAuthor());
            UI.println("Quantity: " + book.getQuantity());
        } else {
            UI.println("That book does not exist!");  
        }
    }
}

