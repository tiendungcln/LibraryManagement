package menu;

import dao.MemberDAO;
import model.Member;

import java.util.Scanner;

public class MemberMenu {

    private Scanner sc = new Scanner(System.in);
    private MemberDAO memberDAO = new MemberDAO();

    public void start(){

        while (true){

            System.out.println("===== Member Management =====");
            System.out.println("1. Add Member");
            System.out.println("2. Show All Member");
            System.out.println("3. Find Member By ID");
            System.out.println("4. Update Member");
            System.out.println("5. Delete Member");
            System.out.println("0. Back");

            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){

                case 1:
                    addMember();
                    break;

                case 2:
                    showAllMembers();
                    break;

                case 3:
                    findMemberById();
                    break;

                case 4:
                    updateMember();
                    break;

                case 5:
                    deleteMember();
                    break;

                case 0:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }

        }

    }

    public void addMember(){

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        while (!email.endsWith("@gmail.com")) {
            System.out.println("Email must end with @gmail.com");
            System.out.print("Enter email again: ");
            email = sc.nextLine();
        }

        System.out.print("Enter phone: ");
        String phone = sc.nextLine();

        Member member = new Member(name, email, phone);

        memberDAO.addMember(member);

    }

    public void showAllMembers(){}

    public void findMemberById(){}

    public void updateMember(){}

    public void deleteMember(){}

}
