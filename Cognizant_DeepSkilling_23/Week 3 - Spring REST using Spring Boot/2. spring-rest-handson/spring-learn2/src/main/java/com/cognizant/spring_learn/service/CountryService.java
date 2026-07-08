package com.cognizant.spring_learn.service;

import java.util.ArrayList;
import com.cognizant.spring_learn.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.spring_learn.dao.CountryDao;
import com.cognizant.spring_learn.model.Country;

@Service
public class CountryService {

    @Autowired
    private CountryDao countryDao;

    public ArrayList<Country> getAllCountries() {
        return countryDao.getAllCountries();
    }

    public Country getCountry(String code) throws CountryNotFoundException {

        ArrayList<Country> countryList = countryDao.getAllCountries();

        for (Country country : countryList) {
            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        }

        throw new CountryNotFoundException();
    }
}