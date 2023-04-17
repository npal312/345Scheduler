package scheduling;

import java.util.ArrayList;
import java.util.HashMap;

public class ScheduleSystem {
    private ArrayList<Availability> totalAvailable;
    private String constraints;
    private Invitation invite;
    private Schedule finalizedSchedule;
    public ArrayList<String> contactInfo;

    public ScheduleSystem(){
    }

    private boolean inputContactInfo(){
        return true;
    }

    private boolean createInvitation(){
        return true;
    }

    private boolean sendInvitation(){
        return true;
    }

    private boolean availabilityAlert(){
        return true;
    }

    private String setConstraints(){
        return "";
    }

    private boolean createPotentialSchedules(ArrayList<Availability> totalAvailable, String str){
        return true; //maybe return arraylist of schedules instead of boolean
    }

    private boolean checkIfPossible(){
        return true;
    }

    private Schedule chooseSchedule(){
        //put arraylist of schedules in there
        //pick one

        HashMap<String, ArrayList<String>> free = new HashMap<String, ArrayList<String>>();
        HashMap<String, ArrayList<String>> busy = new HashMap<String, ArrayList<String>>();
        Availability testing = new Availability(free, busy);
        String help = "";
        HashMap<String, Availability> test = new HashMap<String, Availability>();
        Schedule finish = new Schedule(test);
        return finish;
    }

    public boolean sendSchedule(){
        return true;
    }

}
