package PJ3;

import java.util.*;
import java.io.*;

// You may add new functions or data fields in this class 
// You may modify any functions or data members here
// You must use Customer, Cashier and CheckoutArea classes
// to implement SuperMart simulator

class SuperMart {

  // input parameters
  private int numCashiers, customerQLimit;
  private int chancesOfArrival, maxServiceTime;
  private int simulationTime, dataSource;

  // statistical data
  private int numGoaway, numServed, totalWaitingTime, arrival;

  // internal data
  private int counter;	             // customer ID counter
  private CheckoutArea checkoutarea; // checkout area object
  private Scanner dataFile;	     // get customer data from file
  private Random dataRandom;	     // get customer data using random function

  // most recent customer arrival info, see getCustomerData()
  private boolean anyNewArrival;  
  private int serviceTime;

  // initialize data fields
  private SuperMart()
  {
	// add statements
        numCashiers = 0; 
        customerQLimit = 0; 
        simulationTime = 0;
        dataSource = 0;
        chancesOfArrival = 0;
        maxServiceTime = 0;
        numGoaway = 0;
        numServed = 0;
        totalWaitingTime = 0;
        counter = 0;
        checkoutarea = null;
        dataFile = null;
        dataRandom = new Random();
        anyNewArrival = false;
        serviceTime = 0;
  }

  private void setupParameters()
  {
	
      // read input parameters from users
      System.out.println("***  Get Simulation Parameters  ***");
      Scanner scanner = new Scanner (System.in);
      System.out.print("Enter simulation time (< 10000): ");
      simulationTime = scanner.nextInt();
      if (simulationTime < 0 || simulationTime > 10000){
          System.out.println("Parameters are out of reach. Try positive integers greater than 0 and less than 10000.");
          setupParameters();
      }
      System.out.print("Enter the number of cashiers (< 10): ");
      numCashiers = scanner.nextInt();
      if (numCashiers < 0 || numCashiers > 10){
          System.out.println("Parameters are out of reach. Try positive integers greater than 0 and less than 10.");
          setupParameters();
      }
      System.out.print("Enter chances (1% < & <= 100%) of new customer: ");
      chancesOfArrival = scanner.nextInt();
       if ( chancesOfArrival < 1 ||  chancesOfArrival > 100){
          System.out.println("Parameters are out of reach. Try positive integers greater than or equal 1 and less than or equal to 100.");
          setupParameters();
       }
      System.out.print("Enter maximum service time of customers (<500): ");
      maxServiceTime = scanner.nextInt();
       if ( maxServiceTime < 0 ||  maxServiceTime > 500){
          System.out.println("Parameters are out of reach. Try positive integers greater than 0 and less than 500.");
          setupParameters();
      }
      System.out.print("Enter customer queue limit (<50): ");
      customerQLimit = scanner.nextInt();
      if ( customerQLimit < 0 ||  customerQLimit > 50){
          System.out.println("Parameters are out of reach. Try positive integers greater than 0 and less than 50.");
          setupParameters();
      }
      System.out.print("Enter 1/0 to get data from file/Random: ");
      dataSource = scanner.nextInt();
      // setup dataFile or dataRandom
      // add statements
      if (dataSource == 1){
          System.out.print("Enter filename: ");
          String file = scanner.next();
          
          try {
              dataFile = new Scanner(new File(file));
              
          }
          catch (FileNotFoundException e) {
              System.out.println("No Files found.");
          }
      } 
  }

  // Refer to step 1 in doSimulation()
  private void getCustomerData()
  {
	// get next customer data : from file or random number generator
        // set anyNewArrival and serviceTime
	// see Readme file for more info
	// add statements
      int data1, data2;
      if(dataSource == 1){
          data1 = Integer.valueOf(dataFile.next());
          data2 = Integer.valueOf(dataFile.next());
          anyNewArrival = (((data1%100)+1)<= chancesOfArrival);
          serviceTime = (data2%maxServiceTime)+1;
         
      }
      else{
          anyNewArrival = ((dataRandom.nextInt(100)+1) <= chancesOfArrival);
          serviceTime = dataRandom.nextInt(maxServiceTime)+1;
      }
 }

