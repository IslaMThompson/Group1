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
}