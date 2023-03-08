package com.napier.sem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;
    static CountryReporting countryReporting;
    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);
        countryReporting = new CountryReporting();
    }

    @Test
    void testGetCountries()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries = countryReporting.getCountriesByPopulation();
        Country country = countries.get(0);
        assertEquals(country.Name, "China");
    }
    @Test
    void testReport05()
    {
        // Report 05 - Top N countries in a continent by population
        System.out.println("Report 05 - Top N Populated Countries in a Continent");
        System.out.println("Parameters: Top N Populated Countries = 5 | Continent: Europe");
        ArrayList<Country> countries05;
        countries05 = countryReporting.getTopNCountriesInAContinent(5, "Europe");
        countryReporting.printCountries(countries05);
    }
}
