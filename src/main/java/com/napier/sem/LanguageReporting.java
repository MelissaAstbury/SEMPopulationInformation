package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static com.napier.sem.App.con;

/**
 * <h1>Language Reporting</h1>
 * Data retrieval and reporting for all reports with the standard language report format
 */

public class LanguageReporting {
    public void RunSamples() {

        System.out.println("\nLanguage Reporting");
        System.out.println("====================");

        // Report 32 - Countries by population
        System.out.println("Report 32 - Language Population comparison report for (Chinese,English,Hindi,Spanish and Arabic only)");
        System.out.println("Parameters: None");
        ArrayList<LanguageReport> languageReport32 = new ArrayList<LanguageReport>();
        languageReport32 = getLanguageByPopulation();
        printLanguageReport(languageReport32);
    }

    /**
     * Get language data
     */
    public ArrayList<LanguageReport> getLanguageByPopulation()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String strSelect =
                    "SELECT Language, CAST(TotalPopulation AS SIGNED) TotalPopulation, (TotalPopulation / World.Population) Percentage "
                    + "FROM "
                    + "  (SELECT Language, SUM((countrylanguage.Percentage / 100) * country.Population) as TotalPopulation "
                    + "  FROM countrylanguage "
                    + "  JOIN country ON country.Code = countrylanguage.CountryCode "
                    + "  AND countrylanguage.Language in('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic') "
                    + "  GROUP BY Language) AS languagepopulation "
                    + "JOIN (SELECT SUM(Population) AS Population "
                    + "      FROM country) World "
                    + "ORDER BY TotalPopulation DESC";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

            // Extract language information
            ArrayList<LanguageReport> languageReports = new ArrayList<LanguageReport>();
            while (rset.next())
            {
                LanguageReport languageReport = new LanguageReport();

                languageReport.Language = rset.getString("Language");
                languageReport.TotalPopulation = rset.getInt("TotalPopulation");
                languageReport.PercentageOfWorldPopulation = rset.getDouble("Percentage");
                languageReports.add(languageReport);
            }
            return languageReports;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get details");
            return null;
        }
    }

    /**
     * Prints a language report
     * @param languageReports The list of language population statistics to print.
     */
    public void printLanguageReport(ArrayList<LanguageReport> languageReports)
    {
        // Print header
        System.out.println(String.format("%-50s %-20s %-35s",
                "Language", "Total Population", "% of World Population"));

        // Check is not null
        if (languageReports == null)
        {
            System.out.println("No language reports");
            return;
        }

        // Loop over all items in the list
        for (LanguageReport languageReport : languageReports)
        {
            if (languageReport == null)
                continue;
            String language_string =
                    String.format("%-50s %-20s %.2f",
                            languageReport.Language,
                            languageReport.TotalPopulation,
                            languageReport.PercentageOfWorldPopulation * 100);
            System.out.println(language_string);
        }
    }
}
