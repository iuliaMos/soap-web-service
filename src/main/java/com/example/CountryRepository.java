package com.example;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.Currency;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CountryRepository {

    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        Country spain = new Country();
        spain.setName("Spain");
        spain.setPopulation(46789034);
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        countries.put(spain.getName(), spain);

        Country poland = new Country();
        poland.setName("Poland");
        poland.setPopulation(38167890);
        poland.setCapital("Warsaw");
        poland.setCurrency(Currency.PLN);
        countries.put(poland.getName(), poland);

        Country uk = new Country();
        uk.setName("United Kingdom");
        uk.setPopulation(63750060);
        uk.setCapital("London");
        uk.setCurrency(Currency.GBP);
        countries.put(uk.getName(), uk);
    }

    public Country findByName(String name) {
        Assert.notNull(name, "name should not be null");
        return countries.get(name);
    }
}
