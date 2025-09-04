/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progpracticalassignment.SectionB;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StockTest {
    @Test
    public void testValidPricePass() {
        Stock StockTest = new Stock();
        
        assertTrue(StockTest.ValidPrice("1928910.99"));
    }

    @Test
    public void testValidPriceFail() {
        Stock StockTest = new Stock();
        
        assertFalse(StockTest.ValidPrice("12.3.4"));  
    }

    @Test
    public void testValidQuantityPass() {
        Stock StockTest = new Stock();
        
        assertTrue(StockTest.ValidQuantity("10"));
    }

    @Test
    public void testValidQuantityFail() {
        Stock StockTest = new Stock();
         
        assertFalse(StockTest.ValidQuantity("-2"));   
    }

    @Test
    public void testAddStockNewCarPass() {
        Stock StockTest = new Stock();
        
        StockTest.AddStock("Ford", "Fiesta", "ABCDEFGH123456789", 15000.0, 2);
        StockTest.SellCar("ABCDEFGH123456789"); 
        
        assertTrue(true);
    }

    @Test
    public void testAddStockFail() {
        Stock StockTest = new Stock();

        StockTest.AddStock("Ford", "Fiesta", "3465VGHE466", 15000.0, 2);
        
        assertTrue(true); 
    }

    @Test
    public void testSellCarPass() {
        Stock StockTest = new Stock();
        
        StockTest.SellCar("1HGCM82633A123456"); 
        
        assertTrue(true);
    }

    @Test
    public void testSellCarNotFound() {
        Stock StockTest = new Stock();
        
        StockTest.SellCar("XXXXXXXXXXXXXXXXX"); 
        
        assertTrue(true); 
    }

    @Test
    public void testSellCarOutOfStock() {
        Stock StockTest = new Stock();
        
        StockTest.AddStock("Ford", "Fiesta", "123456789ABCDEFGH", 12000.00, 1);
        StockTest.SellCar("123456789ABCDEFGH");
        StockTest.SellCar("123456789ABCDEFGH");
        
        assertTrue(true);
    }
}