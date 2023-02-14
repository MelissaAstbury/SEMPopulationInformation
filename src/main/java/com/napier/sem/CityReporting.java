package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static com.napier.sem.App.con;

public class CityReporting {
    public void RunSamples(){
        System.out.println("City Reporting");

        // Report 01 - Cites by population
        System.out.println("Report 01 - Cities by population");
        System.out.println("Parameters: None");
        ArrayList<City> cities01 = new ArrayList<City>();
        cities01 = getCitiesByPopulation();
        printCities(cities01);
    }

    public ArrayList<City> getCitiesByPopulation()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name Country, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code "
                            + "ORDER BY city.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                Country country = new Country();
                city.Country = new Country();
                city.Name = rset.getString("Name");
                city.District = rset.getString("District");
                city.Population = rset.getInt("Population");
                city.Country.Name = rset.getString("Country");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    /**
     * Prints a list of cities
     * @param cities The list of cities to print.
     */
    public void printCities(ArrayList<City> cities)
    {
        // Print header
        System.out.println(String.format("%-50s %-50s %-50s %-20s", "Name", "Country", "District", "Population"));
        // Loop over all countries in the list
        for (City city : cities)
        {
            String city_string =
                    String.format("%-50s %-50s %-50s %-20s",
                            city.Name, city.Country.Name, city.District, city.Population);
            System.out.println(city_string);
        }
    }
}