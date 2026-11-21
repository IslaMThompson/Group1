package com.napier.sem;

/**
 * A class to hold the city information
 */
public class City {
    private String name;
    private String country_name;
    private String district;
    private int population;

    /**
     * A constructor to hold cities
     * @param name -
     * @param country_name -
     * @param district -
     * @param population -
     */
    public City(String name, String country_name, String district, int population) {
        this.name = name;
        this.country_name = country_name;
        this.district = district;
        this.population = population;
    }

    /**
     * A constructor to hold capital cities
     * @param name -
     * @param country_name -
     * @param population -
     */
    public City(String name, String country_name, int population) {
        this.name = name;
        this.country_name = country_name;
        this.population = population;
    }

    /**
     * Getters and setters
     */
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCountry_name() {
        return country_name;
    }
    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getDistrict() {
        return district;
    }
    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * To string method
     * @return A string
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
