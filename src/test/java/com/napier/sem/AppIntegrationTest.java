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
    static CityReporting cityReporting;
    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);
        countryReporting = new CountryReporting();
        cityReporting = new CityReporting();
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
    void testGetCities()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities = cityReporting.getCitiesByPopulation();
        City city = cities.get(0);
        assertEquals(city.Name, "Mumbai (Bombay)");
    }
}
