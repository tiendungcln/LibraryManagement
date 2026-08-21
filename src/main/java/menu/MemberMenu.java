package menu;

import dao.MemberDAO;
import model.Member;

import java.util.List;
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

    public void showAllMembers(){

        List<Member> members = memberDAO.showAllMembers();

        for (Member member : members){

            System.out.println(member);

        }

    }

    public void findMemberById(){

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Member member = memberDAO.findMemberById(id);

        if (member != null){
            System.out.println(member);
        }else{
            System.out.println("Member not found!");
        }

    }

    public void updateMember(){

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Member oldMember = memberDAO.findMemberById(id);

        if (oldMember == null){
            System.out.println("Author not found!");
            return;
        }

        System.out.println("\n===== Current Member =====");
        System.out.println(oldMember);

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

        Member member = new Member(id, name, email, phone);

        boolean result = memberDAO.updateMember(member);

        if (result){
            System.out.println("Update member successfully!");
        }else{
            System.out.println("Update member failed!");
        }

    }

    public void deleteMember(){

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        boolean result = memberDAO.deleteMember(id);

        if (result) {
            System.out.println("Delete member successfully!");
        }else{
            System.out.println("Delete member failed!");
        }

    }

}
