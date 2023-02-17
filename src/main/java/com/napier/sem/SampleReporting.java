package com.napier.sem;

public class SampleReporting {

    public void RunSamples() {
        CountryReporting countryReporting = new CountryReporting();
        CityReporting cityReporting = new CityReporting();
        CapitalCityReporting capitalCityReporting = new CapitalCityReporting();
        PopulationReporting populationReporting = new PopulationReporting();
        LanguageReporting languageReporting = new LanguageReporting();

        countryReporting.RunSamples();
        cityReporting.RunSamples();
        capitalCityReporting.RunSamples();
        populationReporting.RunSamples();
        languageReporting.RunSamples();
    }
}
