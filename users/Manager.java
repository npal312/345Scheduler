package users;
import scheduling.Availability;
import backend.Database;
import scheduling.Invitation;
import scheduling.Schedule;
import scheduling.ScheduleSystem;

public class Manager extends Person{

    /**
     * contructor for manager
     * @param username
     * @param password
     * @param email
     */
    public Manager(String username, String password, String email){
        super(username, password, email);
    }

    private boolean createSchedule(){
        System.out.println("Creating schedule.");
        return true;
    }
    
    private boolean setConstraints(){
        System.out.println("Constraints set");
        return true;
    }

<<<<<<< HEAD
    private String setConstraints(){
        System.out.println("Constraints set.");
        return "";
    }

    public boolean receiveAlert(boolean alert){
        if (alert){
            System.out.println("Alert received.");
            return true;
        }
        else{
            System.out.println();
            return false;
        }
    }

    private boolean sendInvitation(){
        System.out.println("Invitation sent!");
        return true;
    }

}
=======
}
>>>>>>> 0c73f3b213be513c5cd96357eb0481be72b2bd84
