/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bmicalculator;

import java.util.Scanner;

/**
 *
 * @author patkhai
 */

public class BmiCalculator {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //Create a scanner object

        double weight_lb, height_in, height_ft, bmi;

        System.out.print("Name: ");
        String first = input.next(); // read the program
        String last = input.next();
        
       
        System.out.print("Weight: ");
        weight_lb = input.nextInt(); // read the program

        System.out.print("Height: ");
        height_in = input.nextInt();
        
        height_ft = height_in/12; // conversion
        bmi = ((weight_lb * 703)/(height_in * height_in)); // equation for bmi
        
        if (bmi <= 18.5) {
            System.out.printf("You have a BMI of %.2f, and your weight status is underweight\n", bmi);
        }   else if (bmi >= 18.5 && bmi < 24.9) {
            System.out.printf("You have a BMI of %.2f, and your weight status is normal\n", bmi);
        }   else if (bmi >= 25 && bmi <29.9) {
            System.out.printf("You have a BMI of %.2f, and your weight status is overweight\n", bmi);
        }   else if (bmi > 30) {
            System.out.printf("You have a BMI of %.2f, and your weight status is obesity\n", bmi);
        } 
       
     
        System.out.println("BMI Categories: ");
        System.out.println("Underweight <= 18.5");
        System.out.println("Normal weight = 18.5 to 24.9 ");
        System.out.println("Overweight = 25 to 29.9");
        System.out.println("Obesity = 30 or greater");
     }
}
