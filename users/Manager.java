package users;
import scheduling.Availability;
import backend.Database;
import scheduling.Invitation;
import scheduling.Schedule;
import scheduling.ScheduleSystem;

public class Manager extends Person{

    /**
     * contructor for manager
     * @param username
     * @param password
     * @param email
     */
    public Manager(String username, String password, String email){
        super(username, password, email);
    }

    private boolean createSchedule(){
        System.out.println("Creating schedule.");
        return true;
    }
    
    private boolean setConstraints(){
        System.out.println("Constraints set");
        return true;
    }

}
