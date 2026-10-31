package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

/**
 * Application to generate various reports from the world database
 */
public class App
{
    /**
     * Main method, Just being used to call the connect and disconnect at the moment
     * @param args
     */
    public static void main(String[] args)
    {
        App a = new App();
        a.connect();
        //ArrayList<Country> allCountries = a.getAllCountries();
        //a.printCountries(allCountries);

        String uContinent = "Europe";
        ArrayList<Country> continentCountries = a.getCountriesByContinent(uContinent);
        a.printCountries(continentCountries);

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

            String strSelect = "SELECT Code, Name, Continent, Region, Population, Capital " +
                    "FROM country " +
                    "ORDER BY Population DESC;";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("Code");
                country.name = rset.getString("Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getInt("Population");
                country.capital = rset.getInt("Capital");
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

            String strSelect = "SELECT Code, Name, Continent, Region, Population, Capital " +
                    "FROM country " +
                    "WHERE Continent = '" + continent + "' " +
                    "ORDER BY Population DESC;";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country();
                country.code = rset.getString("Code");
                country.name = rset.getString("Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getInt("Population");
                country.capital = rset.getInt("Capital");
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
     *
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
        System.out.println(String.format("%-8s %-45s %-15s %-30s %-15s %-10s", "Code", "Name", "Continent", "Region", "Population", "Capital"));

        // Loop over all countries in the list.
        for (Country country : countries) {
            if (country == null)
                continue;

            String country_string = String.format("%-8s %-45s %-15s %-30s %-15s %-10s",
                    country.code, country.name, country.continent, country.region, country.population, country.capital);
            System.out.println(country_string);
        }
    }
}
