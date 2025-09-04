/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progpracticalassignment.SectionB;

import java.util.ArrayList;

public class Stock {
    //Delcare array lists - final so that cannot override
    private final ArrayList<Cars> DealershipStock; 
    private final ArrayList<String> VinList;
    
    //Constructor
    public Stock() {
        DealershipStock = new ArrayList<>();
        VinList = new ArrayList<>();

        InitializeInventory();
    }
    
    //Validate VIN is unique
    public boolean VinUnique(String Vin) {
        return !(VinList.contains(Vin));
    }
    
    //Validate price
    public boolean ValidPrice(String InputPrice) {
        if (InputPrice == null) {
            return false;
        }

        if (!(InputPrice.matches("\\d+"))) {
            return false;
        }

        double Price = Double.parseDouble(InputPrice);
        return Price > 0;
    }

    //Validate quantity
    public boolean ValidQuantity(String Input) {
        if (Input == null) {
            return false;
        }
        
        for (char C : Input.toCharArray()) {
            if (!Character.isDigit(C)) {
                return false;
            }
        }
        
        int Quantity = Integer.parseInt(Input);
        return Quantity > 0;
    }

    //Initialize stock
    private void InitializeInventory() {
        AddStockSilent("Toyota", "Camry", "1HGCM82633A123456", 800000.0, 5);
        AddStockSilent("Toyota", "Corolla", "2HGCM82633A123456", 20000.0, 3);
        AddStockSilent("Toyota", "RAV4", "3HGCM82633A123456", 30000.0, 2);

        AddStockSilent("Honda", "Civic", "4HGCM82633A123456", 22000.0, 4);
        AddStockSilent("Honda", "Accord", "5HGCM82633A123456", 27000.0, 6);
        AddStockSilent("Honda", "CR-V", "6HGCM82633A123456", 32000.0, 3);

        AddStockSilent("Ford", "Focus", "7HGCM82633A123456", 21000.0, 3);
        AddStockSilent("Ford", "Mustang", "8HGCM82633A123456", 35000.0, 2);
        AddStockSilent("Ford", "Explorer", "9HGCM82633A123456", 40000.0, 1);
    }
    
    //Method used to get rid of initial stock being added
    private void AddStockSilent(String Make, String Model, String Vin, double Price, int Amount) {
        Cars NewCar = new Cars(Vin, Make, Model, Price, Amount);
        DealershipStock.add(NewCar);
        VinList.add(Vin);
    }

    //Add stock
    public void AddStock(String Make, String Model, String Vin, double Price, int Amount) {
        for (Cars Car : DealershipStock) {
            if (Car.GetMake().equalsIgnoreCase(Make) && Car.GetModel().equalsIgnoreCase(Model)) {
                Car.AddStock(Amount);
                VinList.add(Vin);
                System.out.println("Added stock: " + Car.GetDetails());
                return;
            }
        }

        Cars NewCar = new Cars(Vin, Make, Model, Price, Amount);
        DealershipStock.add(NewCar);
        VinList.add(Vin);

        System.out.println("\nNew car added successfully!");
        System.out.println("Details: " + NewCar.GetDetails());
    }

    //Sell car 
    public void SellCar(String Vin) {
        if (!(Cars.ValidVin(Vin))) {
            System.out.println("Error: VIN must be 17 characters.");
            return;
        }
        
        for (Cars Car : DealershipStock) {
            if (Car.GetVin().equalsIgnoreCase(Vin)) {
                if (Car.SellCar()) {
                    System.out.println("Sold: " + Car.GetDetails());
                } else {
                    System.out.println("Error: Car with VIN " + Vin + " is out of stock.");
                }
                
                return;
            }
        }
        
        System.out.println("Error: Car with VIN " + Vin + " not found.");
    }

    //Stock report
    public void StockReport() {
        System.out.println("\n--- Car Dealership Current Stock ---\n");

        ArrayList<String> MakesList = new ArrayList<>();
        
        for (Cars Car : DealershipStock) {
            if (!(MakesList.contains(Car.GetMake()))) {
                System.out.println("Make: " + Car.GetMake());
                
                for (Cars ModelCar : DealershipStock) {
                    if (ModelCar.GetMake().equalsIgnoreCase(Car.GetMake())) {
                        System.out.println("  " + ModelCar.GetDetails());
                        System.out.println("");
                    }
                }
                
                MakesList.add(Car.GetMake());
            }
        }
    }
}