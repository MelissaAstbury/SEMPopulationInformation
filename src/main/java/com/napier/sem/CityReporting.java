package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static com.napier.sem.App.con;

public class CityReporting {
    public void RunSamples(){
        System.out.println("\nCity Reporting");

        // Report 01 - Cites by population
        System.out.println("Report 01 - Cities by population");
        System.out.println("Parameters: None");
        ArrayList<City> cities01 = new ArrayList<City>();
        cities01 = getCitiesByPopulation();
        printCities(cities01);

        // Report 02 - Cites for continent by population
        System.out.println("Report 02 - Cities for continent by population");
        System.out.println("Parameters: Continent = Asia");
        ArrayList<City> cities02 = new ArrayList<City>();
        cities02 = getCitiesForContinentByPopulation("Asia");
        printCities(cities02);

        // Report 03 - Cites for district by population
        System.out.println("Report 03 - Cities for district by population");
        System.out.println("Parameters: District = California");
        ArrayList<City> cities03 = new ArrayList<City>();
        cities03 = getCitiesForDistrictByPopulation("California");
        printCities(cities03);

        // Report 04 - All the cities in a country
        System.out.println("Report 04 - Cities in a country by population");
        System.out.println("Parameters: Country = Poland");
        ArrayList<City> cities04 = new ArrayList<City>();
        cities04 = getCitiesForCountryByPopulation("Poland");
        printCities(cities04);

        // Report 05 - All the cities in a region
        System.out.println("Report 05 - Cities in a region by population");
        System.out.println("Parameters: Region = Australia and New Zealand");
        ArrayList<City> cities05 = new ArrayList<City>();
        cities05 = getCitiesForRegionByPopulation("Australia and New Zealand");
        printCities(cities05);

        // Report 16 - the top n populated cities in a district by population
        System.out.println("Report 16 - the top n populated cities in a district by population");
        System.out.println("Parameters: District = California, TopN=5");
        ArrayList<City> cities16 = new ArrayList<City>();
        cities16 = getTopNCitiesForDistrictByPopulation("California",5);
        printCities(cities16);

        // Report 15 - the top n populated cities in a country by population
        System.out.println("Report 15 - the top n populated cities in a country by population");
        System.out.println("Parameters: country = Norway, TopN=5");
        ArrayList<City> cities15 = new ArrayList<City>();
        cities15 = getTopNCitiesForCountryByPopulation("Norway",5);
        printCities(cities15);
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

    public ArrayList<City> getCitiesForContinentByPopulation(String continent)
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
                            + "AND country.Continent = '" + continent + "'"
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

    public ArrayList<City> getCitiesForDistrictByPopulation(String district)
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
                            + "AND city.District = '" + district + "'"
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

    public ArrayList<City> getCitiesForCountryByPopulation(String country)
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
                            + "AND country.Name = '" + country + "'"
                            + "ORDER BY city.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
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

    private ArrayList<City> getCitiesForRegionByPopulation(String region) {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, country.Name Country, city.District, city.Population "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code "
                            + "AND country.Region = '" + region + "'"
                            + "ORDER BY city.Population DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
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

    public ArrayList<City> getTopNCitiesForDistrictByPopulation(String district, int topn)
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
                            + "AND city.District = '" + district + "'"
                            + "ORDER BY city.Population DESC "
                            + "LIMIT " + topn;

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


    public ArrayList<City> getTopNCitiesForCountryByPopulation(String country, int topn)
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
                            + "AND country.Name = '" + country + "'"
                            + "ORDER BY city.Population DESC "
                            + "LIMIT " + topn;

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
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
        // Check cities is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.println(String.format("%-50s %-50s %-50s %-20s", "Name", "Country", "District", "Population"));
        // Loop over all countries in the list
        for (City city : cities)
        {
            if (city == null)
                continue;

            String city_string =
                    String.format("%-50s %-50s %-50s %-20s",
                            city.Name, city.Country.Name, city.District, city.Population);
            System.out.println(city_string);
        }
    }
}
