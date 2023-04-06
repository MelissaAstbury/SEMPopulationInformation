package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static com.napier.sem.App.con;

public class CapitalCityReporting {
    public void RunSamples(){
        System.out.println("\nCapital City Reporting");

        // Report 17 - All the capital cities in the world organised by largest population to smallest
        System.out.println("Report 17 - All the capital cities in the world organised by largest population to smallest");
        System.out.println("Parameters: None");
        ArrayList<City> capitalCities01;
        capitalCities01 = getCapitalCitiesByPopulation();
        printCapitalCities(capitalCities01);

        // Report 18 - All the capital cities in a continent organised by largest population to smallest
        System.out.println("Report 18 - All the capital cities in a continent organised by largest population to smallest");
        System.out.println("Parameters: continent = Europe");
        ArrayList<City> capitalCities02;
        capitalCities02 = getCapitalCitiesForContinentByPopulation("Europe");
        printCapitalCities(capitalCities02);

        // Report 19 - All the capital cities in a region organised by largest to smallest
        System.out.println("Report 19 - All the capital cities in a region organised by largest to smallest");
        System.out.println("Parameters: region = Caribbean");
        ArrayList<City> capitalCities03;
        capitalCities03 = getCapitalCitiesForRegionByPopulation("Caribbean");
        printCapitalCities(capitalCities03);

        // Report 20 - The top 'N' populated capital cities in the world where N is provided by the user
        System.out.println("Report 20 - The top 'N' populated capital cities in the world where N is provided by the user");
        System.out.println("Parameters: Top N Populated Capital Cities = 5");
        ArrayList<City> capitalCities04;
        capitalCities04 = getTopNCapitalCitiesInTheWorld(5);
        printCapitalCities(capitalCities04);

        // Report 21 - The top 'N' populated capital cities in a continent where N is provided by the user
        System.out.println("Report 21 - The top 'N' populated capital cities in a continent where N is provided by the user");
        System.out.println("Parameters: Top N Populated Capital Cities = 5 | Continent: Africa");
        ArrayList<City> capitalCities05;
        capitalCities05 = getTopNCapitalCitiesInaContinent(5, "Africa");
        printCapitalCities(capitalCities05);

        // Report 22 - The top 'N' populated capital cities in a region where N is provided by the user
        System.out.println("Report 22 - The top 'N' populated capital cities in a region where N is provided by the user");
        System.out.println("Parameters: Top N Populated Capital Cities = 5 | Region: North America");
        ArrayList<City> capitalCities06;
        capitalCities06 = getTopNCapitalCitiesInARegion(5,"North America");
        printCapitalCities(capitalCities06);
    }

    // Report 17 - All the capital cities in the world organised by largest population to smallest
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
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next())
            {
                City city = new City();
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

    // // Report 18 - All the capital cities in a continent organised by largest population to smallest
    public ArrayList<City> getCapitalCitiesForContinentByPopulation(String continent)
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
                            + "AND country.Continent = '" + continent + "'"
                            + "ORDER BY city.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next())
            {
                City city = new City();
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
            System.out.println("Failed to get capital city details in a continent");
            return null;
        }
    }

    // Report 19 - All the capital cities in a region organised by largest to smallest
    public ArrayList<City> getCapitalCitiesForRegionByPopulation(String region)
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
                            + "AND country.Region = '" + region + "'"
                            + "ORDER BY city.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next())
            {
                City city = new City();
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
            System.out.println("Failed to get capital city details in a region");
            return null;
        }
    }

    // Report 20 - The top 'N' populated capital cities in the world where N is provided by the user
    public ArrayList<City> getTopNCapitalCitiesInTheWorld(int topN)
    {
        String topNstring = Integer.toString(topN);
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name Country, city.Population "
                            + "FROM city, country "
                            + "WHERE city.ID = country.Capital "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT " + topNstring + "";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next())
            {
                City city = new City();
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
            System.out.println("Failed to get top 'N' capital city details");
            return null;
        }
    }

    // Report 21 - The top 'N' populated capital cities in a continent where N is provided by the user
    public ArrayList<City> getTopNCapitalCitiesInaContinent(int topN, String continent)
    {
        String topNstring = Integer.toString(topN);
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name Country, city.Population "
                            + "FROM city, country "
                            + "WHERE city.ID = country.Capital "
                            + "AND country.Continent = '" + continent + "'"
                            + "ORDER BY city.Population DESC "
                            + "LIMIT " + topNstring + "";

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
            System.out.println("Failed to get top 'N' capital city details in a continent");
            return null;
        }
    }

    // Report 22 - The top 'N' populated capital cities in a region where N is provided by the user
    public ArrayList<City> getTopNCapitalCitiesInARegion(int topN, String region)
    {
        String topNstring = Integer.toString(topN);
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name Country, city.Population "
                            + "FROM city, country "
                            + "WHERE city.ID = country.Capital "
                            + "AND country.Region = '" + region + "'"
                            + "ORDER BY city.Population DESC "
                            + "LIMIT " + topNstring + "";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next())
            {
                City city = new City();
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
            System.out.println("Failed to get top 'N' capital cities in a region");
            return null;
        }
    }

    /**
     * Prints a list of capital cities. This method is called by each individual method as they all produce a Capital City Report
     * @param cities The list of cities to print.
     */
    public void printCapitalCities(ArrayList<City> cities)
    {
        // Print header
        System.out.println(String.format("%-50s %-50s %-20s", "Name", "Country", "Population"));

        // Check cities is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }

        // Loop over all cities in the list
        for (City city : cities)
        {
            if (city == null)
                continue;

            String city_string =
                    String.format("%-50s %-50s %-20s",
                            city.Name, city.Country.Name, city.Population);
            System.out.println(city_string);
        }
    }
}
