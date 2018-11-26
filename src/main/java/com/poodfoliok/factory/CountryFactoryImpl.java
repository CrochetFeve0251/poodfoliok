package com.poodfoliok.factory;

import com.poodfoliok.model.Country;
import com.poodfoliok.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by eisti on 26/11/18.
 */
@Service
public class CountryFactoryImpl extends EntityFactoryImpl implements CountryFactory {
    @Autowired
    protected CountryRepository countryRepository;

    @Override
    public void create(int instances) {
        for (int i = 0; i < instances; i ++){
            Country country = new Country();
            country.setCode(faker.address().countryCode());
            country.setName(faker.address().country());
            countryRepository.save(country);
        }
    }
}
