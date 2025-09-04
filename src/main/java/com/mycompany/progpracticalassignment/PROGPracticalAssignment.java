/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progpracticalassignment;

import java.util.Scanner;

public class PROGPracticalAssignment {

    public static void main(String[] args) {
        //Variables
        String MenuItem;
                    
        //Declare scanner
        Scanner Input = new Scanner(System.in);
        
        //Declare object
        Series Show = new Series();
        
        //Display starting headers 
        System.out.println("LATEST SERIES - 2025");
        System.out.println("*****************************");
        
        //Loop to launch menu until told to exit
        while (true){
            System.out.println("Enter (1) to launch menu or any other key to exit");
            String Start = Input.nextLine();
        
            //Validate user input for menu launch 
            if (Start.equals("1")) {
                System.out.println("Please select one of the following menu items: ");
                System.out.println("(1) Capture a new series.");
                System.out.println("(2) Search for a series.");
                System.out.println("(3) Update series.");
                System.out.println("(4) Delete a series.");
                System.out.println("(5) Print series report - 2025");
                System.out.println("(6) Exit application.");
            } else {
                return;
            }
           //Validate invalid menu option
            while (true) {
                MenuItem = Input.nextLine();

                if (!(MenuItem.matches("[1-6]"))) { 
                    System.out.println("Invalid menu item selected. Enter a number between 1 and 6.");
                } else {
                    break;
                }
            }
 
            //Validate user input for menu option
            if (MenuItem.equals("1")) {
                Show.CaptureSeries();
            } else if (MenuItem.equals("2")) {
                Show.SearchSeries();
            } else if (MenuItem.equals("3")) {
                Show.UpdateSeries();
            } else if (MenuItem.equals("4")) {
                Show.DeleteSeries();
            } else if (MenuItem.equals("5")) {
                Show.SeriesReport();
            } else if (MenuItem.equals("6")) {
                Show.ExitSeriesApplication();
            }  
        }
    }
} 


