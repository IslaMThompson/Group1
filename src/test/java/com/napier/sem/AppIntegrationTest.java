package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);
    }

    //countries

    @Test
    void testGetTopCountries()
    {
        ArrayList<Country> countries = app.getTopCountries(3);
        assertNotNull(countries);
        assertEquals(countries.size(), 3);
        assertEquals(countries.get(0).name, "China");
        assertEquals(countries.get(1).name, "India");
        assertEquals(countries.get(2).name, "United States");
    }

    @Test
    void testGetAllCountries()
    {
        ArrayList<Country> countries = app.getAllCountries();
        assertNotNull(countries);
        //All 239 countries, including the 7 that have no capital (changed from 232 that missed the ones that didnt have capitals due to the wrong join)
        assertEquals(countries.size(), 239);
        //sorted from largest to smallest, some countries have a population of 0 so they will be tied there at the end
        assertEquals(countries.get(0).name, "China");
        assertEquals(countries.get(0).capital, "Peking");
        Country last = countries.get(countries.size() - 1);
        assertEquals(last.population, 0);
        assertNull(last.capital);
    }

    //added to further test countries with no capital
    @Test
    void testGetCountriesByContinentNoCapital()
    {
        ArrayList<Country> countries = app.getCountriesByContinent("Antarctica");
        assertNotNull(countries);
        assertEquals(countries.size(), 5);
        assertNull(countries.get(0).capital);
    }

    @Test
    void testGetCountriesByContinent()
    {
        ArrayList<Country> countries = app.getCountriesByContinent("Europe");
        assertNotNull(countries);
        assertEquals(countries.size(), 46);
        assertEquals(countries.get(0).name, "Russian Federation");
        assertEquals(countries.get(0).capital, "Moscow");
        Country last = countries.get(countries.size() - 1);
        assertEquals(last.name, "Holy See (Vatican City State)");
        assertEquals(last.population, 1000);
    }

    @Test
    void testGetCountriesByContinentUnknown()
    {
        ArrayList<Country> countries = app.getCountriesByContinent("Not A Continent");
        assertNotNull(countries);
        assertTrue(countries.isEmpty());
    }

    @Test
    void testGetCountriesByRegion()
    {
        ArrayList<Country> countries = app.getCountriesByRegion("Caribbean");
        assertNotNull(countries);
        assertEquals(countries.size(), 24);
        assertEquals(countries.get(0).name, "Cuba");
        assertEquals(countries.get(0).capital, "La Habana");
    }

    @Test
    void testGetTopCountriesByContinent()
    {
        ArrayList<Country> countries = app.getTopCountriesByContinent("Asia", 4);
        assertNotNull(countries);
        assertEquals(countries.size(), 4);
        assertEquals(countries.get(0).name, "China");
        assertEquals(countries.get(1).name, "India");
        assertEquals(countries.get(2).name, "Indonesia");
        assertEquals(countries.get(3).name, "Pakistan");
    }

    @Test
    void testGetTopCountriesByRegion()
    {
        ArrayList<Country> countries = app.getTopCountriesByRegion("Polynesia", 4);
        assertNotNull(countries);
        assertEquals(countries.size(), 4);
        assertEquals(countries.get(0).name, "French Polynesia");
        assertEquals(countries.get(3).name, "American Samoa");
    }

    @Test
    void testGetTopCountriesNegative()
    {
        assertNull(app.getTopCountries(-1));
    }

    //cities

    @Test
    void testGetAllCities()
    {
        ArrayList<City> cities = app.getAllCities();
        assertNotNull(cities);
        assertEquals(cities.size(), 4079);
        assertEquals(cities.get(0).name, "Mumbai (Bombay)");
        assertEquals(cities.get(0).country_name, "India");
        assertEquals(cities.get(0).district, "Maharashtra");
        assertEquals(cities.get(0).population, 10500000);
        City last = cities.get(cities.size() - 1);
        assertEquals(last.name, "Adamstown");
        assertEquals(last.population, 42);
    }

    @Test
    void testGetCitiesByContinent()
    {
        ArrayList<City> cities = app.getCitiesByContinent("Africa");
        assertNotNull(cities);
        assertEquals(cities.size(), 366);
        assertEquals(cities.get(0).name, "Cairo");
        assertEquals(cities.get(0).country_name, "Egypt");
    }

    @Test
    void testGetCitiesByRegion()
    {
        ArrayList<City> cities = app.getCitiesByRegion("Middle East");
        assertNotNull(cities);
        assertEquals(cities.size(), 174);
        assertEquals(cities.get(0).name, "Istanbul");
        assertEquals(cities.get(0).country_name, "Turkey");
    }

    @Test
    void testGetCitiesByCountry()
    {
        ArrayList<City> cities = app.getCitiesByCountry("Belarus");
        assertNotNull(cities);
        assertEquals(cities.size(), 16);
        assertEquals(cities.get(0).name, "Minsk");
        assertEquals(cities.get(0).district, "Horad Minsk");
    }

    @Test
    void testGetCitiesByDistrict()
    {
        ArrayList<City> cities = app.getCitiesByDistrict("Zuid-Holland");
        assertNotNull(cities);
        assertEquals(cities.size(), 6);
        assertEquals(cities.get(0).name, "Rotterdam");
        assertEquals(cities.get(0).population, 593321);
        assertEquals(cities.get(5).name, "Delft");
    }

    @Test
    void testGetCitiesByDistrictUnknown()
    {
        ArrayList<City> cities = app.getCitiesByDistrict("Not A District");
        assertNotNull(cities);
        assertTrue(cities.isEmpty());
    }

    @Test
    void testGetTopCities()
    {
        ArrayList<City> cities = app.getTopCities(5);
        assertNotNull(cities);
        assertEquals(cities.size(), 5);
        assertEquals(cities.get(0).name, "Mumbai (Bombay)");
        assertEquals(cities.get(1).name, "Seoul");
        assertEquals(cities.get(4).name, "Jakarta");
    }

    @Test
    void testGetTopCitiesByContinent()
    {
        ArrayList<City> cities = app.getTopCitiesByContinent("South America", 4);
        assertNotNull(cities);
        assertEquals(cities.size(), 4);
        assertEquals(cities.get(0).country_name, "Brazil");
        assertEquals(cities.get(1).name, "Lima");
        assertEquals(cities.get(3).name, "Rio de Janeiro");
    }

    @Test
    void testGetTopCitiesByRegion()
    {
        ArrayList<City> cities = app.getTopCitiesByRegion("Southern and Central Asia", 6);
        assertNotNull(cities);
        assertEquals(cities.size(), 6);
        assertEquals(cities.get(0).name, "Mumbai (Bombay)");
        assertEquals(cities.get(1).name, "Karachi");
        assertEquals(cities.get(2).name, "Delhi");
    }

    @Test
    void testGetTopCitiesByCountry()
    {
        ArrayList<City> cities = app.getTopCitiesByCountry("United Kingdom", 20);
        assertNotNull(cities);
        assertEquals(cities.size(), 20);
        assertEquals(cities.get(0).name, "London");
        assertEquals(cities.get(0).population, 7285000);
        assertEquals(cities.get(1).name, "Birmingham");
    }

    @Test
    void testGetTopCitiesByDistrict()
    {
        ArrayList<City> cities = app.getTopCitiesByDistrict("Buenos Aires", 6);
        assertNotNull(cities);
        assertEquals(cities.size(), 6);
        assertEquals(cities.get(0).name, "La Matanza");
        assertEquals(cities.get(5).name, "Mar del Plata");
    }

    //capital cities

    @Test
    void testGetAllCapitalCities()
    {
        ArrayList<City> cities = app.getAllCapitalCities();
        assertNotNull(cities);
        assertEquals(cities.size(), 232);
        assertEquals(cities.get(0).name, "Seoul");
        assertEquals(cities.get(0).country_name, "South Korea");
        assertEquals(cities.get(0).population, 9981619);
        City last = cities.get(cities.size() - 1);
        assertEquals(last.name, "Adamstown");
        assertEquals(last.country_name, "Pitcairn");
    }

    @Test
    void testGetCapCitiesByContinent()
    {
        ArrayList<City> cities = app.getCapCitiesByContinent("Africa");
        assertNotNull(cities);
        assertEquals(cities.size(), 57);
        assertEquals(cities.get(0).name, "Cairo");
        assertEquals(cities.get(0).country_name, "Egypt");
    }

    @Test
    void testGetCapCitiesByRegion()
    {
        ArrayList<City> cities = app.getCapCitiesByRegion("British Islands");
        assertNotNull(cities);
        assertEquals(cities.size(), 2);
        assertEquals(cities.get(0).name, "London");
        assertEquals(cities.get(1).name, "Dublin");
    }

    @Test
    void testGetTopCapCities()
    {
        ArrayList<City> cities = app.getTopCapCities(3);
        assertNotNull(cities);
        assertEquals(cities.size(), 3);
        assertEquals(cities.get(0).name, "Seoul");
        assertEquals(cities.get(1).name, "Jakarta");
        assertEquals(cities.get(2).country_name, "Mexico");
    }

    @Test
    void testGetTopCapCitiesByContinent()
    {
        ArrayList<City> cities = app.getTopCapCitiesByContinent("Europe", 7);
        assertNotNull(cities);
        assertEquals(cities.size(), 7);
        assertEquals(cities.get(0).name, "Moscow");
        assertEquals(cities.get(1).name, "London");
        assertEquals(cities.get(6).name, "Paris");
    }

    @Test
    void testGetTopCapCitiesByRegion()
    {
        ArrayList<City> cities = app.getTopCapCitiesByRegion("Western Europe", 8);
        assertNotNull(cities);
        assertEquals(cities.size(), 8);
        assertEquals(cities.get(0).name, "Berlin");
        assertEquals(cities.get(7).name, "Vaduz");
    }


    //connection tests


    @Test
    void testNotConnected()
    {
        //tests a new App that never calls connect, every method should fail (but within the test paramaters)
        App notConnected = new App();
        assertNull(notConnected.getAllCountries());
        assertNull(notConnected.getCountriesByContinent("Europe"));
        assertNull(notConnected.getCountriesByRegion("Caribbean"));
        assertNull(notConnected.getTopCountries(3));
        assertNull(notConnected.getTopCountriesByContinent("Asia", 4));
        assertNull(notConnected.getTopCountriesByRegion("Polynesia", 4));
        assertNull(notConnected.getAllCities());
        assertNull(notConnected.getCitiesByContinent("Africa"));
        assertNull(notConnected.getCitiesByRegion("Middle East"));
        assertNull(notConnected.getCitiesByCountry("Belarus"));
        assertNull(notConnected.getCitiesByDistrict("Zuid-Holland"));
        assertNull(notConnected.getTopCities(5));
        assertNull(notConnected.getTopCitiesByContinent("South America", 4));
        assertNull(notConnected.getTopCitiesByRegion("Southern and Central Asia", 6));
        assertNull(notConnected.getTopCitiesByCountry("United Kingdom", 20));
        assertNull(notConnected.getTopCitiesByDistrict("Buenos Aires", 6));
        assertNull(notConnected.getAllCapitalCities());
        assertNull(notConnected.getCapCitiesByContinent("Africa"));
        assertNull(notConnected.getCapCitiesByRegion("British Islands"));
        assertNull(notConnected.getTopCapCities(3));
        assertNull(notConnected.getTopCapCitiesByContinent("Europe", 7));
        assertNull(notConnected.getTopCapCitiesByRegion("Western Europe", 8));
        notConnected.disconnect(); //nothing to close, since its never ran, but checking to see if anything explodes
    }

    @Test
    void testConnectAndDisconnect()
    {
        //makes a new app to test connect and disconect work well, uses a delay of 0, since the actual app has already waited its 30sec delay to get here
        App other = new App();
        other.connect("localhost:33060", 0);
        assertNotNull(other.getAllCountries());
        other.disconnect();
        //a closed connection can't run queries, so this returns null
        assertNull(other.getAllCountries());
    }

    @Test
    void testConnectFailure()
    {
        //no reciving end on port1, so all 10 attempts should fall flat
        App bad = new App();
        bad.connect("localhost:1", 0);
        assertNull(bad.getAllCountries());
    }


}