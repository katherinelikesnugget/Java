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
    int currLikes = 0;

    private String newString;
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
        UI.addButton("Remove", this::removeBook);
        
        UI.setMouseListener(this::doMouse);
        
    }
    
    /**
     * Checks if string is != null
     */
    public String newString(String prompt, String stringNullMessage) {
        do {
            newString = UI.askString(prompt);
            if (newString.isEmpty()){
                UI.println(stringNullMessage);
            }
        } while (newString.isEmpty());
        return newString;
    }
    
    
    /**
     * Add a book to collection
     */
    public void addBook(){
        final int MAX_QUANTITY = 99;
        final int INCREMENT = 1;
        int quantity;
        
        // Ask the user for details
        String name = newString("Title: ", "Null Message");
        String author = newString("Author: ", "Null");
        
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
            books.addBook(name, author, quantity, imgFileName);
    }
    /**
     * Finds book based on name
     * Prints out the author and qty if found
     */
    public void findBook(){
        String bookName = UI.askString("Name of book: ");
        if (books.findBook(bookName.toLowerCase())) {
            UI.println("Found book!");
            book = books.getBook();
            UI.println("Author: " + book.getAuthor());
            UI.println("Quantity: " + book.getQuantity());
            UI.println("Likes: " + currLikes);
        } else {
            UI.println("That book does not exist!");  
        }
    }
    
    public void removeBook(){
        String bookNameRemove = UI.askString("Name of book to remove: ");
        String bookAuthorRemove = UI.askString("Author of book to remove: ");
        
        if(books.removeBook(bookNameRemove.toLowerCase(), bookAuthorRemove.toLowerCase())){
            UI.println("Removed Book");
            book = books.getBook();
            //library.remove(book);
        }
    }
    
    /**
     * Do mouse
     */
    public void doMouse(String action, double x, double y){
        //UI.println(action + ";" + x + ";" + y);
        if (action.equals("clicked") && (this.book != null)){
            int getLikes= this.book.qtybook(x, y);
            UI.println("Likes: " + getLikes);
            //int storedLikes = getLikes;
            currLikes = getLikes;
        }
    }
}

