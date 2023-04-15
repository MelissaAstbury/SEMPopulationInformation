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
    static CapitalCityReporting capitalCityReporting;
    static PopulationReporting populationReporting;

    @BeforeAll
    static void init()
    {
        app = new App();
        countryReporting = new CountryReporting();
        cityReporting = new CityReporting();
        languageReporting = new LanguageReporting();
        capitalCityReporting = new CapitalCityReporting();
        populationReporting = new PopulationReporting();
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

    @Test
    void printCityReportsValid2()
    {
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City();
        city.Name = "Livingston";
        city.District = "West Lothian";
        city.Population = 10;
        city.Country = new Country();
        city.Country.Name = "Scotland";
        cities.add(city);
        cityReporting.printCities(cities);
    }

    @Test
    void printCityReportsValid3()
    {
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City();
        city.Name = "Edinburgh";
        city.District = "MidLothian";
        city.Population = 10;
        city.Country = new Country();
        city.Country.Name = "Scotland";
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

    /**
     Capital City Reporting Tests
     */
    @Test
    void printCapitalCityReportsTestNull() { capitalCityReporting.printCapitalCities(null); }

    @Test
    void printCapitalCityReportsTestContainsNull()
    {
        ArrayList<City> capitalCityReports = new ArrayList<>();
        capitalCityReports.add(null);
        capitalCityReporting.printCapitalCities(capitalCityReports);
    }

    @Test
    void printCapitalCityReportsValid()
    {
        ArrayList<City> capitalCityReports = new ArrayList<>();
        City capitalCityReport = new City();
        capitalCityReport.Country = new Country();
        capitalCityReport.Name = "New York";
        capitalCityReport.Country.Name = "America";
        capitalCityReport.Population = 9999;
        capitalCityReports.add(capitalCityReport);
        capitalCityReporting.printCapitalCities(capitalCityReports);
    }

    /**
     Population Reporting Tests
     */
    @Test
    void printPopulationReportsTestNull() { populationReporting.printPopulationReport(null); }

    @Test
    void printPopulationReportsTestContainsNull()
    {
        ArrayList<PopulationReport> populationReports = new ArrayList<>();
        populationReports.add(null);
        populationReporting.printPopulationReport(populationReports);
    }

    @Test
    void printPopulationReportsValid()
    {
        ArrayList<PopulationReport> populationReports = new ArrayList<>();
        PopulationReport populationReport = new PopulationReport();
        populationReport.Name = "Ireland";
        populationReport.TotalPopulation = 3775100;
        populationReport.TotalPopulationInCities = 609041;
        populationReport.PercentageInCities = 16.13;
        populationReport.TotalPopulationNotInCities = 3166059;
        populationReport.PercentageNotInCities = 83.87;
        populationReports.add(populationReport);
        populationReporting.printPopulationReport(populationReports);
    }
}
