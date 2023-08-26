import java.util.ArrayList;
import java.util.Scanner;
public class Book implements Main{
    private String Title;
    private double Price;
    private int Quantity;
    private String Description;
    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }
    public double getPrice() {
        return Price;
    }
    public void setPrice(double price) {
        Price = price;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }
    public int getQuantity() {
        return Quantity;
    }
    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
    public static ArrayList<Book> bookList = new ArrayList<>();
    public Book(){
        if (bookList.size()==0)
          BookList();
    }

    Book(String Title, double Price, int Quantity, String Description){
        setTitle(Title);
        setPrice(Price);
        setQuantity(Quantity);
        setDescription(Description);
    }

    public void BookList(){
        bookList.add(new Book("Biology",15,15,"Sciences"));
        bookList.add(new Book("JAVA",20,25,"Programming"));
        bookList.add(new Book("Calculus",80,10,"Mathematics"));
        bookList.add(new Book("AI and Fetcher",70,30,"Technology"));
        bookList.add(new Book("Bitcoin",100,50,"Economic"));
        bookList.add(new Book("English",10,20,"Language"));
        bookList.add(new Book("Arabic",60,35,"Language"));
        bookList.add(new Book("Network",85,15,"Technology"));
        bookList.add(new Book("Rich and Poor Dad",125,3,"Self development"));
        bookList.add(new Book("Fitness",110,2,"Sport"));
    }
    public void addBook(){
        System.out.println("Enter Title of Book");
        String title = new Scanner(System.in).nextLine();

        System.out.println("Enter Price of Book");
        double price = new Scanner(System.in).nextDouble();

        System.out.println("Enter Quantity of Book");
        int quantity = new Scanner(System.in).nextInt();

        System.out.println("Enter Description of Book");
        String description = new Scanner(System.in).nextLine();

        setTitle(title);
        setPrice(price);
        setQuantity(quantity);
        setDescription(description);

        bookList.add(new Book(getTitle(),getPrice(),getQuantity(),getDescription()));
    }
    public void deleteBook(int del){
        for (int i = 0; i < bookList.size(); i++){
            if (i == del) {
                bookList.remove(i);
                System.out.println("Delete is Successful");
                break;
            }
        }
    }
}