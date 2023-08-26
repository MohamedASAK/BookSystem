import java.util.ArrayList;
import java.util.Scanner;
public class AdminClass extends Operations implements Main{
    private int SelectOp;
    protected int select;
    void MainViewAndAuthentication(){
        adminGo.Authentication(2);
        adminGo.MainView();
    }
    void MainView(){
        do{
            System.out.println("""
            Choose the operation you want
            1- Show All Book in store
            2- Update Book
            3- Add Book
            4- Delete Book
            5- Back To Login
            """
            );
            SelectOp = new Scanner(System.in).nextInt();
            switch (SelectOp) {
                case 1 :
                    adminGo.DisplayBooks();
                    break;
                case 2 :
                    adminGo.UpdateAdmin();
                    break;
                case 3:
                    adminGo.Add();
                    break;
                case 4:
                    adminGo.Delete();
                    break;
                case 5:
                    Main.StartProject();

                    break;
                default:
                    System.out.println("Wrong input");

            }
        } while (true);
    }
    @Override
    void DisplayBooks() {
        for (int i = 0;i< bookList.size();i++) {
            System.out.println("Book num" + (i + 1) + " | Title: " + bookList.get(i).getTitle() + " | Price: "
                    + bookList.get(i).getPrice() + " | Description: " + bookList.get(i).getDescription()+
                    " | Quantity in store: "+  bookList.get(i).getQuantity()
            );
        }
    }
   @Override
   void Search() {
        System.out.println("Enter Name of book to find it");
        String searchBook = new Scanner(System.in).nextLine();
        for (int i =0;i<bookList.size();i++) {
            if (bookList.get(i).getTitle().equals(searchBook)) {
                System.out.println("Book is available in store");
                System.out.println("""
                        Book is available in store
                        Do you Want
                        1- Add Book
                        2- Delete Book
                        3- Update Book
                        4- Go to MainView for Admin
                        """);
                int Select = new Scanner(System.in).nextInt();
                if (Select == 1){
                    adminGo.Add();
                }
                else if(Select == 2){
                   adminGo.Delete();
                }
                else if (Select == 3) {
                    adminGo.UpdateAdmin();
                }
                else if(Select == 4){
                    System.out.println("Going to MainView ......");
                    adminGo.MainView();
                }
            }
            else if (i == bookList.size()) {
                System.out.println("""
                        Book isn't available in store
                        Do you Want
                        1- Add Book
                        2- Delete Book
                        3- Update Book
                        4- Go to MainView for Admin
                        """);
                int Select = new Scanner(System.in).nextInt();
                if (Select == 1){
                    adminGo.Add();
                }
                else if(Select == 2){
                    adminGo.UpdateAdmin();
                }
                else if (Select == 3) {
                    System.out.println("Go to MainView ......");
                    adminGo.MainView();
                }
            }
        }
    }
   @Override
   void add_To_Cart() {}
   void UpdateAdmin() {
    adminGo.DisplayBooks();
    System.out.println("\nSelect Book Number of book to update");
    select = new Scanner(System.in).nextInt();
    System.out.println("""
                                           
            Select Type of Update this book
            1- Title
            2- Price
            3- Description
            4- Quantity
            
            Another Type
            5- Add Book
            6- Delete Book
            7- Go to Main View
            """);
    do{
        int selectType = new Scanner(System.in).nextInt();
        switch (selectType) {
            case 1:
                System.out.println("Enter new title for book");
                String NewTitle = new Scanner(System.in).nextLine();
                bookList.get(select - 1).setTitle(NewTitle);
                System.out.println("Title has been updated");
                adminGo.MainView();
                break;
            case 2:
                System.out.println("Enter new price for book");
                double NewPrice = new Scanner(System.in).nextDouble();
                bookList.get(select - 1).setPrice(NewPrice);
                System.out.println("Price has been updated");
                adminGo.MainView();
                break;
            case 3:
                System.out.println("Enter new Description for book");
                String NewDescription = new Scanner(System.in).nextLine();
                bookList.get(select - 1).setDescription(NewDescription);
                System.out.println("Description has been updated");
                adminGo.MainView();
                break;
            case 4:
                System.out.println("Enter new Quantity for book");
                double NewQuantity = new Scanner(System.in).nextDouble();
                bookList.get(select - 1).setPrice(NewQuantity);
                System.out.println("Quantity has been updated");
                adminGo.MainView();
                break;
            case 5:
                System.out.println("Go to add new book");
                Add();
            case 6:
                System.out.println("Go to delete book");
                Delete();
            case 7:
                System.out.println("Go to MainView");
                adminGo.MainView();
            default:
                System.out.println("Wrong input Try Again");
                break;
        }
    }while (true);
}
    void Add(){
        adminGo.addBook();
        System.out.println("Book is added");
        adminGo.MainView();
    }
    void Delete(){
        adminGo.DisplayBooks();
        System.out.println("Select Book Number of book to delete");
        int delSelect = new Scanner(System.in).nextInt();
        int Del = delSelect - 1;
        deleteBook(Del);
        System.out.println("Book is deleted");
        adminGo.MainView();
    }
}