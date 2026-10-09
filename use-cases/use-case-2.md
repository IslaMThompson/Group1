# USE CASE: 2 Produce a report with the information of countries (code, name, continent, region, population, capital)

## CHARACTERISTIC INFORMATION

### Goal in Context

As a population reporter I want to be able to produce a generate a report on countries in different areas with all it's information, so I can review information on different countries organised from the largest population to smallest

### Scope

Company.

### Level

Primary task.

### Preconditions

Database contains information on countries

### Success End Condition

A report is made for the population reporter to give to the organisation.

### Failed End Condition

No report is produced.

### Primary Actor

population reporter

### Trigger

The organisation requires a report with countries information in an area

## MAIN SUCCESS SCENARIO

1. The organisation requests a report with countries information in an area
2. The population reporter captures the area
3. The population reporter generates the report
4. The population reporter gives the report to the organisation

## EXTENSIONS

**Area does not exist**:
1. population reporter informs the organisation no area exists.

## SUB-VARIATIONS

An option to generate a report for countries in areas (World, continent, region) organised from the largest population to smallest
An option to generate only a certain number of the most populated countries in an area (World, continent, region)

## SCHEDULE

**DUE DATE**: 26/11/26