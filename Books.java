import java.util.HashMap;
import ecs100.*;
/**
 * Holds a collection of books in a hashmap.
 * Allows a user to add, find, print all, edit from a menu
 * delete
 * Prevents duplicate entries and includes GUI interaction
 *
 * @author KNG
 * @version 1
 */

public class Books {
  // instance variables
  private HashMap<Integer, Book> library; // declaring the hashmap
  private int currBookId; // store the current id number of the book being added
  private Book currBook; // store the instance of the current Book
  private String newString;
  private Book book;
  int currLikes = 0;
    
  /**
   * Constructor for objects of class Books.
   */
  public Books() {
    // initialise instance variables
    library = new HashMap<Integer, Book>(); // initialise hashmap
        
    // Creating Books
    Book b1 = new Book(1, "The Wicked King", "Holly Black", 2, "TheWickedKing.jpg");
    Book b2 = new Book(2, "1984", "George Orwell", 42, "1984.jpg");
    Book b3 = new Book(3, "Song of Archilles", "Madelline Millar", 20, "SongOfArchilles.jpg");
        
    // Add books to collection
    library.put(1, b1);
    library.put(2, b2);
    library.put(3, b3);
        
    this.currBookId = 3;    // Store the current book id
  }
    
  /**
   * Set bookId.
   */
  public void setBookId() {
    this.currBookId += 1;
  }
    
  /**
   * Checks if string is != null.
   */
  public String newString(String prompt, String stringNullMessage) {
    do {
      newString = UI.askString(prompt);
      if (newString.isEmpty()) {
        UI.println(stringNullMessage);
      }
    } while (newString.isEmpty() || newString.equals(" "));
    return newString;
  }
    
  /**
   * Add a book to collection.
   */
  public void addBook() {
    final int MAX_QUANTITY = 999;
    final int INCREMENT = 1;
    int quantity;
    String name;
    String author;
        
    // Ask the user for details
    // Check if same
    do {
      name = newString("Title: ", "Null Message").trim();
      author = newString("Author: ", "Null").trim();
      if (sameBook(name, author)) {
        UI.println("Book is already in the collection or is a duplicate");
        UI.println("Please try again");
      }
    } while (sameBook(name, author));
    
    // Check boundaries for the number of books added
    do {
      quantity = UI.askInt("Quantity: ");
      if ((quantity > 0) && (quantity <= MAX_QUANTITY)) {
        UI.println("Added");
      } else if (quantity > MAX_QUANTITY) {
        UI.println("Must be less than 1000");
      } else if (quantity < 1) {
        UI.println("Must be greater than 0");
      } else {
        UI.println("Must be a number");
      }
    } while (0 > quantity || quantity > MAX_QUANTITY);
            
    // add a book image for display in the GUI
    String imgFileName = UIFileChooser.open("Choose Image File: ");
        
    // Increment the book ID count and add the hashmap
    setBookId();  // increment the id by 1
    addBook(name, author, quantity, imgFileName);
  }

  /**
   * Add a book to the map.
   */
  public void addBook(String name, String author, int qty) {
    this.setBookId(); // increment by 1 current id
    this.library.put(this.currBookId, new Book(this.currBookId, name, author, qty));
  }
    
  /**
   * Add book to the map.
   */
  public void addBook(String name, String author, int qty, String img) {
    this.library.put(currBookId, new Book(currBookId, name, author, qty, img));
  }
    
  /**
   * Checks if the book is already in the library.
   */
  public boolean sameBook(String name, String author) {
    for (Book b : library.values()) {
      if (b.getName().toLowerCase().equals(name.toLowerCase())
          && b.getAuthor().toLowerCase().equals(author.toLowerCase())) {
        return true;
      }
    }
    return false;
  }  
    
  /**
   * Finds book based on name.
   * Prints out the author and qty if found.
   */
  public void findBook() {
    String bookName = UI.askString("Name of book: ").trim();
    if (findBook(bookName.toLowerCase())) {
      UI.println("Found book!");
      book = getBook();
      UI.println("Author: " + book.getAuthor());
      UI.println("Quantity: " + book.getQuantity());
      UI.println("Likes: " + currLikes);
    } else {
      UI.println("That book does not exist!");  
    }
  }
    
  /**
   * Find a book based on name.
   * Sets the current book instance if found.

   * @return boolean false if not found
   */
  public boolean findBook(String name) {
    // Search for book
    for (int bookId : library.keySet()) {
      if (library.get(bookId).getName().toLowerCase().equals(name.toLowerCase())) {
        currBook = library.get(bookId); // Set the current book
        library.get(bookId).displayBook(); // Show book cover on Canvas
        return true;
      }
    }
    return false;
  }
    
  /**
   * Remove book by asking name and author.
   */
  public void removeBook() {
    String bookNameRemove = UI.askString("Name of book to remove: ").trim();
    String bookAuthorRemove = UI.askString("Author of book to remove: ").trim();
        
    if (removeBook(bookNameRemove.toLowerCase(), bookAuthorRemove.toLowerCase())) {
      UI.println("Removed Book");
    
    } else {
      UI.println("Book does not exist");
    }
  }
    
  /**
   * Remove a book by ID number.
   */
  public boolean removeBook(String name, String author) {
    // Search for book
    for (int bookId : library.keySet()) {
      if (library.get(bookId).getName().toLowerCase().equals(name.toLowerCase())
          && library.get(bookId).getAuthor().toLowerCase().equals(author.toLowerCase())) {
        library.remove(bookId);
        return true;
      }
    }
    return false;
  }

    
  /**
  * Getter for the current book instance.
  */
  public Book getBook() {
    return this.currBook;
  }
    
  /**
   * Print detail of all books.
   */
  public void printAll() {
    // Traverse Map
    for (int bookId : library.keySet()) {
      UI.println(bookId + " Details: ");
      UI.println(library.get(bookId).getName() + ", by "
                  + library.get(bookId).getAuthor() + ", "
                  + library.get(bookId).getQuantity() + " books available");
    }
  }

  /**
   * Do mouse.
   */
  public void doMouse(String action, double x, double y) {
    //UI.println(action + ";" + x + ";" + y);
    if (action.equals("clicked") && (this.book != null)) {
      int getLikes = this.book.qtybook(x, y);
      UI.println("Likes: " + getLikes);
      //int storedLikes = getLikes;
      currLikes = getLikes;
    }
  }
}

