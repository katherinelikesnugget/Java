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
        UI.addButton("Remove", this::removeBook);
        UI.addButton("Quit", UI::quit);
        
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
        } while (newString.isEmpty() || newString == " ");
        return newString;
    }
    
    
    /**
     * Add a book to collection
     */
    public void addBook(){
        final int MAX_QUANTITY = 99;
        final int INCREMENT = 1;
        int quantity;
        String name;
        String author;
        
        // Ask the user for details
        // Check if same
        do{
            name = newString("Title: ", "Null Message").trim();
            author = newString("Author: ", "Null").trim();
            if (this.books.sameBook(name, author)) {
                UI.println("Book is already in the collection or is a duplicate");
                UI.println("Please try again");
            }
        } while(this.books.sameBook(name, author));

        
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
        String bookName = UI.askString("Name of book: ").trim();
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
        String bookNameRemove = UI.askString("Name of book to remove: ").trim();
        String bookAuthorRemove = UI.askString("Author of book to remove: ").trim();
        
        if(books.removeBook(bookNameRemove.toLowerCase(), bookAuthorRemove.toLowerCase())){
            UI.println("Removed Book");
            //book = books.getBook();
            //library.remove(book);
        } else {
            UI.println("Book does not exist");
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

