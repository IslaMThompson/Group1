# USE CASE: 6 Produce a report with the information of a population in an area (area name, total population, total and % in cities, total and % outside cities)
## CHARACTERISTIC INFORMATION

### Goal in Context

As a population reporter I want to be able to produce and generate a report on the population of people living in cities and living outside cities in different areas to compare them

### Scope

Company.

### Level

Primary task.

### Preconditions

Database contains information on populations inside cities

### Success End Condition

A report is made for the population reporter to give to the organisation.

### Failed End Condition

No report is produced.

### Primary Actor

population reporter

### Trigger

The organisation requires a report with information on population

## MAIN SUCCESS SCENARIO

1. The organisation requests a report with populations information inside/outside cities of an area
2. The population reporter captures the area
3. The population reporter generates the report
4. The population reporter gives the report to the organisation

## EXTENSIONS

extends from use-case 5

**area does not exist**:
1. population reporter informs the organisation no area language exists.****

## SUB-VARIATIONS

An option to generate a report for areas continent, region or country

## SCHEDULE

**DUE DATE**: 26/11/26