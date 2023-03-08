package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest
{
    static App app;
    static CountryReporting countryReporting;

    @BeforeAll
    static void init()
    {
        app = new App();
        countryReporting = new CountryReporting();
    }

    /**
        Country Reporting Tests
     */
    @Test
    void printCountryReportsTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        countryReporting.printCountries(countries);
    }
    @Test
    void printCountryReportsTestNull()
    {
        countryReporting.printCountries(null);
    }
    @Test
    void printCountryReportsTestContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        countryReporting.printCountries(countries);
    }
    @Test
    void printCountryReportsValid()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country country = new Country();
        country.Code = "LIL";
        country.Name = "Liberty Lab";
        country.Region = "Freeland";
        country.Population = 1;
        country.Continent = "All";
        country.Capital = new City();
        country.Capital.Name = "Free City";
        countries.add(country);
        countryReporting.printCountries(countries);
    }
}
