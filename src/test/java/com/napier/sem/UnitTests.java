package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class UnitTests
{
    static App app;

    /**
     * Initialising app for the tests
     */
    @BeforeAll
    static void init()
    {
        app = new App();
    }

    /**
     * Testing printCountries
     */
    @Test
    void printCountriesTestNull()
    {
        app.printCountries(null);
    }

    @Test
    void printCountriesTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountries(countries);
    }

    @Test
    void printCountriesTestContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.printCountries(countries);
    }

    @Test
    void printCountries()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country coun = new Country();
        coun.code = "ABW";
        coun.name = "Place";
        coun.continent = "BiggerPlace";
        coun.region = "BigBigPlace";
        coun.population = 200000;
        coun.capital = "ABW";
        countries.add(coun);
        app.printCountries(countries);
    }

    /**
     * Testing printCities
     */
    @Test
    void printCitiesTestNull()
    {
        app.printCities(null);
    }

    @Test
    void printCitiesTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCities(cities);
    }

    @Test
    void printCitiesTestContainsNull()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.printCities(cities);
    }

    @Test
    void printCities()
    {
        ArrayList<City> cities = new ArrayList<City>();
        City cit = new City();
        cit.name = "Place";
        cit.country_name = "BiggerPlace";
        cit.district = "SlightlyBiggerPlace";
        cit.population = 30000;
        cities.add(cit);
        app.printCities(cities);
    }
}
