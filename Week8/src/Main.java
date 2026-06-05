import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();
        boolean flag = true;

        while(flag){
            System.out.println("\nLibrary Menu");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search by Title");
            System.out.println("5. Print All Books");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");

            try{
                int choice = sc.nextInt();
                sc.nextLine();

                switch(choice){
                    case 1:
                        try {
                            System.out.println("Enter book id: ");
                            int id = sc.nextInt();
                            sc.nextLine();

                            if(inventory.isDuplicateId(id)) {
                                System.out.println("Duplicate id not allowed. Please enter a unique numeric id.");
                                break;
                            }

                            System.out.println("Enter book title: ");
                            String title = sc.nextLine();

                            System.out.println("Enter book author: ");
                            String author = sc.nextLine();

                            System.out.println("Enter ISBN: ");
                            String isbn = sc.nextLine();

                            System.out.println("Enter number of pages: ");
                            int pages = sc.nextInt();
                            sc.nextLine();

                            inventory.addBook(id, title, author, isbn, pages);
                        }catch (InputMismatchException e) {
                            System.out.println("Please enter a valid book id!");
                            sc.nextLine();
                        }
                        break;
                    case 2:
                        if(inventory.isInventoryEmpty()){
                            System.out.println("Cannot borrow a book. There is no inventory.");
                        } else {
                            try {
                                System.out.println("Enter the id of the book to borrow: ");
                                int borrowId = sc.nextInt();
                                sc.nextLine();
                                inventory.borrowBook(borrowId);
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid book numeric id!");
                                sc.nextLine();
                            }
                        }
                        break;
                    case 3:
                        if(inventory.isBorrowedEmpty()){
                            System.out.println("Cannot return a book. No Books are currently borrowed.");
                        } else {
                            try {
                                System.out.println("Enter the id of the book to return: ");
                                int returnId = sc.nextInt();
                                sc.nextLine();
                                inventory.returnBook(returnId);
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid book numeric id!");
                                sc.nextLine();
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Enter the full or partial title of the book to borrow: ");
                        String searchTitle = sc.nextLine();
                        ArrayList<Book> results = inventory.searchByTitle(searchTitle);

                        if(results.isEmpty()){
                            System.out.println("Book not found!");
                        }else {
                            System.out.println("Book found!");
                            for(Book book : results){
                                book.printBookInfo();
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Books currently in Inventory: ");
                        inventory.printAll();
                        break;
                    case 6:
                        System.out.println("Exiting the program. Goodbye!");
                        flag = false;
                        break;
                    default:
                        System.out.println("Invalid menu option. Please enter a number from 1 - 6.");
                }
            }catch(InputMismatchException e){
                System.out.println("Invalid menu option. Please enter a number from 1 - 6.");
                sc.nextLine();
            }
        }
        sc.close();
    }
}