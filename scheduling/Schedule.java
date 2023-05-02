package scheduling;

import java.util.ArrayList;
import java.util.HashMap;

public class Schedule {
    
    //private Availability available; //not needed anymore
    private HashMap<String, Availability> employeeAvailability;

    public Schedule(HashMap<String, Availability> employeeAvailability){

        this.employeeAvailability = employeeAvailability;
    }

    public boolean addAvailability(String employeeName, Availability availables){
        this.employeeAvailability.put(employeeName, availables);
        System.out.println("Availability added.");
        return true;
    }

    public boolean editSchedule(HashMap<String, Availability> employeeAvailability){
        HashMap<String, ArrayList<String>> free = new HashMap<String, ArrayList<String>>();
        HashMap<String, ArrayList<String>> busy = new HashMap<String, ArrayList<String>>();
        this.employeeAvailability = employeeAvailability;
        System.out.println("Schedule updated.");
        return true;
    }

    public boolean confirmSchedule(String choice){
        if (choice.equals("y")){
            System.out.println("Schedule confirmed.");
            return true;
        }
        else if (choice.equals("n")){
            System.out.println("Please make the necessary changes to the Schedule.");
            return false;
        }
        else{
            System.out.println("Invalid input.");
            return false;
        }
    }

}

//balls
