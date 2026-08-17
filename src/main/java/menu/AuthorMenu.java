package menu;

import dao.AuthorDAO;
import model.Author;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class AuthorMenu {

    private Scanner sc = new Scanner(System.in);
    private AuthorDAO authorDAO = new AuthorDAO();

    public void start(){

        while (true){

            System.out.println("===== Author Management =====");
            System.out.println("1. Add Author");
            System.out.println("2. Show All Authors");
            System.out.println("3. Find Author By ID");
            System.out.println("4. Update Author");
            System.out.println("5. Delete Author");
            System.out.println("0. Back");

            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){

                case 1:
                    addAuthor();
                    break;

                case 2:
                    showAllAuthors();
                    break;

                case 3:
                    findAuthorById();
                    break;

                case 4:
                    updateAuthor();
                    break;

                case 5:
                    deleteAuthor();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice!");

            }

        }

    }

    public void addAuthor(){

        System.out.print("Enter author name: ");
        String authorName = sc.nextLine();

        System.out.print("Enter country: ");
        String country = sc.nextLine();

        System.out.print("Enter birth date (yyyy-MM-dd): ");
        Date birthDate = Date.valueOf(sc.nextLine());

        Author author = new Author(authorName, country, birthDate);

        boolean result = authorDAO.addAuthor(author);

        if (result){
            System.out.println("Add author successfully!");
        }else{
            System.out.println("Add author failed!");
        }

    }

    public void showAllAuthors(){

        List<Author> authors = authorDAO.showAllAuthors();

        for (Author author : authors){

            System.out.println(author);

        }

    }

    public void findAuthorById(){

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Author author = authorDAO.findAuthorById(id);

        if (author != null){
            System.out.println(author);
        }else{
            System.out.println("Author not found!");
        }

    }

    public void updateAuthor(){

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Author oldAuthor = authorDAO.findAuthorById(id);

        if (oldAuthor == null){
            System.out.println("Author not found!");
            return;
        }

        System.out.println("\n===== Current Author =====");
        System.out.println(oldAuthor);

        System.out.print("Enter author name: ");
        String authorName = sc.nextLine();

        System.out.print("Enter country: ");
        String country = sc.nextLine();

        System.out.print("Enter birth date (yyyy-MM-dd): ");
        Date birthDate = Date.valueOf(sc.nextLine());

        Author author = new Author(id, authorName, country, birthDate);

        boolean result = authorDAO.updateAuthor(author);

        if (result){
            System.out.println("Update author successfully!");
        }else{
            System.out.println("Update author failed!");
        }

    }

    public void deleteAuthor(){

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean result = authorDAO.deleteAuthor(id);

        if (result) {
            System.out.println("Delete author successfully!");
        }else{
            System.out.println("Delete author failed!");
        }

    }

}
