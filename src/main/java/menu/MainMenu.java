package menu;

import java.util.Scanner;

public class MainMenu {

    private Scanner sc = new Scanner(System.in);
    private BookMenu bookMenu = new BookMenu();
    private AuthorMenu authorMenu = new AuthorMenu();
    private MemberMenu memberMenu = new MemberMenu();
    private BorrowMenu borrowMenu = new BorrowMenu();

    public void start(){

        while (true){

            // 1. Hiển thị menu
            System.out.println("===== Library Management =====");
            System.out.println("1. Book Management");
            System.out.println("2. Author Management");
            System.out.println("3. Member Management");
            System.out.println("4. Borrow Management");
            System.out.println("0. Exit");

            // 2. Nhập lựa chọn
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            // 3. Xử lý lựa chọn
            switch (choice){

                case 1:
                    bookMenu.start();
                    break;

                case 2:
                    authorMenu.start();
                    break;

                case 3:
                    memberMenu.start();
                    break;

                case 4:
                    borrowMenu.start();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice!");

            }

        }

    }

}
