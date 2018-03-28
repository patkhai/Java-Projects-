/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studenthealthservice;
import java.util.Scanner;
/**
 *
 * @author patkhai
 */
public class Studenthealthservice {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args){


Scanner input = new Scanner(System.in);

System.out.println("The number of patient record is: " + EMR.getCounter());

EMR[]e= new EMR[5]; //creating an array and recalling EMR class

for(int i=0;i<5;i++){

System.out.println("Enter the name of the patient: ");

String name = input.nextLine();

System.out.println("Enter the date of birth of the patient: ");

String dob = input.nextLine();

e[i] = new EMR(name, dob);


 System.out.println("Number of availble records: " + EMR.getCounter());
        
System.out.println(e[i].getName()+ " " + e[i].getDob()); //printing out the record everytime user set it
}

for(int i=0;i<5;i++) {
System.out.println("Enter the reason for visit: ");

String rfv = input.next(); //input the reason

e[i].setRfv(rfv); //using a setter method from class file

System.out.println("Enter the body temperature of the patient : ");

double bodyt = input.nextDouble(); //input the body temperature
e[i].setBodyt(bodyt); //using the setter method from class file 

System.out.println("Enter the Heart-rate of the patient : ");

double hr = input.nextDouble(); // input the heart rate

e[i].setHr(hr);//using the setter method from class file 

System.out.println("Enter the diagnosis of the patient: ");

String diag = input.next(); //input the diagnosis

e[i].setDiag(diag);//using the setter method from class file 

System.out.println("Enter the prescribed medicine to the patient: ");

String pmeds = input.next(); //input the medicines

e[i].setPmeds(pmeds);//using the setter method from class file 


}    
   System.out.println("Choose which patients to visit: " ); 
   for ( int choice = 1; choice <= 5; choice++){
   choice = input.nextInt(EMR.getCounter()); //promptiing user to chooose the patients
   switch (choice) {
       case 1 :  System.out.println(e[1].toString());
                break;
       case 2 :  System.out.println(e[2].toString());
                break;
       case 3 :  System.out.println(e[3].toString());
                break;
       case 4 :  System.out.println(e[4].toString());
                break;
       case 5 :  System.out.println(e[5].toString());
                break;
       default: break;
     } 
   System.out.println("\nChoose which patients to visit: " );
   }
   
}
}