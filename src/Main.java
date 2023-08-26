import java.util.Scanner;
public interface Main {
    static UserClass userGo = new UserClass();
    static AdminClass adminGo = new AdminClass();
    static void main(String[] args) {
        StartProject();
    }
    static void StartProject(){

        boolean exit = false;
        do {
            System.out.println("""
                ---Book Store System---
                -----------------------
                User or Admin ?
                1- User
                2- Admin
                3- Exit
                """);
            int op = new Scanner(System.in).nextInt();
            switch (op){
                case 1:
                    userGo.MainViewAndAuthentication();
                    break;
                case 2:
                    adminGo.MainViewAndAuthentication();
                    break;
                case 3:
                    System.out.println("Thank you for use our system");
                    exit = true;
                    break;
                default:
                    System.out.println("Wrong input try Again");
                    break;
            }
        }while (exit != true);
    }
}