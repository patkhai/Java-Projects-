/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevatorjava;
import java.util.Scanner;
/**
 *
 * @author patkhai
 */
public class Elevatorjava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //create the scanner object making program interactive
        
        System.out.print("Enter desired floor (1 - 9) : "); //prompting the user
        
        int floor = input.nextInt(); // declaration of variables
            if (floor < 1 || floor > 9) { //making surethe user inout is within that range
                System.out.print("Invalid floor number.");
            }
 
        if (floor == 1) { // user demanding the elevator from that floor
            System.out.println("Elevator 1 is ready");
            System.out.println("Elevator 1 is now open");
            System.out.println("Elevator 1 is now on floor : " + floor);
            System.out.print("Which floor do you want to go (1 - 9) : ");
            int destination_floor = input.nextInt(); // letting user choose her final exiting floor
            System.out.println("You have arrived on floor " + destination_floor);

            } else
           
              if(floor == 2) { // user demanding the elevator from that floor
                System.out.println("Elevator 1 is coming up ");
                System.out.println("Going up one floor.");
                System.out.println("Elevator 1 is now on floor : " + floor);
                System.out.print("Which floor do you want to go (1 - 9) : ");
                int destination_floor = input.nextInt(); // letting user choose her final exiting floor
                System.out.println("You have arrived on floor " + destination_floor);
            } else 
                if (floor == 3) { // user demanding the elevator from that floor
                    System.out.println("Elevator 2 is coming up");
                    System.out.println("Elevator 2 is now open");
                    System.out.println("Elevator 2 is now on floor : " + floor);
                    System.out.print("Which floor do you want to go (1 - 9) : ");
                    int destination_floor = input.nextInt(); // letting user choose her final exiting floor
                    System.out.println("You have arrived on floor " + destination_floor);

            } else
                if (floor == 4) { // user demading the elevator from that floor
                    System.out.println("Elevator 2 is coming up");
                    System.out.println("Elevator 2 is now open");
                    System.out.println("Elevator 2 is now on floor : " + floor);
                    System.out.print("Which floor do you want to go (1 - 9) : ");
                    int destination_floor = input.nextInt(); // letting user choose her final exiting floor
                    System.out.println("You have arrived on floor " + destination_floor);
            } else 
                if (floor == 5) { // user demanding the elevator from that floor
                    System.out.println("Elevator 3 is coming up");
                    System.out.println("Elevator 3 is now open");
                    System.out.println("Elevator 3 is now on floor : " + floor);
                    System.out.print("Which floor do you want to go (1 - 9) : ");
                    int destination_floor = input.nextInt(); // letting user choose her final exiting floor
                    System.out.println("You have arrived on floor " + destination_floor);
            } else
                if (floor == 6) { // user demanding the elevator from that floor
                    System.out.println("Elevator 3 is coming up");
                    System.out.println("Elevator 3 is now open");
                    System.out.println("Elevator 3 is now on floor : " + floor);
                    System.out.print("Which floor do you want to go (1 - 9) : ");
                    int destination_floor = input.nextInt(); // letting user choose her final exiting floor
                    System.out.println("You have arrived on floor " + destination_floor);
            } else
                if (floor == 7 || floor == 8) { // user demading the elevator from that floor
                    System.out.println("Elevator 3 is coming up");
                    System.out.println("Elevator 3 is now open");
                    System.out.println("Elevator 3 is now on floor : " + floor);
                    System.out.print("Which floor do you want to go (1 - 9) : ");
                    int destination_floor = input.nextInt(); // letting user choose her final exiting floor
                    System.out.println("You have arrived on floor " + destination_floor);
            } else
                if (floor == 9) { // user demanding the elevator from that floor
                    System.out.println("Elevator 3 is coming up");
                    System.out.println("Elevator 3 is now open");
                    System.out.println("Elevator 3 is now on floor : " + floor);
                    System.out.print("Which floor do you want to go (1 - 9) : ");
                    int destination_floor = input.nextInt(); // letting user choose her final exiting floor
                    System.out.println("You have arrived on floor " + destination_floor);
                    
                    
                } 
                
    
             
            
                
            
            
    } 
       
        
    }
    
}
