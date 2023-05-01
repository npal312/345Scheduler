package scheduling;
import users.Employee;
import users.Manager;

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

    private boolean inputContactInfo(ArrayList<String> information){
        this.contactInfo = information;
        System.out.println("Contact info received.");
        return true;
    }

    private boolean createInvitation(){
        this.invite = new Invitation(contactInfo, constraints);
        System.out.println("Invitation created.");
        return true;
    }

    private boolean sendInvitation(){
        System.out.println("Invitation sent!");
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

        HashMap<String, ArrayList<int[]>> free = new HashMap<String, ArrayList<int[]>>();
        HashMap<String, ArrayList<int[]>> busy = new HashMap<String, ArrayList<int[]>>();
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
