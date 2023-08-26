import java.util.ArrayList; import java.util.Scanner;
public class UserClass extends Operations implements Main{ private int select;
    private int SelectBook; UserClass(){
        ArrayList<Book> bookList;

    }
    void MainViewAndAuthentication(){ System.out.println("Hello in our Book Store"); userGo.Authentication();
        userGo.MainView();

    }
    void MainView(){
        DisplayBooks();
        while (true){
        System.out.println("""
                        What Do you want 
                        1- Add to cart
                        2- Search Book
                        3- Back to Login
                        """);
        select = new Scanner(System.in).nextInt(); if (select==1){
            System.out.println("""
                    What Do you want
                    1- Select with Number
                    2- Select with Search
                    """);
            select = new Scanner(System.in).nextInt();
            if (select==1){
                userGo.DisplayBooks();
                System.out.println("""
                                      
                                Enter Number of book From list
                                                                
                                """);
                select = new Scanner(System.in).nextInt();
                for (int i = 0; i<bookList.size();i++){
                    if (select==i-1){
                        setSearchBook(bookList.get(i).getTitle());
                        userGo.add_To_Cart();
                        break;
                    }
                }
            }

            else if (select==2) {
                System.out.println("Search on Book To Add in Cart");
                userGo.add_To_Cart();

            }
        }

        else if(select==2){
            System.out.println("Search on Book To Add in Cart");
            userGo.Search();

        }
        else if (select==3) { Main.StartProject();

        }

        else {
            System.out.println("Wrong input Try Again");
        }
    }
    }

    void Authentication() {
        userGo.Authentication(1);

    }
    public void add_To_Cart() {
        for (int i = 0; i<bookList.size(); i++){
            if(SelectBook==i){
                setSearchBook(bookList.get(i).getTitle());
            }
        }
        userGo.ListToBuy.add(getSearchBook());
        userGo.addMoreToCart();
    }

    @Override
    void Search() {
        System.out.println("Enter Name of book to find it");
        searchBook = new Scanner(System.in).nextLine();
        for (int i =0;i<bookList.size();i++){
            if(bookList.get(i).getTitle().equals(searchBook)){
            System.out.println("Book is available in store");
            do{
                System.out.println("Do you want add to cart Y/N");
                String putInCart= new Scanner(System.in).nextLine(); if (putInCart=="Y"||putInCart=="y"){
                    setSearchBook(bookList.get(i).getTitle());
                    userGo.add_To_Cart();

                }
                else if (putInCart=="N"||putInCart=="n") {
                    System.out.println("Going to Main View ......");
                    userGo.MainView();
                }
            }while (true);
        }
        }
}
    void DisplayBooks(){
        System.out.println("-------------All books in the store-------------");
        for (int i = 0;i< bookList.size();i++) {
            System.out.println("Book num" + (i + 1) + " | Title: " +
                bookList.get(i).getTitle() + " | Price: "
            + bookList.get(i).getPrice() + " | Description: " + bookList.get(i).getDescription()
            );

        }
    }
}

