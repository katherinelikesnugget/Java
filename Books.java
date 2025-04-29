import java.util.HashMap;
import ecs100.*;
/**
 * Holds a collection of books in a hashmap
 * Allows a user to add, find, print all, edit from a menu
 * delete
 * prevent use from adding a duplicate book
 *
 * @author KNG
 * @version (a version number or a date)
 */
public class Books
{
    // fields
    private HashMap<Integer,Book> library; // declaring the hashmap
    private int currBookId; // store thhhe current id number of the book being added
    private Book currBook; // store the instance of the current Book
    
    
    /**
     * Constructor for objects of class Books
     */
    public Books()
    {
        // initialise instance variables
        library = new HashMap<Integer, Book>(); // initialise hashmap
        
        // Creating Books
        Book b1 = new Book(1, "The Wicked King", "Holly Black", 2);
        Book b2 = new Book(2, "1984", "George Orwell", 42);
        Book b3 = new Book(3, "Song of Archilles", "Madelline Millar", 20);
        
        // Add books to collection
        library.put(1, b1);
        library.put(2, b2);
        library.put(3, b3);
        
        this.currBookId = 3;    // Store the current book id
    }
    
    /**
     * Set bookId
     */
    public void setBookId() {
        this.currBookId += 1;
    }
    
    /**
     * Add book to the map
     */
    public void addBook(String name, String author, int qty, String img) {
        library.put(currBookId, new Book(currBookId, name, author, qty, img));
    }
    
    /**
     * Find a book based on name
     * Sets the current book instance if found
     * @return boolean false if not found
     */
    public boolean findBook(String name) {
        // Search for book
        for (int bookId: library.keySet()) {
            if (library.get(bookId).getName().toLowerCase().equals(name.toLowerCase())) {
                currBook = library.get(bookId); // Set the current book
                library.get(bookId).displayBook(); // Show book cover on Canvas
                return true;
            }
        }
        return false;
    }
    
    /**
     * Getter for the current book instance
     */
    public Book getBook(){
        return this.currBook;
    }
    
    
    /**
     * Print detail of all books
     */
    public void printAll() {
        // Traverse Map
        for (int bookId : library.keySet()) {
            UI.println(bookId + " Details: ");
            UI.println(library.get(bookId).getName() + " "
                        + library.get(bookId).getAuthor() + " "
                        + library.get(bookId).getQuantity());
        }
    }
    
    /**
     * Edit number of books (qty)
     */
    public void editQty(){
        //UI.println(bookId);
        
    }
    
    
    /**
     * Menu to print and call appropriate methods
     */
    public void menu() {
        // Print menu and force choice
        String choice;
        do {
            UI.println("(A)dd a book");
            UI.println("(F)ind a book");
            UI.println("(P)rint all");
            UI.println("(Q)uit");
            
            choice = UI.askString("Enter a choice: ");
            
            if (choice.equalsIgnoreCase("A")) {
                // Ask user for title, author and quantity
                String bookName = UI.askString("Name of book: ");
                String bookAuthor = UI.askString("Author of book: ");
                Integer bookQty = UI.askInt("Quantity of book: ");
                addBook(bookName, bookAuthor, bookQty, null);
                UI.println("Added " + bookName + " by " + bookAuthor + ", " + bookQty + " copies available");
            } else if (choice.equalsIgnoreCase("F")){
                // Ask user for a book
                String bookName = UI.askString("Name of book: ");
                
                if (findBook(bookName)) {
                    UI.println("Found book");
                    UI.println("Name: " + currBook.getName());
                    UI.println("Author: " + currBook.getAuthor());
                    UI.println("Quantity: " + currBook.getQuantity());
                } else {
                    UI.println(bookName + " not found");
                }
                
            } else if (choice.equalsIgnoreCase("P")){
                printAll();
            } else if (choice.equalsIgnoreCase("Q")){
                UI.println("Goodbye!");
                UI.quit();
            } else {
                UI.println("Not a valid choice knucklehead!");
            }
        } while (!choice.equalsIgnoreCase("Q"));    // loop unitl choice is 'Q'  
    }
}
