package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static com.napier.sem.App.con;

/**
 * Population Reports - Data retrieval and Report output
 */

public class PopulationReporting {
    public void RunSamples() {

        System.out.println("\nPopulation Reporting");
        System.out.println("====================");


        // Report 23 - People Living In/ Not Living In Cities In Each Continent
        System.out.println("Report 23 - People Living In/ Not Living In Cities In Each Continent");
        System.out.println("Parameters: None");
        ArrayList<PopulationReport> populationReport23 = new ArrayList<PopulationReport>();
        populationReport23 = getPeopleLivingNotLivingInCitiesInEachContinent();
        printPopulationReport(populationReport23);

        // Report 24 - People Living In/ Not Living In Cities In Each Region
        System.out.println("Report 24 - People Living In/ Not Living In Cities In Each Region");
        System.out.println("Parameters: None");
        ArrayList<PopulationReport> populationReport24 = new ArrayList<PopulationReport>();
        populationReport24 = getPeopleLivingNotLivingInCitiesInEachRegion();
        printPopulationReport(populationReport24);

        // Report 25 - People Living/Not Living in Cities in each Country
        System.out.println("Report 25 - People Living/Not Living in Cities in each Country");
        System.out.println("Parameters: None");
        ArrayList<PopulationReport> populationReport25 = new ArrayList<PopulationReport>();
        populationReport25 = getPeopleLivingNotLivingInCitiesInEachCountry();
        printPopulationReport(populationReport25);

        // Report 28 - People Living/Not Living in Cities in a region
        System.out.println("Report 28 - People Living/Not Living in Cities in a Region");
        System.out.println("Parameters: South America");
        ArrayList<PopulationReport> populationReport28 = new ArrayList<PopulationReport>();
        populationReport28 = getPeopleLivingNotLivingInCitiesInARegion();
        printPopulationReport(populationReport28);

        // Report 29 - Countries by population
        System.out.println("Report 29 - Population of a country");
        System.out.println("Parameters: country = Ireland");
        ArrayList<PopulationReport> populationReport29 = new ArrayList<PopulationReport>();
        populationReport29 = getPopulationForCountry("Ireland");
        printPopulationReport(populationReport29);
    }

    // Report 23 - People Living In/ Not Living In Cities In Each Continent
    public ArrayList<PopulationReport> getPeopleLivingNotLivingInCitiesInEachContinent()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT  c.Continent as Name "
                            + ", Sum(distinct c.Population) as TotalPopulation "
                            + ", Sum(ci.Population) as TotalPopulationInCities "
                            + ", (Sum(ci.Population) / Sum(distinct c.Population)) PercentageInCities "
                            + ", (Sum(distinct c.Population) - Sum(ci.Population)) TotalPopulationNotInCities "
                            + ", (Sum(distinct c.Population)-Sum(ci.Population))/ Sum(distinct c.Population) PercentageNotInCities "
                            + "FROM country c "
                            + "LEFT JOIN city as ci "
                            + "ON c.Code = ci.CountryCode "
                            + "GROUP BY Continent "
                            + "ORDER BY TotalPopulation "
                            + "DESC LIMIT 6";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract country information
            ArrayList<PopulationReport> populationReports = new ArrayList<PopulationReport>();
            while (rset.next())
            {
                PopulationReport populationReport = new PopulationReport();

                populationReport.Name = rset.getString("Name");
                populationReport.TotalPopulation = rset.getLong("TotalPopulation");
                populationReport.TotalPopulationInCities = rset.getLong("TotalPopulationInCities");
                populationReport.PercentageInCities = rset.getDouble("PercentageInCities");
                populationReport.TotalPopulationNotInCities = rset.getLong("TotalPopulationNotInCities");
                populationReport.PercentageNotInCities = rset.getDouble("PercentageNotInCities");
                populationReports.add(populationReport);
            }
            return populationReports;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

