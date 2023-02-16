# USE CASE: Produce all country reports.

## CHARACTERISTIC INFORMATION

### Goal in Context

*"As a **report user, I want to obtain the country reports**, so that **I can report this information to the organization"***

### Scope

Company.

### Level

Primary task.

### Preconditions

The role is known.  The database contains current data about the countries.

### Success End Condition

A report is available for the Report User to provide the required information to the organization.

### Failed End Condition

No report is produced.

### Primary Actor

The report user

### Trigger

The organization asks the report user for information.

## MAIN SUCCESS SCENARIO

1. The organization requests the report user for country reports.
2. The report user gathers the requirements of the report.
3. The report user retrieves the required information from the database.
4. The report user provides the report to the organization.

## EXTENSIONS

1. If some required information does not exist on the Database it will be reported to the database administrator.
2. If the software application used to retrieve the information fails, it will be reported to the developers.

## SUB-VARIATIONS

The category of *Country reports* contains 6 reports that can be required from the organization:

    1. All the countries in the world organised by largest population to smallest.
    2. All the countries in a continent organised by largest population to smallest.
    3. All the countries in a region organised by largest population to smallest.
    4. The top N populated countries in the world where N is provided by the user.
    5. The top N populated countries in a continent where N is provided by the user.
    6. The top N populated countries in a region where N is provided by the user.

## SCHEDULE

**DUE DATE**: 24-February-2023