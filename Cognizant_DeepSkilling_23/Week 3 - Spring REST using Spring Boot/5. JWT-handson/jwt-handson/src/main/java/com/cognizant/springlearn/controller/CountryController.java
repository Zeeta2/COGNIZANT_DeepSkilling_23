package com.cognizant.springlearn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CountryController {


    @GetMapping("/countries")
    public String getCountries(){

        return "Country List";

    }

}