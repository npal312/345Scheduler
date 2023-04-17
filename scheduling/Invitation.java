package scheduling;

import java.util.ArrayList;

public class Invitation {
    
    public ArrayList<String> contactInfo; //Maybe make ArrayList of String
    public String timeInterval;

    public Invitation(ArrayList<String> contactInfo, String timeInterval){
        this.contactInfo = contactInfo;
        this.timeInterval = timeInterval;
    }

    private boolean inputContactInfo(){
        return true;
    }

    private boolean inputTimeInterval(){
        return true;
    }

    private boolean reviewInputs(){
        //call other functions in here
        return true;
    }

}
