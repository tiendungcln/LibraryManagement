package menu;

import dao.BookDAO;
import dao.BorrowDAO;
import dao.MemberDAO;
import model.Book;
import model.Borrow;
import model.Member;

import java.util.List;
import java.util.Scanner;

public class BorrowMenu {

    private Scanner sc = new Scanner(System.in);
    private BorrowDAO borrowDAO = new BorrowDAO();
    private MemberDAO memberDAO = new MemberDAO();
    private BookDAO bookDAO = new BookDAO();

    public void start(){

        while (true){

            System.out.println("1. Add Borrow");
            System.out.println("2. View All Borrows");
            System.out.println("3. Find Borrow By ID");
            System.out.println("4. Return Book");
            System.out.println("5. View Active Borrows");
            System.out.println("6. View Borrow History");
            System.out.println("0. Back");

            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){

                case 1:
                    addBorrow();
                    break;

                case 2:
                    showAllBorrows();
                    break;

                case 3:
                    findBorrowById();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice!");

            }

        }

    }

    public void addBorrow(){

        List<Member> members = memberDAO.showAllMembers();
        for (Member member : members){
            System.out.println(member);
        }

        System.out.print("Enter Member ID: ");
        int memberId = sc.nextInt();
        sc.nextLine();

        Member member = memberDAO.findMemberById(memberId);

        while (member == null){

            System.out.println("Member not found!");

            System.out.print("Enter Member ID again: ");
            memberId = sc.nextInt();
            sc.nextLine();

            member = memberDAO.findMemberById(memberId);

        }

        List<Book> books = bookDAO.showAllBooks();
        for (Book book : books){
            System.out.println(book);
        }

        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();
        sc.nextLine();

        Book book = bookDAO.findBookById(bookId);

        while (book == null){

            System.out.println("Book not found!");

            System.out.print("Enter Book ID again: ");
            bookId = sc.nextInt();
            sc.nextLine();

            book = bookDAO.findBookById(bookId);

        }

        Borrow borrow = new Borrow(memberId, bookId);

        boolean result = borrowDAO.addBorrow(borrow);

        if (result){
            System.out.println("Add borrow successfully!");
        }else{
            System.out.println("Add borrow failed!");
        }

    }

    public void showAllBorrows(){

        List<Borrow> borrows = borrowDAO.showAllBorrows();

        for (Borrow borrow : borrows){

            System.out.println(borrow);

        }

    }

    public void findBorrowById(){

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Borrow borrow = borrowDAO.findBorrowById(id);

        if (borrow != null){
            System.out.println(borrow);
        }else{
            System.out.println("Borrow not found!");
        }

    }

}
