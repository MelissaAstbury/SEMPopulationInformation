package com.napier.sem;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1>A series of integration tests</h1>
 * establish connection to the world db
 * additional reporting validation checks with actual data
 */

public class AppIntegrationTest
{
    static App app;
    static CountryReporting countryReporting;
    static CityReporting cityReporting;
    static LanguageReporting languageReporting;
    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);
        countryReporting = new CountryReporting();
        cityReporting = new CityReporting();
        languageReporting = new LanguageReporting();
    }

    @AfterAll
    static void finish()
    {
        app.disconnect();
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

    @Test
    void testGetLanguage(){
        ArrayList<LanguageReport> languageReports = new ArrayList<LanguageReport>();
        languageReports = languageReporting.getLanguageByPopulation();
        LanguageReport chinaData = languageReports.get(0);
        assertEquals(languageReports.size(), 5);
        assertTrue(chinaData.TotalPopulation < 2000000000);
    }

}
