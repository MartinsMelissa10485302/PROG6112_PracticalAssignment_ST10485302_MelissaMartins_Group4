/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.progpracticalassignment.SectionB;

import java.util.Scanner;

public class CarDealership {
    public static void main(String[] args) {
        Stock Dealership = new Stock();
        Scanner Input = new Scanner(System.in);

        while (true) {
            System.out.println("\n---- Car Dealership Menu ----");
            System.out.println("1. Add Stock");
            System.out.println("2. Sell Stock");
            System.out.println("3. Stock Report");
            System.out.print("Enter choice (any other key to exit): ");

            String MenuChoice = Input.nextLine();

            if (MenuChoice.equals("1")) {
                System.out.print("Enter the make of the car: ");
                String Make = Input.nextLine();

                System.out.print("Enter the model of the car: ");
                String Model = Input.nextLine();

                String Vin;
                
                while (true) {
                    System.out.print("Enter the unique car VIN (17 characters): ");
                    Vin = Input.nextLine();
                    
                    if (Cars.ValidVin(Vin) && Dealership.VinUnique(Vin)) {
                        break;
                    } else {
                        System.out.println("Invalid VIN. ");
                    }
                }

                double Price;
                
                while (true) {
                    System.out.print("Enter the selling price: ");
                    String PriceStr = Input.nextLine();
                    
                    if (Dealership.ValidPrice(PriceStr)) {
                        Price = Double.parseDouble(PriceStr);
                        break;
                    } else {
                        System.out.println("Invalid price.");
                    }
                }

                int Quantity;
                
                while (true) {
                    System.out.print("Enter the quantity: ");
                    String QuantityStr = Input.nextLine();
                    
                    if (Dealership.ValidQuantity(QuantityStr)) {
                        Quantity = Integer.parseInt(QuantityStr);
                        break;
                    } else {
                        System.out.println("Invalid quantity.");
                    }
                }

                Dealership.AddStock(Make, Model, Vin, Price, Quantity);
            } else if (MenuChoice.equals("2")) {
                System.out.print("Enter the car VIN (17 characters): ");
                String Vin = Input.nextLine();
                
                Dealership.SellCar(Vin);
            } else if (MenuChoice.equals("3")) {
                Dealership.StockReport();
            } else {
                System.out.println("Closing application...");
                break;
            }
        }
    }
}
