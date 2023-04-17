package scheduling;

import java.util.HashMap;

public class Availability {
    
    private HashMap availableSlots;
    private HashMap unavailableSlots;

    public Availability(HashMap availableSlots, HashMap unavailableSlots){
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
