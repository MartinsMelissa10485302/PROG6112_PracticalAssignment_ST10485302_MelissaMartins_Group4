/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progpracticalassignment.SectionB;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarsTest {
    ////Test valid VIN - pass
    @Test
    public void testValidVinPass() {
        assertTrue(Cars.ValidVin("1HGCM82633A128456")); 
    }

    //Test valid VIN - fail
    @Test
    public void testValidVinFail() {
        assertTrue(Cars.ValidVin("FG457GHXC"));            
    }
    
    //Test getter methods - pass
    @Test
    public void testAllGettersMethods() {
        Cars CarsTest = new Cars("1HGCM82633A128456", "Suzuki", "Swift", 800000.00, 7);

        assertEquals("1HGCM82633A128456", CarsTest.GetVin());
        assertEquals("Suzuki", CarsTest.GetMake());
        assertEquals("Swift", CarsTest.GetModel());
        assertEquals(800000.00, CarsTest.GetPrice());
        assertEquals(7, CarsTest.GetQuantity());
    }

    //Test add stock - pass
    @Test
    public void testAddStockPass() {
        Cars CarsTest = new Cars("1HGCM82633A128456", "Suzuki", "Swift", 800000.00, 7);

        CarsTest.AddStock(3);
        assertEquals(10, CarsTest.GetQuantity()); 
    }

    //Test add stock - fail
    @Test
    public void testAddStockFail() {
        Cars CarsTest = new Cars("1HGCM82633A128456", "Suzuki", "Swift", 800000.00, 7);

        CarsTest.AddStock(2); 
        assertEquals(5, CarsTest.GetQuantity()); 
    }

    //Test sell car - pass
    @Test
    public void testSellCarPass() {
        Cars CarsTest = new Cars("1HGCM82633A128456", "Suzuki", "Swift", 800000.00, 7);

        boolean Sold = CarsTest.SellCar();
        
        assertTrue(Sold);
        assertEquals(6, CarsTest.GetQuantity()); 
    }

    //Test sell car - fail
    @Test
    public void testSellCarFail() {
        Cars CarsTest = new Cars("1HGCM82633A128456", "Suzuki", "Swift", 800000.00, 7);
        
        boolean Sold = CarsTest.SellCar();
        
        assertTrue(Sold);
        assertEquals(7, CarsTest.GetQuantity());
    }
}
