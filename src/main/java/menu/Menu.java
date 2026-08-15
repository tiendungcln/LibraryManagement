package menu;

import dao.BookDAO;
import model.Book;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner sc = new Scanner(System.in);
    private BookDAO bookDAO = new BookDAO();

    public void start(){

        while (true){

            // 1. Hiển thị menu
            System.out.println("===== Library Management =====");
            System.out.println("1. Add Book");
            System.out.println("2. Show All Books");
            System.out.println("3. Find Book By ID");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("0. Exit");

            // 2. Nhập lựa chọn
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            // 3. Xử lý lựa chọn
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
                    updateBook();
                    break;

                case 5:
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

        System.out.print("Enter author: ");
        String author = sc.nextLine();

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

        Book book = new Book(title, author, publisher, publishDate, price, isbn, quantity);

        boolean result = bookDAO.addBook(book);

        if (result){
            System.out.println("Add book successfully!");
        }else{
            System.out.println("Add book failed!");
        }

    }

    private void showAllBooks() {

        List<Book> books = bookDAO.showAllBooks();

        for (Book book : books){

            System.out.println(book);

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

        System.out.print("Enter new author: ");
        String author = sc.nextLine();

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

        Book book = new Book(id, title, author, publisher, publishDate, price, isbn, quantity);

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
