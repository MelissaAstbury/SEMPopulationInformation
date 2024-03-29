# Software Engineering Methods - Group 2 Assessment

- Developer Build Status ![GitHub Workflow Status (with branch)](https://img.shields.io/github/actions/workflow/status/MelissaAstbury/SEMPopulationInformation/main.yml?branch=develop)
- Master Build Status ![GitHub Workflow Status (with branch)](https://img.shields.io/github/actions/workflow/status/MelissaAstbury/SEMPopulationInformation/main.yml?branch=master)
- License ![LICENSE](https://img.shields.io/github/license/MelissaAstbury/SEMPopulationInformation.svg?style=flat-square)
- Release [![Releases](https://img.shields.io/github/v/tag/melissaastbury/sempopulationinformation?label=Release&sort=semver)](https://github.com/MelissaAstbury/SEMPopulationInformation/releases)
- Developer Coverage  [![codecov](https://codecov.io/gh/MelissaAstbury/SEMPopulationInformation/branch/develop/graph/badge.svg?token=098DKJ7AGC)](https://codecov.io/gh/MelissaAstbury/SEMPopulationInformation)
- Master Coverage  [![codecov](https://codecov.io/gh/MelissaAstbury/SEMPopulationInformation/branch/master/graph/badge.svg?token=098DKJ7AGC)](https://codecov.io/gh/MelissaAstbury/SEMPopulationInformation)
-----
# Checklist for Code Review 1

| Task number | Description                                                                                                                                                                                                          | Done / Not Done | 
|:-----------:|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:---------------:|
|      1      | GitHub project for coursework set-up                                                                                                                                                                                 |      Done       |
|      2      | Product Backlog created.                                                                                                                                                                                             |      Done       |
|      3      | Project builds to self-contained JAR with Maven.                                                                                                                                                                     |      Done       | 
|      4      | Dockerfile for project set-up and works.                                                                                                                                                                             |      Done       | 
|      5      | GitHub Actions for project set-up and build is working using JAR, and Docker on GitHub Actions.                                                                                                                      |      Done       |
|      6      | Correct branches for GitFlow workflow created - includes <span style= 'background:blue'> master</span>, <span style= 'background:blue'> develop</span>, and <span style= 'background:blue'> release</span> branches. |      Done       |
|      7      | First release created on GitHub.                                                                                                                                                                                     |      Done       | 
|      8      | Code of Conduct defined.                                                                                                                                                                                             |      Done       | 
|      9      | Issues being used on GitHub.                                                                                                                                                                                         |      Done       |
|     10      | Tasks defined as user stories.                                                                                                                                                                                       |      Done       |
|     11      | Project integrated with Zube.io.                                                                                                                                                                                     |      Done       | 
|     12      | Kanban/Project Board being used.                                                                                                                                                                                     |      Done       | 
|     13      | Sprint Boards being used.                                                                                                                                                                                            |      Done       |
|     14      | Full use cases defined.                                                                                                                                                                                              |      Done       |
|     15      | Use case diagram created.                                                                                                                                                                                            |      Done       | 

The Kanban/Project Board can be accessed from [this link.](https://zube.io/napier-253/project-board/w/workspace-1/kanban)

---
# Queries for Code Review 2
**Please note these are only snapshots. Some queries were too big to capture all results in the screenshots**
> Reports done: 32/32 = 100%

| ID  | Name                                                                                                        | Met | Screenshot                                                       |
|-----|-------------------------------------------------------------------------------------------------------------|-----|------------------------------------------------------------------|
| 1   | All the countries in the world organised by largest population to smallest                                  | Yes | ![img.png](getCountriesByPopulation.png)                         |
| 2   | All the countries in a continent organised by largest population to smallest                                | Yes | ![img.png](getCountriesInAContinent.png)                         |
| 3   | All the countries in a region organised by largest population to smallest                                   | Yes | ![img.png](getCountriesForRegion.png)                            |
| 4   | The top 'N' populated countries in the world where N is provided by the user                                | Yes | ![img.png](getTopNCountriesByPopulation.png)                     |
| 5   | The top 'N' populated countries in a continent where N is provided by the user                              | Yes | ![img.png](getTopNCountriesInAContinent.png)                     |
| 6   | The top 'N' populated countries in a region where N is provided by the user                                 | Yes | ![img.png](getTopNCountriesInARegion.png)                        |
| 7   | All the cities in the world organised by largest population to smallest                                     | Yes | ![img.png](getCitiesByPopulation.png)                            |
| 8   | All the cities in a continent organised by largest population to smallest                                   | Yes | ![img.png](getCitiesForContinentByPopulation.png)                |
| 9   | All the cities in a region organised by largest population to smallest                                      | Yes | ![img.png](getCitiesForRegionByPopulation.PNG)                   |
| 10  | All the cities in a country organised by largest population to smallest                                     | Yes | ![img.png](getCitiesForCountryByPopulation.PNG)                  |
| 11  | All the cities in a district organised by largest population to smallest                                    | Yes | ![img.png](getCitiesForDistrictByPopulation.png)                 |
| 12  | The top 'N' populated cities in the world where N is provided by the user                                   | Yes | ![img.png](getTopNCitiesInTheWorld.png)                          |
| 13  | The top 'N' populated cities in a continent where N is provided by the user                                 | Yes | ![img.png](getTopNCitiesForContinentByPopulation.png)            |
| 14  | The top 'N' populated cities in a region where N is provided by the user                                    | Yes | ![img.png](getTopNCitiesForRegionByPopulationReport14.png)       |
| 15  | The top 'N' populated cities in a country where N is provided by the user                                   | Yes | ![img.png](getTopNCitiesforCountrybyPopulation.png)              |
| 16  | The top 'N' populated cities in a district where N is provided by the user                                  | Yes | ![img.png](getTopNCitiesforDistrictbyPopulation.png)             |
| 17  | All the capital cities in the world organised by largest population to smallest                             | Yes | ![img.png](getCapitalCitiesByPopulation.png)                     |
| 18  | All the capital cities in a continent organised by largest population to smallest                           | Yes | ![img.png](getCapitalCitiesForContinentByPopl.PNG)               |
| 19  | All the capital cities in a region organised by largest to smallest                                         | Yes | ![img.png](getCapitalCitiesForRegionByPopulation.png)            |
| 20  | The top 'N' populated capital cities in the world where N is provided by the user                           | Yes | ![img.png](getTopNCapitalCitiesInTheWorld.png)                   |
| 21  | The top 'N' populated capital cities in a continent where N is provided by the user                         | Yes | ![img.png](getTopNCapitalCitiesinaContinent.png)                 |
| 22  | The top 'N' populated capital cities in a region where N is provided by the user                            | Yes | ![img.png](getTopNCapitalCitiesInARegion.png)                    |
| 23  | The population of people, people living in cities, and people not living in cities in each continent        | Yes | ![img.png](getPeopleLinvingAndNotLivingInCitiesPerContinent.png) |
| 24  | The population of people, people living in cities, and people not living in cities in each region           | Yes | ![img.png](getPeopleLinvingAndNotLivingInCitiesPerRegion.png)    |
| 25  | The population of people, people living in cities, and people not living in cities in each country          | Yes | ![img.png](getPeopleLivingNotLivingInCItiesPerCountry.png)       |
| 26  | The population of the world                                                                                 | Yes | ![img.png](getPopulationOfTheWorld.png)                          |
| 27  | The population of a continent                                                                               | Yes | ![img.png](getPopulationForContinent.png)                        |
| 28  | The population of a region                                                                                  | Yes | ![img.png](getPeopleLivingNotLivingInCitiesInARegion.png)        |
| 29  | The population of a country                                                                                 | Yes | ![img.png](getPopulationForCountry.PNG)                          |
| 30  | The population of a district                                                                                | Yes | ![img.png](getPopupationOfADistrict.png)                         |
| 31  | The population of a city                                                                                    | Yes | ![img.png](getPopulationOfACity.png)                             |
| 32  | The number of people who speak Chinese, English, Hindi, Spanish and Arabic from greatest number to smallest | Yes | ![img.png](getLanguageByPopulation.PNG)                          |
