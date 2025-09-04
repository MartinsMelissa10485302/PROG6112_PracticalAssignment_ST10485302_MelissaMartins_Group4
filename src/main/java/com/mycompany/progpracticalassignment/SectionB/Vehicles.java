/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progpracticalassignment.SectionB;

//Used in inheritance
public abstract class Vehicles {
    //Varibales - cannot be overwritten
    private final String Vin;
    private final double Price;

    //Constructor
    public Vehicles(String Vin, double Price) {
        this.Vin = Vin;
        this.Price = Price;
    }

    //Public getter methods
    public String GetVin() {
        return Vin;
    }

    public double GetPrice() {
        return Price;
    }

    public abstract String GetDetails();
}