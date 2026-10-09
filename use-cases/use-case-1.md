# USE CASE: 1 Produce a report with the information of a city (name, country, district, population)

## CHARACTERISTIC INFORMATION

### Goal in Context

As a population reporter I want to be able to produce a generate a report on a cities in different areas with all it's information, so I can review information on different cities organised from the largest population to smallest

### Scope

Company.

### Level

Primary task.

### Preconditions

Database contains information on cities

### Success End Condition

A report is made for the population reporter to give to the organisation.

### Failed End Condition

No report is produced.

### Primary Actor

population reporter

### Trigger

The organisation requires a report with a cities information in a given area

## MAIN SUCCESS SCENARIO

1. The organisation requests a report with cities information in an area
2. The population reporter captures the area
3. The population reporter generates the report
4. The population reporter gives the report to the organisation

## EXTENSIONS

**Area does not exist**:
1. population reporter informs the organisation no area exists.

## SUB-VARIATIONS

An option to generate a report for cities in areas (World, continent, region, country or district) organised from the largest population to smallest
An option to generate only a certain number of the most populated cities in an area (World, continent, region , country or district)


## SCHEDULE

**DUE DATE**: 26/11/26