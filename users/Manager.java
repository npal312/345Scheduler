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
        return true;
    }

}