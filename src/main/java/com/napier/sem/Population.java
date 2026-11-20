package com.napier.sem;

public class Population {
    private String area_name;
    private long population;
    private long pop_In_Cities;
    private float pop_In_Cities_Per;
    private long pop_Outside_Cities;
    private float pop_Outside_Cities_Per;
    private String language;
    private float language_per;

    public Population(String area_name, long population, long pop_In_Cities, float pop_In_Cities_Per, long pop_Outside_Cities, float pop_Outside_Cities_Per) {
        this.area_name = area_name;
        this.population = population;
        this.pop_In_Cities = pop_In_Cities;
        this.pop_In_Cities_Per = pop_In_Cities_Per;
        this.pop_Outside_Cities = pop_Outside_Cities;
        this.pop_Outside_Cities_Per = pop_Outside_Cities_Per;
    }

    public Population(String area_name, long population) {
        this.area_name = area_name;
        this.population = population;
    }

    public Population(String language, long population, float language_per) {
        this.language = language;
        this.population = population;
        this.language_per = language_per;
    }

    public String getArea_name() {
        return area_name;
    }
    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public long getPopulation() {
        return population;
    }
    public void setPopulation(long population) {
        this.population = population;
    }

    public long getPop_In_Cities() {
        return pop_In_Cities;
    }
    public void setPop_In_Cities(int pop_In_Cities) {
        this.pop_In_Cities = pop_In_Cities;
    }

    public double getPop_In_Cities_Per() {
        return pop_In_Cities_Per;
    }
    public void setPop_In_Cities_Per(float pop_In_Cities_Per) {
        this.pop_In_Cities_Per = pop_In_Cities_Per;
    }

    public long getPop_Outside_Cities() {
        return pop_Outside_Cities;
    }
    public void setPop_Outside_Cities(int pop_Outside_Cities) {
        this.pop_Outside_Cities = pop_Outside_Cities;
    }

    public double getPop_Outside_Cities_Per() {
        return pop_Outside_Cities_Per;
    }
    public void setPop_Outside_Cities_Per(float pop_Outside_Cities_Per) {
        this.pop_Outside_Cities_Per = pop_Outside_Cities_Per;
    }

    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    public double getLanguage_per() {
        return language_per;
    }
    public void setLanguage_per(float language_per) {
        this.language_per = language_per;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
