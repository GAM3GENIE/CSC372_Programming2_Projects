import java.util.ArrayList;
import java.util.HashSet;

public class Inventory {
    private ArrayList<Book> Inventory;
    private ArrayList<Book> Borrowed;
    private HashSet<Integer> usedIds;

    public Inventory() {
        Inventory = new ArrayList<>();
        Borrowed = new ArrayList<>();
        usedIds = new HashSet<>();
    }

    public void addBook(int id, String title, String author, String isbn, int pages) {
        Book newBook = new Book(id, title, author, isbn, pages);
        Inventory.add(newBook);
        usedIds.add(id);
        System.out.println("Book added successfully!");
    }

    public void borrowBook(int id) {
        if(Inventory.isEmpty()){
            System.out.println("There is no book to borrow");
        }
        for (int i = 0; i < Inventory.size(); i++) {
            Book book = Inventory.get(i);

            if (book.getId() == id) {
                Borrowed.add(book);
                Inventory.remove(i);
                System.out.println("Book borrowed: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not found in Inventory");
    }

    public void returnBook(int id){
        if(Borrowed.isEmpty()){
            System.out.println("No Books are currently borrowed.");
        }

        for (int i = 0; i < Borrowed.size(); i++) {
            Book book = Borrowed.get(i);

            if (book.getId() == id) {
                Inventory.add(book);
                Borrowed.remove(i);
                System.out.println("Book returned: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not found in Borrowed");
    }

    public void printAll(){
        if(Inventory.isEmpty()){
            System.out.println("No Books in inventory.");
        }
        for(Book book : Inventory){
            book.printBookInfo();
        }
    }

    public ArrayList<Book> searchByTitle(String title){
        ArrayList<Book> matches = new ArrayList<>();

        for(Book book : Inventory){
            if(book.getTitle().toLowerCase().contains(title.toLowerCase())){
                matches.add(book);
            }
        }
        return matches;
    }

    // Helper Methods
    public boolean isDuplicateId(int id){
        return usedIds.contains(id);
    }
    public boolean isInventoryEmpty(){
        return Inventory.isEmpty();
    }
    public boolean isBorrowedEmpty(){
        return Borrowed.isEmpty();
    }
}
