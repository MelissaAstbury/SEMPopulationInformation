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

        // Report 25 - People Living/Not Living in Cities in each Country
        System.out.println("Report 25 - People Living/Not Living in Cities in each Country");
        System.out.println("Parameters: None");
        ArrayList<PopulationReport> populationReport25 = new ArrayList<PopulationReport>();
        populationReport25 = getPeopleLivingNotLivingInCitiesInEachCountry();
        printPopulationReport(populationReport25);

        // Report 29 - Countries by population
        System.out.println("Report 29 - Population of a country");
        System.out.println("Parameters: country = Ireland");
        ArrayList<PopulationReport> populationReport29 = new ArrayList<PopulationReport>();
        populationReport29 = getPopulationForCountry("Ireland");
        printPopulationReport(populationReport29);
    }

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
                populationReport.TotalPopulation = rset.getInt("TotalPopulation");
                populationReport.TotalPopulationInCities = rset.getInt("TotalPopulationInCities");
                populationReport.PercentageInCities = rset.getDouble("PercentageInCities");
                populationReport.TotalPopulationNotInCities = rset.getInt("TotalPopulationNotInCities");
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
                populationReport.TotalPopulation = rset.getInt("TotalPopulation");
                populationReport.TotalPopulationInCities = rset.getInt("TotalPopulationInCities");
                populationReport.PercentageInCities = rset.getDouble("PercentageInCities");
                populationReport.TotalPopulationNotInCities = rset.getInt("TotalPopulationNotInCities");
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

        // Loop over all population items in the list
        for (PopulationReport populationReport : populationReports)
        {
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
