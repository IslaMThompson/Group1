package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
     * Testing Country class getters
     */
    @Test
    void countriesClassGetters()
    {
        Country coun = new Country("ABW", "Place", "BiggerPlace", "BigBigPlace", 200000, "ABW");
        assertEquals(coun.getCode(), "ABW");
        assertEquals(coun.getName(), "Place");
        assertEquals(coun.getContinent(), "BiggerPlace");
        assertEquals(coun.getRegion(), "BigBigPlace");
        assertEquals(coun.getPopulation(), 200000);
        assertEquals(coun.getCapital(), "ABW");
    }
    /**
     * Testing Country class getters
     */
    @Test
    void countriesClassSetters()
    {
        Country coun = new Country("ABW", "Place", "BiggerPlace", "BigBigPlace", 200000, "ABW");

        coun.setCode("ERT");
        coun.setName("aaaa");
        coun.setContinent("cccc");
        coun.setRegion("rrrr");
        coun.setPopulation(10);
        coun.setCapital("WWW");

        assertEquals(coun.getCode(), "ERT");
        assertEquals(coun.getName(), "aaaa");
        assertEquals(coun.getContinent(), "cccc");
        assertEquals(coun.getRegion(), "rrrr");
        assertEquals(coun.getPopulation(), 10);
        assertEquals(coun.getCapital(), "WWW");
    }
    /**
     * Testing Country class toString
     */
    @Test
    void countriesClassToString()
    {
        Country coun = new Country("ABW", "Place", "BiggerPlace", "BigBigPlace", 200000, "ABW");
        String country = coun.toString();
        System.out.println(country);
    }

    /**
     * Testing City class getters
     */
    @Test
    void citiesClassGetters()
    {
        City cit = new City("Place", "BiggerPlace", "SlightlyBiggerPlace", 30000);
        assertEquals(cit.getName(), "Place");
        assertEquals(cit.getCountry_name(), "BiggerPlace");
        assertEquals(cit.getDistrict(), "SlightlyBiggerPlace");
        assertEquals(cit.getPopulation(), 30000);
    }
    /**
     * Testing City class getters
     */
    @Test
    void citiesClassSetters()
    {
        City cit = new City("Place", "BiggerPlace", "SlightlyBiggerPlace", 30000);

        cit.setName("tttt");
        cit.setCountry_name("qqqq");
        cit.setDistrict("oooo");
        cit.setPopulation(9000);

        assertEquals(cit.getName(), "tttt");
        assertEquals(cit.getCountry_name(), "qqqq");
        assertEquals(cit.getDistrict(), "oooo");
        assertEquals(cit.getPopulation(), 9000);
    }
    /**
     * Testing City class getters
     */
    @Test
    void citiesClassToString()
    {
        City cit = new City("Place", "BiggerPlace", "SlightlyBiggerPlace", 30000);
        String city = cit.toString();
        System.out.println(city);
    }

    /**
     * Testing Population class getters
     */
    @Test
    void populationClassGetters()
    {
        Population pop = new Population("World", 1234, 34, 34.5F, 1200, 12.6F);
        assertEquals(pop.getArea_name(), "World");
        assertEquals(pop.getPopulation(), 1234);
        assertEquals(pop.getPop_In_Cities(), 34);
        assertEquals(pop.getPop_In_Cities_Per(), 34.5);
        assertEquals(pop.getPop_Outside_Cities(), 1200);
        assertEquals(pop.getPop_Outside_Cities_Per(), 12.6);
    }
    /**
     * Testing Population class getters
     */
    @Test
    void populationClassSetters()
    {
        Population pop = new Population("World", 1234, 34, 34.5F, 1200, 12.6F);

        pop.setArea_name("newName");
        pop.setPopulation(4567);
        pop.setPop_In_Cities(567);
        pop.setPop_In_Cities_Per(9.5F);
        pop.setPop_Outside_Cities(4000);
        pop.setPop_Outside_Cities_Per(90.5F);

        assertEquals(pop.getArea_name(), "newName");
        assertEquals(pop.getPopulation(), 4567);
        assertEquals(pop.getPop_In_Cities(), 567);
        assertEquals(pop.getPop_In_Cities_Per(), 9.5F);
        assertEquals(pop.getPop_Outside_Cities(), 4000);
        assertEquals(pop.getPop_Outside_Cities_Per(), 90.5F);
    }
    /**
     * Testing Population class toString
     */
    @Test
    void populationClassToString()
    {
        Population pop = new Population("World", 1234, 34, 34.5F, 1200, 12.6F);
        String population = pop.toString();
        System.out.println(population);
    }
    /**
     * Testing printCountries with no input
     */
    @Test
    void printCountriesTestNull()
    {
        app.printCountries(null);
    }

    /**
     * Testing printCountries with empty input
     */
    @Test
    void printCountriesTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        app.printCountries(countries);
    }

    /**
     * Testing printCountries with input that is null
     */
    @Test
    void printCountriesTestContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.printCountries(countries);
    }

    /**
     * Testing printCountries with normal data
     */
    @Test
    void printCountries()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country coun = new Country("ABW", "Place", "BiggerPlace", "BigBigPlace", 200000, "ABW");
        countries.add(coun);
        app.printCountries(countries);
    }

    /**
     * Testing printCities with no input
     */
    @Test
    void printCitiesTestNull()
    {
        app.printCities(null);
    }

    /**
     * Testing printCities with empty input
     */
    @Test
    void printCitiesTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCities(cities);
    }

    /**
     * Testing printCities with input that is empty
     */
    @Test
    void printCitiesTestContainsNull()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.printCities(cities);
    }

    /**
     * Testing printCities with normal data
     */
    @Test
    void printCities()
    {
        ArrayList<City> cities = new ArrayList<City>();
        City cit = new City("Place", "BiggerPlace", "SlightlyBiggerPlace", 30000);
        cities.add(cit);
        app.printCities(cities);
    }

    /**
     * Testing printCapCities with no input
     */
    @Test
    void printCapCitiesTestNull()
    {
        app.printCapCities(null);
    }

    /**
     * Testing printCapCities with empty input
     */
    @Test
    void printCapCitiesTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<City>();
        app.printCapCities(cities);
    }

    /**
     * Testing printCapCities with input that is null
     */
    @Test
    void printCapCitiesTestContainsNull()
    {
        ArrayList<City> cities = new ArrayList<City>();
        cities.add(null);
        app.printCapCities(cities);
    }

    /**
     * Testing printCapCities with normal data
     */
    @Test
    void printCapCities()
    {
        ArrayList<City> cities = new ArrayList<City>();
        City cit = new City("Place", "BiggerPlace", 62000);
        cities.add(cit);
        app.printCapCities(cities);
    }

    /**
     * Testing get Countries reports with null inputs
     */
    @Test
    void getCountriesByAreaTestNull()
    {
        app.getAllCountries();
        app.getCountriesByContinent(null);
        app.getCountriesByRegion(null);
    }

    /**
     * Testing get N Countries reports with null inputs
     */
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
     * Testing get Cities reports with null inputs
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

    /**
     * Testing get N Cities Reports with null inputs
     */
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
     * Testing get Capital Cities reports with null inputs
     */
    @Test
    void getCapCitiesByAreaTestNull()
    {
        app.getAllCapitalCities();
        app.getCapCitiesByContinent(null);
        app.getCapCitiesByRegion(null);
    }

    /**
     * Testing get N Capital Cities reports with null inputs
     */
    @Test
    void getNCapCitiesByAreaTestNull()
    {
        app.getTopCapCities(null);
        app.getTopCapCitiesByContinent(null, null);
        app.getTopCapCitiesByRegion(null, null);
        // To force it to check null numbers
        app.getTopCapCitiesByContinent("Africa", null);
        app.getTopCapCitiesByRegion("Caribbean", null);
    }
}
