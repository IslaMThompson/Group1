# USE CASE: 4 Produce a report with the information of capital cities (Name, country, population)

## CHARACTERISTIC INFORMATION

### Goal in Context

As a population reporter I want to be able to produce a generate a report on a capital cities in different areas with all it's information, so I can review information on different cities organised from the largest population to smallest

### Scope

Company.

### Level

Primary task.

### Preconditions

Database contains information on capital cities

### Success End Condition

A report is made for the population reporter to give to the organisation.

### Failed End Condition

No report is produced.

### Primary Actor

population reporter

### Trigger

The organisation requires a report with information on capital cities in a given area

## MAIN SUCCESS SCENARIO

1. The organisation requests a report with capital cities information in an area
2. The population reporter captures the area
3. The population reporter generates the report
4. The population reporter gives the report to the organisation

## EXTENSIONS

Extends from use-case 1

**Area does not exist**:
1. population reporter informs the organisation no area exists.

## SUB-VARIATIONS

An option to generate a report for capital cities in areas (World, continent or region) organised from the largest population to smallest
An option to generate only a certain number of the most populated cities in an area (World, continent or region)

## SCHEDULE

**DUE DATE**: 26/11/26