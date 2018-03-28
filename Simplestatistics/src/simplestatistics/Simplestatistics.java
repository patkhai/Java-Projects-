/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestatistics;
import java.util.Scanner;

/**
 *
 * @author patkhai
 */
public class Simplestatistics {

    /**
     * @param args the command line arguments
     */
    public static double[] getUserInput(){
        double [] array; //assiging array
        int num = 0;
        Scanner input = new Scanner(System.in);
        do{
            try{      
                System.out.println("Enter how many numbers you trying to" + " use: ");
                 num = input.nextInt();
            }catch (ArithmeticException ex) {
                System.out.println("Error!: you must enter a number" + "greater than 0" + ex);
            }
            input.nextLine();
        } while(num<=0);
                array = new double[num];
                for(int i=0; i < num; i++) {
                try {
                    System.out.println("Enter number" +(i+1)+ ":");
                    double userfinalinput = input.nextDouble();
                    array[i] = userfinalinput;
                }catch(ArithmeticException ex) {
                    System.out.println("Error!: you must enter a number" + ex);
                i--;
                }
          input.nextLine();
          }
          return array;                  
        }
    
    public static double arithmeticMean(double[] nums) {
        double mean = 0.0;
        for(int i=0; i < nums.length; i++) {
            mean += nums[i];
        }
        mean = mean / nums.length;
        if (mean < 0){
            throw new ArithmeticException("Value cannot be negative number");           
            }
       try{
           for(int i = 0; i < nums.length; i++) {
               mean += nums[i];
           }
       }
       catch (ArithmeticException ex){
           System.out.println("Exception: the mean value"+"cannot be negative number" + ex);     
       } 
       return mean;
    }
    public static double geometricMean(double[] nums) { //return the geometirc mean of # by input parameter
        double geo_mean = 1.0;
        for(int i =0; i < nums.length; i++) {
            geo_mean *= nums[i];           
        }
        System.out.println("The geometric mean = " + geo_mean);
        geo_mean = Math.pow(geo_mean, 1/nums.length);
        if (geo_mean < 0){
            throw new ArithmeticException("Value cannot be negative number");           
            }
       try{
           for(int i = 0; i < nums.length; i++) {
               geo_mean += nums[i];
           }
       }
       catch (ArithmeticException ex){
           System.out.println("Arthemetic Error!:" + ex);     
           geo_mean = 0.0;
       } 
       return geo_mean;
        
        }
    public static double[] minAndmax(double[] nums){// return smallet & largest #
        double[] biglil = {nums[0],nums[0]};
        try{
            for(int i=0; i <nums.length; i++){
                if(nums[i] > biglil[1]) biglil[1]=nums[i];
                if(nums[i] < biglil[0]) biglil[0]=nums[i];             
            }
        }catch (ArithmeticException ex){
           System.out.println("Arthemetic Error!:" + ex);     
       }
       return biglil;
    }    
    public static double scaleF(){
        Scanner input= new Scanner(System.in);
        System.out.println("Enter a scaling facotr: ");
        double factor = input.nextDouble();//asking user to input scaling
        if(factor < 1) {
            throw new ArithmeticException("Factor must be greater than one. ");
        }
        return factor;
    }
    public static double[] scaleUp(double[] nums,double factor) {
        for(int i=0; i < nums.length; i++){
            nums[i]= nums[i]*factor;
            System.out.println("New value is " + nums[i]);            
        }
        return nums;
        
    }
    public static double[] scaleDown(double[] nums,double factor) {
        try{
            for(int i=0; i < nums.length; i++){
                nums[i] = nums[i]/ factor;
                System.out.println("New value is "+ nums[i]);               
            }
        }    
        catch (ArithmeticException ex){
           System.out.println("Arthemetic Error!: cannot scale down by 0" + ex);     
       } 
       return nums;
    }
    
    
    public static void main(String[] args) {
       double[] array = getUserInput();
       Boolean continueInput = true; //IF THE CONDITION INPUT IS TRUE
       do{
            System.out.println("The length of the Statistics Array equals to: " +array.length);
            
            for (int i= 0; i<(array.length); i++){
            System.out.println("Number" +(i+1)+ ": " +array[i]);
            }
                
            int menu=0; //initializing the menu
            //choices: the Menu// prmoting user to pick an option
            System.out.println("Welcome! this is the main menu.\nEnter a number");
            System.out.println("Enter 1 for Arithmetic Mean");
            System.out.println("Enter 2 for Geometric Mean");
            System.out.println("Enter 3 for to find the smallest and largest " + "numbers");
            System.out.println("Enter 4 to Multiply every number by a factor");
            System.out.println("Enter 5 to Divide every number by a factor");
            System.out.println("Enter 6 to Exit the program");

        try{
            Scanner input= new Scanner(System.in);
            menu= input.nextInt();

        //switch statement for eveyrthing
        switch (menu){
        case 1:{ //Arithmetic Mean
                System.out.println("You've chosen Arithmetic Mean!: ");
                System.out.println("Arithmetic Mean: " + arithmeticMean(array));
                break;
                }

        case 2:{ //Geometric mean
                System.out.println("You've chosen Geometric mean!: ");
                double geo_mean= geometricMean(array);
                if(geo_mean>0) System.out.println("Geometric Mean: " +geo_mean);
                break;
                }
        case 3:{ //for smallest/big numbers
                System.out.println("You've chosen to find the smallest/" + "largest numbers!: ");
                double[]biglil = minAndmax(array);
                System.out.println("The smallest number is : "+biglil[0]);
                System.out.println("The largest number is : "+biglil[1]);
                break;
                }
        case 4: {//scale up
                System.out.println("You've chosen to Multiply every " + "number by a factor!: ");
                scaleUp(array,scaleF());
                break;
                }
        case 5: {//scale down
                System.out.println("You've chosen to Divide every " + "number by a factor!: ");
                scaleDown(array,scaleF());
                break;
                }
        case 6: {//Exit program
                continueInput= false;
                break;
                    }
                }
            } catch (Exception e){//input validity must be number(1~5)<more it continue to run
            System.out.println("Error! the number has to be between" + " 1 and 5:" +e);
            menu=0;
            }
      }while(continueInput);
    }
}


       
    
    

