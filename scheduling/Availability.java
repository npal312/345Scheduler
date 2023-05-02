package scheduling;

import java.util.ArrayList;
import java.util.HashMap;

public class Availability {
    
    private HashMap<String, ArrayList<int[]>> availableSlots;
    private HashMap<String, ArrayList<int[]>> unavailableSlots;
    public final String[] DAYSOFWEEK = {"M", "T", "W", "Th", "F", "S", "Su"}; //week STARTS ON MONDAY

    /**
     * Constructor for availability
     * @param availableSlots
     * @param unavailableSlots
     */
    public Availability(HashMap<String, ArrayList<int[]>> availableSlots, HashMap<String, ArrayList<int[]>> unavailableSlots){
        this.availableSlots = availableSlots;
        this.unavailableSlots = unavailableSlots;
    }

    /**
     * Availability toString() method
     */
    public String toString(){

        StringBuilder sb = new StringBuilder();

        sb.append("Free:" + System.getProperty("line.separator"));
        for (int i = 0; i < 7; i++){
            sb.append(DAYSOFWEEK[i] + ": ");
            if (this.availableSlots.get(DAYSOFWEEK[i]) == null){
                //do nothing
            }
            else{
                for (int j = 0; j < this.availableSlots.get(DAYSOFWEEK[i]).size(); j++){ //getting every free slot and adding it in
                    if (j == this.availableSlots.get(DAYSOFWEEK[i]).size() - 1){ //if last one, then don't put comma after
                        sb.append(this.availableSlots.get(DAYSOFWEEK[i]).get(j)[0] + " - " + this.availableSlots.get(DAYSOFWEEK[i]).get(j)[1]);
                    }
                    else{
                        sb.append(this.availableSlots.get(DAYSOFWEEK[i]).get(j)[0] + " - " + this.availableSlots.get(DAYSOFWEEK[i]).get(j)[1] + ", ");
                    }
                }
            }
            sb.append(System.getProperty("line.separator")); //new line for new day
        }
        sb.append(System.getProperty("line.separator"));

        sb.append("Busy:" + System.getProperty("line.separator"));
        for (int i = 0; i < 7; i++){
            sb.append(DAYSOFWEEK[i] + ": ");
            if (this.unavailableSlots.get(DAYSOFWEEK[i]) == null){
                //do nothing
            }
            else{
                for (int j = 0; j < this.unavailableSlots.get(DAYSOFWEEK[i]).size(); j++){ //getting every free slot and adding it in
                    if (j == this.unavailableSlots.get(DAYSOFWEEK[i]).size() - 1){ //if last one, then don't put comma after
                        sb.append(this.unavailableSlots.get(DAYSOFWEEK[i]).get(j)[0] + " - " + this.unavailableSlots.get(DAYSOFWEEK[i]).get(j)[1]);
                    }
                    else{
                        sb.append(this.unavailableSlots.get(DAYSOFWEEK[i]).get(j)[0] + " - " + this.unavailableSlots.get(DAYSOFWEEK[i]).get(j)[1] + ", ");
                    }
                }
            }
            sb.append(System.getProperty("line.separator")); //new line for new day
        }
        
        return sb.toString();
    }

    private boolean formatAvailability(){
        System.out.println("Availability has been formatted.");
        return true;
    }

}
