package menu;

import dao.AuthorDAO;
import dao.BookDAO;
import model.Author;
import model.Book;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class BookMenu {

    private Scanner sc = new Scanner(System.in);
    private BookDAO bookDAO = new BookDAO();
    private AuthorDAO authorDAO = new AuthorDAO();

    public void start(){

        while (true){

            System.out.println("===== Library Management =====");
            System.out.println("1. Add Book");
            System.out.println("2. Show All Books");
            System.out.println("3. Find Book By ID");
            System.out.println("4. Search Books by title");
            System.out.println("5. Sort Books by Price");
            System.out.println("6. Sort Books by Publish Date");
            System.out.println("7. Filter Books by Price");
            System.out.println("8. Update Book");
            System.out.println("9. Delete Book");
            System.out.println("0. Exit");

            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){

                case 1:
                    addBook();
                    break;

                case 2:
                    showAllBooks();
                    break;

                case 3:
                    findBookById();
                    break;

                case 4:
                    searchBooksByTitle();
                    break;

                case 5:
                    sortBooksByPrice();
                    break;

                case 6:
                    sortBooksByPublishDate();
                    break;

                case 7:
                    filterBooksByPrice();
                    break;

                case 8:
                    updateBook();
                    break;

                case 9:
                    deleteBook();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice!");

            }

        }

    }

    private void addBook() {

        System.out.print("Enter title: ");
        String title = sc.nextLine();

        System.out.println("===== Authors =====");
        List<Author> authors = authorDAO.showAllAuthors();

        for (Author author : authors){
            System.out.println(author);
        }

        System.out.print("Enter author: ");
        int authorId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter publisher: ");
        String publisher = sc.nextLine();

        System.out.print("Enter publish date (yyyy-MM-dd): ");
        Date publishDate = Date.valueOf(sc.nextLine());

        System.out.print("Enter price: ");
        BigDecimal price = sc.nextBigDecimal();
        sc.nextLine();

        System.out.print("Enter isbn: ");
        String isbn = sc.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        Book book = new Book(title, authorId, publisher, publishDate, price, isbn, quantity);

        boolean result = bookDAO.addBook(book);

        if (result){
            System.out.println("Add book successfully!");
        }else{
            System.out.println("Add book failed!");
        }

    }

    private void showAllBooks() {

        List<Book> books = bookDAO.showAllBooks();

        if (books.isEmpty()){
            System.out.println("No books found!");
        }else{
            for (Book book : books){
                System.out.println(book);
            }
        }

    }

    private void findBookById() {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Book book = bookDAO.findBookById(id);

        if (book != null){
            System.out.println(book);
        }else{
            System.out.println("Book not found!");
        }

    }

    private void searchBooksByTitle(){

        System.out.print("Enter name book: ");
        String keyword = sc.nextLine();

        List<Book> books = bookDAO.searchBooksByTitle(keyword);

        if (books.isEmpty()){
            System.out.println("No books found with this title!");
        }else{
            for (Book book : books){
                System.out.println(book);
            }
        }

    }

    private void sortBooksByPrice(){

        System.out.print("Sort price ascending? (true/false): ");
        boolean ascending = sc.nextBoolean();
        sc.nextLine();

        List<Book> books = bookDAO.sortBooksByPrice(ascending);

        if (books.isEmpty()){
            System.out.println("No books found!");
        }else{
            for (Book book : books){
                System.out.println(book);
            }
        }

    }

    private void sortBooksByPublishDate(){

        System.out.print("Sort publish date ascending? (true/false): ");
        boolean ascending = sc.nextBoolean();
        sc.nextLine();

        List<Book> books = bookDAO.sortBooksByPublishDate(ascending);

        if (books.isEmpty()){
            System.out.println("No books found!");
        }else{
            for (Book book : books){
                System.out.println(book);
            }
        }

    }

    private void filterBooksByPrice(){

        System.out.print("Enter minimum price: ");
        BigDecimal minPrice = sc.nextBigDecimal();
        sc.nextLine();

        System.out.print("Enter maximum price: ");
        BigDecimal maxPrice = sc.nextBigDecimal();
        sc.nextLine();

        List<Book> books = bookDAO.filterBooksByPrice(minPrice, maxPrice);

        if (books.isEmpty()){
            System.out.println("No books found in this price range!");
        }else{
            for (Book book : books){
                System.out.println(book);
            }
        }

    }

    private void updateBook() {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        // Tìm sách theo ID
        Book oldBook = bookDAO.findBookById(id);

        if (oldBook == null) {
            System.out.println("Book not found!");
            return;
        }

        // Hiển thị thông tin hiện tại
        System.out.println("\n===== Current Book =====");
        System.out.println(oldBook);

        System.out.print("Enter new title: ");
        String title = sc.nextLine();

        System.out.println("===== Authors =====");
        List<Author> authors = authorDAO.showAllAuthors();

        for (Author author : authors){
            System.out.println(author);
        }

        System.out.print("Enter new author: ");
        int authorId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter new publisher: ");
        String publisher = sc.nextLine();

        System.out.print("Enter new publish date (yyyy-MM-dd): ");
        Date publishDate = Date.valueOf(sc.nextLine());

        System.out.print("Enter new price: ");
        BigDecimal price = sc.nextBigDecimal();
        sc.nextLine();

        System.out.print("Enter new isbn: ");
        String isbn = sc.nextLine();

        System.out.print("Enter new quantity: ");
        int quantity = sc.nextInt();
        sc.nextLine();

        Book book = new Book(id, title, authorId, publisher, publishDate, price, isbn, quantity);

        boolean result = bookDAO.updateBook(book);

        if (result){
            System.out.println("Update book successfully!");
        }else{
            System.out.println("Update book failed!");
        }

    }

    private void deleteBook() {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean result = bookDAO.deleteBook(id);

        if (result) {
            System.out.println("Delete book successfully!");
        }else{
            System.out.println("Delete book failed!");
        }

    }

}
