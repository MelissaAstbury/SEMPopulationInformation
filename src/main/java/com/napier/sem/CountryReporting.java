package com.napier.sem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static com.napier.sem.App.con;

public class CountryReporting {
    public void RunSamples(){

        System.out.println("Country Reporting");

        // Report 01 - Retrieves all the countries in the world organised by largest population to smallest
        System.out.println("Report 01 - All the countries in the world organised by largest population to smallest");
        System.out.println("Parameters: None");
        ArrayList<Country> countries01;
        countries01 = getCountriesByPopulation();
        printCountries(countries01);

        // Report 02 - Retrieve all the countries in a continent organised by largest population to smallest
        System.out.println("Report 02 - All the countries in a continent organised by largest population to smallest");
        System.out.println("Parameters: Continent='Europe'");
        ArrayList<Country> countries02;
        countries02 = getCountriesInAContinent("Europe");
        printCountries(countries02);

        // Report 03 - Retrieve all the countries in a region organised by largest population to smallest
        System.out.println("Report 03 - All the countries in a region organised by largest population to smallest");
        System.out.println("Parameters: Region='Eastern Asia'");
        ArrayList<Country> countries03;
        countries03 = getCountriesForRegion("Eastern Asia");
        printCountries(countries03);

        // Report 04 - Retrieve the top 'N' populated countries in the world where N is provided by the user
        System.out.println("Report 04 - The top 'N' populated countries in the world where N is provided by the user");
        System.out.println("Parameters: Top N = 4 ");
        ArrayList<Country> countries04;
        countries04 = getTopNCountries(4);
        printCountries(countries04);


        // Report 05 - Retrieve the top 'N' populated countries in a continent where N is provided by the user
        System.out.println("Report 05 - The top 'N' populated countries in a continent where N is provided by the user");
        System.out.println("Parameters: Top N Populated Countries = 5 | Continent: Europe");
        ArrayList<Country> countries05;
        countries05 = getTopNCountriesInAContinent(5, "Europe");
        printCountries(countries05);

        // Report 06 - Retrieve the top 'N' populated countries in a region where N is provided by the user
        System.out.println("Report 06 - The top 'N' populated countries in a region where N is provided by the user");
        System.out.println("Parameters: Top N Populated Countries = 5 | Region: Eastern Asia");
        ArrayList<Country> countries06;
        countries06 = getTopNCountriesInARegion(5, "Eastern Asia");
        printCountries(countries06);
    }

    // Report 01 - Retrieves all the countries in the world organised by largest population to smallest
    public ArrayList<Country> getCountriesByPopulation()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name as Capital "
                            + "FROM country, city "
                            + "WHERE country.capital = city.ID "
                            + "ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.Capital = new City();
                country.Code = rset.getString("Code");
                country.Name = rset.getString("Name");
                country.Continent = rset.getString("Continent");
                country.Region = rset.getString("Region");
                country.Population = rset.getInt("Population");
                country.Capital.Name = rset.getString("Capital");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    // Report 02 - Retrieve all the countries in a continent organised by largest population to smallest
    public ArrayList<Country> getCountriesInAContinent(String continent)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create SQL statement
            String query =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name as Capital "
                            + "FROM country, city "
                            + "WHERE country.Continent = '" + continent + "' "
                            + "AND country.Capital = city.ID "
                            + "ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(query);
            // Extract country information
            ArrayList<Country> countries = new ArrayList<>();
            while (result.next())
            {
                Country country = new Country();
                country.Capital = new City();
                country.Code = result.getString("Code");
                country.Name = result.getString("Name");
                country.Continent = result.getString("Continent");
                country.Region = result.getString("Region");
                country.Population = result.getInt("Population");
                country.Capital.Name = result.getString("Capital");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
            System.out.println("Failed to retrieve countries in a continent");
            return null;
        }
    }

    // Report 03 - Retrieve all the countries in a region organised by largest population to smallest
    public ArrayList<Country> getCountriesForRegion(String region)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name as Capital "
                            + "FROM country, city "
                            + "WHERE country.capital = city.ID "
                            + "AND country.Region = '" + region + "' "
                            + "ORDER BY country.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract country information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.Capital = new City();
                country.Code = rset.getString("Code");
                country.Name = rset.getString("Name");
                country.Continent = rset.getString("Continent");
                country.Region = rset.getString("Region");
                country.Population = rset.getInt("Population");
                country.Capital.Name = rset.getString("Capital");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to retrieve countries in a region");
            return null;
        }
    }

    // Report 04 - Retrieve the top 'N' populated countries in the world where N is provided by the user
    public ArrayList<Country> getTopNCountries(int topN)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name as Capital "
                            + "FROM country, city "
                            + "WHERE country.capital = city.ID "
                            + "ORDER BY country.Population DESC "
                            + "LIMIT " + topN + "";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract country information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.Capital = new City();
                country.Code = rset.getString("Code");
                country.Name = rset.getString("Name");
                country.Continent = rset.getString("Continent");
                country.Region = rset.getString("Region");
                country.Population = rset.getInt("Population");
                country.Capital.Name = rset.getString("Capital");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to retrieve top 'N' countries in a continent");
            return null;
        }
    }

    // Report 05 - Retrieve the top 'N' populated countries in a continent where N is provided by the user
    public ArrayList<Country> getTopNCountriesInAContinent(int topN, String continent)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name as Capital "
                            + "FROM country, city "
                            + "WHERE country.capital = city.ID "
                            + "AND country.Continent = '" + continent + "' "
                            + "ORDER BY country.Population DESC "
                            + "LIMIT " + topN + "";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract country information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.Capital = new City();
                country.Code = rset.getString("Code");
                country.Name = rset.getString("Name");
                country.Continent = rset.getString("Continent");
                country.Region = rset.getString("Region");
                country.Population = rset.getInt("Population");
                country.Capital.Name = rset.getString("Capital");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to retrieve top 'N' countries in a continent");
            return null;
        }
    }

    // Report 06 - Retrieve the top 'N' populated countries in a region where N is provided by the user
    public ArrayList<Country> getTopNCountriesInARegion(int topN, String region)
    {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name as Capital "
                            + "FROM country, city "
                            + "WHERE country.capital = city.ID "
                            + "AND country.Region = '" + region + "' "
                            + "ORDER BY country.Population DESC "
                            + "LIMIT " + topN + "";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract country information
            ArrayList<Country> countries = new ArrayList<Country>();
            while (rset.next()) {
                Country country = new Country();
                country.Capital = new City();
                country.Code = rset.getString("Code");
                country.Name = rset.getString("Name");
                country.Continent = rset.getString("Continent");
                country.Region = rset.getString("Region");
                country.Population = rset.getInt("Population");
                country.Capital.Name = rset.getString("Capital");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to retrieve top 'N' countries in a region");
            return null;
        }
    }

    /**
     * Prints a list of countries. This method is called by each individual method as they all produce a Country Report
     * @param countries The list of countries to print.
     */
    public void printCountries(ArrayList<Country> countries)
    {
        // Print header
        System.out.println(String.format("%-10s %-50s %-30s %-30s %-20s %-30s", "Code", "Name", "Continent", "Region", "Population", "Capital"));

        // Check countries is not null
        if (countries == null)
        {
            System.out.println("No country reports found");
            return;
        }

        // Loop over all countries in the list
        for (Country country : countries)
        {
            if (country == null)
                continue;

            String country_string =
                    String.format("%-10s %-50s %-30s %-30s %-20s %-30s",
                            country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital.Name);
            System.out.println(country_string);
        }
    }
}
