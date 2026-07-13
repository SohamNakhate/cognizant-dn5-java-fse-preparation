package com.cognizent.springLearn.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizent.springLearn.Country;

@RestController
public class CountryController {

    @RequestMapping("/country")
    public Country getCountryIndia() {

        ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

        Country country = context.getBean("in", Country.class);

        return country;
    }

}