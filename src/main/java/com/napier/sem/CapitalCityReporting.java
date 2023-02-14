package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static com.napier.sem.App.con;

public class CapitalCityReporting {
    public void RunSamples(){
        System.out.println("Capital City Reporting");

        // Report 01 - Capital cites by population
        System.out.println("Report 01 - Capital Cities by population");
        System.out.println("Parameters: None");
        ArrayList<City> capitalCities01 = new ArrayList<City>();
        capitalCities01 = getCapitalCitiesByPopulation();
        printCapitalCities(capitalCities01);
    }

    public ArrayList<City> getCapitalCitiesByPopulation()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name Country, city.Population "
                            + "FROM city, country "
                            + "WHERE city.ID = country.Capital "
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
                city.Country.Name = rset.getString("Country");
                city.Population = rset.getInt("Population");

                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital city details");
            return null;
        }
    }

    /**
     * Prints a list of capital cities
     * @param cities The list of cities to print.
     */
    public void printCapitalCities(ArrayList<City> cities)
    {
        // Print header
        System.out.println(String.format("%-50s %-50s %-20s", "Name", "Country", "Population"));
        // Loop over all countries in the list
        for (City city : cities)
        {
            String city_string =
                    String.format("%-50s %-50s %-20s",
                            city.Name, city.Country.Name, city.Population);
            System.out.println(city_string);
        }
    }
}
