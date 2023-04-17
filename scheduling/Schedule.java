package scheduling;

import java.util.HashMap;

public class Schedule {
    
    private Availability available;

    public Schedule(Availability available){
        this.available = available;
    }

    private boolean addAvailability(Availability availables){
        return true;
    }

    public Availability editSchedule(){
        return new Availability(new HashMap<>(1, 2), new HashMap<>(1, 2));
    }

    public boolean confirmSchedule(){
        return true;
    }

}
