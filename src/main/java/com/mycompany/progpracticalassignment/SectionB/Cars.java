/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progpracticalassignment.SectionB;

//Used for inhertance
public class Cars extends Vehicles {
    //Variables
    private final String Make;
    private final String Model;
    private int Quantity;
    private int SoldCount;
    
    //Constructor
    public Cars(String Vin, String Make, String Model, double Price, int Quantity) {
        super (Vin, Price);
        this.Make = Make;
        this.Model = Model;
        this.Quantity = Quantity;
        this.SoldCount = 0;
    }

    //Validate VIN
    public static boolean ValidVin(String Vin) {
        return (Vin != null) && (Vin.length() == 17);
    }

    //Getter methods
    public String GetMake() { 
        return Make; 
    }
    
    public String GetModel() { 
        return Model; 
    }
    
    public int GetQuantity() { 
        return Quantity; 
    }
    
    public int GetSoldCount() { 
        return SoldCount; 
    }

    public boolean SellCar() {
        if (Quantity > 0) {
            Quantity --;
            SoldCount ++;
            return true;
        } else{
            return false;
        }
    }

    public void AddStock(int Amount) {
        if (Amount > 0) {
            Quantity += Amount;
        }
    }

    @Override
    public String GetDetails() {
        return "VIN: " + GetVin() + " | Make: " + Make + " | Model: " + Model + " | Price: R" + GetPrice() + " | In Stock: " + Quantity + " | Sold: " + SoldCount;
    }
}
