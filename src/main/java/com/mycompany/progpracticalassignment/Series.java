/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.progpracticalassignment;

import java.util.Scanner;
import java.util.ArrayList;

public class Series {
    //Declare scanner
    Scanner Input = new Scanner(System.in);
    
    //Declare array lists
    ArrayList<String> SeriesID = new ArrayList<>();
    ArrayList<String> SeriesName = new ArrayList<>();
    ArrayList<String> SeriesAge = new ArrayList<>();
    ArrayList<String> SeriesNumOfEpisodes = new ArrayList<>();

    //Capture a new series
    public void CaptureSeries() {
        System.out.println("CAPTURE A NEW SERIES");
        System.out.println("***************************");
        
        System.out.print("Enter the series ID: ");
        String NewID = CheckSeriesID();
        SeriesID.add(NewID);
        
        String NewName = CheckSeriesName();
        SeriesName.add(NewName);

        String NewAgeStr = CheckAgeRestriction();
        SeriesAge.add(NewAgeStr);

        System.out.print("Enter the number of episodes for " + NewName + ": ");
        String NewNumOfEpisodes = CheckNumOfEpisodes(NewName);
        SeriesNumOfEpisodes.add(NewNumOfEpisodes);

        System.out.println("Series processed successfully!");
        System.out.println("---------------------------");
    }

    //Search for a series
    public void SearchSeries() {
        System.out.print("Enter the series ID to search for: ");
        String SearchID = CheckSeriesID();

        int Index = SeriesID.indexOf(SearchID);

        if (Index == -1) {
            System.out.println("Series with series ID: " + SearchID + " was not found!");
            System.out.println("---------------------------");
        } else {
            System.out.println("---------------------------");
            System.out.println("Series ID: " + SeriesID.get(Index));
            System.out.println("Series Name: " + SeriesName.get(Index));
            System.out.println("Series Age Restriction: " + SeriesAge.get(Index));
            System.out.println("Series Number of Episodes: " + SeriesNumOfEpisodes.get(Index));
            System.out.println("---------------------------");
        }
    }

    //Update a series
    public void UpdateSeries() {
        System.out.print("Enter the series ID to update: ");
        String UpdateID = CheckSeriesID();

        int Index = SeriesID.indexOf(UpdateID);

        if (Index == -1) {
            System.out.println("Series with series ID: " + UpdateID + " was not found!");
            System.out.println("---------------------------");
        } else {
            String UpdateName = CheckSeriesName();
            SeriesName.set(Index, UpdateName);

            String UpdateAge = CheckAgeRestriction();
            SeriesAge.set(Index, UpdateAge);

            System.out.print("Enter the number of episodes for " + UpdateName + ": ");
            String UpdateNumOfEpisodes = CheckNumOfEpisodes(UpdateName);
            SeriesNumOfEpisodes.set(Index, UpdateNumOfEpisodes);

            System.out.println("Series updated successfully!");
            System.out.println("---------------------------");
        }
    }

    //Delete a series
    public void DeleteSeries() {
        System.out.print("Enter the series ID to delete: ");
        String DeleteID = CheckSeriesID();

        int Index = SeriesID.indexOf(DeleteID);

        if (Index == -1) {
            System.out.println("Series with series ID: " + DeleteID + " was not found!");
            System.out.println("---------------------------");
        } else {
            System.out.print("Are you sure you want to delete series " + DeleteID + " from the system? (Y) to delete. ");
            String Confirmation = Input.nextLine();

            if (Confirmation.equalsIgnoreCase("Y")) {
                SeriesID.remove(Index);
                SeriesName.remove(Index);
                SeriesAge.remove(Index);
                SeriesNumOfEpisodes.remove(Index);
                System.out.println("Series with series ID: " + DeleteID + " was deleted");
                System.out.println("---------------------------");
            } else {
                System.out.println("Series with series ID: " + DeleteID + " was not deleted");
                System.out.println("---------------------------");
            }  
        }
    }

    //Display all series
    public void SeriesReport() {
        if (SeriesID.isEmpty()) {
            System.out.println("No series recorded.");
            return;
        }

        for (int i = 0; i < SeriesID.size(); i++) {
            System.out.println("Series " + (i + 1) + ": ");
            System.out.println("---------------------------");
            System.out.println("Series ID: " + SeriesID.get(i));
            System.out.println("Series name: " + SeriesName.get(i));
            System.out.println("Series age restriction: " + SeriesAge.get(i));
            System.out.println("Number of Episodes: " + SeriesNumOfEpisodes.get(i));
            System.out.println("---------------------------");
        }
    }

    //Exit application
    public void ExitSeriesApplication() {
        System.out.println("---------------------------");
        System.exit(0);
    }
    
    //Validate series ID 
    public String CheckSeriesID() {
        while (true) {
            String ID = Input.nextLine();
            
            if (SeriesID.contains(ID)) {
                System.out.print("This series ID already exists. Please re-enter a unique series ID: ");
                continue;
            }
            
            if (ID.equals("")) {
                System.out.print("No series ID was entered. Please re-enter a series ID: ");
            } else {
                return ID;
            }
        }
    }  
    
    //Validate series name
    public String CheckSeriesName() {
        while (true) {
            System.out.print("Enter the series name: ");
            String Name = Input.nextLine();
            
            if (Name.equals("")) {
                System.out.print("No series name was entered. Please re-enter a series name:");
            } else {
                return Name;
            }
        }
    }  

    //Validate age restriction 
    public String CheckAgeRestriction() {
        while (true) {
            System.out.print("Enter the series age restriction (2 - 18): ");
            String AgeStr = Input.nextLine();
            
            if (AgeStr.equals("")) {
                System.out.print("No age restriction was entered. Please re-enter an age restriction:");
                continue;
            }
            
            if (!(AgeStr.matches("\\d+"))) {
                System.out.print("Invalid age restriction. Please re-enter an age restriction:");
                continue;
            }

            int Age = Integer.parseInt(AgeStr);

            if (Age < 2 || Age > 18) {
                System.out.print("Invalid age restriction. Please re-enter an age restriction:");
            } else {
                return AgeStr;
            }
        }
    }  
    
    //Validate number of episodes
    public String CheckNumOfEpisodes(String Name) {
        while (true) {
            String Episodes = Input.nextLine();
            
            if (Episodes.equals("")) {
                System.out.print("The number of episodes for " + Name + " was not entered. Please re-enter the number of episodes:");
                continue;
            }
            
            if (!(Episodes.matches("\\d+"))) {
                System.out.print("Invalid number of episodes. Please re-enter the number of episodes for " + Name + ": ");
                continue;
            }
            
            return Episodes;
        }
    }  
}