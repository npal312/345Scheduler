package scheduling;
import users.Employee;
import users.Manager;

import java.util.ArrayList;
import java.util.HashMap;

public class ScheduleSystem {
    private ArrayList<Availability> totalAvailable;
    public String constraints;
    public Invitation invite;
    public Schedule finalizedSchedule;
    public ArrayList<String> contactInfo;

    public ScheduleSystem(){
    }

    public boolean inputContactInfo(ArrayList<String> information){
        this.contactInfo = information;
        System.out.println("Contact info received.");
        return true;
    }

    public boolean createInvitation(){
        this.invite = new Invitation(contactInfo, constraints);
        System.out.println("Invitation created.");
        return true;
    }

    public boolean sendInvitation(){
        System.out.println("Invitation sent!");
        return true;
    }

    public boolean availabilityAlert(){
        System.out.println("Alert: Availability has been entered.");
        return true;
    }

    private String setConstraints(){
        System.out.println("Constraints set.");
        return "";
    }

    private boolean createPotentialSchedules(ArrayList<Availability> totalAvailable, String str){
        System.out.println("Schedule 1: Cool, Schedule 2: Created, Schedule 3: Finished");
        return true; //maybe return arraylist of schedules instead of boolean
    }

    private boolean checkIfPossible(boolean poss){
        if (poss){
            return true;
        }
        else{
            return false;
        }
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
        System.out.println("Schedule has been sent out.");
        return true;
    }

}
