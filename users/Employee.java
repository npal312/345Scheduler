package users;
import scheduling.Availability;
import backend.Database;
import scheduling.Invitation;
import scheduling.Schedule;
import scheduling.ScheduleSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Employee extends Person{
    
    public String position;
    public Availability available;
    public HashMap<String, int[]> free;
    public HashMap<String, int[]> busy;
    public final String[] DAYSOFWEEK = {"M", "T", "W", "Th", "F", "S", "Su"}; //week STARTS ON MONDAY

    public Employee(String position, String username, String password, String email){
        super(username, password, email);
        this.position = position;
        free = new HashMap<String, int[]>();
        busy = new HashMap<String, int[]>();
    }


    public Employee(String position, String username, String password, String email, Availability available){
        super(username, password, email);
        this.position = position;
        this.available = available;
        free = new HashMap<String, int[]>();
        busy = new HashMap<String, int[]>();
    }


    //ADD INPUTS (like viewing schedule having a schedule input)

    public Availability uploadSchedule(){
        HashMap<String, ArrayList<int[]>> free = new HashMap<String, ArrayList<int[]>>();
        HashMap<String, ArrayList<int[]>> busy = new HashMap<String, ArrayList<int[]>>();
        return new Availability(free, busy);
    }

    public boolean manualSchedule(String[] days, String[] blocksOfFree, String[] daysBusy, String[] blocksOfBusy){
        inputFree(days, blocksOfFree);
        inputBusy(daysBusy, blocksOfBusy);

        /*for (int i = 0; i < 7; i++){
            System.out.println(this.free.get(DAYSOFWEEK[i])[0] + " - " + this.free.get(DAYSOFWEEK[i])[1]);
        }
        System.out.println("");
        for (String key : this.busy.keySet()){
            System.out.println(key + ": " + this.busy.get(key)[0] + " - " + this.busy.get(key)[1]);
        }*/

        if (confirmAvailability() == true){
            return true;
        }
        else{
            return false;
        }
    }

    public void inputFree(String[] days, String[] blocksOfTime){
        if (days.length != blocksOfTime.length){
            System.out.println("Invalid input (incorrect amount of days and blocks).");
            return;
        }
        for (int i = 0; i < days.length; i++){
            boolean check = false;
            for (int j = 0; j < DAYSOFWEEK.length; j++){
                if (days[i].equals(DAYSOFWEEK[j])){
                    check = true;
                }
            }
            if (check == false){
                System.out.println("Invalid input (invalid day).");
                return;
            }
        }
        
        for (int i = 0; i < days.length; i++){
            this.free.put(days[i], timeEnter(blocksOfTime[i]));
        }
    }

    public void inputBusy(String[] days, String[] blocksOfTime){ //to simplify adding busy blocks for simulation purposes
        
        if (days.length != blocksOfTime.length){
            System.out.println("Invalid input (incorrect amount of days and blocks).");
            return;
        }
        for (int i = 0; i < days.length; i++){
            boolean check = false;
            for (int j = 0; j < DAYSOFWEEK.length; j++){
                if (days[i].equals(DAYSOFWEEK[j])){
                    check = true;
                }
            }
            if (check == false){
                System.out.println("Invalid input (invalid day).");
                return;
            }
        }
        
        for (int i = 0; i < days.length; i++){
            for (int j = 0; j < days.length; j++){ //j until days length bc impossible to have more entries for one day than total amount of entries for all days
                String name = days[i] + Integer.toString(j); //making name
                if (this.busy.get(name) != null){ //if value is already there
                    //do nothing
                }
                else{
                    this.busy.put(name, timeEnter(blocksOfTime[i])); //inputting correct data
                    break;
                }
            }
        }
    }

    public int[] timeEnter(String blockOfTime){ //will work for available and busy slots
        //written as 10:30AM-5:30PM
        String[] timeSplit = blockOfTime.split("-");
        timeSplit[0] = timeSplit[0].replace(":", "");
        timeSplit[1] = timeSplit[1].replace(":", "");
        //System.out.println(timeSplit[0]);
        //System.out.println(timeSplit[1]);
        int[] timeBlock = new int[2];
        for (int i = 0; i < 2; i++){

            String tempTime = timeSplit[i].substring(0, timeSplit[i].length()-2); //getting rid of letters
            timeBlock[i] = Integer.parseInt(tempTime); //putting number in

            //invalid hours (ex: 13:00AM)
            if (timeBlock[i] > 1259){
                System.out.println("Invalid input (hours).");
                return new int[0];
            }
            //if time has invalid minutes (Ex: 11:60)
            if (timeBlock[i] < 1000 && timeBlock[i] % 10 > 59){
                System.out.println("Invalid input (minutes).");
                return new int[0];
            }
            if (timeBlock[i] >= 1000 && timeBlock[i] % 100 > 59){
                System.out.println("Invalid input (minutes).");
                return new int[0];
            }

            if (timeSplit[i].substring(timeSplit[i].length()-2).equals("PM")){ //if last 2 characters == "PM"

                if (timeBlock[i] >= 1200){ //if hour is "12" (num form would be 1200 or more)
                    //do nothing
                }
                else{
                    timeBlock[i] += 1200; //adds 12 hours to time bc military time is easier to calculate in
                }
            }
            else if (timeSplit[i].substring(timeSplit[i].length()-2).equals("AM")){ //if last 2 characters == "AM"

                if (timeBlock[i] >= 1200){ //if midnight or in first hour of day
                    timeBlock[i] -= 1200; //makes it "00:00" instead of "12:00" and confusing it with noon
                }
                else{
                    //do nothing
                }
            }
            else{
                System.out.println("Invalid input (no AM or PM)."); //no AM or PM
                break;
            }
        }
        System.out.println(timeBlock[0]);
        System.out.println(timeBlock[1]);

        return timeBlock;

    }

    public boolean editAvailability(String editType, String day, int block, String blockOfTime){
        if (!day.equals("M") && !day.equals("T") && !day.equals("W") && !day.equals("Th") && !day.equals("F") && !day.equals("S") && !day.equals("Su")){
            System.out.println("Invalid input (incorrect day)."); //if not a valid day
        }

        if (editType.equals("free")){
            this.free.put(day, timeEnter(blockOfTime)); //edit free block directly
        }
        else if (editType.equals("busy")){
            String name = day + Integer.toString(block);
            if (this.busy.get(name) == null){ //to check if name in form of (ex: M1) is there. If so, change. If not, don't do anything.
                System.out.println("Invalid input (no time block found).");
                return false;
            }
            this.busy.put(name, timeEnter(blockOfTime));
        }
        else{
            System.out.println("Invalid input (editType).");
            return false;
        }
        return true;
    }

    public boolean deleteAvailability(String deleteType, String day, int block){
        if (!day.equals("M") && !day.equals("T") && !day.equals("W") && !day.equals("Th") && !day.equals("F") && !day.equals("S") && !day.equals("Su")){
            System.out.println("Invalid input (incorrect day)."); //if not a valid day
        }

        if (deleteType.equals("free")){
            this.free.remove(day); //delete free block directly
        }
        else if (deleteType.equals("busy")){
            String name = day + Integer.toString(block);
            if (this.busy.get(name) == null){ //to check if name in form of (ex: M1) is there. If so, delete. If not, don't do anything.
                System.out.println("Invalid input (no time block found).");
                return false;
            }
            this.busy.remove(name); //deletes busy block
        }
        else{
            System.out.println("Invalid input (deleteType).");
            return false;
        }
        return true;
    }

    public boolean confirmAvailability(){ //availability gets made here
        HashMap<String, ArrayList<int[]>> availableSlots = new HashMap<String, ArrayList<int[]>>();
        HashMap<String, ArrayList<int[]>> unavailableSlots = new HashMap<String, ArrayList<int[]>>();

        for (int i = 0; i < 7; i++){
            ArrayList<int[]> slots = new ArrayList<int[]>();
            if (this.free.get(DAYSOFWEEK[i]) == null){ //no free time for this day
                ArrayList<int[]> finalSlots = new ArrayList<int[]>();
                int[] slot = {0, 2359}; //busy the whole day
                finalSlots.add(slot);
                unavailableSlots.put(DAYSOFWEEK[i], finalSlots);
            }
            else{
                slots.add(this.free.get(DAYSOFWEEK[i])); //getting free time for this day
                boolean done = false;
                int j = 0;
                while (!done){ //adding busy times
                    String name = DAYSOFWEEK[i] + Integer.toString(j);
                    if (this.busy.get(name) == null){
                        done = true;
                        break;
                    }
                    else{
                        slots.add(this.busy.get(name)); //adding busy slot for this day
                    }
                    j++;
                    //System.out.println("test " + j);
                }
    
                /*System.out.println();
                for (int z = 0; z < slots.size(); z++){
                    System.out.println(slots.get(z)[0] + " - " + slots.get(z)[1]);
                }
                System.out.println();*/

                ArrayList<int[]> finalFreeSlots = new ArrayList<int[]>();
                ArrayList<int[]> finalBusySlots = new ArrayList<int[]>();

                if (slots.get(0)[0] != 0){ //if free doesn't start at midnight
                    int[] newSlot = {0, slots.get(0)[0]};
                    finalBusySlots.add(newSlot);
                }

                if (slots.size() == 1){ //only one slot (free time)
                    int[] newSlot = {slots.get(0)[0], slots.get(0)[1]};
                    finalFreeSlots.add(newSlot); //free
                }
                else if (slots.size() == 2){ //only two slots (one busy and one free)

                    if (slots.get(0)[0] != slots.get(1)[0]){ //if they start at the same time
                        int[] slotOne = {slots.get(0)[0], slots.get(1)[0]};
                        finalFreeSlots.add(slotOne);
                    }
                    
                    int[] slotTwo = {slots.get(1)[0], slots.get(1)[1]};
                    finalBusySlots.add(slotTwo);

                    if (slots.get(1)[1] != slots.get(0)[1]){ //if they end at the same time
                        int[] slotThree = {slots.get(1)[1], slots.get(0)[1]};
                        finalFreeSlots.add(slotThree);
                    }
                }
                else{

                    System.out.println();
                for (int z = 0; z < slots.size(); z++){
                    System.out.println(slots.get(z)[0] + " - " + slots.get(z)[1]);
                }
                System.out.println();

                    if (slots.get(0)[0] != slots.get(1)[0]){ //if they start at the same time
                        int[] slotOne = {slots.get(0)[0], slots.get(1)[0]};
                        finalFreeSlots.add(slotOne);
                    }

                    for (int k = 1; k < slots.size(); k++){
                        int[] newBusySlot = {slots.get(k)[0], slots.get(k)[1]};
                        finalBusySlots.add(newBusySlot);
                        if (k != slots.size() - 1){ //if not the last unavailable (if it was, then it has to loop back around to first slot)
                            int[] newFreeSlot = {slots.get(k)[1], slots.get(k + 1)[0]};
                            finalFreeSlots.add(newFreeSlot);
                        }
                    }

                    if (slots.get(1)[1] != slots.get(0)[1]){ //if they end at the same time
                        int[] slotFinal = {slots.get(slots.size() - 1)[1], slots.get(0)[1]};
                        finalFreeSlots.add(slotFinal);
                    }
                }

                if (slots.get(0)[1] != 2359){ //if free doesn't end at midnight
                    int[] newSlot = {slots.get(0)[1], 2359};
                    finalBusySlots.add(newSlot);
                }

                availableSlots.put(DAYSOFWEEK[i], finalFreeSlots);
                unavailableSlots.put(DAYSOFWEEK[i], finalBusySlots);
            }

        }

        this.available = new Availability(availableSlots, unavailableSlots);
        return true;
    }

    public void saveSchedule() throws FileNotFoundException{
        String filename = new File("").getAbsolutePath() + "/backend/data/" + this.getUsername() + ".txt";
        File file = new File(filename);
        PrintWriter logger = new PrintWriter(file);
        logger.println(this.available.toString());
        logger.close();
    }

    private boolean viewSchedule(){ //for end of project when schedule is out
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException{
        Employee Jerry = new Employee("worker", "jworker", "123", "jerry@gmail.com");

        //Jerry.free.put("M", Jerry.timeEnter("10:30AM-5:30PM"));
        //System.out.println(Jerry.free.get("M"));

        String[] daysOne = {"M", "T", "W", "Th", "F", "S", "Su"};
        String[] blocksOne = {"10:30AM-5:30PM", "9:30AM-4:30PM", "11:30AM-6:00PM", "12:00AM-11:30PM", "12:00AM-12:00PM", "10:30AM-5:30PM", "10:30AM-5:30PM"};
        String[] daysTwo = {"M", "T", "Th", "M"};
        String[] blocksTwo = {"12:30PM-2:00PM", "10:30AM-12:00PM", "9:00PM-10:00PM", "3:30PM-4:00PM"};

        Jerry.manualSchedule(daysOne, blocksOne, daysTwo, blocksTwo);

        System.out.println(Jerry.available.toString());
        Jerry.saveSchedule();
        //System.out.println(new File("").getAbsolutePath() + "/backend/data");
    }

}
