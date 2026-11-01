package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

/**
 * Application to generate various reports from the world database
 */
public class App
{
    /**
     * Main method, to connect disconnect and run the various reports from.
     * @param args -
     */
    public static void main(String[] args)
    {
        App a = new App();
        a.connect();
        // Gets and prints all countries in the world
        //ArrayList<Country> allCountries = a.getAllCountries();
        //a.printCountries(allCountries);

        // Gets and prints all countries in a continent
        //String uContinent = "Europe";
        //ArrayList<Country> continentCountries = a.getCountriesByContinent(uContinent);
        //a.printCountries(continentCountries);

        // Gets and prints all countries in a region
        //String uRegion = "Caribbean";
        //ArrayList<Country> regionCountries = a.getCountriesByRegion(uRegion);
        //a.printCountries(regionCountries);

        // Gets and prints the top n countries in the world
        //int n1 = 3;
        //ArrayList<Country> allNCountries = a.getTopCountries(n1);
        //a.printCountries(allNCountries);

        // Gets and prints the top n countries in a continent
        //String uNContinent = "Asia";
        //int n2 = 4;
        //ArrayList<Country> continentNCountries = a.getTopCountriesByContinent(uNContinent, n2);
        //a.printCountries(continentNCountries);

        // Gets and prints the top n countries in a region
        //String uNRegion = "Polynesia";
        //int n3 = 4;
        //ArrayList<Country> regionNCountries = a.getTopCountriesByRegion(uNRegion, n3);
        //a.printCountries(regionNCountries);

        // Gets and prints all cities
        //ArrayList<City> allCities = a.getAllCities();
        //a.printCities(allCities);

        // Gets and prints all cities in a continent
        //String uCContinent = "Africa";
        //ArrayList<City> continentCities = a.getCitiesByContinent(uCContinent);
        //a.printCities(continentCities);

        // Gets and prints all cities in a region
        //String uCRegion = "Middle East";
        //ArrayList<City> regionCities = a.getCitiesByRegion(uCRegion);
        //a.printCities(regionCities);

        // Gets and prints all cities in a country
        //String uCCountry = "Belarus";
        //ArrayList<City> countryCities = a.getCitiesByCountry(uCCountry);
        //a.printCities(countryCities);

        // Gets and prints all cities in a district
        //String uCDistrict = "Zuid-Holland";
        //ArrayList<City> districtCities = a.getCitiesByDistrict(uCDistrict);
        //a.printCities(districtCities);

        // Gets and prints top cities in the world
        int n4 = 5;
        ArrayList<City> topCities = a.getTopCities(n4);
        a.printCities(topCities);

        a.disconnect();
    }

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        // Connection to the database
        int retries = 100;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(1000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false&allowPublicKeyRetrieval=true", "root", "example");
                System.out.println("Successfully connected");
                // Wait a bit
                Thread.sleep(1000);
                // Exit for loop
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Retrieves details for all countries in the world and stores them in an ArrayList.
     * @return countries
     */
    public ArrayList<Country> getAllCountries() {
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name AS Capital " +
                    "FROM country " +
                    "JOIN city ON city.ID = country.Capital " +
                    "ORDER BY country.Population DESC;";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("Code");
                country.name = rset.getString("Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getInt("Population");
                country.capital = rset.getString("Capital");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details.");
            return null;
        }
    }

    /**
     * Retrieves details for all countries in specified continent and stores them in an ArrayList.
     * @param continent - String for continent to filter by
     * @return countries
     */
    public ArrayList<Country> getCountriesByContinent(String continent) {
        if(continent == null)
        {
            System.out.println("Continent is null");
            return null;
        }

        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name AS Capital " +
                    "FROM country " +
                    "JOIN city ON city.ID = country.Capital " +
                    "WHERE country.Continent = '" + continent + "' " +
                    "ORDER BY country.Population DESC;";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("Code");
                country.name = rset.getString("Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getInt("Population");
                country.capital = rset.getString("Capital");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details.");
            return null;
        }
    }

    /**
     * Retrieves details for all countries for specified region and stores them in an ArrayList.
     * @param region - String for region to filter by
     * @return countries
     */
    public ArrayList<Country> getCountriesByRegion(String region) {
        if(region == null)
        {
            System.out.println("Region is null");
            return null;
        }
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name AS Capital " +
                    "FROM country " +
                    "JOIN city ON city.ID = country.Capital " +
                    "WHERE country.Region = '" + region + "' " +
                    "ORDER BY country.Population DESC;";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("Code");
                country.name = rset.getString("Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getInt("Population");
                country.capital = rset.getString("Capital");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details.");
            return null;
        }
    }

    /**
     * Returns ArrayList of top 'n' countries in the world
     * @param n the number of countries to print
     * @return countries
     */
    public ArrayList<Country> getTopCountries(int n) {
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name AS Capital " +
                    "FROM country " +
                    "JOIN city ON city.ID = country.Capital " +
                    "ORDER BY country.Population DESC " +
                    "LIMIT " + n;

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("Code");
                country.name = rset.getString("Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getInt("Population");
                country.capital = rset.getString("Capital");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details.");
            return null;
        }
    }

    /**
     * Returns ArrayList of top 'n' countries in specified continent
     * @param n - Number of countries to get
     * @param continent - String for continent to filter by
     * @return countries
     */
    public ArrayList<Country> getTopCountriesByContinent(String continent, int n) {
        if(continent == null)
        {
            System.out.println("Continent is null");
            return null;
        }

        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name AS Capital " +
                    "FROM country " +
                    "JOIN city ON city.ID = country.Capital " +
                    "WHERE country.Continent = '" + continent + "' " +
                    "ORDER BY country.Population DESC " +
                    "LIMIT " + n;

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("Code");
                country.name = rset.getString("Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getInt("Population");
                country.capital = rset.getString("Capital");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details.");
            return null;
        }
    }

    /**
     * Returns ArrayList of top 'n' countries in specified region
     * @param n - Number of countries to get
     * @param region - String for region to filter by
     * @return countries
     */
    public ArrayList<Country> getTopCountriesByRegion(String region, int n) {
        if(region == null)
        {
            System.out.println("Region is null");
            return null;
        }

        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name AS Capital " +
                    "FROM country " +
                    "JOIN city ON city.ID = country.Capital " +
                    "WHERE country.Region = '" + region + "' " +
                    "ORDER BY country.Population DESC " +
                    "LIMIT " + n;

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("Code");
                country.name = rset.getString("Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getInt("Population");
                country.capital = rset.getString("Capital");
                countries.add(country);
            }
            return countries;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details.");
            return null;
        }
    }

