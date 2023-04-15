package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static com.napier.sem.App.con;

public class CityReporting {
    public void RunSamples(){
        System.out.println("\nCity Reporting");

        // Report 07 - All the cities in the world organised by largest population to smallest
        System.out.println("Report 07 - All the cities in the world organised by largest population to smallest");
        System.out.println("Parameters: None");
        ArrayList<City> cities01;
        cities01 = getCitiesByPopulation();
        printCities(cities01);

        // Report 08 - All the cities in a continent organised by largest population to smallest
        System.out.println("Report 08 - All the cities in a continent organised by largest population to smallest");
        System.out.println("Parameters: Continent = Asia");
        ArrayList<City> cities02;
        cities02 = getCitiesForContinentByPopulation("Asia");
        printCities(cities02);

        // Report 9 - All the cities in a region organised by largest population to smallest
        System.out.println("Report 9 - All the cities in a region organised by largest population to smallest");
        System.out.println("Parameters: Region = Australia and New Zealand");
        ArrayList<City> cities03;
        cities03 = getCitiesForRegionByPopulation("Australia and New Zealand");
        printCities(cities03);

        // Report 10 - All the cities in a country organised by largest population to smallest
        System.out.println("Report 10 - All the cities in a country organised by largest population to smallest");
        System.out.println("Parameters: Country = Poland");
        ArrayList<City> cities04;
        cities04 = getCitiesForCountryByPopulation("Poland");
        printCities(cities04);

        // Report 11 - All the cities in a district organised by largest population to smallest
        System.out.println("Report 11 - All the cities in a district organised by largest population to smallest");
        System.out.println("Parameters: District = California");
        ArrayList<City> cities05;
        cities05 = getCitiesForDistrictByPopulation("California");
        printCities(cities05);

        // Report 12 - The top 'N' populated cities in the world where N is provided by the user
        System.out.println("Report 12 - The top 'N' populated cities in the world where N is provided by the user");
        System.out.println("TopN = 5");
        ArrayList<City> cities06;
        cities06 = getTopNCitiesInTheWorld(5);
        printCities(cities06);

        // Report 13 - the top n populated cities in a continent by population
        System.out.println("Report 13 - the top n populated cities in a continent by population");
        System.out.println("Parameters: Continent = Europe, TopN=5");
        ArrayList<City> cities13;
        cities13 = getTopNCitiesForContinentByPopulation("Europe",5);
        printCities(cities13);

        // Report 14 - The top 'N' populated cities in a country where N is provided by the user

        //Report 15 - The top 'N' populated cities in a country where N is provided by the user
        System.out.println("//Report 15 - The top 'N' populated cities in a country where N is provided by the user");
        System.out.println("Parameters: country = Norway, TopN=5");
        ArrayList<City> cities09;
        cities09 = getTopNCitiesForCountryByPopulation("Norway",5);
        printCities(cities09);

        // Report 16 - The top 'N' populated cities in a district where N is provided by the user
        System.out.println("Report 16 - The top 'N' populated cities in a district where N is provided by the user");
        System.out.println("Parameters: District = California, TopN=5");
        ArrayList<City> cities10;
        cities10 = getTopNCitiesForDistrictByPopulation("California",5);
        printCities(cities10);
    }

    // Report 07 - All the cities in the world organised by largest population to smallest
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

    // Report 08 - All the cities in a continent organised by largest population to smallest
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
            System.out.println("Failed to retrieve cities in a continent");
            return null;
        }
    }

    // Report 9 - All the cities in a region organised by largest population to smallest
    private ArrayList<City> getCitiesForRegionByPopulation(String region)
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
            System.out.println("Failed to retrieve cities in a region");
            return null;
        }
    }

    // Report 10 - All the cities in a country organised by largest population to smallest
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
            System.out.println("Failed to retrieve cities in a country");
            return null;
        }
    }

    // Report 11 - All the cities in a district organised by largest population to smallest
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
            System.out.println("Failed to retrieve cities in a district");
            return null;
        }
    }

    // Report 12 - The top 'N' populated cities in the world where N is provided by the user
    public ArrayList<City> getTopNCitiesInTheWorld(int topN)
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
                            + "ORDER BY city.Population DESC "
                            + "LIMIT " + topN;

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
            System.out.println("Failed to retrieve top 'N' cities");
            return null;
        }
    }

    // Report 13 - The top 'N' populated cities in a continent where N is provided by the user

    public ArrayList<City> getTopNCitiesForContinentByPopulation(String continent, int topn)
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



    // Report 14 - The top 'N' populated cities in a region where N is provided by the user

    //Report 15 - The top 'N' populated cities in a country where N is provided by the user
    public ArrayList<City> getTopNCitiesForCountryByPopulation(String country, int topN)
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
                            + "LIMIT " + topN;

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
            System.out.println("Failed to retrieve top 'N' cities in a country");
            return null;
        }
    }

    // Report 16 - The top 'N' populated cities in a district where N is provided by the user
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
            System.out.println("Failed to retrieve top 'N' cities in a district");
            return null;
        }
    }

    /**
     * Prints a list of cities. This method is called by each individual method as they all produce a City Report
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
