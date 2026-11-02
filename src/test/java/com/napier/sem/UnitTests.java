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

    /**
     * Testing printCapCities
     */
    @Test
    void printCapCitiesTestNull()
    {
        app.printCapCities(null);
    }

    @Test
    void printCapCitiesTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCapCities(cities);
    }

    @Test
    void printCapCitiesTestContainsNull()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.printCapCities(cities);
    }

    @Test
    void printCapCities()
    {
        ArrayList<City> cities = new ArrayList<City>();
        City cit = new City();
        cit.name = "Place";
        cit.country_name = "BiggerPlace";
        cit.population = 62000;
        cities.add(cit);
        app.printCapCities(cities);
    }

    /**
     * Testing get Countries reports
     */
    @Test
    void getCountriesByAreaTestNull()
    {
        app.getAllCountries();
        app.getCountriesByContinent(null);
        app.getCountriesByRegion(null);
    }

    @Test
    void getNCountriesByAreaTestNull()
    {
        app.getTopCountries(null);
        app.getTopCountriesByContinent(null, null);
        app.getTopCountriesByRegion(null, null);
        // To force it to check null numbers
        app.getTopCountriesByContinent("Africa", null);
        app.getTopCountriesByRegion("Caribbean", null);
    }

    /**
     * Testing get Cities reports
     */
    @Test
    void getCitiesByAreaTestNull()
    {
        app.getAllCities();
        app.getCitiesByContinent(null);
        app.getCitiesByRegion(null);
        app.getCitiesByCountry(null);
        app.getCitiesByDistrict(null);
    }

    @Test
    void getNCitiesByAreaTestNull()
    {
        app.getTopCities(null);
        app.getTopCitiesByContinent(null, null);
        app.getTopCitiesByRegion(null, null);
        app.getTopCitiesByCountry(null, null);
        app.getTopCitiesByDistrict(null, null);
        // To force it to check null numbers
        app.getTopCitiesByContinent("Africa", null);
        app.getTopCitiesByRegion("Caribbean", null);
        app.getTopCitiesByCountry("Afghanistan", null);
        app.getTopCitiesByDistrict("California", null);
    }

    /**
     * Testing get Capital Cities reports
     */
    @Test
    void getCapCitiesByAreaTestNull()
    {
        app.getAllCapitalCities();
        app.getCapCitiesByContinent(null);
        app.getCapCitiesByRegion(null);
    }

    @Test
    void getNCapCitiesByAreaTestNull()
    {
        app.getTopCities(null);
        app.getTopCitiesByContinent(null, null);
        app.getTopCitiesByRegion(null, null);
        // To force it to check null numbers
        app.getTopCitiesByContinent("Africa", null);
        app.getTopCitiesByRegion("Caribbean", null);
    }
}
