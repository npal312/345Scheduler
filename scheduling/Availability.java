package scheduling;

import java.util.ArrayList;
import java.util.HashMap;

public class Availability {
    
    private HashMap<String, ArrayList<String>> availableSlots;
    private HashMap<String, ArrayList<String>> unavailableSlots;

    public Availability(HashMap<String, ArrayList<String>> availableSlots, HashMap<String, ArrayList<String>> unavailableSlots){
        this.availableSlots = availableSlots;
        this.unavailableSlots = unavailableSlots;
    }

    private boolean formatAvailability(){
        return true;
    }

    private boolean editAvailability(){
        return true;
    }

}
