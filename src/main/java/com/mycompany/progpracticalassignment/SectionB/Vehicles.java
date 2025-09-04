/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progpracticalassignment.SectionB;

public abstract class Vehicles {
    private final String Vin;
    private final double Price;

    public Vehicles(String Vin, double Price) {
        this.Vin = Vin;
        this.Price = Price;
    }

    public String GetVin() {
        return Vin;
    }

    public double GetPrice() {
        return Price;
    }

    public abstract String GetDetails();
}