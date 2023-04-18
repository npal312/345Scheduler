package users;
import scheduling.Availability;
import backend.Database;
import scheduling.Invitation;
import scheduling.Schedule;
import scheduling.ScheduleSystem;

public class Manager {
    
    private String username;
    private String password;

    public Manager(String username, String password){
        this.username = username;
        this.password = password;
    }

    private boolean createSchedule(){
        return true;
    }

}