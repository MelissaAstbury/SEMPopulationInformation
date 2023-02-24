# USE CASE: Produce all population reports.

## CHARACTERISTIC INFORMATION

### Goal in Context

*"As a **report user, I want to obtain the population reports**, so that **I can report this information to the organization"***

### Scope

Company.

### Level

Primary task.

### Preconditions

The role is known.  The database contains current data about the population.

### Success End Condition

A report is available for the Report User to provide the required information to the organization.

### Failed End Condition

No report is produced.

### Primary Actor

The report user

### Trigger

The organization asks the report user for information.

## MAIN SUCCESS SCENARIO

1. The organization requests the report user for population reports.
2. The report user gathers the requirements of the report.
3. The report user retrieves the required information from the database.
4. The report user provides the report to the organization.

## EXTENSIONS

1. If some required information does not exist on the Database it will be reported to the database administrator.
2. If the software application used to retrieve the information fails, it will be reported to the developers.

## SUB-VARIATIONS

There are nine different population reports that can be required from the organization:

1. The population of people, people living in cities, and people not living in cities in each 
continent.
2. The population of people, people living in cities, and people not living in cities in each
region.
3. The population of people, people living in cities, and people not living in cities in each
country.
4. The population of the world.
5. The population of a continent.
6. The population of a region.
7. The population of a country.
8. The population of a district.
9. The population of a city.

## SCHEDULE

**DUE DATE**: 24-February-2023