    // Report 24 - People Living In/ Not Living In Cities In Each Region
    public ArrayList<PopulationReport> getPeopleLivingNotLivingInCitiesInEachRegion()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT  c.Region as Name "
                            + ", Sum(distinct c.Population) as TotalPopulation "
                            + ", Sum(ci.Population) as TotalPopulationInCities "
                            + ", (Sum(ci.Population) / Sum(distinct c.Population)) PercentageInCities "
                            + ", (Sum(distinct c.Population) - Sum(ci.Population)) TotalPopulationNotInCities "
                            + ", (Sum(distinct c.Population)-Sum(ci.Population))/ Sum(distinct c.Population) PercentageNotInCities "
                            + "FROM country c "
                            + "LEFT JOIN city as ci "
                            + "ON c.Code = ci.CountryCode "
                            + "GROUP BY Region "
                            + "ORDER BY TotalPopulation DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract country information
            ArrayList<PopulationReport> populationReports = new ArrayList<PopulationReport>();
            while (rset.next())
            {
                PopulationReport populationReport = new PopulationReport();

                populationReport.Name = rset.getString("Name");
                populationReport.TotalPopulation = rset.getLong("TotalPopulation");
                populationReport.TotalPopulationInCities = rset.getLong("TotalPopulationInCities");
                populationReport.PercentageInCities = rset.getDouble("PercentageInCities");
                populationReport.TotalPopulationNotInCities = rset.getLong("TotalPopulationNotInCities");
                populationReport.PercentageNotInCities = rset.getDouble("PercentageNotInCities");
                populationReports.add(populationReport);
            }
            return populationReports;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }
    // Report 25 - People Living/Not Living in Cities in each Country
    public ArrayList<PopulationReport> getPeopleLivingNotLivingInCitiesInEachCountry()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT c.Name, c.Population AS TotalPopulation "
                            + ", cp.TotalPopulationInCities "
                            + ", (cp.TotalPopulationInCities / c.Population) PercentageInCities "
                            + ", (c.Population - cp.TotalPopulationInCities) TotalPopulationNotInCities "
                            + ", ((c.Population - cp.TotalPopulationInCities) / c.Population) PercentageNotInCities "
                            + "FROM country c "
                            + "JOIN (SELECT CountryCode, SUM(Population) AS TotalPopulationInCities "
                            + "FROM city "
                            + "GROUP BY CountryCode) cp ON cp.CountryCode = c.Code";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract country information
            ArrayList<PopulationReport> populationReports = new ArrayList<PopulationReport>();
            while (rset.next())
            {
                PopulationReport populationReport = new PopulationReport();

                populationReport.Name = rset.getString("Name");
                populationReport.TotalPopulation = rset.getLong("TotalPopulation");
                populationReport.TotalPopulationInCities = rset.getLong("TotalPopulationInCities");
                populationReport.PercentageInCities = rset.getDouble("PercentageInCities");
                populationReport.TotalPopulationNotInCities = rset.getLong("TotalPopulationNotInCities");
                populationReport.PercentageNotInCities = rset.getDouble("PercentageNotInCities");
                populationReports.add(populationReport);
            }
            return populationReports;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

    // Report 28 - People Living/Not Living in Cities in a Region
    public ArrayList<PopulationReport> getPeopleLivingNotLivingInCitiesInARegion()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT c2.Name, c2.Population AS TotalPopulation "
                            + ", cp.TotalPopulationInCities "
                            + ", (cp.TotalPopulationInCities / c2.Population) PercentageInCities "
                            + ", (c2.Population - cp.TotalPopulationInCities) TotalPopulationNotInCities "
                            + ", ((c2.Population - cp.TotalPopulationInCities) / c2.Population) PercentageNotInCities "
                            + "FROM (SELECT region AS Name, SUM(Population) Population "
                            + "FROM country "
                            + "WHERE region = 'South America') c2 "
                            + "JOIN (SELECT country.region AS Name, SUM(city.Population) TotalPopulationInCities "
                            + "FROM city, country "
                            + "WHERE city.CountryCode = country.Code "
                            + "AND country.region = 'South America') cp ON cp.Name = c2.Name";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract country information
            ArrayList<PopulationReport> populationReports = new ArrayList<PopulationReport>();
            while (rset.next())
            {
                PopulationReport populationReport = new PopulationReport();

                populationReport.Name = rset.getString("Name");
                populationReport.TotalPopulation = rset.getLong("TotalPopulation");
                populationReport.TotalPopulationInCities = rset.getLong("TotalPopulationInCities");
                populationReport.PercentageInCities = rset.getDouble("PercentageInCities");
                populationReport.TotalPopulationNotInCities = rset.getLong("TotalPopulationNotInCities");
                populationReport.PercentageNotInCities = rset.getDouble("PercentageNotInCities");
                populationReports.add(populationReport);
            }
            return populationReports;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

    /**
     * Get population data for a country
     * @param country The list of cities to print.
     */
    // Report 29 - Countries by population
    public ArrayList<PopulationReport> getPopulationForCountry(String country)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT c.Name, c2.Population AS TotalPopulation "
                        + ", cp.TotalPopulationInCities "
                        + ", (cp.TotalPopulationInCities / c2.Population) PercentageInCities "
                        + ", (c2.Population - cp.TotalPopulationInCities) TotalPopulationNotInCities "
                        + ", ((c2.Population - cp.TotalPopulationInCities) / c2.Population) PercentageNotInCities "
                        + "FROM country c "
                        + "JOIN (SELECT Code, Population FROM country) c2 ON c2.Code = c.Code "
                        + "JOIN (SELECT CountryCode, SUM(Population) AS TotalPopulationInCities "
                        + "      FROM city "
                        + "      GROUP BY CountryCode) cp ON cp.CountryCode = c.Code "
                        + "WHERE c.Name = '" + country + "'";


            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract country information
            ArrayList<PopulationReport> populationReports = new ArrayList<PopulationReport>();
            while (rset.next())
            {
                PopulationReport populationReport = new PopulationReport();

                populationReport.Name = rset.getString("Name");
                populationReport.TotalPopulation = rset.getLong("TotalPopulation");
                populationReport.TotalPopulationInCities = rset.getLong("TotalPopulationInCities");
                populationReport.PercentageInCities = rset.getDouble("PercentageInCities");
                populationReport.TotalPopulationNotInCities = rset.getLong("TotalPopulationNotInCities");
                populationReport.PercentageNotInCities = rset.getDouble("PercentageNotInCities");
                populationReports.add(populationReport);
            }
            return populationReports;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

    /**
     * Prints a population report
     * @param populationReports The list of cities to print.
     */
    public void printPopulationReport(ArrayList<PopulationReport> populationReports)
    {
        // Print header
        System.out.println(String.format("%-50s %-20s %-35s %-20s %-35s %-20s",
                "Name", "Total Population",
                "Total Population (In Cities)", "% (In Cities)",
                "Total Population (Not In Cities)", "% (Not In Cities)"));

        // Check if population is not null
        if (populationReports == null)
        {
            System.out.println("No population reports");
            return;
        }

        // Loop over all population items in the list
        for (PopulationReport populationReport : populationReports)
        {
            if (populationReport == null)
                continue;

            String population_string =
                    String.format("%-50s %-20s %-35s %-20s %-35s %-20s",
                            populationReport.Name,
                            populationReport.TotalPopulation,
                            populationReport.TotalPopulationInCities,
                            populationReport.PercentageInCities * 100, // Express as a percentage
                            populationReport.TotalPopulationNotInCities,
                            populationReport.PercentageNotInCities * 100); // Express as a percentage
            System.out.println(population_string);
        }
    }
}
