package com.poodfoliok.seeder;

import com.poodfoliok.factory.CountryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by eisti on 26/11/18.
 */
@Service
public class CountryTableSeederImpl implements CountryTableSeeder {
    @Autowired
    protected CountryFactory countryFactory;

    @Override
    public void seed() {
        countryFactory.create(200);
    }
}
