package entity;

public class User {


















    private int id;
    private  String userName;
    private  String email;
    private  String password;

    public void setId(int id) {
        this.id = id;
        return;                                     //setid
    }

    public int getId() {                  //getid
        return id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        return;                                        //setUsername
    }

    public String getUserName() {
        return userName;                                      //GetUserName
    }

    public void setEmail(String email) {
        this.email = email;
        return;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
        return;
    }

    public String getPassword() {
        return password;
    }
}
