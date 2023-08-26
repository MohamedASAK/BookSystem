import java.util.ArrayList;
import java.util.Scanner;
public abstract class Operations extends Book implements Main,Account {
    private String op_Authentication; //login and register
    private int op_Buy;
    private boolean checkInput = false;
    protected String searchBook;
    public ArrayList <String> ListToBuy =  new ArrayList<>();

    void setSearchBook(String searchBook){
        this.searchBook = searchBook;
    }
    String getSearchBook(){
        return searchBook;
    }
    abstract void DisplayBooks();
    abstract void Search ();
    abstract void add_To_Cart();
    void Authentication(int Check){
        do {
            System.out.println("""
                ---------------------------------------------
                
                Authentication
                Do you have account
                Y/y for Yes : N/n for No
                
                """
            );
            op_Authentication = new Scanner(System.in).nextLine();
            switch (op_Authentication) {
                case "Y": case "y":
                    checkInput = true;
                    login(Check);
                    break;
                case "N": case "n":
                    checkInput = true;
                    register(Check);

                default:
                    System.out.println("Wrong Input");
                    checkInput = false;
            }
        } while (!checkInput);
    }
    public void login(int check){
        System.out.print("\nEnter your Email : ");
        String Email = new Scanner(System.in).nextLine();
        Email = Email.toLowerCase();
        System.out.print("\nEnter your Password : ");
        String Password = new Scanner(System.in).nextLine();
        do{
            if(check == 1) // user
            {
                Account.UserList();
                for (int i = 0; i < Account.User.size(); i++){
                    if ((Account.User.get(i).Email).equals(Email) &&
                            (Account.User.get(i).Password).equals(Password))
                        break;
                }
                break;
            }
            else if (check == 2) //admin
            {
                Account.AdminList();
                for (int i = 0; i < Account.Admin.size(); i++){
                    if ((Account.Admin.get(i).Email).equals(Email) &&
                            (Account.Admin.get(i).Password).equals(Password))
                        break;
                }
                break;
            }
        }while(true);
    }
    public void register(int check){
        System.out.print("\nEnter your Name : ");
        String name = new Scanner(System.in).nextLine();

        System.out.print("\nEnter your Email : ");
        String Email = new Scanner(System.in).nextLine();
        Email=Email.toLowerCase();


        String ConfirmPassword = null;
        String Password = null;
        do{
            System.out.print("\nEnter your Password : ");
            Password = new Scanner(System.in).nextLine();
            System.out.print("\nEnter your Password Again : ");
            ConfirmPassword = new Scanner(System.in).nextLine();
            if(Password.equals(ConfirmPassword)){
                break;
            }
            else {
                System.out.println("""
                                    Wrong isn't identical
                                    Wright Password again
                                    
                                    """);
            }
        }while(true);

        if (check == 1){
            Account.addUser(name,Email,Password);
        }
        else if (check == 2){
            Account.addAdmin(name,Email,Password);
        }
        else{
            System.out.println("Wrong input");
            Main.StartProject();
        }
    }
    public void addMoreToCart() {
        String check;
        boolean breakLoop = false;
        do {
            System.out.println("Do you want add another book Y/N");
            check = new Scanner(System.in).nextLine();
            switch (check) {
                case "Y": case "y":
                    breakLoop = true;
                    System.out.println("Going To Search Another Book.......");
                    userGo.add_To_Cart();
                    break;
                case "N": case "n":
                    breakLoop = true;
                    cart();
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
            break;
        }while (breakLoop = false);
    }
    public void cart(){
        System.out.println("Are You Sure to add all this item to cart Y/N");
        do {
            String Sure = new Scanner(System.in).nextLine();
            switch (Sure) {
                case "Y":
                case "y":
                    System.out.println("Going To Buy.......");
                    checkInput = true;
                    Buy();
                    break;
                case "N":
                case "n":
                    System.out.println("Going To Display.......");
                    for (int i = 0 ; i < ListToBuy.size() ; i++){
                        if(!ListToBuy.isEmpty()){
                            ListToBuy.remove(i);
                        }
                    }
                    userGo.DisplayBooks();
                    checkInput = true;
                    break;
                default:
                    System.out.println("Wrong input");
                    checkInput = false;
                    break;
            }
        } while (!checkInput);
    }
    public void Buy () {
        do {
            System.out.println("""
                        Please select a payment method:
                        1- Credit card
                        2- Payment upon receipt
                        3- Go Back
                        """);
            op_Buy = new Scanner(System.in).nextInt();

            switch (op_Buy) {
                case 1:
                    Bill(1);
                    checkInput = true;
                    break;
                case 2:
                    Bill(2);
                    checkInput = true;
                    break;
                case 3:
                    userGo.add_To_Cart();
                    break;
                default:
                    System.out.println("Wrong Input");
                    checkInput = false;
            }
        } while (!checkInput);
    }
    public void Bill(int TypeOfMethod){
        System.out.println("""
                    Do you wand Pay the full amount or in installments select:
                    1- Pay the full amount
                    2- Payment in installments
                    """);
        int Pay = new Scanner(System.in).nextInt();
        switch (TypeOfMethod){
            case 1: case 2:
                switch (Pay){
                    case 1: case 2:
                        double PriceOfAll = 0;
                        for (int i = 0;i<ListToBuy.size();i++)
                        {
                            for (int j = 0;j<bookList.size();j++) {
                                if ((bookList.get(j).getTitle()).equals(ListToBuy.get(i))) {
                                    PriceOfAll += bookList.get(j).getPrice();
                                }
                            }
                        }
                        System.out.println("Your Total is : "+PriceOfAll);
                        System.out.println("""
                        Thank you for pay from our store
                        Go to Main View
                        """);
                        autoUpdate(true);
                        break;
                    default:
                        System.out.println("Wrong Input");
                        Buy();
                }
                break;
            default:
        }

    }
    public void autoUpdate(boolean Check){

            for (int j = 0;j<bookList.size();j++){
        for (int i = 0;i<ListToBuy.size();i++) {
                if ((ListToBuy.get(i)).equals(bookList.get(j).getTitle())) {
                    bookList.get(i).setQuantity(getQuantity()-1);
                }
            }
        }
    }
}