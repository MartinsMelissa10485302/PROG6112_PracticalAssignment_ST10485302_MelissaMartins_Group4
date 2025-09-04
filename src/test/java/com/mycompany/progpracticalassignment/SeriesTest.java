/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.progpracticalassignment;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class SeriesTest {
    //Test series found - pass
    @Test
    void testSearchSeries() {
        Series Show = new Series();
        
        Show.SeriesID.add("378");
        Show.SeriesName.add("Prison Break");
        Show.SeriesAge.add("16");
        Show.SeriesNumOfEpisodes.add("60");

        int Index = Show.SeriesID.indexOf("378");

        assertNotEquals(-1, Index);
        assertEquals("Prison Break", Show.SeriesName.get(Index));
        assertEquals("60", Show.SeriesNumOfEpisodes.get(Index));
    }

    //Test series found - fail
    @Test
    void testSearchSeries_SeriesNotFound() {
        Series Show = new Series();
        
        int Index = Show.SeriesID.indexOf("243");

        assertEquals(-1, Index);
    }

    //Test delete series - pass
    @Test
    void testDeleteSeries() {
        Series Show = new Series();
        
        Show.SeriesID.add("237");
        Show.SeriesName.add("Friends");
        Show.SeriesAge.add("13");
        Show.SeriesNumOfEpisodes.add("236");

        int index = Show.SeriesID.indexOf("237");
        
        Show.SeriesID.remove(index);
        Show.SeriesName.remove(index);
        Show.SeriesAge.remove(index);
        Show.SeriesNumOfEpisodes.remove(index);

        assertFalse(Show.SeriesID.contains("237"));
        assertFalse(Show.SeriesName.contains("Friends"));
        assertFalse(Show.SeriesAge.contains("13"));
        assertFalse(Show.SeriesNumOfEpisodes.contains("236"));
    }

    //Test delete series - fail
    @Test
    void testDeleteSeries_SeriesNotFound() {
        Series Show = new Series();
        
        int Index = Show.SeriesID.indexOf("862");

        assertEquals(-1, Index);
    }

    //Test update series - pass
    @Test
    void testUpdateSeries() {
        Series Show = new Series();
        
        Show.SeriesID.add("139");
        Show.SeriesName.add("Grey's Anatomy");
        Show.SeriesAge.add("13");
        Show.SeriesNumOfEpisodes.add("400");

        int Index = Show.SeriesID.indexOf("139");
        
        if (Index != -1) {
            Show.SeriesName.set(Index, "Grey's Anatomy");
            Show.SeriesAge.set(Index, "16");
            Show.SeriesNumOfEpisodes.set(Index, "400");
        }

        assertEquals("Grey's Anatomy", Show.SeriesName.get(Index));
        assertEquals("16", Show.SeriesAge.get(Index));
        assertEquals("400", Show.SeriesNumOfEpisodes.get(Index));
    }

    //Test age restriction - pass
    @Test
    void testSeriesAgeRestriction_AgeValid() {
        String ValidAge = "15";

        boolean IsValidDigit = Integer.parseInt(ValidAge) >= 2 && Integer.parseInt(ValidAge) <= 18;
        boolean IsValidFormat = ValidAge.matches("\\d+");
        
        assertTrue(IsValidDigit && IsValidFormat);
    }

    //Test age restriction - fail
    @Test
    void testSeriesAgeRestriction_AgeInvalid() {
        String InvalidAgeStr = "Ten";
        String InvalidAgeNum = "20";
        
        boolean IsValidNum = InvalidAgeStr.matches("\\d+");
        boolean IsValidStr = Integer.parseInt(InvalidAgeNum) >= 2 && Integer.parseInt(InvalidAgeNum) <= 18;
        
        assertTrue(IsValidNum && IsValidStr);
    }
}