    /**
     * Prints a list of countries.
     * @param countries The list of countries to print.
     */
    public void printCountries(ArrayList<Country> countries) {
        // Check countries is not null.
        if (countries == null) {
            System.out.println("No countries in list.");
            return;
        }
        else if(countries.isEmpty())
        {
            System.out.println("No countries in list.");
            return;
        }

        // Print header.
        System.out.println(String.format("%-8s %-40s %-15s %-30s %-15s %-10s", "Code", "Name", "Continent", "Region", "Population", "Capital"));

        // Loop over all countries in the list.
        for (Country country : countries) {
            if (country == null)
                continue;

            String country_string = String.format("%-8s %-40s %-15s %-30s %-15s %-10s",
                    country.code, country.name, country.continent, country.region, country.population, country.capital);
            System.out.println(country_string);
        }
    }

    /**
     * Retrieves details for all cities in the world and stores them in an ArrayList.
     * @return cities
     */
    public ArrayList<City> getAllCities() {
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT city.Name, country.Name AS Country_name, city.District, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.code " +
                    "ORDER BY city.Population DESC;";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("Name");
                city.country_name = rset.getString("Country_Name");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details.");
            return null;
        }
    }

    /**
     * Retrieves details for all cities in a continent and stores them in an ArrayList.
     * @param continent - the continent to filter by
     * @return cities
     */
    public ArrayList<City> getCitiesByContinent(String continent) {
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT city.Name, country.Name AS Country_name, city.District, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.code " +
                    "WHERE country.Continent = '" + continent + "' " +
                    "ORDER BY city.Population DESC;";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("Name");
                city.country_name = rset.getString("Country_Name");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details.");
            return null;
        }
    }

    /**
     * Retrieves details for all cities in a region and stores them in an ArrayList.
     * @param region - the continent to filter by
     * @return cities
     */
    public ArrayList<City> getCitiesByRegion(String region) {
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT city.Name, country.Name AS Country_name, city.District, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.code " +
                    "WHERE country.Region = '" + region + "' " +
                    "ORDER BY city.Population DESC;";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("Name");
                city.country_name = rset.getString("Country_Name");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details.");
            return null;
        }
    }

    /**
     * Retrieves details for all cities in a country and stores them in an ArrayList.
     * @param country - the continent to filter by
     * @return cities
     */
    public ArrayList<City> getCitiesByCountry(String country) {
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT city.Name, country.Name AS Country_name, city.District, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.code " +
                    "WHERE country.Name = '" + country + "' " +
                    "ORDER BY city.Population DESC;";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("Name");
                city.country_name = rset.getString("Country_Name");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details.");
            return null;
        }
    }

    /**
     * Retrieves details for all cities in a continent and stores them in an ArrayList.
     * @param district - the continent to filter by
     * @return cities
     */
    public ArrayList<City> getCitiesByDistrict(String district) {
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT city.Name, country.Name AS Country_name, city.District, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.code " +
                    "WHERE city.District = '" + district + "' " +
                    "ORDER BY city.Population DESC;";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("Name");
                city.country_name = rset.getString("Country_Name");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details.");
            return null;
        }
    }

    /**
     * Retrieves details for the top cities in the world and stores them in an ArrayList.
     * @param limit - The number to get
     * @return cities
     */
    public ArrayList<City> getTopCities(int limit) {
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT city.Name, country.Name AS Country_name, city.District, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.code " +
                    "ORDER BY city.Population DESC " +
                    "LIMIT " + limit + ";";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("Name");
                city.country_name = rset.getString("Country_Name");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                cities.add(city);
            }
            return cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details.");
            return null;
        }
    }

    /**
     * Prints a list of cities.
     * @param cities The list of cities to print.
     */
    public void printCities(ArrayList<City> cities) {
        // Check countries is not null.
        if (cities == null) {
            System.out.println("No cities in list.");
            return;
        }
        else if(cities.isEmpty())
        {
            System.out.println("No cities in list.");
            return;
        }

        // Print header.
        System.out.println(String.format("%-40s %-40s %-20s %-20s", "Name", "Country", "District", "Population"));

        // Loop over all countries in the list.
        for (City city : cities) {
            if (city == null)
                continue;

            String country_string = String.format("%-40s %-40s %-20s %-20s",
                    city.name, city.country_name, city.district, city.population);
            System.out.println(country_string);
        }
    }
}
