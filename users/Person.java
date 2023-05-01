package users;

public abstract class Person {

    private String username;
    private String password;
    private String email;

    public Person(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public String getEmail(){
        return this.email;
    }

    public void setUsername(String newUsername){
        this.username = newUsername;
    }

    public void setPassword(String newPassword){
        this.password = newPassword;
    }

    public void setEmail(String newEmail){
        this.email = newEmail;
    }

    
}