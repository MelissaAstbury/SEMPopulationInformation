# USE CASE: Produce all population reports.

## CHARACTERISTIC INFORMATION

### Goal in Context

*"As a **report user, I want to obtain the capital city reports**, so that **I can report this information to the organization"***

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

None

## SCHEDULE

**DUE DATE**: 24-February-2023