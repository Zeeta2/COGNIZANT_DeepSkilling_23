package com.cognizant.spring_learn.dao;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.spring_learn.model.Country;

@Repository
public class CountryDao {

    @SuppressWarnings("unchecked")
    public ArrayList<Country> getAllCountries() {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        return (ArrayList<Country>) context.getBean("countryList");
    }
}