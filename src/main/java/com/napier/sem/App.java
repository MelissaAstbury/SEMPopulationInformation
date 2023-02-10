package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
public class App
{
    public static void main(String[] args)
    {
        System.out.println("Let's go! attempt 1");
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Extract employee salary information
        ArrayList<Country> countries = a.getCountries();
        ArrayList<Country> countriesInAContinent = a.getCountriesInAContinent();

        // Test the size of the returned data - should be 240124
        System.out.println(countries.size());
        System.out.println(countriesInAContinent.size());

        // Display
        a.printCountries(countries);
        a.printCountriesInAContinent(countriesInAContinent);

        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Gets all the countries
     * @return A list of all countries.
     */
    public ArrayList<Country> getCountries()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name as Capital "
                            + "FROM country, city "
                            + "WHERE country.capital = city.ID";
                            //+ "ORDER BY country.Population DESC";
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

    /**
     * Prints a list of countries.
     * @param countries The list of countries to print.
     */
    public void printCountries(ArrayList<Country> countries)
    {
        // Print header
        System.out.println(String.format("%-10s %-50s %-30s %-30s %-20s %-30s", "Code", "Name", "Continent", "Region", "Population", "Capital"));
        // Loop over all countries in the list
        for (Country country : countries)
        {
            String country_string =
                    String.format("%-10s %-50s %-30s %-30s %-20s %-30s",
                            country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital.Name);
            System.out.println(country_string);
        }
    }

    /**
     * Gets all the countries in a continent
     * @return A list of all countries.
     */
    public ArrayList<Country> getCountriesInAContinent()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create SQL statement
            String query =
                    "SELECT * "
                            + "FROM countries "
                            + "WHERE continent = Europe"
                            + "ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(query);
            // Extract country information
            ArrayList<Country> countries = new ArrayList<>();
            while (result.next())
            {
                Country country = new Country();
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
            System.out.println("Failed to retrieve countries from a continent");
            return null;
        }
    }

    /**
     * Prints a list of countriesInAContinent.
     * @param countriesInAContinent The list of countries to print.
     */
    public void printCountriesInAContinent(ArrayList<Country> countriesInAContinent)
    {
        // Print header
        System.out.println(String.format("%-10s %-50s %-30s %-30s %-20s %-30s", "Code", "Name", "Continent", "Region", "Population", "Capital"));
        // Loop over all countries in the list
        for (Country country : countriesInAContinent)
        {
            String country_string =
                    String.format("%-10s %-50s %-30s %-30s %-20s %-30s",
                            country.Code, country.Name, country.Continent, country.Region, country.Population, country.Capital.Name);
            System.out.println(country_string);
        }
    }
}
