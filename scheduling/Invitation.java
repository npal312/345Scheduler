package scheduling;
import java.util.Scanner;
import java.util.ArrayList;

public class Invitation {
    
    public ArrayList<String> contactInfo; //Maybe make ArrayList of String
    public String timeInterval;

    public Invitation(ArrayList<String> contactInfo, String timeInterval){
        this.contactInfo = contactInfo;
        this.timeInterval = timeInterval;
    }

    private boolean inputContactInfo(contactInfo){
        this.contactInfo = contactInfo;
        System.out.println("You entered your contact info");
        return true;
    }

    private boolean inputTimeInterval(timeInterval){
        this.timeInterval = timeInterval;
        System.out.println("You entered in your Time Interval");
        return true;
    }

    private boolean reviewInputs(){
        Scanner myObj = new Scanner(System.in); 
        System.out.println("Review your inputs. If they are good, type 'yes' to continue. If not, type 'no' to restart.");
        String answer = myObj.nextLine();  // Read user input
        while (answer != "yes" || answer != "no"){
            System.out.println("Please type 'yes' or 'no'");
            answer = myObj.nextLine();  
        }
        if (answer == "yes"){
            System.out.println("You have confirmed your inputs. Your data has been saved.");
            return true;
        }
        else{
            System.out.println("You have chosen to restart. Please enter your inputs again.");
            return false;

        }

    
    }

}
