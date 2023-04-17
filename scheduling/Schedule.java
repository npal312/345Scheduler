package scheduling;

import java.util.ArrayList;
import java.util.HashMap;

public class Schedule {
    
    //private Availability available; //not needed anymore
    private HashMap<String, Availability> employeeAvailability;

    public Schedule(HashMap<String, Availability> employeeAvailability){

        this.employeeAvailability = employeeAvailability;
    }

    private boolean addAvailability(Availability availables){
        return true;
    }

    public boolean editSchedule(HashMap<String, Availability> employeeAvailability){
        HashMap<String, ArrayList<String>> free = new HashMap<String, ArrayList<String>>();
        HashMap<String, ArrayList<String>> busy = new HashMap<String, ArrayList<String>>();
        this.employeeAvailability = employeeAvailability;
        return true;
    }

    public boolean confirmSchedule(){
        return true;
    }

}
