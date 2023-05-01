package users;

public abstract class Person {

    private String username;
    private String password;
    private String email;

    /**
     * contructor for person
     * @param username
     * @param password
     * @param email
     */
    public Person(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }

    //Getters and setters below
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