package scheduling;

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
        return new Availability(new HashMap<>(1, 2), new HashMap<>(1, 2));
    }

    private Availability manualSchedule(){
        return new Availability(new HashMap<>(1, 2), new HashMap<>(1, 2));
    }

    private boolean confirmAvailability(){
        return true;
    }

    private boolean viewSchedule(){ //for end of project when schedule is out
        return true;
    }

}
