package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

        //no arguments = run locally (db on 33060), otherwise use the arg
        if (args.length < 1)
        {
            a.connect("localhost:33060", 30000);
        }
        else
        {
            a.connect(args[0], Integer.parseInt(args[1]));
        }


        // Gets and prints all countries in the world
        ArrayList<Country> allCountries = a.getAllCountries();
        a.printCountries(allCountries);
        a.outputCountries(allCountries, "AllCountries.md");


        // Gets and prints all countries in a continent
        String uContinent = "Europe";
        ArrayList<Country> continentCountries = a.getCountriesByContinent(uContinent);
        a.printCountries(continentCountries);
        a.outputCountries(continentCountries, "CountriesInContinent.md");


        // Gets and prints all countries in a region
        String uRegion = "Caribbean";
        ArrayList<Country> regionCountries = a.getCountriesByRegion(uRegion);
        a.printCountries(regionCountries);
        a.outputCountries(regionCountries, "CountriesInRegion.md");

        // Gets and prints the top n countries in the world
        int n1 = 3;
        ArrayList<Country> allNCountries = a.getTopCountries(n1);
        a.printCountries(allNCountries);
        a.outputCountries(allNCountries, "TopCountries.md");

        // Gets and prints the top n countries in a continent
        String uNContinent = "Asia";
        int n2 = 4;
        ArrayList<Country> continentNCountries = a.getTopCountriesByContinent(uNContinent, n2);
        a.printCountries(continentNCountries);
        a.outputCountries(continentNCountries, "TopCountriesInContinent.md");

        // Gets and prints the top n countries in a region
        String uNRegion = "Polynesia";
        int n3 = 4;
        ArrayList<Country> regionNCountries = a.getTopCountriesByRegion(uNRegion, n3);
        a.printCountries(regionNCountries);
        a.outputCountries(regionNCountries, "TopCountriesInRegion.md");


        // Gets and prints all cities
        ArrayList<City> allCities = a.getAllCities();
        a.printCities(allCities);
        a.outputCities(allCities, "AllCities.md");

        // Gets and prints all cities in a continent
        String uCContinent = "Africa";
        ArrayList<City> continentCities = a.getCitiesByContinent(uCContinent);
        a.printCities(continentCities);
        a.outputCities(continentCities, "CitiesInContinent.md");

        // Gets and prints all cities in a region
        String uCRegion = "Middle East";
        ArrayList<City> regionCities = a.getCitiesByRegion(uCRegion);
        a.printCities(regionCities);
        a.outputCities(regionCities, "CitiesInRegion.md");

        // Gets and prints all cities in a country
        String uCCountry = "Belarus";
        ArrayList<City> countryCities = a.getCitiesByCountry(uCCountry);
        a.printCities(countryCities);
        a.outputCities(countryCities, "CitiesInCountry.md");

        // Gets and prints all cities in a district
        String uCDistrict = "Zuid-Holland";
        ArrayList<City> districtCities = a.getCitiesByDistrict(uCDistrict);
        a.printCities(districtCities);
        a.outputCities(districtCities, "CitiesInDistrict.md");

        // Gets and prints top cities in the world
        int n4 = 5;
        ArrayList<City> topCities = a.getTopCities(n4);
        a.printCities(topCities);
        a.outputCities(topCities, "TopCities.md");

        // Gets and prints the top cities in a continent
        int n5 = 4;
        String uCityContinent = "South America";
        ArrayList<City> topContinentCities = a.getTopCitiesByContinent(uCityContinent, n5);
        a.printCities(topContinentCities);
        a.outputCities(topContinentCities, "TopCitiesInContinent.md");

        // Gets and prints the top cities in a region
        int n6 = 6;
        String uCityRegion = "Southern and Central Asia";
        ArrayList<City> topRegionCities = a.getTopCitiesByRegion(uCityRegion, n6);
        a.printCities(topRegionCities);
        a.outputCities(topRegionCities, "TopCitiesInRegion.md");

        // Gets and prints the top cities in a country
        int n7 = 20;
        String uCityCountry = "United Kingdom";
        ArrayList<City> topCountryCities = a.getTopCitiesByCountry(uCityCountry, n7);
        a.printCities(topCountryCities);
        a.outputCities(topCountryCities, "TopCitiesInCountry.md");

        // Gets and prints tha top cities in a district
        int n8 = 6;
        String uCityDistrict = "Buenos Aires";
        ArrayList<City> topDistrictCities = a.getTopCitiesByDistrict(uCityDistrict, n8);
        a.printCities(topDistrictCities);
        a.outputCities(topDistrictCities, "TopCitiesInDistrict.md");

        // Get all capital cities in the world
        ArrayList<City> allCapitalCities = a.getAllCapitalCities();
        a.printCapCities(allCapitalCities);
        a.outputCapCities(allCapitalCities, "AllCapitalCities.md");

        // Get all capital cities in a continent
        String uCapContinent = "Africa";
        ArrayList<City> allContinentCapitalCities = a.getCapCitiesByContinent(uCapContinent);
        a.printCapCities(allContinentCapitalCities);
        a.outputCapCities(allContinentCapitalCities, "CapitalCitiesInContinent.md");

        // Get all capital cities in a region
        String uCapRegion = "British Islands";
        ArrayList<City> allRegionCapitalCities = a.getCapCitiesByRegion(uCapRegion);
        a.printCapCities(allRegionCapitalCities);
        a.outputCapCities(allRegionCapitalCities, "CapitalCitiesInRegion.md");

        // Get the top n capital cities in the world
        int n9 = 10;
        ArrayList<City> topCapitalCities = a.getTopCapCities(n9);
        a.printCapCities(topCapitalCities);
        a.outputCapCities(topCapitalCities, "TopCapitalCities.md");

        // Get the top n capital cities in a continent
        int n10 = 7;
        String uNCapContinent = "Europe";
        ArrayList<City> topCapContinentCities = a.getTopCapCitiesByContinent(uNCapContinent, n10);
        a.printCapCities(topCapContinentCities);
        a.outputCapCities(topCapContinentCities, "TopCapitalCitiesInContinent.md");

        // Get the top n capital cities in a region
        int n11 = 8;
        String uNCapCityRegion = "Western Europe";
        ArrayList<City> topCapRegionCities = a.getTopCapCitiesByRegion(uNCapCityRegion, n11);
        a.printCapCities(topCapRegionCities);
        a.outputCapCities(topCapRegionCities, "TopCapitalCitiesInRegion.md");

        // Gets the total population of the World
        Population worldPopulation = a.getWorldPopulation();
        a.printPopulationReport(worldPopulation);
        a.outputPopulationReport(worldPopulation, "WorldPopulation.md");

        // Gets the total population of a continent
        Population continentPopulation = a.getContinentPopulation("Europe");
        a.printPopulationReport(continentPopulation);
        a.outputPopulationReport(continentPopulation, "ContinentPopulation.md");

        // Gets the total population of a region
        Population regionPopulation = a.getRegionPopulation("Central Africa");
        a.printPopulationReport(regionPopulation);
        a.outputPopulationReport(regionPopulation, "RegionPopulation.md");

        // Gets the total population of a country
        Population countryPopulation = a.getCountryPopulation("Faroe Islands");
        a.printPopulationReport(countryPopulation);
        a.outputPopulationReport(countryPopulation, "CountryPopulation.md");

        // Gets the total population of a district
        Population districtPopulation = a.getDistrictPopulation("Fukushima");
        a.printPopulationReport(districtPopulation);
        a.outputPopulationReport(districtPopulation, "DistrictPopulation.md");

        // Gets the total population of a city
        Population cityPopulation = a.getCityPopulation("Zaanstad");
        a.printPopulationReport(cityPopulation);
        a.outputPopulationReport(cityPopulation, "CityPopulation.md");

        // Gets the total population of speakers of certain languages
        ArrayList<Population> languages = a.getLanguagePopulation();
        a.printLanguagePopulations(languages);
        a.outputLanguagePopulations(languages, "LanguagePopulations.md");

        // Gets the total population of people living in cities and outside cities in each continent
        ArrayList<Population> pContinents = a.getContinentCitiesPopulation();
        a.printCitiesPopulations(pContinents);

        a.outputCitiesPopulations(pContinents, "ContinentPopulationInCities.md");

        // Gets the total population of people living in cities and outside cities in each region
        ArrayList<Population> pRegions = a.getRegionCitiesPopulation();
        a.printCitiesPopulations(pRegions);
        a.outputCitiesPopulations(pRegions, "RegionPopulationInCities.md");

        // Gets the total population of people living in cities and outside cities in each population
        ArrayList<Population> pCountries = a.getCountryCitiesPopulation();
        a.printCitiesPopulations(pCountries);
        a.outputCitiesPopulations(pCountries, "CountryPopulationInCities.md");

        a.disconnect();
    }

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect(String location, int delay)
    {
        try
        {
            //Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        // Connection to the database
        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?useSSL=false&allowPublicKeyRetrieval=true", "root", "example");
                System.out.println("Successfully connected");
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
                    "LEFT JOIN city ON city.ID = country.Capital " +
                    "ORDER BY country.Population DESC;";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country(rset.getString("Code"), rset.getString("Name"), rset.getString("Continent"), rset.getString("Region"), rset.getInt("Population"), rset.getString("Capital"));
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
                    "LEFT JOIN city ON city.ID = country.Capital " +
                    "WHERE country.Continent = '" + continent + "' " +
                    "ORDER BY country.Population DESC;";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country(rset.getString("Code"), rset.getString("Name"), rset.getString("Continent"), rset.getString("Region"), rset.getInt("Population"), rset.getString("Capital"));
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
                    "LEFT JOIN city ON city.ID = country.Capital " +
                    "WHERE country.Region = '" + region + "' " +
                    "ORDER BY country.Population DESC;";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country(rset.getString("Code"), rset.getString("Name"), rset.getString("Continent"), rset.getString("Region"), rset.getInt("Population"), rset.getString("Capital"));
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
    public ArrayList<Country> getTopCountries(Integer n) {
        if(n == null)
        {
            System.out.println("Given number is null");
            return null;
        }
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name AS Capital " +
                    "FROM country " +
                    "LEFT JOIN city ON city.ID = country.Capital " +
                    "ORDER BY country.Population DESC " +
                    "LIMIT " + n;

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country(rset.getString("Code"), rset.getString("Name"), rset.getString("Continent"), rset.getString("Region"), rset.getInt("Population"), rset.getString("Capital"));
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
    public ArrayList<Country> getTopCountriesByContinent(String continent, Integer n) {
        if(continent == null)
        {
            System.out.println("Continent is null");
            return null;
        }

        if(n == null)
        {
            System.out.println("Given number is null");
            return null;
        }

        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name AS Capital " +
                    "FROM country " +
                    "LEFT JOIN city ON city.ID = country.Capital " +
                    "WHERE country.Continent = '" + continent + "' " +
                    "ORDER BY country.Population DESC " +
                    "LIMIT " + n;

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country(rset.getString("Code"), rset.getString("Name"), rset.getString("Continent"), rset.getString("Region"), rset.getInt("Population"), rset.getString("Capital"));
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
    public ArrayList<Country> getTopCountriesByRegion(String region, Integer n) {
        if(region == null)
        {
            System.out.println("Region is null");
            return null;
        }
        if(n == null)
        {
            System.out.println("Given number is null");
            return null;
        }

        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name AS Capital " +
                    "FROM country " +
                    "LEFT JOIN city ON city.ID = country.Capital " +
                    "WHERE country.Region = '" + region + "' " +
                    "ORDER BY country.Population DESC " +
                    "LIMIT " + n;

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next()) {
                Country country = new Country(rset.getString("Code"), rset.getString("Name"), rset.getString("Continent"), rset.getString("Region"), rset.getInt("Population"), rset.getString("Capital"));
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
                    country.getCode(), country.getName(), country.getContinent(), country.getRegion(), country.getPopulation(), country.getCapital());
            System.out.println(country_string);
        }
    }


    /**
     * writes mark down info to a file in the reports branch.
     * @param filename the name of the file to create, for exmple "AllCountries.md".
     * @param content the mark down content to write.
     */
    private void writeMarkdown(String filename, String content) {
        try {
            new File("./reports/").mkdir();
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("./reports/" + filename)));
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * outputs a list of countries to a mark down file in the reports branch.
     * @param countries the list of countries that will be  output
     * @param filename the name of the file that will be created
     */
    public void outputCountries(ArrayList<Country> countries, String filename) {
        //check countries is not null or empty
        if (countries == null || countries.isEmpty()) {
            System.out.println("No countries in list.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        //print header
        sb.append("| Code | Name | Continent | Region | Population | Capital |\r\n");
        sb.append("| --- | --- | --- | --- | --- | --- |\r\n");

        //loop over all countries in the list
        for (Country country : countries) {
            if (country == null)
                continue;
            sb.append("| " + country.getCode() + " | " + country.getName() + " | " +
                    country.getContinent() + " | " + country.getRegion() + " | " +
                    country.getPopulation() + " | " + country.getCapital() + " |\r\n");
        }
        writeMarkdown(filename, sb.toString());
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
                City city = new City(rset.getString("Name"), rset.getString("Country_Name"), rset.getString("District"), rset.getInt("Population"));
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
        if(continent == null)
        {
            System.out.println("Continent is null");
            return null;
        }
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
                City city = new City(rset.getString("Name"), rset.getString("Country_Name"), rset.getString("District"), rset.getInt("Population"));
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
        if(region == null)
        {
            System.out.println("Region is null");
            return null;
        }
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
                City city = new City(rset.getString("Name"), rset.getString("Country_Name"), rset.getString("District"), rset.getInt("Population"));
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
        if(country == null)
        {
            System.out.println("Country is null");
            return null;
        }
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
                City city = new City(rset.getString("Name"), rset.getString("Country_Name"), rset.getString("District"), rset.getInt("Population"));
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
     * Retrieves details for all cities in a district and stores them in an ArrayList.
     * @param district - the continent to filter by
     * @return cities
     */
    public ArrayList<City> getCitiesByDistrict(String district) {
        if(district == null)
        {
            System.out.println("District is null");
            return null;
        }
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
                City city = new City(rset.getString("Name"), rset.getString("Country_Name"), rset.getString("District"), rset.getInt("Population"));
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
     * @param n - The number to get
     * @return cities
     */
    public ArrayList<City> getTopCities(Integer n) {
        if(n == null)
        {
            System.out.println("Given number is null");
            return null;
        }
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT city.Name, country.Name AS Country_name, city.District, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.code " +
                    "ORDER BY city.Population DESC " +
                    "LIMIT " + n + ";";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City(rset.getString("Name"), rset.getString("Country_Name"), rset.getString("District"), rset.getInt("Population"));
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
     * Retrieves details for the top cities in a continent and stores them in an ArrayList.
     * @param n - The number to display
     * @param continent - the continent to filter by
     * @return cities
     */
    public ArrayList<City> getTopCitiesByContinent(String continent, Integer n) {
        if(continent == null)
        {
            System.out.println("Continent is null");
            return null;
        }
        if(n == null)
        {
            System.out.println("Given number is null");
            return null;
        }
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT city.Name, country.Name AS Country_name, city.District, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.code " +
                    "WHERE country.Continent = '" + continent + "' " +
                    "ORDER BY city.Population DESC " +
                    "LIMIT " + n + ";";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City(rset.getString("Name"), rset.getString("Country_Name"), rset.getString("District"), rset.getInt("Population"));
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
     * @param n - the number to display
     * @param region - the continent to filter by
     * @return cities
     */
    public ArrayList<City> getTopCitiesByRegion(String region, Integer n) {
        if(region == null)
        {
            System.out.println("Region is null");
            return null;
        }
        if(n == null)
        {
            System.out.println("Given number is null");
            return null;
        }
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT city.Name, country.Name AS Country_name, city.District, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.code " +
                    "WHERE country.Region = '" + region + "' " +
                    "ORDER BY city.Population DESC " +
                    "LIMIT " + n + ";";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City(rset.getString("Name"), rset.getString("Country_Name"), rset.getString("District"), rset.getInt("Population"));
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
     * Retrieves details for the top cities in a country and stores them in an ArrayList.
     * @param n - the number to display
     * @param country - the continent to filter by
     * @return cities
     */
    public ArrayList<City> getTopCitiesByCountry(String country, Integer n) {
        if(country == null)
        {
            System.out.println("Country is null");
            return null;
        }
        if(n == null)
        {
            System.out.println("Given number is null");
            return null;
        }
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT city.Name, country.Name AS Country_name, city.District, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.code " +
                    "WHERE country.Name = '" + country + "' " +
                    "ORDER BY city.Population DESC " +
                    "LIMIT " + n + ";";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City(rset.getString("Name"), rset.getString("Country_Name"), rset.getString("District"), rset.getInt("Population"));
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
     * Retrieves details for the top cities in a district and stores them in an ArrayList.
     * @param n - the number to display
     * @param district - the continent to filter by
     * @return cities
     */
    public ArrayList<City> getTopCitiesByDistrict(String district, Integer n) {
        if(district == null)
        {
            System.out.println("District is null");
            return null;
        }
        if(n == null)
        {
            System.out.println("Given number is null");
            return null;
        }
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT city.Name, country.Name AS Country_name, city.District, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.CountryCode = country.code " +
                    "WHERE city.District = '" + district + "' " +
                    "ORDER BY city.Population DESC " +
                    "LIMIT " + n + ";";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City(rset.getString("Name"), rset.getString("Country_Name"), rset.getString("District"), rset.getInt("Population"));
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
                    city.getName(), city.getCountry_name(), city.getDistrict(), city.getPopulation());
            System.out.println(country_string);
        }
    }


    /**
     * outputs a list of cities to a mark down file in the reports branch
     * @param cities the list of cities to output
     * @param filename the name of the file to create, e.g: "AllCities.md"
     */
    public void outputCities(ArrayList<City> cities, String filename) {
        //check cities is not null or empty
        if (cities == null || cities.isEmpty()) {
            System.out.println("No cities in list.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        //print header
        sb.append("| Name | Country | District | Population |\r\n");
        sb.append("| --- | --- | --- | --- |\r\n");

        //loop over all cities in the list
        for (City city : cities) {
            if (city == null)
                continue;
            sb.append("| " + city.getName() + " | " + city.getCountry_name() + " | " +
                    city.getDistrict() + " | " + city.getPopulation() + " |\r\n");
        }
        writeMarkdown(filename, sb.toString());
    }

    /**
     * Retrieves details for all capital cities in the world and stores them in an ArrayList.
     * @return cities
     */
    public ArrayList<City> getAllCapitalCities() {
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT city.Name, country.Name AS Country_name, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.ID = country.Capital " +
                    "ORDER BY city.Population DESC;";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City(rset.getString("Name"), rset.getString("Country_Name"), rset.getInt("Population"));
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
     * Retrieves details for all capital cities in a continent and stores them in an ArrayList.
     * @param continent - the continent to filter by
     * @return cities
     */
    public ArrayList<City> getCapCitiesByContinent(String continent) {
        if(continent == null)
        {
            System.out.println("Continent is null");
            return null;
        }
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT city.Name, country.Name AS Country_name, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.ID = country.Capital " +
                    "WHERE country.Continent = '" + continent + "' " +
                    "ORDER BY city.Population DESC;";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City(rset.getString("Name"), rset.getString("Country_Name"), rset.getInt("Population"));
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
     * Retrieves details for all capital cities in a region and stores them in an ArrayList.
     * @param region - the continent to filter by
     * @return cities
     */
    public ArrayList<City> getCapCitiesByRegion(String region) {
        if(region == null)
        {
            System.out.println("Region is null");
            return null;
        }
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT city.Name, country.Name AS Country_name, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.ID = country.Capital " +
                    "WHERE country.Region = '" + region + "' " +
                    "ORDER BY city.Population DESC;";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City(rset.getString("Name"), rset.getString("Country_Name"), rset.getInt("Population"));
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
     * Retrieves details for the top capital cities in the world and stores them in an ArrayList.
     * @param n - The number to get
     * @return cities
     */
    public ArrayList<City> getTopCapCities(Integer n) {
        if(n == null)
        {
            System.out.println("Given number is null");
            return null;
        }
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT city.Name, country.Name AS Country_name, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.ID = country.capital " +
                    "ORDER BY city.Population DESC " +
                    "LIMIT " + n + ";";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City(rset.getString("Name"), rset.getString("Country_Name"), rset.getInt("Population"));
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
     * Retrieves details for the top capital cities in a continent and stores them in an ArrayList.
     * @param n - The number to display
     * @param continent - the continent to filter by
     * @return cities
     */
    public ArrayList<City> getTopCapCitiesByContinent(String continent, Integer n) {
        if(continent == null)
        {
            System.out.println("District is null");
            return null;
        }
        if(n == null)
        {
            System.out.println("Given number is null");
            return null;
        }
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT city.Name, country.Name AS Country_name, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.ID = country.Capital " +
                    "WHERE country.Continent = '" + continent + "' " +
                    "ORDER BY city.Population DESC " +
                    "LIMIT " + n + ";";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City(rset.getString("Name"), rset.getString("Country_Name"), rset.getInt("Population"));
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
     * @param n - the number to display
     * @param region - the continent to filter by
     * @return cities
     */
    public ArrayList<City> getTopCapCitiesByRegion(String region, Integer n) {
        if(region == null)
        {
            System.out.println("Region is null");
            return null;
        }
        if(n == null)
        {
            System.out.println("Given number is null");
            return null;
        }
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT city.Name, country.Name AS Country_name, city.Population " +
                    "FROM city " +
                    "JOIN country ON city.ID = country.Capital " +
                    "WHERE country.Region = '" + region + "' " +
                    "ORDER BY city.Population DESC " +
                    "LIMIT " + n + ";";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City(rset.getString("Name"), rset.getString("Country_Name"), rset.getInt("Population"));
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
     * Prints a list of capital cities.
     * @param cCities The list of capital cities to print.
     */
    public void printCapCities(ArrayList<City> cCities) {
        // Check cCities is not null.
        if (cCities == null) {
            System.out.println("No cities in list.");
            return;
        }
        else if(cCities.isEmpty())
        {
            System.out.println("No cities in list.");
            return;
        }

        // Print header.
        System.out.println(String.format("%-40s %-40s %-20s", "Name", "Country", "Population"));

        // Loop over all countries in the list.
        for (City city : cCities) {
            if (city == null)
                continue;

            String country_string = String.format("%-40s %-40s %-20s",
                    city.getName(), city.getCountry_name(), city.getPopulation());
            System.out.println(country_string);
        }
    }



    /**
     * outputs a list of capital cities to a MARKk down files in the reports branch
     * @param cCities The list of capital cities to output
     * @param filename The name of the file to create, e.g: "AllCapitalCities.md"
     */
    public void outputCapCities(ArrayList<City> cCities, String filename) {
        //check cCities is not null or empty
        if (cCities == null || cCities.isEmpty()) {
            System.out.println("No cities in list.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        //print the header
        sb.append("| Name | Country | Population |\r\n");
        sb.append("| --- | --- | --- |\r\n");

        //loop over all capital cities in list
        for (City city : cCities) {
            if (city == null)
                continue;
            sb.append("| " + city.getName() + " | " + city.getCountry_name() + " | " +
                    city.getPopulation() + " |\r\n");
        }
        writeMarkdown(filename, sb.toString());
    }

    /**
     * Retrieves Population of the entire world.
     * @return population
     */
    public Population getWorldPopulation() {
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT SUM(Population) AS TotalPop FROM country;";

            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next()) {
                Population population = new Population("World", rset.getLong("TotalPop"));
                return population;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details.");
            return null;
        }
    }

    /**
     * Retrieves Population of a continent.
     * @return population
     */
    public Population getContinentPopulation(String continent) {
        if(continent == null)
        {
            System.out.println("Continent is null");
            return null;
        }
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT Continent AS Area, SUM(Population) AS TotalPop FROM country " +
                    "WHERE Continent = '" + continent + "' ;";

            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next()) {
                Population population = new Population(rset.getString("Area"), rset.getLong("TotalPop"));
                return population;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details.");
            return null;
        }
    }

    /**
     * Retrieves Population of a region.
     * @return population
     */
    public Population getRegionPopulation(String region) {
        if(region == null)
        {
            System.out.println("region is null");
            return null;
        }
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT Region AS Area, SUM(Population) AS TotalPop FROM country " +
                    "WHERE Region = '" + region + "' ;";

            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next()) {
                Population population = new Population(rset.getString("Area"), rset.getLong("TotalPop"));
                return population;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details.");
            return null;
        }
    }

    /**
     * Retrieves Population of a country.
     * @return population
     */
    public Population getCountryPopulation(String country) {
        if(country == null)
        {
            System.out.println("country is null");
            return null;
        }
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT Name AS Area, Population FROM country " +
                    "WHERE Name = '" + country + "' ;";

            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next()) {
                Population population = new Population(rset.getString("Area"), rset.getLong("Population"));
                return population;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details.");
            return null;
        }
    }

    /**
     * Retrieves Population of a district.
     * @return population
     */
    public Population getDistrictPopulation(String district) {
        if(district == null)
        {
            System.out.println("district is null");
            return null;
        }
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT District AS Area, SUM(Population) AS TotalPop FROM city " +
                    "WHERE District = '" + district + "' ;";

            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next()) {
                Population population = new Population(rset.getString("Area"), rset.getLong("TotalPop"));
                return population;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details.");
            return null;
        }
    }

    /**
     * Retrieves Population of a city.
     * @return population
     */
    public Population getCityPopulation(String city) {
        if(city == null)
        {
            System.out.println("city is null");
            return null;
        }
        try {
            Statement stmt = con.createStatement();

            String strSelect = "SELECT Name, Population FROM city " +
                    "WHERE Name = '" + city + "' ;";

            ResultSet rset = stmt.executeQuery(strSelect);
            if (rset.next()) {
                Population population = new Population(rset.getString("Name"), rset.getLong("Population"));
                return population;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details.");
            return null;
        }
    }

    /**
     * Prints an area and it's population.
     * @param population -
     */
    public void printPopulationReport(Population population) {
        // Check population is not null.
        if (population == null) {
            System.out.println("No areas in list");
            return;
        }

        // Print header.
        System.out.println(String.format("%-40s %-40s", "Area", "Population"));

            String population_string = String.format("%-40s %-40s",
                    population.getArea_name(), population.getPopulation());
            System.out.println(population_string);
    }


    /**
     * outputs an area and its population to a mark down file in the reports branch
     * @param population the population to output
     * @param filename the name of the file to create, e.g: "WorldPopulation.md"
     */
    public void outputPopulationReport(Population population, String filename) {
        //check population is not null
        if (population == null) {
            System.out.println("No areas in list");
            return;
        }

        StringBuilder sb = new StringBuilder();
        //print header
        sb.append("| Area | Population |\r\n");
        sb.append("| --- | --- |\r\n");
        sb.append("| " + population.getArea_name() + " | " + population.getPopulation() + " |\r\n");
        writeMarkdown(filename, sb.toString());
    }

    /**
     * Retrieves details for languages and the number of speakers and stores them in an arraylist.
     * @return populations
     */
    public ArrayList<Population> getLanguagePopulation() {
        try {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT cl.Language, " +
                            "SUM((c.Population * cl.Percentage) / 100) AS TotalSpeakers, " +
                            "(SUM((c.Population * cl.Percentage) / 100) / " +
                            "(SELECT SUM(Population) FROM country)) * 100 AS WorldPercentage " +
                            "FROM countrylanguage cl " +
                            "JOIN country c ON c.Code = cl.CountryCode " +
                            "WHERE cl.Language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic') " +
                            "GROUP BY cl.Language " +
                            "ORDER BY TotalSpeakers DESC;";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Population> populations = new ArrayList<>();
            while (rset.next()) {
                Population population = new Population(rset.getString("Language"), rset.getLong("TotalSpeakers"), rset.getFloat("WorldPercentage"));
                populations.add(population);
            }
            return populations;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get language details.");
            return null;
        }
    }

    /**
     * Prints a list of language populations.
     * @param populations The list languages to print.
     */
    public void printLanguagePopulations(ArrayList<Population> populations) {
        // Check populations is not null.
        if (populations == null) {
            System.out.println("No populations in list.");
            return;
        }
        else if(populations.isEmpty())
        {
            System.out.println("No populations in list.");
            return;
        }

        // Print header.
        System.out.println(String.format("%-40s %-40s %-20s", "Language", "Population", "Percent of World"));

        // Loop over all countries in the list.
        for (Population population : populations) {
            if (population == null)
                continue;

            String population_string = String.format("%-40s %-40s %-20s",
                    population.getLanguage(), population.getPopulation(), population.getLanguage_per());
            System.out.println(population_string);
        }
    }


    /**
     * outputs a list of language populations to a Markdown file in the reports branch
     * @param populations The list of languages to output
     * @param filename The name of the file to create, e.g: "LanguagePopulations.md"
     */
    public void outputLanguagePopulations(ArrayList<Population> populations, String filename) {
        //check populations is not null or empty
        if (populations == null || populations.isEmpty()) {
            System.out.println("No populations in list.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        //print header
        sb.append("| Language | Population | Percent of World |\r\n");
        sb.append("| --- | --- | --- |\r\n");

        //loop over all languages in the list
        for (Population population : populations) {
            if (population == null)
                continue;
            sb.append("| " + population.getLanguage() + " | " + population.getPopulation() + " | " +
                    population.getLanguage_per() + " |\r\n");
        }
        writeMarkdown(filename, sb.toString());
    }

    /**
     * Retrieves details for the population of people in cities and outside cities in each continent.
     * @return populations
     */
    public ArrayList<Population> getContinentCitiesPopulation() {
        try {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT c.Continent, " +
                            "SUM(c.Population) AS TotalPop, " +
                            "(SELECT SUM(ci.Population) " +
                            "FROM city ci " +
                            "JOIN country c2 ON ci.CountryCode = c2.Code " +
                            "WHERE c2.Continent = c.Continent) AS CityPop " +
                            "FROM country c " +
                            "GROUP BY c.Continent " +
                            "ORDER BY TotalPop DESC;";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Population> populations = new ArrayList<>();
            while (rset.next()) {
                String cont = rset.getString("Continent");
                long total = rset.getLong("TotalPop");
                long city = rset.getLong("CityPop");
                long nonCity = total - city;
                float city_per = 0;
                float nonCity_per = 0;
                if (total>0) {
                    float city1 = city;
                    float nonCity1 = nonCity;
                    city_per = (city1 / total) * 100;
                    nonCity_per = (nonCity1 / total) * 100;
                }
                Population population = new Population(cont, total, city, city_per, nonCity, nonCity_per);
                populations.add(population);
            }
            return populations;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details.");
            return null;
        }
    }

    /**
     * Retrieves details for the population of people in cities and outside cities in each region.
     * @return populations
     */
    public ArrayList<Population> getRegionCitiesPopulation() {
        try {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT c.Region, " +
                            "SUM(c.Population) AS TotalPop, " +
                            "(SELECT SUM(ci.Population) " +
                            "FROM city ci " +
                            "JOIN country c2 ON ci.CountryCode = c2.Code " +
                            "WHERE c2.Region = c.Region) AS CityPop " +
                            "FROM country c " +
                            "GROUP BY c.Region " +
                            "ORDER BY TotalPop DESC;";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Population> populations = new ArrayList<>();
            while (rset.next()) {
                String reg = rset.getString("Region");
                long total = rset.getLong("TotalPop");
                long city = rset.getLong("CityPop");
                long nonCity = total - city;
                float city_per = 0;
                float nonCity_per = 0;
                if (total>0) {
                    float city1 = city;
                    float nonCity1 = nonCity;
                    city_per = (city1 / total) * 100;
                    nonCity_per = (nonCity1 / total) * 100;
                }
                Population population = new Population(reg, total, city, city_per, nonCity, nonCity_per);
                populations.add(population);
            }
            return populations;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details.");
            return null;
        }
    }

    /**
     * Retrieves details for the population of people in cities and outside cities in each country.
     * @return populations
     */
    public ArrayList<Population> getCountryCitiesPopulation() {
        try {
            Statement stmt = con.createStatement();

            String strSelect =
                    "SELECT c.Name AS Country, " +
                            "c.Population AS TotalPop, " +
                            "(SELECT SUM(ci.Population) " +
                            "FROM city ci " +
                            "WHERE ci.CountryCode = c.Code) AS CityPop " +
                            "FROM country c " +
                            "ORDER BY c.Population DESC";

            ResultSet rset = stmt.executeQuery(strSelect);

            ArrayList<Population> populations = new ArrayList<>();
            while (rset.next()) {
                String coun = rset.getString("Country");
                long total = rset.getLong("TotalPop");
                long city = rset.getLong("CityPop");
                long nonCity = total - city;
                float city_per = 0;
                float nonCity_per = 0;
                if (total>0) {
                    float city1 = city;
                    float nonCity1 = nonCity;
                    city_per = (city1 / total) * 100;
                    nonCity_per = (nonCity1 / total) * 100;
                }
                Population population = new Population(coun, total, city, city_per, nonCity, nonCity_per);
                populations.add(population);
            }
            return populations;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details.");
            return null;
        }
    }

    /**
     * Prints a list of Populations of people in cities and not in cities in areas.
     * @param populations The list of populations to print.
     */
    public void printCitiesPopulations(ArrayList<Population> populations) {
        // Check populations is not null.
        if (populations == null) {
            System.out.println("No populations in list.");
            return;
        }
        else if(populations.isEmpty())
        {
            System.out.println("No populations in list.");
            return;
        }

        // Print header.
        System.out.println(String.format("%-40s %-20s %-20s %-20s %-20s %-20s", "Area", "Population", "In Cities", "% In Cities", "Not In Cities", "% Not In Cities"));

        // Loop over all populations in the list.
        for (Population population : populations) {
            if (population == null)
                continue;

            String population_string = String.format("%-40s %-20s %-20s %-20s %-20s %-20s",
                    population.getArea_name(), population.getPopulation(), population.getPop_In_Cities(), population.getPop_In_Cities_Per(), population.getPop_Outside_Cities(), population.getPop_Outside_Cities_Per());
            System.out.println(population_string);
        }
    }

    /**
     * outputs a list of populations in and out of cities to a Mark down file in the reports
     * @param populations the list of populations to output
     * @param filename the name of the file to create, e.g   "ContinentPopulationInCities.md"
     */
    public void outputCitiesPopulations(ArrayList<Population> populations, String filename) {
        //check populations is not null or empty
        if (populations == null || populations.isEmpty()) {
            System.out.println("No populations in list.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        //print header
        sb.append("| Area | Population | In Cities | % In Cities | Not In Cities | % Not In Cities |\r\n");
        sb.append("| --- | --- | --- | --- | --- | --- |\r\n");

        //loop over all populations in the list
        for (Population population : populations) {
            if (population == null)
                continue;
            sb.append("| " + population.getArea_name() + " | " + population.getPopulation() + " | " +
                    population.getPop_In_Cities() + " | " + population.getPop_In_Cities_Per() + " | " +
                    population.getPop_Outside_Cities() + " | " + population.getPop_Outside_Cities_Per() + " |\r\n");
        }
        writeMarkdown(filename, sb.toString());
    }



}