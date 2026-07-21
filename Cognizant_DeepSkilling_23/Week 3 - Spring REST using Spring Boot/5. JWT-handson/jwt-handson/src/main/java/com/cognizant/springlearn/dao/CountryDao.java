package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.model.Country;

@Repository
public class CountryDao {

    public List<Country> getAllCountries() {

        List<Country> countryList = new ArrayList<>();

        countryList.add(new Country("US", "United States"));
        countryList.add(new Country("DE", "Germany"));
        countryList.add(new Country("IN", "India"));
        countryList.add(new Country("JP", "Japan"));

        return countryList;
    }
}