import java.util.ArrayList;
class accountData{
    protected String Name;
    protected String Email;
    protected String Password;
}
class user extends accountData{
    user(){}

    public user(String name, String email, String password) {
        Name = name;
        Email = email;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
class admin extends accountData{
    admin(){

    }
    public admin(String name, String email, String password) {
        Name = name;
        Email = email;
        Password = password;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }
}


interface Account {
    ArrayList<accountData> Admin = new ArrayList<>();
    ArrayList<accountData> User = new ArrayList<>();
    static ArrayList AdminList(){
        Admin.add(new admin("Mohamed","mohamedasak@gmail.com","202120216M"));
        Admin.add(new admin("Ahmed","ahmedmohamed2021@gmail.com","202120058Am"));
        return Admin;
    }
    static ArrayList UserList(){
        User.add(new user("Mohamed","mohamedalla23@gmail.com","202120074Ma"));
        User.add(new user("Mahmoud","mahmoudmohamed20@gmail.com","202120081Ma"));
        return User;
    }
    static void addAdmin(String Name, String Email, String Password){
        Admin.add(new admin(Name,Email,Password));
    }
    static void addUser(String Name, String Email, String Password){
        User.add(new user(Name,Email,Password));
    }
}