package users;
import scheduling.Availability;
import backend.Database;
import scheduling.Invitation;
import scheduling.Schedule;
import scheduling.ScheduleSystem;

import java.util.ArrayList;
import java.util.HashMap;

public class Employee {
    
    public String position;
    private String username;
    private String password;
    private Availability available;

    public Employee(String position, String username, String password){
        this.position = position;
        this.username = username;
        this.password = password;
    }


    public Employee(String position, String username, String password, Availability available){
        this.position = position;
        this.username = username;
        this.password = password;
        this.available = available;
    }


    //ADD INPUTS (like viewing schedule having a schedule input)

    private Availability uploadSchedule(){
        HashMap<String, ArrayList<String>> free = new HashMap<String, ArrayList<String>>();
        HashMap<String, ArrayList<String>> busy = new HashMap<String, ArrayList<String>>();
        return new Availability(free, busy);
    }

    private Availability manualSchedule(){
        HashMap<String, ArrayList<String>> free = new HashMap<String, ArrayList<String>>();
        HashMap<String, ArrayList<String>> busy = new HashMap<String, ArrayList<String>>();
        return new Availability(free, busy);
    }

    private boolean confirmAvailability(){
        return true;
    }

    private boolean viewSchedule(){ //for end of project when schedule is out
        return true;
    }

}
