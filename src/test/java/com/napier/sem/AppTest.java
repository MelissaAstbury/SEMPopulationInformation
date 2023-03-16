package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <h1>A series of unit tests</h1>
 * tests the integrity of data retrieval
 */

public class AppTest
{
    static App app;
    static CountryReporting countryReporting;
    static CityReporting cityReporting;
    static LanguageReporting languageReporting;

    @BeforeAll
    static void init()
    {
        app = new App();
        countryReporting = new CountryReporting();
        cityReporting = new CityReporting();
        languageReporting = new LanguageReporting();
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

    /**
     City Reporting Tests
     */
    @Test
    void printCityReportsTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cityReporting.printCities(cities);

    }
    @Test
    void printCityReportsTestNull()
    {
        cityReporting.printCities(null);
    }
    @Test
    void printCityReportsTestContainsNull()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        cityReporting.printCities(cities);
    }

    @Test
    void printCityReportsValid()
    {
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City();
        city.Name = "Sydney";
        city.District = "New South Wales";
        city.Population = 3276207;
        city.Country = new Country();
        city.Country.Name = "Australia";
        cities.add(city);
        cityReporting.printCities(cities);
    }

    /**
     Language Reporting Tests
     */
    @Test
    void printLanguageReportsTestNull()
    {
        languageReporting.printLanguageReport(null);
    }
    @Test
    void printLanguageReportsTestContainsNull()
    {
        ArrayList<LanguageReport> languageReports = new ArrayList<LanguageReport>();
        languageReports.add(null);
        languageReporting.printLanguageReport(languageReports);
    }

    @Test
    void printLanguageReportsValid()
    {
        ArrayList<LanguageReport> languageReports = new ArrayList<LanguageReport>();
        LanguageReport languageReport = new LanguageReport();
        languageReport.Language = "Gaelic";
        languageReport.PercentageOfWorldPopulation = 0.0001;
        languageReport.TotalPopulation = 100000;
        languageReports.add(languageReport);
        languageReporting.printLanguageReport(languageReports);
    }
}