  private void doSimulation()
  {
	// add statements
        
	// Initialize CheckoutArea
        checkoutarea = new CheckoutArea(numCashiers, customerQLimit);
	// Time driver simulation loop
        for (int currentTime = 0; currentTime < simulationTime; currentTime++) {
        // Step 1: any new customer enters the checkout area?
        // Step 1.1: setup customer data
    	      getCustomerData();
              System.out.println("\nTime : " + currentTime);
    	      if (anyNewArrival) {
                     arrival++;
                     counter++;
                     Customer nextArrival = new Customer(counter, serviceTime, currentTime);
        // Step 1.2: check customer waiting queue too long?
        // if customer queue is too long, update numGoaway
                if(checkoutarea.isCustomerQTooLong()){
                  checkoutarea.insertCustomerQ(nextArrival);
                  System.out.println("Customer #" + counter + " arrives with checkout time " + serviceTime + " units");
                  System.out.println("Customer #" + counter + " is in the customer queue");
                }else {
                  numGoaway++;
                } 
        // else goto customer queue
    		} else {
      		    System.out.println("\tNo new customer!");
    		}
        // Step 2: free busy cashiers that are done at currenttime, add to free cashierQ
                while(!checkoutarea.emptyBusyCashierQ() && checkoutarea.peekBusyCashierQ().getEndBusyTime() == currentTime){
                    System.out.println("Customer #" + checkoutarea.peekBusyCashierQ().getCurrentCustomer().getCustomerID() + " is done");
                    System.out.println("Cashier #" + checkoutarea.peekBusyCashierQ().getCashierID() +" is free");
                  
                    Cashier freeCashier = checkoutarea.removeBusyCashierQ();
                    freeCashier.endServeCustomer();
                    checkoutarea.insertFreeCashierQ(freeCashier);
          }
        // Step 3: get free cashiers to serve waiting customers at currenttime
                if (!checkoutarea.emptyFreeCashierQ() && !checkoutarea.emptyCustomerQ()){
                    Customer customer = checkoutarea.removeCustomerQ();
                    Cashier cashieremployee = checkoutarea.removeFreeCashierQ();
                    cashieremployee.startServeCustomer(customer, currentTime);
                    checkoutarea.insertBusyCashierQ(cashieremployee);
                    System.out.println("Customer #" + customer.getCustomerID() + " gets a cashier");
                    numServed++;
                    System.out.println("Cashier #" + cashieremployee.getCashierID() + " starts serving " + "customer #" + customer.getCustomerID() + " for " + serviceTime + " units");
                    int waitingTime = currentTime - customer.getArrivalTime();
                    totalWaitingTime += waitingTime;
          }
 
  }// end simulation loop
 
  
  }	
  	 
  private void printStatistics()
  {
	// add statements into this method!
	// print out simulation results
	// see the given example in project statement
        // you need to display all free and busy gas pumps
      System.out.println("\n\n============================================");
      System.out.println("\n\nEnd of simulation report: ");
      System.out.println("# total arrival customers   : " + arrival);
      System.out.println("# customers gone-away       : " + numGoaway);
      System.out.println("# cutomers served           : " + (numServed + checkoutarea.sizeCustomerQ()));
      System.out.println("\n*** Current Cashiers Info. ***");
      System.out.println("# waiting customers    : " + checkoutarea.sizeCustomerQ());
      System.out.println("# busy cashiers        : " + checkoutarea.sizeBusyCashierQ());
      System.out.println("# free cashiers        : " + checkoutarea.sizeFreeCashierQ());
      double waitduration = (double)totalWaitingTime / numServed;
      System.out.println("\nTotal waiting time          : " + totalWaitingTime);
      System.out.printf("Average waiting time        : %.2f\n", waitduration);
      // need to free up all customers in queue to get extra waiting time.
      if (!checkoutarea.emptyBusyCashierQ()) {
          System.out.println("\nBusy Cashiers Info. :");
      }
      // need to free up all cashiers in queue to get extra free & busy time.
      while(!checkoutarea.emptyBusyCashierQ()){
          Cashier cashieremployee = checkoutarea.removeBusyCashierQ();
          cashieremployee.setEndBusyTime(simulationTime);
          cashieremployee.printStatistics();
      }
      if(!checkoutarea.emptyFreeCashierQ()) {
          System.out.println("\nFree Cashiers Info. :");
      }
      while(!checkoutarea.emptyFreeCashierQ()){
          Cashier cashieremployee = checkoutarea.removeFreeCashierQ();
          cashieremployee.setEndFreeTime(simulationTime);
          cashieremployee.printStatistics();
      }
}

  // *** main method to run simulation ****

  public static void main(String[] args) {
   	SuperMart runSuperMart=new SuperMart();
   	runSuperMart.setupParameters();
   	runSuperMart.doSimulation();
   	runSuperMart.printStatistics();
  }

}
